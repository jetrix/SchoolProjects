// The "March31" class.
public class March31
{
    public static void main (String [] args)
    {
	//
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	String oldWord, str;
	String newWord = new String ("");
	char temp;
	int index;

	System.out.println ("Please enter text to encrypt");
	oldWord = ReadLib.readString ();

	//
	oldWord = oldWord.toLowerCase();
	oldWord = oldWord.trim ();

	//
	for (int i = 0 ; i < oldWord.length () ; i++)

	    {
		//
		temp = oldWord.charAt(i);

		index = alpha.indexOf (temp);
		//
		if (index == -1)
		{
		    System.out.println ("Invalid entry, ");
		    break;
		}
		index += 6;
		index = index % alpha.length ();

		str = alpha.valueOf (index);
		newWord += str;
	    }
	    System.out.println(newWord);

	    } // main method
    } // March31 class



