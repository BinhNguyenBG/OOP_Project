package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import Circuit.Circuit;
import Circuit.SerialCircuit;
import VoltageSource.AC;

public class ACGUI extends ElementGUI{
	private AC ac;
	
	public ACGUI(AC ac, Circuit cc) {
		super(cc);
		this.ac = ac;
	}
	
	public void draw(Graphics g) {
		if (super.getCircuit() instanceof SerialCircuit) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(5); // Set the line width to 5 pixels
            g2d.setStroke(stroke);
            
            g2d.drawLine(50, 400, 50+((250*super.getSeed()-150)/2), 400);
            g2d.drawOval(50+((250*super.getSeed()-150)/2), 350, 150, 100);
            g2d.drawLine(50+((250*super.getSeed()-150)/2)+150, 400, 50+250*super.getSeed(), 400);
            g2d.drawArc(50+((250*super.getSeed()-150)/2)+37, 400-22, 38, 45, 0, 180);
            g2d.drawArc(50+((250*super.getSeed()-150)/2)+37+38, 400-22, 38, 45, 180, 180);
            
    	} else {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(5); // Set the line width to 5 pixels
            g2d.setStroke(stroke);
            
            g2d.drawLine(200, 50, 200, 100);
            g2d.drawOval(150, 100, 100, 150);
            g2d.drawLine(200, 250, 200, 300);
            g2d.drawArc(200-22, 100+37, 45, 38, 270, 180);
            g2d.drawArc(200-22, 100+37+38, 45, 38, 90, 180);
    	}
                       

	}
}
