// The "AppletServer" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;


public class AppletServer extends Applet implements Runnable, KeyListener
{
    // Place instance variables here
    public static Thread thread;
    public static String s = "null", s2 = "null";
    int port = 8190;
    InetAddress serverAddress;
    ServerSocket listener;
    Socket client;
    BufferedReader in;
    PrintWriter out;
    int inc = 0;
    String val = "1";



    public void init ()
    {


	addKeyListener (this);
    } // init method


    public void server () throws IOException
    {
	serverAddress = null;
	serverAddress = InetAddress.getLocalHost ();
	listener = new ServerSocket (port);
	client = listener.accept ();
	in = new BufferedReader (new InputStreamReader (client.getInputStream ()));
	out = new PrintWriter (client.getOutputStream (),true);
    }


    public void getHostName () throws IOException
    {
	serverAddress = null;
	serverAddress = InetAddress.getLocalHost ();
    }


    public void client () throws IOException
    {

	client = new Socket ("10.131.9.14", port);
	in = new BufferedReader (new InputStreamReader (client.getInputStream ()));
    }


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
	    s = in.readLine ();
	    repaint ();
	}
	catch (Exception e)
	{
	    showStatus (e.toString ());
	}

    }



    public void paint (Graphics g)
    {
	g.drawString (s, 10 + inc, 100);
	g.drawString (s2, 10, 200);


	// Place the body of the drawing method here
    } // paint method


    public void keyTyped (KeyEvent e)
    {


    }


    public void keyPressed (KeyEvent e)
    {

	try
	{
	    out.print(e.getKeyText (e.getKeyCode ()));
	    out.flush();
	    repaint ();
	}
	catch (Exception s)
	{
	}




	if (e.getKeyCode () == e.VK_S)
	{
	    try
	    {
		getHostName ();
		showStatus ("Starting as Server " + serverAddress.getHostAddress ());
		server ();
	    }
	    catch (IOException eq)
	    {
	    }
	    s2 = "Client Connected";
	    setBackground (Color.green);
	    repaint ();
	}

	if (e.getKeyCode () == e.VK_C)
	{
	    try
	    {
		showStatus ("Connecting to Server: JOESS-213-D0066");
		repaint ();
		client ();
		showStatus("Connected to JOESS-213-D0066");

	    }
	    catch (Exception a)
	    {
		s2 = a.toString ();
		repaint ();
	    }
	   
	}
    }


    public void keyReleased (KeyEvent e)
    {
    }
} // AppletServer class


