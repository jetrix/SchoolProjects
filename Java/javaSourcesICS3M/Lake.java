import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Lake extends Applet
    implements Runnable
{

    public void createAnimation ()
    {
	Image image = createImage (m_nImgWidth, m_nImgHeight + 1);
	Graphics g = image.getGraphics ();
	g.drawImage (m_Image, 0, 1, this);
	for (int i = 0 ; i < m_nImgHeight >> 1 ; i++)
	{
	    g.copyArea (0, i, m_nImgWidth, 1, 0, m_nImgHeight - i);
	    g.copyArea (0, m_nImgHeight - 1 - i, m_nImgWidth, 1, 0, - m_nImgHeight + 1 + (i << 1));
	    g.copyArea (0, m_nImgHeight, m_nImgWidth, 1, 0, - 1 - i);
	}

	m_WaveImage = createImage (13 * m_nImgWidth, m_nImgHeight);
	m_WaveGraphics = m_WaveImage.getGraphics ();
	m_WaveGraphics.drawImage (image, 12 * m_nImgWidth, 0, this);
	int j = 0;
	do
	    makeWaves (m_WaveGraphics, j);
	while (++j < 12);
	g.drawImage (m_Image, 0, 1, this);
	if (!"".equals (m_OverlayName))
	    g.drawImage (m_Overlay, m_nImgWidth - m_nOvlWidth >> 1, m_nImgHeight - (m_nOvlHeight >> 1), this);
	m_Image = image;
    }


    public void start ()
    {
	if (m_Lake == null)
	{
	    m_Lake = new Thread (this);
	    m_Lake.start ();
	}
    }


    public String [] [] getParameterInfo ()
    {
	String as [] [] = {
	    {
	    "image", "String", "JPG or GIF file to reflect"
	    }, {
	    "overlay", "String", "JPG or GIF file to use as overlay"
	    }, {
	    "href", "URL", "URL to link to"
	    }, {
	    "target", "String", "Target frame"
	    }
	    };
	return as;
    }


    public void stop ()
    {
	if (m_Lake != null)
	{
	    m_Lake.stop ();
	    m_Lake = null;
	}
    }


    private void displayImage (Graphics g)
    {
	if (!m_fAllLoaded)
	    return;
	if (m_WaveImage != null)
	{
	    g.drawImage (m_WaveImage, - m_nCurrImage * m_nImgWidth, m_nImgHeight, this);
	    g.drawImage (m_WaveImage, (12 - m_nCurrImage) * m_nImgWidth, m_nImgHeight, this);
	}
	g.drawImage (m_Image, 0, - 1, this);
    }


    public String getAppletInfo ()
    {
	return "Name: Lake v3.0\r\n" + "Author: David Griffiths\r\n" + "Created with Microsoft Visual J++ Version 1.0";
    }


    public boolean mouseUp (Event event, int i, int j)
    {
	super.mouseUp (event, i, j);
	if (m_HRef == null)
	{
	    m_tAnimate = !m_tAnimate;
	}
	else
	{
	    showStatus ("" + m_HRef);
	    getAppletContext ().showDocument (m_HRef, m_Frame);
	}
	return true;
    }


    public void run ()
    {
	m_nCurrImage = 0;
	if (!m_fAllLoaded)
	{
	    repaint ();
	    m_Graphics = getGraphics ();
	    MediaTracker mediatracker = new MediaTracker (this);
	    m_Image = getImage (getDocumentBase (), m_ImageName);
	    if (!"".equals (m_OverlayName))
		m_Overlay = getImage (getDocumentBase (), m_OverlayName);
	    mediatracker.addImage (m_Image, 0);
	    if (!"".equals (m_OverlayName))
		mediatracker.addImage (m_Overlay, 1);
	    try
	    {
		mediatracker.waitForAll ();
		m_fAllLoaded = !mediatracker.isErrorAny ();
	    }
	    catch (InterruptedException interruptedexception1)
	    {
	    }
	    if (!m_fAllLoaded)
	    {
		stop ();
		m_Graphics.drawString ("Error loading images!", 10, 40);
		return;
	    }
	    m_nImgWidth = m_Image.getWidth (this);
	    m_nImgHeight = m_Image.getHeight (this);
	    if (!"".equals (m_OverlayName))
	    {
		m_nOvlWidth = m_Overlay.getWidth (this);
		m_nOvlHeight = m_Overlay.getHeight (this);
	    }
	    createAnimation ();
	}
     
    }


    public void makeWaves (Graphics g, int i)
    {
	double d = (6.2831853071795862D * (double) i) / (0.0D / 0.0D);
	int j = (12 - i) * m_nImgWidth;
	for (int k = 0 ; k < m_nImgHeight ; k++)
	{
	    int l = (int) (((double) (m_nImgHeight / 14) * ((double) k + 28D) * Math.sin ((double) ((m_nImgHeight / 14) * (m_nImgHeight - k)) / (double) (k + 1) + d)) / (double) m_nImgHeight);
	    if (k < -l)
		g.copyArea (12 * m_nImgWidth, k, m_nImgWidth, 1, - j, 0);
	    else
		g.copyArea (12 * m_nImgWidth, k + l, m_nImgWidth, 1, - j, - l);
	}

	if (!"".equals (m_OverlayName))
	    g.drawImage (m_Overlay, i * m_nImgWidth + (m_nImgWidth - m_nOvlWidth >> 1), - m_nOvlHeight >> 1, this);
    }


    public void destroy ()
    {
    }


    public void init ()
    {
	String s = getParameter ("image");
	if (s != null)
	    m_ImageName = s;
	s = getParameter ("overlay");
	if (s != null)
	    m_OverlayName = s;
	s = getParameter ("href");
	if (s != null)
	    try
	    {
		m_HRef = new URL (getDocumentBase (), s);
	    }
	catch (MalformedURLException malformedurlexception)
	{
	    getAppletContext ().showStatus ("Bad URL: " + s);
	    return;
	}
	s = getParameter ("target");
	if (s != null)
	    m_Frame = s;
    }


    public void paint (Graphics g)
    {
	if (m_fAllLoaded)
	{
	    displayImage (g);
	    return;
	}
	else
	{
	    g.drawString ("Loading images...", 10, 20);
	    return;
	}
    }


    public Lake ()
    {
	m_tAnimate = true;
	m_ImageName = "";
	m_OverlayName = "";
	m_Frame = "_self";
    }


    Thread m_Lake;
    private Graphics m_Graphics;
    private Graphics m_WaveGraphics;
    private Image m_Image;
    private Image m_Overlay;
    private Image m_WaveImage;
    private int m_nCurrImage;
    private int m_nImgWidth;
    private int m_nImgHeight;
    private int m_nOvlWidth;
    private int m_nOvlHeight;
    private boolean m_fAllLoaded;
    private boolean m_tAnimate;
    private final int NUM_FRAMES = 12;
    private String m_ImageName;
    private String m_OverlayName;
    private URL m_HRef;
    private String m_Frame;
    private final String PARAM_image = "image";
    private final String PARAM_overlay = "overlay";
    private final String PARAM_href = "href";
    private final String PARAM_target = "target";
}
