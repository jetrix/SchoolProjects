// The "Ergonomics" class.

import java.io.*;
public class Ergonomics
{
    public static void main (String [] args) throws IOException
    {
	String name; //declare name as string
	//declare totalScore, numQuest as integer and equal to zero and scoreHandle, numQuestHandle as integer
	int totalScore = 0, numQuest = 0, scoreHandle, numQuestHandle;

	print ("Enter your name"); //calls print method and displays to screen
	name = ReadLib.readString (); //Read string from keyboard and put in name

	print ("Do you have an LCD monitor? (Y/N)"); //calls print method and displays to screen
	scoreHandle = questYN (ReadLib.readChar (), 30, 10); //call questYN method send in ReadLib.readChar () and values 30 and 10 and put the return value to scoreHandle
	numQuestHandle = questCount (scoreHandle);
	totalScore += scoreHandle;
	numQuest += numQuestHandle;

	print ("Do you sometimes slouch when sitting?"); //calls print method and displays to screen
	scoreHandle = questYN (ReadLib.readChar (), 10, 30);
	numQuestHandle = questCount (scoreHandle);
	totalScore += scoreHandle;
	numQuest += numQuestHandle;

	print ("Is the room your in always dark when using the computer?"); //calls print method and displays to screen
	scoreHandle = questYN (ReadLib.readChar (), 10, 40);
	numQuestHandle = questCount (scoreHandle);
	totalScore += scoreHandle;
	numQuest += numQuestHandle;

	print ("How far are you from the monitor? a)20cm b)30cm c)50cm d)70cm"); //calls print method and displays to screen
	scoreHandle = questMultiple (ReadLib.readChar (), 5, 10, 30, 50);
	numQuestHandle = questCount (scoreHandle);
	totalScore += scoreHandle;
	numQuest += numQuestHandle;

	print ("True or False. Is it important to excersise before and after using the computer? (T/F)"); //calls print method and displays to screen
	scoreHandle = questTF (ReadLib.readChar (), 40, 10);
	numQuestHandle = questCount (scoreHandle);
	totalScore += scoreHandle;
	numQuest += numQuestHandle;

	print ("Should you get away from the computer for at least 5min every hour? (T/F)"); //calls print method and displays to screen
	scoreHandle = questTF (ReadLib.readChar (), 20, 10);
	numQuestHandle = questCount (scoreHandle);
	totalScore += scoreHandle;
	numQuest += numQuestHandle;

	print ("The position of your mouse should be: a)Next to the keyboard b)Far away as possible from the keboard c)On your lap"); //calls print method and displays to screen
	scoreHandle = questMultiple (ReadLib.readChar (), 30, 10, 5, 0);
	numQuestHandle = questCount (scoreHandle);
	totalScore += scoreHandle;
	numQuest += numQuestHandle;

	print ("How would you reduce glare? a)Point the monitor away from bright light b)Use curtains and blinds c)Get a antiglare screen"); //calls print method and displays to screen
	scoreHandle = questMultiple (ReadLib.readChar (), 20, 20, 25, 0);
	numQuestHandle = questCount (scoreHandle);
	totalScore += scoreHandle;
	numQuest += numQuestHandle;

	print ("Should you curve you back while sitting on a chair?(T/F)"); //calls print method and displays to screen
	scoreHandle = questTF (ReadLib.readChar (), 20, 10);
	numQuestHandle = questCount (scoreHandle);
	totalScore += scoreHandle;
	numQuest += numQuestHandle;

	print ("Should monitors be parallel to the lights?(T/F)"); //calls print method and displays to screen
	scoreHandle = questTF (ReadLib.readChar (), 20, 10);
	numQuestHandle = questCount (scoreHandle);
	totalScore += scoreHandle;
	numQuest += numQuestHandle;




	System.out.println (name + ", Your total score is " + totalScore +" and you answered " + numQuest + " out of 10.");
	System.out.println (numQuest);


    } // main method


    public static int questYN (char charInput, int scrHigh, int scrLow)
    {
	if (charInput == 'y')
	    return scrHigh;
	else if (charInput == 'n')
	    return scrLow;
	else
	    return 0;
    } //questYN method: Reads in charInput, scrHigh, scrLow and returns the score


    public static void print (String handle)
    {
	System.out.println (handle);
    }


    public static int questCount (int score)
    {
	if (score != 0)
	    return 1;
	else
	    return 0;
    }


    public static int questTF (char charInput, int scrHigh, int scrLow)
    {
	if (charInput == 't')
	    return scrHigh;
	else if (charInput == 'f')
	    return scrLow;
	else
	    return 0;
    } //questTF method: Reads in charInput, scrHigh, scrLow and returns the score


    public static int questMultiple (char charInput, int scrA, int scrB, int scrC, int scrD)
    {
	if (charInput == 'a')
	    return scrA;
	else if (charInput == 'b')
	    return scrB;
	else if (charInput == 'c')
	    return scrC;
	else if (charInput == 'd')
	    return scrD;
	else
	    return 0;
    } //questMultiple method: Reads in charInput, scrA, scrB, scrC, scrD and returns the score
} // Ergonomics class
