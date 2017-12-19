/**
 * 
 */
package in.fullstack.codility;

/**
 * @author Prasad
 *
 */
public class SplitString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//
		 String given="(((((((((((((((((((()))";
//		String given = "(()))(()()())))";
		int split = solution(given);
		System.out.println("Split String-->" + split + "--"
				+ given.substring(0, split) + "<--" + given.substring(split));
	}

	public static int solution(String s) {
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				index++;
			}
		}
		return index;
	}

}
