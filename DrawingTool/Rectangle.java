package DrawingTool;

import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape{
	public Rectangle(){
		super();
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(myColor);
		int width = x2 - x1;
		int height = y2 - y1;
		g.drawRect(x1, y1, width, height);
	}

}
