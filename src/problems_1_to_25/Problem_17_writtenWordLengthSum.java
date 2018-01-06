package problems_1_to_25;

import java.util.HashMap;

public class Problem_17_writtenWordLengthSum {
//	If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
//
//			If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
//
//
//			NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
//			The use of "and" when writing out numbers is in compliance with British usage.

	static HashMap<Integer, Integer> mapOfNumbers = new HashMap<Integer, Integer>();

	public static void populateMap(){
		//represent word -and-
		mapOfNumbers.put(-1, 3);
		mapOfNumbers.put(1, 3);
		mapOfNumbers.put(2, 3);
		mapOfNumbers.put(3, 5);
		mapOfNumbers.put(4, 4);
		mapOfNumbers.put(5, 4);
		mapOfNumbers.put(6, 3);
		mapOfNumbers.put(7, 5);
		mapOfNumbers.put(8, 5);
		mapOfNumbers.put(9, 4);
		mapOfNumbers.put(10, 3);
		mapOfNumbers.put(11, 6);
		mapOfNumbers.put(12, 6);
		mapOfNumbers.put(13, 8);
		mapOfNumbers.put(14, 8);
		mapOfNumbers.put(15, 7);
		mapOfNumbers.put(16, 7);
		mapOfNumbers.put(17, 9);
		mapOfNumbers.put(18, 8);
		mapOfNumbers.put(19, 8);
		mapOfNumbers.put(20, 6);
		mapOfNumbers.put(30, 6);
		mapOfNumbers.put(40, 5);
		mapOfNumbers.put(50, 5);
		mapOfNumbers.put(60, 5);
		mapOfNumbers.put(70, 7);
		mapOfNumbers.put(80, 6);
		mapOfNumbers.put(90, 6);
		mapOfNumbers.put(100, 7);
		mapOfNumbers.put(1000, 8);
		
	}
	
	public static int getCount(){
		int count = 0;
		int tillTen = 0;
		int from_10_till_20 =0;
		int from_1_till_100 = 0;
		for(int index = 1; index <20; index ++){
			if(index <10){
				tillTen += mapOfNumbers.get(index);
			}else if(index >=10 && index < 20){
				from_10_till_20 += mapOfNumbers.get(index);
			}
		}
		//-9
		count += tillTen;

		//10-19
		count += from_10_till_20;

		//20-29
		count += mapOfNumbers.get(20) *10 + tillTen;
		//30-39
		count += mapOfNumbers.get(30) * 10 + tillTen;
		//40-49
		count += mapOfNumbers.get(40) * 10 + tillTen;
		//50-59
		count+= mapOfNumbers.get(50) * 10 + tillTen;
		//60-69
		count+= mapOfNumbers.get(60) * 10 + tillTen;
		//70-79
		count+= mapOfNumbers.get(70) * 10 +tillTen;
		//80-89
		count+=mapOfNumbers.get(80) * 10 + tillTen;
		//90-99
		count+= mapOfNumbers.get(90) * 10 + tillTen;
	
		from_1_till_100 = count;
		// rest 900
		System.out.println((mapOfNumbers.get(100) + mapOfNumbers.get(-1)));
		count+= (from_1_till_100 * 9) + mapOfNumbers.get(100) * 9 + (mapOfNumbers.get(100) + mapOfNumbers.get(-1)) * 99*9 + tillTen * 100;
		count += mapOfNumbers.get(1)+mapOfNumbers.get(1000);
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		populateMap();
		//21124
		System.out.println(getCount());

	}

}
