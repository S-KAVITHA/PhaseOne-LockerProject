package collections;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class Bankoperations 
{
	public static void main(String[] args)
	{
		
		// get the input from user
		
		boolean loopagain = true;
		boolean inloop = true;
		
		double initialBal = 0  ;
		
		System.out.println("-----------------------------------------");
		System.out.println("    :: Welcome to Banking System :: ");
		System.out.println("-----------------------------------------");
		    
		System.out.println("1 --> Open account");
	    System.out.println("2 --> Show balance");
	    System.out.println("3 --> Deposit");
	    System.out.println("4 --> Withdrawal");
	    System.out.println("5 --> Close account");
	    System.out.println("6 --> Terminate");
	    
	    // create map object to store account details with key as account no.
	    
		Map<Long,Account> accountMap = new LinkedHashMap<Long,Account>();
		
		//	loop through to get account information from user and store the details into map object.
	  do
		{
	    
	    	Scanner myobj = new Scanner(System.in);	
	    	System.out.println("\nEnter choice [1-6]): ");
	    	int choice = myobj.nextInt();	
	    	
	    	switch (choice)
	    	{
	    	case 1:
	    	 do
	    	 {
	    			     
	    		System.out.println("Enter Account no     : ");
	    		Long accountNo = myobj.nextLong();
			 				     
	    		System.out.println("Enter holder name :");
	    		myobj.nextLine();
			    String acctName = myobj.nextLine();
			   	    		
	    	    Account account1 = new Account(accountNo,acctName, initialBal);
	    	    accountMap.put(accountNo, account1);
	    	   
	    	    System.out.println("Enter account details (y/n)?");
	    	    
	    	    String answer = myobj.nextLine();
	    	  
        	
	    	    if (answer.equals("y") || answer.equals("Y"))
	    	    {
	    	    	continue;
	    	    }    
	    	    else
	    	    {
	    	    	break;
	    	    }
	    	 }
	    	 while(inloop);
	    		break;	
	    		
	    	case 2:
	    		
	    		// show account balance with the user input account no.
	    		
	    		 System.out.println("Enter account no: ");
		   		 Long getAcctnum = myobj.nextLong();
	    	 	 showAccount(accountMap,getAcctnum);
	    		 break;
	    			
	    	case 3:
	    		
	    		//deposit to the account entered by the user.
	    		
	    		 System.out.println("Enter the deopsit account no: ");
		   		 Long depAcctnum = myobj.nextLong();
		   		 deposits(accountMap,depAcctnum);
		   		 break;
	    		
	    	case 4:
	    		
	    		//withdraw amount from the user entered account.
	    		
	    		 System.out.println("Enter the withdrawal account no: ");
		   		 Long withdrawAcct = myobj.nextLong();
		   		 withdrawal(accountMap,withdrawAcct);
		   		 break;
		   		 
	    	case 5:
	    		
	    		// close the account entered by the user.
	    		
	    		System.out.println("Enter the closure account no: ");
	    		Long closeAcct = myobj.nextLong();
	    		closeaccount(accountMap,closeAcct);
	    		break;
	    		
	    	case 6:
	    		return;
	    	}
		}
 
		while(loopagain);
	   }
	    
	
	private static void showAccount(Map<Long,Account> accountMap,Long getAcctnum)
	{
		// if account is present then display the details
		
		if (accountMap.containsKey(getAcctnum))
		{
			System.out.println("Account details:: ");
			System.out.println("------------------");
			System.out.println("Account Number     : "+getAcctnum);
			System.out.println("Account Name       : "+accountMap.get(getAcctnum).getName());
			System.out.println("Account Balance    : "+accountMap.get(getAcctnum).getBalance());
			System.out.println("--------------------------------------");
		}
		else
	    {
	    	System.out.println("\nInvalid account number ");
	    } 		
	}
		
		 @SuppressWarnings("resource")
	public static void deposits(Map<Long,Account> accountMap,Long depAcctnum)
	{
	
		// if deposit account exists then add amount into the account balance.
		if (accountMap.containsKey(depAcctnum))
	 	{	 
			Scanner input = new Scanner(System.in);
			System.out.println("Amount to deposit : ");
			double depositAmt = input.nextDouble();
	   	
			Account acctfetch =accountMap.get(depAcctnum);
	    		
			double acctBalance = acctfetch.getBalance();
	    		
	   
		    acctBalance += depositAmt;		    				
		    acctfetch.setBalance(acctBalance);
		    						
		    System.out.println("\nYou deposited    : "+depositAmt);
		    System.out.println("\nAccount Balance  : "+acctBalance);
		    		
		    System.out.println("\n"+ accountMap);
		    						
	    }
		else
    	{
			System.out.println("\nInvalid account number  ");
		 } 
		    	    
	}
		 
	public static void withdrawal(Map<Long, Account> accountMap , Long withdrawAcct)
	{
	   	
		// if withdrawal account exists then deduct the amount from the account balance.
		if (accountMap.containsKey(withdrawAcct))
		{
			
			Scanner input1 = new Scanner(System.in);
			System.out.println("Amount to withdraw : ");
			double withdrawAmt = input1.nextDouble();
	   	
			Account acctfetch1 =accountMap.get(withdrawAcct);
			double acctBalance1 = acctfetch1.getBalance();
	    	
	   		if (acctBalance1>= withdrawAmt)
	   		{
	   			acctBalance1 -= withdrawAmt;		    				
	   			acctfetch1.setBalance(acctBalance1);
	    			   			    						
	   			System.out.println("\nYou Withdrew    : "+withdrawAmt);
	   			System.out.println("\nAccount Balance : "+acctBalance1);
	    		
	   			System.out.println("\n"+accountMap);
	   		}
	   		else 
	   		{
	   			System.out.println("\nInsufficient balance  ");
	   		}
	   	} 
	   	else
	   	{
	   		System.out.println("\nInvalid account number  ");
	   	} 
	    	
	}  
	
	public static void closeaccount(Map<Long, Account> accountMap , Long closeAcct)
	{
		
		// if account is exists then close the account.
		
		if (accountMap.containsKey(closeAcct))
       	{ 
			accountMap.remove(closeAcct);
			System.out.println(accountMap);
       	}
		else
	   	{
	   		System.out.println("\nInvalid account number  ");
	   	}
	   	
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	