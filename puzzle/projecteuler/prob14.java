package projecteuler;

public class prob14 {

	static long count=0;
	static long max=0;
	static long max_i=0;
	public static void main(String args[])
	{
		prob14 prob=new prob14();
		long start=System.currentTimeMillis();
		for(int i=1;i<=1000000;i++)
		{
			prob.logic(i);
			if(count>max)
			{
				max=count;
				max_i=i;
			}
		//	System.out.println("for "+i+" - "+count);
		}
		System.out.println(max_i+"-"+max);
		System.out.println((System.currentTimeMillis()-start));
	}

	private void logic(long i) {
		count=1;
		while(i!=1)
		{
			if(i%2==0)
			{
				i=i/2;
				count++;
			}
			else
			{
				i=3*i+1;
				count++;
			}
		}
		
	}
}
