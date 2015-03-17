package Entity;

import java.awt.Graphics2D;

import TileMap.TileMap;

public class Camera extends MapObject{

	public Camera(TileMap tm) {
		
		super(tm);
		
		moveSpeed = 5;
		maxSpeed = 10;
		stopSpeed = 100;
		
		facingRight = true;
	}
	
	private void getNextPosition() {
		
		// movement
		if(left) {
			dx -= moveSpeed;
			if(dx < -maxSpeed) {
				dx = -maxSpeed;
			}
		}
		else if(right) {
			dx += moveSpeed;
			if(dx > maxSpeed) {
				dx = maxSpeed;
			}
		}
		else {
			if(dx > 0) {
				dx -= stopSpeed;
				if(dx < 0) {
					dx = 0;
				}
			}
			else if(dx < 0) {
				dx += stopSpeed;
				if(dx > 0) {
					dx = 0;
				}
			}
		}
	}
	
	public void update() {

		// update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
	}
	
	public void draw(Graphics2D g) {
		
		setMapPosition();
		
		super.draw(g);
		
	}
}
