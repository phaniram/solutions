package codechef.febcontest;

import java.util.*;
import java.util.Map.Entry;

class FINDSEQ {

	String sequence;
	int N;
	int[] A;

	public FINDSEQ(int size, String seq, int[] num) {
		this.N = size;
		this.sequence = seq;
		A = num;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num_cases = sc.nextInt();
		while (--num_cases >= 0) {
			int size = sc.nextInt();
			String seq = sc.next();
			int[] num = new int[size];
			int i = 0;
			while (--size >= 0) {
				num[i++] = sc.nextInt();
			}
			FINDSEQ fs = new FINDSEQ(size, seq, num);
			fs.logic();
		}
		sc.close();
	}

	public  Integer getKeyByValue(java.util.Map<Integer, Integer> map, Integer value) {
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (value.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return -1;
	}

	private void logic() {
		ArrayList<Integer> unlist = new ArrayList<Integer>();
		SortedSet<Integer> sort = new TreeSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			sort.add(A[i]);
			unlist.add(A[i]);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(sort);
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			hm.put(A[i], list.indexOf(A[i]) + 1);
		}
		// System.out.println(hm);
		char[] arr = sequence.toCharArray();
		StringBuilder sb = new StringBuilder();
		int count = 0;
                int curr=0;
                int prev=0;
                boolean fin=false;
		for (char ch : arr) {
			int rank = Integer.parseInt(Character.toString(ch));
			int num = getKeyByValue(hm, rank);
			if (num != -1) {
                            curr=unlist.indexOf(num);
                            if(curr>=prev)
                            {
                                sb.append(unlist.indexOf(num)).append(" ");
				count++;
                            }
                            prev=curr;
			}
		}
		if (count == sequence.length()) {
			System.out.println(sb);
		} else {
			System.out.println("-1");
		}
	}
}
