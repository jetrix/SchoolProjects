// The "ICS3M1Library" class contins drawing methods from all class members
// March 2003

import java.awt.*;
import hsa.Console;

public class ICS3M1Library
{
    // Alex and Jack
    public static void drawBobomb (Console c, int row, int col)
    {
	c.setColor (Color.black);
	c.fillOval (col, row, 50, 50);

	c.setColor (Color.white);
	c.fillOval (col + 5, row + 12, 9, 14);
	c.fillOval (col + 15, row + 10, 9, 15);

	Color brown = new Color (139, 69, 19);
	c.setColor (brown);
	c.fillOval (col + 5, row + 45, 22, 12); // Left Foot
	c.setColor (Color.black);
	c.drawOval (col + 5, row + 45, 22, 12); //outline of left
	c.setColor (brown);
	c.fillOval (col + 18, row + 45, 22, 12); //Right Foot
	c.setColor (Color.black);
	c.drawOval (col + 18, row + 45, 22, 12); //outline of right

	c.fillRect (col + 18, row - 5, 14, 10);
	c.drawLine (col + 25, row - 5, col + 45, row - 15);
	moon (c, col + 45, row - 15, row, Color.red);


    }


    // David and Giancarlo
    public static void drawElephant (Console c, int x, int y)
    {


	//This draws the body of the elephant
	c.setColor (Color.gray);
	c.fillOval (x, y, 190, 140);
	c.setColor (Color.gray);
	c.fillOval (x + 130, y - 20, 100, 110);

	//Draws the eye
	c.setColor (Color.white);
	c.fillOval (x + 190, y, 15, 15);
	c.setColor (Color.black);
	c.fillOval (x + 194, y + 2, 10, 10);

	//This draws the legs
	c.setColor (Color.gray);
	c.fillRect (x + 20, y + 90, 50, 80);
	c.setColor (Color.gray);
	c.fillRect (x + 130, y + 90, 50, 80);

	//This draws the tail
	c.setColor (Color.gray);
	c.fillOval (x + 0, y + 60, 5, 50);

	//This draws the trunk
	c.setColor (Color.gray);
	c.fillRect (x + 195, y + 30, 100, 25);

	//This draws the mouth
	c.setColor (Color.white);
	c.fillOval (x + 200, y + 60, 20, 30);

	//This draws the ear
	c.setColor (Color.black);
	c.drawOval (x + 150, y + 10, 30, 50);
	c.setColor (Color.gray);
	c.fillOval (x + 155, y + 5, 20, 20);

	//Draws the water comming out of the trunk
	c.setColor (Color.blue);
	c.fillOval (x + 293, y + 30, 800, 20);

    }


    // Ian & Michel
    public static void drawMan (Console c, int xc, int yc, int height, int width)
    {
	c.setColor (Color.orange);
	c.fillOval (xc, yc, height, width);
	c.setColor (Color.yellow);
	c.fillOval (xc + 10, yc + 30, height - 70, width - 70);
	c.setColor (Color.yellow);
	c.fillOval (xc + 55, yc + 30, height - 70, width - 70);
	//Head
	c.setColor (Color.red);
	c.fillOval (xc, yc + 95, width, height + 50);
	c.setColor (Color.black);
	c.fillRect (xc + 5, yc + 230, width - 90, height + 10);
	c.setColor (Color.black);
	c.fillRect (xc + 85, yc + 230, width - 90, height + 10);
	c.setColor (Color.black);
	c.fillRect (xc - 80, yc + 130, width - 10, height - 90);
	c.setColor (Color.black);
	c.fillRect (xc + 90, yc + 130, width - 10, height - 90);
	c.setColor (Color.red);
	c.fillRect (xc + 25, yc - 50, width - 50, height - 50);
	c.setColor (Color.red);
	c.fillRect (xc + 5, yc, width - 10, height - 90);
	c.setColor (Color.black);
	c.fillRect (xc + 5, yc + 225, width - 10, height - 90);

	c.setColor (Color.black);
	c.fillOval (xc + 45, yc + 125, height - 90, width - 90);
	c.setColor (Color.black);
	c.fillOval (xc + 45, yc + 150, height - 90, width - 90);
	c.setColor (Color.black);
	c.fillOval (xc + 45, yc + 175, height - 90, width - 90);
    }


