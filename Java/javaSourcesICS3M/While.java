// The "While" class.
public class While
{
    public static void main (String [] args)
    {
	String psswd = "mypassword";
	String line = "";
	//Ask for a password
       


	//Keep asking for a password as long as the line
	//the line typed in not matched
	do
	{
	    System.out.println ("Enter your password");
	    line = ReadLib.readString ();
	}while (line.equals (psswd));

	System.out.println ("Password found match");

    } // main method
} // While class
