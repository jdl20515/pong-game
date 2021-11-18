import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// Class Statement
public class paddle 
{
    // Define variables
   private int x=100;
   private int y;
   public int width =100;
   private int height = 20;
  
   private int xMax;
   private int yMax;
   
   private int paddleSpeed = 5;

   private Rectangle myPaddle;

   
  //Constructor Statement receives xMax and yMax
// and assigns them to local variables
public paddle (int xm, int ym)
{
    xMax = xm;
    yMax = ym;
    y = yMax-35;
    myPaddle = new Rectangle(x,y,width,height);
}

public void shrinkPaddle()
{
    myPaddle.width = 75;
    myPaddle.height = 15;
}

public void growPaddle()
{
    myPaddle.width = 125;
    myPaddle.height = 25;
}

public void movePaddle(Graphics g, boolean left, boolean right)
{
     Graphics2D g2 = (Graphics2D) g;
     g2.setColor(Color.white);
     
      if (left)
     {
         myPaddle.x -= paddleSpeed;
         if (myPaddle.x < 0)
         {
             myPaddle.x = 0;
         }
     }
     
      if (right)
     {
         myPaddle.x += paddleSpeed;
         if (myPaddle.x + width  > xMax)
         {
             myPaddle.x = xMax - width;
         }
     }

     
     g2.fill(myPaddle);
}
    
    
public int getPaddleX()
{
    return myPaddle.x;
}

public int getPaddleY()
{
    return myPaddle.y;
}

public int getPaddleWidth()
{
    return myPaddle.width;
}

public int getPaddleHeight()
{
    return myPaddle.height;
}

}