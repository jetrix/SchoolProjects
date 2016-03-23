// The "Moon" class.
import java.awt.*;
import hsa.Console;

public class Moon
{
    static Console c;           // The output console
    static Console f;
    public static void main (String [] args)
    {
	c = new Console ();

	moon (160, 240, 100, Color.red);
	moon (320, 240, 50, Color.green);
	moon (480, 240,2300, Color.blue);
	for(int i=1;i<=100000000;i++);
	c.clear();

	// Place your program here.  'c' is the output console
    } // main method


    static public void moon (int xc, int yc, int size, Color clr)
    {
	for (int angle = 0 ; angle <= 360 ; angle += 10)
	    tiltSquare (xc, yc, size, angle, clr);
    }


    static public void tiltSquare (int x1, int y1, int size, int angle, Color clr)
    {
	double rAngle = angle * Math.PI / 180;
	final int A = (int) Math.round (size * Math.cos (rAngle));
	final int B = (int) Math.round (size * Math.sin (rAngle));
	final int C = (int) Math.round (size * Math.sqrt (2) * Math.cos ((Math.PI / 4) + rAngle));
	final int D = (int) Math.round (size * Math.sqrt (2) * Math.sin ((Math.PI / 4) + rAngle));

	int x2 = x1 + A;
	int y2 = y1 - B;
	int x3 = x1 + C;
	int y3 = y1 - D;
	int x4 = x1 - B;
	int y4 = y1 - A;

	c.setColor (clr);
	c.drawLine (x1, y1, x2, y2);
	c.drawLine (x2, y2, x3, y3);
	c.drawLine (x3, y3, x4, y4);
	c.drawLine (x4, y4, x1, y1);

    }
} // Moon class
