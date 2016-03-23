// The "Purchase" class.
public class Purchase
{

    private String item;
    private double discount;
    private double price;

    public Purchase (String newItem, double newPrice)
    {
	item = newItem;
	price = newPrice;
	calcDiscount ();
    }

    public void calcDiscount ()
    {
	if (price > 25)
	    discount = price * 0.5;
	else
	    discount = 0;
    }

    public String getItem ()
    {
	return item;
    }

    public double getPrice ()
    {
	return price;
    }


    public double getDiscount ()
    {
	return discount;
    }



} // Purchase class


