    // The "ShoppingApplet" class.
import java.applet.*;
import java.awt.*;
import java.text.*;
import java.awt.event.*;


public class ShoppingApplet extends Applet implements ActionListener
{
    // Place instance variables here
    // GUI objects
    Label lblItem, lblPrice, lblDiscount;       // labels
    TextField txtItem, txtPrice, txtDiscount;   // text boxes
    Button btnCalcDiscount, btnClear;           // command buttons


    Purchase p1;
    NumberFormat nf;

    public void init ()
    {
	nf = NumberFormat.getCurrencyInstance ();
	;
	// Load the GUI objects into memory
	lblItem = new Label ("Item");
	lblPrice = new Label ("Price");
	lblDiscount = new Label ("Discount");
	txtItem = new TextField (4);
	txtPrice = new TextField (4);
	txtDiscount = new TextField (4);
	btnCalcDiscount = new Button (" Discount ");
	btnClear = new Button (" Clear ");

	// add the GUI obects to the applet screen, the order is important
	add (lblItem);
	add (lblPrice);
	add (lblDiscount);
	add (txtItem);
	add (txtPrice);
	add (txtDiscount);
	add (btnCalcDiscount);
	add (btnClear);

	// make the buttons respond to mouse clicks
	btnCalcDiscount.addActionListener (this);
	btnClear.addActionListener (this);


    } // init method


    public void actionPerformed (ActionEvent e)
    {
	double price, discount;
	String item;
	Double d;

	// if the user clicks on Discount
	if (e.getSource () == btnCalcDiscount)
	{
	    // get the item name
	    item = txtItem.getText ();

	    // convert the price to a double
	    d = new Double (txtPrice.getText ());
	    price = d.doubleValue ();

	    // create a Purchase object
	    p1 = new Purchase (item, price);
	    discount = p1.getDiscount ();

	    // format and display both price and discount
	    txtPrice.setText (nf.format (price));
	    txtDiscount.setText (nf.format (discount));
	}
	// if the user clicks on Clear
	if (e.getSource () == btnClear)
	{
	    txtItem.setText ("");
	    txtPrice.setText ("");
	    txtDiscount.setText ("");
	}

    } // actionPerformed method
} // ShoppingApplet class
