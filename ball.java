import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// Class Statement
public class ball 
{
    // Define variables
   private int x=0;
   private int y=50;
   private int width =50;
   private int height = 50;
   private int xDirection = 1;
   private int yDirection = 1;
   private int xMax;
   private int yMax;
   private int xSpeed = 2;
   private int ySpeed = 4;
   
   
   

//Constructor Statement receives xMax and yMax
// and assigns them to local variables
public ball (int x, int y)
{
    xMax = x;
    yMax = y;
}

public void speedUpBall()
{
   xSpeed = 3;
   ySpeed = 5;
}

public void shrinkBall()
{
    width = 30;
    height = 30;
}

public void changeSpeed()
{
    

    xSpeed = 5;
    ySpeed = 7;
    
}      



// moveBall method receives the graphics package
// and the performs the same logic we had before
// I moved it from motionRunner to this new object.
public void moveBall(Graphics g)
{
     Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.white);

    


     x += xSpeed * xDirection;

      y += ySpeed * yDirection;
      
      g2.fillOval(x,y,width,height);
      

      
      if (x + width > xMax)
        {
          xDirection = -1;;
        }
        
    if (y + height>yMax)
        {
          yDirection = -1;;
        }
        
     if (x < 0)
        {
          xDirection = 1;;
        }
        
    if (y < 0)
        {
          yDirection = 1;;
        }
        
}
  

        
public int getBallX()
{
    return x;
}

public int getBallY()
{
    return y;
}

public int getBallWidth()
{
    return width;
}

public int getBallHeight()
{
    return height;
}

public int getYDirection()
{
    return yDirection;
}
public void paddleCollision(int paddleY)
{
    y = paddleY-height;
    yDirection = -1;
}

}