//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************
import java.lang.Math;
import java.awt.*;
import javax.swing.JPanel;

public class FractalTreePanel extends JPanel
{
    private final int PANEL_WIDTH = 1200;
    private final int PANEL_HEIGHT = 1200;

    private final int X1 = 600, Y1 = 100, X2 = 600, Y2 = 200;

    private int current; //current order

    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public FractalTreePanel (int currentOrder)
    {
        current = currentOrder;
        setBackground (Color.black);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    //-----------------------------------------------------------------
    //  Draws the fractal recursively. Base case is an order of 1 for
    //  which a simple straight line is drawn. Otherwise three
    //  intermediate points are computed, and each line segment is
    //  drawn as a fractal.
    //-----------------------------------------------------------------
    public void drawFractalTree (int order,int x1, int y1, int x2, int y2, double prevAngle, double prevLength, Graphics page)
    {
        int x3, y3;
        int x4, y4;
        double degree = Math.PI/3.0;
        if (order == 1){page.drawLine(X1,Y1,X2,Y2);}
         else {
            // 1. Reduce segment length
            double length = prevLength/1.4;
            // 2. Set direction equal to its parents direction +/- some angle
            double newAngleCW = prevAngle + degree;
            double newAngleCCW = prevAngle - degree; 
            // 3. Draw a segment by calculating new (x, y) with trig
            
            // 4. Call drawFractal twice with newly calculated value
            x3 = (int)(x2 + length* Math.sin(newAngleCW)); 
            y3 = (int)(y2 + length * Math.cos(newAngleCW)); 
            
            x4 = (int)(x2 + length * Math.sin(newAngleCCW));
            y4 = (int)(y2 + length * Math.cos(newAngleCCW));
            page.drawLine(x2,y2,x3,y3);
            page.drawLine(x2,y2,x4,y4);
            //degree /= 1.5; 
            drawFractalTree (order - 1, x2, y2,x3,y3,newAngleCW,length, page);
            drawFractalTree (order - 1, x2, y2,x4,y4,newAngleCCW,length , page);
            
           
          
        }

    } 

    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawFractal method.
    //----------------------------------------------------------------
        public void paintComponent (Graphics page)
    {
        super.paintComponent (page);

        page.setColor (Color.green);

        drawFractalTree (current,X1, Y1,X2, Y2, 0.0, Y2-Y1, page);

    }

    //-----------------------------------------------------------------
    //  Sets the fractal order to the value specified.
    //-----------------------------------------------------------------
    public void setOrder (int order)
    {
        current = order;
    }

    //-----------------------------------------------------------------
    //  Returns the current order.
    //-----------------------------------------------------------------
    public int getOrder ()
    {
        return current;
    }
}
