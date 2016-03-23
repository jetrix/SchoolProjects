import java.io.*;

// The "WhileFromaFile" class.
public class WhileFromaFile
{
    public static void main (String [] args)throws IOException
    {
	String fileName, line;
	int number;
	int sum = 0, count = 0;

	System.out.println ("What is the name of the file of integers");
	fileName = ReadLib.readString ();
	BufferedReader input;
	input = new BufferedReader (new FileReader (fileName));
	line = input.readLine ();
	//keep reading the file as long as non empty line are read

	while (line != null)
	{
	    number = Integer.parseInt (line);

	    //increase count by 1
	    count++;

	    //add number to existing sum
	    sum += number;

	    line = input.readLine ();

	}
	System.out.println ("Average of " + count + " numbers is " + (double) sum / count);

    } // main method
} // WhileFromaFile class
