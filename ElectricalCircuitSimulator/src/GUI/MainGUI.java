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

public class MainGUI extends JPanel{
	
	private Circuit circuit;
		
	public MainGUI(Circuit circuit) {
		this.circuit = circuit;
        
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
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

}