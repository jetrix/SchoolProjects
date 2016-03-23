// The "Data" class.
import java.util.*;
public class Data
{
    public static Hashtable property [];


    /* Contents of Hashtables
	   property[0]                property[1]
      |-------|-------------|   |-------|-------------|
      |Name   | "Lakeshore" |   |Name   |   "Dixie"   |
      |-------|-------------|   |-------|-------------|
      |Cost   |     50      |   |Cost   |     60      |
      |-------|-------------|   |-------|-------------|
      |House1 |     150     |   |House1 |     190     |
      |-------|-------------|   |-------|-------------|
      |House2 |     250     |   |House2 |     290     |
      |-------|-------------|   |-------|-------------|
      |etc... |             |   |etc... |             |
      |-------|-------------|   |---------------------|

    */


    public static void init ()
    {

	property = new Hashtable [34];
	for (int i = 0 ; i < 34 ; i++)
	    property [i] = new Hashtable ();


	initNames ();
	initCost ();



    }


    //Create and store names to hashtables
    private static void initNames ()
    {
	property [0].put ("Name", "Lakeshore");
	property [1].put ("Name", "Dixie");
	property [2].put ("Name", "Dundas");
	property [3].put ("Name", "Bristol");
	property [4].put ("Name", "River Grove");
	property [5].put ("Name", "Queen St");
	property [6].put ("Name", "Guildwood");
	property [7].put ("Name", "McLaughin");
	property [8].put ("Name", "Huntingfield");
	property [9].put ("Name", "Traders");
	property [10].put ("Name", "Watline");
	property [11].put ("Name", "McGlenn");
	property [12].put ("Name", "Kariya");
	property [13].put ("Name", "Tomken");
	property [14].put ("Name", "Rathburn");
	property [15].put ("Name", "Central Parkway");
	property [16].put ("Name", "McBride");
	property [17].put ("Name", "Forestwood");
	property [18].put ("Name", "Elm");
	property [19].put ("Name", "Mississauga Valley");
	property [20].put ("Name", "Queenston");
	property [21].put ("Name", "Confederation");
	property [22].put ("Name", "Redmond");
	property [23].put ("Name", "Fairview");
	property [24].put ("Name", "Creditview");
	property [25].put ("Name", "Britannia");
	property [26].put ("Name", "Winston Churchill");
	property [27].put ("Name", "Eglinton");
	property [28].put ("Name", "Burnhamtorphe");
	property [29].put ("Name", "Hurontario");
	property [30].put ("Name", "Bancroft");
	property [31].put ("Name", "Argentia");
	property [32].put ("Name", "Mississauga Rd");
	property [33].put ("Name", "Paradise");


    }


    //Generate random and incrementing cost values and store
    private static void initCost ()
    {
	int incrementor = 0;
	for (int i = 0 ; i < 34 ; i++)
	{

	    if (i >= 14 && i <= 23)
	    {
		incrementor = (35 * i ) + 30;
	    }
	    else if (i >= 24 && i <= 29)
	    {
		incrementor = (40 * i) + 50;
	    }
	    else if (i >= 30)
	    {
		incrementor = (70 * i) + 70;
	    }
	    else
	    {
		incrementor = (5 * i) + 50;
	    }

	    property [i].put ("Cost", new Integer (incrementor));
	    property [i].put ("House1", new Integer ((int) (incrementor * 1.5)));
	    property [i].put ("House2", new Integer ((int) (incrementor * 1.6)));
	    property [i].put ("House3", new Integer ((int) (incrementor * 1.7)));
	    property [i].put ("House4", new Integer ((int) (incrementor * 1.9)));
	    property [i].put ("Motel", new Integer ((int) (incrementor * 2.2)));
	    property [i].put ("Mortgage", new Integer ((int) (incrementor / 1.4)));


	}
    }





    //Get property name from hashtable
    public static String getPropertyName (int num)
    {
	return (String) property [num].get ("Name");
    }


    //Get int value from hashtable
    //Key: cost, house1, house2, house3, house4, motel, mortgage
    //int num is the property index
    public static int getPropertyValue (String key, int num)
    {
	Integer val = (Integer) property [num].get (key);
	return val.intValue ();
    }









} // Data class


