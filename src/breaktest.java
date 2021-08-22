import java.util.Scanner;

public class breaktest
{
	public static void main(String[] args)
	{
		
		Scanner myobj = new Scanner(System.in);
		
		 System.out.println("Enter username");
	     String acctName = myobj.nextLine();
	     
	     
		int [] numbers = {5,10,15,20,25} ;
		for (int x : numbers)
		{
			if (x == 20)
			{
			continue;	
			}
			
			System.out.println(x);
			System.out.println("\n");
		}
	}	
}
