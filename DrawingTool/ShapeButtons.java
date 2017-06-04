package DrawingTool;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class ShapeButtons extends JPanel{
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private HashMap<JButton, String> Conversion = new HashMap<JButton, String>();
	private String selectButton;
	
	public ShapeButtons(){
		JButton line = new JButton("line");
		buttons.add(line);
		buttons.add(new JButton("circle"));
		buttons.add(new JButton("rectangle"));
		selectButton = "line";
		for(JButton b : buttons){
			add(b, BorderLayout.NORTH);
			b.setPreferredSize(new Dimension(90, 40));
			Conversion.put(b, b.getText());
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					selectButton = Conversion.get(b);
				}
			});
		}
		
	}
	
	public String retButton(){
		return selectButton;
	}
	
}
