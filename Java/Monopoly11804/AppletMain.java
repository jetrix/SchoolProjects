// The "AppletMain" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class AppletMain extends DBApplet implements KeyListener, MouseListener, Runnable
{
    // Place instance variables here
    Image imgTitle, imgBackground, img2p, img3p, img4p, img2ps, img3ps, img4ps, imgStart;
    Image imgBoard, imgLayout, imgBuy, imgSell, imgBhouse, imgBhotel, imgShouse, imgShotel, imgTrade, imgMort, imgRoll, imgDone, imgInfo;
    Image imgBuyd, imgSelld, imgBhoused, imgBhoteld, imgShoused, imgShoteld, imgTraded, imgMortd, imgRolld, imgDoned;
    Image [] dicePic = new Image [6];
    int x = 0, y = 0;
    int dice1 = 1, dice2 = 1, dice1X = 0, dice1Y = 0, dice2X = 0, dice2Y = 0;
    Thread thread;
    int backX = 0, backY = 0;
    boolean boolMenu = true, bool2p = false, bool3p = false, bool4p = false, boolStartVisible = false;
    boolean boolBuyd = false, boolSelld = false, boolBhoused = false, boolBhoteld = false, boolShoused = false, boolShoteld = false;
    boolean boolTraded = false, boolMortd = false, boolRolld = false, boolDoned = false;

    public void init ()
    {
	imgStart = getImage (getCodeBase (), "images/start.png");
	img2p = getImage (getCodeBase (), "images/2p.png");
	img3p = getImage (getCodeBase (), "images/3p.png");
	img4p = getImage (getCodeBase (), "images/4p.png");
	img2ps = getImage (getCodeBase (), "images/2ps.png");
	img3ps = getImage (getCodeBase (), "images/3ps.png");
	img4ps = getImage (getCodeBase (), "images/4ps.png");
	imgTitle = getImage (getCodeBase (), "images/monotitle.png");
	imgBackground = getImage (getCodeBase (), "images/boardgifbig.gif");
	imgBuy = getImage (getCodeBase (), "images/buy.png");
	imgSell = getImage (getCodeBase (), "images/sell.png");
	imgBhouse = getImage (getCodeBase (), "images/bhouse.png");
	imgBhotel = getImage (getCodeBase (), "images/bhotel.png");
	imgShouse = getImage (getCodeBase (), "images/shouse.png");
	imgShotel = getImage (getCodeBase (), "images/shotel.png");
	imgTrade = getImage (getCodeBase (), "images/trade.png");
	imgMort = getImage (getCodeBase (), "images/mort.png");
	imgRoll = getImage (getCodeBase (), "images/roll.png");
	imgDone = getImage (getCodeBase (), "images/done.png");
	imgInfo = getImage (getCodeBase (), "images/infobox.png");
	imgLayout = getImage (getCodeBase (), "images/layout.png");
	imgBoard = getImage (getCodeBase (), "images/boardgif.gif");
	imgBuyd = getImage (getCodeBase (), "images/buyd.png");
	imgSelld = getImage (getCodeBase (), "images/selld.png");
	imgBhoused = getImage (getCodeBase (), "images/bhoused.png");
	imgBhoteld = getImage (getCodeBase (), "images/bhoteld.png");
	imgShoused = getImage (getCodeBase (), "images/shoused.png");
	imgShoteld = getImage (getCodeBase (), "images/shoteld.png");
	imgTraded = getImage (getCodeBase (), "images/traded.png");
	imgMortd = getImage (getCodeBase (), "images/mortd.png");
	imgRolld = getImage (getCodeBase (), "images/rolld.png");
	imgDoned = getImage (getCodeBase (), "images/doned.png");
	dicePic [0] = getImage (getCodeBase (), "images/DICE_01.gif");
	dicePic [1] = getImage (getCodeBase (), "images/DICE_02.gif");
	dicePic [2] = getImage (getCodeBase (), "images/DICE_03.gif");
	dicePic [3] = getImage (getCodeBase (), "images/DICE_04.gif");
	dicePic [4] = getImage (getCodeBase (), "images/DICE_05.gif");
	dicePic [5] = getImage (getCodeBase (), "images/DICE_06.gif");
	addMouseListener (this);
	addKeyListener (this);
	// Place the body of the initialization method here
    } // init method


    public void paint (Graphics g)
    {
	if (boolMenu)
	{
	    g.drawImage (imgBackground, backX, backY, this);
	    g.drawImage (imgTitle, 140, 100, this);

	    if (boolStartVisible)
		g.drawImage (imgStart, 214, 420, this);

	    if (bool2p)
		g.drawImage (img2ps, 230, 200, this);
	    else
		g.drawImage (img2p, 230, 200, this);

	    if (bool3p)
		g.drawImage (img3ps, 230, 230, this);
	    else
		g.drawImage (img3p, 230, 230, this);

	    if (bool4p)
		g.drawImage (img4ps, 230, 260, this);
	    else
		g.drawImage (img4p, 230, 260, this);

	    g.drawString ("Monopoly Version 1.0", 480, 495);
	}
	else
	{
	    g.drawImage (imgLayout, 0, 0, this);
	    g.drawImage (imgBoard, 0, 0, this);
	    g.drawImage (imgBuy, 418, 10, this);
	    g.drawImage (imgSell, 418, 61, this);
	    g.drawImage (imgBhouse, 474, 11, this);
	    g.drawImage (imgBhotel, 474, 34, this);
	    g.drawImage (imgShouse, 474, 60, this);
	    g.drawImage (imgShotel, 474, 85, this);
	    g.drawImage (imgTrade, 412, 110, this);
	    g.drawImage (imgMort, 502, 111, this);
	    g.drawImage (imgRoll, 411, 147, this);

	    g.drawImage (imgInfo, 405, 217, this);
	    g.drawString ("      |-------------------------------|", 415, 240);
	    g.drawString ("      |         Creditview Rd       |", 415, 250);
	    g.drawString ("      |-------------------------------|", 415, 260);
	    g.drawString ("                                      |", 415, 270);
	    g.drawString ("                                      |", 415, 280);
	    g.drawString ("ABCDEFGHIJKLMNOPQRSTU", 415, 290);
	    g.drawString ("sdfgsd;fgkljsdf;lgkjdsfg;lkjsdfkl", 415, 300);
	    g.drawString ("sdfgsd;fgkljsdf;lgkjdsfg;lkjsdfkl", 415, 310);
	    g.drawString ("sdfgsd;fgkljsdf;lgkjdsfg;lkjsdfkl", 415, 320);
	    g.drawString ("sdfgsd;fgkljsdf;lgkjdsfg;lkjsdfkl", 415, 330);
	    g.drawString ("sdfgsd;fgkljsdf;lgkjdsfg;lkjsdfkl", 415, 340);
	    g.drawString ("sdfgsd;fgkljsdf;lgkjdsfg;lkjsdfkl", 415, 350);
	    g.drawString ("sdfgsd;fgkljsdf;lgkjdsfg;lkjsdfkl", 415, 360);
	    g.drawString ("sdfgsd;fgkljsdf;lgkjdsfg;lkjsdfkl", 415, 370);
	    g.drawString ("---------------------------------", 415, 380);


	    if (boolBuyd)
		g.drawImage (imgBuyd, 418, 10, this);
	    else
		g.drawImage (imgBuy, 418, 10, this);
	    if (boolSelld)
		g.drawImage (imgSelld, 418, 61, this);
	    else
		g.drawImage (imgSell, 418, 61, this);
	    if (boolBhoused)
		g.drawImage (imgBhoused, 474, 11, this);
	    else
		g.drawImage (imgBhouse, 474, 11, this);
	    if (boolBhoteld)
		g.drawImage (imgBhoteld, 474, 34, this);
	    else
		g.drawImage (imgBhotel, 474, 34, this);
	    if (boolShoused)
		g.drawImage (imgShoused, 474, 60, this);
	    else
		g.drawImage (imgShouse, 474, 60, this);
	    if (boolShoteld)
		g.drawImage (imgShoteld, 474, 85, this);
	    else
		g.drawImage (imgShotel, 474, 85, this);
	    if (boolTraded)
		g.drawImage (imgTraded, 412, 110, this);
	    else
		g.drawImage (imgTrade, 412, 110, this);
	    if (boolMortd)
		g.drawImage (imgMortd, 502, 111, this);
	    else
		g.drawImage (imgMort, 502, 111, this);
	    if (boolRolld)
		g.drawImage (imgRolld, 411, 147, this);
	    else
		g.drawImage (imgRoll, 411, 147, this);
	    if (boolDoned)
		g.drawImage (imgDoned, 411, 182, this);
	    else
		g.drawImage (imgDone, 411, 182, this);



	    g.setColor (Color.blue);
	    g.fillOval (1 + x, 1 + y, 15, 15);
	    showStatus (x + "" + y);

	    g.drawImage (dicePic [dice1], dice1X, dice1Y, this);
	    g.drawImage (dicePic [dice2], dice2X, dice2Y, this);

	}

	// Place the body of the drawing method here
    } // paint method


    public void run ()
    {

	try
	{

	    int delay = 10;
	    x = 360;
	    y = 370;
	    while (thread == Thread.currentThread ())
	    {
		if (boolMenu)
		{

		    // while (titleX != 140)  //to calculate center dimen of back /2 - dimen of image /2
		    // {


		    // }

		    while (backX != -600)
		    {
			backX--;
			Thread.sleep (delay);
			repaint ();
		    }
		    while (backY != -700)
		    {
			backY--;
			Thread.sleep (delay);
			repaint ();
		    }
		    while (backX != 0)
		    {
			backX++;
			Thread.sleep (delay);
			repaint ();
		    }
		    while (backY != 0)
		    {
			backY++;
			Thread.sleep (delay);
			repaint ();
		    }

		}
		else
		{
		    while (x != 10)
		    {
			x--;
			Thread.sleep (delay);

			repaint ();
		    }
		    while (y != 10)
		    {
			y--;
			Thread.sleep (delay);
			repaint ();
		    }
		    while (x != 360)
		    {
			x++;
			Thread.sleep (delay);
			repaint ();
		    }
		    while (y != 370)
		    {
			y++;
			Thread.sleep (delay);
			repaint ();
		    }

		}
	    }
	}
	catch (Exception ce)
	{
	}

    }


    public void start ()
    {
	(thread = new Thread (this)).start ();
    }


    public void stop ()
    {
	thread = null;
    }


    public void rollDice ()
    {

	dice1 = (int) (Math.random () * 6);
	dice2 = (int) (Math.random () * 6);
	dice1X = (int) (Math.random () * 300 + 1);
	dice2X = (int) (Math.random () * 300 + 1);
	dice1Y = (int) (Math.random () * 300 + 1);
	dice2Y = (int) (Math.random () * 300 + 1);

    }


    public void mouseClicked (MouseEvent m)
    {
	if (boolMenu)
	{
	    int x = m.getX ();
	    int y = m.getY ();
	    if (x >= 235 && x <= 365)
		if (y >= 206 && y <= 228)
		{
		    if (bool2p == false)
		    {
			bool2p = true;
			bool3p = false;
			bool4p = false;
			boolStartVisible = true;
		    }
		}

	    if (x > 235 && x < 365)
		if (y >= 234 && y <= 255)
		{
		    if (bool3p == false)
		    {
			bool3p = true;
			bool2p = false;
			bool4p = false;
			boolStartVisible = true;
		    }
		}

	    if (x >= 235 && x <= 365)
		if (y >= 265 && y <= 287)
		{
		    if (bool4p == false)
		    {
			bool4p = true;
			bool3p = false;
			bool2p = false;
			boolStartVisible = true;

		    }
		}
	    if (x >= 218 && x <= 380)
		if (y >= 424 && y <= 468)
		{
		    boolMenu = false;
		}



	}

    }


    public void mouseEntered (MouseEvent m)
    {


    }


    public void mouseExited (MouseEvent m)
    {
    }


    public void mousePressed (MouseEvent m)
    {
	int x = m.getX ();
	int y = m.getY ();
	if (x >= 424 && x <= 468)
	    if (y >= 14 && y <= 57)
	    {
		boolBuyd = true;
	    }
	if (x >= 423 && x <= 468)
	    if (y >= 67 && y <= 111)
	    {
		boolSelld = true;
	    }
	if (x >= 477 && x <= 582)
	    if (y >= 14 && y <= 34)
	    {
		boolBhoused = true;
	    }
	if (x >= 477 && x <= 582)
	    if (y >= 38 && y <= 58)
	    {
		boolBhoteld = true;
	    }
	if (x >= 477 && x <= 582)
	    if (y >= 64 && y <= 83)
	    {
		boolShoused = true;
	    }
	if (x >= 477 && x <= 582)
	    if (y >= 90 && y <= 109)
	    {
		boolShoteld = true;
	    }
	if (x >= 416 && x <= 491)
	    if (y >= 114 && y <= 147)
	    {
		boolTraded = true;
	    }
	if (x >= 505 && x <= 580)
	    if (y >= 115 && y <= 142)
	    {
		boolMortd = true;
	    }
	if (x >= 416 && x <= 587)
	    if (y >= 152 && y <= 181)
	    {
		boolRolld = true;
		rollDice ();
	    }
	if (x >= 416 && x <= 587)
	    if (y >= 187 && y <= 217)
	    {
		boolDoned = true;
	    }
    }


    public void mouseReleased (MouseEvent m)
    {
	if (x >= 416 && x <= 587)
	    if (y >= 152 && y <= 181)
	    {
		rollDice ();
	    }
	boolBuyd = false;
	boolSelld = false;
	boolBhoused = false;
	boolBhoteld = false;
	boolShoused = false;
	boolShoteld = false;
	boolTraded = false;
	boolMortd = false;
	boolRolld = false;
	boolDoned = false;


    }


    public void keyPressed (KeyEvent e)
    {
	if (boolMenu)
	{
	    if (e.getKeyCode () == e.VK_ENTER)
	    {
		boolMenu = false;

	    }
	    if (e.getKeyCode () == e.VK_K)
	    {
		boolMenu = true;

	    }
	}
	else
	{
	    if (e.getKeyCode () == e.VK_LEFT)
	    {
		x -= 10;
		repaint ();
	    }

	    if (e.getKeyCode () == e.VK_RIGHT)
	    {
		x += 10;
		repaint ();
	    }
	    if (e.getKeyCode () == e.VK_UP)
	    {
		y -= 10;
		repaint ();
	    }

	    if (e.getKeyCode () == e.VK_DOWN)
	    {
		y += 10;

		repaint ();
	    }

	    if (e.getKeyCode () == e.VK_ENTER)
	    {
		rollDice ();
	    }
	}
    }


    public void keyReleased (KeyEvent e)
    {
    }


    public void keyTyped (KeyEvent e)
    {
    }
} // AppletMain class


