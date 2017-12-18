/**
 * 
 */
package in.fullstack.codility;

/**
 * @author Prasad
 *
 */
public class AbsoluteSumOfSlice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final int[] testCase1 = new int[] { 2, -4, 6, -3, 9 };
		System.out.println("Minimum Slice=" + solution(testCase1));
		final int[] testCase2 = new int[] {  2, 3, 4, 5 };
		System.out.println("Minimum Slice=" + solution(testCase2));
	}

	public static int solution(int[] A) {
		int minSumOfSlice = 0;

		for (int i = 0; i < A.length; i++) {
			int temp = 0;
			for (int f = i; f < A.length; f++) {
				if (f == i) {
					temp = temp + A[f];
				} else {
					temp = Math.min(Math.abs(temp), Math.abs(temp + A[f]));
				}

			}
			if (i == 0) {
				minSumOfSlice = Math.abs(temp);
			}
			minSumOfSlice = Math.min(minSumOfSlice, Math.abs(temp));

		}
		return minSumOfSlice;

	}

}
