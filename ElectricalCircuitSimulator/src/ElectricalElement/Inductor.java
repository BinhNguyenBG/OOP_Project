package ElectricalElement;

public class Inductor extends ElectricalElement{
	private double inductance;
		
	public Inductor() {
		// TODO Auto-generated constructor stub
		super();
		String lName = String.format("L%s", super.getNbElement());
		super.setName(lName);
	}
	
	public Inductor(double inductance) {
		this();
		this.inductance = inductance;
	}

	public double getInductance() {
		return inductance;
	}

	public void setInductance(double inductance) {
		this.inductance = inductance;
	}
	
	public String toString() {
		return (super.getName() + " = " + this.inductance + "H, U = " + super.getVoltage().getReal() + "+" + super.getVoltage().getImaginary() +"i V, I = " + super.getCurrentIntensity().getReal() + "+" + super.getCurrentIntensity().getImaginary() + "i A, R_L = " + super.getResistance().getReal() + "+" + super.getResistance().getImaginary()+"i ohm");
	}

}
