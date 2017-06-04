package DrawingTool;

import java.awt.*;

public class Line extends Shape {
	
	
	public Line()
	{
		super();
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(myColor);
		g.drawLine(x1, y1, x2, y2);
	}
	
}
