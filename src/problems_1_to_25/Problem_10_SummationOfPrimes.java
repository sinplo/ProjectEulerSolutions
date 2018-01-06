package problems_1_to_25;

import java.util.ArrayList;

public class Problem_10_SummationOfPrimes {
	//	https://projecteuler.net/problem=10
	//
	//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	//Find the sum of all the primes below two million.
	
	//took way too long for such big problem;
	public static long sumOfPrimes(int margin){
		ArrayList<Long> primeList = new ArrayList<Long>();;
		long sum = 0;
		long currentNumber = 2;
		int listIndex = 0;
		while(currentNumber < margin){
			if(primeList.isEmpty()){
				sum = sum + currentNumber;
				primeList.add(currentNumber);
				currentNumber ++;
				
			}else{
				long currentDivider = primeList.get(listIndex);
				if(currentNumber % currentDivider == 0){
					currentNumber++;
					listIndex = 0;
				}else{
					if(listIndex == primeList.size() -1){
						sum = sum + currentNumber;
						primeList.add(currentNumber);
						
						listIndex = 0;
					}else{
						listIndex ++;
					}
				}
			}
		}
		return sum;
	}	
	//TODO implement faster method for primeNumbers

	public static void main(String[] args) {
		System.out.println("Correct Answer: " + "142913828922");
		System.out.println(sumOfPrimes(2000000));
	}

}
