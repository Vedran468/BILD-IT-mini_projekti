package mini_1_kalendar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PodsjetnikSaDao implements DAOPodsjetnik {

	Connection connection = UpravljanjeKonekcijom.getInstance().getConnection();

	// pomocna metoda koja prilagodjava datum sql kodu
	private String dateFormat(String date) {
		// pretvaramo string u niz karaktera i menjamo . sa _
		char[] c = date.toCharArray();
		// varijabla za rezultat koja vraca string ispravljen
		String d = "";
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '.') {
				d = d + "_";
			} else {
				d = d + (c[i] + "");
			}
		}
		return d;
	}

	@Override
	public ArrayList<String> getAllReminders() throws SQLException {

		// kreiramo listu u kojoj cemo smestati dobijene podatke iz baze podata
		// i na osnovu njih praviti objekte
		ArrayList<String> result = new ArrayList<>();
		// objekat klse podsetnik
		Podsjetnik reminder = null;
		// definisemo sql kod odnosno upit da vrati podsatke datum
		String sqlQuery = "SELECT date FROM calendar";

		// kreiramo objekat u interfejsu postavi rezultat
		ResultSet rs = null;
		ResultSet rs2 = null;

		// pokusaj izvrsiti sql upit
		try (Statement statement = connection.createStatement();) {
			rs = statement.executeQuery(sqlQuery);
			while (rs.next()) {

				// resenje iz baze podataka prosledjujemo konstruktoru
				reminder = new Podsjetnik(rs.getString("date"));
				// preko get metode dobijamo podatak iz konstruktora
				String d = reminder.getDate();
				// dodajemo ga u lisu
				result.add(d);

				// drufi sql upit da vrati sve podsetnike
				String sqlQuery2 = "SELECT * FROM date_" + d + ";";
				// pokusaj izvrsiti sql upit
				try (Statement statement2 = connection.createStatement();) {
					rs2 = statement2.executeQuery(sqlQuery2);
					while (rs2.next()) {
						// resenje iz baze podataka smestamo u
						reminder = new Podsjetnik(rs2.getInt("idReminder"), rs2.getString("reminder"));
						// int u string pretvaramo
						String s = reminder.getIdReminder() + " ";
						// dodajemo urezultat
						result.add(s);
						result.add(reminder.getReminder());
					}

					// zatvaramo objekat interfejsa postavi rezultat
					rs2.close();
					// u slucaju greske
				} catch (SQLException e) {
					System.out.println("Error!!!");
					System.err.println(e);
				}
			}
			// zatvaramo objekat interfejsa postavi rezultat
			rs.close();
			// u slucaju greske
		} catch (SQLException e) {
			System.out.println("Error!!!");
			System.err.println(e);

		}
		// vrati rezultat
		return result;
	}

	@Override
	public ArrayList<String> getRemindersDate(String date) throws SQLException {
		// menjamo formu datuma
		String d = dateFormat(date);
		// objekat posetnika
		Podsjetnik reminder = new Podsjetnik();
		// lista kao resenje
		ArrayList<String> result = new ArrayList<>();
		// proveravamo da li postoji datum u slucaju da ne
		if (doesItExist(d)) {
			// izvrsi ovaj sql upit
			String sqlQuery = "SELECT idReminder, reminder FROM date_" + d + ";";
			ResultSet rs = null;
			try (Statement statement = connection.createStatement();) {
				rs = statement.executeQuery(sqlQuery);
				while (rs.next()) {
					reminder = new Podsjetnik(rs.getInt("idReminder"), rs.getString("reminder"));
					// pretvaramo dobijeni int u string
					String s = reminder.getIdReminder() + " ";
					// rezultate dodajemo listi
					result.add(s);
					result.add(reminder.getReminder());
				}

				// zatvaramo objekat interfejsa postavi rezultat
				rs.close();
				// u slucaju greske
			} catch (SQLException e) {
				System.out.println("Error!!!");
				System.err.println(e);
			}

		} else {
			// u slucaju da datum dobijen ne postoji
			System.out.println("This date does not exist!!!");
		}
		// vrati listu
		return result;
	}

	@Override
	public String getSpecificReminderDate(String date, int id) throws SQLException {
		// menjamo formu datuma
		String d = dateFormat(date);
		String result = "";
		String sqlQuery = "SELECT reminder  FROM date_" + d + "  WHERE idReminder =" + id + " ;";
		ResultSet rs = null;
		try (Statement statement = connection.createStatement();) {
			rs = statement.executeQuery(sqlQuery);
			if (rs.next()) {
				result = rs.getString("reminder");
			}
			// zatvaramo objekat interfejsa postavi rezultat
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error!!!");
			System.err.println(e);
		}
		return result;
	}

	@Override
	public boolean updateReminder(String date, int idReminder, String reminder) throws SQLException {
		// menjamo formu datuma
		String d = dateFormat(date);

		if (!doesItExistReminder(d, idReminder)) {
			System.out.println("This date does not exist!!!");
			return false;
		} else {
			// sql kod koji menja podatke dobijene iz get metode objkta student
			String sqlQuery = "UPDATE date_" + d + " SET  reminder = '" + reminder + "' " + " WHERE idReminder = "
					+ idReminder + " ;";
			try (Statement statement = connection.createStatement();) {
				// objektom izjava interfejsa pozivamo metodu izvrsi upit i
				// prosledjujemo kao argument sql kod odnosno upit
				statement.executeUpdate(sqlQuery);
				System.out.println("You have successfully edited a reminder!!!");
				// metoda vraca tacno
				return true;
			} catch (SQLException e) {
				System.out.println("There is a reminder with a valid ID");
				// u ovom slucaju metoda vraca lazan
				return false;
			}
		}
	}

	@Override
	public boolean deleteReminder(String date, int idReminder) throws SQLException {
		// menjamo formu datuma
		String d = dateFormat(date);
		// provera je li datum postoji u slucaju da ne postoji izvrsi
		if (!doesItExist(d)) {
			System.out.println("This date does not exist!!!");
			return false;
		}
		// inace izbrisi podsetnik
		String sqlQuery = "DELETE FROM date_" + d + " WHERE idReminder = " + idReminder + " ;";
		try (Statement statement = connection.createStatement();) {
			statement.executeUpdate(sqlQuery);
			System.out.println("You have successfully deleted a reminder");
			return true;
		} catch (SQLException e) {
			System.out.println("There is a reminder with a valid ID");
			return false;
		}
	}

	// pomocna metoda koja brise tabelu sa podsetniko,
	private boolean dropReminders(String reminders) {
		String sqlQuery2 = "DROP TABLE date_" + reminders + " ;";
		try (Statement statement2 = connection.createStatement();) {
			statement2.executeUpdate(sqlQuery2);
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	// pomocna metoda koja brise tabelu sa datumima
	private boolean dropTable() {
		String sqlQuery3 = "DROP TABLE calendar ;";
		try (Statement statement3 = connection.createStatement();) {
			statement3.executeUpdate(sqlQuery3);
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	@Override
	public boolean deleteAllReminders() throws SQLException {

		// objekat klase posdsetnik
		Podsjetnik date = null;

		// prikazi sve datume sql kod
		String sqlQuery = "SELECT date FROM calendar ";

		// kreiramo objekat u interfejsu postavi rezultat
		ResultSet rs = null;

		// pokusaj izvrsiti sql kod
		try (Statement statement = connection.createStatement();) {
			rs = statement.executeQuery(sqlQuery);
			while (rs.next()) {
				date = new Podsjetnik(rs.getString("date"));
				// dobijeni int pretvaramo u string
				String reminder = date.getDate();
				// saljemo ga u metodu za brisanje tabele podsetnika
				dropReminders(reminder);
			}
			rs.close();
			// ako je tabela izbrisana
			if (dropTable()) {
				System.out.println("You have successfully delete all reminders!!!");
				return true;
			} else {
				System.out.println("Error!!!");
				return false;
			}
			// u slucaju greske
		} catch (SQLException e) {
			System.out.println("Error!!!");
			System.err.println(e);
			return false;
		}

	}

	@Override
	public boolean deleteAllReminderDate(String date) throws SQLException {
		// menjamo formu datuma
		String d = dateFormat(date);
		// provera da li datum postoji
		if (!doesItExist(d)) {
			System.out.println("This date does not exist!!!");
			return false;
		}
		// brisanje tabele sa podsetnicima za datum
		String sqlQuery = "DROP TABLE date_" + d + " ;";
		// u tabeli datuma brisati taj datum
		String sqlQuery2 = "DELETE FROM calendar WHERE date LIKE '" + d + "' ;";

		// izvrsi sql upite
		try (Statement statement = connection.createStatement();) {
			statement.executeUpdate(sqlQuery);
			statement.executeUpdate(sqlQuery2);
			System.out.println("You have successfully delete all reminders!!!");
			return true;
			// u slucaju greske
		} catch (SQLException e) {
			System.out.println("Error!!!");
			return false;
		}
	}

	@Override
	public boolean addReminders(String date, String reminder) {
		// menjamo formu datuma
		String d = dateFormat(date);
		// provera da li postoji datum
		boolean check = doesItExist(d);
		if (check == false) {
			// ako ne ubaci u tabelu datuma
			String sqlQuery = "INSERT INTO calendar ( date )  VALUES ( '" + d + "' );";
			// kreiraj tabelu za podsetnike sa tim datumom
			String sqlQuery2 = "CREATE TABLE date_" + d + " (" + " idReminder INTEGER PRIMARY KEY AUTO_INCREMENT , "
					+ " reminder  TEXT);";

			// ubaci podsetnik u kreiranu tabelu podsetnika za dati datum
			String sqlQuery3 = "INSERT INTO date_" + d + " ( idReminder , reminder )  VALUES ( 1 , '" + reminder
					+ "' );";
			// izvrsi sql upite
			try (Statement statement = connection.createStatement();) {
				statement.executeUpdate(sqlQuery);
				statement.executeUpdate(sqlQuery2);
				statement.executeUpdate(sqlQuery3);
				System.out.println("You have successfully add a reminder!!!");
				return true;
				// u slucaju greske
			} catch (SQLException e) {
				System.out.println("Error!!!");
				return false;
			}

			// ako postoji vec neki podsetnik za taj datum
		} else if (check == true) {
			// ubaci u njega novi podsetnik
			String sqlQuery = "INSERT INTO date_" + d + " ( reminder )  VALUES ( '" + reminder + "' );";
			// izvrsi sql upit
			try (Statement statement = connection.createStatement();) {
				statement.executeUpdate(sqlQuery);
				System.out.println("You have successfully add a reminder!!!");
				return true;
				// u slucaju greske
			} catch (SQLException e) {
				System.out.println("Error!!!");
				return false;
			}
		} else {
			// ako nista nije ispunjeno uradi sledece
			System.out.println("Error!!!");
			return false;
		}

	}

	@Override
	public boolean doesItExist(String date) {
		// menjamo formu datuma
		String d = dateFormat(date);
		// provera u tabeli datuma da li postoji dobijeni datum
		String sqlQuery = "SELECT * FROM calendar WHERE date LIKE '" + d + "'";
		ResultSet rs = null;
		// izvrsisql upit
		try (Statement statement = connection.createStatement();) {
			rs = statement.executeQuery(sqlQuery);
			// ako postoji vrati ture inace false
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
			// u slucaju greske
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean doesItExistReminder(String date, int id) {
		// menjamo formu datuma
		String d = dateFormat(date);
		// provera da li postoji id podsetnika za dobijeni datum
		String sqlQuery = "SELECT * FROM date_" + d + " WHERE idReminder = " + id + " ; ";
		ResultSet rs = null;
		// izvrsi sql upit
		try (Statement statement = connection.createStatement();) {
			rs = statement.executeQuery(sqlQuery);
			// ako postoji vrati ture inace false
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
			// u slucaju greske
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean correctlyEnteredDate(String date) {
		// proveravamo da li je datum oblika npr 01.07.2018
		// prvo da li je duznia stringa 10
		if (date.length() == 10) {
			// akoda pretvori ga u listu karaktera
			char[] array = date.toCharArray();
			// provera da i se na 3 i 5 mestu nalazi tacka i da li su poslednja
			// 4 broja uopste brojevi
			if ((int) (array[2]) == 46 && (int) (array[5]) == 46 && (int) (array[6]) > 48 && (int) (array[6]) <= 57
					&& (int) (array[7]) >= 48 && (int) (array[7]) <= 57 && (int) (array[8]) >= 48
					&& (int) (array[8]) <= 57 && (int) (array[9]) >= 48 && (int) (array[9]) <= 57) {
				// provera prvog broja ako je 0, 1 ili 2 koji su to dozvoljeni
				// brojevi za 2 broj
				if ((int) (array[0]) >= 48 && (int) (array[0]) <= 50 && (int) (array[1]) >= 48
						&& (int) (array[1]) <= 57) {
					// u slucaju da je 4 broj 0 5 broj moze ici do 9
					if ((int) (array[3]) == 48 && (int) (array[4]) > 48 && (int) (array[4]) <= 57) {
						return true;
						// u slucaju da je 4 broj 1 5 broj je 0, 1 ili 2
					} else if ((int) (array[3]) == 49 && (int) (array[4]) == 48 || (int) (array[4]) == 49
							|| (int) (array[4]) == 50) {
						return true;

					} else {
						return false;
					}
					// ako je prvi broj 3 drugi broj moze biti samo 0 ili 1 i
					// opet provera za ostale brojeve u datumu
				} else if ((int) (array[0]) == 51 && (int) (array[1]) == 48 || (int) (array[1]) == 49) {
					if ((int) (array[3]) == 48 && (int) (array[4]) > 48 && (int) (array[4]) <= 57) {
						return true;
					} else if ((int) (array[3]) == 49 && (int) (array[4]) == 48 || (int) (array[4]) == 49
							|| (int) (array[4]) == 50) {
						return true;
						// ako nesto od gore navedenog nije ispostovano vrati
						// false
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;

			}
		} else {
			return false;
		}

	}

}
