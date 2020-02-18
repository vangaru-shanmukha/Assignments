/**
 * Gruber Healthcare has different types of forms for their customer, one of which is a know your customer form ( KYC ) which has to be filled annually. 
 * Each form has a date which signifies the date the form was filled called the form date.
 * Due to government regulations the KYC form can only be filled within + or - 30 days of the signup anniversary of a customer. 
 * When filling it up, you have to provide the form date. 
 * If you are past the +-30 day anniversary then you can back-date it so that it falls in the +-30-day window. 
 * When filling it up you cannot use a future date for the form date.
 * For Example, assuming today is 4 Apr 2017 and I had signed up on 1st Mar 2014, my window for KYC submission this year would be 30 Jan 2017 to 31 Mar 2017. 
 * Since it is already 4th Apr - I would have to back-date the KYC to a date in this range.
 * Note: The KYC form can be filled only for the closest anniversary in the past or within 30 days range in future.
 * Anniversary refers to same day and month every year. If your birthday is 01-02-1992 -then your first anniversary will be 01-02-1993, the 2nd will be 01-02-1994 and so on.
 * 01-02-1992 is not an anniversary.
 * Given the signup date and the current date, provide the allowable date range for the form date.
 * Input - First line is an integer n as the number of inputs to be passed. 
 * Next, n lines are n input for the program in the format dd-mm-yyyy dd-mm-yyyy 
 * Each line has two dates separated by space where the first date in signup date and the second date is the current date.
 * Output - Range of dates for KYC form in format dd-mm-yyyy dd-mm-yyyy
 * Test Input:
 * 5 
 * 16-07-1998 27-06-2017
 * 04-02-2016 04-04-2017 
 * 04-05-2017 04-04-2017
 * 04-04-2015 04-04-2016
 * 04-04-2015 15-03-2016
 * Test output:
 * 16-06-2017 27-06-2017
 * 05-01-2017 06-03-2017
 * No range
 * 05-03-2016 04-04-2016
 * 05-03-2016 15-03-2016

 */
package assignments;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LocalDateAssignment {
	// These list are used to store the start and end date values for each input
	private static ArrayList<LocalDate> startList = new ArrayList<LocalDate>();
	private static ArrayList<LocalDate> endList = new ArrayList<LocalDate>();

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// reading the number of input lines
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			// reading the signupdate and currentdate
			String s = sc.nextLine();
			String dates[] = s.split(" ");
			// getting the start date object
			LocalDate signupDate = getDate(dates[0]);
			// getting the current date object
			LocalDate currentDate = getDate(dates[1]);
			// getting the range
			getRange(signupDate, currentDate);
		}
		// printing the range values
		printRangeValues();
	}

	/**
	 * This method is used to print the range values in startList and endList
	 */
	private static void printRangeValues() {
		for (int i = 0; i < startList.size(); i++) {
			LocalDate startDate = startList.get(i);
			LocalDate endDate = endList.get(i);
			if (startDate != null) {
				DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String textstartDate = startDate.format(formatters);
				String textendDate = endDate.format(formatters);
				LocalDate parsedStartDate = LocalDate.parse(textstartDate, formatters);
				LocalDate parsedEndDate = LocalDate.parse(textendDate, formatters);
				System.out.println(parsedStartDate.format(formatters) + " " + parsedEndDate.format(formatters));
			} else
				System.out.println("No Range");
		}

	}

	/**
	 * This method is used to update the startList and endList with the range values
	 * based on the signupDate and currentDate values
	 * 
	 * @param signupDate
	 * @param currentDate
	 */
	private static void getRange(LocalDate signupDate, LocalDate currentDate) {
		LocalDate newSignupDate = signupDate.plusYears(currentDate.getYear() - signupDate.getYear());
		LocalDate startDate = newSignupDate.minusDays(30);
		LocalDate endDate = newSignupDate.plusDays(30);
		if (startDate.getMonthValue() >= currentDate.getMonthValue()) {
			if (startDate.getDayOfMonth() >= currentDate.getDayOfMonth()) {
				startList.add(null);
				endList.add(null);
				return;
			}
		} else if (startDate.getMonthValue() == currentDate.getMonthValue()
				&& startDate.getDayOfMonth() >= currentDate.getDayOfMonth()) {
			startList.add(null);
			endList.add(null);
			return;
		}
		if (endDate.getMonthValue() > currentDate.getMonthValue()) {
			endDate = currentDate;
		} else if (endDate.getDayOfMonth() > currentDate.getDayOfMonth()
				&& endDate.getMonthValue() == currentDate.getMonthValue())
			endDate = currentDate;
		startList.add(startDate);
		endList.add(endDate);
	}

	/**
	 * This method is used to get the localdate object of the string
	 * 
	 * @param string
	 * @return LocalDate
	 */
	private static LocalDate getDate(String string) {
		String day[] = string.split("-");
		LocalDate date = LocalDate.of(Integer.parseInt(day[2]), Integer.parseInt(day[1]), Integer.parseInt(day[0]));
		return date;
	}

}