    // Emmanual & Oscar
    public static void bubble (Console c, int x, int y)
    {

	c.setColor (Color.blue);
	c.fillRect (100, 300, 350, 40);
	c.fillRect (230, 250, 150, 100);
	c.setColor (Color.gray);
	c.fillRect (80, 340, 400, 20);
	c.setColor (Color.yellow);
	c.fillRect (100, 295, 15, 45);
	c.setColor (Color.black);
	c.fillOval (140, 320, 65, 65);
	c.setColor (Color.black);
	c.fillOval (350, 320, 65, 65);
	c.setColor (Color.orange);
	c.fillOval (150, 330, 45, 45);
	c.setColor (Color.orange);
	c.fillOval (360, 330, 45, 45);

	c.setColor (Color.gray);
	c.fillRect (250, 260, 100, 40);


    }


    // Mathew & Michael
    static public void radio1 (Console c, int x, int y, int length, int width, Color clr)
    {
	c.setColor (Color.black);
	c.fillRect (x, y, length, width);
	c.setColor (Color.gray);
	c.fillOval (x + 5, y + 5, length - 130, width - 10);
	c.fillOval (x + 125, y + 5, length - 130, width + 10);
	c.setColor (Color.white);
	c.fillRect (x + 80, y + 40, length - 160, width - 60);
	c.fillRect (x + 83, y + 10, length - 170, width - 75);
	c.setColor (Color.black);
	c.fillRect (x + 50, y - 36, length - 180, width - 40);
	c.fillRect (x + 60, y - 36, length - 140, width - 60);
	c.fillRect (x + 120, y - 36, length - 180, width - 40);




    }


    // Tareq and
    static public void house (Console c, int xc, int yc)
    {

	int height = 50;
	int width = 50;
	int x1 = 61;
	int x2 = 61;
	int y1 = 10;
	int y2 = 10;

	c.fillRect (xc - 40, yc + 300, width, height);
	c.setColor (Color.black);
	c.fillRect (xc + 40, yc + 180, width, height);
	c.fillRect (xc - 40, yc + 180, width, height);
	c.fillRect (xc - 82, yc + 180, width + 175, height + 150);
	c.setColor (Color.green);
	c.fillRect (xc - 82, yc + 360, width + 175, height);
	c.setColor (Color.cyan);
	c.fillOval (xc - 60, yc + 180, width, height);
	c.fillOval (xc + 60, yc + 180, width, height);
	c.setColor (Color.red);
	c.fillRect (xc, yc + 300, width, height + 10);
    }


    // Irum, Elwira & Jacqueline
    public static void flowers (Console c, int x, int y)
    {

	moon (c, x, y, 10, Color.blue);
	moon (c, x + 50, y - 40, 10, Color.magenta);
	moon (c, x + 100, y - 20, 10, Color.cyan);

	//stem 1
	c.setColor (Color.green);
	c.fillRect (x, y + 10, 2, 70);

	//leaf 1
	c.setColor (Color.green);
	c.fillOval (x, y + 25, 25, 10);

	//stem 2
	c.setColor (Color.green);
	c.fillRect (x + 50, y - 30, 2, 100);

	//leaf 2
	c.setColor (Color.green);
	c.fillOval (x + 50, y - 10, 25, 10);

	//leaf 3
	c.setColor (Color.green);
	c.fillOval (x + 27, y + 10, 25, 10);

	//stem 3

	c.setColor (Color.green);
	c.fillRect (x + 100, y - 10, 2, 70);

	//leaf 4
	c.setColor (Color.green);
	c.fillOval (x + 100, y + 5, 25, 10);
    }


