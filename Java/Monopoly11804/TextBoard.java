// The "TextBoard" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TextBoard extends DBApplet implements MouseListener, KeyListener, Runnable
{
    // Place instance variables here
    Image imgBoard, imgLayout, imgBuy, imgSell, imgBhouse, imgBhotel, imgShouse, imgShotel, imgTrade, imgMort, imgRoll, imgDone, imgInfo;
    Image [] dicePic = new Image [6];
    int x = 0, y = 0;
    int dice1 = 1, dice2 = 1, dice1X = 0, dice1Y = 0, dice2X = 0, dice2Y = 0;
    public static Thread thread;
    public void init ()
    {
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
	dicePic [0] = getImage (getCodeBase (), "images/DICE_01.gif");
	dicePic [1] = getImage (getCodeBase (), "images/DICE_02.gif");
	dicePic [2] = getImage (getCodeBase (), "images/DICE_03.gif");
	dicePic [3] = getImage (getCodeBase (), "images/DICE_04.gif");
	dicePic [4] = getImage (getCodeBase (), "images/DICE_05.gif");
	dicePic [5] = getImage (getCodeBase (), "images/DICE_06.gif");

	addKeyListener (this);
	// Place the body of the initialization method here
    } // init method


    public void paint (Graphics g)
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
	g.drawImage (imgDone, 411, 182, this);
	g.drawImage (imgInfo, 405, 217, this);
	g.drawString ("      |-------------------------------|", 415, 240);
	g.drawString ("      |         Creditview Rd         |", 415, 250);
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






	g.setColor (Color.blue);
	g.fillOval (1 + x, 1 + y, 15, 15);
	showStatus (x + "" + y);

	g.drawImage (dicePic [dice1], dice1X, dice1Y, this);
	g.drawImage (dicePic [dice2], dice2X, dice2Y, this);


	// Place the body of the drawing method here
    } // paint method


    public void start ()
    {
	(thread = new Thread (this)).start ();
    }


    public void stop ()
    {
	thread = null;
    }


    public void run ()
    {
	try
	{
	    int delay = 10;
	    x = 360;
	    y = 370;
	    while (thread == Thread.currentThread ())
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
	catch (Exception ce)
	{
	}


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
    }


    public void mouseEntered (MouseEvent m)
    {
    }


    public void mouseExited (MouseEvent m)
    {
    }


    public void mousePressed (MouseEvent m)
    {
    }


    public void mouseReleased (MouseEvent m)
    {
    }



    public void keyTyped (KeyEvent e)
    {


    }


    public void keyPressed (KeyEvent e)
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




    public void keyReleased (KeyEvent e)
    {
    }
} // TextBoard class
