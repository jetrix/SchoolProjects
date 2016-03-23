// The "LinearSearch" class.
public class LinearSearch
{
    public static void main (String [] args)
    {
	String name [] = {"Jacqueline", "Carly", "Larah", "Jack", "Giancario", "David", "Tareq", "Adam"};
	String searchName;
	int searchResult;

	System.out.print ("Enter a name to search for: ");
	searchName = ReadLib.readString ();

	searchResult = linearSearch (name, searchName);

	if (searchResult > -1)
	{
	    System.out.println ("The name " + searchName + " was found in position " + searchResult);
	}
	else
	    System.out.println ("The name was not found");
    } // main method


    public static int linearSearch (String name [], String searchName)
    {
	for (int position = 0 ; position < name.length ; position++)
	{
	    if (searchName.equals (name [position]))
		return position;
	}
	return -1;
    }
} // LinearSearch class
