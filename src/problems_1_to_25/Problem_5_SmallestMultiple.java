package problems_1_to_25;

import java.util.HashMap;
import java.util.Map;

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
	
	//multiplying the highest power of each prime number together
	//source wikipedia  https://en.wikipedia.org/wiki/Least_common_multiple#Finding_least_common_multiples_by_prime_factorization
	
	//TODO implement method
	public static long leastCommonMultiple(int range){
		long commonMultiple = 0;
		Map<Integer, Integer> primePowers = new HashMap<Integer, Integer>();
		for(int number=1; number<= range ; number++){
			
		}
		
		return commonMultiple;
	}
	
	// not my implementation [here as an example of another way to solve the problem] based on Euclidean algorith
	// https://en.wikipedia.org/wiki/Euclidean_algorithm
	private static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	private static long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}

	private static long lcm(long range)
	{
	    long result = 1;
	    for(int i = 1; i <=range; i++) {
	    	result = lcm(result, i);
	    }
	    return result;
	}

	public static void main(String[] args) {
//		//System.out.print("Answer: " + 232792560 + "\nResult: " + smallestCommonDivisible(20));
		
		System.out.println(lcm(20));
	//	System.out.println(gcd(10, 6));

	}

}
