package ElectricalElement;

import org.apache.commons.math3.complex.*;
 
public class TestElement {

	public TestElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resistor r = new Resistor(1);
		Inductor l = new Inductor(2);
		System.out.println(r.getName());
		System.out.println(l.getName());
		System.out.println(r.toString());
	}

}
