package problems_1_to_25;

public class Problem_5_SmallestMultiple {
//	2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//
//	What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	
	//Slow method for range of 1-20
	public static long smallestCommonDivisible(int number){
		long smallestMultiple = 0;
		long dividable =1;
		while(smallestMultiple == 0){
			for(int divider = 1; divider <= number; divider++){
				if(dividable % divider > 0){
					dividable ++;
					break;
				}else if( dividable % divider == 0  && divider == number){
					smallestMultiple = dividable;
					
				}
			}
		}
		
		return smallestMultiple;
	}

	public static void main(String[] args) {
		System.out.print("Answer: " + 232792560 + "\nResult: " + smallestCommonDivisible(20));

	}

}
