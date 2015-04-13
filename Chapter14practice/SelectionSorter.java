

/**
 * Write a description of class SelectionSorter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectionSorter
{
   public static void sort(int[] a)
   {
       // repeatedly scan the unsorted portion of the array for the next
       // smallest value and swap it with the element at the beginning 
       // of the unsorted portion of the array
       for(int i =0 ; i<a.length-1; i++)
       {
           int smallestValue = a[i];
           int indexOfSmallestValue = i;
           
           // scan through the unsorted portion of the array and find the 
           for (int j = i; j<a.length; j++)
           {
               if (a[j]<samllestValue) // change the sign to make it sort the biggest  
               {
                   smallestValue = a[j];
                   indexOfSmallestValue = j;
                   
                }
            }
        }
        
        // swap the smallest value with element at the beginning of the unsorted portion of the array
        
        int temp[i]= a[i];
        a[i] = a[indexOfSmallestValue];
        a[indexOfSmallestValue] = temp; 
    } 
    

   public static void main(String[] args)
   {
       int[] a = new int[20];
       for (int i=0; i<a.length; i++)
       {
           a[i]= (int)(Math.random()*100);
           
        }
        
        System.out.println(Arrays.toString(a));
        
        sort(a);
        
        System.out.println(Arrays.toString(a));
    }
}
