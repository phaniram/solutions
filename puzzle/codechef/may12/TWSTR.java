package codechef.may12;

/** 
* @author Cypronmaya -Codechef- Accepted 
*/
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class TWSTR {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String Si = sc.next();
			int Vi = sc.nextInt();
			hm.put(Si, Vi);
		}
		int Q = sc.nextInt();

		for (int i = 0; i < Q; i++) {
			HashMap<String, Integer> res = new HashMap<String, Integer>();
			ValueComparator bvc = new ValueComparator(res);
			TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(
					bvc);

			String Qi = sc.next();
			int count = 0;
			for (String s : hm.keySet()) {
				if (s.startsWith(Qi)) {
					res.put(s, hm.get(s));
					count++;
				}
			}
			if (count != 0) {
				sorted_map.putAll(res);
				System.out.println(sorted_map.firstKey());
			} else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}

class ValueComparator implements Comparator {
	Map base;

	public ValueComparator(Map base) {
		this.base = base;
	}

	public int compare(Object a, Object b) {
		if ((Integer) base.get(a) < (Integer) base.get(b)) {
			return 1;
		} else if ((Integer) base.get(a) == (Integer) base.get(b)) {
			return 0;
		} else {
			return -1;
		}
	}
}