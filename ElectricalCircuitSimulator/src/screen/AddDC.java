package screen;

import VoltageSource.DC;

public class AddDC extends AddComponent{
	
	public AddDC() {
		super();
		
		this.setName("DC");
		this.getUnit().addItem("V");
		this.getUnit().addItem("kV");
		this.getUnit().addItem("MV");
		this.getUnit().addItem("mV");
		this.getUnit().addItem("µV");
		this.getUnit().addItem("nV");
		
		this.construct();
	}
}
