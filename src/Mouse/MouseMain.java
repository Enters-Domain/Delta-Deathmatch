package Mouse;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

public class MouseMain {
	
	public static void getMouseLocation() {
		
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		
		int x = (int) b.getX();
		int y = (int) b.getY();
		
		if (x > 1280) x = 1280;
		if (y > 720) y = 720;
		
		System.out.println("x: " + x + " y: " + y);
	}
}
