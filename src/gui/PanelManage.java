package gui;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Connection.MySQLConnUtils;

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class PanelManage extends JPanel {
	private JTable tableNV;
	private JTable tableSP;
	
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	private JTextField textField;
	private JTextField txtFullname;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAccountID;
	
	private JTextField txtNameSP;
	private JTextField txtUnitprice;
	private JTextField txtDescription;
	private JTextField txtCategoryID;
	private JTextField txtStatus;
	
	private JTextField txtQuantityOC;
	private JTextField txtStatusT;
	private JTextField txtDescriptionT;
	
	MySQLConnUtils mySQLCon = new MySQLConnUtils();
	

	/**
	 * Create the panel.
	 */
	public PanelManage() {
		setBounds(0, 78, 1395, 875);
		setBackground(new Color(238, 207, 161));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(0, 0, 0, 200));
		panel.setBounds(0, 0, 1395, 875);
		add(panel);
		panel.setLayout(null);
		
		JButton btnManageNV = new JButton("Nh\u00E2n Vi\u00EAn");
		btnManageNV.setBackground(Color.WHITE);
		btnManageNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageNV mNV = new ManageNV();
				mNV.setLocationRelativeTo(null);
				mNV.setVisible(true);
			}
		});
		btnManageNV.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnManageNV.setBounds(543, 141, 308, 128);
		btnManageNV.setIcon(new ImageIcon(PanelManage.class.getResource("/images/employee.png")));
		panel.add(btnManageNV);
		
		JButton btnManageSP = new JButton("S\u1EA3n Ph\u1EA9m");
		btnManageSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSP mSP = new ManageSP();
				mSP.setLocationRelativeTo(null);
				mSP.setVisible(true);
			}
		});
		btnManageSP.setBackground(Color.WHITE);
		btnManageSP.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnManageSP.setBounds(543, 331, 308, 128);
		btnManageSP.setIcon(new ImageIcon(PanelManage.class.getResource("/images/product.png")));
		panel.add(btnManageSP);
		
		JButton btnManageAccount = new JButton("Tài Khoản");
		btnManageAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageAccount mA = new ManageAccount();
				mA.setLocationRelativeTo(null);
				mA.setVisible(true);
			}
		});
		btnManageAccount.setIcon(new ImageIcon(PanelManage.class.getResource("/images/account.png")));
		btnManageAccount.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnManageAccount.setBackground(Color.WHITE);
		btnManageAccount.setBounds(543, 522, 308, 128);
		panel.add(btnManageAccount);
		
		JButton btnChangeP = new JButton("Đổi mật khẩu");
		btnChangeP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword cP = new ChangePassword();
				cP.setLocationRelativeTo(null);
				cP.setVisible(true);
			}
		});
		btnChangeP.setForeground(Color.BLACK);
		btnChangeP.setIcon(new ImageIcon(PanelManage.class.getResource("/images/lock.png")));
		btnChangeP.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnChangeP.setBounds(1147, 0, 248, 78);
		btnChangeP.setBackground(Color.WHITE);
		btnChangeP.setBorder(null);
		panel.add(btnChangeP);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1395, 875);
		add(label);
		label.setIcon(new ImageIcon(PanelManage.class.getResource("/images/bgcoffee2.jpg")));
		


	}
}
