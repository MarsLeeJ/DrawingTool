package DrawingTool;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class MyPic {
	
	private ShapeButtons shapebuttons;
	private ColorButtons colorbuttons;
	private DrawPanel drawpanel;
	
	public MyPic(){
		shapebuttons = new ShapeButtons();
		colorbuttons = new ColorButtons();
		drawpanel = new DrawPanel(shapebuttons, colorbuttons);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(colorbuttons, BorderLayout.SOUTH);
		frame.add(drawpanel);
		frame.add(shapebuttons, BorderLayout.NORTH);
		frame.setVisible(true);
		frame.setSize(800, 800);
	}
	
	public static void main(String[] args) {
		MyPic mypic = new MyPic();
	}

}
