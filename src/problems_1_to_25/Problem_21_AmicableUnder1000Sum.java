package problems_1_to_25;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem_21_AmicableUnder1000Sum {
	//	Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
	//	If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
	//
	//	For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
	//
	//	Evaluate the sum of all the amicable numbers under 10000.

	public static int amicableNumberSum(){
		int sum=0;
		ArrayList<Integer> validAmbicableNumbers = new ArrayList<Integer>();
		HashMap<Integer, Integer> NumbersAndDivisorSums = new HashMap<Integer, Integer>();

		for(int index = 2; index < 10000; index ++){

			int divisorSum = 0;
			int divisorSum2= 0;
			if(NumbersAndDivisorSums.containsKey(index) == false){
				for(int indexB = index -1;  indexB>0; indexB--){
					if(index % indexB == 0){
						if(indexB < index / indexB){
							break;
						}else if(indexB == index/indexB ){
							divisorSum += indexB;
						}else{
							divisorSum += indexB;
							divisorSum += index / indexB;
						}					
					}
				}
				divisorSum += 1;

				if(divisorSum != index){
					for(int indexB = divisorSum-1;  indexB>0; indexB--){
						if(divisorSum % indexB == 0){
							if(indexB < divisorSum / indexB){
								break;
							}else if(indexB == index/indexB){
								divisorSum2 += indexB;
							}else{
								divisorSum2 += indexB;
								divisorSum2+= divisorSum / indexB;
							}					
						}
					}
					divisorSum2+= 1;
					if(divisorSum2 == index){
						NumbersAndDivisorSums.put(index, divisorSum);
						NumbersAndDivisorSums.put(divisorSum, index);
						sum+= index + divisorSum;
					}
				}
			}
		}
		return sum;

	}
	public static void main(String[] args) {


		//31626
		System.out.println(amicableNumberSum());


	

//			int divisorSum = 0;
//			int divisorSum2= 0;
//
//			for(int indexB = 220 -1;  indexB>0; indexB--){
//				if(220 % indexB == 0){
//					if(indexB < 220 / indexB){
//						break;
//					}else if(indexB == 220/indexB ){
//						divisorSum += indexB;
//					}else{
//						divisorSum += indexB;
//						divisorSum += 220 / indexB;
//					}					
//				}
//			}
//			divisorSum += 1;
//			System.out.println(divisorSum);


		
	}

}
