package DrawingTool;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ColorButtons extends JPanel implements ChangeListener{
	
	private JColorChooser tcc;
	private Color selectColor;
 
    public ColorButtons() {
        super(new BorderLayout());
 
        selectColor = Color.black;
        tcc = new JColorChooser(Color.black);
        tcc.getSelectionModel().addChangeListener(this);
        tcc.setBorder(BorderFactory.createTitledBorder(
                                             "Choose Text Color"));
 
        add(tcc, BorderLayout.PAGE_END);
    }
 
    public void stateChanged(ChangeEvent e) {
        selectColor = tcc.getColor();
    }
 
    public Color getColor(){
    	return selectColor;
    }
}
