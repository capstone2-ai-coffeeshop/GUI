package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;

public class PanelHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHome() {
		setForeground(Color.BLACK);
		setBackground(new Color(238, 207, 161));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1395, 875);
		panel.setBackground(new Color(0, 0, 0, 200));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1395, 875);
		add(label);
		label.setIcon(new ImageIcon(PanelHome.class.getResource("/images/bgcoffee3.jpg")));

	}

}
