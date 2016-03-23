// The "TestPiggyBank" class.
// Written by Jezreel Navarrete
// April 7, 2003
// This program will make a piggy bank that will store in the
// amount of coins and calculates the total value

import PiggyBank;
public class TestPiggyBank
{
    public static void main (String [] args)
    {
	PiggyBank person = new PiggyBank (20, 5, 2);
	person.calcTotal ();
	System.out.println ("The person has initialy $" + person.getTotal () + " amount of money in his bank.");
	person.addNickels (10);
	person.addPennies (1);
	person.addDimes (8);
	person.calcTotal ();
	System.out.println ("The person has $" + person.getTotal () + " amount of money in his bank.");
	person.EmptyBank();
	System.out.println ("The person has emptied his piggybank");
	System.out.println ("The person has now $" + person.getTotal () + " amount of money in his bank.");
	
	
    } // main method
} // TestPiggyBank class
