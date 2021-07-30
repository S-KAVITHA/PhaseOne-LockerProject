// package typecasting;


import java.util.Scanner;
import java.util.Arrays;  

public class Example3 
{

	public static void main(String[] args) 
	{
		// string to number value (byte , short , int, long ,double , float)
      
		
// collect user input from console -> 
		
			Scanner input = new Scanner(System.in);
			System.out.println("---------------------------------------------");
			System.out.println(" :: Welcome to string -> numeric convertor :: ");
			System.out.println("---------------------------------------------");
			
			//System.out.println("\n\nEnter a string vaule : ");
			//String strInput = input.nextLine();
			String strInput = "127";
		
			
			int strLength = strInput.length();
						
			int byteMax = String.valueOf(Byte.MAX_VALUE).length();			
			int byteMin = String.valueOf(Byte.MIN_VALUE).length();
			
			System.out.println(strLength);
			
			System.out.println(byteMax);
			System.out.println(byteMin);
			
			int shortMax = String.valueOf(Short.MAX_VALUE).length();			
			int shortMin = String.valueOf(Short.MIN_VALUE).length();
			
			System.out.println(shortMax);
			System.out.println(shortMin);
			
			if (strLength < byteMin && strLength <= byteMax)
			{
				
			byte byteValue = Byte.parseByte(strInput);
			System.out.println("Byte Value     : "+byteValue);
			
			}
			
			if (strLength <= shortMin && strLength <= shortMax)
			{
								
				short shortValue = Short.parseShort(strInput);
				//byte byteValue = (byte)shortValue;
				//System.out.println("Byte Value     : "+byteValue);
				System.out.println("Short Value    : "+shortValue);
			}
			
			
			
			int intValue  = Integer.parseInt(strInput);
			long longValue = Long.parseLong(strInput);
			float floatValue = Float.parseFloat(strInput);
			double doubleValue = Double.parseDouble(strInput);
		
		
		
		
		System.out.println("Integer Value  : "+intValue);
		System.out.println("Long Value     : "+longValue);
		System.out.println("Float Value    : "+floatValue);	
		System.out.println("Double Value   : "+doubleValue);
		
	}
}
