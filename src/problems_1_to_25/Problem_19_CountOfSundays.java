package problems_1_to_25;

public class Problem_19_CountOfSundays {
	//	You are given the following information, but you may prefer to do some research for yourself.
	//
	//	1 Jan 1900 was a Monday.
	//	Thirty days has September,
	//	April, June and November.
	//	All the rest have thirty-one,
	//	Saving February alone,
	//	Which has twenty-eight, rain or shine.
	//	And on leap years, twenty-nine.
	//	A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

	//	How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

	public static int calculate1stSundays(){
		int sum =0;
		int year = 1901;
		int month = 1;
		
		int weekDayIndex = 1;
		int dayOfMonth = 1;
		while(year < 2001){
			//check if first day of month is Sunday
			if(dayOfMonth == 1 && weekDayIndex == 7)
				sum++;

			dayOfMonth ++;
			weekDayIndex++;
			//check if weekdayIndex is eight and changes back to 1 (Monday) if it is
			if( weekDayIndex == 8)
				weekDayIndex= 1;
			
			//check for end of the month non-leap year February 
			if(dayOfMonth == 29 && month == 2 && (year%4 != 0 || year%400 != 0)){
				dayOfMonth = 1;
				month = 3;
			//check for end of the month of leap-year February
			}else if(dayOfMonth == 30 && month == 2 && (year%4 == 0 || year%400 == 0)){
				dayOfMonth = 1;
				month = 3;
			//check for end of the month of April, June, September, November
			}else if(dayOfMonth == 31 && (month == 4 || month ==6 || month ==9 || month == 11)){
				dayOfMonth = 1;
				month++;
			//check for end of the year
			}else if(month == 12 && dayOfMonth == 32){
				year++;
				month =1;
				dayOfMonth =1;
			//check for the end of rest of months
			}else if( dayOfMonth == 32){
					dayOfMonth = 1;
					month++;
			}

			
// print something just to test the change of days/ weekdays/ months
//			if( month <3){
//				System.out.println("MonthDay: " + dayOfMonth);
//				System.out.println("WeekDayIndex: " + weekDayIndex);
//				System.out.println("Month: " + month);
//				System.out.println("Year"+ year);
//				System.out.println("--------------------------");
//			}
		}
		return sum;
	}


	public static void main(String[] args) {

		//171
		System.out.println(calculate1stSundays());

	}

}
