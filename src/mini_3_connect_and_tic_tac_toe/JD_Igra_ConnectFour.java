package mini_3_connect_and_tic_tac_toe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class JD_Igra_ConnectFour {

	public static void main(String[] args) {
		// stringovi koji se salju u metode u zavisnosti da li je igrac odigrao
		// crvenu ili zutu boju
		String R = "R";
		String Y = "Y";
		// informacije ko je na potezu
		String p1 = "Where do you want to put red color: ";
		String p2 = "Where do you want to put yellow color: ";
		// objekat klase u kojoj su metode
		Igra_ConnectFour game = new Igra_ConnectFour();

		// definisemo dva prozora za igru
		JFrame window = new JFrame("ConnectFour");
		JFrame window2 = new JFrame("Result");

		// definisemo da njihov raspored nije definisan
		window.setLayout(null);
		window2.setLayout(null);

		// polja za tekst odnosno crvenu ili zutu boju it o 42 polja
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
		JTextArea field21 = new JTextArea(20, 55);
		JTextArea field22 = new JTextArea(20, 55);
		JTextArea field23 = new JTextArea(20, 55);
		JTextArea field24 = new JTextArea(20, 55);
		JTextArea field25 = new JTextArea(20, 55);
		JTextArea field26 = new JTextArea(20, 55);
		JTextArea field27 = new JTextArea(20, 55);
		JTextArea field28 = new JTextArea(20, 55);
		JTextArea field29 = new JTextArea(20, 55);
		JTextArea field30 = new JTextArea(20, 55);
		JTextArea field31 = new JTextArea(20, 55);
		JTextArea field32 = new JTextArea(20, 55);
		JTextArea field33 = new JTextArea(20, 55);
		JTextArea field34 = new JTextArea(20, 55);
		JTextArea field35 = new JTextArea(20, 55);
		JTextArea field36 = new JTextArea(20, 55);
		JTextArea field37 = new JTextArea(20, 55);
		JTextArea field38 = new JTextArea(20, 55);
		JTextArea field39 = new JTextArea(20, 55);
		JTextArea field40 = new JTextArea(20, 55);
		JTextArea field41 = new JTextArea(20, 55);
		JTextArea field42 = new JTextArea(20, 55);

		// polje u kojem smestamo rezultat
		final JLabel result = new JLabel("");

		// dugmad preko kojih smestamo boju
		JButton button1 = new JButton("Add");
		JButton button2 = new JButton("Add");
		JButton button3 = new JButton("Add");
		JButton button4 = new JButton("Add");
		JButton button5 = new JButton("Add");
		JButton button6 = new JButton("Add");
		JButton button7 = new JButton("Add");

		// polja za ponovnu igru ili izlaz
		JButton buttonAgain = new JButton("Again");
		JButton buttonExit = new JButton("Exit");

		// polje za informacije ko je na potezu
		JLabel information = new JLabel(p1);

		// dodajemo elemente za prvi prozor
		// ovde dodajemo polja za smestanje boje
		window.add(field1);
		window.add(field2);
		window.add(field3);
		window.add(field4);
		window.add(field5);
		window.add(field6);
		window.add(field7);
		window.add(field8);
		window.add(field9);
		window.add(field10);
		window.add(field11);
		window.add(field12);
		window.add(field13);
		window.add(field14);
		window.add(field15);
		window.add(field16);
		window.add(field17);
		window.add(field18);
		window.add(field19);
		window.add(field20);
		window.add(field21);
		window.add(field22);
		window.add(field23);
		window.add(field24);
		window.add(field25);
		window.add(field26);
		window.add(field27);
		window.add(field28);
		window.add(field29);
		window.add(field30);
		window.add(field31);
		window.add(field32);
		window.add(field33);
		window.add(field34);
		window.add(field35);
		window.add(field36);
		window.add(field37);
		window.add(field38);
		window.add(field39);
		window.add(field40);
		window.add(field41);
		window.add(field42);

		// dodajemo prozoru dugmice
		window.add(button1);
		window.add(button2);
		window.add(button3);
		window.add(button4);
		window.add(button5);
		window.add(button6);
		window.add(button7);

		// polje sa informacijama dodajemo prozoru 1
		window.add(information);

		// podesavamo gde se se nalaziti sta sa setBounds
		information.setBounds(50, 50, 350, 30);

		field1.setBounds(63, 150, 33, 47);
		field2.setBounds(63, 200, 33, 47);
		field3.setBounds(63, 250, 33, 47);
		field4.setBounds(63, 300, 33, 47);
		field5.setBounds(63, 350, 33, 47);
		field6.setBounds(63, 400, 33, 47);

		field7.setBounds(125, 150, 33, 47);
		field8.setBounds(125, 200, 33, 47);
		field9.setBounds(125, 250, 33, 47);
		field10.setBounds(125, 300, 33, 47);
		field11.setBounds(125, 350, 33, 47);
		field12.setBounds(125, 400, 33, 47);

		field13.setBounds(185, 150, 33, 47);
		field14.setBounds(185, 200, 33, 47);
		field15.setBounds(185, 250, 33, 47);
		field16.setBounds(185, 300, 33, 47);
		field17.setBounds(185, 350, 33, 47);
		field18.setBounds(185, 400, 33, 47);

		field19.setBounds(245, 150, 33, 47);
		field20.setBounds(245, 200, 33, 47);
		field21.setBounds(245, 250, 33, 47);
		field22.setBounds(245, 300, 33, 47);
		field23.setBounds(245, 350, 33, 47);
		field24.setBounds(245, 400, 33, 47);

		field25.setBounds(305, 150, 33, 47);
		field26.setBounds(305, 200, 33, 47);
		field27.setBounds(305, 250, 33, 47);
		field28.setBounds(305, 300, 33, 47);
		field29.setBounds(305, 350, 33, 47);
		field30.setBounds(305, 400, 33, 47);

		field31.setBounds(365, 150, 33, 47);
		field32.setBounds(365, 200, 33, 47);
		field33.setBounds(365, 250, 33, 47);
		field34.setBounds(365, 300, 33, 47);
		field35.setBounds(365, 350, 33, 47);
		field36.setBounds(365, 400, 33, 47);

		field37.setBounds(425, 150, 33, 47);
		field38.setBounds(425, 200, 33, 47);
		field39.setBounds(425, 250, 33, 47);
		field40.setBounds(425, 300, 33, 47);
		field41.setBounds(425, 350, 33, 47);
		field42.setBounds(425, 400, 33, 47);

		button1.setBounds(50, 100, 60, 50);
		button2.setBounds(110, 100, 60, 50);
		button3.setBounds(170, 100, 60, 50);
		button4.setBounds(230, 100, 60, 50);
		button5.setBounds(290, 100, 60, 50);
		button6.setBounds(350, 100, 60, 50);
		button7.setBounds(410, 100, 60, 50);

		// definisemo boju teksta da je crvena ili zuta, odnosno plava
		java.awt.Color red = new java.awt.Color(255, 0, 0);
		java.awt.Color yellow = new java.awt.Color(255, 255, 0);
		java.awt.Color blue = new java.awt.Color(0, 0, 255);
		// definisanje fonta za tekst
		Font font = new Font("Serif", Font.BOLD, 42);
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
		field21.setFont(font);
		field22.setFont(font);
		field23.setFont(font);
		field24.setFont(font);
		field25.setFont(font);
		field26.setFont(font);
		field27.setFont(font);
		field28.setFont(font);
		field29.setFont(font);
		field30.setFont(font);
		field31.setFont(font);
		field32.setFont(font);
		field33.setFont(font);
		field34.setFont(font);
		field35.setFont(font);
		field36.setFont(font);
		field37.setFont(font);
		field38.setFont(font);
		field39.setFont(font);
		field40.setFont(font);
		field41.setFont(font);
		field42.setFont(font);
	

		// teks informacija ima plavu boju
		information.setForeground(blue);

		// velicina prozora
		window.setSize(550, 550);
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

		result.setForeground(blue);

		// velicina prozora2
		window2.setSize(300, 300);
		// i vidljivost da
		window2.setVisible(false);

		// definisemo sta zelimo da se desi ako pritisnemo prvo dugme
		ActionListener al1 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				// ako je igrac 1 na potezu posalji crvenu
				if (information.getText().equals(p1)) {
					game.input(1, R);

					// u avisnosti koji broj vrati metoda postavi crvenu boju
					switch (game.getCounter1() + 2) {
					case 1:
						field1.setForeground(red);
						field1.setText("O");
						break;
					case 2:
						field2.setForeground(red);
						field2.setText("O");
						break;
					case 3:
						field3.setForeground(red);
						field3.setText("O");
						break;
					case 4:
						field4.setForeground(red);
						field4.setText("O");
						break;
					case 5:
						field5.setForeground(red);
						field5.setText("O");
						break;
					case 6:
						field6.setForeground(red);
						field6.setText("O");
						break;
					}

					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow!!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					// u slucaju da je na potezu 2 igrac
					game.input(1, Y);

					// u avisnosti koji broj vrati metoda postavi zutu boju
					switch (game.getCounter1() + 2) {
					case 1:
						field1.setForeground(yellow);
						field1.setText("O");
						break;
					case 2:
						field2.setForeground(yellow);
						field2.setText("O");
						break;
					case 3:
						field3.setForeground(yellow);
						field3.setText("O");
						break;
					case 4:
						field4.setForeground(yellow);
						field4.setText("O");
						break;
					case 5:
						field5.setForeground(yellow);
						field5.setText("O");
						break;
					case 6:
						field6.setForeground(yellow);
						field6.setText("O");
						break;
					}

					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
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
				// ako je igrac 1 na potezu posalji crvenu
				if (information.getText().equals(p1)) {
					game.input(2, R);

					// u avisnosti koji broj vrati metoda postavi crvenu boju
					switch (game.getCounter2() + 2) {
					case 1:
						field7.setForeground(red);
						field7.setText("O");
						break;
					case 2:
						field8.setForeground(red);
						field8.setText("O");
						break;
					case 3:
						field9.setForeground(red);
						field9.setText("O");
						break;
					case 4:
						field10.setForeground(red);
						field10.setText("O");
						break;
					case 5:
						field11.setForeground(red);
						field11.setText("O");
						break;
					case 6:
						field12.setForeground(red);
						field12.setText("O");
						break;
					}

					// postavljamo na informacije da je na potezu 2 igrac
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					// u slucaju da je na potezu 2 igrac
					game.input(2, Y);

					// u avisnosti koji broj vrati metoda postavi zutu boju
					switch (game.getCounter2() + 2) {
					case 1:
						field7.setForeground(yellow);
						field7.setText("O");
						break;
					case 2:
						field8.setForeground(yellow);
						field8.setText("O");
						break;
					case 3:
						field9.setForeground(yellow);
						field9.setText("O");
						break;
					case 4:
						field10.setForeground(yellow);
						field10.setText("O");
						break;
					case 5:
						field11.setForeground(yellow);
						field11.setText("O");
						break;
					case 6:
						field12.setForeground(yellow);
						field12.setText("O");
						break;
					}
					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
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
				// ako je igrac 1 na potezu posalji x
				if (information.getText().equals(p1)) {
					game.input(3, R);

					// u avisnosti koji broj vrati metoda postavi crvenu boju
					switch (game.getCounter3() + 2) {
					case 1:
						field13.setForeground(red);
						field13.setText("O");
						break;
					case 2:
						field14.setForeground(red);
						field14.setText("O");
						break;
					case 3:
						field15.setForeground(red);
						field15.setText("O");
						break;
					case 4:
						field16.setForeground(red);
						field16.setText("O");
						break;
					case 5:
						field17.setForeground(red);
						field17.setText("O");
						break;
					case 6:
						field18.setForeground(red);
						field18.setText("O");
						break;
					}
					// postavljamo na informacije da je na potezu 2 igrac
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					// u slucaju da je na potezu 2 igrac
					game.input(3, Y);

					// u avisnosti koji broj vrati metoda postavi zutu boju
					switch (game.getCounter3() + 2) {
					case 1:
						field13.setForeground(yellow);
						field13.setText("O");
						break;
					case 2:
						field14.setForeground(yellow);
						field14.setText("O");
						break;
					case 3:
						field15.setForeground(yellow);
						field15.setText("O");
						break;
					case 4:
						field16.setForeground(yellow);
						field16.setText("O");
						break;
					case 5:
						field17.setForeground(yellow);
						field17.setText("O");
						break;
					case 6:
						field18.setForeground(yellow);
						field18.setText("O");
						break;
					}

					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
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
				// ako je igrac 1 na potezu posalji x
				if (information.getText().equals(p1)) {
					game.input(4, R);

					// u avisnosti koji broj vrati metoda postavi crvenu boju
					switch (game.getCounter4() + 2) {
					case 1:
						field19.setForeground(red);
						field19.setText("O");
						break;
					case 2:
						field20.setForeground(red);
						field20.setText("O");
						break;
					case 3:
						field21.setForeground(red);
						field21.setText("O");
						break;
					case 4:
						field22.setForeground(red);
						field22.setText("O");
						break;
					case 5:
						field23.setForeground(red);
						field23.setText("O");
						break;
					case 6:
						field24.setForeground(red);
						field24.setText("O");
						break;
					}

					// postavljamo na informacije da je na potezu 2 igrac
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					// u slucaju da je na potezu 2 igrac
					game.input(4, Y);

					// u avisnosti koji broj vrati metoda postavi zutu boju
					switch (game.getCounter4() + 2) {
					case 1:
						field19.setForeground(yellow);
						field19.setText("O");
						break;
					case 2:
						field20.setForeground(yellow);
						field20.setText("O");
						break;
					case 3:
						field21.setForeground(yellow);
						field21.setText("O");
						break;
					case 4:
						field22.setForeground(yellow);
						field22.setText("O");
						break;
					case 5:
						field23.setForeground(yellow);
						field23.setText("O");
						break;
					case 6:
						field24.setForeground(yellow);
						field24.setText("O");
						break;
					}

					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
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
				// ako je igrac 1 na potezu posalji x
				if (information.getText().equals(p1)) {
					game.input(5, R);

					// u avisnosti koji broj vrati metoda postavi crvenu boju
					switch (game.getCounter5() + 2) {
					case 1:
						field25.setForeground(red);
						field25.setText("O");
						break;
					case 2:
						field26.setForeground(red);
						field26.setText("O");
						break;
					case 3:
						field27.setForeground(red);
						field27.setText("O");
						break;
					case 4:
						field28.setForeground(red);
						field28.setText("O");
						break;
					case 5:
						field29.setForeground(red);
						field29.setText("O");
						break;
					case 6:
						field30.setForeground(red);
						field30.setText("O");
						break;
					}

					// postavljamo na informacije da je na potezu 2 igrac
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					// u slucaju da je na potezu 2 igrac
					game.input(5, Y);

					// u avisnosti koji broj vrati metoda postavi zutu boju
					switch (game.getCounter5() + 2) {
					case 1:
						field25.setForeground(yellow);
						field25.setText("O");
						break;
					case 2:
						field26.setForeground(yellow);
						field26.setText("O");
						break;
					case 3:
						field27.setForeground(yellow);
						field27.setText("O");
						break;
					case 4:
						field28.setForeground(yellow);
						field28.setText("O");
						break;
					case 5:
						field29.setForeground(yellow);
						field29.setText("O");
						break;
					case 6:
						field30.setForeground(yellow);
						field30.setText("O");
						break;
					}

					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
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
				// ako je igrac 1 na potezu posalji x
				if (information.getText().equals(p1)) {
					game.input(6, R);

					// u avisnosti koji broj vrati metoda postavi crvenu boju
					switch (game.getCounter6() + 2) {
					case 1:
						field31.setForeground(red);
						field31.setText("O");
						break;
					case 2:
						field32.setForeground(red);
						field32.setText("O");
						break;
					case 3:
						field33.setForeground(red);
						field33.setText("O");
						break;
					case 4:
						field34.setForeground(red);
						field34.setText("O");
						break;
					case 5:
						field35.setForeground(red);
						field35.setText("O");
						break;
					case 6:
						field36.setForeground(red);
						field36.setText("O");
						break;
					}

					// postavljamo na informacije da je na potezu 2 igrac
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					// u slucaju da je na potezu 2 igrac
					game.input(6, Y);

					// u avisnosti koji broj vrati metoda postavi zutu boju
					switch (game.getCounter6() + 2) {
					case 1:
						field31.setForeground(yellow);
						field31.setText("O");
						break;
					case 2:
						field32.setForeground(yellow);
						field32.setText("O");
						break;
					case 3:
						field33.setForeground(yellow);
						field33.setText("O");
						break;
					case 4:
						field34.setForeground(yellow);
						field34.setText("O");
						break;
					case 5:
						field35.setForeground(yellow);
						field35.setText("O");
						break;
					case 6:
						field36.setForeground(yellow);
						field36.setText("O");
						break;
					}

					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");

					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
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
				// ako je igrac 1 na potezu posalji x
				if (information.getText().equals(p1)) {
					game.input(7, R);

					// u avisnosti koji broj vrati metoda postavi crvenu boju
					switch (game.getCounter7() + 2) {
					case 1:
						field37.setForeground(red);
						field37.setText("O");
						break;
					case 2:
						field38.setForeground(red);
						field38.setText("O");
						break;
					case 3:
						field39.setForeground(red);
						field39.setText("O");
						break;
					case 4:
						field40.setForeground(red);
						field40.setText("O");
						break;
					case 5:
						field41.setForeground(red);
						field41.setText("O");
						break;
					case 6:
						field42.setForeground(red);
						field42.setText("O");
						break;
					}

					// postavljamo na informacije da je na potezu 2 igrac
					information.setText(p2);

					// u slucaju pobede
					if (game.win().equals("Win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");

					} else if (game.win().equals("Win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				} else {
					// u slucaju da je na potezu 2 igrac
					game.input(7, Y);

					// u avisnosti koji broj vrati metoda postavi zutu boju
					switch (game.getCounter7() + 2) {
					case 1:
						field37.setForeground(yellow);
						field37.setText("O");
						break;
					case 2:
						field38.setForeground(yellow);
						field38.setText("O");
						break;
					case 3:
						field39.setForeground(yellow);
						field39.setText("O");
						break;
					case 4:
						field40.setForeground(yellow);
						field40.setText("O");
						break;
					case 5:
						field41.setForeground(yellow);
						field41.setText("O");
						break;
					case 6:
						field42.setForeground(yellow);
						field42.setText("O");
						break;
					}

					information.setText(p1);

					// u slucaju pobede
					if (game.win().equals("win R")) {
						window2.setVisible(true);
						result.setText("He won the player 1 with the color red!!!");
					} else if (game.win().equals("win Y")) {
						window2.setVisible(true);
						result.setText("He won the player 2 with the color yellow !!!");
						// ili nereseno
					} else if (game.getCounter() == 42) {
						window2.setVisible(true);
						result.setText("Draws!!!");
					}
				}
			}
		};
		button7.addActionListener(al7);

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
				
				// podesimo samo da nestanu obadva prozora
				window.setVisible(false);
				window2.setVisible(false);
				
				// stringovi koji se salju u metode u zavisnosti da li je igrac odigrao
				// crvenu ili zutu boju
				String R = "R";
				String Y = "Y";
				// informacije ko je na potezu
				String p1 = "Where do you want to put red color: ";
				String p2 = "Where do you want to put yellow color: ";
				// objekat klase u kojoj su metode
				Igra_ConnectFour game = new Igra_ConnectFour();

				// definisemo dva prozora za igru
				JFrame window = new JFrame("ConnectFour");
				JFrame window2 = new JFrame("Result");

				// definisemo da njihov raspored nije definisan
				window.setLayout(null);
				window2.setLayout(null);

				// polja za tekst odnosno crvenu ili zutu boju it o 42 polja
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
				JTextArea field21 = new JTextArea(20, 55);
				JTextArea field22 = new JTextArea(20, 55);
				JTextArea field23 = new JTextArea(20, 55);
				JTextArea field24 = new JTextArea(20, 55);
				JTextArea field25 = new JTextArea(20, 55);
				JTextArea field26 = new JTextArea(20, 55);
				JTextArea field27 = new JTextArea(20, 55);
				JTextArea field28 = new JTextArea(20, 55);
				JTextArea field29 = new JTextArea(20, 55);
				JTextArea field30 = new JTextArea(20, 55);
				JTextArea field31 = new JTextArea(20, 55);
				JTextArea field32 = new JTextArea(20, 55);
				JTextArea field33 = new JTextArea(20, 55);
				JTextArea field34 = new JTextArea(20, 55);
				JTextArea field35 = new JTextArea(20, 55);
				JTextArea field36 = new JTextArea(20, 55);
				JTextArea field37 = new JTextArea(20, 55);
				JTextArea field38 = new JTextArea(20, 55);
				JTextArea field39 = new JTextArea(20, 55);
				JTextArea field40 = new JTextArea(20, 55);
				JTextArea field41 = new JTextArea(20, 55);
				JTextArea field42 = new JTextArea(20, 55);

				// polje u kojem smestamo rezultat
				final JLabel result = new JLabel("");

				// dugmad preko kojih smestamo boju
				JButton button1 = new JButton("Add");
				JButton button2 = new JButton("Add");
				JButton button3 = new JButton("Add");
				JButton button4 = new JButton("Add");
				JButton button5 = new JButton("Add");
				JButton button6 = new JButton("Add");
				JButton button7 = new JButton("Add");

				// polja za ponovnu igru ili izlaz
				JButton buttonAgain = new JButton("Again");
				JButton buttonExit = new JButton("Exit");

				// polje za informacije ko je na potezu
				JLabel information = new JLabel(p1);

				// dodajemo elemente za prvi prozor
				// ovde dodajemo polja za smestanje boje
				window.add(field1);
				window.add(field2);
				window.add(field3);
				window.add(field4);
				window.add(field5);
				window.add(field6);
				window.add(field7);
				window.add(field8);
				window.add(field9);
				window.add(field10);
				window.add(field11);
				window.add(field12);
				window.add(field13);
				window.add(field14);
				window.add(field15);
				window.add(field16);
				window.add(field17);
				window.add(field18);
				window.add(field19);
				window.add(field20);
				window.add(field21);
				window.add(field22);
				window.add(field23);
				window.add(field24);
				window.add(field25);
				window.add(field26);
				window.add(field27);
				window.add(field28);
				window.add(field29);
				window.add(field30);
				window.add(field31);
				window.add(field32);
				window.add(field33);
				window.add(field34);
				window.add(field35);
				window.add(field36);
				window.add(field37);
				window.add(field38);
				window.add(field39);
				window.add(field40);
				window.add(field41);
				window.add(field42);

				// dodajemo prozoru dugmice
				window.add(button1);
				window.add(button2);
				window.add(button3);
				window.add(button4);
				window.add(button5);
				window.add(button6);
				window.add(button7);

				// polje sa informacijama dodajemo prozoru 1
				window.add(information);

				// podesavamo gde se se nalaziti sta sa setBounds
				information.setBounds(50, 50, 350, 30);

				field1.setBounds(63, 150, 33, 47);
				field2.setBounds(63, 200, 33, 47);
				field3.setBounds(63, 250, 33, 47);
				field4.setBounds(63, 300, 33, 47);
				field5.setBounds(63, 350, 33, 47);
				field6.setBounds(63, 400, 33, 47);

				field7.setBounds(125, 150, 33, 47);
				field8.setBounds(125, 200, 33, 47);
				field9.setBounds(125, 250, 33, 47);
				field10.setBounds(125, 300, 33, 47);
				field11.setBounds(125, 350, 33, 47);
				field12.setBounds(125, 400, 33, 47);

				field13.setBounds(185, 150, 33, 47);
				field14.setBounds(185, 200, 33, 47);
				field15.setBounds(185, 250, 33, 47);
				field16.setBounds(185, 300, 33, 47);
				field17.setBounds(185, 350, 33, 47);
				field18.setBounds(185, 400, 33, 47);

				field19.setBounds(245, 150, 33, 47);
				field20.setBounds(245, 200, 33, 47);
				field21.setBounds(245, 250, 33, 47);
				field22.setBounds(245, 300, 33, 47);
				field23.setBounds(245, 350, 33, 47);
				field24.setBounds(245, 400, 33, 47);

				field25.setBounds(305, 150, 33, 47);
				field26.setBounds(305, 200, 33, 47);
				field27.setBounds(305, 250, 33, 47);
				field28.setBounds(305, 300, 33, 47);
				field29.setBounds(305, 350, 33, 47);
				field30.setBounds(305, 400, 33, 47);

				field31.setBounds(365, 150, 33, 47);
				field32.setBounds(365, 200, 33, 47);
				field33.setBounds(365, 250, 33, 47);
				field34.setBounds(365, 300, 33, 47);
				field35.setBounds(365, 350, 33, 47);
				field36.setBounds(365, 400, 33, 47);

				field37.setBounds(425, 150, 33, 47);
				field38.setBounds(425, 200, 33, 47);
				field39.setBounds(425, 250, 33, 47);
				field40.setBounds(425, 300, 33, 47);
				field41.setBounds(425, 350, 33, 47);
				field42.setBounds(425, 400, 33, 47);

				button1.setBounds(50, 100, 60, 50);
				button2.setBounds(110, 100, 60, 50);
				button3.setBounds(170, 100, 60, 50);
				button4.setBounds(230, 100, 60, 50);
				button5.setBounds(290, 100, 60, 50);
				button6.setBounds(350, 100, 60, 50);
				button7.setBounds(410, 100, 60, 50);

				// definisemo boju teksta da je crvena ili zuta, odnosno plava
				java.awt.Color red = new java.awt.Color(255, 0, 0);
				java.awt.Color yellow = new java.awt.Color(255, 255, 0);
				java.awt.Color blue = new java.awt.Color(0, 0, 255);
				// definisanje fonta za tekst
				Font font = new Font("Serif", Font.BOLD, 42);
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
				field21.setFont(font);
				field22.setFont(font);
				field23.setFont(font);
				field24.setFont(font);
				field25.setFont(font);
				field26.setFont(font);
				field27.setFont(font);
				field28.setFont(font);
				field29.setFont(font);
				field30.setFont(font);
				field31.setFont(font);
				field32.setFont(font);
				field33.setFont(font);
				field34.setFont(font);
				field35.setFont(font);
				field36.setFont(font);
				field37.setFont(font);
				field38.setFont(font);
				field39.setFont(font);
				field40.setFont(font);
				field41.setFont(font);
				field42.setFont(font);
			

				// teks informacija ima plavu boju
				information.setForeground(blue);

				// velicina prozora
				window.setSize(550, 550);
				// vidljivos da
				window.setVisible(true);

				// dodajemo elemente za prozor 2
				window2.add(result);
				window2.add(buttonExit);

				// podesavamo gde ce se sta nalaziti
				result.setBounds(10, 50, 250, 50);
				buttonAgain.setBounds(30, 200, 100, 50);
				buttonExit.setBounds(150, 200, 100, 50);

				result.setForeground(blue);

				// velicina prozora2
				window2.setSize(300, 300);
				// i vidljivost da
				window2.setVisible(false);

				// definisemo sta zelimo da se desi ako pritisnemo prvo dugme
				ActionListener al1 = new ActionListener() {
					public void actionPerformed(ActionEvent evt) {

						// ako je igrac 1 na potezu posalji crvenu
						if (information.getText().equals(p1)) {
							game.input(1, R);

							// u avisnosti koji broj vrati metoda postavi crvenu boju
							switch (game.getCounter1() + 2) {
							case 1:
								field1.setForeground(red);
								field1.setText("O");
								break;
							case 2:
								field2.setForeground(red);
								field2.setText("O");
								break;
							case 3:
								field3.setForeground(red);
								field3.setText("O");
								break;
							case 4:
								field4.setForeground(red);
								field4.setText("O");
								break;
							case 5:
								field5.setForeground(red);
								field5.setText("O");
								break;
							case 6:
								field6.setForeground(red);
								field6.setText("O");
								break;
							}

							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow!!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							// u slucaju da je na potezu 2 igrac
							game.input(1, Y);

							// u avisnosti koji broj vrati metoda postavi zutu boju
							switch (game.getCounter1() + 2) {
							case 1:
								field1.setForeground(yellow);
								field1.setText("O");
								break;
							case 2:
								field2.setForeground(yellow);
								field2.setText("O");
								break;
							case 3:
								field3.setForeground(yellow);
								field3.setText("O");
								break;
							case 4:
								field4.setForeground(yellow);
								field4.setText("O");
								break;
							case 5:
								field5.setForeground(yellow);
								field5.setText("O");
								break;
							case 6:
								field6.setForeground(yellow);
								field6.setText("O");
								break;
							}

							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
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
						// ako je igrac 1 na potezu posalji crvenu
						if (information.getText().equals(p1)) {
							game.input(2, R);

							// u avisnosti koji broj vrati metoda postavi crvenu boju
							switch (game.getCounter2() + 2) {
							case 1:
								field7.setForeground(red);
								field7.setText("O");
								break;
							case 2:
								field8.setForeground(red);
								field8.setText("O");
								break;
							case 3:
								field9.setForeground(red);
								field9.setText("O");
								break;
							case 4:
								field10.setForeground(red);
								field10.setText("O");
								break;
							case 5:
								field11.setForeground(red);
								field11.setText("O");
								break;
							case 6:
								field12.setForeground(red);
								field12.setText("O");
								break;
							}

							// postavljamo na informacije da je na potezu 2 igrac
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							// u slucaju da je na potezu 2 igrac
							game.input(2, Y);

							// u avisnosti koji broj vrati metoda postavi zutu boju
							switch (game.getCounter2() + 2) {
							case 1:
								field7.setForeground(yellow);
								field7.setText("O");
								break;
							case 2:
								field8.setForeground(yellow);
								field8.setText("O");
								break;
							case 3:
								field9.setForeground(yellow);
								field9.setText("O");
								break;
							case 4:
								field10.setForeground(yellow);
								field10.setText("O");
								break;
							case 5:
								field11.setForeground(yellow);
								field11.setText("O");
								break;
							case 6:
								field12.setForeground(yellow);
								field12.setText("O");
								break;
							}
							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
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
						// ako je igrac 1 na potezu posalji x
						if (information.getText().equals(p1)) {
							game.input(3, R);

							// u avisnosti koji broj vrati metoda postavi crvenu boju
							switch (game.getCounter3() + 2) {
							case 1:
								field13.setForeground(red);
								field13.setText("O");
								break;
							case 2:
								field14.setForeground(red);
								field14.setText("O");
								break;
							case 3:
								field15.setForeground(red);
								field15.setText("O");
								break;
							case 4:
								field16.setForeground(red);
								field16.setText("O");
								break;
							case 5:
								field17.setForeground(red);
								field17.setText("O");
								break;
							case 6:
								field18.setForeground(red);
								field18.setText("O");
								break;
							}
							// postavljamo na informacije da je na potezu 2 igrac
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							// u slucaju da je na potezu 2 igrac
							game.input(3, Y);

							// u avisnosti koji broj vrati metoda postavi zutu boju
							switch (game.getCounter3() + 2) {
							case 1:
								field13.setForeground(yellow);
								field13.setText("O");
								break;
							case 2:
								field14.setForeground(yellow);
								field14.setText("O");
								break;
							case 3:
								field15.setForeground(yellow);
								field15.setText("O");
								break;
							case 4:
								field16.setForeground(yellow);
								field16.setText("O");
								break;
							case 5:
								field17.setForeground(yellow);
								field17.setText("O");
								break;
							case 6:
								field18.setForeground(yellow);
								field18.setText("O");
								break;
							}

							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
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
						// ako je igrac 1 na potezu posalji x
						if (information.getText().equals(p1)) {
							game.input(4, R);

							// u avisnosti koji broj vrati metoda postavi crvenu boju
							switch (game.getCounter4() + 2) {
							case 1:
								field19.setForeground(red);
								field19.setText("O");
								break;
							case 2:
								field20.setForeground(red);
								field20.setText("O");
								break;
							case 3:
								field21.setForeground(red);
								field21.setText("O");
								break;
							case 4:
								field22.setForeground(red);
								field22.setText("O");
								break;
							case 5:
								field23.setForeground(red);
								field23.setText("O");
								break;
							case 6:
								field24.setForeground(red);
								field24.setText("O");
								break;
							}

							// postavljamo na informacije da je na potezu 2 igrac
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							// u slucaju da je na potezu 2 igrac
							game.input(4, Y);

							// u avisnosti koji broj vrati metoda postavi zutu boju
							switch (game.getCounter4() + 2) {
							case 1:
								field19.setForeground(yellow);
								field19.setText("O");
								break;
							case 2:
								field20.setForeground(yellow);
								field20.setText("O");
								break;
							case 3:
								field21.setForeground(yellow);
								field21.setText("O");
								break;
							case 4:
								field22.setForeground(yellow);
								field22.setText("O");
								break;
							case 5:
								field23.setForeground(yellow);
								field23.setText("O");
								break;
							case 6:
								field24.setForeground(yellow);
								field24.setText("O");
								break;
							}

							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
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
						// ako je igrac 1 na potezu posalji x
						if (information.getText().equals(p1)) {
							game.input(5, R);

							// u avisnosti koji broj vrati metoda postavi crvenu boju
							switch (game.getCounter5() + 2) {
							case 1:
								field25.setForeground(red);
								field25.setText("O");
								break;
							case 2:
								field26.setForeground(red);
								field26.setText("O");
								break;
							case 3:
								field27.setForeground(red);
								field27.setText("O");
								break;
							case 4:
								field28.setForeground(red);
								field28.setText("O");
								break;
							case 5:
								field29.setForeground(red);
								field29.setText("O");
								break;
							case 6:
								field30.setForeground(red);
								field30.setText("O");
								break;
							}

							// postavljamo na informacije da je na potezu 2 igrac
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							// u slucaju da je na potezu 2 igrac
							game.input(5, Y);

							// u avisnosti koji broj vrati metoda postavi zutu boju
							switch (game.getCounter5() + 2) {
							case 1:
								field25.setForeground(yellow);
								field25.setText("O");
								break;
							case 2:
								field26.setForeground(yellow);
								field26.setText("O");
								break;
							case 3:
								field27.setForeground(yellow);
								field27.setText("O");
								break;
							case 4:
								field28.setForeground(yellow);
								field28.setText("O");
								break;
							case 5:
								field29.setForeground(yellow);
								field29.setText("O");
								break;
							case 6:
								field30.setForeground(yellow);
								field30.setText("O");
								break;
							}

							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
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
						// ako je igrac 1 na potezu posalji x
						if (information.getText().equals(p1)) {
							game.input(6, R);

							// u avisnosti koji broj vrati metoda postavi crvenu boju
							switch (game.getCounter6() + 2) {
							case 1:
								field31.setForeground(red);
								field31.setText("O");
								break;
							case 2:
								field32.setForeground(red);
								field32.setText("O");
								break;
							case 3:
								field33.setForeground(red);
								field33.setText("O");
								break;
							case 4:
								field34.setForeground(red);
								field34.setText("O");
								break;
							case 5:
								field35.setForeground(red);
								field35.setText("O");
								break;
							case 6:
								field36.setForeground(red);
								field36.setText("O");
								break;
							}

							// postavljamo na informacije da je na potezu 2 igrac
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							// u slucaju da je na potezu 2 igrac
							game.input(6, Y);

							// u avisnosti koji broj vrati metoda postavi zutu boju
							switch (game.getCounter6() + 2) {
							case 1:
								field31.setForeground(yellow);
								field31.setText("O");
								break;
							case 2:
								field32.setForeground(yellow);
								field32.setText("O");
								break;
							case 3:
								field33.setForeground(yellow);
								field33.setText("O");
								break;
							case 4:
								field34.setForeground(yellow);
								field34.setText("O");
								break;
							case 5:
								field35.setForeground(yellow);
								field35.setText("O");
								break;
							case 6:
								field36.setForeground(yellow);
								field36.setText("O");
								break;
							}

							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");

							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
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
						// ako je igrac 1 na potezu posalji x
						if (information.getText().equals(p1)) {
							game.input(7, R);

							// u avisnosti koji broj vrati metoda postavi crvenu boju
							switch (game.getCounter7() + 2) {
							case 1:
								field37.setForeground(red);
								field37.setText("O");
								break;
							case 2:
								field38.setForeground(red);
								field38.setText("O");
								break;
							case 3:
								field39.setForeground(red);
								field39.setText("O");
								break;
							case 4:
								field40.setForeground(red);
								field40.setText("O");
								break;
							case 5:
								field41.setForeground(red);
								field41.setText("O");
								break;
							case 6:
								field42.setForeground(red);
								field42.setText("O");
								break;
							}

							// postavljamo na informacije da je na potezu 2 igrac
							information.setText(p2);

							// u slucaju pobede
							if (game.win().equals("Win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");

							} else if (game.win().equals("Win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						} else {
							// u slucaju da je na potezu 2 igrac
							game.input(7, Y);

							// u avisnosti koji broj vrati metoda postavi zutu boju
							switch (game.getCounter7() + 2) {
							case 1:
								field37.setForeground(yellow);
								field37.setText("O");
								break;
							case 2:
								field38.setForeground(yellow);
								field38.setText("O");
								break;
							case 3:
								field39.setForeground(yellow);
								field39.setText("O");
								break;
							case 4:
								field40.setForeground(yellow);
								field40.setText("O");
								break;
							case 5:
								field41.setForeground(yellow);
								field41.setText("O");
								break;
							case 6:
								field42.setForeground(yellow);
								field42.setText("O");
								break;
							}

							information.setText(p1);

							// u slucaju pobede
							if (game.win().equals("win R")) {
								window2.setVisible(true);
								result.setText("He won the player 1 with the color red!!!");
							} else if (game.win().equals("win Y")) {
								window2.setVisible(true);
								result.setText("He won the player 2 with the color yellow !!!");
								// ili nereseno
							} else if (game.getCounter() == 42) {
								window2.setVisible(true);
								result.setText("Draws!!!");
							}
						}
					}
				};
				button7.addActionListener(al7);

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
