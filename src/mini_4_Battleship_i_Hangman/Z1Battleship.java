package mini_4_Battleship_i_Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Vedran Vidakovic
 *
 */
public class Z1Battleship {
	// data fields za
	// brojac unosa brodica
	private int counterEntry = 5;
	// matrica za smestanje brodica racunara
	private char[][] charComp = new char[10][10];
	// matrica za smestanje brodica korisnika
	private char[][] charPlayer = { { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
			{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
			{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
			{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
			{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
			{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' } };

	// brojac pogodejnih polja racunara
	private int winComp = 17;
	// brojac pogodejnih polja korisnika
	private int winPlayer = 17;
	// brojac unosa polja koja je kompjuter izabrao
	private int cHave = 0;
	// provera je li ostvaren unoz horizontalni i vertikalni
	private boolean okV = false;
	private boolean okH = false;

	// smestanje izbranih polja racunara
	private int[] have = new int[100];
	// provera unosa slova
	private String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
	// provera unosa brojeva
	private int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	// za smestanje pozicije vertilkalne ili horizontalne
	private String position = "";
	// smestanje po x kordinate
	private String x = "";
	// smestanje po y kordinate
	private int y = 0;
	// brojac ponavljanja broda od 3 polja
	private int c3 = 0;

	// no-arg konstruktor
	public Z1Battleship() {

	}

	// metoda kioja vraca poziciju
	public String getPosition() {
		return position;
	}

	// metode koje vracaju je li ostvaren unos
	public boolean isOkH() {
		return okH;
	}

	public boolean isOkV() {
		return okV;
	}

	// metoda koja dobijenin string pretvara u niz karaktera
	private static char[] convertingTheCharacters(ArrayList<String> line, int number) {
		// na osnovu broja koji definise opcije rasporeda brodova taj raspored
		// pretvori u niz karaktera
		char[] chars = line.get(number).toCharArray();
		return chars;
	}

	// metoda koja vraca raspored brodova
	public char[][] listCharakersComp() throws FileNotFoundException {
		// trazimo fajl sa ovom apsolutnom adresom
		File file = new File("pokolj na moru1.txt");
		Scanner input2 = new Scanner(file);
		// string lista svih pozicija brodica koji se nalaze dokumentu
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
		// iscitavamo te karakere i dodajemomatrici karaktera
		int counter = 0;
		for (int i = 0; i < charComp.length; i++) {
			for (int j = 0; j < charComp[i].length; j++) {
				charComp[i][j] = chars[counter];
				counter++;
			}
		}
		return charComp;
	}

	// provera unosa kordinate y
	public boolean checkY(int y) {
		this.y = y;
		int counter = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == this.y) {
				counter++;
			}
		}
		if (counter == 1) {
			return true;
		} else {
			return false;
		}
	}

	// provera unosa kordinate x
	public boolean checkX(String x) {
		this.x = x;
		int counter = 0;
		for (int i = 0; i < letters.length; i++) {
			if (letters[i].equals(this.x)) {
				counter++;
			}
		}
		if (counter == 1) {
			return true;
		} else {
			return false;
		}
	}

	// pretvaranje dobijeniih kordinata u brojeve matrice
	public void convertPosition() {
		int x1 = 0;
		this.y = this.y - 1;
		switch (this.x) {
		case "A":
			x1 = 0;
			break;
		case "B":
			x1 = 1;
			break;
		case "C":
			x1 = 2;
			break;
		case "D":
			x1 = 3;
			break;
		case "E":
			x1 = 4;
			break;
		case "F":
			x1 = 5;
			break;
		case "G":
			x1 = 6;
			break;
		case "H":
			x1 = 7;
			break;
		case "I":
			x1 = 8;
			break;
		case "J":
			x1 = 9;
			break;
		}
		inputMatrix(x1, y);
	}

	// provera da li su polja ispod slobodna kod vertikalnog polozaja
	private boolean checkDV(int x, int y) {
		if (charPlayer[y + counterEntry][x] == 'O') {
			return true;
		} else {
			return false;
		}
	}

	// provera da li su polja iznad slobodna kod vertikalnog polozaja
	private boolean checkUV(int x, int y) {
		if (charPlayer[y - 1][x] == 'O') {
			return true;
		} else {
			return false;
		}
	}

	// provera da li su polja desmo slobodna kod horizontalnog polozaja
	private boolean checkRH(int x, int y) {
		if (charPlayer[y][x + counterEntry] == 'O') {
			return true;
		} else {
			return false;
		}
	}

	// provera da li su polja levo slobodna kod horizontalnog polozaja
	private boolean checkLH(int x, int y) {
		if (charPlayer[y][x - 1] == 'O') {
			return true;
		} else {
			return false;
		}
	}

	// provera da li su polja desno slobodna kod vertikalnog polozaja
	private boolean checkRV(int x, int y) {
		int counter = 0;
		for (int i = 0; i < counterEntry; i++) {
			if (charPlayer[y + i][x + 1] == ' ' || charPlayer[y + i][x + 1] == 'O') {
				counter++;
			}
		}
		if (counter != counterEntry) {
			return false;
		} else {
			return true;
		}
	}

	// provera da li su polja levo slobodna kod vertikalnog polozaja
	private boolean checkLV(int x, int y) {
		int counter = 0;
		for (int i = 0; i < counterEntry; i++) {
			if (charPlayer[y + i][x - 1] == ' ' || charPlayer[y + i][x - 1] == 'O') {
				counter++;
			}
		}
		if (counter != counterEntry) {
			return false;
		} else {
			return true;
		}
	}

	// provera da li su polja ispod slobodna kod horizontalnog polozaja
	private boolean checkDHor(int x, int y) {
		int counter = 0;
		for (int i = 0; i < counterEntry; i++) {
			if (charPlayer[y + 1][x + i] == ' ' || charPlayer[y + 1][x + i] == 'O') {
				counter++;
			}
		}
		if (counter != counterEntry) {
			return false;
		} else {
			return true;
		}
	}

	// provera da li su polja iznad slobodna kod horizontalnog polozaja
	private boolean checkUH(int x, int y) {
		int counter = 0;
		for (int i = 0; i < counterEntry; i++) {
			if (charPlayer[y - 1][x + i] == ' ' || charPlayer[y - 1][x + i] == 'O') {
				counter++;
			}
		}
		if (counter != counterEntry) {
			return false;
		} else {
			return true;
		}
	}

	// unos u matricu
	private void inputMatrix(int x, int y) {
		// provera slobodnih polja
		boolean lV = false;
		boolean lH = false;
		boolean rV = false;
		boolean rH = false;
		boolean uV = false;
		boolean uH = false;
		boolean dV = false;
		boolean dH = false;
		// u slucaju vaertikalnog polozaja
		if (getPosition().equals("Vv")) {
			// provera da li je desna strana slobodna
			if (x < 9) {
				if (checkRV(x, y)) {
					rV = true;
				}
			} else {
				rV = true;
			}

			if (x > 0) {
				if (checkLV(x, y)) {
					lV = true;
				}
			} else {
				lV = true;
			}

			// provera donjih polja
			if ((y + counterEntry) <= 9) {
				if (checkDV(x, y)) {
					dV = true;
				}
			} else {
				dV = true;
			}

			// provera gornjih polja
			if (y > 0) {
				if (checkUV(x, y)) {
					uV = true;
				}
			} else {
				uV = true;
			}

			// ako je sve ok smesti iksice
			if (rV && lV && uV && dV) {
				for (int i = 0; i < counterEntry; i++) {
					charPlayer[y + i][x] = 'X';
				}
				// postavi unos tacan i smanji broj brodica
				okV = true;
				counterEntry--;
			} else {
				okV = false;
			}

			// u slucaju da drugi put treba uneti brod od 3 polja
			if (counterEntry == 2 && c3 == 0) {
				counterEntry = 3;
				c3++;
			}
			// u slucaju pozicije horizontalno
		} else if (getPosition().equals("h")) {
			// provera desnih polja
			if ((x + counterEntry) <= 9) {
				if (checkRH(x, y)) {
					rH = true;
				}
			} else {
				rH = true;
			}

			// provera levih polja
			if (x > 0) {
				if (checkLH(x, y)) {
					lH = true;
				}
			} else {
				lH = true;
			}

			// provera gornjih polja
			if (y > 0) {
				if (checkUH(x, y)) {
					uH = true;
				}
			} else {
				uH = true;
			}

			// provera donjih polja
			if (y < 9) {
				if (checkDHor(x, y)) {
					dH = true;
				}
			} else {
				dH = true;
			}

			// ako je sve ok postavi brodice smanji broj brodica i postavi unos
			// tacan
			if (rH && lH && uH && dH) {
				for (int i = 0; i < counterEntry; i++) {
					this.charPlayer[y][x + i] = 'X';
				}
				okH = true;
				counterEntry--;
			} else {
				okH = false;
			}

			// u slucaju da drugi puta treba brodic od 3 polja
			if (counterEntry == 2 && c3 == 0) {
				counterEntry = 3;
				c3++;
			}
		} else {
			System.out.println("Error!!!");
		}
	}

	// postavlja poziciju
	public void setPosition(String position) {
		this.position = position;
	}

	// provera je li ostvaren pogodak kompjutera
	public boolean hitComp(int i, int j) {
		if (charPlayer[i][j] == 'X') {
			winComp--;
			return true;
		} else {
			return false;
		}
	}

	// provera je li ostvaren pogodak kompjutera
	public boolean winComp() {
		if (winComp == 0) {
			return true;
		} else {
			return false;
		}
	}

	// provera je li korisnik pobedio
	public boolean winPlayer() {
		if (winPlayer == 0) {
			return true;
		} else {
			return false;
		}
	}

	// posto iz trece klase se poziva matrica a iz druge smestaju podaci
	// najlakse da se pamte jesete smestanje u txt dokument
	public void storingShips() throws FileNotFoundException {
		java.io.File file = new java.io.File("unos brodica.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		for (int i = 0; i < charPlayer.length; i++) {
			for (int j = 0; j < charPlayer[i].length; j++) {
				output.print(charPlayer[i][j] + " ");
			}
		}
		output.close();
	}

	// provera je li korisnik pogodio
	public boolean hitPlayer(int i, int j) {
		if (charComp[i][j] == 'X') {
			winPlayer--;
			return true;
		} else {
			return false;
		}
	}

	// metoda koja proverava da li je vec dodato taj broj
	private boolean have(int n) {
		int counter = 0;
		for (int i = 0; i < have.length; i++) {
			if (have[i] == n) {
				counter++;
			}
		}
		if (counter > 0) {
			return true;
		} else {
			return false;
		}
	}

	// vraca broj polja koje kompjuter napada 
	public int attack() {
		int n = (int) (Math.random() * 100);
		if (have(n)) {
			while (have(n)) {
				n = (int) (Math.random() * 100);
				if (!have(n)) {
					have[cHave] = n;
					cHave++;
					break;
				}
			}
		} else {
			have[cHave] = n;
			cHave++;
		}
		return n;
	}

	// vraca brojac unosa brodova
	public int getCounterEntry() {
		return counterEntry;
	}

	// vraca matricu za prikaz unosa
	public char[][] getCharPlayer() {
		return charPlayer;
	}

}
