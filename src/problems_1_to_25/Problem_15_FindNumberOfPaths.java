package problems_1_to_25;

import java.math.BigInteger;

public class Problem_15_FindNumberOfPaths {
	
//	Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
//
//
//	How many such routes are there through a 20×20 grid?
	
//	good additional info (especially the second link)	
//	http://www.luschny.de/math/factorial/FastFactorialFunctions.htm
//	https://betterexplained.com/articles/navigate-a-grid-using-combinations-and-permutations/
	
	public static String findNumberOfPath(){
		String pathCount = "";
		BigInteger gridRowFac = getFactorialForLarge(20, 1);
//		System.out.println("G: " + gridRowFac);
		//because first 20 multiplications are the same those can be emitted therefore we multiply until index goes down to 20
		BigInteger sumOfRowAndColumns = getFactorialForLarge(40, 20);
//		System.out.println("d: " + sumOfRowAndColumns);
		
		//formula from second link paths= (sumOfRowAndComlumns)! / (row)! / (column)!
		//because we emited first 20 muliplications from (sumOfRowAndColumns)! 
		//paths = (21*22*...40) / (row)!
		BigInteger intermidiateProduct = sumOfRowAndColumns.divide(gridRowFac);
		pathCount = String.valueOf(intermidiateProduct);
		return pathCount;
	}
	
	//get the factorial
	public static BigInteger getFactorialForLarge(int number, int lowerLimit){
		BigInteger factorial = BigInteger.valueOf(number);
		
		for(int index = number-1 ; index > lowerLimit; index --){
			factorial = factorial.multiply(BigInteger.valueOf(index));
		}
		
		return factorial;
	}
	
	

	public static void main(String[] args) {

		//137846528820
		System.out.println(findNumberOfPath());

	}

}
