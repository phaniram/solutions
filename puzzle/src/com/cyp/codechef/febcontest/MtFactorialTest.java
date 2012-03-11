package com.cyp.codechef.febcontest;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MtFactorialTest {

    private static final int INPUT = 203457;

   public static void main(String[] args) throws InterruptedException, ExecutionException {
        BigInteger fact1, fact2;
        {
            long start = System.nanoTime();
            fact1 = factMt(INPUT, 4);
            long end = System.nanoTime();
            System.out.println(TimeUnit.SECONDS.convert(end - start,
                    TimeUnit.NANOSECONDS) + " seconds for simple start/join");
        }
        {
            long start = System.nanoTime();
            fact2 = factMtExecutor(INPUT, 4);
            long end = System.nanoTime();
            System.out.println(TimeUnit.SECONDS.convert(end - start,
                    TimeUnit.NANOSECONDS) + " seconds for ThreadPoolExecutor");
        }

    }
    
    private static BigInteger factMt(int input, int numThreads)
            throws InterruptedException {
        BigInteger result = BigInteger.valueOf(1);
        Thread[] threads = new Thread[numThreads];
        FactComputer[] workers = new FactComputer[numThreads];
        for (int i = 1; i <= numThreads; i++) {
            int start = i == 1 ? 1 : (input / numThreads * (i - 1)) + 1;
            int end = i == numThreads ? input : input / numThreads * i;
            workers[i - 1] = new FactComputer(start, end);
            threads[i - 1] = new Thread(workers[i - 1]);
        }

        for (int i = 0; i < numThreads; i++) {
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }
        for (int i = 0; i < numThreads; i++) {
            result = result.multiply(workers[i].result);
        }
        return result;
    }

    private static BigInteger factMtExecutor(int input, int numThreads)
            throws InterruptedException, ExecutionException {
        FactCallable[] workers = new FactCallable[100];
        for (int i = 1; i <= 100; i++) {
            int start = i == 1 ? 1 : (input / 100 * (i - 1)) + 1;
            int end = i == 100 ? input : input / 100 * i;
            workers[i - 1] = new FactCallable(start, end);
        }

        ThreadPoolExecutor executor = new ThreadPoolExecutor(numThreads,
                numThreads, 0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());

        List<Future<BigInteger>> futures = executor.invokeAll(Arrays
                .asList(workers));
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

    private static class FactComputer implements Runnable {
        BigInteger result;
        private final int from;
        private final int to;

        public FactComputer(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            result = BigInteger.valueOf(from);
            for (int i = from + 1; i <= to; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }

        }
    }
}