    // The "ThreeEyedFish" class. By: Michael Liang and Vince Nguyen
    static public void Threeeyedfish (Console c, int x, int y)
    {

	c.setColor (Color.orange);
	Body (c, x, y, 170, 100, Color.orange);
	Fins (c, x + 140, y + 25, x + 140, y + 65, 55);
	c.setColor (Color.white);
	Whiteeyes (c, x - 10, y + 20, 40, 35, Color.white);
	Whiteeyes (c, x + 30, y + 20, 40, 35, Color.white);
	Whiteeyes (c, x + 70, y + 20, 40, 35, Color.white);
	c.setColor (Color.black);
	Eyes (c, x, y + 28, 15, 15, Color.black);
	Eyes (c, x + 80, y + 28, 15, 15, Color.black);
	Eyes (c, x + 39, y + 28, 15, 15, Color.black);
	Eyeoutline (c, x - 10, y + 20, 40, 35, Color.black);
	Eyeoutline (c, x + 30, y + 20, 40, 35, Color.black);
	Eyeoutline (c, x + 70, y + 20, 40, 35, Color.black);
	Mouth (c, x + 25, y + 70, 60, 5, Color.black);

    }


    // by Sean and Adriel
    public static void sunny (Console c, int col, int row)

    {

	moon (c, col + 42, row + 42, 30, Color.yellow);
	c.setColor (Color.orange);
	c.fillOval (col + 12, row + 12, 59, 59);
	//this is the frame for the glasses
	c.setColor (Color.black);
	c.fillRect (col + 36, row + 32, 10, 2);
	//.these are the lens for the sunglasses
	c.setColor (Color.black);
	c.fillRect (col + 16, row + 28, 20, 10);
	c.setColor (Color.black);
	c.fillRect (col + 46, row + 28, 20, 10);



    } // main method


    // by Carly and Larah
    public static void drawFlower (Console c, int x, int y)
    {
	c.setColor (Color.green);
	c.fillRect (x + 109, y + 120, 5, 50);

	c.setColor (Color.yellow);
	c.fillOval (x + 100, y + 100, 20, 20);

	c.setColor (Color.red);
	c.fillOval (x + 85, y + 90, 20, 20);

	c.setColor (Color.red);
	c.fillOval (x + 100, y + 80, 20, 20);

	c.setColor (Color.red);
	c.fillOval (x + 84, y + 110, 20, 20);

	c.setColor (Color.red);
	c.fillOval (x + 100, y + 120, 20, 20);

	c.setColor (Color.red);
	c.fillOval (x + 117, y + 110, 20, 20);

	c.setColor (Color.red);
	c.fillOval (x + 116, y + 90, 20, 20);

    }


    // part of ThreeEyedFish
    static public void Eyes (Console c, int x, int y, int width, int height, Color clr)
    {
	c.fillOval (x, y, width, height);

    }


    // part of ThreeEyedFish
    static public void Whiteeyes (Console c, int x, int y, int width, int height, Color clr)
    {
	c.fillOval (x, y, width, height);
    }


    // part of ThreeEyedFish
    static public void Body (Console c, int x, int y, int width, int height, Color clr)
    {
	c.fillOval (x, y, width, height);
    }


    // part of ThreeEyedFish
    static public void Eyeoutline (Console c, int x, int y, int width, int height, Color clr)
    {
	c.drawOval (x, y, width, height);
    }


    // part of ThreeEyedFish
    static public void Mouth (Console c, int x, int y, int width, int height, Color clr)
    {
	c.fillOval (x, y, width, height);
    }


    // part of ThreeEyedFish
    static public void Fins (Console c, int x1, int y1, int x2, int y2, int length)
    {

	for (int i = 0 ; i < length ; i++)
	{
	    c.drawLine (x1, y1, x2, y2);
	    x1++;
	    x2++;
	    y1--;
	    y2++;
	}
    }


    static public void moon (Console c, int xc, int yc, int size, Color clr)
    {
	for (int angle = 0 ; angle <= 350 ; angle = angle + 10)
	{
	    tiltSquare (c, xc, yc, 5, angle, clr);
	}

    } // Moon class


    static public void tiltSquare (Console c, int x1, int y1, int size, int angle, Color clr)
    {
	double rAngle = angle * Math.PI / 180;
	final int A = (int) Math.round (size * Math.cos (rAngle));
	final int B = (int) Math.round (size * Math.cos (rAngle));
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
	c.setColor (Color.orange);
	c.drawLine (x2, y2, x3, y3);
	c.setColor (Color.red);
	c.drawLine (x3, y3, x4, y4);
	c.setColor (Color.orange);
	c.drawLine (x4, y4, x1, y1);
    }
} // ICS3M1Library class
