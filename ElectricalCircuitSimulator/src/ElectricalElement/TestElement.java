package ElectricalElement;

import org.apache.commons.math3.complex.*;

public class TestElement {

	public TestElement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complex z = new Complex(1, 0);
		Resistor r = new Resistor(z);
		Inductor l = new Inductor(2);
		System.out.println(r.getName());
		System.out.println(l.getName());
		System.out.println(r.toString());
	}

}
