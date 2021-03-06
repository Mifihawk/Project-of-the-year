package BreakOut;
import javax.swing.JFrame;



public class main 
{
public static void main(String[] args)
{
	JFrame obj = new JFrame();
	gameplay gamePlay = new gameplay();
	obj.setBounds(10, 10, 700, 600);
	obj.setTitle("BreakOut Ball");
	obj.setResizable(false);
	obj.setVisible(true);
	obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	obj.add(gamePlay);
}
}
