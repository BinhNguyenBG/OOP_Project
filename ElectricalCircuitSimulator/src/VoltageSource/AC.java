package VoltageSource;

public class AC extends VoltageSource{
	private String frequnit;	
	
	public AC(double voltage, String volunit, double frequency, String frequnit) {
		super(voltage, volunit);
		this.frequency = frequency;
		this.frequnit = frequnit;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	
	public String toString() {
		return ("AC: " + super.getVoltage() + "V, " + this.frequency + " Hz");
	}

	public double getSIFrequency() {
		String unit = this.getFrequnit();
		if (frequnit.equals("kHz")) {
			return this.getFrequency()*1e3;
		}
		else if (frequnit.equals("MHz")) {
			return this.getFrequency()*1e6;
		}
		else if (frequnit.equals("GHz")) {
			return this.getFrequency()*1e9;
		}
		else if (frequnit.equals("THz")) {
			return this.getFrequency()*1e12;
		}
		return this.getFrequency();
	}
}
