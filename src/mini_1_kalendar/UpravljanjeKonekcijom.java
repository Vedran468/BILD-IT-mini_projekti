package mini_1_kalendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpravljanjeKonekcijom {

	// objekat ove klase
	private static UpravljanjeKonekcijom instance = null;
	// uspostavljanje konekcije sa serverom mysql
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String CONN_STRING1 = "jdbc:mysql://localhost";
	// konekcija sa bazom podataka
	private final String CONN_STRING2 = "jdbc:mysql://localhost/calendar";

	// objekat konekcije
	private Connection connection = null;

	// kreiramo bazu podataka kalendar
	public void createDatabaseCalendar() throws SQLException {
		String sqlQuery = "CREATE DATABASE calendar";

		try (Connection connection = DriverManager.getConnection(CONN_STRING1, USERNAME, PASSWORD);
				Statement statement = connection.createStatement();

		) {
			statement.executeUpdate(sqlQuery);
			System.out.println("Successfully created database!!!");
		} catch (SQLException e) {
		}
	}

	// kreiramo tabelu za datume koi imaju podsetnik
	public void createTableCalendar() {
		String sqlQuery = "CREATE TABLE calendar ( date VARCHAR(10) UNIQUE  ) ;";

		try (Connection connection = DriverManager.getConnection(CONN_STRING2, USERNAME, PASSWORD);

				Statement statement = connection.createStatement();) {
			statement.executeUpdate(sqlQuery);
			System.out.println("Successfully created table!!!");
		} catch (SQLException e) {
		}
	}

	// konstruktor konekcije
	UpravljanjeKonekcijom() {
	}

	// metoda koja vraca objekat ove klase
	public static UpravljanjeKonekcijom getInstance() {
		// ako je instanca odnosno objekat prazan
		if (instance == null) {
			// napravi novi objekat ove klase
			instance = new UpravljanjeKonekcijom();
		}
		// vrati instancu
		return instance;
	}

	// metoda preko koje se konektujemo na bazu podataka
	private boolean openConnection() {
		try {
			connection = DriverManager.getConnection(CONN_STRING2, USERNAME, PASSWORD);
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

	// metoda sa kojom proveravamo jesmo li konektovani na bazu podataka
	public Connection getConnection() {
		if (connection == null) {
			if (openConnection()) {
				return connection;
			} else {
				System.out.println("Connection not opened!!!");
				return null;
			}
		}
		return connection;
	}

}
