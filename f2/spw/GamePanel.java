package f2.spw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	public GamePanel() {
		bi = new BufferedImage(400, 650, BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
		big.setBackground(Color.DARK_GRAY);
	}

	public void updateGameUI(GameReporter reporter){
		Font f1 = new Font("Mistral",Font.BOLD,30);	//Set Font Character
		big.setFont(f1);
		big.clearRect(0, 0, getWidth(), getHeight());
		
		big.setColor(Color.YELLOW);		
		big.drawString(String.format("Scores : %08d", reporter.getScore()), 0, 20);
		for(Sprite s : sprites){
			s.draw(big);
		}
		
		//Show number of states
		big.setColor(Color.BLUE);		
		big.drawString(String.format("State : %02d", reporter.getState()), 0, 50);
		for(Sprite s : sprites){
			s.draw(big);
		}

		big.setColor(Color.GREEN);		//floor
		big.fillRect(0,570,400,80);

		repaint();
	}

	//Show String "Game Over"
	public void GameEnd(GameReporter reporter)
	{
		Font f1 = new Font("Mistral",Font.BOLD, 60);	//Set Font Character
		big.setFont(f1);

		big.setColor(Color.RED);		
		big.drawString("Game Over !!!", 30, 300);	//String, x axis, y axis 
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}

}
