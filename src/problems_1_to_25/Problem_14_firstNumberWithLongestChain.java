package problems_1_to_25;

import java.util.HashMap;

public class Problem_14_firstNumberWithLongestChain {
	//	The following iterative sequence is defined for the set of positive integers:
	//
	//		n - n/2 (n is even)
	//		n - 3n + 1 (n is odd)
	//
	//		Using the rule above and starting with 13, we generate the following sequence:
	//
	//		13 - 40 - 20 - 10 - 5 - 16 - 8 - 4 - 2 - 1
	//		It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
	//
	//		Which starting number, under one million, produces the longest chain?
	//
	//		NOTE: Once the chain starts the terms are allowed to go above one million.

	private static class StartingNumber{
		public StartingNumber() {
			super();
		}
		private int chainLength = 0;
		private int value =0;

		public int getChainLength(){
			return chainLength;
		}
		public void setChainLength(int chainLength){
			this.chainLength = chainLength;
		}

		public int getValue(){
			return value;
		}
		public void setValue(int value){
			this.value = value;
		}
	}
	private static  StartingNumber number = new StartingNumber();

	public static void calculateStartingNumber(){
		HashMap<Integer, Integer> mapOfAllCounts = new HashMap<Integer, Integer>();
		for(int startNumber = 2; startNumber < 7; startNumber ++){
			int nextChainNumber = startNumber;
			int chainLength = 0;
			while(nextChainNumber != 1){
				if(nextChainNumber % 2 == 0){
					nextChainNumber = nextChainNumber /2;
					
				}else{
					nextChainNumber = nextChainNumber *3 +1;
					
				}
				if(mapOfAllCounts.containsKey(nextChainNumber) == false){
					chainLength++;
					mapOfAllCounts.put(nextChainNumber, chainLength);
					//chainLength++;

				}else{
					int tempLength = mapOfAllCounts.get(nextChainNumber);
					chainLength += tempLength;		
									
				}
				if(startNumber > nextChainNumber){
							nextChainNumber =1;
							chainLength++;						
							mapOfAllCounts.put(startNumber, chainLength);
					}
				if(nextChainNumber == 1){
					if(chainLength > number.chainLength){
						number.chainLength = chainLength;
						number.value = startNumber;
					}

				}
			}

		}
	}
	//brute force not efficiant enough takes way too long
	public static StartingNumber calculateStartingNumber2(){
		for(int startNumber = 999999; startNumber > 1; startNumber --){
			int nextChainNumber = startNumber;
			int chainLength = 1;
			while(nextChainNumber != 1){
				if(nextChainNumber%2 == 0){
					nextChainNumber = nextChainNumber /2;
					chainLength++;
				}else{
					nextChainNumber = nextChainNumber * 3 + 1;
					chainLength++;
				}
				if(nextChainNumber == 1){
					if(number.chainLength < chainLength){
						number.value = startNumber;
						number.chainLength = chainLength;
					}
				}
			}
		}
		return number;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculateStartingNumber();
		System.out.println(number.value + "     "+  number.chainLength);
		HashMap<Integer, Integer> d = new HashMap<Integer, Integer>();
		d.put(1, 4);
		d.put(2, 2);



	}

}
