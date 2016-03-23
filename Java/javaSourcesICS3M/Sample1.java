// The "Sample1" class.
public class Sample1
{
    public static void main (String [] args)
    {

	double number = 0, topNumber = 0;
	long r = 1;
	int i;
	int w = 0;
	System.out.println ("Give me a number");
	number = ReadLib.readInt();
	
	topNumber= Math.pow(2.0,10.0);
	System.out.println ("The largest number is " + topNumber) ;
	    for (i = 1 ; i <= number ; i++)
	{
	    r = r + Math.pow(r,2.0);
	    System.out.println (r);
	    if (r >= topNumber)
		break;
	}
	// Place your code here
    } // main method
} // Sample1 class
