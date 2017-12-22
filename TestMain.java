package com.codility.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* Integer V lies strictly between integers U and W if U < V < W or if U > V > W 

A non empty zero indexed array A consisting of N integers is given. 
A pair of indices (P, Q), where 0 <= P < Q < N, is said to have 'adjacent values' 
if no value in the array lies strictly between values A[P] and A[Q], 
and in addition A[P] != A[Q] 

For example, in array A such that: 
A[0] = 0 
A[1] = 3 
A[2] = 3 
A[3] = 7 
A[4] = 5 
A[5] = 3 
A[6] = 11 
A[7] = 1 

the following pairs of indices have adjacent values: 
 (0,7), (1,4), (1,7) 
 (2,4), (2,7), (3,4) 
 (3,6), (4,5), (5,7) 

For example, indices 4 and 5 have adjacent values because the values a[4] = 5 and A[5] = 3 are different 
and there is no value in array A that lies strictly between them 
the only such value could be the number 4, which is not present in the array 

Given two indices P and Q, their distance is defined as abs(P-Q) 
where abs(X) = X for X>=0 
and abs(X) = -X for X<=0 
For example the distance between indices 4 and 5 is 1 because abs(4-5) = abs(5-4) = 1 

Write a function that given a non-empty zero-indexed array A consisting of N integers 
returns the maximum distance between indices of this array that have adjacent values 
The function should return -1 if no adjacent indices exist 

For example given array A such that: 
A[0] = 1 
A[1] = 4 
A[2] = 7 
A[3] = 3 
A[4] = 3 
A[5] = 5 

the function should return 4 because: 
- indices 0 and 4 are adjacent because A[0] != A[4] 
  and the array does not contain any value that lies strictly between A[0] = 1 and A[4] = 3 
 - the distance between these indices is abd(0-4) = 4 
 - no other pair of adjacent indices that has a larger distance exists 

Assume that 
- N is an integer within the range [1 .. 40,000] 
- each element of array A is an integer within the range [-2,147,483,648 to 2,147,483,647] 

*/ 
public class TestMain {

	public static void main(final String[] args) {
		final int[] arr = { 1, 3, 2, 5, 6, -1, -5, 2, 3, 5, 2, 4, 1, 1, 1, 4, 1 };

		final int max = TestMain.solutions(arr);
		// [1, 3, 2, 5, 6, -1, -5, 2, 3, 5, 2, 4, 1, 1, 1, 4, 1]
		// [-5, -1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6]
	}

	private static int solutions(final int[] arr) {
		final List<Integer> all = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			all.add(arr[i]);
		}
		final List<Integer> sorted = new ArrayList<Integer>();
		sorted.addAll(all);

		// sort the list
		Collections.sort(sorted);
		System.out.println(all);
		System.out.println(sorted);

		if (arr.length == 1 || arr.length == 0) {
			return -1;
		}

		int max = 0;
		int difference = 0;
		for (int i = 0; i < arr.length; i++) {

			// length
			if (i + 1 >= arr.length) {
				break;
			}

			// if equal
			if (sorted.get(i) != sorted.get(i + 1)) {

				difference = Math.abs(all.indexOf(sorted.get(i))
						- all.lastIndexOf(sorted.get(i + 1)));

				System.out.println("(" + sorted.get(i) + ", "
						+ sorted.get(i + 1) + "), indeces:" + "("
						+ all.indexOf(sorted.get(i)) + ","
						+ all.lastIndexOf(sorted.get(i + 1)) + ")" + " diff: "
						+ difference);
				if (difference > max) {
					max = difference;
				}

				difference = Math.abs(all.lastIndexOf(sorted.get(i))
						- all.indexOf(sorted.get(i + 1)));
				System.out.println("(" + sorted.get(i) + ", "
						+ sorted.get(i + 1) + "), indeces:" + "("
						+ all.lastIndexOf(sorted.get(i)) + ","
						+ all.indexOf(sorted.get(i + 1)) + ")" + " diff: "
						+ difference);
				if (difference > max) {
					max = difference;
				}
			}
		}
		System.out.println("Max: " + max);
		return max;
	}

}
