package ElectricalElement;

import org.apache.commons.math3.complex.*;

public abstract class ElectricalElement {
	private Complex voltage;
	private Complex currentIntensity;
	private Complex resistance;
	private String name;
	private static int nbElement;
	
	
	public ElectricalElement() {
		// TODO Auto-generated constructor stub
		nbElement++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Complex getVoltage() {
		return voltage;
	}

	public Complex getCurrentIntensity() {
		return currentIntensity;
	}

	public static int getNbElement() {
		return nbElement;
	}

	public void setVoltage(Complex voltage) {
		this.voltage = voltage;
	}

	public void setCurrentIntensity(Complex curInt) {
		this.currentIntensity = curInt;
	}

	public Complex getResistance() {
		return resistance;
	}

	public void setResistance(Complex resistance) {
		this.resistance = resistance;
	}
	
	public abstract String toString();
}
