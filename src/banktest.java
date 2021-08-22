
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

public class banktest 
{

	public static void main(String[] args)
	{
		
		boolean loopagain = true;
		
		double initialBal = 0d ;
		
		System.out.println("-----------------------------------------");
		System.out.println("    :: Welcome to Banking System :: ");
		System.out.println("-----------------------------------------");
		    
		System.out.println("1 --> Open account");
	    System.out.println("2 --> Deposit");
	    System.out.println("3 --> Withdrawal");
	    System.out.println("3 --> Close account");
	    System.out.println("3 --> Terminate");
	    
		Map<Long, Account> accountMap = new LinkedHashMap<Long, Account>();
		
	  do
		{
	    
	    	Scanner getinp = new Scanner(System.in);
	    	
	    	System.out.println("Enter choice [1-3]: ");
	    	int choice = getinp.nextInt();
	 
	    	if (choice == 1)
	    	{
	    		Scanner myobj = new Scanner(System.in);
    			 			     
	    		System.out.println("Enter Account no     : ");
	    		Long accountNo = myobj.nextLong();
			 				     
	    		System.out.println("Enter holder name :");
	    		myobj.nextLine();
			    String acctName = myobj.nextLine();
	    		
	    	    Account account1 = new Account(accountNo,acctName, initialBal);
	    	
		
	    	    Account account2 = new Account(1002L, "Jeet Kumar", 90000.50d);
	    	//Account account3 = new Account(1003, "Emma Kim", 50000d);
	    	//Account account4 = new Account(1004, "David Miller", 60000d);
	    	//Account account5 = new Account(1005, "Tony Stark", 40000.50d);
		    	
	    	
	    	    accountMap.put(accountNo, account1);
	    	// accountMap.put(7000002L, account2);
	    	}	
	    	System.out.println("Enter account details (y/n)?");
	    	String answer = getinp.nextLine();
        	
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
	
	    	
		//accountMap.put(7000002L, account2);
		//accountMap.put(7000003L, account3);
		//accountMap.put(7000004L, account4);
		//accountMap.put(7000005L, account5);
		
		//showas(accountMap);
	    for(Map.Entry<Long, Account> entry : accountMap.entrySet())
	    {
	    		Long acctNum = entry.getKey();
	    		System.out.println("-----------------");
	    		System.out.println("Account Number : "+entry.getKey());
	    		System.out.println("Account Name : "+entry.getValue().getName());
	    		System.out.println("Account Balance : "+entry.getValue().getBalance());
			
	    		Scanner input = new Scanner(System.in);
	    		System.out.println("Amount to withdraw : ");
	    		double withdrawAmt = input.nextDouble();
	    		double acctBalance = entry.getValue().getBalance();
	    		System.out.println(acctBalance);
			
	    		if (acctBalance>= withdrawAmt)
	    		{
	    			acctBalance -= withdrawAmt;
	    			entry.setValue(entry.getValue()).setBalance(acctBalance);
				
	    			System.out.println("\n You Withdrew    : "+withdrawAmt);
	    			System.out.println("\n Account Balance : "+entry.getValue().getBalance());
				
	    		}
	    		else
	    		{
	    			System.out.println("\n Insufficient balance  ");
	    		}          
	    	}

		
	    
	    
		//System.out.println(accountMap.get(7000001L));
	}
//showas(Map<Long, Account> accountMap){}