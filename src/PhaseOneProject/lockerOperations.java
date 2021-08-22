package PhaseOneProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class lockerOperations {

	private static Scanner keyboard = new Scanner(System.in);
	private static UserCredentials userCredentials = new UserCredentials();
	private static String fileSep = System.getProperty("file.separator");
	static String pathDirect;
	static boolean loopagain1 = true;

	public static void dolockerOperations(String inpUsername) {

		pathDirect = System.getProperty("user.dir") + fileSep + inpUsername;

		System.out.println("1 . FETCH ALL STORED CREDENTIALS ");
		System.out.println("2 . STORED CREDENTIALS ");
		System.out.println("2 . Delete CREDENTIALS ");

		do {
			System.out.println("\nEnter choice [1-4]: ");

			int getchoice = keyboard.nextInt();
			switch (getchoice) {
			case 1:

				fetchCredentials();
				break;

			case 2:
				storeCredentials(inpUsername);
				break;

			case 4:
				System.out.println("Return to Main Menu");
				return;

			case 5:
				System.out.println("Exit the application");
				loopagain1 = false;
				// input.close();
				System.exit(0);
				break;

			}
		} while (loopagain1);
	}

	public static void storeCredentials(String loggedInUser) {

		System.out.println("==========================================");
		// System.out.println("* *");
		System.out.println("*   Welcome to Digital Locker System	 *");
		System.out.println("*    Store Your Credentials here !!!	 *");
		// System.out.println("* *");
		System.out.println("==========================================");
		System.out.println(loggedInUser);

		userCredentials.setLoggedInUser(loggedInUser);

		System.out.println("Enter Site Name :");
		String siteName = keyboard.next();
		userCredentials.setSiteName(siteName);

		System.out.println("Enter Username :");
		String siteusername = keyboard.next();
		userCredentials.setUsername(siteusername);

		System.out.println("Enter Password :");
		String password = keyboard.next();
		userCredentials.setPassword(password);

		File createFolder = new File(loggedInUser);

		// If file doesn't exist, create the main folder
		if (!createFolder.exists()) {
			createFolder.mkdirs();
		}

		String Framefilename = pathDirect + fileSep + siteusername + ".txt";

		// File tempFile = new File(Framefilename);

		try {
			// create file output stream.
			FileOutputStream sitefile = new FileOutputStream(Framefilename);

			// create object stream
			ObjectOutputStream siteout = new ObjectOutputStream(sitefile);

			// method to serialize object
			siteout.writeObject(userCredentials);

			System.out.println("Serialization is completed !");

			siteout.close();
			sitefile.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("YOUR CREDS ARE STORED AND SECURED!");

	}

	// fetch credentials
	public static void fetchCredentials() {
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   WELCOME TO DIGITAL LOCKER 	 *");
		System.out.println("*   YOUR CREDS ARE 	 *");
		System.out.println("*					*");
		System.out.println("==========================================");

		System.out.println("Enter an website user name : ");
		String getwebuser = keyboard.nextLine();

		try {
			// 1. read a file
			String fetchfilename = pathDirect + fileSep + getwebuser + ".txt";

			FileInputStream fetchfile = new FileInputStream(fetchfilename);

			// 2. create a input stream object
			ObjectInputStream fetchin = new ObjectInputStream(fetchfile);

			// 3. method to de-serialized object
			UserCredentials employee = (UserCredentials) fetchin.readObject();

			System.out.println(" De serialization completed !");
			System.out.println("Emp Id : " + employee.getSiteName());
			System.out.println("Emp Name : " + employee.getUsername());
			System.out.println("Emp Dept : " + employee.getPassword());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
