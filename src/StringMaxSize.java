

    import java.util.Arrays;  
public class StringMaxSize   
{  
    public static void main(String args[])   
    {  
    	for (int i = 0; i < 1000; i++)   
    	{  
    		try   
    		{  
  
    			char[] array = new char[Integer.MAX_VALUE - i];  
   
    			Arrays.fill(array, 'a');  
    
    			String str = new String(array);  
  
    			System.out.println(str.length());  
    		}   
    		catch (Throwable e)   
    		{  
     
    			System.out.println(e.getMessage());  
   
    			System.out.println("Last: " + (Integer.MAX_VALUE - i));  
    			System.out.println("Last: " + i);  
    		}  
    	}  
    } 
}