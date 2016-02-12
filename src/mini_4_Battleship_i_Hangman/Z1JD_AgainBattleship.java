package mini_4_Battleship_i_Hangman;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Vedran Vidakovic
 *
 */
public class Z1JD_AgainBattleship {

	// data field za prozor
	private JFrame window3 = new JFrame("Result");
	// polje u kojem smestamo rezultat
	private JLabel result = new JLabel("");

	// polja za ponovnu igru
	private JButton buttonAgain = new JButton("Again");

	// podesavenje slova
	private Font font = new Font("Serif", Font.BOLD, 32);

	// objekat klse za koju pozivamo metode
	Z1Battleship b = new Z1Battleship();

	// no-arg konstruktor
	public Z1JD_AgainBattleship() {

	}

	public void again() {
		// raspored u prozoru ne definisan
		window3.setLayout(null);

		// dodajemo elemente za prozor 3
		window3.add(result);
		window3.add(buttonAgain);

		// podesavamo gde ce se sta nalaziti
		result.setBounds(10, 50, 390, 50);
		buttonAgain.setBounds(100, 150, 100, 50);
		// definisemo da kad se zatvori prozor3 zaustavi program
		window3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// velicina prozora
		window3.setSize(400, 300);
		// i vidljivost da
		window3.setVisible(true);

		// podesi slova rezultat
		result.setFont(font);

		// dugme za ponovnu igru
		ActionListener al2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// sakrivamo ekran
				window3.setVisible(false);
				// ponovo pokrecemo igricu
				Z1JD_UnosBrodica o = new Z1JD_UnosBrodica();
				o.displeyInputShips();
			}
		};
		buttonAgain.addActionListener(al2);

	}

	// metoda koja vraca polje sa informacijama
	public JLabel getResult() {
		return result;
	}
}
