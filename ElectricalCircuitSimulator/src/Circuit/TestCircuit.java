package Circuit;

import org.apache.commons.math3.complex.Complex;
import ElectricalElement.*;
import VoltageSource.*;

public class TestCircuit {
    public static void main(String[] args) {
        SerialCircuit cc = new SerialCircuit();
        Resistor r = new Resistor(new Complex(4, 0));
        //Inductor l = new Inductor(5);
        Resistor r_ = new Resistor(new Complex(2, 0));
        Capacitor c = new Capacitor(2*Math.pow(10, -3));
        AC src = new AC(12, 100);
        cc.addElement(c);
        //cc.addElement(l);
        cc.addElement(r);
        cc.setVoltageSource(src);
        
        cc.trigger();
        cc.print();
        System.out.println(cc.getEquivalentResistance());
    }
}