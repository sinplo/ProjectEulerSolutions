package problems_26_to_50;

public class Problem_28_number_spiral_diagnols {
	
//	Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
//
//		21 22 23 24 25
//		20  7  8  9 10
//		19  6  1  2 11
//		18  5  4  3 12
//		17 16 15 14 13
//
//		It can be verified that the sum of the numbers on the diagonals is 101.
//
//		What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
	
	public static int getTheSumOfSpiralDiagnols(int sizeOfOneEdge){
		int sum = 1;
		int sizeOfHalfOfEdge = (sizeOfOneEdge -1 ) / 2;
		int index = 1;
		int addNumber = 2;
		int countOffour = 0;
		int currentNumber = sum;
		while(index <= sizeOfHalfOfEdge){
			currentNumber = currentNumber + addNumber;
			sum = sum+ currentNumber;
			countOffour++;
//			System.out.println(currentNumber);
			if(countOffour == 4){
				index++;
				countOffour = 0;
				addNumber += 2;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		//corrent Answer 669171001
		System.out.println(getTheSumOfSpiralDiagnols(1001));

	}

}
