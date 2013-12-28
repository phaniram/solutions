package projecteuler;

public class text {

	 long count=0;
	 long max=0;
	 long max_i=0;
	public static void main(String args[])
	{
		text prob=new text();
		int i=113383;
	//	int i=82;
			prob.logic(i);
			if(prob.count>prob.max)
			{
				prob.max=prob.count;
				prob.max_i=i;
			}
			System.out.println("for "+i+" - "+prob.count);
		
		System.out.println("for "+prob.max_i+"-"+prob.max);
	}

	private void logic(long i) {
		count=1;
		while(i!=1)
		{
			if(i%2==0)
			{
				i=i/2;
				System.out.print(">"+i);
				count++;
			}
			else
			{
				i=(3*i)+1;
				System.out.print(">"+i);
				count++;
			}
		}
		
	}
}
