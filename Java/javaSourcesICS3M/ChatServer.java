// The "ChatServer" class.
import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;

public class ChatServer
{
    public static List clientList = new List ();
    public static int id = 0;
    public static Date today = new Date ();

    public static void main (String [] args) throws IOException
    {
	System.out.println ("JezNET Chatserver V1.0");
	int port = 8190;
	InetAddress serverAddress = null;
	serverAddress = InetAddress.getLocalHost ();
	if (args.length > 0)
	    port = Integer.parseInt (args [0]);

	ServerSocket listener = new ServerSocket (port);
	System.out.println ("Server started on " + today);
	System.out.println ("Running on " + serverAddress.getHostName () + " on port " + port);
	System.out.println ("Ready to receive clients...");

	while (true)
	{
	    Socket client = listener.accept ();
	    new ChatHandler (client).start ();
	    System.out.println ("New client no." + id +" on client's port " + client.getPort ());
	    clientList.reset ();
	    clientList.add (client);
	    id++;
	}
    } // main method


    static synchronized void broadcast (String message, String name) throws IOException
    {
	Socket s;
	PrintWriter p;
	for (clientList.reset () ; !clientList.eol () ; clientList.succ ())
	{
	    s = (Socket) clientList.current ();
	    p = new PrintWriter (s.getOutputStream (), true);
	    p.println (name + ": " + message);

	}
    }


    static synchronized void remove (Socket s)
    {
	Socket t;

	for (clientList.reset () ; !clientList.eol () ; clientList.succ ())
	{
	    t = (Socket) clientList.current ();
	    if (t.equals (s))
		break;

	}
	clientList.remove ();
	id--;
    }
} // ChatServer class

class ChatHandler extends Thread
{
    static Date clientDate = new Date ();
    private BufferedReader in;
    private PrintWriter out;
    private Socket toClient;
    private String name;


    ChatHandler (Socket s)
    {
	toClient = s;
    }


    public void run ()
    {
	try
	{
	    in = new BufferedReader (new InputStreamReader (toClient.getInputStream ()));
	    out = new PrintWriter (toClient.getOutputStream (), true);
	    //put clear code here
	    out.println ("|==============================================================================|");
	    out.println ("|                                 Welcome to JezNET                            |");
	    out.println ("|                                    Version 1.0                  coded by JezN|");
	    out.println ("|==============================================================================|");
	    out.println ("Today's date : " + clientDate);
	    out.println ();
	    out.println ("This is the first java based IRC that runs on any OS by using telnet.");
	    out.println ("The version of this program can broadcast messages thoughout any client that is");
	    out.println ("connected to the chatserver. However it is still buggy and there is a lot to ");
	    out.println ("fix. The next version that is comming soon will have commands such as MSG,SEND,");
	    out.println ("KICK,WHOIS, but now this only has one command \"BYE\"");
	    out.println ("More news to come.");
	    out.println ();
	    out.print ("Enter your name :");
	    out.flush ();
	    String name = in.readLine ();
	    out.println ();
	    ChatServer.broadcast (name + " has joined the discussion.", "JezNET");
	    out.println ("Welcome, " + name);

	    while (true)
	    {
		String s = in.readLine ().trim ();

		if (s.equals ("BYE"))
		{
		    ChatServer.broadcast (name + " has left the discussion.",
			    "JezNET");
		    break;
		}
		ChatServer.broadcast (s, name);
	    }
	    ChatServer.remove (toClient);
	    toClient.close ();
	}


	catch (Exception e)
	{
	    System.out.println ("Error :" + e);
	}
    }




}

class List
{

    private Node start, now, prev;

    public List ()
    {
	now = null;
	start = null;
	prev = null;
    }


    public void add (Object x)
    {
	prev = now;
	if (start == null)
	{
	    start = new Node (x, null);
	    now = start;
	}
	else
	{
	    Node T = new Node (x, now.link);
	    now.link = T;
	    now = T;
	}
    }


    public void remove ()
    {
	if (isempty () || eol ())
	{
	    return;
	}
	else
	{
	    if (prev == null)
	    {
		start = now.link;
	    }
	    else
	    {
		prev.link = now.link;
		now = now.link;
	    }
	}
    }


    public boolean isempty ()
    {
	return start == null;
    }


    public Object current ()
    {
	return now.data;
    }


    public void reset ()
    {
	now = start;
	prev = null;
    }


    public boolean eol ()
    {
	return now.link == null;
    }


    public void succ ()
    {
	now = now.link;
	if (prev == null)
	    prev = start;
	else
	    prev = prev.link;
    }


    class Node
    {


	Node link;
	Object data;

	Node (Object d, Node n)
	{
	    link = n;
	    data = d;
	}
    }
}
