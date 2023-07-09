package GUI;

import javax.swing.*;

import Circuit.Circuit;
import Circuit.ParallelCircuit;
import Circuit.SerialCircuit;
import ElectricalElement.Capacitor;
import ElectricalElement.ElectricalElement;
import ElectricalElement.Inductor;
import ElectricalElement.Resistor;
import VoltageSource.AC;
import VoltageSource.DC;
import VoltageSource.VoltageSource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame{
	
	private Circuit circuit;
		
	public MainGUI(Circuit circuit) {
		this.circuit = circuit;
		
		Container cp = getContentPane();
		cp.setLayout(null);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the closing operation
        setSize(1400, 800); // Set the size of the frame
        setTitle("MainGUI");
        setVisible(true); 
        
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for (ElectricalElement e: circuit.getElements()) {
			if (e instanceof Resistor) {
				ResistorGUI r_GUI = new ResistorGUI((Resistor)e, circuit);
				r_GUI.draw(g);
			} else if (e instanceof Capacitor) {
				CapacitorGUI c_GUI = new CapacitorGUI((Capacitor) e, circuit);
				c_GUI.draw(g);
			} else {
				InductorGUI i_GUI = new InductorGUI((Inductor) e, circuit);
				i_GUI.draw(g);
			}
		}
		
		VoltageSource src = circuit.getVoltageSource();
		if (src instanceof AC) {
			ACGUI src_GUI = new ACGUI((AC)src, circuit);
			src_GUI.draw(g);
		} else {
			DCGUI src_GUI = new DCGUI((DC) src, circuit);
			src_GUI.draw(g);
		}
	}

	
	

	public static void main(String[] args) {
		Inductor i1 = new Inductor(30);
		Resistor r2 = new Resistor(30);
		Capacitor c3 = new Capacitor(30);
		Capacitor c4 = new Capacitor(30);
		Resistor r5 = new Resistor(30);
		AC src = new AC(20,20);
		ParallelCircuit cc = new ParallelCircuit();
		cc.addElement(i1);
		cc.addElement(r2);
		cc.addElement(c3);
		cc.addElement(c4);
		cc.addElement(r5);
		cc.addVoltageSource(src);
		new MainGUI(cc);
	}
}
