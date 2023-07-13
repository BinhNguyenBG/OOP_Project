package Circuit;

import ElectricalElement.*;

import org.apache.commons.math3.complex.Complex;

public class ParallelCircuit extends Circuit{
	
	public ParallelCircuit() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void trigger() {
		//get the voltage of the circuit and cast it into Complex
		Complex vol = new Complex(super.getVoltageSource().getVoltage(), 0);
		
		//set voltage of all elements in the circuit equals to the voltage of the source
		for (ElectricalElement e: super.getElements()) {
			e.setVoltage(vol);
		}
		
		//set resistance, current intensity of all elements in the circuit
		for (ElectricalElement e: super.getElements()) {
			if (e instanceof Resistor) {
				e.setCurrentIntensity(vol.divide(e.getResistance()));
			} else if (e instanceof Inductor) {
				//calculate the resistance of the inductor
				Complex lRes = j.multiply(2*Math.PI*super.getVoltageSource().getFrequency()*((Inductor) e).getInductance());
				
				e.setResistance(lRes);
				e.setCurrentIntensity(vol.divide(e.getResistance()));
				if (lRes.getImaginary() == 0) {
					System.out.println("Short circuit detected");
				}
			} else if (e instanceof Capacitor) {
				//calculate the resistance of the capacitor
				Complex cRes = j.multiply(-1.0/(2*Math.PI*super.getVoltageSource().getFrequency()*((Capacitor) e).getCapacitance()));
				
				e.setResistance(cRes);
				e.setCurrentIntensity(vol.divide(cRes));
			}
		}
	}
	
	public Complex getEquivalentResistance() {
		//calculate the inverse of the equivalent resistance
		Complex invRes = new Complex(0, 0);
		
		Complex one = new Complex(1, 0); //cast number 1 into Complex
		
		for (ElectricalElement e: super.getElements()) {
			invRes = invRes.add(one.divide(e.getResistance()));
		}
		return one.divide(invRes);
	}
	
	public void print() {
		System.out.println("***********************ParallelCircuit***********************");
		System.out.println("Electrical Elements:");
		for (ElectricalElement element: super.getElements()) {
			System.out.println(element.toString());
		}
		System.out.println("*************************************************************");
	}
}
