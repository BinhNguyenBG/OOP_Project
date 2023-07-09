package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import Circuit.Circuit;
import Circuit.SerialCircuit;
import ElectricalElement.Capacitor;

public class CapacitorGUI extends ElementGUI{
	private Capacitor capacitor;

    public CapacitorGUI(Capacitor c, Circuit cc) {
    	super(cc);
        this.capacitor = c;
    }
    
    public void draw(Graphics g) {
    	if (super.getCircuit() instanceof SerialCircuit) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(5); // Set the line width to 5 pixels
            g2d.setStroke(stroke);
            
            if (capacitor.getId() == 1) {
            	int startX_0 = 50;
            	int startY_0 = 200;
            	int endX_0 = startX_0;
            	int endY_0 = startY_0 + 200;
            	g2d.drawLine(startX_0, startY_0, endX_0, endY_0);
            	
            }

            int startX_1 = 50 + 250*(this.capacitor.getId()-1);
            int startY_1 = 200;
            int endX_1 = startX_1 + 100;
            int endY_1 = 200;

            
            g2d.drawLine(startX_1, startY_1, endX_1, endY_1);
            
            int startX_2 = endX_1;
            int startY_2 = endY_1 - 35;
            int endX_2 = startX_2;
            int endY_2 = endY_1 + 35;
            g2d.drawLine(startX_2, startY_2, endX_2, endY_2);
            
            int startX_3 = startX_2 + 50;
            int startY_3 = startY_2;
            int endX_3 = startX_3;
            int endY_3 = endY_2;
            g2d.drawLine(startX_3, startY_3, endX_3, endY_3);
            
            int startX_4 = startX_3;
            int startY_4 = startY_1;
            int endX_4 = startX_4 + 100;
            int endY_4 = startY_4;
            g2d.drawLine(startX_4, startY_4, endX_4, endY_4);
            
            if (capacitor.getId() == super.getCircuit().getElements().size()) {
            	int endX_5 = endX_4;
            	int endY_5 = endY_4+200;
            	g2d.drawLine(endX_4, endY_4, endX_5, endY_5);
            }
            
    	} else {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(5); // Set the line width to 5 pixels
            g2d.setStroke(stroke);

            int startX_1 = 400 + 200*(this.capacitor.getId()-1);
            int startY_1 = 50;
            int endX_1 = startX_1;
            int endY_1 = startY_1 + 100;
            
            
            g2d.drawLine(startX_1, startY_1, endX_1, endY_1);
            
            int startX_2 = endX_1 + 35;
            int startY_2 = endY_1;
            int endX_2 = endX_1 - 35;
            int endY_2 = endY_1;
            g2d.drawLine(startX_2, startY_2, endX_2, endY_2);
            
            int startX_3 = startX_2;
            int startY_3 = endY_1 + 50;
            int endX_3 = endX_2;
            int endY_3 = startY_3;
            g2d.drawLine(startX_3, startY_3, endX_3, endY_3);
            
            int startX_4 = startX_1;
            int startY_4 = endY_3;
            int endX_4 = startX_4;
            int endY_4 = startY_4 + 100;
            g2d.drawLine(startX_4, startY_4, endX_4, endY_4);
            
            g2d.drawLine(startX_1, startY_1, endX_1-200, startY_1);
            g2d.drawLine(startX_1, endY_4, endX_4-200, endY_4);
    	}
    }
}
