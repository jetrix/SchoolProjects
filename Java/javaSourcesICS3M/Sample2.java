// The "Sample2" class.
public class Sample2
{
    public static void main (String [] args)
    {
	int i;
	System.out.println ("What is your favorite number unde 10?");
	int number = ReadLib.readInt ();
	System.out.println ("What is your favorite number under 100?");
	int topNumber = ReadLib.readInt ();

	System.out.println ("Here it is...");
	for (i = 0 ; i <= number ; i++)
	{
	    int j = (int) Math.random () * topNumber;
	     System.out.println (j);
	}
    } // main method
} // Sample2 class
