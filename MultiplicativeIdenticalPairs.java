/**
 * 
 */
package in.fullstack.codility;

/**
 * @author pboini
 *
 */
public class MultiplicativeIdenticalPairs {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		final int[] a = new int[] { 0, 1, 2, 2, 3, 5 };
		final int[] b = new int[] { 500000, 500000, 0, 0, 0, 20000 };
		System.out.println(solution(a, b));
	}

	/**
	 * Problem statement 3 Solution
	 * 
	 * @param arrayA
	 * @param arrayB
	 * @return
	 */
	public static int solution(final int[] arrayA, final int[] arrayB) {
		int identicalMultiplicative = 0;
		final double[] temp = new double[arrayA.length];
		for (int i = 0; i < arrayA.length; i++) {
			temp[i] = arrayA[i] + ((double) arrayB[i] / 1000000);
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = i + 1; j < temp.length; j++) {
				if ((temp[i] * temp[j]) >= (temp[i] + temp[j])) {
					identicalMultiplicative++;
				}
			}
		}
		System.out
				.println("identicalMultiplicative=" + identicalMultiplicative);
		if (1000000000 < identicalMultiplicative) {
			identicalMultiplicative = 1000000000;
		}
		return identicalMultiplicative;
	}
}
