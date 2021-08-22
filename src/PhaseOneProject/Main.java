package PhaseOneProject;

import java.io.*;

//Main class
//Here all above helper classes comes into play
public class Main {

 // Main driver method
 public static void main(String[] args)
 {
     // Class objects assigned with constructors
     // Customer input entries
	 Users c1 = new Users("Rita", "red","oo");
	 Users c2 = new Users("Sita","blue","pp");
	 
    
     // Adding new customers as created above
	 CustomerCollection.AddNewCustomer(c1);
	 CustomerCollection.AddNewCustomer(c2);
   

     // Display message for better readibility and
     // understanding
     System.out.println("****Reading File****");

     // Lastly reading File
     CustomerCollection.readFile();
 }
}