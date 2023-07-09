package GUI;

import java.awt.Graphics;

import Circuit.Circuit;

public abstract class ElementGUI {
	
	private Circuit circuit;
	private int seed;
	
	public ElementGUI(Circuit cc) {
		this.circuit = cc;
		this.seed = cc.getElements().size();	
	}
	
	public Circuit getCircuit() {
		return this.circuit;
	}
	
	public int getSeed() {
		return this.seed;
	}
	
	public abstract void draw(Graphics g);
}
