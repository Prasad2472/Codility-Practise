/**
 * 
 */
package in.fullstack.codility;

/**
 * @author Prasad
 *
 */
public class FindLengthOfIntList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IntList fourth = new IntList();
		fourth.value = 10;
		IntList third = new IntList();
		third.value = 10;
		third.next = fourth;
		IntList second = new IntList();
		second.value = 10;
		second.next = third;
		IntList first = new IntList();
		first.value = 10;
		first.next = second;

		System.out.println("Actual Size-->" + solution(first));

	}

	public static int solution(IntList L) {

		return findDepth(L);
	}

	public static int findDepth(IntList intList) {
		int result = 0;
		if (intList != null) {
			return ++result + findDepth(intList.next);
		}
		return result;
	}
}
