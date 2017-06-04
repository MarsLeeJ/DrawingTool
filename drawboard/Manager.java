package test.drawboard;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.color.*;

public class Manager {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("drawboard");
		frame.setSize(700,500);
		FlowLayout f1 = new FlowLayout(FlowLayout.LEFT);
		frame.setLayout(f1);
		frame.setDefaultCloseOperation(3);
		frame.setLocationRelativeTo(null);
		
		Graphics gg = frame.getGraphics();
		Graph g1 = new Graph(frame);
		
		String array[] = {"直线","曲线","矩形","直角三角形"};
		Color colors[] = {Color.BLACK,Color.BLUE,Color.GRAY,Color.GREEN,Color.PINK,new Color(100,210,220)};
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(200, 210, 220));
		panel1.setPreferredSize(new Dimension(300, 50));
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(190, 200, 210));
		panel2.setPreferredSize(new Dimension(300, 50));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		for(int i=0; i<array.length; i++) {
			JButton but = new JButton(array[i]);
//			but.setPreferredSize(new Dimension(70, 20));
			but.addActionListener(g1);
			panel1.add(but);
		}
		
		for(int i=0; i<colors.length; i++) {
			JButton but = new JButton();
			but.setBackground(colors[i]);
			but.setPreferredSize(new Dimension(30, 20));
			but.addActionListener(g1);
			panel2.add(but);
		}
		
		JButton but = new JButton("橡皮");
		but.setPreferredSize(new Dimension(60, 20));
		but.addActionListener(g1);
		
		frame.add(panel1);
		frame.add(panel2);
		frame.add(but);
		frame.setVisible(true);
		
		frame.addMouseListener(g1);
		frame.addMouseMotionListener(g1);
	}

}
