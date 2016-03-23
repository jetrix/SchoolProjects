// The "StringLibrary" class.
public class StringLibrary
{

    public static String pigLatinWord (String word)
    {
	String pigWord = "";
	char letter = word.charAt (0);
	word = word.toLowerCase ();

	if (word.length () == 1)
	{
	    pigWord = word;
	}
	else if (word.charAt (0) == 'q' && word.charAt (1) == 'u')
	{
	    pigWord = word.substring (2) + "quay";
	}
	else if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u')
	{
	    pigWord = word + "way";
	}
	else
	{
	    pigWord = word.substring (1) + word.substring (0, 1) + "ay";
	}
	return pigWord;

    }
} // StringLibrary class
