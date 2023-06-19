package ElectricalElement;

import org.apache.commons.math3.complex.*;

public class Resistor extends ElectricalElement{

	public Resistor() {
		// TODO Auto-generated constructor stub
		super();
		String rName = String.format("R%s", super.getNbElement());
		super.setName(rName);
	}
	
	public Resistor(double resistance) {
		this();
		super.setResistance(new Complex(resistance, 0));
	}
	
	public String toString() {
		return (super.getName() + " = " + super.getResistance().getReal() + "ohm, U = " + super.getVoltage().getReal() + "+" + super.getVoltage().getImaginary() +"i V, I = " + super.getCurrentIntensity().getReal() + "+" + super.getCurrentIntensity().getImaginary() + "i A");
	}
}
