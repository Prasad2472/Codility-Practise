/**
 * 
 */
package in.fullstack.codility;

/**
 * @author pboini
 *
 */
public class Test {

	public static void main(final String[] args) {

		final int[] a = new int[] { -5,6,8,-10,4,50,-55,84,75};
		final int[] b = new int[] { -8, 4, 0, 5, -3, 6 };
		final int[] c = new int[] { };

		System.out.println("Max-->A-->" + solution(a));
		System.out.println("Max-->B-->" + solution(b));
		System.out.println("Max-->-->" + solution(c));
	}

	public static int solution(final int[] A) {
		// write your code in Java SE 8
		int sumDistance = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				if (sumDistance < (A[i] + A[j] + (j - i))) {
					sumDistance = A[i] + A[j] + (j - i);
				}
			}
		}
		return sumDistance;
	}
}
