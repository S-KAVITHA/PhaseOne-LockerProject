
public class typecast
{
	public static void main(String[] args)
	{
		double d =1000.4 ; 
		long l = (long)d ; 
		int i = (int)l ; 
		short s= (short)i ; 
		byte b = (byte)s ;
	
		System.out.println("Double value " +d);
		System.out.println("Long value " +l);
		System.out.println("Int value " +i);
		System.out.println("Short value " +s);
		System.out.println("Byte value " +b);
	}

}
