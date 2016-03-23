import java.io.*;

public class ArrayFile
{
    public static void main (String [] args) throws IOException
    {
	String fName = "sales.txt";
	int sales [];

	// read contents of the file
	sales = readFile (fName);

	// Sum up the elements
	sumUp (sales);

	// find number of sales in given ranges
	findRanges (sales);

	// double sales over 900
	doubleSales (sales);

	// find largest element
	findLargest (sales);

	// find smallest element
	findSmallest (sales);

    } // main method


    // method to read the contents of array from file
    public static int [] readFile (String fileName) throws IOException
    {
	BufferedReader fr = new BufferedReader (new FileReader (fileName));
	int sale [] = new int [30];
	String line;
	int count = 0;

	line = fr.readLine ();

	while (line != null && count < sale.length)
	{
	    sale [count] = Integer.parseInt (line);
	    line = fr.readLine ();
	    count += 1;
	}
	return sale;
    }


    // Method to sum the elements of the arrray
    public static void sumUp (int [] sale)
    {
	int sum = 0;

	for (int i = 0 ; i < sale.length ; i++)
	{
	    sum += sale [i];
	}
	// display the total
	System.out.println ("The total of sales is $" + sum);
	System.out.println ();
    }


    // Method to find sales in ranges
    public static void findRanges (int [] sale)
    {
	int range200 = 0, range500 = 0, range800 = 0;

	for (int i = 0 ; i < sale.length ; i++)
	{
	    if (sale [i] >= 200 && sale [i] <= 299)
	    {
		range200 += 1;
	    }
	    else if (sale [i] >= 500 && sale [i] <= 599)
	    {
		range500 += 1;
	    }
	    else if (sale [i] >= 800 && sale [i] <= 899)
	    {
		range800 += 1;
	    }
	}
	// display the number of sales in each range
	System.out.println ("The number of sales in range $200-299 is " + range200);
	System.out.println ("The number of sales in range $500-599 is " + range500);
	System.out.println ("The number of sales in range $800-899 is " + range800);
	System.out.println ();
    }


    // Method to double sales over 900
    public static void doubleSales (int [] sale)
    {
	for (int i = 0 ; i < sale.length ; i++)
	{
	    if (sale [i] >= 900)
	    {
		System.out.println ("Old sale value is " + sale [i]);
		sale [i] = sale [i] * 2;
		System.out.println ("New sale value is " + sale [i]);
		System.out.println ();
	    }
	}
    }


    // Method to find largest sale
    public static void findLargest (int [] sale)
    {
	int maxSale, maxIndex;

	maxSale = sale [0];
	maxIndex = 0;
	for (int i = 0 ; i < sale.length ; i++)
	{
	    if (sale [i] > maxSale)
	    {
		maxSale = sale [i];
		maxIndex = i;
	    }
	}
	// display the largest element and its index
	System.out.println ("Largest sale is " + maxSale + " at index " + maxIndex);
	System.out.println ();
    }


    // Method to find smallest sale
    public static void findSmallest (int [] sale)
    {
	int minSale, minIndex;

	minSale = sale [0];
	minIndex = 0;
	for (int i = 0 ; i < sale.length ; i++)
	{
	    if (sale [i] < minSale)
	    {
		minSale = sale [i];
		minIndex = i;
	    }
	}
	// display the smallest element and its index
	System.out.println ("Smallest sale is " + minSale + " at index " + minIndex);
	System.out.println ();
    }
} // ArrayFile class
