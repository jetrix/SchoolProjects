// The "PiggyBank" class. (Test #2)
// Written ny Jezreel Navarrete
// April 7, 2003
// This class file creates a virtual PiggyBank that accepts coins
// such as dimes, pennies and nickels and records the number of coins
// and calculates the total value
public class PiggyBank
{
    private double totalValue; //create a private double variable called totalValue
    private int numPennies; //create a private integer variable called numPennies
    private int numNickels; //create a private integer variable called numNickels
    private int numDimes; //create a private integer variable called numDimes


    public PiggyBank (int newNumPennies, int newNumNickels, int newNumDimes) 
    {
	numPennies = newNumPennies; //let numPennies equal to newNumPennies
	numNickels = newNumNickels; //let numNickels equal to newNumNickels
	numDimes = newNumDimes; //let numDimes equal to newNumDimes
    }


    public void addPennies (int newNumPennies)
    {
	numPennies += newNumPennies; //let numPennies equal to numPennies plus newNumPennies
    }


    public void addNickels (int newNumNickels)
    {
	numNickels += newNumNickels; //let numNickels equal to numNickels plus newNumNickels
    }


    public void addDimes (int newNumDimes)
    {
	numDimes += newNumDimes; //let numDimes equal to numDimes plus newNumDimes
    }


    public void calcTotal ()
    {
	totalValue = (numDimes*.1) + (numNickels*.05) + (numPennies*.01); 
	//let totalValue equal to numDimes times .1 plus numNickels times .05 plus numPennies times .01
    }


    public double getTotal ()
    {
	return totalValue; //return the value of totalValue
    }


    public void EmptyBank ()
    {
	totalValue = 0; //let totalValue equal to 0
    }
} // PiggyBank class


