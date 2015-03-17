package GameState;

import Main.GamePanel;
import TileMap.*;
import Audio.AudioPlayer;
import Entity.Camera;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Level1State extends GameState {
	
	private TileMap tileMap;
	private Background bg;
	
	//private Player player;
	
	private Camera camera;
	
	//private ArrayList<Enemy> enemies;
	//private ArrayList<Explosion> explosions;
	
	//private HUD hud;
	
	private AudioPlayer bgMusic;
	
	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}
	
	public void init() {
		
		// loading
		tileMap = new TileMap(29);
		tileMap.loadTiles("/Tilesets/maintileset.png");
		tileMap.loadMap("/Maps/testing.map");
		tileMap.setPosition(0, 0);
		tileMap.setMapPosition(0, 87); // 29 (tile height) * 3
		tileMap.setTween(1);
		
		bg = new Background("/Backgrounds/backgroundclean.png", 0);
		
		//player = new Player(tileMap);
		//player.setPosition(100, 100);
		
		camera = new Camera(tileMap);
		camera.setPosition(GamePanel.WIDTH / 2, 100);
		
		//hud = new HUD(player);
	}
	
	public void update() {
		
		// update player
		//player.update();
		//tileMap.setPosition(
				//GamePanel.WIDTH / 2 - player.getx(),
				//GamePanel.HEIGHT / 2 - player.gety()
				//);
		
		camera.update();
		tileMap.setPosition(GamePanel.WIDTH / 2 - camera.getx(), GamePanel.HEIGHT / 2 - camera.gety());
		
		// set background
		bg.setPosition(tileMap.getx(), tileMap.gety());
		
		// attack enemies
		//player.checkAttack(enemies);
		
		/* update all enemies
		for(int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);
			e.update();
			if(e.isDead()) {
				enemies.remove(i);
				i--;
				explosions.add(
					new Explosion(e.getx(), e.gety()));
			}
		}
		*/
		
		/* update explosions
		for(int i = 0; i < explosions.size(); i++) {
			explosions.get(i).update();
			if(explosions.get(i).shouldRemove()) {
				explosions.remove(i);
				i--;
			}
		}*/		
		// update music
		//if (Player.getDead() == true) {
			//bgMusic.stop();
		//}
	}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		bg.draw(g);
		
		// draw tilemap
		tileMap.draw(g);
		
		// draw player
		//player.draw(g);
		
		// draw enemies
		//for(int i = 0; i < enemies.size(); i++) {
			//enemies.get(i).draw(g);
		//}
		
		/* draw explosions
		for(int i = 0; i < explosions.size(); i++) {
			explosions.get(i).setMapPosition(
				(int)tileMap.getx(), (int)tileMap.gety());
			explosions.get(i).draw(g);
		}
		*/
		
		// draw hud
		//hud.draw(g);
		
	}
	
	public void keyPressed(int k) {
		
		if(k == KeyEvent.VK_LEFT) camera.setLeft(true);
		if(k == KeyEvent.VK_RIGHT) camera.setRight(true);
		/*
		if(k == KeyEvent.VK_LEFT) player.setLeft(true);
		if(k == KeyEvent.VK_RIGHT) player.setRight(true);
		if(k == KeyEvent.VK_UP) player.setUp(true);
		if(k == KeyEvent.VK_DOWN) player.setDown(true);
		if(k == KeyEvent.VK_W) player.setJumping(true);
		*/
	}
	
	public void keyReleased(int k) {
		
		if(k == KeyEvent.VK_LEFT) camera.setLeft(false);
		if(k == KeyEvent.VK_RIGHT) camera.setRight(false);
		/*
		if(k == KeyEvent.VK_LEFT) player.setLeft(false);
		if(k == KeyEvent.VK_RIGHT) player.setRight(false);
		if(k == KeyEvent.VK_UP) player.setUp(false);
		if(k == KeyEvent.VK_DOWN) player.setDown(false);
		if(k == KeyEvent.VK_W) player.setJumping(false);
		*/
	}
	
}

