package Phase1Project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class UserfileCreation {

	@SuppressWarnings("resource")
	public static void filecreate() {

		File createFolder = new File("main");
		String fileSeparator1 = System.getProperty("file.separator");
		
		
		// If file doesn't exist, create the main folder
		if (!createFolder.exists()) {
			createFolder.mkdirs();
		}
		
		String pathDir = System.getProperty("user.dir") + fileSeparator1 + "main";
		
		System.out.println(pathDir);
				
		Scanner myobj = new Scanner(System.in);
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

		try {

			String fileNamePath =  pathDir + fileSeparator1 + userName + ".txt";
			System.out.println(fileNamePath);
			
			FileOutputStream file = new FileOutputStream(fileNamePath);

			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(userdetails);

			out.close();
			file.close();
			System.out.println("File Creation Sucessfull !!!");

		} catch (Exception ex) {
			System.out.println("File Creation Un-Sucessfull !");
		}

	}

}
