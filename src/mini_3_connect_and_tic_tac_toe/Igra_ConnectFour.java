package mini_3_connect_and_tic_tac_toe;

public class Igra_ConnectFour {
	// definisemo matricu sa pocetnim vrednostima
	private String[][] matrix = { { "  ", "  ", "  ", "  ", "  ", "  ", "  " },
			{ "  ", "  ", "  ", "  ", "  ", "  ", "  " }, { "  ", "  ", "  ", "  ", "  ", "  ", "  " },
			{ "  ", "  ", "  ", "  ", "  ", "  ", "  " }, { "  ", "  ", "  ", "  ", "  ", "  ", "  " },
			{ "  ", "  ", "  ", "  ", "  ", "  ", "  " } };
	private int totalCounter= 0;

	// definisemo brojace za kolone koji omogucavaju upis u matricu od
	// poslednjeg reda ka prvom
	private int counter1 = 5;
	private int counter2 = 5;
	private int counter3 = 5;
	private int counter4 = 5;
	private int counter5 = 5;
	private int counter6 = 5;
	private int counter7 = 5;

	// no-arg konstruktor
	public Igra_ConnectFour() {

	}

	// metoda koja vraca brojac
		public int getCounter() {
			return totalCounter;
		}
	
	// metoda koja smesta u matricu podatke da li je crvena ili zuta boja
	public boolean input(int n, String sign) {
		// ako je dobijeni broj od 1 do 6 ucini u zavisnosti od broja
		switch (n) {
		case 1:
			// ako je jedan dobijeni broj a brojac za prvu kolonu veci od -1
			if (counter1 > -1) {
				// izvrsi upis dobijenog stringa
				matrix[counter1][0] = sign;
				// zmanji brojac indeksa a povecaj brojac u metodi
				counter1--;
				totalCounter++;
			}
			break;
		// i atkoi za ostale varijante dobijenog broja
		case 2:
			if (counter2 > -1) {
				matrix[counter2][1] = sign;
				counter2--;
				totalCounter++;
			}
			break;
		case 3:
			if (counter3 > -1) {
				matrix[counter3][2] = sign;
				counter3--;
				totalCounter++;
			}
			break;
		case 4:
			if (counter4 > -1) {
				matrix[counter4][3] = sign;
				counter4--;
				totalCounter++;
			}
			break;
		case 5:
			if (counter5 > -1) {
				matrix[counter5][4] = sign;
				counter5--;
				totalCounter++;
			}
			break;
		case 6:
			if (counter6 > -1) {
				matrix[counter6][5] = sign;
				counter6--;
				totalCounter++;
			}
			break;
		case 7:
			if (counter7 > -1) {
				matrix[counter7][6] = sign;
				counter7--;
				totalCounter++;
			}
			break;
		}

		if (totalCounter > 0) {
			return true;
		} else {
			return false;
		}

	}

