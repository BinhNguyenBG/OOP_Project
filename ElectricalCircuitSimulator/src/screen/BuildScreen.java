package screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Circuit.*;
import ElectricalElement.*;
import VoltageSource.*;

public class BuildScreen extends JFrame{
	private Circuit circuit = new ParallelCircuit();
	private ArrayList <AddComponent> addcomponents = new ArrayList();
	
	private static int MAX_SOURCE = 1;
	private static int MAX_ELEMENTS = 5;
	
	private int nbSource = 0;
	private int nbElements = 0;
	
	JPanel createEast() {
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(300, 500));
		east.add(Box.createVerticalStrut(350));
		
		JButton done = new JButton("SUBMIT");
		done.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (AddComponent addcomp: addcomponents) {
					if (addcomp.blankInput()) {
						System.out.println("Invalid Input!");
						return;
					}
				}
				
				for (AddComponent addcomp: addcomponents) {
					if (addcomp instanceof AddAC) {
						double voltage = addcomp.getDoubleParameter();
						String volunit = (String)addcomp.getUnit().getSelectedItem();
						
						double frequency = ((AddAC)addcomp).getMoreDoubleParameter();
						String frequnit = (String)((AddAC)addcomp).getOptunit().getSelectedItem();
						
						circuit.addVoltageSource(new AC(voltage, volunit, frequency, frequnit));
					}
					else if (addcomp instanceof AddDC) {
						double voltage = addcomp.getDoubleParameter();
						String volunit = (String)addcomp.getUnit().getSelectedItem();
						
						circuit.addVoltageSource(new DC(voltage, volunit));
					}
					else if (addcomp instanceof AddResistor) {
						double resistance = addcomp.getDoubleParameter();
						String unit = (String)addcomp.getUnit().getSelectedItem();
						
						Resistor resistor = new Resistor(resistance, unit);
						resistor.setName(addcomp.getName());
						circuit.addElement(resistor);
					}
					else if (addcomp instanceof AddCapacitor) {
						double capacitance = addcomp.getDoubleParameter();
						String unit = (String)addcomp.getUnit().getSelectedItem();
						
						Capacitor capacitor = new Capacitor(capacitance, unit);
						capacitor.setName(addcomp.getName());
						circuit.addElement(capacitor);
					}
					else {
						double inductance = addcomp.getDoubleParameter();
						String unit = (String)addcomp.getUnit().getSelectedItem();
						
						Inductor inductor = new Inductor(inductance, unit);
						inductor.setName(addcomp.getName());
						circuit.addElement(inductor);
					}
				}
				
