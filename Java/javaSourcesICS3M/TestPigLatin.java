// The "TestPigLatin" class.
import java.util.*;
public class TestPigLatin
{
    public static void main (String [] args)
    {
	String word = ReadLib.readString ();
	StringTokenizer st = new StringTokenizer (word);
	while (st.hasMoreTokens ())
	{
	    System.out.print (StringLibrary.pigLatinWord (st.nextToken ())+ " ");
	}
	// Place your code here
    } // main method
} // TestPigLatin class

