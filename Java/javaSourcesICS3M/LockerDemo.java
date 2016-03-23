// The "LockerDemo" class.
// written by Jezreel Navarrete
// 42903
// This program demonstrate the parallel arrays
import java.io.*;
import java.util.*;

public class LockerDemo
{
    public static void main (String [] args) throws IOException
    {
	int locker [] = new int [10];
	String name [] = new String [10];
	int grade [] = new int [10];

	int lockerNum, searchResult;
	StringTokenizer st;

	BufferedReader lockList = new BufferedReader (new FileReader ("locker.txt"));
	int listLength = Integer.parseInt(lockList.readLine());
	for (int i = 0 ; i < listLength ; i++)
	{
	    st = new StringTokenizer (lockList.readLine (), ",");
	    locker [i] = Integer.parseInt (st.nextToken ());
	    name [i] = st.nextToken ();
	    grade [i] = Integer.parseInt (st.nextToken ());
	}
	/* for (int i = 0 ; i < 10 ; i++)
	 {
	     System.out.println (locker [i] + " " + name [i] + " " + grade [i]);
	 }*/

	System.out.println ("Enter Locker # ");
	lockerNum = ReadLib.readInt ();

	searchResult = linearSearch (lockerNum, locker);
	if (searchResult > -1)
	{
	    System.out.println ("This locker belongs to " + name [searchResult] + " in grade " + grade [searchResult]);

	}
	else
	    System.out.println ("There is no record for locker " + lockerNum);
	lockList.close ();
    } // main method


    public static int linearSearch (int lockerNum, int locker [])
    {
	for (int position = 0 ; position < locker.length ; position++)
	{
	    if (lockerNum == (locker [position]))
		return position;
	}
	return -1;
    }
} // LockerDemo class
