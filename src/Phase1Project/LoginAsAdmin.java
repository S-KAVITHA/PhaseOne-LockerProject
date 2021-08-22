package Phase1Project;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginAsAdmin {

	static String fileSeparator1 = System.getProperty("file.separator");
	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		checkloginInfo();

	}

	public static void checkloginInfo() {

		System.out.println("==========================================");
		System.out.println("*					*");
		System.out.println("*   WELCOME TO LOGIN PAGE	 *");
		System.out.println("*					*");
		System.out.println("==========================================");
		System.out.println("Enter Username :");
		String inpUsername = keyboard.next();
		System.out.println("Enter Password :");
		String inpPassword = keyboard.next();

		// boolean found = false;

		fetchFileInfo(inpUsername, inpPassword);

	}

	public static void fetchFileInfo(String inpUsername, String inpPassword) {
		try {

			String pathDir1 = System.getProperty("user.dir"); 
					//+ fileSeparator1 + "main";
			String fileNamePath1 = pathDir1 + fileSeparator1 + "adminlogin" + ".txt";

			// 1. read a file
			FileInputStream adminfile = new FileInputStream(fileNamePath1);

			// 2. create a input stream object
		
			System.out.println(fileNamePath1);
			//System.out.println(adminfile);
			ObjectInputStream inp = new ObjectInputStream(adminfile);

			// 3. method to serialized object
			@SuppressWarnings("unused")
			
			
			//Users users = (Users) in.readObject();
			//System.out.println("------------");
			//System.out.println(users);
			
			Object obj = inp.readObject();
			System.out.println(obj);
			

			@SuppressWarnings({ "unchecked", "unused" })
			ArrayList<Users> users1 = (ArrayList<Users>) obj;
			
			
			/*
			 * for (Users user : users) { System.out.println("--------------------------");
			 * System.out.println(user.toString());
			 * System.out.println("------------------------------");
			 * 
			 * System.out.println(" De serialization completed !");
			 * 
			 * // System.out.println("Emp Id : "+employee.getId()); //
			 * System.out.println("Emp Salary : "+employee.getSalary()); }
			 */
			
			

			//System.out.println(users);

			//String userId = users.getUserName();
			//String userpassword = users.getPassword();

		//	System.out.println(userId);
		//	System.out.println(userpassword);
		//	System.out.println(inpUsername);
		//	System.out.println(inpPassword);

		//	if (userId.equals(inpUsername) && userpassword.equals(inpPassword)) {

			//	System.out.println("Login Successful ! 200OK");
				// found = true;
				//lockerOptions(inpUsername);
				// break;
			//}

		}catch(Exception e){
		System.out.println("Invalid User Credentials : Login Failure : 404");
		}
	}

	public static void lockerOptions(String inpUsername) {
		System.out.println("1 . FETCH ALL STORED CREDENTIALS ");
		System.out.println("2 . STORED CREDENTIALS ");
		int option = keyboard.nextInt();
		switch (option) {
		case 1:
			// fetchCredentials(inpUsername);
			break;
		case 2:
			// storeCredentials(inpUsername);
			break;
		default:
			System.out.println("Please select 1 Or 2");
			break;
		}
		// lockerInput.close();
	}

}
