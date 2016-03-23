// The "Test3" class written by Jezreel N.
// 50803
// This program reads a line from a file and process them
import java.io.*;
import java.util.*;
public class Test3
{
    public static void main (String [] args) throws IOException
    {
	int startM = 0; //declare startM as integer and equal to 0 
	int endM = 0; //declare endM as integer and equal to 0 
	double letters = 0; //declare letters as double and equal to 0 
	String names [] = new String [8]; //declare startM as a String array of 8

	//This creates a file reader called file and reads the classmates.txt
	BufferedReader file = new BufferedReader (new FileReader ("classmates.txt"));
	String oneLine = file.readLine (); // This creates a string variable and reads a line from the file handler
	file.close (); //Closes the file

	// Creates a StringTokenizer called token which tokenizes the variable onLine
	StringTokenizer token = new StringTokenizer (oneLine);

	//This created a for loop starting from 0 to the length of the array
	for (int i = 0 ; i < names.length ; i++)
	{
	    names [i] = token.nextToken ();
	    // The names array of the current index is equal to the current token being read
	}


	//This created a for loop starting from 0 to the length of the array
	for (int i = 0 ; i < names.length ; i++)
	{
	    // The names array of the current index is equal to its own value but in uppercase
	    names [i] = names [i].toUpperCase ();
	}

	//This created a for loop starting from 0 to the length of the array
	for (int i = 0 ; i < names.length ; i++)
	{
	    if (names [i].startsWith ("M")) //If the array names of the current index starts with "M"
		startM++; //increment the value of startM

	    if (names [i].endsWith ("M")) //If the array names of the current index ends with "M"
		endM++; //increment the value of endM

	    letters += names [i].length ();
	    // The variable letters is equal itself plus to the length of the current index array , names

	}
	
	
	// This part of the program prints the result to the screen
	System.out.println ("Names in capital letters: "); 
	for (int i = 0 ; i < names.length ; i++) //A for loop starting from 0 to the length of the array
	    System.out.print (names [i] + " "); // Print the array
	System.out.println ();
	System.out.println ("Number of names that begin with 'M': " + startM); //Print the number of letters that starts with M
	System.out.println ("Number of names that end with 'M': " + endM);//Print the number of letters that ends with M
	System.out.println("Average number of letters per name : " +letters/names.length); //Print the average of the letters per name in the array






    } // main method
} // Test3 class
