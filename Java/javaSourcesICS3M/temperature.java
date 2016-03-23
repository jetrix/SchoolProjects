/* The Fahrenheit Program by Jezreel Navarrete
 * Written on 21003
 * This program will convert celcius into fahrenheit.
 */
public class Temperature 
{
    public static void main (String [] args)
    {
	System.out.print ("Please enter the temperature in Celcius :");
	int celTemp = ReadLib.readInt ();
	System.out.print ("The temperature in Fahrenheit is " + convert (celTemp));
    }


    public static int convert (int tempHandle)
    {
	int fahTemp;
	fahTemp = tempHandle * 9 / 5 + 32;
	return fahTemp;
    }
}
