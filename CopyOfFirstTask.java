/**
 * 
 */
package com.codility.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author boini
 *
 */
public class CopyOfFirstTask {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		System.out.println("Output-->"
				+ solution(new int[] { 1, 4, 7, 3, 3, 5 }));
		System.out.println("testCase2 Output-->"
				+ solution(new int[] { 0, 3, 3, 7, 5, 3, 11, 1 }));

	}

	public static int solution(final int[] A) {
		final List<Integer> all = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			all.add(A[i]);
		}
		final List<Integer> sorted = new ArrayList<>(all);
		Collections.sort(sorted);
		int distance = 0;
		int max = 0;
		for (int i = 0; i < A.length - 2; i++) {

			if (all.get(i) != all.get(i + 1)) {

				distance = Math.abs(all.indexOf(sorted.get(i))
						- all.lastIndexOf(sorted.get(i + 1)));
				if (distance > max) {
					max = distance;
				}
				distance = Math.abs(all.lastIndexOf(sorted.get(i))
						- all.indexOf(sorted.get(i + 1)));
				if (distance > max) {
					max = distance;
				}
			}
		}
		return max;
	}
}
