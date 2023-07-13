package ElectricalElement;

public class Capacitor extends ElectricalElement{
	private double capacitance;

	public Capacitor() {
		// TODO Auto-generated constructor stub
		super();
		String cName = String.format("C%s", super.getNbElement());
		super.setName(cName);
	}
	
	public Capacitor(double capacitance, String unit) {
		this();
		this.capacitance = capacitance;
		this.setUnit(unit);
	}

	public double getCapacitance() {
		return capacitance;
	}

	public void setCapacitance(double capacitance) {
		this.capacitance = capacitance;
	}
	
	public double getSICapitance() {
		if (this.getUnit().equals("mF")) {
			return capacitance*1e-3;
		}
		else if (this.getUnit().equals("µF")) {
			return capacitance*1e-6;
		}
		else if (this.getUnit().equals("nF")) {
			return capacitance*1e-9;
		}
		else if (this.getUnit().equals("pF")) {
			return capacitance*1e-12;
		}
		return capacitance;
	}
	
	public String toString() {
		return (super.getName() + " = " + this.capacitance + "F, U = " + super.getVoltage().getReal() + "+" + super.getVoltage().getImaginary() + "i V, I = " + super.getCurrentIntensity().getReal() + "+" + super.getCurrentIntensity().getImaginary() + "i A, R_C = " + super.getResistance().getReal() + "+" + super.getResistance().getImaginary() + "i ohm");
	}
}
