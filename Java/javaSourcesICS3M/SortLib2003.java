// Searching and Sorting Java Library by R. Parteno (January 2001)
// includes:
//      Searches    - linear & binary
//      Sorts       - selection, insertion, quick

public class SortLib2003
{
    public static void makeData (int num [], int highLimit)
    {
	for (int ctr = 0 ; ctr < num.length ; ctr++)
	{
	    num [ctr] = (int) (Math.random () * highLimit + 1);
	}
    } // make data set


    public static int linearSearch (int num [], int searchItem)
    {
	int ptr = 0;
	while (searchItem != num [ptr] && ptr < num.length - 1)
	{
	    ptr++;
	}
	if (searchItem == num [ptr])
	    return ptr;
	else
	    return - 1;
    } // linear search


    public static int binarySearch (int data [], int searchItem)
    {
	int first = 0;
	int last = data.length - 1;
	int mid;
	if (searchItem < data [first] || searchItem > data [last])
	{
	    return - 1;
	}
	while (first <= last)
	{
	    mid = (first + last) / 2;
	    if (searchItem > data [mid])
		first = mid + 1;
	    else if (searchItem < data [mid])
		last = mid - 1;
	    else
		return mid;
	}

	return - 1;

    } // binary search


    public static void selectionSort (int data [])
    {
	int temp, smallPtr;
	for (int outer = 0 ; outer < data.length - 1 ; outer++)
	{
	    smallPtr = outer;
	    for (int inner = outer + 1 ; inner < data.length ; inner++)
	    {
		if (data [smallPtr] > data [inner])
		{
		    smallPtr = inner;
		}
	    }
	    if (smallPtr != outer)
	    {
		temp = data [outer];
		data [outer] = data [smallPtr];
		data [smallPtr] = temp;
	    }
	}
    } // selection sort


    public static void insertionSort (int numbers [])
    {

	int dataPtr, hold, insertNum;


	// this loop selects the elements of the unsorted list
	for (int outer = 1 ; outer < numbers.length ; outer++)
	{
	    dataPtr = 0;                        // points to the first data item in the sorted list
	    insertNum = numbers [outer]; // stores the number to be inserted into the sorted list

	    // find the place in the sorted list to insert the data item
	    // continue while
	    //        the data item is larger than the current sorted list data item AND
	    //        the end of the sorted list has not been reached
	    while (insertNum > numbers [dataPtr] && dataPtr < outer)
	    {
		dataPtr++;
	    }

	    // shift down to make room for the data item
	    for (int movePtr = outer ; movePtr > dataPtr ; movePtr--)
	    {
		numbers [movePtr] = numbers [movePtr - 1];
	    }

	    // insert the data item into the sorted list
	    numbers [dataPtr] = insertNum;
	}

    } // insertion sort


    public static void quickSort (int numbers [], int first, int last)
    {
	if (last >= first)
	{
	    int pivotIndex = partition (numbers, first, last);
	    quickSort (numbers, first, pivotIndex - 1);
	    quickSort (numbers, pivotIndex + 1, last);
	}
    }


    public static int partition (int numbers [], int first, int last)
    {
	int pivPtr = (first + last) / 2;
	swap (numbers, first, pivPtr);
	int pivot = numbers [first];
	int up = first + 1;
	int down = last;
	while (up < down)
	{
	    
	    while (numbers [up] <= pivot && up <down)
	    {
		up++;
		if (up < 0 || up > numbers.length-1)
		System.out.println("Numbers: "+up+" "+pivot);
	    }
	    while (numbers [down] >= pivot && up <=down)
		down--;
	    if (up < down)
	    {
		swap (numbers, up, down);
	    }
	}
	if (numbers[first]>numbers[down])
	    swap (numbers, first, down);
	return down;
    }


    public static void swap (int numbers [], int x, int y)
    {
	int hold = numbers [x];
	numbers [x] = numbers [y];
	numbers [y] = hold;
    }
}

