package PhaseOneProject;

import java.io.*;
// Importing utility classes
import java.util.*;

// Class 1
// helper class
class MyObjectOutputStream extends ObjectOutputStream {

	// Constructor of ths class
	// 1. Default
	MyObjectOutputStream() throws IOException {

		// Super keyword refers to parent class instance
		super();
	}

	// Constructor of ths class
	// 1. Parameterized constructor
	MyObjectOutputStream(OutputStream o) throws IOException {
		super(o);
	}

	// Method of this class
	public void writeStreamHeader() throws IOException {
		return;
	}
}

// Class 2
// Helper class
class UserCollection {

	private static String fileSeparator1 = System.getProperty("file.separator");
	private static String pathDir1 = System.getProperty("user.dir");
	// + fileSeparator1 + "main";
	private static String fileNamePath1 = pathDir1 + fileSeparator1 + "adminlogin" + ".txt";

	// private static File f = new File("BankAccountt.txt");

	private static File userFile = new File(fileNamePath1);

	// Method 1
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

					// long accNo = c.getAccountNumber();

					// Print customer name and account
					// number

					// = users.getUserName();
					// = users.getPassword();
					String userId = listOfusers.getUsername();
					String userpassword = listOfusers.getPassword();
					if (userId.equals(inpUsername) && userpassword.equals(inpPassword)) {

						System.out.println("Login Successful ! 200OK");
						System.out.println(inpUsername);
						// found = true;
						lockerOperations.dolockerOperations(inpUsername);
						// break;
					}

				}

				// Closing the connection to release memory
				// resources using close() method
				ois.close();
				fis.close();

				// Once all connection are closed after the
				// desired action change the flag state
				status = true;
			}

			// Catch block to handle the exception
			catch (Exception e) {

				// Print the exception on the console
				// along with display message
				System.out.println("Error Occurred" + e);

				// Exception encountered line is also
				// displayed on console using the
				// printStackTrace() method
				e.printStackTrace();
			}
		}
		return status;
	}

	// Method 2
	// To add a new customer
	public static boolean AddNewUser(Users userinfo) {
		// again, setting and initializing the flag boolean
		// value
		boolean status = false;

		// If customer is not present
		if (userinfo != null) {
			// try block to check for exception
			try {

				// Initially assigning the object null to
				// avoid GC involvement
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

					// Closing the FileOutputStream object
					// to release memory resources
					oos.close();
				}
				System.out.println("User Registration Sucessfull !!!");
				// Closing the File class object to avoid
				// read-write
				fos.close();
			}

			// Catch block to handle the exceptions
			catch (Exception e) {

				// Print the exception along with the
				// display message
				System.out.println("User Registratin Un-Successfull !");
			}

			// Change the flag status
			status = true;
		}

		return status;
	}
}