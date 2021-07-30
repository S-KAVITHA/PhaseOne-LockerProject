package accessmodifiersB;

import java.util.Scanner;

// to access public Calculator in access modifier package. import the class.
import accessmodifiers.Calculator;

public class calcdemo {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("---------------------------------------");
		System.out.println(" :: Welcome to Arithmetic calulator :: ");
		System.out.println("---------------------------------------");
		System.out.println("Enter a number1 vaule : ");		
		double number1 = input.nextInt();
		
		System.out.println("Enter a number2 vaule : ");		
		double number2 = input.nextInt();
		
		System.out.println("---------------------------------------");
		System.out.println("             Results  ");	
		System.out.println("---------------------------------------");
//create instance for the public class and access the public properties and methods>
	Calculator calculator = new Calculator();
	System.out.println("Addition of "+ number1+" and "+ number2 +" is    : "+calculator.add(number1, number2));
	System.out.println("Subraction of "+ number1+" and "+ number2 +" is  : "+calculator.subraction(number1, number2));
	System.out.println("Product of "+ number1+" and "+ number2 +" is     : "+calculator.product(number1, number2));
	System.out.println("Division of "+ number1+" and "+ number2 +" is    : "+calculator.division(number1, number2));

	
	}
	
}
