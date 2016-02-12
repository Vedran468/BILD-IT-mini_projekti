package mini_4_Battleship_i_Hangman;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Vedran Vidakovic
 *
 */
public class Z1JD_Brodici {

	// data field za prozor
	private JFrame window2 = new JFrame("Battleship");

	// informacije potrebne za igru
	private String s1 = "Vi ste na potezu Izaberite jedno dugme od desne strane polja :";
	private String s3 = "\"X\"  oznacava da se u tom polju nalzi vas brod.";
	private String s4 = "\"bela boja\"  oznacava da se pogodili brod, a \"plava\" da ste promasili.";

	// 100 dugmadi koji prikazuju da li je polje bilo birano od strane racunara
	JButton playerB[][] = {
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() } };

	// 100 dugmadi za izbor napada brodica racunara
	JButton compB[][] = {
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() },
			{ new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(), new JButton(),
					new JButton(), new JButton(), new JButton() } };

	// 100 polja za prikazivanje brodica korisnika gde se nalazi
	JTextArea[][] playerTA = {
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() } };

	// 100 polja za prikazivanje brodica racunara gde se nalazi
	JTextArea[][] compTA = {
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() },
			{ new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea(),
					new JTextArea(), new JTextArea(), new JTextArea(), new JTextArea() } };

	// polja sa informacijama
	JLabel information1 = new JLabel(s1);
	JLabel information2 = new JLabel(s3);
	JLabel information3 = new JLabel(s4);

	// pane le za prikaz plave boje
	JPanel playerP = new JPanel();
	JPanel compP = new JPanel();

	// objekti klasa za koje pozivamo metode
	Z1Battleship s = new Z1Battleship();
	Z1JD_AgainBattleship a = new Z1JD_AgainBattleship();

	// no-arg konstruktor
	public Z1JD_Brodici() {

	}

	public void displeyShips() throws FileNotFoundException {

		// definisemo raspored prozora i panela ne postoji
		window2.setLayout(null);
		playerP.setLayout(null);
		compP.setLayout(null);

		// dodajemo prozoru
		window2.add(playerP);
		window2.add(compP);
		window2.add(information1);
		window2.add(information2);
		window2.add(information3);

		// podesavamo gde ce se nalaziti na prozoru
		playerP.setBounds(49, 249, 402, 402);
		compP.setBounds(549, 249, 402, 402);
		information1.setBounds(300, 50, 500, 50);
		information2.setBounds(50, 150, 400, 50);
		information3.setBounds(550, 150, 400, 50);

		// panele imaju boju plavu kao pozadina
		playerP.setBackground(Color.blue);
		compP.setBackground(Color.blue);

		// velicina prozora
		window2.setSize(1050, 750);
		// vidljivos da
		window2.setVisible(true);
		// pri zatvaranju prozora zatvori i program
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// varijable za pomeranje po x i y
		int x = 0;
		int y = 0;

		// citanje korisnikovg unosa
		java.io.File file = new java.io.File("unos brodica.txt");
		Scanner input = new Scanner(file);
		String[][] mP = new String[10][10];
		while (input.hasNext()) {
			for (int i = 0; i < playerB.length; i++) {
				for (int j = 0; j < playerB[i].length; j++) {
					mP[i][j] = input.next();
				}
			}
		}
		input.close();

		// uzimanje podataka o brodicima racunara
		char[][] mC = s.listCharakersComp();
		Font font = new Font("Serif", Font.BOLD, 12);

		for (int i = 0; i < playerB.length; i++) {
			for (int j = 0; j < playerB[i].length; j++) {
				// dodavanje paneli i podesavanje polozaja na paneli
				playerP.add(playerB[i][j]);
				playerP.add(playerTA[i][j]);
				playerB[i][j].setBounds(1 + x, 1 + y, 40, 40);
				playerTA[i][j].setBounds(1 + x, 1 + y, 40, 40);
				x += 40;
				playerB[i][j].setVisible(true);

				// prikaz polja kao je iz matrice na istoj kordinati "x"
				if (mP[i][j].equals("X")) {
					playerB[i][j].setFont(font);
					playerB[i][j].setText("x");
					playerTA[i][j].setVisible(true);
				} else {
					playerTA[i][j].setVisible(false);
				}
			}
			x = 0;
			y += 40;
		}
		x = 0;
		y = 0;
		for (int i = 0; i < compB.length; i++) {
			for (int j = 0; j < compB[i].length; j++) {
				// dodavanje paneli i podesavanje polozaja na paneli
				compP.add(compB[i][j]);
				compP.add(compTA[i][j]);
				compB[i][j].setBounds(1 + x, 1 + y, 40, 40);
				compTA[i][j].setBounds(1 + x, 1 + y, 40, 40);
				x += 40;

				// prikaz polja kao je iz matrice na istoj kordinati "x"
				if (mC[i][j] == 'X') {
					compTA[i][j].setVisible(true);
				} else {
					compTA[i][j].setVisible(false);
				}
			}
			x = 0;
			y += 40;
		}

		// ZA 100 DUGMADI ISTA AKCIJA SAMO SE KORDINATE MENJAJU A AKCIJE SU
		// SLANJE KORDINATE KOJA SE NAPADA, SAKRIVANJE DUGMETA KOJE JE POZVANO I
		// POSTAVLJANJE REZULTATA AKO JE POBEDA KOMPJUTERA ILI KORISNIKA I
		// POZIVANJE METODE SA BROJEM POLJA KOJE KOMPJUTER NAPADA
		ActionListener al00 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[0][0].setVisible(false);
				s.hitPlayer(0, 0);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[0][0].addActionListener(al00);

		ActionListener al01 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[0][1].setVisible(false);
				s.hitPlayer(0, 1);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[0][1].addActionListener(al01);

		ActionListener al02 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[0][2].setVisible(false);
				s.hitPlayer(0, 2);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[0][2].addActionListener(al02);

		ActionListener al03 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[0][3].setVisible(false);
				s.hitPlayer(0, 3);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[0][3].addActionListener(al03);

		ActionListener al04 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[0][4].setVisible(false);
				s.hitPlayer(0, 4);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[0][4].addActionListener(al04);

		ActionListener al05 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[0][5].setVisible(false);
				s.hitPlayer(0, 5);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[0][5].addActionListener(al05);

		ActionListener al06 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[0][6].setVisible(false);
				s.hitPlayer(0, 6);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[0][6].addActionListener(al06);

		ActionListener al07 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[0][7].setVisible(false);
				s.hitPlayer(0, 7);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				}
			}
		};
		compB[0][7].addActionListener(al07);

		ActionListener al08 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[0][8].setVisible(false);
				s.hitPlayer(0, 8);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[0][8].addActionListener(al08);

		ActionListener al09 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[0][9].setVisible(false);
				s.hitPlayer(0, 9);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};

		compB[0][9].addActionListener(al09);

		ActionListener al10 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[1][0].setVisible(false);
				s.hitPlayer(1, 0);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[1][0].addActionListener(al10);

		ActionListener al11 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[1][1].setVisible(false);
				s.hitPlayer(1, 1);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[1][1].addActionListener(al11);

		ActionListener al12 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[1][2].setVisible(false);
				s.hitPlayer(1, 2);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[1][2].addActionListener(al12);

		ActionListener al13 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[1][3].setVisible(false);
				s.hitPlayer(1, 3);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[1][3].addActionListener(al13);

		ActionListener al14 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[1][4].setVisible(false);
				s.hitPlayer(1, 4);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[1][4].addActionListener(al14);

		ActionListener al15 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[1][5].setVisible(false);
				s.hitPlayer(1, 5);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[1][5].addActionListener(al15);

		ActionListener al16 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[1][6].setVisible(false);
				s.hitPlayer(1, 6);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[1][6].addActionListener(al16);

		ActionListener al17 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[1][7].setVisible(false);
				s.hitPlayer(1, 7);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[1][7].addActionListener(al17);

		ActionListener al18 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[1][8].setVisible(false);
				s.hitPlayer(1, 8);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[1][8].addActionListener(al18);

		ActionListener al19 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[1][9].setVisible(false);
				s.hitPlayer(1, 9);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[1][9].addActionListener(al19);

		ActionListener al20 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[2][0].setVisible(false);
				s.hitPlayer(2, 0);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[2][0].addActionListener(al20);

		ActionListener al21 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[2][1].setVisible(false);
				s.hitPlayer(2, 1);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[2][1].addActionListener(al21);

		ActionListener al22 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[2][2].setVisible(false);
				s.hitPlayer(2, 2);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[2][2].addActionListener(al22);

		ActionListener al23 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[2][3].setVisible(false);
				s.hitPlayer(2, 3);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[2][3].addActionListener(al23);

		ActionListener al24 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[2][4].setVisible(false);
				s.hitPlayer(2, 4);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[2][4].addActionListener(al24);

		ActionListener al25 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[2][5].setVisible(false);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[2][5].addActionListener(al25);

		ActionListener al26 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[2][6].setVisible(false);
				s.hitPlayer(2, 6);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[2][6].addActionListener(al26);

		ActionListener al27 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[2][7].setVisible(false);
				s.hitPlayer(2, 7);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[2][7].addActionListener(al27);

		ActionListener al28 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[2][8].setVisible(false);
				s.hitPlayer(2, 8);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[2][8].addActionListener(al28);

		ActionListener al29 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[2][9].setVisible(false);
				s.hitPlayer(2, 9);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[2][9].addActionListener(al29);

		ActionListener al30 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[3][0].setVisible(false);
				s.hitPlayer(3, 0);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[3][0].addActionListener(al30);

		ActionListener al31 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[3][1].setVisible(false);
				s.hitPlayer(3, 1);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[3][1].addActionListener(al31);

		ActionListener al32 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[3][2].setVisible(false);
				s.hitPlayer(3, 2);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[3][2].addActionListener(al32);

		ActionListener al33 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[3][3].setVisible(false);
				s.hitPlayer(3, 3);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[3][3].addActionListener(al33);

		ActionListener al34 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[3][4].setVisible(false);
				s.hitPlayer(3, 4);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[3][4].addActionListener(al34);

		ActionListener al35 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[3][5].setVisible(false);
				s.hitPlayer(3, 5);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[3][5].addActionListener(al35);

		ActionListener al36 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[3][6].setVisible(false);
				s.hitPlayer(3, 6);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[3][6].addActionListener(al36);

		ActionListener al37 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[3][7].setVisible(false);
				s.hitPlayer(3, 7);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[3][7].addActionListener(al37);

		ActionListener al38 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[3][8].setVisible(false);
				s.hitPlayer(3, 8);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[3][8].addActionListener(al38);

		ActionListener al39 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[3][9].setVisible(false);
				s.hitPlayer(3, 9);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[3][9].addActionListener(al39);

		ActionListener al40 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[4][0].setVisible(false);
				s.hitPlayer(4, 0);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[4][0].addActionListener(al40);

		ActionListener al41 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[4][1].setVisible(false);
				s.hitPlayer(4, 1);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[4][1].addActionListener(al41);

		ActionListener al42 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[4][2].setVisible(false);
				s.hitPlayer(4, 2);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[4][2].addActionListener(al42);

		ActionListener al43 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[4][3].setVisible(false);
				s.hitPlayer(4, 3);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[4][3].addActionListener(al43);

		ActionListener al44 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[4][4].setVisible(false);
				s.hitPlayer(4, 4);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[4][4].addActionListener(al44);

		ActionListener al45 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[4][5].setVisible(false);
				s.hitPlayer(4, 5);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[4][5].addActionListener(al45);

		ActionListener al46 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[4][6].setVisible(false);
				s.hitPlayer(4, 6);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[4][6].addActionListener(al46);

		ActionListener al47 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[4][7].setVisible(false);
				s.hitPlayer(4, 7);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[4][7].addActionListener(al47);

		ActionListener al48 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[4][8].setVisible(false);
				s.hitPlayer(4, 8);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[4][8].addActionListener(al48);

		ActionListener al49 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[4][9].setVisible(false);
				s.hitPlayer(4, 9);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[4][9].addActionListener(al49);

		ActionListener al50 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[5][0].setVisible(false);
				s.hitPlayer(5, 0);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[5][0].addActionListener(al50);

		ActionListener al51 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[5][1].setVisible(false);
				s.hitPlayer(5, 1);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[5][1].addActionListener(al51);

		ActionListener al52 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[5][2].setVisible(false);
				s.hitPlayer(5, 2);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[5][2].addActionListener(al52);

		ActionListener al53 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[5][3].setVisible(false);
				s.hitPlayer(5, 3);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[5][3].addActionListener(al53);

		ActionListener al54 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[5][4].setVisible(false);
				s.hitPlayer(5, 4);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[5][4].addActionListener(al54);

		ActionListener al55 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[5][5].setVisible(false);
				s.hitPlayer(5, 5);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[5][5].addActionListener(al55);

		ActionListener al56 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[5][6].setVisible(false);
				s.hitPlayer(5, 6);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[5][6].addActionListener(al56);

		ActionListener al57 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[5][7].setVisible(false);
				s.hitPlayer(5, 7);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[5][7].addActionListener(al57);

		ActionListener al58 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[5][8].setVisible(false);
				s.hitPlayer(5, 8);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[5][8].addActionListener(al58);

		ActionListener al59 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[5][9].setVisible(false);
				s.hitPlayer(5, 9);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};

		compB[5][9].addActionListener(al59);

		ActionListener al60 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[6][0].setVisible(false);
				s.hitPlayer(6, 0);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[6][0].addActionListener(al60);

		ActionListener al61 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[6][1].setVisible(false);
				s.hitPlayer(6, 1);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[6][1].addActionListener(al61);

		ActionListener al62 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[6][2].setVisible(false);
				s.hitPlayer(6, 2);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[6][2].addActionListener(al62);

		ActionListener al63 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[6][3].setVisible(false);
				s.hitPlayer(6, 3);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[6][3].addActionListener(al63);

		ActionListener al64 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[6][4].setVisible(false);
				s.hitPlayer(6, 4);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[6][4].addActionListener(al64);

		ActionListener al65 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[6][5].setVisible(false);
				s.hitPlayer(6, 5);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[6][5].addActionListener(al65);

		ActionListener al66 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[6][6].setVisible(false);
				s.hitPlayer(6, 6);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[6][6].addActionListener(al66);

		ActionListener al67 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[6][7].setVisible(false);
				s.hitPlayer(6, 7);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[6][7].addActionListener(al67);

		ActionListener al68 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[6][8].setVisible(false);
				s.hitPlayer(6, 8);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[6][8].addActionListener(al68);

		ActionListener al69 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[6][9].setVisible(false);
				s.hitPlayer(6, 9);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[6][9].addActionListener(al69);

		ActionListener al70 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[7][0].setVisible(false);
				s.hitPlayer(7, 0);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[7][0].addActionListener(al70);

		ActionListener al71 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[7][1].setVisible(false);
				s.hitPlayer(7, 1);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[7][1].addActionListener(al71);

		ActionListener al72 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[7][2].setVisible(false);
				s.hitPlayer(7, 2);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[7][2].addActionListener(al72);

		ActionListener al73 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[7][3].setVisible(false);
				s.hitPlayer(7, 3);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[7][3].addActionListener(al73);

		ActionListener al74 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[7][4].setVisible(false);
				s.hitPlayer(7, 4);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[7][4].addActionListener(al74);

		ActionListener al75 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[7][5].setVisible(false);
				s.hitPlayer(7, 5);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[7][5].addActionListener(al75);

		ActionListener al76 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[7][6].setVisible(false);
				s.hitPlayer(7, 6);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[7][6].addActionListener(al76);

		ActionListener al77 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[7][7].setVisible(false);
				s.hitPlayer(7, 7);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[7][7].addActionListener(al77);

		ActionListener al78 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[7][8].setVisible(false);
				s.hitPlayer(7, 8);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[7][8].addActionListener(al78);

		ActionListener al79 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[7][9].setVisible(false);
				s.hitPlayer(7, 9);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[7][9].addActionListener(al79);

		ActionListener al80 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[8][0].setVisible(false);
				s.hitPlayer(8, 0);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[8][0].addActionListener(al80);

		ActionListener al81 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[8][1].setVisible(false);
				s.hitPlayer(8, 1);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[8][1].addActionListener(al81);

		ActionListener al82 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[8][2].setVisible(false);
				s.hitPlayer(8, 2);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[8][2].addActionListener(al82);

		ActionListener al83 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[8][3].setVisible(false);
				s.hitPlayer(8, 3);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[8][3].addActionListener(al83);

		ActionListener al84 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[8][4].setVisible(false);
				s.hitPlayer(8, 4);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[8][4].addActionListener(al84);

		ActionListener al85 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[8][5].setVisible(false);
				s.hitPlayer(8, 5);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[8][5].addActionListener(al85);

		ActionListener al86 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[8][6].setVisible(false);
				s.hitPlayer(8, 6);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[8][6].addActionListener(al86);

		ActionListener al87 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[8][7].setVisible(false);
				s.hitPlayer(8, 7);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[8][7].addActionListener(al87);

		ActionListener al88 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[8][8].setVisible(false);
				s.hitPlayer(8, 8);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[8][8].addActionListener(al88);

		ActionListener al89 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[8][9].setVisible(false);
				s.hitPlayer(8, 9);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[8][9].addActionListener(al89);

		ActionListener al90 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[9][0].setVisible(false);
				s.hitPlayer(9, 0);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[9][0].addActionListener(al90);

		ActionListener al91 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[9][1].setVisible(false);
				s.hitPlayer(9, 1);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[9][1].addActionListener(al91);

		ActionListener al92 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[9][2].setVisible(false);
				s.hitPlayer(9, 2);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[9][2].addActionListener(al92);

		ActionListener al93 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[9][3].setVisible(false);
				s.hitPlayer(9, 3);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[9][3].addActionListener(al93);

		ActionListener al94 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[9][4].setVisible(false);
				s.hitPlayer(9, 4);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[9][4].addActionListener(al94);

		ActionListener al95 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[9][5].setVisible(false);
				s.hitPlayer(9, 5);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[9][5].addActionListener(al95);

		ActionListener al96 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[9][6].setVisible(false);
				s.hitPlayer(9, 6);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[9][6].addActionListener(al96);

		ActionListener al97 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[9][7].setVisible(false);
				s.hitPlayer(9, 7);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[9][7].addActionListener(al97);

		ActionListener al98 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[9][8].setVisible(false);
				s.hitPlayer(9, 8);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {
					number();
				}
			}
		};
		compB[9][8].addActionListener(al98);

		ActionListener al99 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				compB[9][9].setVisible(false);
				s.hitPlayer(9, 9);
				if (s.winPlayer()) {
					a.getResult().setText("Vi ste pobedili!!!");
					a.again();
					window2.setVisible(false);
				} else if (s.winComp()) {
					a.getResult().setText("Vi ste igubili!!!");
					a.again();
					window2.setVisible(false);
				} else {

					number();
				}
			}
		};
		compB[9][9].addActionListener(al99);

	}

	public void number() {
		// U ZAVISNOSTI KOJE POLJE NAPADA KOMPJUTER ZA NJEGA POLJI KORDINATE I
		// TO DUGME SAKRIJ KOD KORISNIKA DUGME I TAKO ZA 100 VARIJANTI POLJA
		int n = s.attack();
		switch (n) {
		case 0:
			s.hitComp(0, 0);
			playerB[0][0].setVisible(false);
			break;
		case 1:
			s.hitComp(0, 1);
			playerB[0][1].setVisible(false);
			break;
		case 2:
			s.hitComp(0, 2);
			playerB[0][2].setVisible(false);
			break;
		case 3:
			s.hitComp(0, 3);
			playerB[0][3].setVisible(false);
			break;
		case 4:
			s.hitComp(0, 4);
			playerB[0][4].setVisible(false);
			break;
		case 5:
			s.hitComp(0, 5);
			playerB[0][5].setVisible(false);
			break;
		case 6:
			s.hitComp(0, 6);
			playerB[0][6].setVisible(false);
			break;
		case 7:
			s.hitComp(0, 7);
			playerB[0][7].setVisible(false);
			break;
		case 8:
			s.hitComp(0, 8);
			playerB[0][8].setVisible(false);
			break;
		case 9:
			s.hitComp(0, 9);
			playerB[0][9].setVisible(false);
			break;
		case 10:
			s.hitComp(1, 0);
			playerB[1][0].setVisible(false);
			break;
		case 11:
			s.hitComp(1, 1);
			playerB[1][1].setVisible(false);
			break;
		case 12:
			s.hitComp(1, 2);
			playerB[1][2].setVisible(false);
			break;
		case 13:
			s.hitComp(1, 3);
			playerB[1][3].setVisible(false);
			break;
		case 14:
			s.hitComp(1, 4);
			playerB[1][4].setVisible(false);
			break;
		case 15:
			s.hitComp(1, 5);
			playerB[1][5].setVisible(false);
			break;
		case 16:
			s.hitComp(1, 6);
			playerB[1][6].setVisible(false);
			break;
		case 17:
			s.hitComp(1, 7);
			playerB[1][7].setVisible(false);
			break;
		case 18:
			s.hitComp(1, 8);
			playerB[1][8].setVisible(false);
			break;
		case 19:
			s.hitComp(1, 9);
			playerB[1][9].setVisible(false);
			break;
		case 20:
			s.hitComp(2, 0);
			playerB[2][0].setVisible(false);
			break;
		case 21:
			s.hitComp(2, 1);
			playerB[2][1].setVisible(false);
			break;
		case 22:
			s.hitComp(2, 2);
			playerB[2][2].setVisible(false);
			break;
		case 23:
			s.hitComp(2, 3);
			playerB[2][3].setVisible(false);
			break;
		case 24:
			s.hitComp(2, 4);
			playerB[2][4].setVisible(false);
			break;
		case 25:
			s.hitComp(2, 5);
			playerB[2][5].setVisible(false);
			break;
		case 26:
			s.hitComp(2, 6);
			playerB[2][6].setVisible(false);
			break;
		case 27:
			s.hitComp(2, 7);
			playerB[2][7].setVisible(false);
			break;
		case 28:
			s.hitComp(2, 8);
			playerB[2][8].setVisible(false);
			break;
		case 29:
			s.hitComp(2, 9);
			playerB[2][9].setVisible(false);
			break;
		case 30:
			s.hitComp(3, 0);
			playerB[3][0].setVisible(false);
			break;
		case 31:
			s.hitComp(3, 1);
			playerB[3][0].setVisible(false);
			break;
		case 32:
			s.hitComp(3, 2);
			playerB[3][2].setVisible(false);
			break;
		case 33:
			s.hitComp(3, 3);
			playerB[3][3].setVisible(false);
			break;
		case 34:
			s.hitComp(3, 4);
			playerB[3][4].setVisible(false);
			break;
		case 35:
			s.hitComp(3, 5);
			playerB[3][5].setVisible(false);
			break;
		case 36:
			s.hitComp(3, 6);
			playerB[3][6].setVisible(false);
			break;
		case 37:
			s.hitComp(3, 7);
			playerB[3][7].setVisible(false);
			break;
		case 38:
			s.hitComp(3, 8);
			playerB[3][8].setVisible(false);
			break;
		case 39:
			s.hitComp(3, 9);
			playerB[3][9].setVisible(false);
			break;
		case 40:
			s.hitComp(4, 0);
			playerB[4][0].setVisible(false);
			break;
		case 41:
			s.hitComp(4, 1);
			playerB[4][1].setVisible(false);
			break;
		case 42:
			s.hitComp(4, 2);
			playerB[4][2].setVisible(false);
			break;
		case 43:
			s.hitComp(4, 3);
			playerB[4][3].setVisible(false);
			break;
		case 44:
			s.hitComp(4, 4);
			playerB[4][4].setVisible(false);
			break;
		case 45:
			s.hitComp(4, 5);
			playerB[4][5].setVisible(false);
			break;
		case 46:
			s.hitComp(4, 6);
			playerB[4][6].setVisible(false);
			break;
		case 47:
			s.hitComp(4, 7);
			playerB[4][7].setVisible(false);
			break;
		case 48:
			s.hitComp(4, 8);
			playerB[4][8].setVisible(false);
			break;
		case 49:
			s.hitComp(4, 9);
			playerB[4][9].setVisible(false);
			break;
		case 50:
			s.hitComp(5, 0);
			playerB[5][0].setVisible(false);
			break;
		case 51:
			s.hitComp(5, 1);
			playerB[5][1].setVisible(false);
			break;
		case 52:
			s.hitComp(5, 2);
			playerB[5][2].setVisible(false);
			break;
		case 53:
			s.hitComp(5, 3);
			playerB[5][3].setVisible(false);
			break;
		case 54:
			s.hitComp(5, 4);
			playerB[5][4].setVisible(false);
			break;
		case 55:
			s.hitComp(5, 5);
			playerB[5][5].setVisible(false);
			break;
		case 56:
			s.hitComp(5, 6);
			playerB[5][6].setVisible(false);
			break;
		case 57:
			s.hitComp(5, 7);
			playerB[5][7].setVisible(false);
			break;
		case 58:
			s.hitComp(5, 8);
			playerB[5][8].setVisible(false);
			break;
		case 59:
			s.hitComp(5, 9);
			playerB[5][9].setVisible(false);
			break;
		case 60:
			s.hitComp(6, 0);
			playerB[6][0].setVisible(false);
			break;
		case 61:
			s.hitComp(6, 1);
			playerB[6][1].setVisible(false);
			break;
		case 62:
			s.hitComp(6, 2);
			playerB[6][2].setVisible(false);
			break;
		case 63:
			s.hitComp(6, 3);
			playerB[6][3].setVisible(false);
			break;
		case 64:
			s.hitComp(6, 4);
			playerB[6][4].setVisible(false);
			break;
		case 65:
			s.hitComp(6, 5);
			playerB[6][5].setVisible(false);
			break;
		case 66:
			s.hitComp(6, 6);
			playerB[6][6].setVisible(false);
			break;
		case 67:
			s.hitComp(6, 7);
			playerB[6][7].setVisible(false);
			break;
		case 68:
			s.hitComp(6, 8);
			playerB[6][8].setVisible(false);
			break;
		case 69:
			s.hitComp(6, 9);
			playerB[6][9].setVisible(false);
			break;
		case 70:
			s.hitComp(7, 0);
			playerB[7][0].setVisible(false);
			break;
		case 71:
			s.hitComp(7, 1);
			playerB[7][1].setVisible(false);
			break;
		case 72:
			s.hitComp(7, 2);
			playerB[7][2].setVisible(false);
			break;
		case 73:
			s.hitComp(7, 3);
			playerB[7][3].setVisible(false);
			break;
		case 74:
			s.hitComp(7, 4);
			playerB[7][4].setVisible(false);
			break;
		case 75:
			s.hitComp(7, 5);
			playerB[7][5].setVisible(false);
			break;
		case 76:
			s.hitComp(7, 6);
			playerB[7][6].setVisible(false);
			break;
		case 77:
			s.hitComp(7, 7);
			playerB[7][7].setVisible(false);
			break;
		case 78:
			s.hitComp(7, 8);
			playerB[7][8].setVisible(false);
			break;
		case 79:
			s.hitComp(7, 9);
			playerB[7][9].setVisible(false);
			break;
		case 80:
			s.hitComp(8, 0);
			playerB[8][0].setVisible(false);
			break;
		case 81:
			s.hitComp(8, 1);
			playerB[8][1].setVisible(false);
			break;
		case 82:
			s.hitComp(8, 2);
			playerB[8][2].setVisible(false);
			break;
		case 83:
			s.hitComp(8, 3);
			playerB[8][3].setVisible(false);
			break;
		case 84:
			s.hitComp(8, 4);
			playerB[8][4].setVisible(false);
			break;
		case 85:
			s.hitComp(8, 5);
			playerB[8][5].setVisible(false);
			break;
		case 86:
			s.hitComp(8, 6);
			playerB[8][6].setVisible(false);
			break;
		case 87:
			s.hitComp(8, 7);
			playerB[8][7].setVisible(false);
			break;
		case 88:
			s.hitComp(8, 8);
			playerB[8][8].setVisible(false);
			break;
		case 89:
			s.hitComp(8, 9);
			playerB[8][9].setVisible(false);
			break;
		case 90:
			s.hitComp(9, 0);
			playerB[9][0].setVisible(false);
			break;
		case 91:
			s.hitComp(9, 1);
			playerB[9][1].setVisible(false);
			break;
		case 92:
			s.hitComp(9, 2);
			playerB[9][2].setVisible(false);
			break;
		case 93:
			s.hitComp(9, 3);
			playerB[9][3].setVisible(false);
			break;
		case 94:
			s.hitComp(9, 4);
			playerB[9][4].setVisible(false);
			break;
		case 95:
			s.hitComp(9, 5);
			playerB[9][5].setVisible(false);
			break;
		case 96:
			s.hitComp(9, 6);
			playerB[9][6].setVisible(false);
			break;
		case 97:
			s.hitComp(9, 7);
			playerB[9][7].setVisible(false);
			break;
		case 98:
			s.hitComp(9, 8);
			playerB[9][8].setVisible(false);
			break;
		case 99:
			s.hitComp(9, 9);
			playerB[9][9].setVisible(false);
			break;
		}
	}

	// AKO JE NEKOM MRSKO UNOSITI POLJA NEKA POKRENE OVU METODU
	/*
	 * public static void main(String[] args) throws FileNotFoundException {
	 * Z1JD_Brodici b = new Z1JD_Brodici(); b.displeyShips(); }
	 */
}
