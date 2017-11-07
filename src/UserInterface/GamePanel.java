package UserInterface;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sun.javafx.tk.Toolkit;

import GameManagement.GameManager;

public class GamePanel extends JPanel   {

	GameManager gameManager;
	
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	int x;
	int bulletY;
	int bulletX;
	public GamePanel() throws Exception {
		 bulletY = 290;
		 bulletX = 0;
		 addKeyListener(new KeyAdapter() {

	            @Override
	            public void keyPressed(KeyEvent e) {
	            	if (e.getKeyCode() == KeyEvent.VK_A) {
	                	int key = e.getKeyCode();	            		
	            			System.out.println("Move Left");
	            			gameManager.gameEngine.round.player1.pos -= 20;
	            			repaint();            	
	                   
	                }
	                if (e.getKeyCode() == KeyEvent.VK_D) {
	                	int key = e.getKeyCode();	            		
	            			System.out.println("Move Right");
	            			gameManager.gameEngine.round.player1.pos += 20;
	            			repaint();            	
	                   
	                }
	                if (e.getKeyCode() == KeyEvent.VK_F)
	                {
	                	System.out.println("Fire");
	                	gameManager.gameEngine.round.player1.isShooting = true;
	                	bulletX = gameManager.gameEngine.round.player1.pos;
	                	
	                	//gameManager.gameEngine.round.player1.isShooting = false;
	                	
	                }
	                
	            }
	        });	
	    setFocusable(true);
	    setFocusTraversalKeysEnabled(false);
		this.gameManager = new GameManager();	
		x = gameManager.gameEngine.round.player1.pos;
		this.setVisible(true);
	}
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void keyTyped(KeyEvent e) {
//		
//		int key = e.getKeyCode();
//		if( key == KeyEvent.VK_A)
//		{
//			System.out.println("ASD");
//			gameManager.gameEngine.round.player1.pos += 50;
//			repaint();
//		}
//	}
	
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
        	final BufferedImage background = ImageIO.read(new File("C:\\Users\\Mert\\git\\2J-BubblePopper\\background.png"));
        	g.drawImage(background, 250, 70, this);			
        	g.drawImage(gameManager.gameEngine.round.player1.image, gameManager.gameEngine.round.player1.pos, 290, this);
        	if(gameManager.gameEngine.round.player1.isShooting == true )
			{				
				if(bulletY > 20)
				{
					g.drawImage(gameManager.gameEngine.bullet.bullet1Image, bulletX,bulletY, this);
					bulletY -= 2;				
									
				}
				else 
				{
					gameManager.gameEngine.round.player1.isShooting = false;
					bulletY = 290;
				}
				
			}	
        	
        	repaint();
			//gameManager.gameEngine.round.player1.pos += 50;
			//System.out.println(gameManager.gameEngine.round.player1.pos);
			
            
           
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // if(gameManager.gameEngine.round.player1.image != null){
      //  }
    }


}
