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
		setBounds(0, 0, 1902, 905);
		setBackground(new Color(238, 207, 161));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(0, 0, 0, 200));
		panel.setBounds(0, 0, 1902, 905);
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
		
		JButton btnManageCategory = new JButton("Danh mục");
		btnManageCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageCategory mC = new ManageCategory();
				mC.setLocationRelativeTo(null);
				mC.setVisible(true);
			}
		});
		btnManageCategory.setIcon(new ImageIcon(PanelManage.class.getResource("/images/backend.png")));
		btnManageCategory.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnManageCategory.setBackground(Color.WHITE);
		btnManageCategory.setBounds(979, 141, 308, 128);
		panel.add(btnManageCategory);
		
		JButton btnManageCustomer = new JButton("Khách hàng");
		btnManageCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageCustomer mCus = new ManageCustomer();
				mCus.setLocationRelativeTo(null);
				mCus.setVisible(true);
			}
		});
		btnManageCustomer.setIcon(new ImageIcon(PanelManage.class.getResource("/images/segment.png")));
		btnManageCustomer.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnManageCustomer.setBackground(Color.WHITE);
		btnManageCustomer.setBounds(979, 331, 308, 128);
		panel.add(btnManageCustomer);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1902, 905);
		add(label);
		label.setIcon(new ImageIcon(PanelManage.class.getResource("/images/bgcoffee2.jpg")));
		


	}
}
