package DrawingTool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {

	protected int x1;
	protected int y1;
	protected int x2;
	protected int y2;
	protected Color myColor;

	public Shape(){}
	public abstract void draw(Graphics g);
}
