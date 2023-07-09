package Circuit;

import org.apache.commons.math3.complex.Complex;
import ElectricalElement.*;
import VoltageSource.*;

public class TestCircuit {
	
	public static Complex j = new Complex(0, 1);
	
    public static void main(String[] args) {
        SerialCircuit cc = new SerialCircuit();
        Resistor r = new Resistor(4);
        //Inductor l = new Inductor(5);
        Resistor r_ = new Resistor(2);
        Capacitor c = new Capacitor(2*Math.pow(10, -3));
        AC src = new AC(12, 100);
        cc.addElement(c);
        //cc.addElement(l);
        cc.addElement(r);
        cc.addVoltageSource(src);
        
        cc.trigger();
        cc.print();
        System.out.println(cc.getEquivalentResistance());
    }
}