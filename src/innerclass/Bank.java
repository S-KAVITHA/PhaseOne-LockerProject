package innerclass;

public class Bank
{

	class Finance 
	{
		// properties & methods
		double cashPymnt = 50000d;
		double taxCalc=1000d;
		double payRoll=70000d;
			
		public void finshowData()
		{
			System.out.println("-------------------------------------------------------");
			System.out.println("            :Finance details:       ");
			System.out.println("-------------------------------------------------------");
			
			System.out.println("Cash Payment     :  "+ cashPymnt);
			System.out.println("Tax Calculation  :  "+ taxCalc);
			System.out.println("Payroll Balance  :  "+ payRoll);
		}	
		
		
		
	}

	
	class Insurance
	{
		// properties & methods
		String insurName = "Bajaj Insurance";
		Long insurId = 10045677L ;
		String insurdesc = "Loan safety policy" ;
		
		public void insshowData()
		{
			System.out.println("-------------------------------------------------------");
			System.out.println("            :Insurance details      ");
			System.out.println("-------------------------------------------------------");
			
			System.out.println("Insurance Name        :  "+ insurName);
			System.out.println("Insurance Id          :  "+ insurId);
			System.out.println("Insurance Description :  "+ insurdesc);
		}	
	}
	
	class Lockers
	{
		// properties & methods
		Long lockerId = 56789999L ;
		double lockerdeposit = 5000;
		String lockerduration = "5years";
	
		public void lockshowData()
		{
			System.out.println("-------------------------------------------------------");
			System.out.println("            :Locker details:        ");
			System.out.println("-------------------------------------------------------");
			
			System.out.println("Locker Id       :  "+ lockerId);
			System.out.println("Locker deposit  :  "+ lockerdeposit);
			System.out.println("Locker term     :  "+ lockerduration);
		}	
		
	}
	
	class Banking 
	{
		// properties & methods
		Long acctNumber = 10023456L ;
		String acctName = "Joe Thomas";
		double acctbalance = 500d ;
		
		// showBalance, Withdraw , deposit etc.
		
		public void showData()
		{
			System.out.println("-------------------------------------------------------");
			System.out.println("            :Account details:       ");
			System.out.println("-------------------------------------------------------");
			
			System.out.println("Account Number  :  "+ acctNumber);
			System.out.println("Account Name    :  "+ acctName);
			System.out.println("Account Balance :  "+ acctbalance);
		}	
		
		public double withdrawAmount(double amount)
		{
			if(amount>0 || amount<acctbalance) 
			{
				acctbalance -= amount; // account.balance = account.balance- amount;
				
				System.out.println("-------------------------------------------------------");
				System.out.println("            :Withdrawal:            ");
				System.out.println("-------------------------------------------------------");
				
				System.out.println("You withdrew     : "+amount);
				System.out.println("Account balance  : "+acctbalance);
				
				return acctbalance;
				
			} else
			{
				System.out.println("Invalid withdraw amount !");
				return 0;
			}
		}
	
		
		public double depositAmount(double amount)
		{
				acctbalance += amount; // account.balance = account.balance - amount;
			
				System.out.println("-------------------------------------------------------");
				System.out.println("            :Deposits:              ");
				System.out.println("-------------------------------------------------------");
				
				System.out.println("You deposited    : "+amount);
				System.out.println("Account balance  : "+acctbalance);
				return acctbalance;
		}
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Bank bankobj = new Bank();
		Finance finobj = bankobj.new Finance();
		Insurance Insobj = bankobj.new Insurance();
		Lockers Lockobj = bankobj.new Lockers();
		Banking Bankingobj = bankobj.new Banking();
		
		finobj.finshowData();
		Insobj.insshowData();
		Lockobj.lockshowData();
		Bankingobj.showData();
		Bankingobj.withdrawAmount(100.50);
		Bankingobj.depositAmount(50000);
	}

}