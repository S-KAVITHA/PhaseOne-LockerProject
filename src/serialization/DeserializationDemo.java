package serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DeserializationDemo {
	
	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) {
		
		
		try {
			// 1. read a file
			FileInputStream file = new FileInputStream("file-db.txt");
			
			// 2. create a input strem object
			@SuppressWarnings("resource")
			ObjectInputStream in = new ObjectInputStream(file);
				
			Employee obj = (Employee) in.readObject();
			System.out.println(in.readObject());
			
			//ArrayList<Employee> computers = (ArrayList<Employee>) obj;
        
			
           // System.out.println(computers);
            
			/*
			 * for (Employee employee : computers) {
			 * System.out.println("--------------------------");
			 * System.out.println(employee.toString());
			 * System.out.println("------------------------------");
			 * 
			 * System.out.println(" De serialization completed !");
			 * 
			 * System.out.println("Emp Id : "+employee.getId());
			 * System.out.println("Emp Name : "+employee.getName());
			 * System.out.println("Emp Dept : "+employee.getDept());
			 * 
			 * }
			 */
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}