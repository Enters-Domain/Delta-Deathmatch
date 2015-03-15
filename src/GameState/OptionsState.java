package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import TileMap.Background;

public class OptionsState extends GameState {
	
	private Background bg;
	
	private Font font;
	private Color fontColour;
	
	public OptionsState(GameStateManager gsm){
		this.gsm = gsm;
		init();
	}
	
	public void init() {
		
		// load background
		bg = new Background("/Backgrounds/background1280x640.jpg", 0);
		
		font = new Font("M04_FATAL FURY", Font.PLAIN, 50);
		
		fontColour = new Color(170,0,0);
		
	}
	
	public void update() {}

	public void draw(Graphics2D g) {
		
		// draw background
		bg.draw(g);
		
		// draw fonts
		g.setColor(fontColour);
		g.setFont(font);
		g.drawString("OPTIONS", 480,180);
	}
	
	public void keyPressed(int k) {}
	
	public void keyReleased(int k) {}
	
}
