// The "Test1" class by Jezreel Navarrete
// 22803
// Price pay for civies
public class Test1
{
    public static void main (String[] args)
    {
       double price=0; //declare price as double and assign 0
       char option; //declare option as char
       
       //This block of code prints out message into the screen and informing the user
       System.out.println("Welcome to St. Joseph's civies day"); 
       System.out.println("Please select the folowing option to pay for your civies");
       System.out.println("Select option: 1)Wear something other than the school sweater $2");
       System.out.println("               2)Wear something other than McCarthy pants or kilts $2");
       System.out.println("               3)Wear both options from 1 and 2, you save $1 only pay $3");
       System.out.println("               4)Just wear uniform $0");
       
       //Do input from the keyboard and store the character value into option
       option = ReadLib.readChar();
       
       if (option == '1')//if the option is equal to 1
	{
	    price = 2.00; //let price equal to 2.00
	    callPay(price); // call callPay method and send in price value to it
	}
       else if (option =='2')//if the option is equal to 2
	{
	    price = 2.00; //let price equal to 2.00
	    callPay(price); // call callPay method and send in price value to it
	}
       else if (option =='3')//if the option is equal to 3
	{
	    price = 3.00; //let price equal to 3.00
	    callPay(price); // call callPay method and send in price value to it
	}
       else //anything else do the code below
	price = 0.00; //let price equal to 0.00
	
       System.out.println("Have a nice day!"); //print message to the screen
       
    } // main method
    
    
    public static void callPay(double price) //callPay method and declares double price in the parameters
	{
	    System.out.println("Please pay $" + price); //print the message to the screen including the value of the price
	}
} // Test1 class
