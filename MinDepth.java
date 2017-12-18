/**
 * 
 */
package in.fullstack.codility;

/**
 * @author pboini
 *
 */
public class MinDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final int[] a = new int[] { 0, 1, 3, -2, 0, 1, 0, -3, 2 };
		System.out.println("A-->" + solution(a));
	}

	public static int solution(int A[]) {
		int deepestVal = 0;
		int lastDecreaseval = 0;
		int lastIncreaseVal = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] > A[j]) {
					lastDecreaseval = A[j];
					lastIncreaseVal = A[j];
				} else if (lastIncreaseVal < A[j]) {
					lastIncreaseVal = A[j];
				}
			}
			System.out.println("lastDecreaseval=" + lastDecreaseval
					+ ",lastIncreaseVal=" + lastIncreaseVal + ",A[" + i + "]"
					+ "-->" + A[i] + ",deepestVal-->" + deepestVal);

			deepestVal = Math.max(
					deepestVal,
					Math.min(A[i] - lastDecreaseval, lastIncreaseVal
							- lastDecreaseval));
			// Reset values
			lastDecreaseval = 0;
			lastIncreaseVal = 0;
			// i = i + 1 + indexToMoveOn;
		}

		return deepestVal;
	}

}
