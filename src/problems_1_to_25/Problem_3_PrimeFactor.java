package problems_1_to_25;

public class Problem_3_PrimeFactor {
	// The prime factors of 13195 are 5, 7, 13 and 29.
	// What is the largest prime factor of the number 600851475143 ?

	public static int largestPrimeFactor(long number) {
		int largest = 0;
		int divider = 2;
		while (number > 1) {
			if (number % divider == 0) {
				largest = divider;
				number = number / divider;
			}
			if (divider < number) {
				divider++;
			} else {
				break;
			}
		}
		return largest;
	}

	public static void main(String[] args) {
		int number = largestPrimeFactor(600851475143l);
		System.out.println("Answer: " + 6857 + "\nResult: " + number);

	}

}
