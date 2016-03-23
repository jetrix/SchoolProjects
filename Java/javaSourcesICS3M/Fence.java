// The "Fence" class.
//
import java.awt.*;
import java.util.*;
import hsa.Console;

public class Fence
{
    static Console c;           // The output console

    public static void main (String [] args)
    {
	c = new Console ();
	makeFence (c, 0, 300, Color.black);



	// Place your program here.  'c' is the output console
    } // main method



    public static void makeFence (Console c, int x, int y, Color clr)
    {
	c.setColor (Color.blue.brighter ());
	c.fillRect (0, 0, c.maxx (), c.maxy ());


	for (int i = 0 ; i <= 200 ; i++)
	    for (int grass = 0 ; grass <= c.maxy () ; grass += 5)
	    {
		c.setColor (Color.green);
		c.fillRect ((int) (Math.random () * (x + c.maxx ())) + x, 90 + y + grass, 2, 20);
		c.setColor (Color.green.darker ());
		c.fillRect ((int) (Math.random () * (x + c.maxx ())) + x, 95 + y + grass, 2, 15);
		c.setColor (Color.green);
		c.fillRect ((int) (Math.random () * (x + c.maxx ())) + x, 90 + y + grass, 3, 10);
		c.setColor (Color.green.darker ());
		c.fillRect ((int) (Math.random () * (x + c.maxx ())) + x, 85 + y + grass, 2, 14);

	    }

	c.setColor (clr);
	for (int j = 0 ; j <= 7 ; j++)
	{
	    c.fillRect (x + (c.maxx () / 6) * j, y, 15, 15 * 5);
	}
	c.fillRect (x, y + 15, c.maxx (), 15);
	c.fillRect (x, y + (15 * 3), c.maxx (), 15);
	c.fillRect (x, y + (15 * 5), c.maxx (), 15);

	for (int h = 0 ; h <= 5 ; h++)
	    for (int i = 0 ; i <= 100 ; i++)

		{
		    c.setColor (Color.green);
		    c.fillRect ((int) (Math.random () * (x + c.maxx ())) + x, 90 + y, 2, 20);
		    c.setColor (Color.green.darker ());
		    c.fillRect ((int) (Math.random () * (x + c.maxx ())) + x, 95 + y, 2, 15);
		    c.setColor (Color.green);
		    c.fillRect ((int) (Math.random () * (x + c.maxx ())) + x, 90 + y, 3, 10);
		    c.setColor (Color.green.darker ());
		    c.fillRect ((int) (Math.random () * (x + c.maxx ())) + x, 85 + y, 2, 14);

		}
    }
}
// test class
