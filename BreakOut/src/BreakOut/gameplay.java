package BreakOut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class gameplay extends JPanel implements KeyListener, ActionListener
{

	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer time; 
	private int delay = 8;
	private int playerX = 310;
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	private Timer timer;
	
	private mapgenerator map;
	
	public gameplay() 
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		map = new mapgenerator(3, 7);
	}
	
	public void paint(Graphics g)
	{
	//background
		g.setColor(Color.black);
		g.fillRect(1,1,692, 592);
	//drawing map
		map.draw((Graphics2D)g);
		
	//Borders
		g.setColor(Color.blue);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(681, 0, 3, 592);
		
		//the paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		//Ball of Joy :D
		g.setColor(Color.blue);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	timer.start();
	if(play)
	{
		if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8)))
			ballYdir = -ballYdir;

	
	ballposX += ballXdir;
	ballposY += ballYdir;
	if(ballposX < 0) 
	{
		ballXdir = -ballXdir;
	}
	if(ballposY < 0) 
	{
		ballYdir = -ballYdir;
	}
	if(ballposX > 670) 
	{
		ballXdir = -ballXdir;
	}
	
	}
	repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
	if(playerX >= 600) {
		playerX = 600;
		 }
	else {
		moveRight();
	}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) 
		{
			if(playerX < 10) 
			{
				playerX = 10;
			}
			else
			{
		moveLeft();
			}
		
		}	
	}
	

		private void moveRight()
		{
		play = true;
		playerX+=20;
		
	}

		private void moveLeft() 
		{
		play = true;
		playerX-=20;
			
	}
	@Override
	
	public void keyReleased(KeyEvent e)
	{
		
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}

}
