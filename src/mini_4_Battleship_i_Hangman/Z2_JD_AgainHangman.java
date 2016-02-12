package mini_4_Battleship_i_Hangman;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Vedran Vidakovic
 *
 */
public class Z2_JD_AgainHangman {

	// no-arg konstruktor
	public Z2_JD_AgainHangman() {

	}

	public void again() throws FileNotFoundException {

		// stringovi za ispis na prozoru igrice
		String s1 = "Unesite jedno slovo i pritisnite posalji:";
		String s2 = "Greska!!!";
		String s3 = "Misses: ";

		// definisemo dva prozora za igru
		JFrame window = new JFrame("Hangman");
		JFrame window2 = new JFrame("Result");

		// definisemo da njihov raspored nije definisan
		window.setLayout(null);
		window2.setLayout(null);

		// polje za informacije ko je na potezu
		JLabel information = new JLabel(s1);
		// spisak slova koja su ukucana a nisu bila u reci
		JLabel misses = new JLabel(s3);

		// polje za unos slova
		final JTextField letter = new JTextField(20);
		// dugme posalji slovo
		JButton sent = new JButton("Posalji");

		// dugmad koja prikazuju koliko slova treba pogoditi
		JButton b0 = new JButton("");
		JButton b1 = new JButton("");
		JButton b2 = new JButton("");
		JButton b3 = new JButton("");
		JButton b4 = new JButton("");
		JButton b5 = new JButton("");
		JButton b6 = new JButton("");
		JButton b7 = new JButton("");
		JButton b8 = new JButton("");
		JButton b9 = new JButton("");
		JButton b10 = new JButton("");
		JButton b11 = new JButton("");
		JButton b12 = new JButton("");
		JButton b13 = new JButton("");
		JButton b14 = new JButton("");
		JButton b15 = new JButton("");
		JButton b16 = new JButton("");
		JButton b17 = new JButton("");
		JButton b18 = new JButton("");
		JButton b19 = new JButton("");
		JButton b20 = new JButton("");

		// polja gde se smestaju slova trazene reci
		JTextArea field0 = new JTextArea(20, 55);
		JTextArea field1 = new JTextArea(20, 55);
		JTextArea field2 = new JTextArea(20, 55);
		JTextArea field3 = new JTextArea(20, 55);
		JTextArea field4 = new JTextArea(20, 55);
		JTextArea field5 = new JTextArea(20, 55);
		JTextArea field6 = new JTextArea(20, 55);
		JTextArea field7 = new JTextArea(20, 55);
		JTextArea field8 = new JTextArea(20, 55);
		JTextArea field9 = new JTextArea(20, 55);
		JTextArea field10 = new JTextArea(20, 55);
		JTextArea field11 = new JTextArea(20, 55);
		JTextArea field12 = new JTextArea(20, 55);
		JTextArea field13 = new JTextArea(20, 55);
		JTextArea field14 = new JTextArea(20, 55);
		JTextArea field15 = new JTextArea(20, 55);
		JTextArea field16 = new JTextArea(20, 55);
		JTextArea field17 = new JTextArea(20, 55);
		JTextArea field18 = new JTextArea(20, 55);
		JTextArea field19 = new JTextArea(20, 55);
		JTextArea field20 = new JTextArea(20, 55);

		// slike koje se prikazuju
		ImageIcon imageIcon0 = new ImageIcon("slike hangman\\Hangman-0.png");
		ImageIcon imageIcon1 = new ImageIcon("slike hangman\\Hangman-1.png");
		ImageIcon imageIcon2 = new ImageIcon("slike hangman\\Hangman-2.png");
		ImageIcon imageIcon3 = new ImageIcon("slike hangman\\Hangman-3.png");
		ImageIcon imageIcon4 = new ImageIcon("slike hangman\\Hangman-4.png");
		ImageIcon imageIcon5 = new ImageIcon("slike hangman\\Hangman-5.png");
		ImageIcon imageIcon6 = new ImageIcon("slike hangman\\Hangman-6.png");
		// slike prikazujemo kao tekst
		JLabel image0 = new JLabel(imageIcon0);
		JLabel image1 = new JLabel(imageIcon1);
		JLabel image2 = new JLabel(imageIcon2);
		JLabel image3 = new JLabel(imageIcon3);
		JLabel image4 = new JLabel(imageIcon4);
		JLabel image5 = new JLabel(imageIcon5);
		JLabel image6 = new JLabel(imageIcon6);

		// podesavanje velicine i pozicije slika
		image0.setBounds(200, 10, 300, 300);
		image1.setBounds(200, 10, 300, 300);
		image2.setBounds(200, 10, 300, 300);
		image3.setBounds(200, 10, 300, 300);
		image4.setBounds(200, 10, 300, 300);
		image5.setBounds(200, 10, 300, 300);
		image6.setBounds(200, 10, 300, 300);

		// dodoavanje prvom prozoru slike
		window.add(image0);
		window.add(image1);
		window.add(image2);
		window.add(image3);
		window.add(image4);
		window.add(image5);
		window.add(image6);

		// vidljivost da je samo slike pocetne ostale sakrij
		image0.setVisible(true);
		image1.setVisible(false);
		image2.setVisible(false);
		image3.setVisible(false);
		image4.setVisible(false);
		image5.setVisible(false);
		image6.setVisible(false);

		// polje u kojem smestamo rezultat
		final JLabel result = new JLabel("");

		// polja za ponovnu igru
		JButton buttonAgain = new JButton("Again");

		// dododavanje ostalih elemenata prvom prozoru
		window.add(information);
		window.add(letter);
		window.add(sent);
		window.add(misses);

		// podesavanje velicine koponenti i pozicije
		information.setBounds(160, 400, 600, 50);
		misses.setBounds(160, 360, 600, 50);
		letter.setBounds(160, 460, 40, 50);
		sent.setBounds(210, 460, 200, 50);

		// velicina prozora
		window.setSize(800, 600);
		// vidljivos da
		window.setVisible(true);

		// dodajemo elemente za prozor 2
		window2.add(result);
		window2.add(buttonAgain);

		// podesavamo gde ce se sta nalaziti
		result.setBounds(10, 50, 390, 50);
		buttonAgain.setBounds(100, 150, 100, 50);
		// definisemo da kad se zatvori prozor2 zaustavi program
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// velicina prozora
		window2.setSize(400, 300);
		// i vidljivost ne
		window2.setVisible(false);

		// dve velicine i oblik slova
		Font font = new Font("Serif", Font.BOLD, 32);
		Font font1 = new Font("Serif", Font.BOLD, 24);

		// dodavanje oblika i velicine slova pojedinim elementima tekstualnim
		field0.setFont(font);
		field1.setFont(font);
		field2.setFont(font);
		field3.setFont(font);
		field4.setFont(font);
		field5.setFont(font);
		field6.setFont(font);
		field7.setFont(font);
		field8.setFont(font);
		field9.setFont(font);
		field10.setFont(font);
		field11.setFont(font);
		field12.setFont(font);
		field13.setFont(font);
		field14.setFont(font);
		field15.setFont(font);
		field16.setFont(font);
		field17.setFont(font);
		field18.setFont(font);
		field19.setFont(font);
		field20.setFont(font);
		information.setFont(font1);
		misses.setFont(font1);
		letter.setFont(font);
		sent.setFont(font1);
		result.setFont(font);

		// objekat glavne klase
		Z2Hangman h = new Z2Hangman();

		// iscitavamo slova koja se traze
		ArrayList<Character> listCharakers = h.listCharakers();
		// string u koji smestamo slovo
		String string = "";

		for (int i = 0; i < listCharakers.size(); i++) {
			// smestamo slovo tj karakter pretvaramo u string
			string = listCharakers.get(i) + "";
			// ako nije prazno polje
			if (!listCharakers.get(i).equals(' ')) {
				// na osnovu indeksa dodaj slovo polju za slovo i njega sakrij a
				// postavi dugme
				switch (i) {
				case 0:
					window.add(field0);
					field0.setText(string.toUpperCase());
					field0.setBounds(50, 300, 30, 50);
					field0.setVisible(false);
					window.add(b0);
					b0.setBounds(50, 300, 30, 50);
					break;
				case 1:
					window.add(field1);
					field1.setText(string.toUpperCase());
					field1.setBounds(85, 300, 30, 50);
					field1.setVisible(false);
					window.add(b1);
					b1.setBounds(85, 300, 30, 50);
					break;
				case 2:
					window.add(field2);
					field2.setText(string.toUpperCase());
					field2.setBounds(120, 300, 30, 50);
					field2.setVisible(false);
					window.add(b2);
					b2.setBounds(120, 300, 30, 50);
					break;
				case 3:
					window.add(field3);
					field3.setText(string.toUpperCase());
					field3.setBounds(155, 300, 30, 50);
					field3.setVisible(false);
					window.add(b3);
					b3.setBounds(155, 300, 30, 50);
					break;
				case 4:
					window.add(field4);
					field4.setText(string.toUpperCase());
					field4.setBounds(190, 300, 30, 50);
					field4.setVisible(false);
					window.add(b4);
					b4.setBounds(190, 300, 30, 50);
					break;
				case 5:
					window.add(field5);
					field5.setText(string.toUpperCase());
					field5.setBounds(225, 300, 30, 50);
					window.add(b5);
					field5.setVisible(false);
					b5.setBounds(225, 300, 30, 50);
					break;
				case 6:
					window.add(field6);
					field6.setText(string.toUpperCase());
					field6.setBounds(260, 300, 30, 50);
					window.add(b6);
					field6.setVisible(false);
					b6.setBounds(260, 300, 30, 50);
					break;
				case 7:
					window.add(field7);
					field7.setText(string.toUpperCase());
					field7.setBounds(295, 300, 30, 50);
					window.add(b7);
					field7.setVisible(false);
					b7.setBounds(295, 300, 30, 50);
					break;
				case 8:
					window.add(field8);
					field8.setText(string.toUpperCase());
					field8.setBounds(330, 300, 30, 50);
					window.add(b8);
					field8.setVisible(false);
					b8.setBounds(330, 300, 30, 50);
					break;
				case 9:
					window.add(field9);
					field9.setText(string.toUpperCase());
					field9.setBounds(365, 300, 30, 50);
					window.add(b9);
					field9.setVisible(false);
					b9.setBounds(365, 300, 30, 50);
					break;
				case 10:
					window.add(field10);
					field10.setText(string.toUpperCase());
					field10.setBounds(400, 300, 30, 50);
					window.add(b10);
					field10.setVisible(false);
					b10.setBounds(400, 300, 30, 50);
					break;
				case 11:
					window.add(field11);
					field11.setText(string.toUpperCase());
					field11.setBounds(435, 300, 30, 50);
					window.add(b11);
					field11.setVisible(false);
					b11.setBounds(435, 300, 30, 50);
					break;
				case 12:
					window.add(field12);
					field12.setText(string.toUpperCase());
					field12.setBounds(470, 300, 30, 50);
					window.add(b12);
					field12.setVisible(false);
					b12.setBounds(470, 300, 30, 50);
					break;
				case 13:
					window.add(field13);
					field13.setText(string.toUpperCase());
					field13.setBounds(505, 300, 30, 50);
					window.add(b13);
					field13.setVisible(false);
					b13.setBounds(505, 300, 30, 50);
					break;
				case 14:
					window.add(field14);
					field14.setText(string.toUpperCase());
					field14.setBounds(540, 300, 30, 50);
					window.add(b14);
					field14.setVisible(false);
					b14.setBounds(540, 300, 30, 50);
					break;
				case 15:
					window.add(field15);
					field15.setText(string.toUpperCase());
					field15.setBounds(575, 300, 30, 50);
					window.add(b15);
					field15.setVisible(false);
					b15.setBounds(575, 300, 30, 50);
					break;
				case 16:
					window.add(field16);
					field16.setText(string.toUpperCase());
					field16.setBounds(610, 300, 30, 50);
					window.add(b16);
					field16.setVisible(false);
					b16.setBounds(610, 300, 30, 50);
					break;
				case 17:
					window.add(field17);
					field17.setText(string.toUpperCase());
					field17.setBounds(645, 300, 30, 50);
					window.add(b17);
					field17.setVisible(false);
					b17.setBounds(645, 300, 30, 50);
					break;
				case 18:
					window.add(field18);
					field18.setText(string.toUpperCase());
					field18.setBounds(680, 300, 30, 50);
					window.add(b18);
					field18.setVisible(false);
					b18.setBounds(680, 300, 30, 50);
					break;
				case 19:
					window.add(field19);
					field19.setText(string.toUpperCase());
					field19.setBounds(715, 300, 30, 50);
					window.add(b19);
					field19.setVisible(false);
					b19.setBounds(715, 300, 30, 50);
					break;
				case 20:
					window.add(field20);
					field20.setText(string.toUpperCase());
					field20.setBounds(750, 300, 30, 50);
					window.add(b20);
					field20.setVisible(false);
					b20.setBounds(750, 300, 30, 50);
					break;
				}
				// ako je prazno polje posalji u metodu prazno polje
			} else {
				h.indexs(" ");
			}
		}

		// u slucaju kad se pritisne dugme sent
		ActionListener al1 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				// proveri je li unos jedno slovo
				if (h.checkingEntries(letter.getText())) {
					try {
						// proveravamo na kojem indeksu je slovo trazeno
						ArrayList<Integer> input = h.indexs(letter.getText().toLowerCase());
						// ako postoji slovo
						if (!input.isEmpty()) {
							// prolazimo kroz listu
							for (int i = 0; i < input.size(); i++) {
								// u zavisnosti koji je broj postavi vidljivo
								// slovo tog polja ili indeksa a dugme koje ga
								// je sakrivalo skloni
								switch (input.get(i)) {
								case 0:
									field0.setVisible(true);
									b0.setVisible(false);
									break;
								case 1:
									field1.setVisible(true);
									b1.setVisible(false);
									break;
								case 2:
									field2.setVisible(true);
									b2.setVisible(false);
									break;
								case 3:
									field3.setVisible(true);
									b3.setVisible(false);
									break;
								case 4:
									field4.setVisible(true);
									b4.setVisible(false);
									break;
								case 5:
									field5.setVisible(true);
									b5.setVisible(false);
									break;
								case 6:
									field6.setVisible(true);
									b6.setVisible(false);
									break;
								case 7:
									field7.setVisible(true);
									b7.setVisible(false);
									break;
								case 8:
									field8.setVisible(true);
									b8.setVisible(false);
									break;
								case 9:
									field9.setVisible(true);
									b9.setVisible(false);
									break;
								case 10:
									field10.setVisible(true);
									b10.setVisible(false);
									break;
								case 11:
									field11.setVisible(true);
									b11.setVisible(false);
									break;
								case 12:
									field12.setVisible(true);
									b12.setVisible(false);
									break;
								case 13:
									field13.setVisible(true);
									b13.setVisible(false);
									break;
								case 14:
									field14.setVisible(true);
									b14.setVisible(false);
									break;
								case 15:
									field15.setVisible(true);
									b15.setVisible(false);
									break;
								case 16:
									field16.setVisible(true);
									b16.setVisible(false);
									break;
								case 17:
									field17.setVisible(true);
									b17.setVisible(false);
									break;
								case 18:
									field18.setVisible(true);
									b18.setVisible(false);
									break;
								case 19:
									field19.setVisible(true);
									b19.setVisible(false);
									break;
								case 20:
									field20.setVisible(true);
									b20.setVisible(false);
									break;
								}

							}
							// ako slovo ne postoji dodeli ga u metodu slova
							// koja ne postoje i postavi ga na ekran
						} else {
							ArrayList<String> no = h.nonexistentLetters(letter.getText().toLowerCase());
							String n = "";
							for (int i = 0; i < no.size(); i++) {
								n = n + "" + no.get(i);
							}
							misses.setText(misses.getText() + "[" + n + "]");
						}
						// u slucaju greske da txt dokument ne postoji
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					// u slucaju unosa vise od jednog slova
				} else {
					information.setText(s2 + s1);
				}
				// provera je li pobedio korisnik
				if (h.win()) {
					result.setText("Cestitam vi ste pobedili!!!");
					window2.setVisible(true);
				}
				// ili izgubio
				if (h.lost()) {
					result.setText("Igubili ste!!!");
					window2.setVisible(true);
				}
				// u zavisnosti koliko je puta pogresio korisnik postavi sliku
				int g = h.getCounterLost();
				switch (g) {
				case 0:
					image0.setVisible(false);
					image1.setVisible(false);
					image2.setVisible(false);
					image3.setVisible(false);
					image4.setVisible(false);
					image5.setVisible(false);
					image6.setVisible(true);
					break;
				case 1:
					image0.setVisible(false);
					image1.setVisible(false);
					image2.setVisible(false);
					image3.setVisible(false);
					image4.setVisible(false);
					image6.setVisible(false);
					image5.setVisible(true);
					break;
				case 2:
					image0.setVisible(false);
					image1.setVisible(false);
					image2.setVisible(false);
					image3.setVisible(false);
					image6.setVisible(false);
					image5.setVisible(false);
					image4.setVisible(true);
					break;
				case 3:
					image0.setVisible(false);
					image1.setVisible(false);
					image2.setVisible(false);
					image6.setVisible(false);
					image4.setVisible(false);
					image5.setVisible(false);
					image3.setVisible(true);
					break;
				case 4:
					image0.setVisible(false);
					image1.setVisible(false);
					image6.setVisible(false);
					image3.setVisible(false);
					image4.setVisible(false);
					image5.setVisible(false);
					image2.setVisible(true);
					break;
				case 5:
					image0.setVisible(false);
					image6.setVisible(false);
					image2.setVisible(false);
					image3.setVisible(false);
					image4.setVisible(false);
					image5.setVisible(false);
					image1.setVisible(true);
					break;
				case 6:
					image6.setVisible(false);
					image1.setVisible(false);
					image2.setVisible(false);
					image3.setVisible(false);
					image4.setVisible(false);
					image5.setVisible(false);
					image0.setVisible(true);
					break;
				}
				letter.setText("");
			}
		};
		sent.addActionListener(al1);

		// dugme za ponovnu igru
		ActionListener al2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Z2_JD_AgainHangman a = new Z2_JD_AgainHangman();
				// sakrivamo dva predhodna ekrana
				window.setVisible(false);
				window2.setVisible(false);
				try {
					// pozivamo metodu da ponovo pokrene sve
					a.again();
					// posto koristi opet txt dokument ispisi u slucaju greske
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		};
		buttonAgain.addActionListener(al2);

	}

}
