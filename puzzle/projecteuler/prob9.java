package projecteuler;

/*	
  A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,

	a2 + b2 = c2
	For example, 32 + 42 = 9 + 16 = 25 = 52.

	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	Find the product abc.
	
	*/
class prob9 {

	public static void main(String[] args) {
		
		for(int a=1;a<=998;a++)
		{
			for(int b=1;b<=998;b++)
			{
				for(int c=1;c<=998;c++)
				{
					if(a<b && b<c && a+b+c==1000 && a*a+b*b==c*c)
					{
						System.out.println(a*b*c);
					}
				}
			}
		}
	}

}
