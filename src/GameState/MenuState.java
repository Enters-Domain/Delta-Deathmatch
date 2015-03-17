package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import TileMap.Background;

public class MenuState extends GameState {
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
		"Start",
		"Help",
		"Options",
		"Quit"
	};
	
	private Font font;
	private Color fontColour;
	
	public MenuState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Backgrounds/titlebackground.jpg", 0);
			bg.setImagePosition(0, 0);
			bg.setVector(0, 0);
			
			font = new Font("M04_FATAL FURY", Font.PLAIN, 25);
			// R G B
			fontColour = new Color(57,142,240);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void init() {}
	
	public void update() {}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		bg.draw(g);
		
		// draw menu options
		g.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == currentChoice) {
				g.setColor(fontColour);
			}
			else {
				g.setColor(Color.WHITE);
			}
			g.drawString(options[i], 580, 450 + i * 40);
		}
		
	}
	private void select() {
		if(currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE);
		}
		if(currentChoice == 1) {
			// help
		}
		if(currentChoice == 2) {
			gsm.setState(GameStateManager.OPTIONSSTATE);
		}
		if(currentChoice == 3) {
			System.exit(0);
		}
	}

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP) {
			currentChoice--;
			if(currentChoice == -1) {
				currentChoice = options.length - 1;
			}
		}
		if(k == KeyEvent.VK_DOWN) {
			currentChoice++;
			if(currentChoice == options.length) {
				currentChoice = 0;
			}
		}
	}
	public void keyReleased(int k) {}
	
}
