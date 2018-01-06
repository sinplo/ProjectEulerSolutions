package problems_1_to_25;

import java.util.ArrayList;

public class Problem_20_FactorialSum {
	//	n! means n × (n − 1) × ... × 3 × 2 × 1
	//
	//	For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
	//	and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
	//
	//	Find the sum of the digits in the number 100!


	public static int findFactorialSum(){
		int sum =0;
		ArrayList<Integer> factoredNumber = new ArrayList<>();
		int factor = 100;
		factoredNumber.add(factor);

		for(int index = 99; index >=1; index--){
			int intermediateProduct = 0;
			for(int indexB=factoredNumber.size() - 1; indexB >= 0; indexB --){

				int digit = factoredNumber.get(indexB);

				digit = digit * index;
				digit += intermediateProduct;

				String digitString = String.valueOf(digit);
				digitString = digitString.substring(digitString.length() -1);
//				System.out.println(digitString);
//				System.out.println(digit);

				int digitReplace = Integer.valueOf(digitString);

				if(indexB >= 0){
					factoredNumber.remove(indexB);
					factoredNumber.add(indexB, digitReplace);
				}


				intermediateProduct = digit;
				if(intermediateProduct > 9){
					String c = String.valueOf(intermediateProduct);
					c = c.substring(0, c.length()-1);
					intermediateProduct = Integer.valueOf(c);
				}else{
					intermediateProduct = 0;
				}



			}
//			System.out.println(intermediateProduct +  "ssssssss");
			if(intermediateProduct > 0){
				String stringInterm = String.valueOf(intermediateProduct);
				for(int indexz = stringInterm.length(); indexz >0; indexz --){
					factoredNumber.add(0, Integer.valueOf(stringInterm.substring(indexz - 1, indexz)));
				}


			}

//			for(int digit: factoredNumber){
//				System.out.println(digit);
//			}
//			System.out.println("------------");

		}
		//
		//		for(int digit: factoredNumber){
		//			System.out.println(digit);
		//		}

		for(int digit: factoredNumber){
			sum += digit;
		}

		return sum;
	}

	public static void main(String[] args) {
		//648
		System.out.println(findFactorialSum());
		//		String d = "989456123";
		//		System.out.println(d.substring(d.length()-1));


	}

}
