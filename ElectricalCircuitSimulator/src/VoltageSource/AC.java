package VoltageSource;

public class AC extends VoltageSource{
	
	public AC(double voltage, double frequency) {
		super(voltage);
		this.frequency = frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	
	public String toString() {
		return ("AC: " + super.getVoltage() + "V, " + this.frequency + " Hz");
	}

}
