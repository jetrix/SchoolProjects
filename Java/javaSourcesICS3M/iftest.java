//if test
public class iftest
{
    public static void main (String [] args)
    {
	int NumOfEnemies;
	NumOfEnemies = ReadLib.readInt ();
	if (NumOfEnemies == 1)
	    System.out.println ("Enemy visible,Attack!!");
	else if (NumOfEnemies > 1)
	    System.out.println ("We're under attack! Flee!!");
	else
	{
	    System.out.println ("Stop shooting");
	    System.out.println ("Keep minding my own busisnes");
	}

    }
}
