import java.io.*;
import java.net.*;

public class Server
{

    public static void main (String [] args) throws IOException
    {
	int port = 8190;
	InetAddress serverAddress = null;
	serverAddress = InetAddress.getLocalHost ();

	System.out.println ("Running...please connect to " + serverAddress.getHostName ());
	System.out.println ("Server socket is opened at port " + port);

	ServerSocket listener = new ServerSocket (port);
	Socket client = listener.accept ();

	BufferedReader in = new BufferedReader (new InputStreamReader (client.getInputStream ()));
	PrintWriter out = new PrintWriter (client.getOutputStream (), true);
	System.out.println ("Client is connected!");


	//clearscreen
	char esc = 27;
	String clear = esc + "[2J";
	out.print (clear);

	out.println ("*******************************************************************************");
	out.println ("*                             !!!!!WELCOME!!!!!                               *");
	out.println ("*******************************************************************************");
	out.println ();
	out.println ("Welcome to " + serverAddress.getHostName () + "'s computer");
	out.print ("Please enter your name : ");
	out.flush ();

	String name = in.readLine ();
	out.println ();
	out.println ("Hello, " + name);
	System.out.println ("Client's name is " + name);


	while (true)
	{
	    String server = ReadLib.readString ();
	    out.println ("Server: " + server);
	    String cl = in.readLine ();
	    System.out.println (name + ": " + cl);

	    if (cl == null)
	    {
		System.out.println ("Client has disconnected");
		break;
	    }
	}
	






    }
}
