// The "StringBack" class.
import java.io.*;
public class StringBack
{
    public static void main (String [] args) throws IOException
    {
	BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
	String string = in.readLine ();
	int length = string.length ()-1;
      
	while(length!=-1)
	{
	    System.out.print (string.charAt (length));
	    length=length - 1;
	}


	// Place your code here
    } // main method
} // StringBack class
