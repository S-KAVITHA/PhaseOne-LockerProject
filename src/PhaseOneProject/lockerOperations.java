package PhaseOneProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class lockerOperations {

	// class to perform user credential related operations.

	private static Scanner keyboard = new Scanner(System.in);
	private static UserCredentials userCredentials = new UserCredentials();
	private static String fileSep = System.getProperty("file.separator");
	static String pathDirect;
	static boolean loopagain1 = true;

	public static void dolockerOperations(String inpUsername) {

		pathDirect = System.getProperty("user.dir") + fileSep + inpUsername;

		System.out.println("\n1 -> Store User Credentials ");
		System.out.println("2 -> List User Files ");
		System.out.println("3 -> Show User Credentials");
		System.out.println("4 -> Delete User Files ");
		System.out.println("5 -> Return to Previous Menu");
		System.out.println("6 -> Exit the application");

		do {

			try {
				System.out.println("\nEnter choice [1-6]: ");

				int getchoice = keyboard.nextInt();
				switch (getchoice) {
				case 1:

					storeCredentials(inpUsername);
					break;

				case 2:
					listallfilenames(inpUsername);
					break;
				case 3:

					fetchCredentials();
					break;

				case 4:

					deleteCredentials();
					break;

				case 5:
					System.out.println("Return to Main Menu");
					loopagain1 = false;
					return;

				case 6:
					System.out.println("Thankyou for using LockMe.com");
					loopagain1 = false;
					System.exit(0);
					break;
				default:
					System.out.println("Please enter a valid input");
					continue;

				}
			} catch (Exception e) {
				System.out.println("Please enter a valid input");
				continue;
			}
		} while (loopagain1);
	}

	// method to sort and display files in ascending order

	private static void listallfilenames(String listUsername) {

		String listfilenames = pathDirect + fileSep;

		File fileDirList = new File(listfilenames);

		File[] listOffiles = fileDirList.listFiles();
		List<String> listFile = new ArrayList<String>();

		for (File gettfile : listOffiles) {
			if ((gettfile.isDirectory() == false) && (gettfile.getAbsolutePath().endsWith(".txt"))) {
				listFile.add(gettfile.getAbsolutePath());

			}
		}

		System.out.println("----------------------------------------");
		System.out.println("::Sorting filenames in ascending order::");
		System.out.println("----------------------------------------");

		Collections.sort(listFile);
		listFile.forEach(System.out::println);

	}

	// method to get input from console and store credentials into a file.

	public static void storeCredentials(String loggedInUser) {

		System.out.println("==========================================");
		System.out.println("*   Welcome to Digital Locker System	 *");
		System.out.println("*    Store Your Credentials here !!!	 *");
		System.out.println("==========================================");

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

		try {
			// create file output stream.
			FileOutputStream sitefile = new FileOutputStream(Framefilename);

			// create object stream
			ObjectOutputStream siteout = new ObjectOutputStream(sitefile);

			// method to serialize object
			siteout.writeObject(userCredentials);

			siteout.close();
			sitefile.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("\nYour Credentials Stored Sucessfully !!!");

	}

	// method to fetch credentials stored in the file and display in the console.

	public static void fetchCredentials() {
		System.out.println("==========================================");
		System.out.println("*   Welcome to Digital Locker System     *");
		System.out.println("*       Your Credentials are here 	 *");
		System.out.println("==========================================");

		System.out.println("Enter an website user name : ");
		String getwebuser = keyboard.next();

		try {
			// 1. read a file
			String fetchfilename = pathDirect + fileSep + getwebuser + ".txt";

			FileInputStream filef = new FileInputStream(fetchfilename);

			// 2. create a input stream object

			ObjectInputStream inf = new ObjectInputStream(filef);

			// 3. method to de-serialized object
			UserCredentials listOfCreds = (UserCredentials) inf.readObject();

			System.out.println("Website User Credentials !");
			System.out.println("****************************");
			System.out.println("Website Name : " + listOfCreds.getSiteName());
			System.out.println("User Name    : " + listOfCreds.getUsername());
			System.out.println("Password     : " + listOfCreds.getPassword());

			inf.close();
			filef.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
// method to delete user input file.

	public static void deleteCredentials() {
		System.out.println("==========================================");
		System.out.println("*   Welcome to Digital Locker System	 *");
		System.out.println("*      Remove Your Credentials 	 *");
		System.out.println("==========================================");

		System.out.println("Enter an website user name to remove: ");
		String delwebuser = keyboard.next();

		String delfilename = pathDirect + fileSep + delwebuser + ".txt";
		File delfile = new File(delfilename);

		if (delfile.delete()) {
			System.out.println("\nFile deleted successfully");
		} else {
			System.out.println("\nFailed to delete the file");
		}

	}

}
