package screen;

import javax.swing.JFrame;
import java.text.DecimalFormat;

import Circuit.*;
import ElectricalElement.ElectricalElement;
import GUI.MainGUI;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DisplayScreen extends JFrame {
	Circuit circuit;
	
	/**
	 * @wbp.parser.constructor
	 */
	public DisplayScreen(ParallelCircuit circuit) {
		this.circuit = circuit;
		circuit.trigger();
		createScreen();
	}
	
	public DisplayScreen(SerialCircuit circuit) {
		this.circuit = circuit;
		circuit.trigger();
		createScreen();
	}
	
	private void createScreen(){
		if (circuit instanceof ParallelCircuit) {
			this.setBounds(200,90,1300,500);
		} else {
			this.setBounds(200,90,1400,800);
		}
		this.setBounds(200,90,1400,800);
        this.setLocation(100, 30);
		this.setSize(1100, 600);
		this.setTitle("Display Screen");
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// Header
		JLabel lblDisplayScreen = new JLabel("Display Circuit");
		lblDisplayScreen.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblDisplayScreen.setBounds(10, 10, 234, 35);
		getContentPane().add(lblDisplayScreen);
		
		// Circuit Diagram:
		addCircuitDiagram();
		
		// Table Analysis:
		addAnalysisTable();
		
		// Equivalent Resistance:
		addEquivalentResistance();
		
		this.setVisible(true);
	}
	private void addCircuitDiagram(){
		JLabel lblCircuitDiagram = new JLabel("Circuit Diagram");
		lblCircuitDiagram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JPanel circuit = new MainGUI(this.circuit);
		circuit.setLayout(null);
		if (this.circuit instanceof ParallelCircuit) {
			lblCircuitDiagram.setBounds(50, 73, 103, 25);
			circuit.setBounds(0,80,1400,350);
		} else {
			lblCircuitDiagram.setBounds(50, 73, 103, 25);
			circuit.setBounds(0,0,1300,500);
		}
		
		getContentPane().add(lblCircuitDiagram);
		this.getContentPane().add(circuit);
	}
	
	private void addAnalysisTable() {
		JLabel lblTable = new JLabel("Circuit Analysis Table");
		JPanel panelTable = new JPanel();
		if (this.circuit instanceof ParallelCircuit) {
			lblTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTable.setBounds(50, 450, 145, 19);
			
			// Create panel to contain table
			panelTable.setBounds(150, 480, 1200,80);
			panelTable.setLayout(new BorderLayout(0, 0));
		} else {
			lblTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTable.setBounds(50, 500, 145, 19);
			
			// Create panel to contain table
			panelTable.setBounds(150, 530,1200,80);
			panelTable.setLayout(new BorderLayout(0, 0));
		}
		getContentPane().add(panelTable);
		getContentPane().add(lblTable);

		JTable table = new JTable();
		table.setLocation(0,0);
		//Set up the table:
		DefaultTableModel model = new DefaultTableModel();
	
		/// Set the column of table:
		int nbElement = this.circuit.getElements().size();
		Object[] columns = new Object[nbElement+3];
		Object[] row1 = new Object[nbElement+3];
		Object[] row2 = new Object[nbElement+3];
		Object[] row3 = new Object[nbElement+3];
		
		// Add some default row, column;
		columns[0] = "Notation";
		columns[1] = "Quantity";
		columns[columns.length-1] = "Unit";
		
		row1[0] = "U";
		row1[1] = "Voltage";
		row1[columns.length-1] = "V";
		
		row2[0] = "I";
		row2[1] = "Current Intensity";
		row2[columns.length-1] = "A";
		
		row3[0] = "R";
		row3[1] = "Resistance";
		row3[columns.length-1] = "Ω";
		
		for (int i = 0; i< nbElement; i++) {
			ElectricalElement ee = this.circuit.getElements().get(i);
			
			columns[i+2] = ee.getName();
			DecimalFormat df = new DecimalFormat("###.####");
			row1[i+2] = df.format(ee.getVoltage().getReal()) + " + " +
					df.format(ee.getVoltage().getImaginary())+"i";
			
			row2[i+2] = df.format(ee.getCurrentIntensity().getReal()) + " + " +
						df.format(ee.getCurrentIntensity().getImaginary())+"i";
			
			row3[i+2] = df.format(ee.getResistance().getReal()) + " + " +
						df.format(ee.getResistance().getImaginary())+"i";
		}
			
		
		model.setColumnIdentifiers(columns);
		model.addRow(row1);
		model.addRow(row2);
		model.addRow(row3);

		table.setPreferredSize(new Dimension(650,400));
		table.setModel(model);
		table.setRowHeight(20);
		table.setEnabled(false);
		table.setFont(new Font("Dialog", Font.PLAIN, 15));
		
        
        
        Dimension d = table.getPreferredSize();
        panelTable.add(table.getTableHeader(), BorderLayout.NORTH);
        panelTable.add(table, BorderLayout.CENTER);
        panelTable.setPreferredSize(new Dimension(d.width, table.getRowHeight()*4));
	}
	
	private void addEquivalentResistance() {
		JLabel lblEqResistance = new JLabel("Equivalent Resistance:");
		lblEqResistance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		DecimalFormat df = new DecimalFormat("###.####");
		String result = df.format(this.circuit.getEquivalentResistance().getReal()) + " + " +
		df.format(this.circuit.getEquivalentResistance().getImaginary())+"i";
		JLabel lblTotalResistance = new JLabel(result +" Ω");
		lblTotalResistance.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		if (this.circuit instanceof ParallelCircuit) {
			lblEqResistance.setBounds(50,600, 150, 19);
			lblTotalResistance.setBounds(207,600, 500, 19);
		} else {
			lblEqResistance.setBounds(50,650, 150, 19);
			lblTotalResistance.setBounds(207,650, 500, 19);
		}
		getContentPane().add(lblTotalResistance);
		getContentPane().add(lblEqResistance);

	}
		
}
