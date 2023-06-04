package VoltageSource;

public abstract class VoltageSource {
	private double voltage;
	protected double frequency;
	
	public VoltageSource(double voltage) {
		this.voltage = voltage;
	}

	public double getVoltage() {
		return voltage;
	}

	public void setVoltage(double voltage) {
		this.voltage = voltage;
	}
	
	public double getFrequency() {
		return this.frequency;
	}
	
	public abstract String toString();
}
