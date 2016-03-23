// The "HelloWorldApplet" class.
import java.applet.*;
import java.awt.*;

public class HelloWorldApplet extends Applet
{
    // Place instance variables here
    
    public void init ()
    {
	// Place the body of the initialization method here
    } // init method
    
    
    public void paint (Graphics c)
    {
    c.drawString("!!!Hello World!!!",120,100);
    ICS3M1Library.house (c, 210, - 100);
	ICS3M1Library.house (c, 410, - 100);
	ICS3M1Library.house (c, 70, - 50);
	ICS3M1Library.house (c, 210, - 50);
	ICS3M1Library.house (c, 410, - 50);
	ICS3M1Library.house (c, 70, 0);
	ICS3M1Library.house (c, 210, 0);
	ICS3M1Library.house (c, 410, 0);
	ICS3M1Library.house (c, 530, 0);
	// Place the body of the drawing method here
    } // paint method
} // HelloWorldApplet class
