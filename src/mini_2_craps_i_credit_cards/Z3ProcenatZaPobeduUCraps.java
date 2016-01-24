package mini_2_craps_i_credit_cards;

public class Z3ProcenatZaPobeduUCraps {

	public static void main(String[] args) {
		// pravimo objekat klase gde smestena igra
		Z1Craps c = new Z1Craps();
		// brojac pobeda
		int win = 0;
		// 10000 puta se kladimo
		for (int i = 0; i < 10000; i++) {
			// p[ozivamo metodu da ispise rezultat
			c.display();
			// prazan red radi preglednosti
			System.out.println();
			// ako je jednak pobeda povecaj brojac
			if (c.getWin_lose().endsWith("You win!!!")) {
				win++;
			}
		}
		// racunamo koliko je u procentima ostavreno pobeda
		double percentage = (10000 - (10000 - (double) win)) / 100;
		// stampamo rezultat
		System.out.println(
				"\nFrom 10000 bets, you have achieved " + win + " victories, which means " + percentage + "[%] !!!");
	}

}
