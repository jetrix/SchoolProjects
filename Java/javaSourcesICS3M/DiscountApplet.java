//The "DiscountApplet" class. by Jezreel N.
//41003
//This program calculates the discounting price using the interfaces of the applet
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
public class DiscountApplet extends JApplet implements ActionListener
{
    // GUI objects
    JLabel lblItem, lblPrice, lblDiscount, lblDiscountAmt;
    JTextField txtItem, txtPrice;
    JButton btnCalcDiscount, btnClear;
    JPanel panel;

    // Other objects
    Purchase purchase;
    NumberFormat nf;

    public void init ()
    {
	// Container gives access to the main screen
	Container contentPane = getContentPane ();
	panel = new JPanel ();
	// Set up formatting object
	panel.setLayout (new GridLayout (4, 2));
	nf = NumberFormat.getCurrencyInstance ();
	lblItem = new JLabel ("Item");
	lblPrice = new JLabel ("Price");
	lblDiscount = new JLabel ("Discount");
	txtItem = new JTextField (6);
	txtPrice = new JTextField (6);
	lblDiscountAmt = new JLabel ("");
	btnCalcDiscount = new JButton ("Discount");
	btnClear = new JButton ("Clear");

	//Add GUI to the panel
	panel.add (lblItem);
	panel.add (txtItem);

	panel.add (lblPrice);
	panel.add (txtPrice);

	panel.add (lblDiscount);
	panel.add (lblDiscountAmt);

	panel.add (btnClear);
	panel.add (btnCalcDiscount);

	//make button listen to the mouse clicks
	btnCalcDiscount.addActionListener (this);
	btnClear.addActionListener (this);

	//Add panel to the main screen
	contentPane.add (panel);

	//Add some text in text
	txtItem.setText ("<Enter Item name>");
	txtPrice.setText ("0");


    } // init method


    public void actionPerformed (ActionEvent e)
    {
	double price, discount;
	String item;

	// If discount button was clicked
	if (e.getSource () == btnCalcDiscount)
	{
	    // Get the item name
	    item = txtItem.getText ();

	    // Get the price
	    price = Double.parseDouble (txtPrice.getText ());

	    purchase = new Purchase (item, price);
	    discount = purchase.getDiscount ();

	    // Format and display price and discount
	    txtPrice.setText (nf.format (price));
	    lblDiscountAmt.setText (nf.format (discount));
	}

	// If the clear button is clicked
	if (e.getSource () == btnClear)
	{
	    txtItem.setText ("");
	    txtPrice.setText ("");
	    lblDiscountAmt.setText ("");
	}

    } // actionPerformed method
} // DiscountApplet class

