// The "main" class.
import CoinBox;
public class Main
{
    public static void main (String [] args)
    {
    
    CoinBox cb = new CoinBox(20);
    cb.addMoney(20);
    cb.addMoney(20);
    cb.addMoney(20);
    cb.addMoney(20);
    cb.addMoney(20);
    System.out.println(cb.getCents());
    System.out.println(cb.emptyCoinBox());
    System.out.println(cb.getCents());
    System.out.println(cb.emptyCoinBox());
    
    
	// Place your code here
    } // main method
} // main class
