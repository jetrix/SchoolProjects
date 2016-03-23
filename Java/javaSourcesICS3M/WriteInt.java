// The "WriteInt" class.+
import java.io.*;
public class WriteInt
{
    public static void main (String [] args) throws IOException
    {
	//Where the information will be displayed
	PrintWriter output;
	String fileName;
	int number;
	System.out.println ("What is the name of the file for integers");
	fileName = ReadLib.readString ();
	//Create the connection between the program and the file
	output = new PrintWriter (new FileWriter (fileName));

	System.out.println ("Enter an Integer");
	number = ReadLib.readInt ();
	
	//Put the integer into file
	output.println (number);
	
	//close the file
	output.close ();
    } // main method
} // WriteInt class
