/**
 * 
 */
package com.codility.test;

/**
 * @author boini
 *
 */
public class Secondtask {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		System.err.println("ooutput-->" + solution(1000));
	}

	public static int solution(final int N) {
		// write your code in Java SE 8
		int counter = 0;
		for (Integer i = 1; i <= N; i++) {
			final String stringRePresentaion = i.toString();
			System.out.println(stringRePresentaion);
			for (int j = 0; j < stringRePresentaion.length(); j++) {
				if (stringRePresentaion.charAt(j) == '1') {
					counter++;
				}
			}
		}
		return counter;
	}

}
