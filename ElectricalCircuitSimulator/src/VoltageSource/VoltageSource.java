package VoltageSource;

public abstract class VoltageSource {
	private double voltage;
	protected double frequency;
	private String volunit;
	protected String frequnit;
	
	public VoltageSource(double voltage, String volunit) {
		this.voltage = voltage;
		this.volunit = volunit;
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
	
	public String getVolunit() {
		return volunit;
	}

	public String getFrequnit() {
		return frequnit;
	}

	public double getSIVoltage() {
		String unit = this.getVolunit();
		if (unit.equals("kV")) {
			return this.getVoltage()*1e3;
		}
		else if (unit.equals("MV")) {
			return this.getVoltage()*1e6;
		}
		else if (unit.equals("mV")) {
			return this.getVoltage()*1e-3;
		}
		else if (unit.equals("µV")) {
			return this.getVoltage()*1e-6;
		}
		else if (unit.equals("nV")) {
			return this.getVoltage()*1e-9;
		}
		return this.getVoltage();
	}
	
	public abstract String toString();
}
