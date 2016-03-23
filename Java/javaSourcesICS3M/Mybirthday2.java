 /* The "HelloWorld" class by Navarrete
    Written Febuary 4, 2003
    This program says "Hello World"
 */
import java.io.*; 
public class HelloWorld
{
    public static void main (String[] args) throws IOException
    {
       BufferedReader kb = new BufferedReader (new InputStreamReader (System.in));
       System.out.print ("Please enter your name: ");
       String test = kb.readLine ();
       System.out.print ("Please enter your age: ");
       String Myage;
       Myage = kb.readLine ();
       sayHappy();
       sayHappy();
       greeting(test);
       sayHappy();
       sayAge(Myage);
    } // main method
    
    public static void greeting(String birthdayName)
    {
    System.out.println("Happy Birthday Dear "+birthdayName+"...");
 
    }
    public static void sayHappy()
    {
    System.out.println("Happy Birthday To You");
    }
    public static void sayAge(String age)
    {
    System.out.println("You are "+age+" years old");
    }
   
 }   
