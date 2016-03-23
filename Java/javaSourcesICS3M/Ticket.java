public class Ticket
{
    private double price;
    private String event;
    private String location;
    private String date;

    public void SetPrice (double newPrice)
    {
	price = newPrice;
    }


    public double GetPrice ()
    {
	return price;
    }


    public void SetLocation (String newLocation)
    {
	location = newLocation;
    }


    public String GetLocation ()
    {
	return location;
    }
	
    public void SetEvent(String newEvent)
    {
	event = newEvent;
    }

    public String GetEvent()
    {
	return event;
    }
    
    public void SetDate(String newDate)
    {
	date = newDate;
    } 
    
    public String GetDate()
    {
	return date;
    }
    public static void main (String [] args)
    {
	Ticket RaptorsTic = new Ticket ();

	RaptorsTic.SetPrice (100.00);
	RaptorsTic.SetEvent  ("Basketball game");
	RaptorsTic.SetLocation ("ACC");
	RaptorsTic.SetDate  ("March 24, 2003");

	System.out.println ("Price for " + RaptorsTic.GetEvent() + " at " + RaptorsTic.GetLocation() + " on " + RaptorsTic.GetDate() + " is $" + RaptorsTic.GetPrice () + ".");
    } // main method
}
