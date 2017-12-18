/**
 * 
 */
package in.fullstack.codility;

/**
 * @author Prasad
 *
 */
public class FindValidPasswordMaxLength {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		System.out.println("max Password Expected 2, Actual-->"
				+ solution("a0Ba"));
		System.out.println("max Password Expected -1, Actual-->"
				+ solution("aaaaa"));
		System.out.println("max Password Expected 9, Actual-->"
				+ solution("aaaaa3BadtHasgT"));
		System.out.println("max Password Expected 11, Actual-->"
				+ solution("6524lshdtgY0slyhretgegh"));
		System.out.println("max Password Expected 8, Actual-->"
				+ solution("Hello2WorldNew"));
		System.out.println("max Password Expected -1, Actual-->"
				+ solution("hello2worldnew"));

	}

	/**
	 * Problem Statement 12 Soultion
	 * 
	 * @param s
	 * @return
	 */
	public static int solution(final String s) {
		int result = -1;
		StringBuilder builder = new StringBuilder();
		Boolean isUpperCaseLetterFound = false;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				builder.append(s.charAt(i));
				isUpperCaseLetterFound = true;
			}
			if (Character.isLowerCase(s.charAt(i))) {
				builder.append(s.charAt(i));
			}
			if (Character.isDigit(s.charAt(i))) {
				builder = new StringBuilder();
			}
			if (isUpperCaseLetterFound && result < builder.length()) {
				result = builder.length();
			}
		}
		return result;
	}

}
