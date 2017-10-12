package problems_1_to_25;

import java.util.ArrayList;

public class Problem_7_10001stPrime {
	// https://projecteuler.net/problem=7
	//
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

	// still slow
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

	
	//bit slow but much faster than previous methods
	//basic idea is to put all the prime numbers in list and check every next number whether they can be divided with any of the prime numbers in list
	public static long primeInPlace2(int place){
		ArrayList<Long> primeList = new ArrayList<Long>();;
		long primeInPlace = 0;
		long currentNumber = 2;
		int listIndex = 0;
		while(place >=1){
			if(primeList.isEmpty()){
				primeList.add(currentNumber);
				currentNumber ++;
				place --;
			}else{
				long currentDivider = primeList.get(listIndex);
				if(currentNumber % currentDivider == 0){
					currentNumber++;
					listIndex = 0;
				}else{
					if(listIndex == primeList.size() -1){
						primeList.add(currentNumber);
						place--;
						listIndex = 0;
					}else{
						listIndex ++;
					}
				}
			}
		}
		primeInPlace = primeList.get(primeList.size()-1);
		return primeInPlace;
	}
	
	
	
	// these are just some notes for future (maybe different solution, haven't decided yet)
	// croos 1
	// circle 2
	// cross every 2nd
	// circle 3
	// cross every 3rd
	// circle 5
	// cross every 5th
	// source http://mathforum.org/dr.math/faq/faq.prime.num.html
	//
	// +++++++++++++++11 ===========cross out (not proper)

	// 1-3-1-3-5-1-5-3 between prime number pattern
	// +2+4+2+4+6+2+6+4 next prime number pattern
	// different approach

	// public static long betterPrimeNumberInPlace(long place) {
	// long primeInPlace = 0;
	// long[] smallPrimes = { 2, 3, 5, 7, 11 };
	//
	// if (place <= smallPrimes.length)
	// return primeInPlace = smallPrimes[(int) (place - 1)];
	//
	// long currentPrimeNumber = 11;
	// int patternMultiplier = (int) ((place - 5) / 8);
	// long lastPrimeNumberInPattern = 11 + (patternMultiplier * 30);
	// int placeInPattern = (int) ((place - 5) % 8);
	// switch (placeInPattern) {
	// case 1:
	// primeInPlace = lastPrimeNumberInPattern + 2;
	// break;
	// case 2:
	// primeInPlace = lastPrimeNumberInPattern + 2 + 4;
	// break;
	// case 3:
	// primeInPlace = lastPrimeNumberInPattern + 2 + 4 + 2;
	// break;
	// case 4:
	// primeInPlace = lastPrimeNumberInPattern + 2 + 4 + 2 + 4;
	// break;
	// case 5:
	// primeInPlace = lastPrimeNumberInPattern + 2 + 4 + 2 + 4 + 6;
	// break;
	// case 6:
	// primeInPlace = lastPrimeNumberInPattern + 2 + 4 + 2 + 4 + 6 + 2;
	// break;
	// case 7:
	// primeInPlace = lastPrimeNumberInPattern + 2 + 4 + 2 + 4 + 6 + 2 + 6;
	// break;
	// default:
	// primeInPlace = lastPrimeNumberInPattern;
	// break;
	// }
	//
	// return primeInPlace;
	// }


	


	public static void main(String[] args) {
		
		 System.out.println("Correct Answer: " + 104743);
		// System.out.println(primeNumberInPlace2(10001));
		// System.out.println("Result: ");
		// System.out.println(primeNumberInPlace(10001));
		System.out.println(primeInPlace2(10001));

	}

}
