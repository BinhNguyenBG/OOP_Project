package VoltageSource;

public class DC extends VoltageSource{
	
	public DC(double voltage, String volunit) {
		super(voltage, volunit);
		this.frequency = 0;
	}
	
	public String toString() {
		return ("DC: " + super.getVoltage() + "V");
	}
}
