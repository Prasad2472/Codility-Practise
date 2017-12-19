/**
 * 
 */
package in.fullstack.codility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Prasad
 *
 */
public class OddOccurrencesInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 9, 3, 9, 3, 9, 7, 7 }));
	}

	public static int solution(int[] A) {
		// write your code in Java SE 8
		Set<Integer> unpaired = new HashSet<Integer>();
	    for (int i = 0; i<A.length; i++){
	        if (unpaired.contains(A[i])){
	            unpaired.remove(new Integer(A[i]));
	        }else{
	            unpaired.add(A[i]);
	        }
	    }
		return new ArrayList<Integer>(unpaired).get(0);
	}
}
