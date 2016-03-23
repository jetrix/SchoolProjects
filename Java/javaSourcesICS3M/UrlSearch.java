// The "UrlSearch" class.
// Written by Jezreel N. and Godric
import java.io.*;
import java.util.*;
public class UrlSearch
{

    public static void main (String [] args) throws IOException
    {
	int tempMatch = 0;

	String url [] = new String [25];
	int urlMatch [] = new int [25];
	String description;
	String tempUrl;
	int counter = -1;
	BufferedReader urlList = new BufferedReader (new FileReader ("repository.txt"));
	String searchWord = ReadLib.readString ();
	StringTokenizer tokenDescription;


	String currentWord = searchWord.toLowerCase();
	int array = Integer.parseInt (urlList.readLine ());
	for (int i = 0 ; i < array ; i++)
	{
	    counter++;
	    urlList.readLine ();
	    tempUrl = urlList.readLine ();
	    description = urlList.readLine ();
	    if (description == null)
		break;
	    tokenDescription = new StringTokenizer (description.toLowerCase (), " ,;:()-._");
	    while (tokenDescription.hasMoreTokens ())
	    {
		String tempWord = tokenDescription.nextToken ();
		if (currentWord.equals (tempWord))
		{
		    tempMatch++;
		    url [counter] = tempUrl;
		    urlMatch [counter] = tempMatch;
		}
	    }
	    tempMatch = 0;
	}

	System.out.println ("Websites found :");
	for (int i = 0 ; i < array ; i++)
	{
	    if (url [i] != null)
	    {
		System.out.print (url [i]);
		System.out.println (" Matches found:" + urlMatch [i]);
	    }

	} // main method
    } // UrlSearch class
}
