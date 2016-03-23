/* The average grade calculator
   written by Jez. N
   21303
   Finds the total average of the marks 
*/
public class Grade
{

    public static void main (String args [])
    {
	// declares variables as integers
	int m, c, s, e, average;
	// This part of the code prompts the user and
	// reads the input and stores it into a variable
	System.out.println ("Enter your grade for math ");
	m = ReadLib.readInt ();
	System.out.println ("Enter your grade for chemistry ");
	c = ReadLib.readInt ();
	System.out.println ("Enter your grade for computer science ");
	s = ReadLib.readInt ();
	System.out.println ("Enter your grade for english ");
	e = ReadLib.readInt ();
	// adds the variable and divides by 4 and puts it into average
	average = (m + c + s + e) / 4;
	// displays the results in the screen
	System.out.println ("The average is " + average);

    }
}
