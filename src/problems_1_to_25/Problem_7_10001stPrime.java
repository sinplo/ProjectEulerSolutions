package problems_1_to_25;

public class Problem_7_10001stPrime {
	// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
	// see that the 6th prime is 13.
	//
	// What is the 10 001st prime number?
	// very slow for large numbers
	public static long primeNumberInPlace(int place) {
		long primeNumber = 0;
		long currentNumber = 2;
		// System.out.println(currentNumber);

		while (place >= 1) {
			for (long divider = currentNumber; divider >= 1; divider--) {
				// System.out.println(divider);
				if (currentNumber % divider == 0 && divider < currentNumber && divider > 1) {
					// System.out.println("in");
					currentNumber++;
					break;
				} else if (divider == 1) {
					if (place == 1) {
						primeNumber = currentNumber;
					} else {
						currentNumber++;
					}
					place--;
				}
			}

		}

		return primeNumber;
	}

	//still slow
	public static long primeNumberInPlace2(int place) {
		long primeNumber = 0;
		long currentNumber = 2;
		// System.out.println(currentNumber);

		for (long divider = currentNumber; divider >= 1 && place >= 1; divider--) {
			// System.out.println(divider);
			if (currentNumber % divider == 0 && divider < currentNumber && divider > 1) {
				// System.out.println("in");
				currentNumber++;
				divider = currentNumber;
			} else if (divider == 1) {
				if (place == 1) {
					primeNumber = currentNumber;
				} else {
					currentNumber++;
					divider = currentNumber;
				}
				place--;
			}
		}

		return primeNumber;
	}
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// primeNumberInPlace(6);
		System.out.println("Correct Answer: " + 104743);
		System.out.println(primeNumberInPlace2(10001));
//		System.out.println("Result: ");
//		System.out.println(primeNumberInPlace(10001));

	}

}
