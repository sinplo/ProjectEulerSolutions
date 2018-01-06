package problems_1_to_25;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Path;



public class Problem_22_TotalofAlphabeticScores {
	//	Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
	//
	//	For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
	//
	//	What is the total of all the name scores in the file?

	private static HashMap<String, Integer> letterValues;
	public static void initizializeLetterValues(){
		letterValues = new HashMap<>();
		letterValues.put("A", 1);
		letterValues.put("B", 2);
		letterValues.put("C", 3);
		letterValues.put("D", 4);
		letterValues.put("E", 5);
		letterValues.put("F", 6);
		letterValues.put("G", 7);
		letterValues.put("H", 8);
		letterValues.put("I", 9);
		letterValues.put("J", 10);
		letterValues.put("K", 11);
		letterValues.put("L", 12);
		letterValues.put("M", 13);
		letterValues.put("N", 14);
		letterValues.put("O", 15);
		letterValues.put("P", 16);
		letterValues.put("Q", 17);
		letterValues.put("R", 18);
		letterValues.put("S", 19);
		letterValues.put("T", 20);
		letterValues.put("U", 21);
		letterValues.put("V", 22);
		letterValues.put("W", 23);
		letterValues.put("X", 24);
		letterValues.put("Y", 25);
		letterValues.put("Z", 26);
	
	}
	
	
	
	public static ArrayList<String> loadFile(){
		
		String path = new File("src/problems_1_to_25/p022_names.txt").getAbsolutePath();
		ArrayList<String> listOfName = new ArrayList<>();
		Path realPath = Paths.get(path);
		try {
			ArrayList<String> printString = (ArrayList<String>) Files.readAllLines((Path)realPath);
			String inputS = printString.get(0);
			String regex = "[a-zA-Z]+";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(inputS);
			while(matcher.find()){
				String f = matcher.group(0);
				listOfName.add(f);
			}
			
			//Sorting alphabetic order the list of names
			Collections.sort(listOfName, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareToIgnoreCase(o2);
				}
				
			});
		} catch (IOException e) {
			e.printStackTrace();
		}


		return listOfName;
	}
	
	public static int getTotalNameScore(){
		ArrayList<String> listOfNames = loadFile();
		int sum = 0;
		for(int index= 0; index< listOfNames.size(); index++){
			String name = listOfNames.get(index);
			int score = 0;
			for(int indexString= 0; indexString< name.length(); indexString ++){
				String letter = name.substring(indexString, indexString+1);
				int letterValue = (int)letterValues.get(letter);
				score+= letterValue;
			}
			
			score*=(index+1);
			sum+=score;
						
		}
		return sum;
		
	}
	public static void main(String[] args) {
		loadFile();
		initizializeLetterValues();
		//871198282
		System.out.println(getTotalNameScore());

	}

}
