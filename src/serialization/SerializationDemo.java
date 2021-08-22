package serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializationDemo {

	public static void main(String[] args) {

		// 1. create object
		Employee employee = new Employee(100001, "Will Smith", "Engineering");
		//Employee employee1 = new Employee(100002, "dave Smith", "Engineering");
		//Employee employee2 = new Employee(100003, "Eva Smith", "Engineering");

		String fileSeparator1 = System.getProperty("file.separator");

		String pathDir = System.getProperty("user.dir");
		String fileNamePath = pathDir + fileSeparator1 + "file-db.txt";

		File tempFile = new File(fileNamePath);

		boolean append = tempFile.exists();
		System.out.println(append);

		ArrayList<Employee> woi = new ArrayList<>();

		// 2. create a byte strem.
int i = 0;

		for (i = 0; i <4 ; i++)

		{
			try {
				// create file output stream.
				if (append) {
					FileOutputStream file = new FileOutputStream(fileNamePath, append);

					// create object stream
					ObjectOutputStream out = new ObjectOutputStream(file);

					woi.add(employee);
					
					out.writeObject(woi);

					System.out.println("Serialization is upd completed !");

					out.close();
					file.close();
				} else {
					FileOutputStream file = new FileOutputStream(fileNamePath);

					// create object stream
					ObjectOutputStream out = new ObjectOutputStream(file);

					woi.add(employee);
					System.out.println("Serialization is completed !");

					out.close();
					file.close();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}