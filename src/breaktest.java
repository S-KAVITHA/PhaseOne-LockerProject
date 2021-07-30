
public class breaktest
{
	public static void main(String[] args)
	{
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
