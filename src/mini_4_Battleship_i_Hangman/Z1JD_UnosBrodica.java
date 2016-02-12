package mini_4_Battleship_i_Hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author Vedran Vidakovic
 *
 */
public class Z1JD_UnosBrodica {

	// polje podatka za prozor
	private JFrame window1 = new JFrame("Unos brodica");

	// no-arg konstruktor
	public Z1JD_UnosBrodica() {

	}

	public void displeyInputShips() {
		// stringovi sa informacijama
		final String s1 = "Postavljate brod \"Nosac aviona\" koji ima 5 polja:";
		final String s2 = "Postavljate brod \"Vojni brod\" koji ima 4 polja:";
		final String s3 = "Postavljate brod \"Podmornicu\" koji ima 3 polja:";
		final String s5 = "Postavljate brod \"Patrolni brod\" koji ima 2 polja:";
		final String s = "Unesite u prvo polje broj od 1 do 10, ";
		final String ss1 = "a udrugo slovoa od \"A\" do \"J\" da oznacite prvo polje broda:";
		final String e = "Promenite unos, ovaj ne moze biti ostvaren!!!";
		final String ss = "Zatim polozaj da li zelite da vertikalni ili horizontalni, pritisnute odredjeno dugme:";

		// definisemo da raspored prozora nije definisan
		window1.setLayout(null);

		// polja sa informacijama
		JLabel information1 = new JLabel(s1);
		JLabel information2 = new JLabel(s);
		JLabel information3 = new JLabel(ss1);
		JLabel information4 = new JLabel(ss);
		JLabel information5 = new JLabel();
		JLabel information6 = new JLabel(
				"Unos nece biti ostvaren ako nije razmak izmedju brodova najmanje jedno polje!!!");
		JLabel n1 = new JLabel("1");
		JLabel n2 = new JLabel("2");
		JLabel n3 = new JLabel("3");
		JLabel n4 = new JLabel("4");
		JLabel n5 = new JLabel("5");
		JLabel n6 = new JLabel("6");
		JLabel n7 = new JLabel("7");
		JLabel n8 = new JLabel("8");
		JLabel n9 = new JLabel("9");
		JLabel n10 = new JLabel("10");
		JLabel letters = new JLabel(
				"        A          B         C          D          E          F          G          H          I          J");

		// polje za unos slova i broja
		final JTextField letter = new JTextField(20);
		final JTextField number = new JTextField(20);

		// dugme za vertikalan i horizontalan polozaj
		JButton vertical = new JButton("v\ne\nr\nt\ni\nk\na\nl\nn\no");
		JButton horizontally = new JButton("horizontalno");

		// polja gde se prikazuju sa "x" polje brodica
		JTextField field0 = new JTextField();
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		JTextField field3 = new JTextField();
		JTextField field4 = new JTextField();
		JTextField field5 = new JTextField();
		JTextField field6 = new JTextField();
		JTextField field7 = new JTextField();
		JTextField field8 = new JTextField();
		JTextField field9 = new JTextField();
		JTextField field10 = new JTextField();
		JTextField field11 = new JTextField();
		JTextField field12 = new JTextField();
		JTextField field13 = new JTextField();
		JTextField field14 = new JTextField();
		JTextField field15 = new JTextField();
		JTextField field16 = new JTextField();
		JTextField field17 = new JTextField();
		JTextField field18 = new JTextField();
		JTextField field19 = new JTextField();
		JTextField field20 = new JTextField();
		JTextField field21 = new JTextField();
		JTextField field22 = new JTextField();
		JTextField field23 = new JTextField();
		JTextField field24 = new JTextField();
		JTextField field25 = new JTextField();
		JTextField field26 = new JTextField();
		JTextField field27 = new JTextField();
		JTextField field28 = new JTextField();
		JTextField field29 = new JTextField();
		JTextField field30 = new JTextField();
		JTextField field31 = new JTextField();
		JTextField field32 = new JTextField();
		JTextField field33 = new JTextField();
		JTextField field34 = new JTextField();
		JTextField field35 = new JTextField();
		JTextField field36 = new JTextField();
		JTextField field37 = new JTextField();
		JTextField field38 = new JTextField();
		JTextField field39 = new JTextField();
		JTextField field40 = new JTextField();
		JTextField field41 = new JTextField();
		JTextField field42 = new JTextField();
		JTextField field43 = new JTextField();
		JTextField field44 = new JTextField();
		JTextField field45 = new JTextField();
		JTextField field46 = new JTextField();
		JTextField field47 = new JTextField();
		JTextField field48 = new JTextField();
		JTextField field49 = new JTextField();
		JTextField field50 = new JTextField();
		JTextField field51 = new JTextField();
		JTextField field52 = new JTextField();
		JTextField field53 = new JTextField();
		JTextField field54 = new JTextField();
		JTextField field55 = new JTextField();
		JTextField field56 = new JTextField();
		JTextField field57 = new JTextField();
		JTextField field58 = new JTextField();
		JTextField field59 = new JTextField();
		JTextField field60 = new JTextField();
		JTextField field61 = new JTextField();
		JTextField field62 = new JTextField();
		JTextField field63 = new JTextField();
		JTextField field64 = new JTextField();
		JTextField field65 = new JTextField();
		JTextField field66 = new JTextField();
		JTextField field67 = new JTextField();
		JTextField field68 = new JTextField();
		JTextField field69 = new JTextField();
		JTextField field70 = new JTextField();
		JTextField field71 = new JTextField();
		JTextField field72 = new JTextField();
		JTextField field73 = new JTextField();
		JTextField field74 = new JTextField();
		JTextField field75 = new JTextField();
		JTextField field76 = new JTextField();
		JTextField field77 = new JTextField();
		JTextField field78 = new JTextField();
		JTextField field79 = new JTextField();
		JTextField field80 = new JTextField();
		JTextField field81 = new JTextField();
		JTextField field82 = new JTextField();
		JTextField field83 = new JTextField();
		JTextField field84 = new JTextField();
		JTextField field85 = new JTextField();
		JTextField field86 = new JTextField();
		JTextField field87 = new JTextField();
		JTextField field88 = new JTextField();
		JTextField field89 = new JTextField();
		JTextField field90 = new JTextField();
		JTextField field91 = new JTextField();
		JTextField field92 = new JTextField();
		JTextField field93 = new JTextField();
		JTextField field94 = new JTextField();
		JTextField field95 = new JTextField();
		JTextField field96 = new JTextField();
		JTextField field97 = new JTextField();
		JTextField field98 = new JTextField();
		JTextField field99 = new JTextField();

		// sve elemente dodajemo prozoru
		window1.add(information1);
		window1.add(information2);
		window1.add(information3);
		window1.add(information4);
		window1.add(information5);
		window1.add(information6);
		window1.add(letter);
		window1.add(letters);
		window1.add(number);
		window1.add(n1);
		window1.add(n2);
		window1.add(n3);
		window1.add(n4);
		window1.add(n5);
		window1.add(n6);
		window1.add(n7);
		window1.add(n8);
		window1.add(n9);
		window1.add(n10);
		window1.add(vertical);
		window1.add(horizontally);
		window1.add(field0);
		window1.add(field1);
		window1.add(field2);
		window1.add(field3);
		window1.add(field4);
		window1.add(field5);
		window1.add(field6);
		window1.add(field7);
		window1.add(field8);
		window1.add(field9);
		window1.add(field10);
		window1.add(field10);
		window1.add(field11);
		window1.add(field12);
		window1.add(field13);
		window1.add(field14);
		window1.add(field15);
		window1.add(field16);
		window1.add(field17);
		window1.add(field18);
		window1.add(field19);
		window1.add(field20);
		window1.add(field21);
		window1.add(field22);
		window1.add(field23);
		window1.add(field24);
		window1.add(field25);
		window1.add(field26);
		window1.add(field27);
		window1.add(field28);
		window1.add(field29);
		window1.add(field30);
		window1.add(field31);
		window1.add(field32);
		window1.add(field33);
		window1.add(field34);
		window1.add(field35);
		window1.add(field36);
		window1.add(field37);
		window1.add(field38);
		window1.add(field39);
		window1.add(field40);
		window1.add(field41);
		window1.add(field42);
		window1.add(field43);
		window1.add(field44);
		window1.add(field45);
		window1.add(field46);
		window1.add(field47);
		window1.add(field48);
		window1.add(field49);
		window1.add(field50);
		window1.add(field51);
		window1.add(field52);
		window1.add(field53);
		window1.add(field54);
		window1.add(field55);
		window1.add(field56);
		window1.add(field57);
		window1.add(field58);
		window1.add(field59);
		window1.add(field60);
		window1.add(field61);
		window1.add(field62);
		window1.add(field63);
		window1.add(field64);
		window1.add(field65);
		window1.add(field66);
		window1.add(field67);
		window1.add(field68);
		window1.add(field69);
		window1.add(field70);
		window1.add(field71);
		window1.add(field72);
		window1.add(field73);
		window1.add(field74);
		window1.add(field75);
		window1.add(field76);
		window1.add(field77);
		window1.add(field78);
		window1.add(field79);
		window1.add(field80);
		window1.add(field81);
		window1.add(field82);
		window1.add(field83);
		window1.add(field84);
		window1.add(field85);
		window1.add(field86);
		window1.add(field87);
		window1.add(field88);
		window1.add(field89);
		window1.add(field90);
		window1.add(field91);
		window1.add(field92);
		window1.add(field93);
		window1.add(field94);
		window1.add(field95);
		window1.add(field96);
		window1.add(field97);
		window1.add(field98);
		window1.add(field99);

		// podesavanje polzaja na prozoru svakog elementa
		letters.setBounds(60, 80, 500, 20);
		n1.setBounds(20, 100, 40, 40);
		n2.setBounds(20, 140, 40, 40);
		n3.setBounds(20, 180, 40, 40);
		n4.setBounds(20, 220, 40, 40);
		n5.setBounds(20, 260, 40, 40);
		n6.setBounds(20, 300, 40, 40);
		n7.setBounds(20, 340, 40, 40);
		n8.setBounds(20, 380, 40, 40);
		n9.setBounds(20, 420, 40, 40);
		n10.setBounds(20, 460, 40, 40);
		field0.setBounds(60, 100, 40, 40);
		field1.setBounds(100, 100, 40, 40);
		field2.setBounds(140, 100, 40, 40);
		field3.setBounds(180, 100, 40, 40);
		field4.setBounds(220, 100, 40, 40);
		field5.setBounds(260, 100, 40, 40);
		field6.setBounds(300, 100, 40, 40);
		field7.setBounds(340, 100, 40, 40);
		field8.setBounds(380, 100, 40, 40);
		field9.setBounds(420, 100, 40, 40);
		field10.setBounds(60, 140, 40, 40);
		field11.setBounds(100, 140, 40, 40);
		field12.setBounds(140, 140, 40, 40);
		field13.setBounds(180, 140, 40, 40);
		field14.setBounds(220, 140, 40, 40);
		field15.setBounds(260, 140, 40, 40);
		field16.setBounds(300, 140, 40, 40);
		field17.setBounds(340, 140, 40, 40);
		field18.setBounds(380, 140, 40, 40);
		field19.setBounds(420, 140, 40, 40);
		field20.setBounds(60, 180, 40, 40);
		field21.setBounds(100, 180, 40, 40);
		field22.setBounds(140, 180, 40, 40);
		field23.setBounds(180, 180, 40, 40);
		field24.setBounds(220, 180, 40, 40);
		field25.setBounds(260, 180, 40, 40);
		field26.setBounds(300, 180, 40, 40);
		field27.setBounds(340, 180, 40, 40);
		field28.setBounds(380, 180, 40, 40);
		field29.setBounds(420, 180, 40, 40);
		field30.setBounds(60, 220, 40, 40);
		field31.setBounds(100, 220, 40, 40);
		field32.setBounds(140, 220, 40, 40);
		field33.setBounds(180, 220, 40, 40);
		field34.setBounds(220, 220, 40, 40);
		field35.setBounds(260, 220, 40, 40);
		field36.setBounds(300, 220, 40, 40);
		field37.setBounds(340, 220, 40, 40);
		field38.setBounds(380, 220, 40, 40);
		field39.setBounds(420, 220, 40, 40);
		field40.setBounds(60, 260, 40, 40);
		field41.setBounds(100, 260, 40, 40);
		field42.setBounds(140, 260, 40, 40);
		field43.setBounds(180, 260, 40, 40);
		field44.setBounds(220, 260, 40, 40);
		field45.setBounds(260, 260, 40, 40);
		field46.setBounds(300, 260, 40, 40);
		field47.setBounds(340, 260, 40, 40);
		field48.setBounds(380, 260, 40, 40);
		field49.setBounds(420, 260, 40, 40);
		field50.setBounds(60, 300, 40, 40);
		field51.setBounds(100, 300, 40, 40);
		field52.setBounds(140, 300, 40, 40);
		field53.setBounds(180, 300, 40, 40);
		field54.setBounds(220, 300, 40, 40);
		field55.setBounds(260, 300, 40, 40);
		field56.setBounds(300, 300, 40, 40);
		field57.setBounds(340, 300, 40, 40);
		field58.setBounds(380, 300, 40, 40);
		field59.setBounds(420, 300, 40, 40);
		field60.setBounds(60, 340, 40, 40);
		field61.setBounds(100, 340, 40, 40);
		field62.setBounds(140, 340, 40, 40);
		field63.setBounds(180, 340, 40, 40);
		field64.setBounds(220, 340, 40, 40);
		field65.setBounds(260, 340, 40, 40);
		field66.setBounds(300, 340, 40, 40);
		field67.setBounds(340, 340, 40, 40);
		field68.setBounds(380, 340, 40, 40);
		field69.setBounds(420, 340, 40, 40);
		field70.setBounds(60, 380, 40, 40);
		field71.setBounds(100, 380, 40, 40);
		field72.setBounds(140, 380, 40, 40);
		field73.setBounds(180, 380, 40, 40);
		field74.setBounds(220, 380, 40, 40);
		field75.setBounds(260, 380, 40, 40);
		field76.setBounds(300, 380, 40, 40);
		field77.setBounds(340, 380, 40, 40);
		field78.setBounds(380, 380, 40, 40);
		field79.setBounds(420, 380, 40, 40);
		field80.setBounds(60, 420, 40, 40);
		field81.setBounds(100, 420, 40, 40);
		field82.setBounds(140, 420, 40, 40);
		field83.setBounds(180, 420, 40, 40);
		field84.setBounds(220, 420, 40, 40);
		field85.setBounds(260, 420, 40, 40);
		field86.setBounds(300, 420, 40, 40);
		field87.setBounds(340, 420, 40, 40);
		field88.setBounds(380, 420, 40, 40);
		field89.setBounds(420, 420, 40, 40);
		field90.setBounds(60, 460, 40, 40);
		field91.setBounds(100, 460, 40, 40);
		field92.setBounds(140, 460, 40, 40);
		field93.setBounds(180, 460, 40, 40);
		field94.setBounds(220, 460, 40, 40);
		field95.setBounds(260, 460, 40, 40);
		field96.setBounds(300, 460, 40, 40);
		field97.setBounds(340, 460, 40, 40);
		field98.setBounds(380, 460, 40, 40);
		field99.setBounds(420, 460, 40, 40);
		information1.setBounds(500, 100, 500, 40);
		information2.setBounds(500, 140, 500, 40);
		information3.setBounds(500, 180, 500, 40);
		information4.setBounds(500, 220, 500, 40);
		information6.setBounds(60, 30, 500, 40);
		number.setBounds(500, 260, 50, 40);
		letter.setBounds(560, 260, 50, 40);
		vertical.setBounds(620, 260, 110, 200);
		horizontally.setBounds(740, 260, 200, 50);
		information5.setBounds(500, 470, 500, 50);

		// velicina prozora
		window1.setSize(1000, 750);
		// vidljivos da
		window1.setVisible(true);
		// u slucaju izlaska da se zaustavi i program
		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// objekat klase sa metodama
		Z1Battleship b = new Z1Battleship();

		// za vertikalni polozaj dugme
		ActionListener al1 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					int y1 = Integer.parseInt(number.getText());
					// u zavisnosti sta koja metoda trazi saljemo podatke i
					// postavljamo vidljivost informacija o gresci
					b.setPosition("Vv");
					if (b.checkX(letter.getText().toUpperCase()) && b.checkY(y1)) {
						information5.setVisible(false);
						b.checkX(letter.getText().toUpperCase());
						b.checkY(y1);
						b.convertPosition();
						letter.setText("");
						number.setText("");
					} else {
						information5.setText(e);
						information5.setVisible(true);
					}

				} catch (Exception e1) {
					information5.setText(e);
				}
				// ako je unos izvrsen
				if (b.isOkV()) {
					// postavi unos polja da su prazna i info o gresci sakrij
					letter.setText("");
					number.setText("");
					information5.setVisible(false);
					int counter = 0;
					char[][] s = b.getCharPlayer();
					for (int i = 0; i < s.length; i++) {
						for (int j = 0; j < s[i].length; j++) {
							if (s[i][j] == 'X') {
								// U SLUCAJU ZA KOJE POLJE U MATRICI SE NALAZI
								// "X" PRIKAZI ZA TO POLJE X U PROZORU
								switch (counter) {
								case 0:
									field0.setText(s[i][j] + "");
									break;
								case 1:
									field1.setText(s[i][j] + "");
									break;
								case 2:
									field2.setText(s[i][j] + "");
									break;
								case 3:
									field3.setText(s[i][j] + "");
									break;
								case 4:
									field4.setText(s[i][j] + "");
									break;
								case 5:
									field5.setText(s[i][j] + "");
									break;
								case 6:
									field6.setText(s[i][j] + "");
									break;
								case 7:
									field7.setText(s[i][j] + "");
									break;
								case 8:
									field8.setText(s[i][j] + "");
									break;
								case 9:
									field9.setText(s[i][j] + "");
									break;
								case 10:
									field10.setText(s[i][j] + "");
									break;
								case 11:
									field11.setText(s[i][j] + "");
									break;
								case 12:
									field12.setText(s[i][j] + "");
									break;
								case 13:
									field13.setText(s[i][j] + "");
									break;
								case 14:
									field14.setText(s[i][j] + "");
									break;
								case 15:
									field15.setText(s[i][j] + "");
									break;
								case 16:
									field16.setText(s[i][j] + "");
									break;
								case 17:
									field17.setText(s[i][j] + "");
									break;
								case 18:
									field18.setText(s[i][j] + "");
									break;
								case 19:
									field19.setText(s[i][j] + "");
									break;
								case 20:
									field20.setText(s[i][j] + "");
									break;
								case 21:
									field21.setText(s[i][j] + "");
									break;
								case 22:
									field22.setText(s[i][j] + "");
									break;
								case 23:
									field23.setText(s[i][j] + "");
									break;
								case 24:
									field24.setText(s[i][j] + "");
									break;
								case 25:
									field25.setText(s[i][j] + "");
									break;
								case 26:
									field26.setText(s[i][j] + "");
									break;
								case 27:
									field27.setText(s[i][j] + "");
									break;
								case 28:
									field28.setText(s[i][j] + "");
									break;
								case 29:
									field29.setText(s[i][j] + "");
									break;
								case 30:
									field30.setText(s[i][j] + "");
									break;
								case 31:
									field31.setText(s[i][j] + "");
									break;
								case 32:
									field32.setText(s[i][j] + "");
									break;
								case 33:
									field33.setText(s[i][j] + "");
									break;
								case 34:
									field34.setText(s[i][j] + "");
									break;
								case 35:
									field35.setText(s[i][j] + "");
									break;
								case 36:
									field36.setText(s[i][j] + "");
									break;
								case 37:
									field37.setText(s[i][j] + "");
									break;
								case 38:
									field38.setText(s[i][j] + "");
									break;
								case 39:
									field39.setText(s[i][j] + "");
									break;
								case 40:
									field40.setText(s[i][j] + "");
									break;
								case 41:
									field41.setText(s[i][j] + "");
									break;
								case 42:
									field42.setText(s[i][j] + "");
									break;
								case 43:
									field43.setText(s[i][j] + "");
									break;
								case 44:
									field44.setText(s[i][j] + "");
									break;
								case 45:
									field45.setText(s[i][j] + "");
									break;
								case 46:
									field46.setText(s[i][j] + "");
									break;
								case 47:
									field47.setText(s[i][j] + "");
									break;
								case 48:
									field48.setText(s[i][j] + "");
									break;
								case 49:
									field49.setText(s[i][j] + "");
									break;
								case 50:
									field50.setText(s[i][j] + "");
									break;
								case 51:
									field51.setText(s[i][j] + "");
									break;
								case 52:
									field52.setText(s[i][j] + "");
									break;
								case 53:
									field53.setText(s[i][j] + "");
									break;
								case 54:
									field54.setText(s[i][j] + "");
									break;
								case 55:
									field55.setText(s[i][j] + "");
									break;
								case 56:
									field56.setText(s[i][j] + "");
									break;
								case 57:
									field57.setText(s[i][j] + "");
									break;
								case 58:
									field58.setText(s[i][j] + "");
									break;
								case 59:
									field59.setText(s[i][j] + "");
									break;
								case 60:
									field60.setText(s[i][j] + "");
									break;
								case 61:
									field61.setText(s[i][j] + "");
									break;
								case 62:
									field62.setText(s[i][j] + "");
									break;
								case 63:
									field63.setText(s[i][j] + "");
									break;
								case 64:
									field64.setText(s[i][j] + "");
									break;
								case 65:
									field65.setText(s[i][j] + "");
									break;
								case 66:
									field66.setText(s[i][j] + "");
									break;
								case 67:
									field67.setText(s[i][j] + "");
									break;
								case 68:
									field68.setText(s[i][j] + "");
									break;
								case 69:
									field69.setText(s[i][j] + "");
									break;
								case 70:
									field70.setText(s[i][j] + "");
									break;
								case 71:
									field71.setText(s[i][j] + "");
									break;
								case 72:
									field72.setText(s[i][j] + "");
									break;
								case 73:
									field73.setText(s[i][j] + "");
									break;
								case 74:
									field74.setText(s[i][j] + "");
									break;
								case 75:
									field75.setText(s[i][j] + "");
									break;
								case 76:
									field76.setText(s[i][j] + "");
									break;
								case 77:
									field77.setText(s[i][j] + "");
									break;
								case 78:
									field78.setText(s[i][j] + "");
									break;
								case 79:
									field79.setText(s[i][j] + "");
									break;
								case 80:
									field80.setText(s[i][j] + "");
									break;
								case 81:
									field81.setText(s[i][j] + "");
									break;
								case 82:
									field82.setText(s[i][j] + "");
									break;
								case 83:
									field83.setText(s[i][j] + "");
									break;
								case 84:
									field84.setText(s[i][j] + "");
									break;
								case 85:
									field85.setText(s[i][j] + "");
									break;
								case 86:
									field86.setText(s[i][j] + "");
									break;
								case 87:
									field87.setText(s[i][j] + "");
									break;
								case 88:
									field88.setText(s[i][j] + "");
									break;
								case 89:
									field89.setText(s[i][j] + "");
									break;
								case 90:
									field90.setText(s[i][j] + "");
									break;
								case 91:
									field91.setText(s[i][j] + "");
									break;
								case 92:
									field92.setText(s[i][j] + "");
									break;
								case 93:
									field93.setText(s[i][j] + "");
									break;
								case 94:
									field94.setText(s[i][j] + "");
									break;
								case 95:
									field95.setText(s[i][j] + "");
									break;
								case 96:
									field96.setText(s[i][j] + "");
									break;
								case 97:
									field97.setText(s[i][j] + "");
									break;
								case 98:
									field98.setText(s[i][j] + "");
									break;
								case 99:
									field99.setText(s[i][j] + "");
									break;
								}
							}
							counter++;
						}
					}

					// PROVERA KOJI SE BROD SMESTA
					int entry = b.getCounterEntry();
					switch (entry) {
					case 5:
						information1.setText(s1);
						break;
					case 4:
						information1.setText(s2);
						break;
					case 3:
						information1.setText(s3);
						break;
					case 2:
						information1.setText(s5);
						break;
					case 1:
						// u slucaju da su izvrseni unosi sakrij ovaj prozor
						window1.setVisible(false);
						Z1JD_Brodici s2 = new Z1JD_Brodici();
						// pokreni igricu preko metoda
						try {
							b.storingShips();
							s2.displeyShips();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						break;
					}
					// u slucaju da unos nije izvrsen
				} else {
					information5.setVisible(true);
					information5.setText(e);
				}

			}
		};
		vertical.addActionListener(al1);

		// dugme za vertikalan unos
		ActionListener al2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					// u zavisnosti sta koja metoda trazi saljemo podatke i
					// postavljamo vidljivost informacija o gresci
					int y2 = Integer.parseInt(number.getText());
					b.setPosition("h");
					if (b.checkX(letter.getText().toUpperCase()) && b.checkY(y2)) {
						information5.setVisible(false);
						b.checkX(letter.getText().toUpperCase());
						b.checkY(y2);
						b.convertPosition();
						letter.setText("");
						number.setText("");
					} else {
						information5.setText(e);
						information5.setVisible(true);
					}

				} catch (Exception e2) {
					information5.setText(e);
				}

				if (b.isOkH()) {
					// ako je unos ok na polja za unos postavi da su przna a
					// info o gresci sakrij
					letter.setText("");
					number.setText("");
					information5.setVisible(false);
					int counter = 0;
					char[][] s = b.getCharPlayer();
					for (int i = 0; i < s.length; i++) {
						for (int j = 0; j < s[i].length; j++) {
							// U ZAVISNOSTI NA KOJEM POLJU U MATRICI SE NALAZI
							// "X" ZA ISTO POLJE UU PROZORU POTAVI "X"
							if (s[i][j] == 'X') {
								switch (counter) {
								case 0:
									field0.setText(s[i][j] + "");
									break;
								case 1:
									field1.setText(s[i][j] + "");
									break;
								case 2:
									field2.setText(s[i][j] + "");
									break;
								case 3:
									field3.setText(s[i][j] + "");
									break;
								case 4:
									field4.setText(s[i][j] + "");
									break;
								case 5:
									field5.setText(s[i][j] + "");
									break;
								case 6:
									field6.setText(s[i][j] + "");
									break;
								case 7:
									field7.setText(s[i][j] + "");
									break;
								case 8:
									field8.setText(s[i][j] + "");
									break;
								case 9:
									field9.setText(s[i][j] + "");
									break;
								case 10:
									field10.setText(s[i][j] + "");
									break;
								case 11:
									field11.setText(s[i][j] + "");
									break;
								case 12:
									field12.setText(s[i][j] + "");
									break;
								case 13:
									field13.setText(s[i][j] + "");
									break;
								case 14:
									field14.setText(s[i][j] + "");
									break;
								case 15:
									field15.setText(s[i][j] + "");
									break;
								case 16:
									field16.setText(s[i][j] + "");
									break;
								case 17:
									field17.setText(s[i][j] + "");
									break;
								case 18:
									field18.setText(s[i][j] + "");
									break;
								case 19:
									field19.setText(s[i][j] + "");
									break;
								case 20:
									field20.setText(s[i][j] + "");
									break;
								case 21:
									field21.setText(s[i][j] + "");
									break;
								case 22:
									field22.setText(s[i][j] + "");
									break;
								case 23:
									field23.setText(s[i][j] + "");
									break;
								case 24:
									field24.setText(s[i][j] + "");
									break;
								case 25:
									field25.setText(s[i][j] + "");
									break;
								case 26:
									field26.setText(s[i][j] + "");
									break;
								case 27:
									field27.setText(s[i][j] + "");
									break;
								case 28:
									field28.setText(s[i][j] + "");
									break;
								case 29:
									field29.setText(s[i][j] + "");
									break;
								case 30:
									field30.setText(s[i][j] + "");
									break;
								case 31:
									field31.setText(s[i][j] + "");
									break;
								case 32:
									field32.setText(s[i][j] + "");
									break;
								case 33:
									field33.setText(s[i][j] + "");
									break;
								case 34:
									field34.setText(s[i][j] + "");
									break;
								case 35:
									field35.setText(s[i][j] + "");
									break;
								case 36:
									field36.setText(s[i][j] + "");
									break;
								case 37:
									field37.setText(s[i][j] + "");
									break;
								case 38:
									field38.setText(s[i][j] + "");
									break;
								case 39:
									field39.setText(s[i][j] + "");
									break;
								case 40:
									field40.setText(s[i][j] + "");
									break;
								case 41:
									field41.setText(s[i][j] + "");
									break;
								case 42:
									field42.setText(s[i][j] + "");
									break;
								case 43:
									field43.setText(s[i][j] + "");
									break;
								case 44:
									field44.setText(s[i][j] + "");
									break;
								case 45:
									field45.setText(s[i][j] + "");
									break;
								case 46:
									field46.setText(s[i][j] + "");
									break;
								case 47:
									field47.setText(s[i][j] + "");
									break;
								case 48:
									field48.setText(s[i][j] + "");
									break;
								case 49:
									field49.setText(s[i][j] + "");
									break;
								case 50:
									field50.setText(s[i][j] + "");
									break;
								case 51:
									field51.setText(s[i][j] + "");
									break;
								case 52:
									field52.setText(s[i][j] + "");
									break;
								case 53:
									field53.setText(s[i][j] + "");
									break;
								case 54:
									field54.setText(s[i][j] + "");
									break;
								case 55:
									field55.setText(s[i][j] + "");
									break;
								case 56:
									field56.setText(s[i][j] + "");
									break;
								case 57:
									field57.setText(s[i][j] + "");
									break;
								case 58:
									field58.setText(s[i][j] + "");
									break;
								case 59:
									field59.setText(s[i][j] + "");
									break;
								case 60:
									field60.setText(s[i][j] + "");
									break;
								case 61:
									field61.setText(s[i][j] + "");
									break;
								case 62:
									field62.setText(s[i][j] + "");
									break;
								case 63:
									field63.setText(s[i][j] + "");
									break;
								case 64:
									field64.setText(s[i][j] + "");
									break;
								case 65:
									field65.setText(s[i][j] + "");
									break;
								case 66:
									field66.setText(s[i][j] + "");
									break;
								case 67:
									field67.setText(s[i][j] + "");
									break;
								case 68:
									field68.setText(s[i][j] + "");
									break;
								case 69:
									field69.setText(s[i][j] + "");
									break;
								case 70:
									field70.setText(s[i][j] + "");
									break;
								case 71:
									field71.setText(s[i][j] + "");
									break;
								case 72:
									field72.setText(s[i][j] + "");
									break;
								case 73:
									field73.setText(s[i][j] + "");
									break;
								case 74:
									field74.setText(s[i][j] + "");
									break;
								case 75:
									field75.setText(s[i][j] + "");
									break;
								case 76:
									field76.setText(s[i][j] + "");
									break;
								case 77:
									field77.setText(s[i][j] + "");
									break;
								case 78:
									field78.setText(s[i][j] + "");
									break;
								case 79:
									field79.setText(s[i][j] + "");
									break;
								case 80:
									field80.setText(s[i][j] + "");
									break;
								case 81:
									field81.setText(s[i][j] + "");
									break;
								case 82:
									field82.setText(s[i][j] + "");
									break;
								case 83:
									field83.setText(s[i][j] + "");
									break;
								case 84:
									field84.setText(s[i][j] + "");
									break;
								case 85:
									field85.setText(s[i][j] + "");
									break;
								case 86:
									field86.setText(s[i][j] + "");
									break;
								case 87:
									field87.setText(s[i][j] + "");
									break;
								case 88:
									field88.setText(s[i][j] + "");
									break;
								case 89:
									field89.setText(s[i][j] + "");
									break;
								case 90:
									field90.setText(s[i][j] + "");
									break;
								case 91:
									field91.setText(s[i][j] + "");
									break;
								case 92:
									field92.setText(s[i][j] + "");
									break;
								case 93:
									field93.setText(s[i][j] + "");
									break;
								case 94:
									field94.setText(s[i][j] + "");
									break;
								case 95:
									field95.setText(s[i][j] + "");
									break;
								case 96:
									field96.setText(s[i][j] + "");
									break;
								case 97:
									field97.setText(s[i][j] + "");
									break;
								case 98:
									field98.setText(s[i][j] + "");
									break;
								case 99:
									field99.setText(s[i][j] + "");
									break;
								}
							}
							counter++;
						}
					}
					// PROVERA KOJI BROD SE UNOSI
					int entry = b.getCounterEntry();
					switch (entry) {
					case 5:
						information1.setText(s1);
						break;
					case 4:
						information1.setText(s2);
						break;
					case 3:
						information1.setText(s3);
						break;
					case 2:
						information1.setText(s5);
						break;
					case 1:
						// u sliucaju da su unosi zavrseni sakrij ovaj prozor i
						// pokreni igricu preko metoda
						window1.setVisible(false);
						Z1JD_Brodici s2 = new Z1JD_Brodici();
						try {
							b.storingShips();
							s2.displeyShips();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						break;
					}
					// u slucaju nepravilnog unosa postavi info za to
				} else {
					information5.setVisible(true);
					information5.setText(e);
				}
			}
		};
		horizontally.addActionListener(al2);

	}

}
