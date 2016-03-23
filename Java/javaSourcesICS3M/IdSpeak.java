// The "IdSpeak" class.

// This is the library class for Idspeak
import java.util.*;
public class IdSpeak
{
    public static void main (String [] args)
    {
	String wordHandle, word = "";
	StringTokenizer token;
	String sentence = "";
	while (sentence != "quit")
	{
	    sentence = ReadLib.readString ();
	    token = new StringTokenizer (sentence);
	    while (token.hasMoreTokens ())
	    {
		boolean done = false;
		while (!done)
		{
		    wordHandle = token.nextToken ();
		    word = checkWordLength (wordHandle);

		    word = checkEnding (word);
		    word = checkBeginning (word);
		    System.out.print (word + " ");
		    done = true;
		}

	    }
	}

    }


    public static String checkWordLength (String word)
    {
	if (word.length () == 4) //if the length of the word is 4
	    return "FRED"; //return the word FRED
	else //anything else
	    return word; // return the value of of word
    }


    public static String checkEnding (String word)
    {
	if (word.equals ("FRED")) //if the word equals to FRED
	    return "FRED"; // return the word FRED
	else if (word.endsWith ("ED")) //If the word ends with "ED"
	    return word.substring (0, word.length () - 2) + "ID"; //return the original word without the ED then add ID
	else //anything else
	    return word; // return the original word
    }


    public static String checkBeginning (String word)
    {
	int length = word.length () - 1; //declare length as integer and equal to the length of the word
	String wordBack = ""; //declare wordBack as string and have no string value
	if (word.startsWith ("DI")) //if the word starts with DI
	{
	    while (length != -1) //do while length not equal to 1
	    {
		wordBack += word.charAt (length); //let wordBack equal to itself plus the character of the word starting from last
		length = length - 1; //length equal to length minus 1
	    }
	    return wordBack; //return the value of wordBack
	}
	else //anything else
	    return word; //return the original word
    }
} // IdSpeak class


