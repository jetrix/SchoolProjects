// The "ConsoleAnim" class.
import java.awt.*;
import hsa.Console;

public class ConsoleAnim
{
    static Console c;           // The output console

    public static void main (String [] args)
    {
	c = new Console ();
	int col = 0;
	int row = 0;
	do
	{
	    row += 30;
	    do
	    {

		c.setColor (Color.yellow);
		c.fillRect (col, row, 30, 30);
		col += 30;
		c.setColor (Color.blue);
		c.fillRect (col, 0, 30, 30);
		col += 30;
	    }
	    while (col < 600);

	    col = 0;
	    row = 0;
	    row += 30;
	    do
	    {

		c.setColor (Color.green);
		c.fillRect (col, row, 30, 30);
		col += 30;
		c.setColor (Color.red);
		c.fillRect (col, row, 30, 30);
		col += 30;
	    }
	    while (col < 600);

	}while (row <60);
	// Place your program here.  'c' is the output console
    } // main method
} // ConsoleAnim class
