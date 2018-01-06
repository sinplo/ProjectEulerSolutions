package problems_1_to_25;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem_25_1000DigitFibonacci {
	//	The Fibonacci sequence is defined by the recurrence relation:
	//
	//		Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
	//		Hence the first 12 terms will be:
	//
	//		F1 = 1
	//		F2 = 1
	//		F3 = 2
	//		F4 = 3
	//		F5 = 5
	//		F6 = 8
	//		F7 = 13
	//		F8 = 21
	//		F9 = 34
	//		F10 = 55
	//		F11 = 89
	//		F12 = 144
	//		The 12th term, F12, is the first term to contain three digits.
	//
	//		What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

	public static int getFibbonacciIndex(){
		int indexOfFib = 0;
		ArrayList<Integer> fibonnaciNumber_n = new ArrayList<Integer>();
		ArrayList<Integer> fibonnaciNumber_n_Minus1 = new ArrayList<Integer>();

		int currentIndex =3;
		fibonnaciNumber_n_Minus1.add(1);
		fibonnaciNumber_n.add(2);

		int indexn = fibonnaciNumber_n.size()-1;
		int indexn_1= fibonnaciNumber_n_Minus1.size() -1;


		int betweenNumber = 0;
		ArrayList<Integer> placeHolderList = new ArrayList<>(fibonnaciNumber_n);

		while(fibonnaciNumber_n.size() < 1000){
			int numberA = fibonnaciNumber_n.get(indexn);
			int numberB = 0;
			if(indexn_1 >= 0){
				numberB= fibonnaciNumber_n_Minus1.get(indexn_1);
			}
			betweenNumber += numberA + numberB;

			if(betweenNumber < 10){
				fibonnaciNumber_n.set(indexn, betweenNumber);
				betweenNumber = 0;	
			}else{
				String betWeenNumberString = String.valueOf(betweenNumber);
				if(indexn == 0){	
					fibonnaciNumber_n.set(indexn, Integer.valueOf(betWeenNumberString.substring(1)));
					fibonnaciNumber_n.add(0, Integer.valueOf(betWeenNumberString.substring(0, 1)));
					betweenNumber = 0;
				}else{
					fibonnaciNumber_n.set(indexn, Integer.valueOf(betWeenNumberString.substring(1)));

					betweenNumber = Integer.valueOf(betWeenNumberString.substring(0, 1));
				}		

			}
			indexn--;
			indexn_1--;
			//Fn will always be larger than Fn-1
			if(indexn <0){



				fibonnaciNumber_n_Minus1 = new ArrayList<>(placeHolderList);
				placeHolderList = new ArrayList<>(fibonnaciNumber_n);
				currentIndex++;
				indexn = fibonnaciNumber_n.size()-1;
				indexn_1= fibonnaciNumber_n_Minus1.size()-1;
				betweenNumber = 0;	


//---------------just to test all the lists ---------------------------------------------------------------------
//				String prinStringB = "";
//				for(int i: fibonnaciNumber_n){
//					prinStringB += "" + i;
//				}
//				System.out.println("N"+ prinStringB);
//
//				String prinStringA = "";
//				for(int i: placeHolderList){
//					prinStringA += "" + i;
//				}
//
//				System.out.println("H" + prinStringA);
//				String prinStringC = "";
//				for(int i: fibonnaciNumber_n_Minus1){
//					prinStringC += "" + i;
//				}
//				System.out.println("N-1 " + prinStringC);	
//				System.out.println("8888888888888888888888888888");


			}



		}

		indexOfFib = currentIndex;


		return indexOfFib;
	}

	
	//unrelated methods to delete------------------------
	public static String convertStringToHex(String str){

		char[] chars = str.toCharArray();

		StringBuffer hex = new StringBuffer();
		for(int i = 0; i < chars.length; i++){
			hex.append(Integer.toHexString((int)chars[i]));
		}

		return hex.toString();
	}

	public static String convertHexToString(String hex){

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		//49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for( int i=0; i<hex.length()-1; i+=2 ){

			//grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			//convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			//convert the decimal to character
			sb.append((char)decimal);

			temp.append(decimal);
		}
		System.out.println("Decimal : " + temp.toString());

		return sb.toString();
	}




	public static void main(String[] args) {
		//		String text = "21";
		//		byte[] arrayOfBytes = text.getBytes();
		//		byte b = new Byte((byte) 37);
		//		byte b2 = new Byte((byte) 32);
		//		byte b3 = new Byte((byte) 34);
		//		byte b4 = new Byte((byte) -126);
		//		byte[]dsdsd ={b, b2, b3, b4};
		//
		//        String formatedString="";
		//		for(byte s: arrayOfBytes){
		//			formatedString +=  String.format("0x%02X ", s);
		//		}
		//		String m = new String(dsdsd);
		//		System.out.println(formatedString);
		//		String ssfs = convertStringToHex(text);
		//		System.out.println(ssfs);
		//		System.out.println(convertHexToString("042762c95adf5380"));

		System.out.println(getFibbonacciIndex());
		String s = "13";
		System.out.println("------------------------------------------");
		System.out.println(s.substring(1));

	}

}
