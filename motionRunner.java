import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class motionRunner extends JPanel  implements KeyListener

{

    private ball myBall;
    private paddle myPaddle;
    
    private boolean firstTime = true;
    private boolean left = false;

    private boolean right = false;
    
    private int score = 0;
    public int level = 1;
    
    private int yMax, xMax;

     
public motionRunner ()
{
    this.setFocusable(true);
    this.addKeyListener(this);
}

           
   public void start_timer()
   {
      Timer t = new Timer(10, new Listener());
      t.start();
      
 
   }
   public void paintComponent (Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g; 
      if (firstTime)
      {
      xMax = getWidth();
      yMax = getHeight(); 
      myBall = new ball (xMax,yMax);
      myPaddle = new paddle(xMax, yMax);
      firstTime= false;
      }
      
     
      super.paintComponent(g);
      
      setBackground(Color.black);
      myBall.moveBall(g);
      myPaddle.movePaddle(g,left, right);
      testCollision();
      checkBottom();
      increaseLevel();
      
      
      /*************************************************
       * 
       *   Add the DrawString instruction below this
       * ***********************************************/
       
        Font font = new Font("Impact", Font.BOLD, 20);
        
        g2.setFont(font);
        
        g2.setColor(Color.white);

        
        g2.drawString("Score = ", 50, 30);
        
        g2.drawString(Integer.toString(score), 150, 30);
        
        g2.drawString("Level = ", 200, 30);
        
        g2.drawString(Integer.toString(level), 300, 30);
       
   }
   
   private void checkBottom()
   {
       if (myBall.getBallY() + myBall.getBallHeight()
       > yMax)
       {
           score--;
       }
   }
   
   private void testCollision()
   {
       if (myBall.getBallX() + myBall.getBallWidth()
       > myPaddle.getPaddleX() &&
       
       myBall.getBallX() < myPaddle.getPaddleX() 
       + myPaddle.getPaddleWidth() &&
       
       myBall.getBallY() + myBall.getBallHeight() >
       myPaddle.getPaddleY() &&
       
       myBall.getYDirection() == 1
       )
       {
          myBall.paddleCollision(myPaddle.getPaddleY());
          //score = score + 1;
          score ++;
         
           
       }
   }
       
    private void increaseLevel()
    {
        if (score >= 10)
        {
            level = 2;
            myPaddle.shrinkPaddle();
        }
        
        if (score >= 20)
        {
            level = 3;
            myBall.shrinkBall();
        }        
        
        if (score >= 30)
        {
            level = 4;
            myBall.speedUpBall();
        }   
        
        if (score >= 50)
        {
            level = 5;
           myBall.changeSpeed();
           myPaddle.growPaddle();
     
        }        
    }
    
    

    
   
   private class Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         repaint();//paintImmediately(0, 0, getWidth(), getHeight());
      }
   }
   
   
@Override
public void keyTyped(KeyEvent e) {}
                    
@Override
public void keyReleased(KeyEvent e) 
{
int keyCode = e.getKeyCode();
      	switch( keyCode ) 
{ 
          case KeyEvent.VK_LEFT:
            left = false;
            break;
         case KeyEvent.VK_RIGHT:
            right = false;
            break;
         }
  }

@Override
public void keyPressed(KeyEvent e) 
{     
      int keyCode = e.getKeyCode();
      switch( keyCode ) 
{ 
         case KeyEvent.VK_LEFT:
            left=true;
            break;
         case KeyEvent.VK_RIGHT:
            right = true;
            break;
      }
    }

}