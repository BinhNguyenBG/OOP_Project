package ElectricalElement;

import org.apache.commons.math3.complex.*;

public abstract class ElectricalElement {
	private Complex voltage;
	private Complex currentIntensity;
	private Complex resistance;
	private String name;
	private int id;
	private static int nbElement;
	private String unit;
	
	public ElectricalElement() {
		// TODO Auto-generated constructor stub
		nbElement++;
		this.id = nbElement;
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
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getId() {
		return id;
	}
	
	public abstract String toString();
}
