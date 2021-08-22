package collections.map;

import java.util.Scanner;
import java.util.Iterator;


import java.util.HashMap;
import java.util.Map;


public class UPMap
{

	static boolean until = true;
	static boolean loopagain = true;
	
	public static void main(String[] args)
	{
				
	// single dimensional arrays to hold list of ip address values.
					
		
			Map<String,String> mapOfItems = new HashMap<String, String>();
		
			// step 1. collect input from user console
			
			Scanner input = new Scanner(System.in);
			System.out.println("-----------------------------------------");
			System.out.println("    :: Welcome to Security System :: ");
			System.out.println("-----------------------------------------");
			
			do
			{
	           Scanner input1 = new Scanner(System.in);
								
	        	System.out.println("Enter an user name : ");
	        	String emails = input1.nextLine();	
	        	System.out.println("Enter an password : ");
	        	String passwords = input1.nextLine();
				 
	        	mapOfItems.put(emails, passwords);
	        	
	        	
	        	System.out.println("Enter an U-name/password (y/n)?");
	        	String answer = input1.nextLine();
	        	
	        	if (answer.equals("y") || answer.equals("Y"))
	       		{
	       			continue;
	  			}    
	        	else
	        	{
	       			break;
	        	}
	       	}
			while(loopagain);
			
			
			System.out.println(mapOfItems);		
			 
			System.out.println("1--> Show password");
		    System.out.println("2 --> Replace password");
		    System.out.println("3 --> Terminate");
		    
		    
			while (until) 
			{
						
				System.out.println("Enter choice [1-3]: ");
			    int choice = input.nextInt();
			    
			    
			    if (choice != 1 && choice != 2 && choice != 3)
			    {
			    	System.out.println("Invalid choice");
			    	continue;
	    	    }
		     
		   		
			    if (choice == 3 ) 
			    {
			    	System.out.println("Terminated");
	                until = false;
			    	return;		
			    }
		   
			System.out.println("Enter an email address : ");			
						
			@SuppressWarnings("resource")
			Scanner myObj = new Scanner(System.in);
			String useremail = myObj.nextLine();
			
			
			findemailaddress(mapOfItems,useremail,choice);
			
			}
	}
	
	public static void findemailaddress(Map<String,String> mapOfItems, String useremail,int choice)
	{
			int match = 0;
			Iterator<Map.Entry<String, String>> itr = mapOfItems.entrySet().iterator();
	         
	        while(itr.hasNext())
			{
	        	 Map.Entry<String, String> entry = itr.next();
	             
				// match user given userId with existing userids
			//	if (emails[index].equals(useremail)) 
	          
	             
	             if (entry.getKey().equals(useremail))
				{
					switch(choice) 
					{
					case 1:	
						           
						System.out.println("Email address  : " +entry.getKey());
						System.out.println("Password       : " +entry.getValue());
						match++;
						break;
											
					case 2:
						System.out.println("Enter a new password : ");
						Scanner input = new Scanner(System.in);
						String newuserpw = input.nextLine();
						
						mapOfItems.put(entry.getKey(), newuserpw);
						
						//passwords[index] = newuserpw ;
						System.out.println("Password succesfully updated" );
						System.out.println("Email address  : " +entry.getKey());
						System.out.println("Password       : " +entry.getValue());
						match++;
						break;
						
					default:
					   break;
					   					
					}
									
				}
			}

			
			if (match == 0) 
			{
				System.out.println("Email Address not found  : " + useremail);
			}
	}
}