package PhaseOneProject;

import java.io.*;
// Importing utility classes
import java.util.*;

class MyObjectOutputStream extends ObjectOutputStream {

	MyObjectOutputStream() throws IOException {

		// Super keyword refers to parent class instance
		super();
	}

	// Constructor of this class
	// 1. Parameterized constructor
	MyObjectOutputStream(OutputStream o) throws IOException {
		super(o);
	}

	// Method of this class
	public void writeStreamHeader() throws IOException {
		return;
	}
}

// class to collect user credentials for different web sites and stores into a file.

class UserCollection {

	private static String fileSeparator1 = System.getProperty("file.separator");
	private static String pathDir1 = System.getProperty("user.dir");

	private static String fileNamePath1 = pathDir1 + fileSeparator1 + "adminlogin" + ".txt";

	private static File userFile = new File(fileNamePath1);

	// To read from the file
	public static boolean readFile(String inpUsername, String inpPassword) {
		// Initially setting boolean value as false
		boolean status = false;

		// Try block to check for exceptions
		try {

			// Creating new file using File object above
			userFile.createNewFile();
		}

		// Catch block to handle the exception
		catch (Exception e) {
		}

		// If the file is empty

		if (userFile.length() != 0) {

			try {

				// If file doesn't exists
				FileInputStream fis = null;

				fis = new FileInputStream(fileNamePath1);
				ObjectInputStream ois = new ObjectInputStream(fis);

				Users listOfusers = null;

				while (fis.available() != 0) {

					listOfusers = (Users) ois.readObject();

					String userId = listOfusers.getUsername();
					String userpassword = listOfusers.getPassword();

					if (userId.equals(inpUsername) && userpassword.equals(inpPassword)) {
						System.out.println("\nLogin Successfull ! 200OK");
						lockerOperations.dolockerOperations(inpUsername);
					}

				}

				ois.close();
				fis.close();
				System.out.println("\nLogin failed. Invalid User Credentials");

				status = true;
			}

			// Catch block to handle the exception
			catch (Exception e) {

				System.out.println("Error Occurred" + e);
				e.printStackTrace();
			}
			
		}
		return status;
	}

	// method to add a new user credentials into a file.

	public static boolean AddNewUser(Users userinfo) {

		boolean status = false;

		if (userinfo != null) {
			// try block to check for exception
			try {

				FileOutputStream fos = null;

				// Creating an new FileOutputStream object
				fos = new FileOutputStream("adminlogin.txt", true);

				// If there is nothing to be write onto file
				if (userFile.length() == 0) {
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(userinfo);
					oos.close();
				}

				// There is content in file to be write on
				else {

					MyObjectOutputStream oos = null;
					oos = new MyObjectOutputStream(fos);
					oos.writeObject(userinfo);

					oos.close();
				}
				System.out.println("\nUser Registration Sucessfull !!!");

				fos.close();
			}

			// Catch block to handle the exceptions
			catch (Exception e) {

				System.out.println("\nUser Registratin Un-Successfull !");
			}

			// Change the flag status
			status = true;
		}

		return status;
	}
}