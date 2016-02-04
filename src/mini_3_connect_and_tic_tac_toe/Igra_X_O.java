package mini_3_connect_and_tic_tac_toe;

public class Igra_X_O {
	// definisemo matricu sa mogucim poljimoa u X/O
	private String[][] matrix = { { "  ", "  ", "  " }, { "  ", "  ", "  " }, { "  ", "  ", "  " } };
	// definisemo niz mogucih brojeva koji prestavljaju polje u igri, odnosno
	// matrici
	private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	// niz u koji definisemo sta je korisnik odigrao
	private int[] plays = new int[9];
	
	// brojac
private int counter = 0;
	// no-arg konstruktor
	public Igra_X_O() {

	}

	// metoda koja vraca trenutni niz
	public String[][] getMatrix() {
		return matrix;
	}
	
	// metoda koja vraca brojac
	public int getCounter() {
		return counter;
	}

	// metoda koja prima polje gde se smesta X ili O podatak
	public boolean input(int n, String sign) {
		// definisemo brojac radi provere je li uspesno postavljen u matrici X
		// ili O
		// proveravamo da li je broj dobijen za polje jednak dozvoljenim
		// brojevima
		if (doesItExist(n)) {
			// provera u zavisnosti od broja za polje i stringa odnosno X ili O
			// upisujemo u matricu, npr za dobijeni broj 1 i ako je string X u
			// matricu na indekse 0 i 0 upisujemo X
			switch (n) {
			case 1:
				matrix[0][0] = sign;
				counter++;
				break;
			case 2:
				matrix[0][1] = sign;
				counter++;
				break;
			case 3:
				matrix[0][2] = sign;
				counter++;
				break;
			case 4:
				matrix[1][0] = sign;
				counter++;
				break;
			case 5:
				matrix[1][1] = sign;
				counter++;
				break;
			case 6:
				matrix[1][2] = sign;
				counter++;
				break;
			case 7:
				matrix[2][0] = sign;
				counter++;
				break;
			case 8:
				matrix[2][1] = sign;
				counter++;
				break;
			case 9:
				matrix[2][2] = sign;
				counter++;
				break;
			}
		}
		// buduci da pri svakom upisu se povecava brojac proveravao je li brojac
		// veci od 0 ako jeste metoda vraca da je tacno tj da je izvrsen upis u
		// matricu inace da je lazan pokusaj upisa tj neuspesan
		if (counter > 0) {
			return true;
		} else {
			return false;
		}
	}

	

	// metoda koja proverava da li je broj jednak dozvoljenim brojevima prilikom
	// unosa u matricu
	private boolean doesItExist(int n) {
		// brojac koji sluzi za proveru
		int counter = 0;
		// uporedjujemo dobijeni broj sa dozvoljenim brojevima u nizu
		for (int i = 0; i < array.length; i++) {
			if (array[i] == n) {
				// proveravamo da li je broj vec jednom bio unesen u niz ako
				// nije
				if (!exist(n)) {
					// povecaj brojac i unesi ga u niz
					counter++;
					plays[i] = n;
				}
			}
		}
		// ako je brojac veci od 0 metoda vraca da je broj regularan inace false
		if (counter > 0) {
			return true;
		} else {
			return false;
		}
	}

	// metoda koja proverava da li bro je vec jednom bio
	private boolean exist(int n) {
		// brojac koji sluzi za proveru
		int counter = 0;
		// prolazimo kroz niz gde su smesteni iskoristeni brojevi
		for (int i = 0; i < plays.length; i++) {
			// uporedjujemo ako broj vec postoji povecaj brojac
			if (plays[i] == n) {
				counter++;
			}
		}
		// ako je brojac veci od 0 broj vec postoji inace ne
		if (counter > 0) {
			return true;
		} else {
			return false;
		}
	}

	// provera da li ima pobednik
	public String win() {
		// string koji vraca rezultat provere
		String result = "";
		// provera po prvom redu za X
		if (matrix[0][0].equals("X") && matrix[0][1].equals("X") && matrix[0][2].equals("X")) {
			result = "win X";
			// provera za drugi red i to za X
		} else if (matrix[1][0].equals("X") && matrix[1][1].equals("X") && matrix[1][2].equals("X")) {
			result = "win X";
			// provera i za treci red i to za X
		} else if (matrix[2][0].equals("X") && matrix[2][1].equals("X") && matrix[2][2].equals("X")) {
			result = "win X";
			// Zatim na isti nacin provera i po kolonama za X
		} else if (matrix[0][0].equals("X") && matrix[1][0].equals("X") && matrix[2][0].equals("X")) {
			result = "win X";
		} else if (matrix[0][1].equals("X") && matrix[1][1].equals("X") && matrix[2][1].equals("X")) {
			result = "win X";
		} else if (matrix[0][2].equals("X") && matrix[1][2].equals("X") && matrix[2][2].equals("X")) {
			result = "win X";
			// A zatim i na isti nacin provera po dijagonalama za X
		} else if (matrix[0][0].equals("X") && matrix[1][1].equals("X") && matrix[2][2].equals("X")) {
			result = "win X";
		} else if (matrix[0][2].equals("X") && matrix[1][1].equals("X") && matrix[2][0].equals("X")) {
			result = "win X";
			// PROVERA KAO I ZA IKS SAMO SADA OKS
			// provera po redovima za O
		} else if (matrix[0][0].equals("O") && matrix[0][1].equals("O") && matrix[0][2].equals("O")) {
			result = "win O";
		} else if (matrix[1][0].equals("O") && matrix[1][1].equals("O") && matrix[1][2].equals("O")) {
			result = "win O";
		} else if (matrix[2][0].equals("O") && matrix[2][1].equals("O") && matrix[2][2].equals("O")) {
			result = "win O";
			// provera po kolonama za O
		} else if (matrix[0][0].equals("O") && matrix[1][0].equals("O") && matrix[2][0].equals("O")) {
			result = "win O";
		} else if (matrix[0][1].equals("O") && matrix[1][1].equals("O") && matrix[2][1].equals("O")) {
			result = "win O";
		} else if (matrix[0][2].equals("O") && matrix[1][2].equals("O") && matrix[2][2].equals("O")) {
			result = "win O";
			// Provera po dijagonalama za O
		} else if (matrix[0][0].equals("O") && matrix[1][1].equals("O") && matrix[2][2].equals("O")) {
			result = "win O";
		} else if (matrix[0][2].equals("O") && matrix[1][1].equals("O") && matrix[2][0].equals("O")) {
			result = "win O";
		} else {
			// Ako nema pobednika vrati NO
			result = "NO";
		}
		return result;
	}

	// metoda koja stampa matricu
	public void printMatrix() {
		System.out.println("-----------");
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(" | ");
			for (int j = 0; j < matrix[i].length; j++) {
				// Stampamo matricu
				System.out.print(matrix[i][j] + " | ");
			}
			System.out.println("\n-----------");
		}
	}

}
