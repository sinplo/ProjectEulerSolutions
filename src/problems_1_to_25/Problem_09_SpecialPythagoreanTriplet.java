package problems_1_to_25;

public class Problem_09_SpecialPythagoreanTriplet {
	// https://projecteuler.net/problem=9
	//
	// A Pythagorean triplet is a set of three natural numbers, a < b < c, for
	// which,
	//
	// a2(square) + b2(square) = c2(square)
	// For example, 3(2) + 4(2) = 9 + 16 = 25 = 52.
	//
	// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	// Find the product abc.

	// 
	public static long returnMultiplicationOfPythagoreanTriplet() {
		long multiplication = 0;
		int a = 3;
		int b = 4;
		int c = b + 1;
		boolean found = false;
		
		while (found == false) {
			int Asquare = a * a;
			int Bsquare = b * b;
			int sumOfSquares = Asquare + Bsquare;

			if (sumOfSquares < c * c) {
				if (b <= 1000 - a) {
					c = b + 1;
					b++;
				} else {
					a++;
					b = a + 1;
					c = b + 1;
				}
			} else {
				if (sumOfSquares == c * c && c + a + b == 1000) {
					multiplication = a * b * c;
					found = true;
				} else if (sumOfSquares > c * c) {
					c++;
				} else if (sumOfSquares == c * c) {
					//this is to move b further 
					b++;
					c = b + 1;
				}
			}
		}
		return multiplication;
	}

	public static void main(String[] args) {
		System.out.println("Correct Answer: " + 31875000);
		System.out.println(returnMultiplicationOfPythagoreanTriplet());

	}

}
