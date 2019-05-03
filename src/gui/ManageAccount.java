package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import Connection.MySQLConnUtils;
import bean.Account;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageAccount extends JFrame {
	MySQLConnUtils mySQLCon = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTextField txtPassword;
	private JTextField txtUsername;
	private JTable tableA;
	private String idAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageAccount frame = new ManageAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void loadDataA() {
		MySQLConnUtils connUtils = new MySQLConnUtils();
		List<Account> accounts = connUtils.getAccounts();

		List<Object[]> list = new ArrayList<Object[]>();
		for (Account account : accounts) {
			String role = "";
			if (account.getRole().equals("1")) {
				role = "Admin";
			}
			if (account.getRole().equals("0")) {
				role = "Saleman";
			}
			list.add(new Object[] { account.getId(), account.getUsername(), account.getPassword(), role });
		}
		tableA.setModel(new DefaultTableModel(list.toArray(new Object[][] {}),
				new String[] { "ID", "User name", "Password", "Role" }));
	}

	/**
	 * Create the frame.
	 */
	public ManageAccount() {
		setTitle("Quản Lý Tài Khoản");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1085, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(238, 207, 161));
		contentPane.setLayout(null);
		
		txtPassword = new JTextField();
		txtPassword.setHorizontalAlignment(SwingConstants.TRAILING);
		txtPassword.setForeground(Color.BLACK);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPassword.setColumns(10);
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(805, 584, 250, 38);
		contentPane.add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPassword.setBounds(636, 584, 157, 31);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.TRAILING);
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtUsername.setColumns(10);
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(177, 584, 250, 38);
		contentPane.add(txtUsername);
		
		JLabel lblRole = new JLabel("Role:");
		lblRole.setForeground(Color.BLACK);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRole.setBounds(12, 635, 157, 31);
		contentPane.add(lblRole);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUsername.setBounds(12, 584, 157, 31);
		contentPane.add(lblUsername);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 1043, 476);
		contentPane.add(scrollPane);
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setForeground(Color.BLACK);
		rdbtnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnAdmin.setBounds(177, 631, 99, 35);
		contentPane.add(rdbtnAdmin);
		
		JRadioButton rdbtnSaleman = new JRadioButton("Saleman");
		rdbtnSaleman.setForeground(Color.BLACK);
		rdbtnSaleman.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnSaleman.setBounds(292, 631, 123, 35);
		contentPane.add(rdbtnSaleman);
		
		JButton btnAddA = new JButton("Thêm");
		btnAddA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (!txtUsername.getText().equals("") && !txtPassword.getText().equals("") && !rdbtnAdmin.isSelected() || !rdbtnSaleman.isSelected()) {
						MySQLConnUtils connUtils = new MySQLConnUtils();
						String username = txtUsername.getText();
						String password = txtPassword.getText();
						String role = null;
						if (rdbtnAdmin.isSelected()) {
							role = "1";
						} else if (rdbtnSaleman.isSelected()){
							role = "0";
						}
						connUtils.insertAccount(username, password, role);
						DefaultTableModel model = (DefaultTableModel)tableA.getModel();
						model.setRowCount(0);
						loadDataA();
						JOptionPane.showMessageDialog(null, "Thêm Tài Khoản thành công!!!");
					} else {
						JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin!!!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnAddA.setIcon(new ImageIcon(ManageAccount.class.getResource("/images/add.png")));
		btnAddA.setForeground(Color.BLACK);
		btnAddA.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAddA.setBackground(Color.WHITE);
		btnAddA.setBounds(12, 741, 138, 49);
		contentPane.add(btnAddA);
		
		JButton btnDelA = new JButton("Xóa");
		btnDelA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MySQLConnUtils connUtils = new MySQLConnUtils();
					connUtils.deleteAccount(idAccount);
					DefaultTableModel model = (DefaultTableModel)tableA.getModel();
					model.setRowCount(0);
					loadDataA();
					JOptionPane.showMessageDialog(null, "Xóa Tài Khoản thành công!!!");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnDelA.setIcon(new ImageIcon(ManageAccount.class.getResource("/images/delete.png")));
		btnDelA.setForeground(Color.BLACK);
		btnDelA.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDelA.setBackground(Color.WHITE);
		btnDelA.setBounds(917, 741, 138, 49);
		contentPane.add(btnDelA);
		
		tableA = new JTable();
		tableA.setForeground(Color.BLACK);
		tableA.setRowHeight(30);
		tableA.setSelectionBackground(new Color(1, 198, 83));
		tableA.setSelectionForeground(new Color(255, 255, 255));
		tableA.setGridColor(new Color(255, 255, 255));
		tableA.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		tableA.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					int row = tableA.getSelectedRow();
					String table_click = (tableA.getModel().getValueAt(row, 0).toString());
					String sql = "Select * from accounts where id = '" + table_click + "' ";
					pst = mySQLCon.connect().prepareStatement(sql);
					rs = pst.executeQuery();
					if (rs.next()) {
						idAccount = rs.getString("id");
						txtUsername.setText(rs.getString("username"));
						txtPassword.setText(rs.getString("password"));
						if (rs.getString("role").equals("1")) {
							rdbtnAdmin.setSelected(true);
							rdbtnSaleman.setSelected(false);
						} else {
							rdbtnSaleman.setSelected(true);
							rdbtnAdmin.setSelected(false);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(tableA);
		
		loadDataA();
	}
}
