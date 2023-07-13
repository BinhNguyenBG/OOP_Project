package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import Circuit.Circuit;
import Circuit.SerialCircuit;
import VoltageSource.DC;

public class DCGUI extends ElementGUI{
	private DC dc;
	
	public DCGUI(DC dc, Circuit cc) {
		super(cc);
		this.dc = dc;
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
            g2d.drawLine(50+((250*super.getSeed()-150)/2)+26, 400, 50+((250*super.getSeed()-150)/2)+26+36, 400);
            g2d.drawLine(50+((250*super.getSeed()-150)/2)+26+18, 400-18, 50+((250*super.getSeed()-150)/2)+26+18, 400+18);
            g2d.drawLine(50+((250*super.getSeed()-150)/2)+26+36+26, 400, 50+((250*super.getSeed()-150)/2)+26+36+26+36, 400);
            
          //Draw String:
            g2d.setFont(new Font("Arial", Font.BOLD,30));
    		g2d.drawString((int) dc.getVoltage()+ " V",50+((250*super.getSeed()-150)/2)+40,330); 
            
    	} else {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(5); // Set the line width to 5 pixels
            g2d.setStroke(stroke);
            
            g2d.drawLine(200, 50, 200, 100);
            g2d.drawOval(150, 100, 100, 150);
            g2d.drawLine(200, 250, 200, 300);
            g2d.drawLine(200, 100+26, 200, 100+26+36);
            g2d.drawLine(200+18, 100+26+18, 200-18, 100+26+18);
            g2d.drawLine(200, 100+26+36+26, 200, 100+26+36+26+36);
            
          //Draw String:
            g2d.setFont(new Font("Arial", Font.BOLD,30));
    		g2d.drawString((int) dc.getVoltage()+ " V",260,190); 
    	}
                       

	}
}