	// metoda koja proverava je li ima pobednik
	public String win() {
		// string za smestanje rezultata metode
		String result = "";
		// brojac koji broji je li ima pobednika za crvenu boju
		int counterR = 0;
		// brojac koji broji je li ima pobednika za zutu boju
		int counterY = 0;
		// stringovi za proveru u matrici
		String signR = "R";
		String signY = "Y";
		// provera po redovima, kolonama, dijagnalama i kontra dijagonalama za
		// crvenu boju preko metoda
		if (checkRows(signR)) {
			counterR++;
		} else if (checkColumns(signR)) {
			counterR++;
		} else if (checksDiagonals1(signR)) {
			counterR++;
		} else if (checksDiagonals2(signR)) {
			counterR++;
		} else if (checksDiagonals3(signR)) {
			counterR++;
		} else if (checksDiagonals4(signR)) {
			counterR++;
		} else if (checksDiagonals5(signR)) {
			counterR++;
		} else if (checksDiagonals6(signR)) {
			counterR++;
		} else if (checksByConsDiagonal1(signR)) {
			counterR++;
		} else if (checksByConsDiagonal2(signR)) {
			counterR++;
		} else if (checksByConsDiagonal3(signR)) {
			counterR++;
		} else if (checksByConsDiagonal4(signR)) {
			counterR++;
		} else if (checksByConsDiagonal5(signR)) {
			counterR++;
		} else if (checksByConsDiagonal6(signR)) {
			counterR++;
			// provera po redovima, kolonama, dijagnalama i kontra dijagonalama za
			// zutu boju preko metoda
		} else if (checkRows(signY)) {
			counterY++;
		} else if (checkColumns(signY)) {
			counterY++;
		} else if (checksDiagonals1(signY)) {
			counterY++;
		} else if (checksDiagonals2(signY)) {
			counterY++;
		} else if (checksDiagonals3(signY)) {
			counterY++;
		} else if (checksDiagonals4(signY)) {
			counterY++;
		} else if (checksDiagonals5(signY)) {
			counterY++;
		} else if (checksDiagonals6(signY)) {
			counterY++;
		} else if (checksByConsDiagonal1(signY)) {
			counterY++;
		} else if (checksByConsDiagonal2(signY)) {
			counterY++;
		} else if (checksByConsDiagonal3(signY)) {
			counterY++;
		} else if (checksByConsDiagonal4(signY)) {
			counterY++;
		} else if (checksByConsDiagonal5(signY)) {
			counterY++;
		} else if (checksByConsDiagonal6(signY)) {
			counterY++;
		}

		// provera je li imamo pobednika u zavisnosti od brojaca 
		if (counterR == 1) {
			result = "Win R";
		} else if (counterY == 1) {
			result = "Win Y";
		} else {
			// ako ne vrati no
			result = "NO";
		}
		// metoda vraca rezultat bstring
		return result;
	}
// metoda koja proverava po redovima  je li ima 4 ista znaka u matrici
	private boolean checkRows(String sign) {
		int counter = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				if (matrix[i][j].equals(sign)) {
					if (matrix[i][j].equals(matrix[i][j + 1])) {
						counter++;
						if (counter == 4) {
							break;
						}
					} else {
						counter = 1;
					}
				}
			}
			if (counter == 4) {
				break;
			}
			counter = 1;
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// metoda koja proverava po kolonama je li ima ista 4 znaka u matrici
	private boolean checkColumns(String sign) {
		int counter = 1;

		for (int j = 0; j < matrix[0].length; j++) {
			for (int i = 0; i < matrix.length - 1; i++) {
				if (matrix[i][j].equals(sign)) {
					if (matrix[i][j].equals(sign) && matrix[i + 1][j].equals(sign)) {
						counter++;
						if (counter == 4) {
							break;
						}
					} else {
						counter = 1;

					}
				}
			}
			if (counter == 4) {
				break;
			}
			counter = 1;
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// provera za prvu kontra dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksByConsDiagonal1(String sign) {
		int counter = 0;
		for (int i = 3, j = 0; i >= 0; i--, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// provera za drugu kontra dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksByConsDiagonal2(String sign) {
		int counter = 0;
		for (int i = 4, j = 0; i >= 0; i--, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// provera za trecu kontra dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksByConsDiagonal3(String sign) {
		int counter = 0;
		for (int i = 5, j = 0; i >= 0; i--, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}

		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// provera za cetvrtu kontra dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksByConsDiagonal4(String sign) {
		int counter = 0;
		for (int i = 5, j = 1; i >= 0; i--, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// provera za petu kontra dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksByConsDiagonal5(String sign) {
		int counter = 0;
		for (int i = 5, j = 2; i >= 1; i--, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}

		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// provera za sestu kontra dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksByConsDiagonal6(String sign) {
		int counter = 0;
		for (int i = 5, j = 3; i >= 2; i--, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// provera za prvu dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksDiagonals1(String sign) {
		int counter = 0;
		for (int i = 2, j = 0; i <= 5; i++, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// provera za drugu dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksDiagonals2(String sign) {
		int counter = 0;
		for (int i = 1, j = 0; i <= 5; i++, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// provera za trecu dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksDiagonals3(String sign) {
		int counter = 0;
		for (int i = 0, j = 0; i <= 5; i++, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// get metode koje vracaju brojace
	public int getCounter1() {
		return counter1;
	}

	public int getCounter2() {
		return counter2;
	}

	public int getCounter3() {
		return counter3;
	}

	public int getCounter4() {
		return counter4;
	}

	public int getCounter5() {
		return counter5;
	}

	public int getCounter6() {
		return counter6;
	}

	public int getCounter7() {
		return counter7;
	}

	// provera za cetvrtu dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksDiagonals4(String sign) {
		int counter = 0;
		for (int i = 0, j = 1; i <= 5; i++, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// provera za petu dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksDiagonals5(String sign) {
		int counter = 0;
		for (int i = 0, j = 2; i <= 4; i++, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// provera za setu dijagonalu matrice koja moze imati 4 ista znaka
	private boolean checksDiagonals6(String sign) {
		int counter = 0;
		for (int i = 0, j = 3; i <= 3; i++, j++) {
			if (matrix[i][j].equals(sign)) {
				counter++;
				if (counter == 4) {
					break;
				}
			} else {
				counter = 0;
			}
		}
		if (counter == 4) {
			return true;
		} else {
			return false;
		}
	}

	// metoda koja stampa matricu
	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(" | ");
			for (int j = 0; j < matrix[i].length; j++) {
				if (!matrix[i][j].equals("  ")) {
					// Stampamo matricu
					System.out.printf("%1s | ", matrix[i][j]);
				} else {
					System.out.print(matrix[i][j] + " | ");
				}
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}
}
