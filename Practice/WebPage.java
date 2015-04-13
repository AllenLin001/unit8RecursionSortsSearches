import java.util.Scanner;
import java.net.URL; 
import java.io.IOException; 
import java.io.File; 

/**
 * Write a description of class BabyName here.
 * 
 * @Allen Lin   
 * @3/11/2015
 */
public class WebPage 
{
    public static void main (String[] args)
    {
        try
        {
            String address = "https://www.facebook.com"; 
            URL pageLocation = new URL (address); 
            Scanner in = new Scanner (pageLocation.openStream()); 
            while (in.hasNextLine())
            {
                String line = in.nextLine(); 
                System.out.println(line); 
            }
        }
        catch(IOException exception)
        {
            System.out.println("Could not open input web page.");
        }
    }
}
