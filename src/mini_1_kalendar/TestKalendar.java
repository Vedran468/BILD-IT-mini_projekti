package mini_1_kalendar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestKalendar {

	public static void main(String[] args) throws SQLException {

		try {
			// objekat klase konekcija
			UpravljanjeKonekcijom conn = new UpravljanjeKonekcijom();
			// na osnovu objekta pokusaj napraviti bazu podataka i tabelu
			conn.createDatabaseCalendar();
			conn.createTableCalendar();

		} catch (Exception e) {
			// i na kraju uradi
		} finally {
			// kreiramo skene
			Scanner input = new Scanner(System.in);
			// objekat klase podsetnika sa metodama
			PodsjetnikSaDao dao = new PodsjetnikSaDao();
			// nastavi unos varijable za proveru je li korisniik uneo ceo broj
			boolean continueInput3 = true;
			boolean continueInput1 = true;
			boolean continueInput2 = true;
			// varijabla za godinu
			int year = 0;
			// provera je li korisnik uneo celi broj za godinu broj
			while (continueInput1) {
				System.out.print("Enter full year (e.g., 2012): ");
				try {
					year = input.nextInt();
					// unos dozvoljen od 1 do 10000
					if (year < 0 || year > 10000) {
						// ako je tacan zustavi petlju
						continueInput1 = true;

					} else {
						// inace petlja nastavalj sa radom
						continueInput1 = false;
					}
					// u slucaju greske
				} catch (InputMismatchException ex) {
					System.out.println("Try again. (" + "Incorrect input: an integer is required)");
					input.nextLine(); // Discard input, odbaci predhodni unos
				}
			}
			// varijabla za mesec
			int month = 0;
			// provera za unos meseca da li ispravab
			while (continueInput2) {
				System.out.print("Enter month as a number between 1 and 12: ");
				try {
					month = input.nextInt();
					// dozvoljeno uneti samo brojeve od 1 do 12
					if (month < 0 || month > 12) {
						// zaustavi petlju
						continueInput2 = true;

					} else {
						// inace nastavi raditi petlja
						continueInput2 = false;
					}
					// u slucaju greske
				} catch (InputMismatchException ex) {
					System.out.println("Try again. (" + "Incorrect input: an integer is required)");
					input.nextLine(); // Discard input, odbaci predhodni unos
				}
			}
			// objekat klse za stampanje gde pozivamo metodu i saljemo
			// korisnikovu godinu i mesec
			StampanjeKalendara printCalendar = new StampanjeKalendara();
			printCalendar.printMonth(year, month);
			// varijabla za prvi izbor korisnika
			int choice1 = 0;
			// provera da li zeli nastaviti
			while (continueInput3) {
				System.out.println("If you want to display another month, enter 1; "
						+ "\nIf you want to add a reminder to enter 2; "
						+ "\nIf you want to delete a reminder, enter 3; "
						+ "\nIf you want to change a reminder, enter 4; "
						+ "\nIf you want to display a reminder enter 5;" + "\nExit to the number 6;");
				try {
					choice1 = input.nextInt();
					if (choice1 > 0 && choice1 < 7) {
						// zaustavljamo petlju
						continueInput3 = false;
					} else {
						// nastavi sa petljom
						continueInput3 = true;
					}
					// u slucaju greske
				} catch (InputMismatchException ex) {
					System.out.println("Try again. (" + "Incorrect input: an integer is required)");
					input.nextLine(); // Discard input, odbaci predhodni unos
				}
			}
			// ako je korisnik uneo 1 novi prikaz kalendara
			if (choice1 == 1) {

				// nastavi unos varijabla za proveru da li je korisniik uneo
				// broj
				boolean continueInput4 = true;
				boolean continueInput5 = true;
				// ponovo za godinu
				int year2 = 0;

				// provera je li korisnik uneo broj
				while (continueInput4) {
					System.out.print("Enter full year (e.g., 2012): ");
					try {
						year2 = input.nextInt();
						// dozvoljeni unos za godinu
						if (year2 < 0 || year2 > 10000) {
							// zaustavljamo petlju
							continueInput4 = true;
						} else {
							// nastvi sa petljom
							continueInput4 = false;
						}
						// u slucaju greske
					} catch (InputMismatchException ex) {
						System.out.println("Try again. (" + "Incorrect input: an integer is required)");
						input.nextLine(); // Discard input, odbaci predhodni
											// unos
					}
				}
				// ponovo unos za mesec
				int month2 = 0;
				// provera je li unesen dozvoljeni broj za mesec
				while (continueInput5) {
					System.out.print("Enter month as a number between 1 and 12: ");
					try {
						month2 = input.nextInt();
						// dozvoljeni unos
						if (month2 < 0 || month2 > 12) {
							// zaustavi petlju
							continueInput5 = true;
						} else {
							// nastavi sa petljom
							continueInput5 = false;
						}
					} catch (InputMismatchException ex) {
						System.out.println("Try again. (" + "Incorrect input: an integer is required)");
						input.nextLine(); // Discard input, odbaci predhodni
											// unos
					}
				}
				// prikazi kaledar za ovu godinu imesec
				printCalendar.printMonth(year2, month2);
				// ako je korisnik uneo 2 ispisi mu za unos podsetnika
			} else if (choice1 == 2) {
				// varijable za podsetnik i datum
				String reminder = "";
				String date = "";
				// varijabla za provera unosa
				boolean continueInput6 = true;
				System.out.println("Enter the date for which you want"
						+ " to add a reminder, in the form 01.01.2016, but not 33.12.2017: ");
				// petlja radi dok se ne unese tacan unos za datum
				while (continueInput6) {
					date = input.next();
					// provera da li datum ispravno napian
					if (dao.correctlyEnteredDate(date)) {
						// ako jeste zaustavi petlju
						continueInput6 = false;

					} else {
						// inace ispisi i nastavi sa petljom
						System.out.println("Enter the date for which you want"
								+ " to add a reminder, in the form 01.01.2016, but not 33.12.2017: ");

						input.nextLine(); // Discard input, odbaci predhodni
											// unos
						continueInput6 = true;
					}

				}
				// odbaci predhodni unos
				reminder = input.nextLine();
				System.out.println("Enter reminder: ");
				// unesi podsetnik
				reminder = input.nextLine();
				// posalji ga u metodu
				dao.addReminders(date, reminder);
				// ako je korisnik uneo 3 to je za brisanje
			} else if (choice1 == 3) {
				// provera unosa za izbor sledeci
				boolean continueInput7 = true;
				// ponovni izbor
				int choice2 = 0;
				// provera da li je validan unos za izbor daljih opcija
				while (continueInput7) {
					System.out.println("If you want to delete all reminders enter 1; "
							+ "\nIf you want to delete reminders for a specific date, enter 2; "
							+ "\nIf you want to delete a specific reminder type 3;");
					try {
						choice2 = input.nextInt();
						// uslov unosa
						if (choice2 > 0 && choice2 < 4) {
							// zaustavljamo petlju
							continueInput7 = false;
						} else {
							// nastavi
							continueInput7 = true;
						}
						// u slucaju greske
					} catch (InputMismatchException ex) {
						System.out.println("Try again. (" + "Incorrect input: an integer is required)");
						input.nextLine(); // Discard input, odbaci predhodni
											// unos
					}
				}
				// u slucaju da je izbrao drugi puta jedan radi za brisanje svih
				// podsetnika
				if (choice2 == 1) {
					dao.deleteAllReminders();
					// a za unos 2 brisanje podsetnika za odredjen daum
				} else if (choice2 == 2) {
					boolean continueInput8 = true;
					String date = "";
					while (continueInput8) {
						System.out.println("Enter the date you want to delete the "
								+ "reminders, in the form 01.01.2016, but not 33.12.2017: ");
						try {
							date = input.next();
							// saljemo u metodu datum koja brise za odredjen
							// datum
							if (dao.deleteAllReminderDate(date)) {
								// zaustavljamo petlju
								continueInput8 = false;
							} else {
								// inace nastavi sa petljom
								continueInput8 = true;
							}
							// u slucaju greske
						} catch (InputMismatchException ex) {
							System.out.println("Try again: ");
							input.nextLine(); // Discard input, odbaci predhodni
												// unos
						}
					}
					// u slucaju da je korisnik uneo 3 izbrisi specifican
					// podsetnik
				} else {
					// provera za datum i id
					boolean continueInput9 = true;
					boolean continueInput10 = true;
					// varijable za id i datum
					int id;
					String date = "";
					// proveri za datum
					while (continueInput9) {

						try {
							System.out.println("Enter the date you want to delete the specific reminder"
									+ " , in the form 01.01.2016, but not 33.12.2017:  ");
							date = input.next();
							// proveri je li postoji taj datum sa podsetnikom
							if (dao.doesItExist(date)) {
								// zaustavljamo petlju
								continueInput9 = false;
							} else {
								// inace nastavi sa petljom
								continueInput9 = true;
							}
							// u slucaju greske
						} catch (InputMismatchException ex) {
							System.out.println("Try again: ");
							input.nextLine(); // Discard input, odbaci predhodni
												// unos
						}
					}
					// proveravaj za id
					while (continueInput10) {
						try {
							System.out.println("Enter the id of the reminder");
							id = input.nextInt();
							// da li postoji id sa podsetnikom
							if (dao.doesItExistReminder(date, id)) {
								// pokusaj izbrisati podsetnik sa tim id na
								// datumu
								if (dao.deleteReminder(date, id)) {
									// zausstavi petlju
									continueInput10 = false;
								} else {
									// nastavi sa petljom
									continueInput10 = true;
								}
							} else {
								// u slucaju da ne postoji id
								System.out.println("The id does not exist!!!");
								continueInput10 = true;
							}
							// u slucaju greske
						} catch (InputMismatchException ex) {
							System.out.println("Try again. (" + "Incorrect input: an integer is required)");
							input.nextLine(); // Discard input, odbaci predhodni
												// unos
						}
					}
				}
				// ako je korisnik une 4 to se odnosi na izmenu podsetnika
			} else if (choice1 == 4) {
				// za proveru unosa datuma i id
				boolean continueInput11 = true;
				boolean continueInput12 = true;
				// varijable za id, datum i podsetnik
				int id;
				String date = "";
				String reminder = "";
				// proveravaj unos za datum
				while (continueInput11) {
					try {
						System.out.println("Enter the date for the change reminder "
								+ ", in the form 01.01.2016, but not 33.12.2017:  ");
						date = input.next();
						// provera da li postoji vec taj datum
						if (dao.doesItExist(date)) {
							// zaustavljamo petlju
							continueInput11 = false;
						} else {
							// inace nastavi sa petljom
							continueInput11 = true;
						}
						// u slucaju greske
					} catch (InputMismatchException ex) {
						System.out.println("Try again: ");
						input.nextLine(); // Discard input, odbaci predhodni
											// unos
					}
				}
				// proveri za id
				while (continueInput12) {
					try {
						System.out.println("Enter id for that change reminder");
						id = input.nextInt();
						// da li postoji takav id za taj datum
						if (dao.doesItExistReminder(date, id)) {
							// odbaci unos
							input.nextLine();
							System.out.println("Enter a new reminder:");
							// skeniraj podsetnik
							reminder = input.nextLine();
						} else {
							// inace nek petlja nastavi
							continueInput12 = true;
						}
						// proveri jeli podsetnik dodat
						if (dao.updateReminder(date, id, reminder)) {
							// zaustavi petju
							continueInput12 = false;
						} else {
							// inace ponovo
							continueInput12 = true;
						}
						// u slucaju greske
					} catch (InputMismatchException ex) {
						System.out.println("Try again. (" + "Incorrect input: an integer is required)");
						input.nextLine(); // Discard input, odbaci predhodni
											// unos
					}
				}
				// ako je korisnik uneo 5 odnasi se na prikaz podsetnika
			} else if (choice1 == 5) {
				// varijabla za proveru izbora daljih opcija
				boolean continueInput13 = true;
				// var za izbor sledeci
				int choice3 = 0;
				// proveravaj ispravnost unetog izbora
				while (continueInput13) {
					System.out.println("Enter 1 to display all reminders; "
							+ "\nAnd 2 to display reminders for a specific date, " + "\nAnd 3 for specific reminder;");
					try {
						choice3 = input.nextInt();
						// uslov za izbor daljih opcija
						if (choice3 > 0 && choice3 < 4) {
							// zaustavljamo petlju
							continueInput13 = false;
						} else {
							// inace nastavi
							continueInput13 = true;
						}
						// u slucaju greske
					} catch (InputMismatchException ex) {
						System.out.println("Try again. (" + "ERROR)");
						input.nextLine(); // Discard input, odbaci predhodni
											// unos
					}
				}
				// ako je posle 5 unet 1
				if (choice3 == 1) {
					// posto metoda vraca listu pohrani je ovde
					ArrayList<String> result = dao.getAllReminders();
					// u slucaju da je lista prazna
					if (result.size() == 0) {
						System.out.println("No reminders have not entered any!!!");
					} else {
						// inace ispisi je
						for (int i = 0; i < result.size(); i++) {
							System.out.println(result.get(i));
						}
					}
					// u slucaju posle 5 da je uneta 2
				} else if (choice3 == 2) {
					// varijabla za datum
					String date = "";
					// var zxa tacnos unosa datuma
					boolean continueInput14 = true;
					// proveravaj unos za datum
					while (continueInput14) {
						System.out.println("Enter the date for which you want to view "
								+ ", in the form 01.01.2016, but not 33.12.2017:  ");
						try {
							date = input.next();
							// provera dali takav datum postoji sa podsetnikom
							if (dao.doesItExist(date)) {
								// zaustavljamo petlju
								continueInput14 = false;
							} else {
								// inace nastavi sa petljom
								continueInput14 = true;
							}
							// u slucaju greske
						} catch (InputMismatchException ex) {
							System.out.println("Try again: ");
							input.nextLine(); // Discard input, odbaci predhodni
												// unos
						}
					}
					// ako je datum tacan pohrani listu podsetnika
					ArrayList<String> result = dao.getRemindersDate(date);
					// ispisi listu podsetnika
					for (int i = 0; i < result.size(); i++) {
						System.out.println(result.get(i));
					}
					// ako je posle 5 uneta 3 to je ispis specificnog podsetnika
				} else {
					// var za proveru tacnosti datuma i id
					boolean continueInput15 = true;
					boolean continueInput16 = true;
					// var za id i datum
					int id;
					String date = "";
					// proveravaj ispravnost datuma
					while (continueInput15) {
						try {
							System.out.println("Enter the date for which you want to view "
									+ ", in the form 01.01.2016, but not 33.12.2017:  ");
							date = input.next();
							// posalji u metodu na proveru postojanja datuma sa
							// podsetnikom
							if (dao.doesItExist(date)) {
								// zaustavljamo petlju
								continueInput15 = false;
							} else {
								// nastavi unos
								continueInput15 = true;
							}
							// u slucaju greske
						} catch (InputMismatchException ex) {
							System.out.println("Try again: ");
							input.nextLine(); // Discard input, odbaci predhodni
												// unos
						}
					}
					// prveravaj za id
					while (continueInput16) {
						try {
							System.out.println("Enter the id that you want to display: ");
							id = input.nextInt();
							// da li postoji id sa podsetnikom na tom datumu
							if (dao.doesItExistReminder(date, id)) {
								System.out.println(dao.getSpecificReminderDate(date, id));
								// zaustavljamo petlju
								continueInput16 = false;
							} else {
								// inace nastavi s petljom
								continueInput16 = true;
							}
							// u slucaju greske
						} catch (InputMismatchException ex) {
							System.out.println("Try again. (" + "Incorrect input: an integer is required)");
							input.nextLine(); // Discard input, odbaci predhodni
												// unos
						}
					}
				}
			}
			// zaustavi unos
			input.close();
		}

	}
}
