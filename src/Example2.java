
import java.util.Scanner;

public class Example2 {
	// converting long, float , int => byte , short , double.

public static void main(String[] args) {
		
		// step 1. collect input from user console
	
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println(" :: Welcome to numeric convertor :: ");
		System.out.println("---------------------------------------");
		
//long to byte , short , double conversion
		
		System.out.println("\n\nEnter a long number vaule : ");
		long longInput = input.nextLong();
		byte byteCount = (byte)longInput; // narrowing => long => byte        
        short shortCount = (short)longInput; // narrowing => long => short
        double decimalCount = longInput;  // widening => long => double
			
        System.out.println("-----Long converted values ----");
		System.out.println("Byte Value   : "+byteCount);
		System.out.println("Short Value  : "+shortCount);
	    System.out.println("Double Value : "+decimalCount);
 
	    
 //float to byte , short , double conversion
	  		
	  		System.out.println("\n\nEnter a float number vaule : ");
	  		float floatInput = input.nextFloat();
	  		byte byteCount1 = (byte)floatInput; // narrowing => float => byte        
	        short shortCount1 = (short)floatInput; // narrowing => float => short
	        double decimalCount1 = floatInput;  // widening => float => double
	  			
	        System.out.println("-----Float converted values ----");
	  		System.out.println("Byte Value   : "+byteCount1);
	  		System.out.println("Short Value  : "+shortCount1);
	  	    System.out.println("Double Value : "+decimalCount1);
	       
		
//int to byte , short , double conversion
		
		System.out.println("\n\nEnter a int number vaule : ");
		int intInput = input.nextInt();
		byte byteCount2 = (byte)intInput; // narrowing => int => byte        
        short shortCount2 = (short)intInput; // narrowing => int => short
        double decimalCount2 = intInput;  // widening => int => double
			
        System.out.println("-----Int converted values ----");
		System.out.println("Byte Value   : "+byteCount2);
		System.out.println("Short Value  : "+shortCount2);
	    System.out.println("Double Value : "+decimalCount2);
	}  
}