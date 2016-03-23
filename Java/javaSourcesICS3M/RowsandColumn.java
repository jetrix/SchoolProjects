// The "RowsandColumn" class.
public class RowsandColumn
{
    public static void main (String [] args)
    {
	a ();
	b ();
	c ();
    } // main method


    public static void a ()
    {

	int line = 10;
	for (int row = 1 ; row <= 10 ; row++)
	{
	    for (int d = 1 ; d <= line ; d++)
	    {
		System.out.print ("$");
	    }
	    System.out.println ();
	    line--;
	}
    }


    public static void b ()
    {
	int line = 1;
	for (int row = 1 ; row <= 10 ; row++)
	{
	    for (int d = 1 ; d <= line ; d++)
	    {
		System.out.print ("$");
	    }
	    System.out.println ();
	    line++;
	}

    }


    public static void c ()
    {
	int line = 9;

	for (int row = 1 ; row <= 10 ; row++)
	{
	    for (int d = 1 ; d <= 10 ; d++)
	    {
		if (d<10)
		System.out.print ("$");
		else
		System.out.print (" ");
	    }
	    
		 System.out.println ();

       
	}

    }





}
