package problems_1_to_25;

import java.util.ArrayList;

public class Problem_23_Sum {
	//	A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
	//
	//			A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
	//
	//			As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
	//
	//			Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.


	public static int getSumOfNotNumbers(){
		int sum = 1;
		ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();

		for(int number = 2;  number <= 28123; number++){
			int dividerSum =1;
			for(int divider= 2; divider < number-1; divider++){
				if(number % divider == 0){
					if(number / divider < divider){
						break;
					}else if(number / divider == divider){
						dividerSum+= divider;
					}else{
						int secondDivider = number / divider;
						dividerSum+= divider + secondDivider;
					}
				}

			}
			if(dividerSum > number){
				abundantNumbers.add(number);
			}

			if(abundantNumbers.size() >0){
				for(int index = 0; index < abundantNumbers.size(); index++){
					int abundantNumber = abundantNumbers.get(index);
					int b = number - abundantNumber;
					if(abundantNumbers.contains(b) || abundantNumber >number){
						break;
					}else if(index == abundantNumbers.size()-1){
						sum+= number;
					}
				}
			}else{
				sum+= number;
			}


		}

		return sum;
	}
	
	
	
	public static int getSumOfNotNumbers2(){
		int sum=0;
		ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();

		for(int number = 2;  number <= 28123; number++){
			int dividerSum =1;
			for(int divider= 2; divider < number-1; divider++){
				if(number % divider == 0){
					if(number / divider < divider){
						break;
					}else if(number / divider == divider){
						dividerSum+= divider;
					}else{
						int secondDivider = number / divider;
						dividerSum+= divider + secondDivider;
					}
				}

			}
			if(dividerSum > number){
				abundantNumbers.add(number);
			}	
		}
		
		ArrayList<Integer> sumsOfAbundantNumbers = new ArrayList<Integer>();
		for(int index=0; index < abundantNumbers.size(); index++){
			int number1 = abundantNumbers.get(index);
			for(int indexB= index; indexB < abundantNumbers.size(); indexB++){
				int number2 = abundantNumbers.get(indexB);
				int sumOfTwoAbundants = number2+ number1;
				sumsOfAbundantNumbers.add(sumOfTwoAbundants);
			}
		}
		
		for(int index = 0; index <= 28123; index++ ){
			if(sumsOfAbundantNumbers.contains(index)== false){
				sum+= index;
			}
		}
			return sum;
		}
		
	
	
	
	public static void main(String[] args) {
		
			//4179871
			System.out.println(getSumOfNotNumbers2());

		}

	}
