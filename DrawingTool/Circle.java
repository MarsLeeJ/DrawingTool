package DrawingTool;

import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Shape{
	
	public Circle(){
		super();
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(myColor);
		int radius = (int)Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
		g.drawOval(x1-radius, y1-radius, radius*2, radius*2);
	}

}
