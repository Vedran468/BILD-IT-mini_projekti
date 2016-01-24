package mini_2_craps_i_credit_cards;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Z2IspravnostBrojaKreditneKartice {

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		// varijabla koja sabira rezultate zbira na brojevima koje mnozimo sa 2
		// i one koje ne mnozimo
		int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		// prvo proveravamo je li broj kartice dozvoljene velicine
		if (getSize(number) <= 16 && getSize(number) >= 13) {
			// zatim je li zbir deljiv sa 10
			if (sum % 10 == 0) {
				// ako jeste vrati true inace vrati false
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		// suma brojeva koje mnozimo sa 2
		int sumOfDoubleEvenPlace = 0;

		do {
			// prvo odbijamo poslednji broj
			number = number / 10;
			// pa sledeci broj definisemo u varijablu y
			long y = number % 10;
			// broj prosledjujemo metodi da vrati jednu cifru u slucaju da se
			// broj poslati pomnozen sa 2 bude veci od 9
			sumOfDoubleEvenPlace += getDigit((int) y);
			// System.out.println(sumOfDoubleEvenPlace);
			// zatim opet odbijamo broj koji smo dodali zbiru
			number = number / 10;
			// i tako dok broj ne postane dobijeni broj 0
		} while (number != 0);
		return sumOfDoubleEvenPlace;
	}

	/**
	 * Return this number if it is a single digit, otherwise, return the sum of
	 * the two digits
	 */
	public static int getDigit(int number) {
		// ako je broj ispod 5
		if (number < 5) {
			// pomnoziga sa 2
			number = number * 2;
		} else {
			// inace u pomocnoj varijabli pomnozi ga
			int x = number * 2;
			// ova pomocna varijabla pohranjuje poslednju cifru rezultata
			// mnozenja
			int y = x % 10;
			// a ova varijabla prvu cifru
			int z = x / 10;
			// zatim saberemo te dve cifre i metoda ih vrati
			number = z + y;
		}
		return number;
	}

	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number) {
		// variojabla za sumu brojeva koji se ne mnoze sa dva
		int sumOddPlace = 0;
		do {
			// pomocna varijabla koja odvaja poslednji broj
			long n = number % 10;
			// njega sabiramo
			sumOddPlace = sumOddPlace + (int) n;
			// zatim od broja dobijenog odbijamo dve poslednje cifre
			number = number / 100;
			// i sve tako dok broj dobijeni ne postane 0
		} while (number != 0);
		return sumOddPlace;
	}

	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		// proveravamo da li su brojevi prvi koji oznacava pripadnost kartice
		// poznati ovom programu
		if ((getPrefix(number, d) == 4) || (getPrefix(number, d) == 5) || (getPrefix(number, d) == 37)
				|| (getPrefix(number, d) == 6)) {

			// ako jesu stampamo naziv kartice
			if (getPrefix(number, d) == 4) {
				System.out.print("Visa card \n" + number);
			} else if (getPrefix(number, d) == 5) {
				System.out.print("Master card \n" + number);
			} else if (getPrefix(number, d) == 37) {
				System.out.print("American Express card \n" + number);
			} else if (getPrefix(number, d) == 6) {
				System.out.print("Discover card \n" + number);
			}
			return true;
		} else {
			// inace vrati false ako kartica ne postoji
			return false;
		}
	}

	/** Return the number of digits in d */
	public static int getSize(long d) {
		// definisemo varijablu za velicinu brojeva kartice
		int size = 0;
		do {
			// odbijamo poslednji broj
			d = d / 10;
			// ako je odbijen poslednji broj povecaj brojac velicine
			size++;
			// petlja radi dok ne postane dobijeni broj 0
		} while (d != 0);
		return size;
	}

	/**
	 * Return the first k number of digits from number. If the number of digits
	 * in number is less than k, return number.
	 */
	public static long getPrefix(long number, int k) {
		// ako je velicina brojeva kartice manja od dobijenog broja kartice
		if (getSize(number) < k) {
			// vrati brojeve
			return number;
			// inace
		} else {
			// velicinu brojeva redukujemo na trazeni broj za proveru
			// pripadnosti kartice
			int size = (int) getSize(number);
			for (int i = 0; i < (size - k); i++) {
				// odbijamo brojeve dok ne postane
				number = number / 10;
			}
			// vrati prve brojeve za pripadnost kartice
			return number;

		}
	}

	public static void main(String[] args) {
		// skener zxa unos
		Scanner input = new Scanner(System.in);
		// varijable za proveru unosa
		boolean checkingEntry1 = true;
		boolean checkingEntry2 = true;
		int sizeControlNumber = 0;
		/*
		 * 4388576018402626 i 4388576018410707 SU VISA KARTICE NJIHOVA KONTROLNA
		 * VELICINA JE 1
		 */
		// radi dok unos ne bude tacan za velicinu kontrolnog broja
		while (checkingEntry1) {
			System.out.println("Enter the size of the control number\n(Visa, MasterCard and "
					+ "Discover card that is 1 \nfor American Express cards that is 2). "
					+ "\nThe program stopped entering 3: ");
			try {
				sizeControlNumber = input.nextInt();
				// provera je li korisnik uneo broj jednak ponudjenim
				if (sizeControlNumber == 3) {
					checkingEntry1 = false;
					checkingEntry2 = false;
				} else if (sizeControlNumber == 1 || sizeControlNumber == 2) {
					checkingEntry1 = false;
				} else {
					System.out.println("Unsupported input, try again!!!");
					checkingEntry1 = true;
				}
				// u slucaju greske
			} catch (InputMismatchException e) {
				System.out.println("Againl!!! Enter the integer: ");
				input.nextLine();
			}
		}
		// varijabla za broj kartice
		long numberCard = 0;

		// radi dok unos ne bude tacan za broj kartice
		while (checkingEntry2) {
			System.out.println("Enter the number of card: ");
			try {
				numberCard = input.nextLong();
				// provera je li korisnik uneo broj veci od 0
				if (numberCard > 0) {
					checkingEntry2 = false;
				} else {
					System.out.println("Entering must be greater than 0!!!");
					checkingEntry2 = true;
				}
				// u slucaju greske
			} catch (InputMismatchException e) {
				System.out.println("Againl!!! Enter the long integer: ");
				input.nextLine();
			}
		}
		// zatvaramo unos
		input.close();
		// provera jesu li iuneti trazeni podaci
		if (numberCard != 0 && sizeControlNumber != 0) {
			// provera je li pripadnost kartice podrzana
			if (prefixMatched(numberCard, sizeControlNumber)) {
				// provera je li broj kartice vazeci
				if (isValid(numberCard)) {
					System.out.print(" is valid.");
				} else {
					System.out.print(" is invalid.");
				}
			} else {
				System.out.println("Unsupported cards!!!");
			}
		}
	}
}
