// The "ReadInt" class.

import java.io.*;
public class ReadInt
{
    public static void main (String [] args) throws IOException
    {
	String fileName, line;
	int number;
	System.out.println ("What is the name of the file in integers?");
	fileName = ReadLib.readString ();
	BufferedReader input;

	// Create a connection between file and program
	input = new BufferedReader (new FileReader (fileName));

	//Read line from 0the file
	line = input.readLine ();

	// Find an integer in the line from the file
	number = Integer.parseInt (line);
	System.out.println ("The integer read was " + number);
    } // main method
} // ReadInt class
