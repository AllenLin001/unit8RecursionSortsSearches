

/**
 * Write a description of class StringReverseIter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringReverseIter
{
    public static String reverse(String text)
    {
        String reversetext = "";
        
        for (int i= text.length()-1; i>=0; i--)
        {
            char c = text.charAt(i);
            reverseText +=c;
        }
        
        return reverseText; 
    }
}
