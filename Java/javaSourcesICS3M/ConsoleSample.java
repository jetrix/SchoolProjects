// The "ConsoleSample" class.
import java.awt.*;
import hsa.Console;

public class ConsoleSample
{
    static Console c;           // The output console

    public static void main (String [] args)
    {
	int inc = 0;
	c = new Console ();
	c.setColor (Color.blue);
	do
	{
	    inc++;
	   
	    c.fillRect (0, 0, inc, inc);
	}
	while (inc <= 700);
	inc = 1;
	c.setColor (Color.green);
	do
	{
	    inc++;
	    
	    c.fillRect (0, 0, inc, inc);
	}
	while (inc <= 600);
	inc = 1;
	c.setColor (Color.red);
	do
	{
	    inc++;
	    
	    c.fillRect (0, 0, inc, inc);
	}
	while (inc <= 500);
	inc = 1;
	c.setColor (Color.yellow);
	do
	{
	    inc++;
	    
	    c.fillRect (0, 0, inc, inc);
	}
	while (inc <= 400);
	// Place your program here.  'c' is the output console
    } // main method
} // ConsoleSample class
