package PhaseOneProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class DigitalLockerMain {

	private static Scanner myobj;
	@SuppressWarnings("unused")
	private static String fileSeparator1 = System.getProperty("file.separator");

	public static void main(String[] args) {

		// String path = System.getProperty("user.dir");
		initapplicatin();
		welcomeScreen();
		displaymain();
	}

	public static void initapplicatin() {
		myobj = new Scanner(System.in);

	}

	public static void welcomeScreen() {
		// step 1. collect input from user console
		String userName = "Kavitha S";
		System.out.println("::********************************************::");
		System.out.println("\n       Welcome to LockMe.com ");
		System.out.println("\n::********************************************::");
		System.out.println("         Your Personal Digital Locker   ");
		System.out.println("            Developed by " + userName);
		System.out.println("\n************************************************");

		System.out.println("\nYou can use this application to ,  ");
		System.out.println("\n1 -> Registration. ");
		System.out.println("2 -> Login ");
		System.out.println("3 -> Exit the application");

	}

	public static void displaymain() {

		boolean loopagain = true;
		do {

			try {

				System.out.println("\nEnter choice [1-3]: ");
				Scanner input1 = new Scanner(System.in);
				int choice = input1.nextInt();

				switch (choice) {
				case 1:

					adminfileCreation();
					break;

				case 2:

					checkloginInfo();
					break;

				case 3:

					System.out.println("Terminated");
					loopagain = false;
					input1.close();
					System.exit(0);
					break;

				default:
					System.out.println("Please enter a valid input");
					break;
				}
			} catch (Exception e) {
				System.out.println("Please enter a valid input");
			}

		} while (loopagain);

	}

	public static void adminfileCreation() {

		System.out.println("--------------------------------------------");
		System.out.println("Add new file with user details:  ");
		System.out.println("--------------------------------------------");

		System.out.println("Enter an user name : ");
		String userName = myobj.nextLine();

		System.out.println("Enter an password : ");
		String password = myobj.nextLine();

		System.out.println("Enter an email ID : ");
		String emailID = myobj.nextLine();

		Users userdetails = new Users(userName, password, emailID);

		// Users userdetails = new Users("w", "w", "w", "w");

		File createFolder = new File("main");

		// If file doesn't exist, create the main folder
		if (!createFolder.exists()) {
			createFolder.mkdirs();
		}

		UserCollection.AddNewUser(userdetails);

		// writeAdminfile(userdetails);
		// }

	}

	private static void checkloginInfo() {
		
		
		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   WELCOME TO LOGIN PAGE	 *");
		System.out.println("*					*");
		System.out.println("==========================================");
		System.out.println("Enter Username :");
		String inpUsername = myobj.next();
		System.out.println("Enter Password :");
		String inpPassword = myobj.next();
		System.out.println("****Reading File****");

	     // Lastly reading File
	     UserCollection.readFile(inpUsername,inpPassword);

	}

}
