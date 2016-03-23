// The "UrlSearch" class.
// Written by Jezreel N. and Godric
import java.io.*;
import java.util.*;
public class UrlSearch
{
    public static void main (String [] args) throws IOException

    {
	int tempMatch;

	String url [] = new String [25];
	int urlMatch [] = new int [25];
	String description;

	BufferedReader urlList = new BufferedReader (new FileReader ("repository.txt"));
	String searchWord = ReadLib.readString ();
	StringTokenizer searchWrd;
	StringTokenizer tokenDescription;
	int i = 0;

	while (urlList.readLine () == null)
	    {
		i++;
		tempMatch = 0;
		urlList.readLine ();
		String tempUrl = urlList.readLine ();
		description = urlList.readLine ();
		searchWrd = new StringTokenizer (searchWord);

		while (searchWrd.hasMoreTokens ())
		{
		    String currentWord = searchWrd.nextToken ();

		    if (currentWord.compareTo (description) == 0)
		    {
			System.out.println ("");
		    }
		    else
		    {
			tempMatch++;
			urlMatch [i] = tempMatch;
			System.out.println(tempUrl);
		    }

		}




	    }





    } // main method
} // UrlSearch class

