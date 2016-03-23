// The "TestData" class.
import java.util.*;
public class TestData
{
    public static void main (String [] args)
    {
	Data.init ();

	for (int i = 0 ; i < 34 ; i++)
	{

	    System.out.println ("Name: " + Data.getPropertyName (i));
	    System.out.println ("Cost: $" + Data.getPropertyValue ("Cost", i));
	    System.out.println ("House1: $" + Data.getPropertyValue ("House1", i));
	    System.out.println ("House2: $"+ Data.getPropertyValue ("House2", i));
	    System.out.println ("House3: $"+ Data.getPropertyValue ("House3", i));
	    System.out.println ("House4: $"+ Data.getPropertyValue ("House4", i));
	    System.out.println ("Motel: $"+ Data.getPropertyValue ("Motel", i));
	    System.out.println ("Mortgage: $"+ Data.getPropertyValue ("Mortgage", i));
	    System.out.println ();
	}



    } // main method
} // TestData class
