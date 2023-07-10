package screen;

import Circuit.*;

public class DisplayScreen {
	Circuit circuit;
	
	public DisplayScreen(ParallelCircuit circuit) {
		this.circuit = circuit;
	}
	
	public DisplayScreen(SerialCircuit circuit) {
		this.circuit = circuit;
	}
}
