package DrawingTool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

public class DrawPanel extends JPanel{
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Shape currentShape;
	private ShapeButtons shapebuttons;
	private ColorButtons colorbuttons;
	
	public DrawPanel(ShapeButtons shapebuttons, ColorButtons colorbuttons){
		this.shapebuttons = shapebuttons;
		this.colorbuttons = colorbuttons;
		
		
		setBackground(Color.WHITE);
		
		MouseHandler mousehandler = new MouseHandler();
		this.addMouseListener(mousehandler);
		this.addMouseMotionListener(mousehandler);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for ( Shape s : shapes )
		{
			s.draw(g);
		}
		
		if(currentShape != null ){
			currentShape.draw(g);
		}
	}
	
	private class MouseHandler extends MouseAdapter implements MouseMotionListener{
		
		@Override
		public void mousePressed(MouseEvent e){
			
			if(shapebuttons.retButton().equals("line")){
				currentShape = new Line();
			}else if(shapebuttons.retButton().equals("circle")){
				currentShape = new Circle();
			}else if(shapebuttons.retButton().equals("rectangle")){
				currentShape = new Rectangle();
			}
				
			currentShape.myColor = colorbuttons.getColor();
				
			if(currentShape != null){
				currentShape.x1 = e.getX(); 
				currentShape.y1 = e.getY();
			}
		}
		
		@Override
		public void mouseReleased(MouseEvent e){
			if(currentShape != null){
				currentShape.x2 = e.getX();
				currentShape.y2 = e.getY();
				
				shapes.add(currentShape);
				currentShape = null;
				
				repaint();
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e){
		
			if(currentShape != null){
				currentShape.x2 = e.getX();
				currentShape.y2 = e.getY();
				repaint();
			}
		}
	}
}
