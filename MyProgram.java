import javax.swing.*;

public class MyProgram {
    public static void main(String[] args)
    {
        //creating instance of JFrame
        JFrame frame = new JFrame();
        frame.setSize(400,300);
        frame.setTitle("Motion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Instantiate motionRunner
        motionRunner myMotion =new motionRunner();
        //Call the start_timer method
        myMotion.start_timer();
        frame.add(myMotion);
        frame.setVisible(true);
    }
}