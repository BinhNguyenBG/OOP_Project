package screen;

import ElectricalElement.Resistor;

public class AddResistor extends AddComponent{
	
	public AddResistor() {
		super();
		
		index += 1;
		this.setName("R" + index);
		this.getUnit().addItem("Ω");
		this.getUnit().addItem("kΩ");
		this.getUnit().addItem("MΩ");
		
		this.construct();
	}
}
