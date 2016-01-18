package mini_1_kalendar;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOPodsjetnik {

	// mertoda koja ce vracati sve unete podsetnike
	public ArrayList<String> getAllReminders() throws SQLException;

	// metoda koja vraca podsetnik za odrdjen datum
	public ArrayList<String> getRemindersDate(String date) throws SQLException;

	// metoda koja vraca odredjen podsetnik
	public String getSpecificReminderDate(String date, int id) throws SQLException;

	// metoda koja vrsi izmenu podsetnika
	public boolean updateReminder(String date, int idReminder, String reminder) throws SQLException;

	// metoda koja brise odredjen podsetnik
	public boolean deleteReminder(String date, int idReminder) throws SQLException;

	// metoda koja brise sve podsetnike
	public boolean deleteAllReminders() throws SQLException;

	// metoda koja brise sve podsetnike za odredjen datum
	public boolean deleteAllReminderDate(String date) throws SQLException;

	// metoda koja dodaje podsetnik
	public boolean addReminders(String date, String reminder);

	// metoda koja proverava da li postoji datum koji je unesen
	public boolean doesItExist(String date);

	// proverava da li postoji podsetnik sa id zadanim
	public boolean doesItExistReminder(String date, int id);

	// metoda koja proverava ji li pravilno unesen datum
	public boolean correctlyEnteredDate(String date);
}
