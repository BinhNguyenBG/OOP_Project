package screen;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public abstract class AddComponent extends JPanel{
	public static int index = 0;
	
	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		AddComponent.index = index;
	}

	public JTextField getParameter() {
		return parameter;
	}

	public JComboBox<String> getUnit() {
		return unit;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	private JButton button = new JButton();
	
	public JButton getButton() {
		return button;
	}

	private JButton removeBtn() {
		Icon removeIcon = new RemoveIcon();		
		button.setIcon(removeIcon);
		button.setPreferredSize(new Dimension(30, 30));
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		
		return button;
	}
	
	public JButton getRemoveBtn() {
		return removeBtn();
	}
	
	private String name;
	private JTextField parameter = new JTextField();
	private JComboBox<String> unit = new JComboBox<>();
	private String previousText="";
	
	JPanel createHead(){
		JPanel head = new JPanel();
		head.setLayout(new BoxLayout(head, BoxLayout.X_AXIS));
		
		JButton removeBtn = new JButton();
		Icon removeIcon = new RemoveIcon();		
		removeBtn.setIcon(removeIcon);
		removeBtn.setPreferredSize(new Dimension(50, 50));
		removeBtn.setBorderPainted(false);
		removeBtn.setContentAreaFilled(false);
		removeBtn.setFocusPainted(false);
//		removeBtn.setOpaque(false);
		
		head.add(removeBtn);
		
		head.add(Box.createHorizontalGlue());
		
		return head;
	}
	
	public AddComponent() {		
		setVisible(false);
	}
	
	public void construct() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setMaximumSize(new Dimension(500, 100));
		
		add(Box.createVerticalStrut(20));
		
		JPanel label = new JPanel(new FlowLayout(FlowLayout.LEFT));
		label.setLayout(new BoxLayout(label, BoxLayout.X_AXIS));
		label.add(Box.createHorizontalStrut(30));
		label.add(new JLabel(name));
		label.add(Box.createHorizontalGlue());
//		label.setBorder(BorderFactory.createLineBorder(Color.black));
		
		add(label);
		
		add(Box.createVerticalStrut(5));
		
		JPanel center = new JPanel();
		center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
		center.add(removeBtn());
		center.add(parameter);
		parameter.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				handleTextChange();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				previousText = parameter.getText();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			private void handleTextChange() {
			    Runnable doHighlight = new Runnable() {
			        @Override
			        public void run() {
						try {
							double test = Double.parseDouble(parameter.getText());
						} catch (Exception e) {
							parameter.setText(previousText);
						} finally {
							previousText = parameter.getText();
						}
			        }
			    };       
			    SwingUtilities.invokeLater(doHighlight);
			}
			
		});
		center.add(unit);
		
		add(center);
	}
	
	public boolean blankInput() {
		if (parameter.getText().equals("")) {
			return true;
		}
		return false;
	}
	
	public double getDoubleParameter() {
		return Double.parseDouble(parameter.getText());
	}
}

class RemoveIcon implements Icon{

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Perform custom painting here
        x += 17;
        y += 15;
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(2));
        g2.draw(new Ellipse2D.Double(x, y, 10, 10));
        g2.draw(new Line2D.Double(x+3, y+5, x+7, y+5));
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 50;
	}
}