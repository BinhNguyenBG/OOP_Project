package GUI;

import javax.swing.*;

import Circuit.Circuit;
import Circuit.ParallelCircuit;
import Circuit.SerialCircuit;
import ElectricalElement.Resistor;

import java.awt.*;

public class ResistorGUI extends ElementGUI{
    private Resistor resistor;

    public ResistorGUI(Resistor r, Circuit cc) {
    	super(cc);
        this.resistor = r;
    }

    
    public void draw(Graphics g) {
    	if (super.getCircuit() instanceof SerialCircuit) {
    		//super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(5); // Set the line width to 5 pixels
            g2d.setStroke(stroke);
            
            if (resistor.getId() == 1) {
            	int startX_0 = 50;
            	int startY_0 = 200;
            	int endX_0 = startX_0;
            	int endY_0 = startY_0 + 200;
            	g2d.drawLine(startX_0, startY_0, endX_0, endY_0);
            	
            }
            
            
            
            int startX_1 = 50 + 250*(this.resistor.getId()-1);
            int startY_1 = 200;
            int endX_1 = startX_1 + 50;
            int endY_1 = 200;

            g2d.drawLine(startX_1, startY_1, endX_1, endY_1);
            
            int endX_2 = endX_1 + 15;
            int endY_2 = endY_1 - 35;
            g2d.drawLine(endX_1, endY_1, endX_2, endY_2);
            
            int endX_3 = endX_2 + 30;
            int endY_3 = endY_2 + 70;
            g2d.drawLine(endX_2, endY_2, endX_3, endY_3);
            
            int endX_4 = endX_3 + 30;
            int endY_4 = endY_3 - 70;
            g2d.drawLine(endX_3, endY_3, endX_4, endY_4);
            
            int endX_5 = endX_4 + 30;
            int endY_5 = endY_4 + 70;
            g2d.drawLine(endX_4, endY_4, endX_5, endY_5);
            
            int endX_6 = endX_5 + 30;
            int endY_6 = endY_5 - 70;
            g2d.drawLine(endX_5, endY_5, endX_6, endY_6);
            
            int endX_7 = endX_6 + 15;
            int endY_7 = endY_6 + 35;
            g2d.drawLine(endX_6, endY_6, endX_7, endY_7);
            
            int endX_8 = endX_7 + 50;
            int endY_8 = endY_7;
            g2d.drawLine(endX_7, endY_7, endX_8, endY_8);
            
			if (resistor.getId() == super.getCircuit().getElements().size()) {
            	int endX_9 = endX_8;
            	int endY_9 = endY_8+200;
            	g2d.drawLine(endX_8, endY_8, endX_9, endY_9);
            }
			// Draw String:
            g2d.setFont(new Font("Arial", Font.BOLD,30));
            g2d.drawString(this.resistor.getName(), endX_1 + 55, endY_1-85);
            g2d.drawString((int)this.resistor.getResistance().getReal()+" Ω", endX_1 + 45, endY_1-50);
			
    	} else {
    		//super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(5); // Set the line width to 5 pixels
            g2d.setStroke(stroke);

            int startX_1 = 400 + 200*(this.resistor.getId()-1);
            int startY_1 = 50;
            int endX_1 = startX_1;
            int endY_1 = startY_1 + 50;

            g2d.drawLine(startX_1, startY_1, endX_1, endY_1);
            
            int endX_2 = endX_1 + 35;
            int endY_2 = endY_1 + 15;
            g2d.drawLine(endX_1, endY_1, endX_2, endY_2);
            
            int endX_3 = endX_2 - 70;
            int endY_3 = endY_2 + 30;
            g2d.drawLine(endX_2, endY_2, endX_3, endY_3);
            
            int endX_4 = endX_3 + 70;
            int endY_4 = endY_3 + 30;
            g2d.drawLine(endX_3, endY_3, endX_4, endY_4);
            
            int endX_5 = endX_4 - 70;
            int endY_5 = endY_4 + 30;
            g2d.drawLine(endX_4, endY_4, endX_5, endY_5);
            
            int endX_6 = endX_5 + 70;
            int endY_6 = endY_5 + 30;
            g2d.drawLine(endX_5, endY_5, endX_6, endY_6);
            
            int endX_7 = endX_6 - 35;
            int endY_7 = endY_6 + 15;
            g2d.drawLine(endX_6, endY_6, endX_7, endY_7);
            
            int endX_8 = endX_7;
            int endY_8 = endY_7 + 50;
            g2d.drawLine(endX_7, endY_7, endX_8, endY_8);
            
            g2d.drawLine(startX_1, startY_1, startX_1-200, startY_1);
            g2d.drawLine(endX_8, endY_8, endX_8-200, endY_8);
            
            
            
            // Draw String:
            g2d.setFont(new Font("Arial", Font.BOLD,30));
            g2d.drawString(this.resistor.getName(), endX_2 + 20, 170);
            g2d.drawString((int)this.resistor.getResistance().getReal()+" Ω", endX_2 + 20, 210);
    	}
    }
    

}