				if (circuit instanceof ParallelCircuit) {
					new DisplayScreen((ParallelCircuit)circuit);
				}
				else {
					new DisplayScreen((SerialCircuit)circuit);
				}
				dispose();
			}
			
		});
		east.add(done);
		
		return east;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
		center.add(createSource());
		center.add(Box.createHorizontalStrut(10));
		center.add(createElements());
		return center;
	}
	
	JPanel createSource() {
		JPanel source = new JPanel();
		source.setMinimumSize(new Dimension(00, 500));
		source.setLayout(new BoxLayout(source, BoxLayout.Y_AXIS));
		
		JPanel addSource = new JPanel();
		addSource.setLayout(new BoxLayout(addSource, BoxLayout.Y_AXIS));
		source.add(addSource);
		
		source.add(Box.createVerticalStrut(120));
		
		JPanel addSourceBtnPane = new JPanel();
		JComboBox<String> sourceOption = new JComboBox<>(new String[] {"AC", "DC"});
		addSourceBtnPane.add(sourceOption);
		JButton addSourceBtn = new JButton("Add Source");
		addSourceBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (nbSource >= MAX_SOURCE) {
					return;
				}
				
				nbSource++;
				
				if (sourceOption.getSelectedItem().equals("AC")) {
					
					AddComponent newAC = new AddAC();
					
					newAC.getButton().addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							nbSource--;
							
							newAC.setVisible(false);
							addcomponents.remove(newAC);
						}
						
					});
					addSource.add(newAC);
					newAC.setVisible(true);
					
					addcomponents.add(newAC);
				}
				else {					
					AddComponent newDC = new AddDC();
					newDC.getButton().addActionListener(new ActionListener() {												

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							nbSource--;
							
							newDC.setVisible(false);							
							addcomponents.remove(newDC);
						}
						
					});
					addSource.add(newDC);
					newDC.setVisible(true);
					
					addcomponents.add(newDC);
				}
			}
			
		});
		addSourceBtnPane.add(Box.createHorizontalStrut(30));
		addSourceBtnPane.add(addSourceBtn);
		source.add(addSourceBtnPane);
		
		source.add(Box.createVerticalGlue());
		
		return source;
	}
	
	JPanel createElements() {
		JPanel elements = new JPanel();
		elements.setLayout(new BoxLayout(elements, BoxLayout.Y_AXIS));
		
		JPanel addElements = new JPanel();
		addElements.setLayout(new BoxLayout(addElements, BoxLayout.Y_AXIS));
		elements.add(addElements);
		
		JPanel addElementsBtnPane = new JPanel();
		addElementsBtnPane.setLayout(new BoxLayout(addElementsBtnPane, BoxLayout.X_AXIS));
		
		JButton addResistorBtn = new JButton("Add Resistor");
		addResistorBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (nbElements >= MAX_ELEMENTS) {
					return;
				}
				nbElements++;
				
				AddComponent newR = new AddResistor();
				newR.getButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						nbElements--;
						
						newR.setVisible(false);
						addcomponents.remove(newR);
					}
					
				});
				addElements.add(newR);
				newR.setVisible(true);
				
				addcomponents.add(newR);
			}
			
		});
		JButton addCapacitorBtn =  new JButton("Add Capacitor");
		addCapacitorBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (nbElements >= MAX_ELEMENTS) {
					return;
				}
				nbElements++;
				
				AddComponent newC = new AddCapacitor();
				newC.getButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						nbElements--;
						
						newC.setVisible(false);
						addcomponents.remove(newC);
					}
					
				});
				addElements.add(newC);
				newC.setVisible(true);
				
				addcomponents.add(newC);
			}
			
		});
		JButton addInductorBtn = new JButton("Add Inductor");
		addInductorBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (nbElements >= MAX_ELEMENTS) {
					return;
				}
				nbElements++;
				
				AddComponent newL = new AddInductor();
				newL.getButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						nbElements--;
						
						newL.setVisible(false);
						addcomponents.remove(newL);
					}
					
				});
				addElements.add(newL);
				newL.setVisible(true);
				
				addcomponents.add(newL);
			}
			
		});
		
		addElementsBtnPane.add(addResistorBtn);
		addElementsBtnPane.add(Box.createHorizontalStrut(10));
		addElementsBtnPane.add(addCapacitorBtn);
		addElementsBtnPane.add(Box.createHorizontalStrut(10));
		addElementsBtnPane.add(addInductorBtn);
		
		elements.add(addElementsBtnPane);
//		elements.add(Box.createVerticalStrut(10));
		
//		JPanel removeElementsBtnPane = new JPanel();
//		removeElementsBtnPane.setLayout(new BoxLayout(removeElementsBtnPane, BoxLayout.X_AXIS));
//		removeElementsBtnPane.add(Box.createHorizontalGlue());
//		JButton removeElementsBtn = new JButton("Remove elements");
//		removeElementsBtnPane.add(removeElementsBtn);
//		
//		elements.add(removeElementsBtnPane);
		
		elements.add(Box.createVerticalGlue());
		
		return elements;
	}
	
	JPanel createParallel() {
		circuit = new ParallelCircuit();
		addcomponents = new ArrayList();
		nbSource = 0;
		nbElements = 0;
		AddComponent.index = 0;
		
		JPanel parallel = new JPanel();
		parallel.setLayout(new BorderLayout());
		parallel.add(createCenter(), BorderLayout.CENTER);
		parallel.add(createEast(), BorderLayout.EAST);
		return parallel;
	}
	
	JPanel createSerial() {
		circuit = new SerialCircuit();
		addcomponents = new ArrayList();
		nbSource = 0;
		nbElements = 0;
		AddComponent.index = 0;
		
		JPanel series = new JPanel();
		series.setLayout(new BorderLayout());
		series.add(createCenter(), BorderLayout.CENTER);
		series.add(createEast(), BorderLayout.EAST);
		return series;
	}
	
	JTabbedPane createTabbedPane(){
		JTabbedPane tabpane = new JTabbedPane();
		tabpane.addTab("Parallel Circuit", createParallel());
		tabpane.addTab("Serial Circuit", createSerial());
		tabpane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				String title = tabpane.getTitleAt(tabpane.getSelectedIndex());
				if (title.equals("Parallel Circuit")) {
					tabpane.setComponentAt(0, createParallel());
					circuit = new ParallelCircuit();
				} else if (title.equals("Serial Circuit")) {
					tabpane.setComponentAt(1, createSerial());
					circuit = new SerialCircuit();
				}
			}			
		});
		return tabpane;
	}
	
	public BuildScreen() {
		Container cp = getContentPane();
		cp.add(createTabbedPane());
        setLocation(100, 30);
		setVisible(true);
		setTitle("Electrical circuit simulator");
		setSize(1100, 600);
	}
}
