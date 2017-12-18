/**
 * 
 */
package in.fullstack.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author pboini
 *
 */
public class NooFoccuranceVal {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		final int[] testCase1 = new int[] { 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3,
				3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,
				4, 4, 4, 4, 4, 6 };
		System.out.println(solution(testCase1));
	}

	/**
	 * Problem Statement 4 solution.
	 * 
	 * @param array
	 * @return
	 */
	public static int solution(final int[] array) {
		Integer result = -1;
		final Integer arraySize = array.length / 2;
		Map<Integer, Integer> holdNumbers = new TreeMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (holdNumbers.containsKey(array[i])) {
				holdNumbers.put(array[i], holdNumbers.get(array[i]) + 1);
			} else {
				holdNumbers.put(array[i], 1);
			}
		}
		ArrayList<Integer> maximumNumbers = new ArrayList<Integer>(
				holdNumbers.values());
		/**
		 * holdNumbers No Longer Required.
		 */
		holdNumbers = null;
		Collections.sort(maximumNumbers, new Comparator<Integer>() {

			@Override
			public int compare(final Integer o1, final Integer o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println("maximumNumbers-->" + maximumNumbers);
		if (!maximumNumbers.isEmpty() && arraySize < maximumNumbers.get(0)) {
			result = maximumNumbers.get(0);
		}
		/**
		 * maximumNumbers No Longer Required.
		 */
		maximumNumbers = null;
		System.out.println("array-->" + array.length + " ;arraySize-->"
				+ arraySize + ",result-->" + result);
		return result;
	}
}
