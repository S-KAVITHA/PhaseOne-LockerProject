package Phase1Project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOperations {

	@SuppressWarnings("resource")
	public static void dofileoperations() {

		String fileSeparator = System.getProperty("file.separator");
		String path = System.getProperty("user.dir") + fileSeparator + "main";

		boolean loopagain = true;

		System.out.println("\n1 -> Add a file to the main directory");
		System.out.println("2 -> Delete a file from the main directory");
		System.out.println("3 -> Search a user specified file from the main directory");
		System.out.println("4 -> Return to Main Menu");
		System.out.println("5 -> Exit the application");

		do {

			Scanner input = new Scanner(System.in);
			System.out.println("\nEnter choice [1-5]: ");
			int choice = input.nextInt();

			switch (choice) {
			case 1:

				UserfileCreation.filecreate();
				break;

			case 2:

				System.out.println("\nEnter file to delete: ");
				input.nextLine();
				String filename = input.nextLine();

				System.out.println(path);
				String fullpath = path + fileSeparator + filename;
				System.out.println(fullpath);
				try {
					Files.delete(Paths.get(fullpath));
					System.out.println("File is deleted !");

				} catch (IOException e) {
					System.out.println("File Not Found Exception !");
				}

				break;
			case 3:

				File dir = new File(path);
				File[] listOffiles = dir.listFiles();
				List<String> searchFiles = new ArrayList<String>();

				System.out.println("Enter an file name : ");
				input.nextLine();
				String name = input.nextLine();

				for (File getFile : listOffiles) {
					if (getFile.getName().startsWith(name)) {
						searchFiles.add(getFile.getAbsolutePath());
					}
				}

				searchFiles.forEach(System.out::println);
				break;

			case 4:
				System.out.println("Return to Main Menu");
				return;

			case 5:
				System.out.println("Exit the application");
				loopagain = false;
				input.close();
				System.exit(0);
				break;

			default:

				System.out.println("Please enter a valid input");
				break;

			}

		} while (loopagain);
	}
}
