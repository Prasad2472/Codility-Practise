/**
 * 
 */
package in.fullstack.codility;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author pboini
 *
 */
public class FindMinIntergerMissedInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int[] b = new int[] { -1, -3 };
		final int[] a = new int[] { 1, 2, 2, 3, 5 };
		final int[] c = new int[] { 1, 2, 4, 3, 5 };
		final int[] d = new int[] { 2, 4, 3, 5 };
		final int[] e = new int[] { 1, 2, 3 };
		final int[] g = new int[] { 1, 3, 6, 4, 1, 2 };
		final int[] f = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
				14, 15, 16, 17, 18, 19, 20, 21, 22, 23 };
		final int[] h = new int[] { -2 - 1, 1, 3, 6, 4, 1, 2 };

		System.out.println("A-->Expected- 4  Actual-->" + solution(a));
		System.out.println("B-->Expected- 1  Actual-->" + solution(b));
		System.out.println("C-->Expected- 6  Actual-->" + solution(c));
		System.out.println("D-->Expected- 1  Actual-->" + solution(d));
		System.out.println("E-->Expected- 4  Actual-->" + solution(e));
		System.out.println("F->Expected- 24  Actual-->" + solution(f));
		System.out.println("G->Expected- 5  Actual-->" + solution(g));
		System.out.println("H->Expected- 5  Actual-->" + solution(h));
	}

	public static int solution(int[] A) {
		// write your code in Java SE 8

		Set<Integer> all = new TreeSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			all.add(A[i]);
		}
		int result = 1;
		while (all.contains(result)) {
			result++;
		}
		// int previous = 0;
		// int missedMinMunber = 0;
		// int counter = 0;
		// for (int i : all) {
		// // if (counter == 0 && 1 < i) {
		// // break;
		// // }
		// counter++;
		// if (++previous == i) {
		// continue;
		// } else {
		// missedMinMunber = previous;
		// break;
		// }
		// }
		// if (missedMinMunber == 0) {
		// missedMinMunber = ++previous;
		// }
		// if (0 < missedMinMunber) {
		// result = missedMinMunber;
		// }
		return result;
	}
}
