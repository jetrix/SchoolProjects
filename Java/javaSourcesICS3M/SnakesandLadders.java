// The "SnakesandLadders" class.
public class SnakesandLadders
{
    public static void main (String [] args)
    {

	int position = 1;
	int dice;

	while (true)
	{
	    System.out.println ("Enter a number (2-12)");
	    dice = ReadLib.readInt ();

	    position += dice;

	    if (position == 9)
		position = 34;

	    if (position == 54)
		position = 19;

	    if (position == 40)
		position = 65;

	    if (position == 67)
		position = 86;

	    if (position == 90)
		position = 48;

	    if (position == 99)
		position = 77;

	    if (position == 100)
	    {
		System.out.println ("You win!!!!");
		break;
	    }

	    if (dice == 0)
	    {
		System.out.println ("You quited!");
		break;
	    }


	    if (dice < 2 || dice > 12)
		System.out.println ("Please enter a number between (2-12) only!");

	    System.out.println ("Current position is " + position);



	}







    } // main method
} // SnakesandLadders class
