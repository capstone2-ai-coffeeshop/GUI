package gui;

import java.awt.Color;

import javax.swing.JPanel;

import files.JsonReader;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Font;


public class PanelHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHome() {
		setForeground(Color.BLACK);
		setBackground(new Color(238, 207, 161));
		setBounds(0, 0, 1902, 905);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1902, 905);
		panel.setBackground(new Color(0, 0, 0));
		add(panel);
		panel.setLayout(null);


	}
}
