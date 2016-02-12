package mini_4_Battleship_i_Hangman;

import java.io.FileNotFoundException;

/**
 * @author Vedran Vidakovic
 *
 */
public class Z2IgrajHangman {

	public static void main(String[] args) throws FileNotFoundException {

		Z2_JD_AgainHangman a = new Z2_JD_AgainHangman();

		try {
			// pozivamo metodu da ponovo pokrene
			a.again();
			// posto koristi opet txt dokument ispisi u slucaju greske
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
