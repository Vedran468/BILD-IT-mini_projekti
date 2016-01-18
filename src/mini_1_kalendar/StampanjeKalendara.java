package mini_1_kalendar;

public class StampanjeKalendara {

	/**
	 * Metoda koja izvrsava stampanje naslova odnosno naziv meseca i datume
	 * kalendara
	 */
	public void printMonth(int year, int month) {
		// Print the headings of the calendar
		printMonthTitle(year, month);
		// Print the body of the calendar
		printMonthBody(year, month);
	}

	/** Metoda za stampanje naslova kalendara odnosno naziv meseca */
	public void printMonthTitle(int year, int month) {
		// naziv meseca dobija kada prosledimo broj u metodu
		System.out.println("\t\t" + getMonthName(month) + " " + year);
		System.out.println("-----------------------------------");
		System.out.println(" Mon  Tue Wed Thu   Fri  Sat  Sun");
	}

	/** Metoda koja proverava na osnovu dobijenog broja koji je mjesec */
	public String getMonthName(int month) {
		String monthName = "";
		switch (month) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "February";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
		}
		return monthName;
	}

	/** metoda koja stampa datume */
	public void printMonthBody(int year, int month) {
		// definisemo varijablu koja ce imati vrednost praznih polja odnosno
		// racuna
		int startDay = getStartDay(year, month) - 1;
		// dani u mesevu
		int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
		// stamnpamo prazna polja za starni dan u mesecu tj gde ce biti 1
		int i = 0;
		for (i = 0; i < startDay; i++) {
			String s = " ";
			System.out.printf("%8s", s);
		}
		// stampamo ostae dane u kalendar
		for (i = 1; i <= numberOfDaysInMonth; i++) {
			if (i < 10) {
				System.out.printf("%7d", i);
			} else {
				System.out.printf("%6d", i);

			}
			if ((i + startDay) % 7 == 0)
				System.out.println();
		}
		System.out.println();
	}

	/** metoda vraca startni dan */
	public int getStartDay(int year, int month) {
		final int START_DAY_FOR_JAN_1_1800 = 3;
		// ukupan broj dana od 1,1,1800
		int totalNumberOfDays = getTotalNumberOfDays(year, month);
		// vrati startni dan
		return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
	}

	/** metoda koja vraca ukupan broj dana od 1.1.1800 */
	public int getTotalNumberOfDays(int year, int month) {
		int total = 0;
		// sabiri dane od 1800 godine do dobijene
		for (int i = 1800; i < year; i++)
			if (isLeapYear(i))
				total = total + 366;
			else
				total = total + 365;
		// dodaj dane do trenutnog meseca
		for (int i = 1; i < month; i++)
			total = total + getNumberOfDaysInMonth(year, i);
		return total;
	}

	/** metoda vraca dane za trenutni mesec */
	public int getNumberOfDaysInMonth(int year, int month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;
		if (month == 4 || month == 6 || month == 9 || month == 11)
			return 30;
		if (month == 2)
			return isLeapYear(year) ? 29 : 28;

		return 0; // ako nije zadovoljeno nista od gor vrati 0
	}

	/** provera je li godina prestupna */
	public boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
}
