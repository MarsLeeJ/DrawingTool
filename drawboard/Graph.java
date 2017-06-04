package test.drawboard;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Graph extends MouseAdapter implements ActionListener {

	private int x1,y1,x2,y2;
	private int x11,y11,x22,y22;
	private String type="直线";
	Color color = Color.BLACK;
	private Graphics2D g;
	private JFrame frame;
	
	public Graph(JFrame frame) {
		this.frame = frame;
		frame.setVisible(true);
		this.g = (Graphics2D)frame.getGraphics();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		x11 = x1;
		y11 = y1;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		if(type.equals("直线"))
			g.drawLine(x1, y1, x2, y2);
		else if(type.equals("矩形")) {
			g.drawLine(x1,y1,x1,y2);  
			g.drawLine(x1,y1,x2,y1);  
			g.drawLine(x2,y1,x2,y2);  
			g.drawLine(x1,y2,x2,y2);
		}
		else if(type.equals("直角三角形")) {  
			g.drawLine(x1,y1,x2,y2);  
			g.drawLine(x1,y1,x1,y2);  
			g.drawLine(x1,y2,x2,y2);  
        }
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(type.equals("曲线")) {
			x22 = e.getX();
			y22 = e.getY();
			g.drawLine(x11, y11, x22, y22);
			x11 = x22;
			y11 = y22;
		} else if(type.equals("橡皮")) {
			x22 = e.getX();
			y22 = e.getY();
			color = frame.getBackground();
			g.setStroke(new BasicStroke(20));
			g.setColor(color);
			g.drawLine(x11, y11, x22, y22);
			x11 = x22;
			y11 = y22;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("")) {
			JButton but = (JButton) e.getSource();
			color = but.getBackground();
			g.setColor(color);
		} else {
			type = e.getActionCommand();
		}
	}

}
