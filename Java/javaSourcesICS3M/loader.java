

import java.applet.Applet;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.zip.ZipFile;

public class loader extends Applet
    implements Runnable
{

    public final void init()
    {
	try
	{
	    if(getParameter("forcems").equals("1") && System.getProperties().getProperty("java.vendor").toLowerCase().indexOf("sun") != -1)
	    {
		forcems = true;
		fms = getImage(new URL(getCodeBase(), "switch.gif"));
		return;
	    }
	}
	catch(Exception _ex) { }
	socketthread = false;
	Thread thread = new Thread(this);
	thread.start();
	while(!socketthread) 
	    try
	    {
		Thread.sleep(100L);
	    }
	    catch(Exception _ex) { }
	Thread thread1 = new Thread(this);
	thread1.start();
    }

    private final void socketrun()
    {
	do
	{
	    if(link.socketport != 0)
	    {
		try
		{
		    Socket socket = new Socket(InetAddress.getByName(getCodeBase().getHost()), link.socketport);
		    socket.setSoTimeout(30000);
		    socket.setTcpNoDelay(true);
		    link.s = socket;
		}
		catch(Exception _ex)
		{
		    link.s = null;
		}
		link.socketport = 0;
	    }
	    if(link.runme != null)
	    {
		Thread thread = new Thread(link.runme);
		thread.setDaemon(true);
		thread.start();
		link.runme = null;
	    }
	    if(link.iplookup != null)
	    {
		String s = "unknown";
		try
		{
		    s = InetAddress.getByName(link.iplookup).getHostName();
		}
		catch(Exception _ex) { }
		link.host = s;
		link.iplookup = null;
	    }
	    try
	    {
		Thread.sleep(100L);
	    }
	    catch(Exception _ex) { }
	} while(true);
    }

    public final void run()
    {
	if(socketthread)
	{
	    socketrun();
	    return;
	}
	socketthread = true;
	try
	{
	    boolean flag = false;
	    try
	    {
		String s = getParameter("member");
		int i = Integer.parseInt(s);
		if(i == 1)
		    flag = true;
	    }
	    catch(Exception _ex) { }
	    loading = getImage(new URL(getCodeBase(), "loading.jpg"));
	    mt = new MediaTracker(this);
	    mt.addImage(loading, 0);
	    m = MessageDigest.getInstance("SHA");
	    String s1 = findcachedir();
	    if(s1 == null)
		return;
	    link.uid = getuid(s1);
	    link.mainapp = this;
	    link.numfile = 0;
	    for(int j = 0; j < 13; j++)
		if(flag || !internetname[j].endsWith(".mem"))
		{
		    for(int k = 0; k < 4; k++)
		    {
			if(k == 3)
			    return;
			byte abyte0[] = loadfile(s1 + localname[j], sha[j]);
			if(abyte0 != null)
			{
			    if(j > 0)
				link.putjag(internetname[j], abyte0);
			    break;
			}
			try
			{
			    URL url = new URL(getCodeBase(), internetname[j]);
			    DataInputStream datainputstream = new DataInputStream(url.openStream());
			    int l = size[j];
			    byte abyte1[] = new byte[l];
			    for(int i1 = 0; i1 < l; i1 += 1000)
			    {
				int j1 = l - i1;
				if(j1 > 1000)
				    j1 = 1000;
				datainputstream.readFully(abyte1, i1, j1);
				showpercent(nicename[j], (i1 * 100) / l, barpos[j]);
			    }

			    datainputstream.close();
			    FileOutputStream fileoutputstream = new FileOutputStream(s1 + localname[j]);
			    fileoutputstream.write(abyte1);
			    fileoutputstream.close();
			}
			catch(Exception _ex) { }
		    }

		}

	    cloader cloader1 = new cloader();
	    cloader1.zip = new ZipFile(s1 + localname[0]);
	    cloader1.link = Class.forName("link");
	    inner = (Applet)cloader1.loadClass("mudclient").newInstance();
	    inner.init();
	    inner.start();
	    return;
	}
	catch(Exception exception)
	{
	    System.out.println(exception + " " + exception.getMessage());
	    exception.printStackTrace();
	    return;
	}
    }

    private final byte[] loadfile(String s, byte abyte0[])
    {
	try
	{
	    File file = new File(s);
	    int i = (int)file.length();
	    DataInputStream datainputstream = new DataInputStream(new FileInputStream(s));
	    byte abyte1[] = new byte[i];
	    datainputstream.readFully(abyte1, 0, i);
	    datainputstream.close();
	    m.reset();
	    m.update(abyte1);
	    byte abyte2[] = m.digest();
	    for(int j = 0; j < 20; j++)
		if(abyte2[j] != abyte0[j])
		    return null;

	    return abyte1;
	}
	catch(Exception _ex)
	{
	    return null;
	}
    }

    private final String findcachedir()
    {
	String as[] = {
	    "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", "~/", 
	    ""
	};
	for(int i = 0; i < as.length; i++)
	    try
	    {
		String s = as[i];
		if(s.length() > 0)
		{
		    File file = new File(s);
		    if(!file.exists())
			continue;
		}
		File file1 = new File(s + ".file_store_32");
		if(file1.exists() || file1.mkdir())
		    return s + ".file_store_32" + "/";
	    }
	    catch(Exception _ex) { }

	return null;
    }

    private final int getuid(String s)
    {
	try
	{
	    File file = new File(s + "uid.dat");
	    if(!file.exists() || file.length() < 4L)
	    {
		DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(s + "uid.dat"));
		dataoutputstream.writeInt((int)(Math.random() * 99999999D));
		dataoutputstream.close();
	    }
	}
	catch(Exception _ex) { }
	try
	{
	    DataInputStream datainputstream = new DataInputStream(new FileInputStream(s + "uid.dat"));
	    int i = datainputstream.readInt();
	    datainputstream.close();
	    return i + 1;
	}
	catch(Exception _ex)
	{
	    return 0;
	}
    }

    private final void showpercent(String s, int i, int j)
    {
	Graphics g = getGraphics();
	Font font = new Font("Helvetica", 1, 13);
	FontMetrics fontmetrics = getFontMetrics(font);
	Font font1 = new Font("Helvetica", 0, 13);
	FontMetrics fontmetrics1 = getFontMetrics(font1);
	if(all || !img && mt.checkAll(true))
	{
	    all = false;
	    if(img || mt.checkAll(true))
	    {
		g.drawImage(loading, 0, 0, this);
		img = true;
	    } else
	    {
		g.setColor(Color.black);
		g.fillRect(0, 0, 512, 344);
	    }
	    g.setColor(Color.white);
	    g.setFont(font);
	    String s1 = "RuneScape has been updated!";
	    g.drawString(s1, 256 - fontmetrics.stringWidth(s1) / 2, 125);
	    s1 = "Please wait - Fetching new files...";
	    g.drawString(s1, 256 - fontmetrics.stringWidth(s1) / 2, 140);
	    g.setFont(font1);
	    s1 = "This may take a few minutes, but only";
	    g.drawString(s1, 256 - fontmetrics1.stringWidth(s1) / 2, 165);
	    s1 = "needs to be done when the game is updated.";
	    g.drawString(s1, 256 - fontmetrics1.stringWidth(s1) / 2, 180);
	}
	Color color = new Color(140, 17, 17);
	g.setColor(color);
	g.drawRect(104, 190, 304, 34);
	g.fillRect(106, 192, j * 3, 30);
	g.setColor(Color.black);
	g.fillRect(106 + j * 3, 192, 300 - j * 3, 30);
	String s2 = "Loading " + s + " - " + i + "%";
	g.setFont(font);
	g.setColor(Color.white);
	g.drawString(s2, 256 - fontmetrics.stringWidth(s2) / 2, 212);
    }

    public final void update(Graphics g)
    {
	paint(g);
    }

    public final void paint(Graphics g)
    {
	all = true;
	if(inner != null)
	    inner.paint(g);
	if(forcems)
	    g.drawImage(fms, 0, 0, this);
    }

    public final void start()
    {
	if(inner != null)
	    inner.start();
    }

    public final void stop()
    {
	if(inner != null)
	    inner.stop();
    }

    public final void destroy()
    {
	if(inner != null)
	    inner.destroy();
    }

    public final boolean mouseDrag(Event event, int i, int j)
    {
	if(inner != null)
	    return inner.mouseDrag(event, i, j);
	else
	    return true;
    }

    public final boolean mouseDown(Event event, int i, int j)
    {
	if(inner != null)
	    return inner.mouseDown(event, i, j);
	else
	    return true;
    }

    public final boolean mouseUp(Event event, int i, int j)
    {
	if(inner != null)
	    return inner.mouseUp(event, i, j);
	else
	    return true;
    }

    public final boolean mouseMove(Event event, int i, int j)
    {
	if(inner != null)
	    return inner.mouseMove(event, i, j);
	else
	    return true;
    }

    public final boolean keyUp(Event event, int i)
    {
	if(inner != null)
	    return inner.keyUp(event, i);
	else
	    return true;
    }

    public final boolean keyDown(Event event, int i)
    {
	if(inner != null)
	    return inner.keyDown(event, i);
	else
	    return true;
    }

    public loader()
    {
	forcems = false;
	all = true;
	img = false;
    }

    private boolean forcems;
    private boolean all;
    private boolean img;
    private Image loading;
    private Image fms;
    private MediaTracker mt;
    private boolean socketthread;
    private Applet inner;
    private MessageDigest m;
    private final int width = 512;
    private final int height = 344;
    private final String cacheid = ".file_store_32";
    private final String nicename[] = {
	"main game", "config", "monster graphics", "jagex library", "landscape", "maps", "object graphics", "3d models", "textures", "members monsters", 
	"members land", "members maps", "sound effects"
    };
    private final String internetname[] = {
	"mudclient162.jar", "config73.jag", "entity19.jag", "jagex.jag", "land52.jag", "maps52.jag", "media47.jag", "models26.jag", "textures15.jag", "entity19.mem", 
	"land52.mem", "maps52.mem", "sounds1.mem"
    };
    private final String localname[] = {
	"g34zx", "1jfds", "94jfj", "k23lk", "mn24j", "k4o2n", "zko34", "plam3", "zn12n", "lam3n", 
	"zl3kp", "a2155", "zck35"
    };
    private final int barpos[] = {
	10, 20, 25, 35, 40, 50, 60, 70, 80, 84, 
	88, 92, 96
    };
    private final int size[] = {
	0x1cd0a, 57870, 0x3a29e, 15166, 0x20c18, 33887, 0x12a7c, 0x2fda3, 60809, 28534, 
	0x17907, 38791, 0x1bec7
    };
    private final byte sha[][] = {
	{
	    -13, -114, 82, 112, -14, -15, 60, 45, 47, -128, 
	    -7, 12, 70, 27, 119, 107, 14, 56, 116, -63
	}, {
	    59, 106, 107, -54, -53, 66, -93, -22, -6, -117, 
	    4, -122, 52, 99, -99, 40, -7, 108, 74, 42
	}, {
	    20, -89, 39, 40, -88, 40, -99, 4, 49, 23, 
	    106, 53, 125, 47, 99, 44, -89, -99, -55, -80
	}, {
	    -113, -52, -27, 31, -9, -74, 127, -21, -41, 61, 
	    -98, 26, 124, 114, -127, 43, 50, -109, -34, -77
	}, {
	    -82, 84, 114, -67, -61, 27, 12, 15, 120, -28, 
	    110, 83, -99, 31, -77, 36, -44, -126, -107, 69
	}, {
	    74, 6, -13, 30, 81, -99, -5, 57, -95, -110, 
	    -11, 83, -53, -44, 54, 13, -51, -123, -120, -49
	}, {
	    -44, 88, 67, 0, 49, 41, 89, -63, 77, 126, 
	    -91, 125, -2, -66, 62, -101, -89, -111, 62, -123
	}, {
	    -103, 101, -125, 26, 71, 101, -5, -122, 15, 58, 
	    -82, 99, -5, 22, 91, 106, -2, 40, -69, 115
	}, {
	    -84, 75, 50, 112, -124, -27, -72, -24, 118, -112, 
	    -57, -11, 53, -91, -66, -91, 2, 95, -46, -67
	}, {
	    43, -1, -117, 34, -24, -114, 119, 25, -71, 17, 
	    82, -45, -109, 68, -43, 120, 89, -1, -3, -22
	}, {
	    -60, 39, -115, -84, -5, -60, 112, -65, 115, 87, 
	    59, -60, -5, -18, 90, 85, 71, 28, 95, 29
	}, {
	    28, -31, 51, -91, 106, -34, 96, 113, -7, 88, 
	    83, -41, -37, -32, -20, 117, -58, -108, -85, 22
	}, {
	    79, -114, 127, 101, 21, -104, 120, -49, -110, -43, 
	    98, 30, -118, 125, 20, -97, 16, -116, 85, -65
	}
    };
}
