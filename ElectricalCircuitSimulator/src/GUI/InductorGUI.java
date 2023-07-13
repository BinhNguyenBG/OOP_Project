package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.text.DecimalFormat;

import Circuit.Circuit;
import Circuit.SerialCircuit;
import ElectricalElement.Capacitor;
import ElectricalElement.Inductor;

public class InductorGUI extends ElementGUI{
	private Inductor inductor;

    public InductorGUI(Inductor i, Circuit cc) {
    	super(cc);
        this.inductor = i;
    }
    
    public void draw(Graphics g) {
    	if (super.getCircuit() instanceof SerialCircuit) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(5); // Set the line width to 5 pixels
            g2d.setStroke(stroke);
            
            if (inductor.getId() == 1) {
            	int startX_0 = 50;
            	int startY_0 = 200;
            	int endX_0 = startX_0;
            	int endY_0 = startY_0 + 200;
            	g2d.drawLine(startX_0, startY_0, endX_0, endY_0);
            	
            }

            int startX_1 = 50 + 250*(this.inductor.getId()-1);
            int startY_1 = 200;
            int endX_1 = startX_1 + 50;
            int endY_1 = 200;

            g2d.drawLine(startX_1, startY_1, endX_1, endY_1);
            
            int startX_2 = endX_1;
            int startY_2 = endY_1-18;
            int height = 35;
            int width = 45;
            g2d.drawArc(startX_2, startY_2, width, height, 0, 180);
            
            int startX_3 = startX_2 + width - 10;
            int startY_3 = startY_2;
            g2d.drawArc(startX_3, startY_3, width, height, 0, 180);
            
            int startX_4 = startX_3 + width - 10;
            int startY_4 = startY_3;
            g2d.drawArc(startX_4, startY_4, width, height, 0, 180);
            
            int startX_5 = startX_4 + width - 10;
            int startY_5 = startY_4;
            g2d.drawArc(startX_5, startY_5, width, height, 0, 180);
            
            g2d.drawLine(startX_5+width, endY_1, startX_5+width+50, endY_1);
            
            g2d.drawArc(startX_3, startY_3+16, 10, 13, 180, 180);
            g2d.drawArc(startX_4, startY_4+16, 10, 13, 180, 180);
            g2d.drawArc(startX_5, startY_5+16, 10, 13, 180, 180);
            
            if (inductor.getId() == super.getCircuit().getElements().size()) {
            	int startX_6 = startX_5 + width+50;
            	int startY_6 = endY_1;
            	int endX_6 = startX_6;
            	int endY_6 = startY_6+200;
            	g2d.drawLine(startX_6, startY_6, endX_6, endY_6);
            }
            
            g2d.setFont(new Font("Arial", Font.BOLD,30));
            g2d.drawString(inductor.getName(),endX_1 + 55, endY_1-75);
            Double inductance = this.inductor.getInductance()/1e-6;
            if (Math.floor(inductance) == Math.round(inductance)) {
            	g2d.drawString((int) Math.round(inductance)+" μH",endX_1 + 55-25,endY_1-35);
            } else {
            	DecimalFormat df = new DecimalFormat("###.#");
            	g2d.drawString(df.format(inductance) + " μH", endX_1 + 55-25, 210);
            }     
            
            
    	} else {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(5); // Set the line width to 5 pixels
            g2d.setStroke(stroke);

            int startX_1 = 400 + 200*(this.inductor.getId()-1);
            int startY_1 = 50;
            int endX_1 = startX_1;
            int endY_1 = startY_1 + 50;

            g2d.drawLine(startX_1, startY_1, endX_1, endY_1);
            
            int startX_2 = endX_1-18;
            int startY_2 = endY_1;
            int height = 45;
            int width = 35;
            g2d.drawArc(startX_2, startY_2, width, height, 270, 180);
            
            int startX_3 = startX_2;
            int startY_3 = startY_2+height-10;
            g2d.drawArc(startX_3, startY_3, width, height, 270, 180);
            
            int startX_4 = startX_3;
            int startY_4 = startY_3+height-10;
            g2d.drawArc(startX_4, startY_4, width, height, 270, 180);
            
            int startX_5 = startX_4;
            int startY_5 = startY_4+height-10;
            g2d.drawArc(startX_5, startY_5, width, height, 270, 180);
            
            
            g2d.drawLine(startX_1, startY_5+height, endX_1, startY_5+height+50);
            
            g2d.drawArc(startX_3+6, startY_3, 13, 10, 90, 180);
            g2d.drawArc(startX_4+6, startY_4, 13, 10, 90, 180);
            g2d.drawArc(startX_5+6, startY_5, 13, 10, 90, 180);
            
            g2d.drawLine(startX_1, startY_1, startX_1-200, startY_1);
            g2d.drawLine(startX_1, startY_5+height+50, startX_1-200, startY_5+height+50);
            
            // draw String
            
            g2d.setFont(new Font("Arial", Font.BOLD,30));
            g2d.drawString(inductor.getName(), startX_1+ 35, 170);
            Double inductance = this.inductor.getInductance()/1e-6;
            if (Math.floor(inductance) == Math.round(inductance)) {
            	g2d.drawString((int) Math.round(inductance)+" μH",startX_1+ 35, 210);
            } else {
            	DecimalFormat df = new DecimalFormat("###.#");
            	g2d.drawString(df.format(inductance) + " μH", startX_1+ 35, 210);
            }            
    	}
    }
}
