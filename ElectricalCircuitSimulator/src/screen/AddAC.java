package screen;

import java.awt.Dimension;

import javax.swing.*;

import VoltageSource.AC;

public class AddAC extends AddComponent{
	private JTextField optparameter = new JTextField();
	private JComboBox<String> optunit = new JComboBox<>();
	
	public AddAC() {
		super();
		
		this.setName("AC");
		this.getUnit().addItem("V");
		this.getUnit().addItem("kV");
		this.getUnit().addItem("MV");
		this.getUnit().addItem("mV");
		this.getUnit().addItem("µV");
		this.getUnit().addItem("nV");
		
		this.construct();

		this.setMaximumSize(new Dimension(500, 200));
		
		this.add(Box.createVerticalStrut(5));
		
		JPanel optcenter = new JPanel();
		optcenter.setLayout(new BoxLayout(optcenter, BoxLayout.X_AXIS));
		optcenter.add(Box.createHorizontalStrut(30));
		optcenter.add(optparameter);
		optunit.addItem("Hz");
		optunit.addItem("kHz");
		optunit.addItem("MHz");
		optunit.addItem("GHz");
		optunit.addItem("THz");
		optcenter.add(optunit);
		
		this.add(optcenter);
	}
	
	@Override
	public boolean blankInput() {
		if (super.blankInput() && optparameter.equals("")) {
			return true;
		}
		return false;
	}
	
	public double getMoreDoubleParameter() {
		return Double.parseDouble(optparameter.getText());
	}
}
