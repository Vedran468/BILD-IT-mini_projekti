package mini_4_Battleship_i_Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Vedran Vidakovic
 *
 */
public class Z2Hangman {

	// data fields za brojace
	private int counterLost = 6;
	private int counterWin = 0;
	// data field koji sprema niz karaktera koji se trazi tj rec koja se trazi
	private ArrayList<Character> charList = new ArrayList<>();
	private ArrayList<String> have = new ArrayList<>();

	// no-arg konstruktor
	public Z2Hangman() {

	}

	// get metode koje vracaju brojace
	public int getCounterWin() {
		return counterWin;
	}

	public int getCounterLost() {
		return counterLost;
	}

	public ArrayList<String> getHave() {
		return have;
	}

	// metoda koja dobijenin string pretvara u niz karaktera
	private static char[] convertingTheCharacters(ArrayList<String> line, int number) {
		// posto dobijamo niz stringova tj moguci reci za igru na osnovu
		// dobijenog broja tu rec da pretvorimo u niz karaktera
		char[] chars = line.get(number).toCharArray();
		return chars;
	}

	// metoda koja vraca trazenu rec
	public ArrayList<Character> listCharakers() throws FileNotFoundException {
		// trazimo fajl sa ovom apsolutnom adresom
		File file = new File("reci za igru.txt");
		Scanner input2 = new Scanner(file);
		// string lista svih reci koji se nalaze dokumentu
		ArrayList<String> line = new ArrayList<>();
		// iz fajla recenice smestamo u listu
		while (input2.hasNextLine()) {
			line.add(input2.nextLine());
		}
		input2.close();

		// iz niza biramo jedan zadatak nasumicno
		int number = (int) (Math.random() * (line.size()));

		// pretvaramo taj string u niz karaktera
		char[] chars = convertingTheCharacters(line, number);
		// iscitavamo te karakere i dodajemo listi karaktera
		for (int i = 0; i < chars.length; i++) {
			charList.add(chars[i]);
		}
		return charList;
	}

	// metoda koja vraca indekse na kojima se nalazi slovo koje je dobijeno
	public ArrayList<Integer> indexs(String l) throws FileNotFoundException {
		// definisemo listu koju ce mo vratitit
		ArrayList<Integer> indexs = new ArrayList<>();
		// brojac koji proverava je li bilo tog slova
		int counter = 0;
		// provera je li dobijeno samo jedno slovo
		if (checkingEntries(l)) {
			// saljemo u metodu na proveru da li postoji vec
			if (!have(l)) {
			// ako je samo slovo i ne postoji prodji kroz niz karaktera i upordei gde se
			// nalazi to slovo
			for (int i = 0; i < charList.size(); i++) {
					if (charList.get(i).equals(l.charAt(0))) {
						// ako je nasao indeks sa istim slovom dodaj ga u listu
						// i
						// povecaj brojace
						indexs.add(i);
						have.add(l);
						counter++;
						counterWin++;
					}
				}
			}
		}

		// ako nije bilo slova posalji slovo u metodu koja pamti ta slova i
		// smanji brojac gresaka
		if (counter == 0) {
			nonexistentLetters(l);
			counterLost--;
		}
		return indexs;
	}

	// metoda koja proverava je li unos bio jedno slovo
	public boolean checkingEntries(String l) {
		if (l.length() == 1) {
			return true;
		} else {
			return false;
		}
	}

	// metoda koja proverava da li je vec dodato to slovo
	private boolean have(String l) {
		int counter = 0;
		for (int i = 0; i < have.size(); i++) {
			if (have.get(i).equals(l)) {
				counter++;
			}
		}
		if (counter > 0) {
			return true;
		} else {
			return false;
		}
	}

	// metoda koja vraca slova koja ne postoje
	public ArrayList<String> nonexistentLetters(String w) {
		ArrayList<String> nonexistentLetters = new ArrayList<>();
		nonexistentLetters.add(w);
		return nonexistentLetters;
	}

	// metoda koja vraca da li je pobeda
	public boolean win() {
		if (counterWin == charList.size()) {
			return true;
		} else {
			return false;
		}
	}

	// metoda koja proverava da li je poraz
	public boolean lost() {
		if (counterLost == 0) {
			return true;
		} else {
			return false;
		}
	}

}
