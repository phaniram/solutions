package projecteuler;

import java.util.HashMap;

class prob12 {

	static int fin;
	static HashMap<Integer,Integer> fin_factors = new HashMap<Integer,Integer>();
	public static void main(String[] args) {
		int next=0;
		int num_div=0;
		while(num_div<=500)
		{
			num_div=logic(++next);
		}
		System.out.println(fin);
		System.out.println(fin_factors);
	}

	private static int logic(int i) {
		int triangle_num=0;
		triangle_num=(i*(i+1))/2;
		return fact(triangle_num);
	}

	private static int fact(int triangle_num) {
		int n = triangle_num; 
		int sum=1;
		HashMap<Integer,Integer> factors = new HashMap<Integer,Integer>();
		for (int i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				if(factors.containsKey(i))
				{
					int value=factors.get(i);
					factors.put(i,++value);
				}
				else
				{
					factors.put(i, 1);
				}
				n /= i;
			}
		}
		if (n > 1) {
			if(factors.containsKey(n))
			{
				int value=factors.get(n);
				factors.put(n,++value);
			}
			else
			{
				factors.put(n, 1);
			}
		}
		for(int val : factors.values())
		{
			sum*=(val+1);
		}
		fin=n;
		fin_factors=factors;
		return sum;
	}
	
	
}
