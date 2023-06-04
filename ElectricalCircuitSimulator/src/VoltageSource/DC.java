package VoltageSource;

public class DC extends VoltageSource{
	
	public DC(double voltage) {
		super(voltage);
		this.frequency = 0;
	}
	
	public String toString() {
		return ("DC: " + super.getVoltage() + "V");
	}
}
