package screen;

import ElectricalElement.Inductor;

public class AddInductor extends AddComponent{
	
	public AddInductor() {
		super();
		
		index += 1;
		this.setName("L" + index);
		this.getUnit().addItem("H");
		this.getUnit().addItem("mH");
		this.getUnit().addItem("µH");
		this.getUnit().addItem("nH");
		this.getUnit().addItem("pH");
		
		this.construct();
	}
}
