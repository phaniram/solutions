package com.cyp.codechef.febcontest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ForkJoinFactorialTest {

    private static final int INPUT = 203457;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        BigInteger fact1, fact2;
        {
            long start = System.nanoTime();
            fact2 = factMtExecutor(INPUT, 10);
            long end = System.nanoTime();
            System.out.println(TimeUnit.SECONDS.convert(end - start,
                    TimeUnit.NANOSECONDS) + " seconds for ThreadPoolExecutor");
        }
        {
            long start = System.nanoTime();
            fact1 = factFjPool(INPUT, 10);
            long end = System.nanoTime();
            System.out.println(TimeUnit.SECONDS.convert(end - start,
                    TimeUnit.NANOSECONDS) + " seconds for ForkJoin");
        }
        System.out.println(fact1.equals(fact2));
    }

    private static BigInteger factFjPool(int input, int numThreads)
            throws InterruptedException, ExecutionException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(numThreads);
        ForkJoinTask<BigInteger> future = forkJoinPool.submit(new FactorialRecursiveTask(1, input + 1));
        return future.get();
    }

    private static class FactorialRecursiveTask extends RecursiveTask<BigInteger> {
        private static final long serialVersionUID = 1L;

        private static final int THRESHOLD = 1000;

        private final int lo, hi;

        public FactorialRecursiveTask(int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        protected BigInteger compute() {
            if (hi - lo < THRESHOLD) {
                BigInteger result = BigInteger.valueOf(lo);
                for (int i = lo + 1; i < hi; i++) {
                    result = result.multiply(BigInteger.valueOf(i));
                }
                return result;
            } else {
                int mid = (lo + hi) >>> 1;

                FactorialRecursiveTask f1 = new FactorialRecursiveTask(lo, mid);
                f1.fork();
                FactorialRecursiveTask f2 = new FactorialRecursiveTask(mid, hi);
                return f2.compute().multiply(f1.join());
            }
        }
    }

    private static final int WORKERS = 100;

    private static BigInteger factMtExecutor(int input, int numThreads)
            throws InterruptedException, ExecutionException {

        FactCallable[] workers = new FactCallable[WORKERS];
        for (int i = 1; i <= WORKERS; i++) {
            int start = i == 1 ? 1 : (input / WORKERS * (i - 1)) + 1;
            int end = i == WORKERS ? input : input / WORKERS * i;
            workers[i - 1] = new FactCallable(start, end);
        }

        ThreadPoolExecutor executor = new ThreadPoolExecutor(numThreads, numThreads, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());

        List<Future<BigInteger>> futures = executor.invokeAll(Arrays.asList(workers));
        BigInteger result = BigInteger.valueOf(1L);
        for (Future<BigInteger> future : futures) {
            result = result.multiply(future.get());
        }

        return result;
    }

    private static class FactCallable implements Callable<BigInteger> {
        private final int from;
        private final int to;

        public FactCallable(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public BigInteger call() throws Exception {
            BigInteger result = BigInteger.valueOf(from);
            for (int i = from + 1; i <= to; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        }
    }

}
