package mini_3_connect_and_tic_tac_toe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JD_Igra_X_O {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// stringovi koji se salju u metode u zavisnosti da li je igrac odigrao
		// X ili O
		String x = "X";
		String o = "O";
		// informacije ko je na potezu
		String p1 = "Player 1 move with the sign \"X\", please select the field: ";
		String p2 = "Player 2 move with the sign \"O\", please choose field: ";
		// objekat klase u kojoj su metode
		Igra_X_O game = new Igra_X_O();

		// definisemo dva prozora za igru
		JFrame window = new JFrame("Tic-Tac-Toe");
		JFrame window2 = new JFrame("Result");

		// definisemo da njihov raspored nije definisan
		window.setLayout(null);
		window2.setLayout(null);

		// polja za tekst odnosno x ili o za 9 polja
		final JLabel field1 = new JLabel("");
		final JLabel field2 = new JLabel("");
		final JLabel field3 = new JLabel("");
		final JLabel field4 = new JLabel("");
		final JLabel field5 = new JLabel("");
		final JLabel field6 = new JLabel("");
		final JLabel field7 = new JLabel("");
		final JLabel field8 = new JLabel("");
		final JLabel field9 = new JLabel("");

		// polje u kojem smestamo rezultat
		final JLabel result = new JLabel("");

		// dugmad ili polja gde moguce smestiti x ili o
		JButton button1 = new JButton("");
		JButton button2 = new JButton("");
		JButton button3 = new JButton("");
		JButton button4 = new JButton("");
		JButton button5 = new JButton("");
		JButton button6 = new JButton("");
		JButton button7 = new JButton("");
		JButton button8 = new JButton("");
		JButton button9 = new JButton("");

		// polja za ponovnu igru ili izlaz
		JButton buttonAgain = new JButton("Again");
		JButton buttonExit = new JButton("Exit");

		// polje za informacije ko je na potezu
		JLabel information = new JLabel(p1);

		// dodajemo elemente za prvi prozor
		// ovde dodajemo polja u kojima je x ili o
		window.add(field1);
		window.add(field2);
		window.add(field3);
		window.add(field4);
		window.add(field5);
		window.add(field6);
		window.add(field7);
		window.add(field8);
		window.add(field9);

		// dodajemo prozoru dugmice
		window.add(button1);
		window.add(button2);
		window.add(button3);
		window.add(button4);
		window.add(button5);
		window.add(button6);
		window.add(button7);
		window.add(button8);
		window.add(button9);

		// polje sa informacijama dodajemo prozoru 1
		window.add(information);

		// podesavamo gde se se nalaziti sta sa setBounds
		information.setBounds(50, 50, 350, 30);

		field1.setBounds(150, 150, 50, 50);
		field2.setBounds(210, 150, 50, 50);
		field3.setBounds(270, 150, 50, 50);

		field4.setBounds(150, 210, 50, 50);
		field5.setBounds(210, 210, 50, 50);
		field6.setBounds(270, 210, 50, 50);

		field7.setBounds(150, 270, 50, 50);
		field8.setBounds(210, 270, 50, 50);
		field9.setBounds(270, 270, 50, 50);

		button1.setBounds(150, 150, 50, 50);
		button2.setBounds(210, 150, 50, 50);
		button3.setBounds(270, 150, 50, 50);

		button4.setBounds(150, 210, 50, 50);
		button5.setBounds(210, 210, 50, 50);
		button6.setBounds(270, 210, 50, 50);

		button7.setBounds(150, 270, 50, 50);
		button8.setBounds(210, 270, 50, 50);
		button9.setBounds(270, 270, 50, 50);

		// definisemo boju teksta da je crvena
		java.awt.Color red = new java.awt.Color(255, 0, 0);
		// definisanje fonta za tekst
		Font font = new Font("Serif", Font.BOLD, 32);
		field1.setFont(font);
		field2.setFont(font);
		field3.setFont(font);
		field4.setFont(font);
		field5.setFont(font);
		field6.setFont(font);
		field7.setFont(font);
		field8.setFont(font);
		field9.setFont(font);

		// definisanje boje crvene teksta
		information.setForeground(red);

		// prozor da je prikazan
		window.show();
		// velicina prozora
		window.setSize(500, 500);
		// vidljivos da
		window.setVisible(true);

		// dodajemo elemente za prozor 2
		window2.add(result);
		window2.add(buttonAgain);
		window2.add(buttonExit);

		// podesavamo gde ce se sta nalaziti
		result.setBounds(10, 50, 250, 50);
		buttonAgain.setBounds(30, 200, 100, 50);
		buttonExit.setBounds(150, 200, 100, 50);

		result.setForeground(red);

		// prozor da se prikaze
		window2.show();
		// velicina prozora
		window2.setSize(300, 300);
		// i vidljivost da
		window2.setVisible(false);

		// vidljivost informacija je da
		information.setVisible(true);

		// polja koja ne zelimo da se vide
		field1.setVisible(false);
		field2.setVisible(false);
		field3.setVisible(false);
		field4.setVisible(false);
		field5.setVisible(false);
		field6.setVisible(false);
		field7.setVisible(false);
		field8.setVisible(false);
		field9.setVisible(false);

		// definisemo sta zelimo da se desi ako pritisnemo prvo dugme
		ActionListener al1 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// ako je igrac 1 na potezu posalji x
				if (information.getText().equals(p1)) {
					game.input(1, x);
					// polje se vidi sada
					field1.setVisible(true);
					// i ima vrednost x a dugme se ne vidi
					field1.setText(x);
					button1.setVisible(false);
					// postavljamo na informacije da je na potezu 2 igrac
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					// u slucaju da je na potezu 2 igrac
					game.input(1, o);
					field1.setVisible(true);
					field1.setText(o);
					button1.setVisible(false);
					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				}

			}
		};
		button1.addActionListener(al1);

		// 2 dugme sve isto
		ActionListener al2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (information.getText().equals(p1)) {
					game.input(2, x);
					field2.setVisible(true);
					field2.setText(x);
					button2.setVisible(false);
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					game.input(2, o);
					field2.setVisible(true);
					field2.setText(o);
					button2.setVisible(false);
					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				}
			}
		};
		button2.addActionListener(al2);

		// 3 dugme sve isto
		ActionListener al3 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (information.getText().equals(p1)) {
					game.input(3, x);
					field3.setVisible(true);
					field3.setText(x);
					button3.setVisible(false);
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					game.input(3, o);
					field3.setVisible(true);
					field3.setText(o);
					button3.setVisible(false);
					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				}
			}
		};
		button3.addActionListener(al3);

		// 4 dugme sve isto kao i predhodna
		ActionListener al4 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (information.getText().equals(p1)) {
					game.input(4, x);
					field4.setVisible(true);
					field4.setText(x);
					button4.setVisible(false);
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					game.input(4, o);
					field4.setVisible(true);
					field4.setText(o);
					button4.setVisible(false);
					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				}
			}
		};
		button4.addActionListener(al4);

		// 5 dugme isto sve kao i prvo mislim logika
		ActionListener al5 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (information.getText().equals(p1)) {
					game.input(5, x);
					field5.setVisible(true);
					field5.setText(x);
					button5.setVisible(false);
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					game.input(5, o);
					field5.setVisible(true);
					field5.setText(o);
					button5.setVisible(false);
					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				}
			}
		};
		button5.addActionListener(al5);

		// 6 isto kao i prvo
		ActionListener al6 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (information.getText().equals(p1)) {
					game.input(6, x);
					field6.setVisible(true);
					field6.setText(x);
					button6.setVisible(false);
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					game.input(6, o);
					field6.setVisible(true);
					field6.setText(o);
					button6.setVisible(false);
					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				}
			}
		};
		button6.addActionListener(al6);

		// 7 isto kao i prvo
		ActionListener al7 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (information.getText().equals(p1)) {
					game.input(7, x);
					field7.setVisible(true);
					field7.setText(x);
					button7.setVisible(false);
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					game.input(7, o);
					field7.setVisible(true);
					field7.setText(o);
					button7.setVisible(false);
					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				}
			}
		};
		button7.addActionListener(al7);

		// 8 isto kao i prvo
		ActionListener al8 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (information.getText().equals(p1)) {
					game.input(8, x);
					field8.setVisible(true);
					field8.setText(x);
					button8.setVisible(false);
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					game.input(8, o);
					field8.setVisible(true);
					field8.setText(o);
					button8.setVisible(false);
					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				}
			}
		};
		button8.addActionListener(al8);

		// 9 isto kao i prvo
		ActionListener al9 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (information.getText().equals(p1)) {
					game.input(9, x);
					field9.setVisible(true);
					field9.setText(x);
					button9.setVisible(false);
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					game.input(9, o);
					field9.setVisible(true);
					field9.setText(o);
					button9.setVisible(false);
					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("win X")) {
						window2.setVisible(true);
						result.setText("He won the player 1, with the sign \"X\" !!!");

					} else if (game.win().equals("win O")) {
						window2.setVisible(true);
						result.setText("He won the player 2, with the sign \"O\" !!!");
						// ili nereseno
					} else if (game.getCounter() == 9) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				}
			}
		};
		button9.addActionListener(al9);

		// ovo je specificno dugme izlaz
		ActionListener al10 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// podesimo samo da nestanu obadva prozora
				window.setVisible(false);
				window2.setVisible(false);
			}
		};
		buttonExit.addActionListener(al10);

		// SAD SVE ISPOCETKA JER JE OVO DUGME ZA PONOVNU IGRU
		ActionListener al11 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				window.setVisible(false);
				window2.setVisible(false);
				buttonAgain.setVisible(false);
				
				
				// stringovi koji se salju u metode u zavisnosti da li je igrac odigrao
				// X ili O
				String x = "X";
				String o = "O";
				// informacije ko je na potezu
				String p1 = "Player 1 move with the sign \"X\", please select the field: ";
				String p2 = "Player 2 move with the sign \"O\", please choose field: ";
				// objekat klase u kojoj su metode
				Igra_X_O game = new Igra_X_O();

				// definisemo dva prozora za igru
				JFrame window = new JFrame("Tic-Tac-Toe");
				JFrame window2 = new JFrame("Result");

				// definisemo da njihov raspored nije definisan
				window.setLayout(null);
				window2.setLayout(null);

				// polja za tekst odnosno x ili o za 9 polja
				final JLabel field1 = new JLabel("");
				final JLabel field2 = new JLabel("");
				final JLabel field3 = new JLabel("");
				final JLabel field4 = new JLabel("");
				final JLabel field5 = new JLabel("");
				final JLabel field6 = new JLabel("");
				final JLabel field7 = new JLabel("");
				final JLabel field8 = new JLabel("");
				final JLabel field9 = new JLabel("");

				// polje u kojem smestamo rezultat
				final JLabel result = new JLabel("");

				// dugmad ili polja gde moguce smestiti x ili o
				JButton button1 = new JButton("");
				JButton button2 = new JButton("");
				JButton button3 = new JButton("");
				JButton button4 = new JButton("");
				JButton button5 = new JButton("");
				JButton button6 = new JButton("");
				JButton button7 = new JButton("");
				JButton button8 = new JButton("");
				JButton button9 = new JButton("");

				// polja za ponovnu igru ili izlaz
				JButton buttonAgain = new JButton("Again");
				JButton buttonExit = new JButton("Exit");

				// polje za informacije ko je na potezu
				JLabel information = new JLabel(p1);

				// dodajemo elemente za prvi prozor
				// ovde dodajemo polja u kojima je x ili o
				window.add(field1);
				window.add(field2);
				window.add(field3);
				window.add(field4);
				window.add(field5);
				window.add(field6);
				window.add(field7);
				window.add(field8);
				window.add(field9);

				// dodajemo prozoru dugmice
				window.add(button1);
				window.add(button2);
				window.add(button3);
				window.add(button4);
				window.add(button5);
				window.add(button6);
				window.add(button7);
				window.add(button8);
				window.add(button9);

				// polje sa informacijama dodajemo prozoru 1
				window.add(information);

				// podesavamo gde se se nalaziti sta sa setBounds
				information.setBounds(50, 50, 350, 30);

				field1.setBounds(150, 150, 50, 50);
				field2.setBounds(210, 150, 50, 50);
				field3.setBounds(270, 150, 50, 50);

				field4.setBounds(150, 210, 50, 50);
				field5.setBounds(210, 210, 50, 50);
				field6.setBounds(270, 210, 50, 50);

				field7.setBounds(150, 270, 50, 50);
				field8.setBounds(210, 270, 50, 50);
				field9.setBounds(270, 270, 50, 50);

				button1.setBounds(150, 150, 50, 50);
				button2.setBounds(210, 150, 50, 50);
				button3.setBounds(270, 150, 50, 50);

				button4.setBounds(150, 210, 50, 50);
				button5.setBounds(210, 210, 50, 50);
				button6.setBounds(270, 210, 50, 50);

				button7.setBounds(150, 270, 50, 50);
				button8.setBounds(210, 270, 50, 50);
				button9.setBounds(270, 270, 50, 50);

				// definisemo boju teksta da je crvena
				java.awt.Color red = new java.awt.Color(255, 0, 0);
				// definisanje fonta za tekst
				Font font = new Font("Serif", Font.BOLD, 32);
				field1.setFont(font);
				field2.setFont(font);
				field3.setFont(font);
				field4.setFont(font);
				field5.setFont(font);
				field6.setFont(font);
				field7.setFont(font);
				field8.setFont(font);
				field9.setFont(font);

				// definisanje boje crvene teksta
				information.setForeground(red);

				// prozor da je prikazan
				window.show();
				// velicina prozora
				window.setSize(500, 500);
				// vidljivos da
				window.setVisible(true);

				// dodajemo elemente za prozor 2
				window2.add(result);
				window2.add(buttonExit);

				// podesavamo gde ce se sta nalaziti
				result.setBounds(10, 50, 250, 50);
				buttonAgain.setBounds(30, 200, 100, 50);
				buttonExit.setBounds(150, 200, 100, 50);

				result.setForeground(red);

				// prozor da se prikaze
				window2.show();
				// velicina prozora
				window2.setSize(300, 300);
				// i vidljivost da
				window2.setVisible(false);

				// vidljivost informacija je da
				information.setVisible(true);

				// polja koja ne zelimo da se vide
				field1.setVisible(false);
				field2.setVisible(false);
				field3.setVisible(false);
				field4.setVisible(false);
				field5.setVisible(false);
				field6.setVisible(false);
				field7.setVisible(false);
				field8.setVisible(false);
				field9.setVisible(false);

				// definisemo sta zelimo da se desi ako pritisnemo prvo dugme
				ActionListener al1 = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						// ako je igrac 1 na potezu posalji x
						if (information.getText().equals(p1)) {
							game.input(1, x);
							// polje se vidi sada
							field1.setVisible(true);
							// i ima vrednost x a dugme se ne vidi
							field1.setText(x);
							button1.setVisible(false);
							// postavljamo na informacije da je na potezu 2 igrac
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"X\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							// u slucaju da je na potezu 2 igrac
							game.input(1, o);
							field1.setVisible(true);
							field1.setText(o);
							button1.setVisible(false);
							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						}

					}
				};
				button1.addActionListener(al1);

				// 2 dugme sve isto
				ActionListener al2 = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if (information.getText().equals(p1)) {
							game.input(2, x);
							field2.setVisible(true);
							field2.setText(x);
							button2.setVisible(false);
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							game.input(2, o);
							field2.setVisible(true);
							field2.setText(o);
							button2.setVisible(false);
							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						}
					}
				};
				button2.addActionListener(al2);

				// 3 dugme sve isto
				ActionListener al3 = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if (information.getText().equals(p1)) {
							game.input(3, x);
							field3.setVisible(true);
							field3.setText(x);
							button3.setVisible(false);
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							game.input(3, o);
							field3.setVisible(true);
							field3.setText(o);
							button3.setVisible(false);
							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						}
					}
				};
				button3.addActionListener(al3);

				// 4 dugme sve isto kao i predhodna
				ActionListener al4 = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if (information.getText().equals(p1)) {
							game.input(4, x);
							field4.setVisible(true);
							field4.setText(x);
							button4.setVisible(false);
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							game.input(4, o);
							field4.setVisible(true);
							field4.setText(o);
							button4.setVisible(false);
							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						}
					}
				};
				button4.addActionListener(al4);

				// 5 dugme isto sve kao i prvo mislim logika
				ActionListener al5 = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if (information.getText().equals(p1)) {
							game.input(5, x);
							field5.setVisible(true);
							field5.setText(x);
							button5.setVisible(false);
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							game.input(5, o);
							field5.setVisible(true);
							field5.setText(o);
							button5.setVisible(false);
							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						}
					}
				};
				button5.addActionListener(al5);

				// 6 isto kao i prvo
				ActionListener al6 = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if (information.getText().equals(p1)) {
							game.input(6, x);
							field6.setVisible(true);
							field6.setText(x);
							button6.setVisible(false);
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							game.input(6, o);
							field6.setVisible(true);
							field6.setText(o);
							button6.setVisible(false);
							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						}
					}
				};
				button6.addActionListener(al6);

				// 7 isto kao i prvo
				ActionListener al7 = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if (information.getText().equals(p1)) {
							game.input(7, x);
							field7.setVisible(true);
							field7.setText(x);
							button7.setVisible(false);
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							game.input(7, o);
							field7.setVisible(true);
							field7.setText(o);
							button7.setVisible(false);
							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						}
					}
				};
				button7.addActionListener(al7);

				// 8 isto kao i prvo
				ActionListener al8 = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if (information.getText().equals(p1)) {
							game.input(8, x);
							field8.setVisible(true);
							field8.setText(x);
							button8.setVisible(false);
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							game.input(8, o);
							field8.setVisible(true);
							field8.setText(o);
							button8.setVisible(false);
							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						}
					}
				};
				button8.addActionListener(al8);

				// 9 isto kao i prvo
				ActionListener al9 = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if (information.getText().equals(p1)) {
							game.input(9, x);
							field9.setVisible(true);
							field9.setText(x);
							button9.setVisible(false);
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							game.input(9, o);
							field9.setVisible(true);
							field9.setText(o);
							button9.setVisible(false);
							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("win X")) {
								window2.setVisible(true);
								result.setText("He won the player 1, with the sign \"X\" !!!");

							} else if (game.win().equals("win O")) {
								window2.setVisible(true);
								result.setText("He won the player 2, with the sign \"O\" !!!");
								// ili nereseno
							} else if (game.getCounter() == 9) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						}
					}
				};
				button9.addActionListener(al9);

				// ovo je specificno dugme izlaz
				ActionListener al10 = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						// podesimo samo da nestanu obadva prozora
						window.setVisible(false);
						window2.setVisible(false);
					}
				};
				buttonExit.addActionListener(al10);
				
			}
			};
			buttonAgain.addActionListener(al11);

	}
}
