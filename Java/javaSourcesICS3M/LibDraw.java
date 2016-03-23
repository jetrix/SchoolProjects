// The "LibDraw" class.
//By Jezreel and Godric
//32703
//Creates a picture using ICS3M1Library
import java.awt.*;
import hsa.Console;
import java.util.*;

public class LibDraw
{
    static Console c;           // The output console

    public static void main (String [] args)
    {
	c = new Console (); //creates new console and sets to c

	c.setColor (Color.blue);
	c.fillRect (0, 0, 640, 420);
	for (int v = 0 ; v <= 200 ; v += 3)
	{
	    c.setColor (Color.cyan);
	    c.fillRect (0, v, 640, 1);
	}
	//creates a sky with blue color 
	
	c.setColor (Color.green.darker ());
	c.fillRect (0, 400, 640, 250);
	//creates grass
	
	ICS3M1Library.house (c, 210, - 100);
	ICS3M1Library.house (c, 410, - 100);
	ICS3M1Library.house (c, 70, - 50);
	ICS3M1Library.house (c, 210, - 50);
	ICS3M1Library.house (c, 410, - 50);
	ICS3M1Library.house (c, 70, 0);
	ICS3M1Library.house (c, 210, 0);
	ICS3M1Library.house (c, 410, 0);
	ICS3M1Library.house (c, 530, 0);
	//This calls the house method in the library and places them on the screen

	for (int i = 0 ; i <= 590 ; i += 30)
	{
	    ICS3M1Library.flowers (c, i, c.maxy () - 70);
	} // This creates a series of flowers by calling ICS3M1Library.flowers methods in the library multiple times and
	//increasing the x value


	ICS3M1Library.drawElephant (c, 0, c.maxy () - 170); //calls the ICS3M1Library.drawElephant to draw the elephant
	ICS3M1Library.sunny (c, c.maxx () - 100, 5); //calls ICS3M1Library.sunny method to draw the sun
	ICS3M1Library.drawBobomb (c, 383, c.maxx () - 48); //calls ICS3M1Library.drawBobomb to draw the bomb images


	// Place your program here.  'c' is the output console
    } // main method
} // LibDraw class
