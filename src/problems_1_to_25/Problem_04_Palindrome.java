package problems_1_to_25;

public class Problem_04_Palindrome {
	// A palindromic number reads the same both ways. The largest palindrome
	// made from the product of two 2-digit numbers is 9009 = 91 × 99.
	//
	// Find the largest palindrome made from the product of two 3-digit numbers.

	public static int largestPalindromeOf3() {
		int palindrome = 0;

		for (int a = 999; a >= 100; a--) {
			for (int b = 999; b >= 100; b--) {
				int number = a * b;
				if (isPalindrome(number) && number > palindrome) {
					palindrome = number;
				}
			}
		}

		return palindrome;
	}

	public static boolean isPalindrome(int number) {
		boolean isPalindrome = false;
		String tempString = Integer.toString(number);
		int indexA = 0;
		int indexB = tempString.length() - 1;

		while (indexA < 3 && indexB > 2) {
			if (tempString.charAt(indexA) == tempString.charAt(indexB)) {
				isPalindrome = true;
				indexA++;
				indexB--;
			} else {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}

	public static void main(String[] args) {
		boolean palindrome = isPalindrome(100091);
		System.out.println(largestPalindromeOf3());
	}

}
