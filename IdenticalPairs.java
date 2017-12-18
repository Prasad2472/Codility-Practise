package in.fullstack.codility;

/**
 * 
 * @author pboini
 *
 */
public class IdenticalPairs {

	public static void main(final String[] args) {
		/**
		 * integer range -2,147,483,648 to +2,147,483,647
		 */
		final int[] testCase1 = new int[] { 3, 5, 6, 3, 3, 5 };
		System.out.println(solution(testCase1));
		final int[] testCase2 = new int[] { 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(solution(testCase2));
		final int[] testCase3 = new int[] { 3, 5, 6, 3, 3, 5, 5 };
		System.out.println(solution(testCase3));
	}

	/**
	 * Problem Statement 17 solution.
	 * 
	 * @param array
	 * @return
	 */
	public static int solution(final int[] array) {
		int identicalPairs = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (i != j && array[i] == array[j]) {
					identicalPairs++;
				}
			}
		}
		if (1000000000 < identicalPairs) {
			identicalPairs = 1000000000;
		}
		return identicalPairs;
	}
}
