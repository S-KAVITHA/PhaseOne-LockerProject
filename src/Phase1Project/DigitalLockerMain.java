package Phase1Project;

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
		System.out.println("---------------------------------------------------------------");
		System.out.println("         :: Welcome to Digital Locker System :: ");
		System.out.println("                 Developed by " + userName);
		System.out.println("---------------------------------------------------------------");

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

					LoginAsAdmin.checkloginInfo();
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

		// Scanner myobj = new Scanner(System.in);
		System.out.println("--------------------------------------------");
		System.out.println("Add new file with user details:  ");
		System.out.println("--------------------------------------------");

		System.out.println("Enter an user name : ");
		String userName = myobj.nextLine();

		System.out.println("Enter an password : ");
		String password = myobj.nextLine();

		System.out.println("Enter an email ID : ");
		String emailID = myobj.nextLine();

		System.out.println("Enter an role : ");
		String role = myobj.nextLine();

		Users userdetails = new Users(userName, password, emailID, role);
		//Users userdetails = new Users("w", "w", "w", "w");

		File createFolder = new File("main");

		// If file doesn't exist, create the main folder
		if (!createFolder.exists()) {
			createFolder.mkdirs();
		}

		writeAdminfile(userdetails);
		// }

	}

	@SuppressWarnings("resource")
	private static void writeAdminfile(Users userdetails) {

		ArrayList<Users> woi =new ArrayList<>();
		
		
			//String pathDir = System.getProperty("user.dir") + fileSeparator1 + "main";
		//	String fileNamePath = pathDir + fileSeparator1 + "adminlogin" + ".txt";

			
			String pathDir = System.getProperty("user.dir");
			String fileNamePath = pathDir + fileSeparator1 + "adminlogin.txt";
			
			File tempFile = new File(fileNamePath);
			//System.out.println(fileNamePath);
			//System.out.println(tempFile);

			boolean append = tempFile.exists();
			System.out.println(append);
			
			try {
				// create file output stream.
				if (append) {
					FileOutputStream file = new FileOutputStream(fileNamePath, append);

					// create object stream
					ObjectOutputStream out = new ObjectOutputStream(file);

					woi.add(userdetails);
					
					out.writeObject(woi);

					System.out.println("Serialization is upd completed !");

					out.close();
					file.close();
				} else {
					FileOutputStream file = new FileOutputStream(fileNamePath);

					// create object stream
					ObjectOutputStream out = new ObjectOutputStream(file);

					woi.add(userdetails);
					System.out.println("Serialization is completed !");

					out.close();
					file.close();
				}

				
			FileInputStream file1 = new FileInputStream(fileNamePath);
			
			// 2. create a input strem object
			@SuppressWarnings("resource")
			ObjectInputStream in = new ObjectInputStream(file1);
			System.out.println(":: !");	
		//	System.out.println("Deserialized Data: \n" + in.readObject().toString());
			
			Users users = (Users) in.readObject();
		//	Object obj = in.readObject();
			
		
			
		//	System.out.println(obj);
			

			//ArrayList<Employee> computers = (ArrayList<Employee>) obj;
        
			
            //System.out.println(computers);
            
			/*
			 * for (Employee employee : computers) {
			 * System.out.println("--------------------------");
			 * System.out.println(employee.toString());
			 * System.out.println("------------------------------");
			 * 
			 * System.out.println(" De serialization completed !");
			 * 
			 * }
			 */
			
			
		} catch (Exception ex) {
			System.out.println("File Creation Un-Sucessfull !");
		}
	}

}
