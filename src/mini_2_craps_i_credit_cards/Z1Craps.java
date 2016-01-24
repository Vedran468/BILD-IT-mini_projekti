package mini_2_craps_i_credit_cards;

public class Z1Craps {
	// polje podatka za ispis u slucaju pobede ili poraza
	private String win_lose ;
// get metoda koja vraca da li je pobeda ili poraz
	public String getWin_lose() {
		return win_lose;
	}

	// no arg konstruktor za pozivanje klase
	public Z1Craps() {

	}

	// metoda koja vraca dva broja od 1 do 6 koji prestavljaju brojeve na
	// kockicama
	private int[] dice() {
		int[] dice = new int[2];
		dice[0] = (int) (Math.random() * 6) + 1;
		dice[1] = (int) (Math.random() * 6) + 1;
		return dice;
	}

	// metoda koja proverava je li ostvarena pobeda u prvom bacanju
	private boolean winning(int sum) {
		// pobeda je ostvarena ako je zbir na kockicam jednak 7 ili 11
		if (sum == 7 || sum == 11) {
			return true;
		} else {
			return false;
		}
	}

	// metoda koja prova da li je korisnik izgubio u prvom bacanju
	public boolean lose(int sum) {
		if (sum == 2 || sum == 3 || sum == 12) {
			return true;
		} else {
			return false;
		}
	}

	// metoda koja vraca ime za odredjenu sumu
	public String name(int sum) {
		String name = "";
		switch (sum) {
		case 2:
			name = "Snake Eyes";
			break;
		case 3:
			name = "Ace Deuce";
			break;
		case 4:
			name = "Easy Four";
			break;
		case 5:
			name = "Five";
			break;
		case 6:
			name = "Easy Six";
			break;
		case 7:
			name = "Natural";
			break;
		case 8:
			name = "Easy Eight";
			break;
		case 9:
			name = "Nine";
			break;
		case 10:
			name = "Easy Ten";
			break;
		case 11:
			name = "Yo-leven";
			break;
		case 12:
			name = "Midnight";
			break;
		}
		return name;
	}

	/*
	 * metoda koja vraca ime za sumu koja ima dva ista clana npr 3 i 3 je Hard
	 * Six
	 */
	public String nameDoubles(int sum) {
		String name = "";
		switch (sum) {
		case 4:
			name = "Hard Four";
			break;
		case 6:
			name = "Hard Six";
			break;
		case 8:
			name = "Hard Eight";
			break;
		case 10:
			name = "Hard Ten";
			break;
		case 12:
			name = "Boxcars";
			break;
		}
		return name;
	}

	// metoda prvo bacanje
	public boolean firstRollDice(int sum) {
		// provera je li dobitno prvo bacanje ili gubitno
		if (winning(sum)) {
			win_lose = "You win!!!";
			System.out.println(getWin_lose());
			return true;
		} else if (lose(sum)) {
			win_lose = "You lose!!!";
			System.out.println(getWin_lose());
			return true;
		} else {
			/*
			 * u slucaju da nije nit dobitno nit gubitno vec da se predje na
			 * sledece bacanje ova metoda vraca u tom slucaju false
			 */
			return false;
		}
	}

	// metoda za ispis na ekranu
	public void display() {
		// varijabla za proveru nastavka bacanja
		boolean continueDice = true;
		// sprremanje rezultat metode brojeva sa kockica
		int[] result = dice();
		// racunanje zbira
		int sum = result[0] + result[1];
		/*
		 * privremena metoda koja sluzi za proveru je li pogodjen trazeni broj
		 * posle prvog bacanja
		 */
		int temp = sum;
		// varijabla za smestanje trazenog broja
		String point = "";
		// ispis dobijenih brojeva i njihov zbir
		System.out.println("You rolled " + result[0] + " + " + result[1] + " = " + sum);
		// provera da li da se predje na sledece bacanje
		if (firstRollDice(sum)) {
			continueDice = false;
		} else {
			// ako da provera kako se zove dobijena suma
			if (result[0] == result[1]) {
				point = "Point is " + sum + " (" + nameDoubles(sum) + "):";
			} else {
				point = "Point is " + sum + " (" + name(sum) + "):";
			}
			// provera da li je dobijeno ili izgubljeno
			while (continueDice) {
				System.out.println(point);
				result = dice();
				sum = result[0] + result[1];
				System.out.println("You rolled " + result[0] + " + " + result[1] + " = " + sum);
				// posle drugog bacanja da li je sada dobitno ili izgubljeno
				if (sum == temp) {
					win_lose = "You win!!!";
					System.out.println(getWin_lose());
					continueDice = false;
				} else if (sum == 7) {
					win_lose = "You lose!!!";
					System.out.println(getWin_lose());
					continueDice = false;
				} else {
					// ako nije nastavi sa bacanjem
					continueDice = true;
				}
			}
		}
	}
	
}
