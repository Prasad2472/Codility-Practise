/**
 * 
 */
package in.fullstack.codility;

/**
 * @author Prasad
 *
 */
public class BinaryGap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(solution(20));
	}

	public static int solution(int N) {
		// write your code in Java SE 8
		int result = 0;
		String binary = Integer.toBinaryString(N);
		int counter = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '0') {
				counter++;
			} else {
				result = Math.max(result, counter);
				counter = 0;
			}
		}
		return result;
	}

}
