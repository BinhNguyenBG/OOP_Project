package Circuit;

import ElectricalElement.*;

import org.apache.commons.math3.complex.Complex;

public class SerialCircuit extends Circuit{

	public SerialCircuit() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void trigger() {
		
		//set resistance of all elements in the circuit
		for (ElectricalElement e: super.getElements()) {
			if (e instanceof Inductor) {
				//calculate the resistance of the inductor
				Complex lRes = j.multiply(2*Math.PI*super.getVoltageSource().getFrequency()*((Inductor) e).getInductance());
				
				e.setResistance(lRes);				
			} else if (e instanceof Capacitor) {
				//calculate the resistance of the capacitor
				Complex cRes = j.multiply(-1.0/(2*Math.PI*super.getVoltageSource().getFrequency()*((Capacitor) e).getCapacitance()));
				
				e.setResistance(cRes);
			}
		}
		
		//get main current intensity of the circuit
		Complex equiRes = this.getEquivalentResistance();
		Complex curInt = (new Complex(super.getVoltageSource().getVoltage(), 0)).divide(equiRes);
		
		//set current intensity and voltage of all elements
		for (ElectricalElement e: super.getElements()) {
			e.setCurrentIntensity(curInt);
			e.setVoltage(curInt.multiply(e.getResistance()));
		}
		
	}
	
	public Complex getEquivalentResistance() {
		Complex res = new Complex(0, 0);
		for (ElectricalElement e: super.getElements()) {
			res = res.add(e.getResistance());
		}
		return res;
	}
	
	public void print() {
		System.out.println("***********************SerialCircuit***********************");
		System.out.println("Electrical Elements:");
		for (ElectricalElement element: super.getElements()) {
			System.out.println(element.toString());
		}
		System.out.println("***********************************************************");
	}
}
