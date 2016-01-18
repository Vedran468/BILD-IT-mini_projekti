package mini_1_kalendar;

public class Podsjetnik {

	// kreiramo polja podataka za datum, posetnik i id
	private String date;
	private String reminder;
	private int idReminder;

	// prazni konstriktor
	public Podsjetnik() {

	}

	// drugi tipovi konstruktora sa razlicitim argumentima
	public Podsjetnik(String date, int idReminder, String reminder) {
		this.date = date;
		this.idReminder = idReminder;
		this.reminder = reminder;
	}

	public Podsjetnik(String date, int idReminder) {
		this.date = date;
		this.idReminder = idReminder;
	}

	public Podsjetnik(String date) {
		this.date = date;
	}

	public Podsjetnik(String date, String reminder) {
		this.date = date;
		this.reminder = reminder;
	}

	public Podsjetnik(int idReminder, String reminder) {
		this.idReminder = idReminder;
		this.reminder = reminder;
	}

	// metode koje vracaju vrednosti za polja podataka
	public String getDate() {
		return date;
	}

	public String getReminder() {
		return reminder;
	}

	public int getIdReminder() {
		return idReminder;
	}

}
