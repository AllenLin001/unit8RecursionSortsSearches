import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;

public class LogSpiralPanel extends JPanel
{
   private static final double GOLDEN_MEAN = (1 + Math.sqrt(5)) / 2;

   public void paintComponent(Graphics g)
   {
     int size = panel.getheight(); 
     Graphics.drawRect(0,0,size,size);
     recursiveDraw();
     
   }
   
   /**
      Method that recursively draws a logarithmic spiral.
      @param x The x-coordinate of the golden rectangle's upper-left corner  
      @param y The y-coordinate of the golden rectangle's upper-left corner
      @param side the smallest side size of the golden rectangle
      @param angle the angle (0, 90, 180 or 270) where the top of the 
      golden rectangle is located. For the outermost golden rectangle, 
      the angle is 90.
   */
   private void recursiveDraw(Graphics g, double x, double y, double side, int angle)
   {
      while (side>0.0001)
      {
          
        }
      
   }
}

What is the code of your completed paintComponent method?


4.2) Now you will complete the code of the recursive helper method recursiveDraw. To recursively draw the logarithmic spiral, you first need to draw the square. The square's upper-left corner is at position (x, y), and its side size is side. Then you need to draw the arc. You can use the method drawArc that has been provided for you. Then you need to recursively call recursiveDraw to continue drawing the spiral recursively.

Before making the recursive call you need to calculate the new side size, the new x-coordinate, the new y-coordinate, and the new angle. Two methods calculateNewX and calculateNewY have been provided for you. You can use these methods to calculate the new x and y coordinates, but you need to calculate the new side size and the new angle yourself. Remember that the new side size is the difference between the sizes of the two sides of the current rectangle. The new angle is given by rotating the current angle 90 degrees in clock-wise direction.

public class LogSpiralPanel extends JPanel
{
   private static final double GOLDEN_MEAN =  (1 + Math.sqrt(5)) / 2;

   public void paintComponent(Graphics g)
   {
      . . .
   }
   
   /**
      Method that recursively draws a logarithmic spiral.
      @param x The upper left corner x-coordinate of the golden rectangle
      @param y The upper left corner y-coordinate of the golden rectangle
      @param side the smallest side size of the golden rectangle
      @param angle The angle (0, 90, 180 or 270) where the top of the 
      current golden rectangle is located. For the outermost golden 
      rectangle, the angle is 90.
   */
   private void recursiveDraw(Graphics g, double x, double y, double side, int angle)
   {
      
      // Recursion ending condition: when the side is very small
      . . .
      while (side > .000001)
      {
          
          
        
      // Draw the current square and arc
      . . .

      /* Continue drawing the spiral recursively: calculate the new side 
         size, calculate the new (x, y) coordinates and the new angle. Then, 
         call "recursiveDraw" again. */
      . . .
    }
    }
   
   /**
      Draws the arc of the current iteration.
      @param x The x-coordinate of the square's upper-left corner  
      @param y The y-coordinate of the square's upper-left corner
      @param side The size of the side of the square (or the arc's radius)
      @param angle The angle (0, 90, 180 or 270) where the top of the 
      current golden rectangle is located. For the outermost golden 
      rectangle, the angle is 90.
   */
   private void drawArc(Graphics g, double x, double y, double side, int angle)
   {
      double auxX = x;
      double auxY = y;
      if (angle == 0 || angle == 270 )
      {
         auxX = x - side;
      }
      if (angle == 270 || angle == 180)
      {
         auxY = y - side;
      }
      g.drawArc((int) auxX, (int) auxY, (int) side * 2, (int) side * 2, angle, 90);
   }   
   private double calculateNewX(double x, double angle, double side, double newSide)
   {
      if (angle == 0)
         x = x + side - newSide;
      else if (angle == 90)
         x = x + side;
      else if (angle == 270)
         x = x - newSide;
      return x;
   }

   private double calculateNewY(double y, double angle, double side, double newSide)
   {
      if (angle == 0)
         y = y + side;
      else if (angle == 180)
         y = y - newSide;
      else if (angle == 270)
         y = y + side - newSide;
      return y;
   }
}