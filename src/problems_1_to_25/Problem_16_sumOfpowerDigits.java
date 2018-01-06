package problems_1_to_25;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problem_16_sumOfpowerDigits {
	//	215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
	//
	//			What is the sum of the digits of the number 21000?


	//use arrayList or stringBuilder
	//StringBuilder myName = new StringBuilder("domanokz");
	//	myName.setCharAt(4, 'x');

	public static int powerby(int what, int by){
		int returnInt = 0;
		ArrayList<String> listOfDigitsOFPower = new ArrayList<String>();	
		int forNow = what;
		listOfDigitsOFPower.add(String.valueOf(what));
		for(int index= 1; index < by; index++){
			int temptemp = 0;
			for(int stringIndex = listOfDigitsOFPower.size()-1; stringIndex >= 0; stringIndex --){
//				System.out.println("me");
				String digitString = listOfDigitsOFPower.get(stringIndex);
				int digitInteger = Integer.valueOf(digitString);
				digitInteger = digitInteger*what;
//				System.out.println(digitString);
				digitInteger += temptemp;

				digitString = String.valueOf(digitInteger);	
				String lastDigit = digitString.substring(digitString.length()-1);
				if(stringIndex >= 0){

					listOfDigitsOFPower.remove(stringIndex);
					
					listOfDigitsOFPower.add(stringIndex, lastDigit);
				}
				temptemp = digitInteger;
				if(temptemp > 9){
					String c = String.valueOf(temptemp);
					c = c.substring(0, c.length()-1);
					temptemp = Integer.valueOf(c);
				}else{
					temptemp = 0;
				}
			}
			String m = String.valueOf(temptemp);
			if(temptemp > 0){
				for(int i= m.length(); i >0; i--){
					listOfDigitsOFPower.add(0, m.substring(i-1, i));
				}
			}

		}
		for(String s: listOfDigitsOFPower){
			int tempInt = Integer.valueOf(s);
			returnInt+= tempInt;
		}
		return returnInt;
	}

	public static void main(String[] args) {
		//1366
		System.out.println(powerby(2, 1000));
	}

}
