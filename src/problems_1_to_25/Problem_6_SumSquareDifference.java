package problems_1_to_25;

public class Problem_6_SumSquareDifference {
//The sum of the squares of the first ten natural numbers is = 385
//The square of the sum of the first ten natural numbers is = 3025
//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 -385 =2640
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	
	
	
	public static long sumOfSquares(int range){
		long sum = 0;
		for(int number = 1; number <= range; number++){
			sum = sum + (number * number);
		}
		return sum;
	}
	
	public static long squareOFSum(int range){
		long sum = 0;
		for(int number =1; number <= range; number++){
			sum = sum + number;
		}
		sum = sum* sum;
		return sum;
	}
	
	public static long differenceOfSquares(int range){
		long difference = 0;
		long sumOfSquares = sumOfSquares(range);
		long squareOfSum = squareOFSum(range);
		
		difference = squareOfSum - sumOfSquares;
		return difference;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumOfSquares(10));
		System.out.println(squareOFSum(10));
		System.out.println("Correct Answer: " + 25164150 + "\nResult: " + differenceOfSquares(100));

	}

}
