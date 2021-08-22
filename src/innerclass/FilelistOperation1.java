package innerclass;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;



public class FilelistOperation1 {

	public static void welcomeScreen()
	{
		// step 1. collect input from user console

		String userName = "Kavitha S";
		@SuppressWarnings("resource")
		
		// String path = System.getProperty("user.dir");

		System.out.println("---------------------------------------------------------------");
		System.out.println("         :: Welcome to Digital Locker System :: ");
		System.out.println("                 Developed by " + userName);
		System.out.println("---------------------------------------------------------------");

		System.out.println("\nYou can use this application to ,  ");
		System.out.println("\n1 -> Create files for each user with login credentials. ");
		System.out.println("2 -> Retrieving the file names in an ascending order. ");
		System.out.println("3 -> Perform File operations such as add, delete , search. ");
		System.out.println("4 -> Exit the application");
		
	}

	public static void displaymain() {

		boolean loopagain = true;
		do {

			// try {
			System.out.println("\nEnter choice [1-4]: ");
			Scanner input1 = new Scanner(System.in);

			int choice = input1.nextInt();

			switch (choice) {
			case 1:

				UserfileCreation.filecreate();
				break;

			case 2:
				displayFiles();
				break;

			case 3:

				FileOperations.dofileoperations();
				break;

			case 4:

				System.out.println("Terminated");
				loopagain = false;
				input1.close();
				System.exit(0);
				break;

			default:
				System.out.println("Please enter a valid input");
				break;
			}

			// catch (Exception e) {
			// System.out.println(e.getClass().getName());
			// }

		} while (loopagain);

	}

	private static void displayFiles() {
		// TODO Auto-generated method stub

		String currentDir = System.getProperty("user.dir");
		File fileDir = new File(currentDir);

		File[] files = fileDir.listFiles();
		List<String> listFile = new ArrayList<String>();

		for (File file : files) {
			if ((file.isDirectory() == false) && (file.getAbsolutePath().endsWith(".txt"))) {
				listFile.add(file.getAbsolutePath());
			}
		}

		System.out.println("----------------------------------------");
		System.out.println("::Sorting filenames in ascending order::");
		System.out.println("----------------------------------------");

		Collections.sort(listFile);
		listFile.forEach(System.out::println);

		System.out.println("-----------------------------------------");
		System.out.println("::Sorting filenames in descending order::");
		System.out.println("-----------------------------------------");

		Collections.sort(listFile, Collections.reverseOrder());

		listFile.forEach(System.out::println);
	}

}
