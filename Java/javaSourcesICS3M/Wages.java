/* Work wages calculator
   Written by Jezreel N.
   21803
   This program calculates the number of hours worked
   and pay rate.
*/



public class Wages
{
    public static void main (String [] args)
    {
	String name; //declare name as string
	int hoursWorked; //declare hoursWorked as integer
	double payRate, payAmount = 0; //declare payRate and payAmount which equals to 0 as double


	//prompt user name
	System.out.print ("Please enter your name: ");
	//read input and store to string
	name = ReadLib.readString ();
	//prompt user work hours
	System.out.print ("Please enter your work hours: ");
	//read input and store to hoursWorked
	hoursWorked = ReadLib.readInt ();
	//prompt user hourly rate
	System.out.print ("Please enter your hourly rate: ");
	//read input and store to payRate
	payRate = ReadLib.readDouble ();


	if (hoursWorked > 0) //if the hours worked is greater than 0
	{
	    if (hoursWorked > 40) // if the hours worked is greater than 40
	    {
		//let pay amount equal to pay rate time 40 plus hours worked minus 40 plus pay rate times 1.5
		payAmount = (payRate * 40) + (hoursWorked - 40) + (payRate * 1.5);
		//call message method sending variables
		message (name, payAmount, hoursWorked);
	    }
	    else if (hoursWorked <= 40)//and if hours worked less than or equal to 40
	    {
		//let pay amount equal to pay rate times hours worked
		payAmount = (payRate * hoursWorked);
		//call message method sending variables
		message (name, payAmount, hoursWorked);
	    }

	}
	else //anything else
	{
	    //prompt user error message
	    System.out.println ("You did not enter a proper value in work hours. Calulation Halted.");
	}





    }

    //this method reads variables in the parameter and output to screen
    public static void message (String name, double payAmount, int hoursWorked)
    {   
	//prompts user final results
	System.out.print (name + ", Your pay amount is $" + payAmount + " which you have worked for " + hoursWorked + " hours.");
    }
}


