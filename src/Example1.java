import java.util.Scanner;

public class Example1 {
	// converting int , byte , short  => float , double , long.

public static void main(String[] args) {
		
		// step 1. collect input from user console
	
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println(" :: Welcome to numeric convertor :: ");
		System.out.println("---------------------------------------");
		
//int to long , float , double conversion
		
		System.out.println("\n\nEnter a int number vaule : ");
		int intInput = input.nextInt();
		long bigCount = intInput; // widening => int => long        
        float floatCount = intInput; // widening => int => float
        double decimalCount = intInput;  // widening => int => double
			
        System.out.println("-----Implicit int converted values ----");
		System.out.println("Long Value   : "+bigCount);
		System.out.println("Float Value  : "+floatCount);
	    System.out.println("Double Value : "+decimalCount);
     
	    
//byte to long , float , double conversion    
	 
        System.out.println("\n\nEnter a byte number vaule : ");
        byte byteInput = input.nextByte();
		long bigCount1 = byteInput; // widening => byte => long        
        float floatCount1 = byteInput; // widening => byte => float
        double decimalCount1 = byteInput;  // widening => byte => double
	
        System.out.println("-----Implicit byte converted values ----");
		System.out.println("Long Value   : "+bigCount1);
		System.out.println("Float Value  : "+floatCount1);
	    System.out.println("Double Value : "+decimalCount1);
        
	    
	    
//short to long , float , double conversion
		
        System.out.println("\n\nEnter a short number vaule : ");
        short shortInput = input.nextShort();
		long bigCount2 = shortInput; // widening => short => long        
        float floatCount2 = shortInput; // widening => short => float
        double decimalCount2 = shortInput;  // widening => short => double
	
        
        System.out.println("-----Implicit short converted values ----");
		System.out.println("Long Value   : "+bigCount2);
		System.out.println("Float Value  : "+floatCount2);
	    System.out.println("Double Value : "+decimalCount2);
	

	}

}
