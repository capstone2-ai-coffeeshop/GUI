package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Connection.MySQLConnUtils;
import bean.Staffs;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;;

public class ManageNV extends JFrame {
	MySQLConnUtils mySQLCon = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTextField txtAccountID;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtFullname;

	private JTable tableNV;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageNV frame = new ManageNV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	public void loadDataNV() {
//		DefaultTableModel model = new DefaultTableModel();
//
//		ResultSet rs = mySQLCon.getData();
//		try {
//			ResultSetMetaData rsMD = rs.getMetaData();
//			int colNumber = rsMD.getColumnCount();
//			String[] arr = new String[colNumber];
//			for (int i = 0; i < colNumber; i++) {
//				arr[i] = rsMD.getColumnName(i + 1);
//			}
//			model.setColumnIdentifiers(arr);
//			while (rs.next()) {
//				for (int i = 0; i < colNumber; i++) {
//					arr[i] = rs.getString(i + 1);
//				}
//				model.addRow(arr);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		tableNV.setModel(model);
//	}

	public void loadDataNV3() { // ngắn gọn, tiêu đề chuẩn, OK? có chớ sao k m, k có lớp dao làm răng có API, ở bên chổ project restful c
		MySQLConnUtils connUtils = new MySQLConnUtils();
		List<Staffs> staffs = connUtils.getStaffs();

		List<Object[]> list = new ArrayList<Object[]>();
		for (Staffs staff : staffs) {
			list.add(new Object[] { staff.getId(), staff.getFullname(), staff.getEmail(), staff.getDateOfBirth(),
					staff.getPhone(), staff.getGender(), staff.getAccountId() });
		}
		tableNV.setModel(new DefaultTableModel(list.toArray(new Object[][] {}),
				new String[] { "ID", "Full name", "Email", "DOB", "Phone number", "Gender", "Account's ID" }));
		
	}

	/**
	 * Create the frame.
	 */
	public ManageNV() {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		setTitle("Qu\u1EA3n L\u00FD Nh\u00E2n Vi\u00EAn");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1085, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(238, 207, 161));
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setForeground(Color.BLACK);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblID.setBounds(12, 533, 157, 31);
		contentPane.add(lblID);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setHorizontalAlignment(SwingConstants.TRAILING);
		txtID.setForeground(Color.BLACK);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtID.setColumns(10);
		txtID.setBackground(Color.WHITE);
		txtID.setBounds(177, 533, 250, 38);
		contentPane.add(txtID);

		txtAccountID = new JTextField();
		txtAccountID.setHorizontalAlignment(SwingConstants.TRAILING);
		txtAccountID.setForeground(Color.BLACK);
		txtAccountID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtAccountID.setColumns(10);
		txtAccountID.setBackground(Color.WHITE);
		txtAccountID.setBounds(805, 635, 250, 38);
		contentPane.add(txtAccountID);

		txtPhone = new JTextField();
		txtPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		txtPhone.setForeground(Color.BLACK);
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPhone.setColumns(10);
		txtPhone.setBackground(Color.WHITE);
		txtPhone.setBounds(805, 584, 250, 38);
		contentPane.add(txtPhone);

		JDateChooser txtDOB = new JDateChooser();
		txtDOB.setForeground(Color.BLACK);
		txtDOB.setDateFormatString("dd/MM/yyyy");
		txtDOB.setBounds(805, 533, 250, 38);
		contentPane.add(txtDOB);

		JLabel lblDOB = new JLabel("Date of birth:");
		lblDOB.setForeground(Color.BLACK);
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDOB.setBounds(636, 533, 157, 31);
		contentPane.add(lblDOB);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPhone.setBounds(636, 584, 157, 31);
		contentPane.add(lblPhone);

		JLabel lblAccountID = new JLabel("AccountID:");
		lblAccountID.setForeground(Color.BLACK);
		lblAccountID.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAccountID.setBounds(636, 635, 157, 31);
		contentPane.add(lblAccountID);

		JRadioButton rdbtnFemale = new JRadioButton("FeMale");
		rdbtnFemale.setForeground(Color.BLACK);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnFemale.setBackground(Color.WHITE);
		rdbtnFemale.setBounds(296, 686, 105, 31);
		contentPane.add(rdbtnFemale);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(177, 635, 250, 38);
		contentPane.add(txtEmail);

		txtFullname = new JTextField();
		txtFullname.setHorizontalAlignment(SwingConstants.TRAILING);
		txtFullname.setForeground(Color.BLACK);
		txtFullname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtFullname.setColumns(10);
		txtFullname.setBackground(Color.WHITE);
		txtFullname.setBounds(177, 584, 250, 38);
		contentPane.add(txtFullname);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(Color.BLACK);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setBounds(177, 686, 79, 31);
		contentPane.add(rdbtnMale);

		JButton btnAddNV = new JButton("Thêm");
		btnAddNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MySQLConnUtils connUtils = new MySQLConnUtils();
					String fullname = txtFullname.getText();
					String email = txtEmail.getText();
					String gender = null;
					if (rdbtnMale.isSelected()) {
						gender = "1";
					} else if (rdbtnFemale.isSelected()){
						gender = "0";
					}
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String dOB = df.format(txtDOB.getDate());
					String phone = txtPhone.getText();
					String accountID = txtAccountID.getText();
					connUtils.insertStaff(fullname, email, gender, dOB, phone, accountID);
					DefaultTableModel model = (DefaultTableModel)tableNV.getModel();
					model.setRowCount(0);
					loadDataNV3();
					JOptionPane.showMessageDialog(null, "Thêm Nhân Viên thành công!!!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnAddNV.setForeground(Color.BLACK);
		btnAddNV.setBackground(Color.WHITE);
		btnAddNV.setIcon(new ImageIcon(ManageNV.class.getResource("/images/add.png")));
		btnAddNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAddNV.setBounds(12, 741, 138, 49);
		contentPane.add(btnAddNV);
		
		JButton btnEditNV = new JButton("Sửa");
		btnEditNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MySQLConnUtils connUtils = new MySQLConnUtils();
					String gender = null;
					if (rdbtnMale.isSelected()) {
						gender = "1";
					} else if (rdbtnFemale.isSelected()){
						gender = "0";
					}
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String dOB = df.format(txtDOB.getDate());
					connUtils.updateStaff(txtID.getText(), txtFullname.getText(), txtEmail.getText(), gender, dOB, txtPhone.getText());
					DefaultTableModel model = (DefaultTableModel)tableNV.getModel();
					model.setRowCount(0);
					loadDataNV3();
					JOptionPane.showMessageDialog(null, "Sửa Nhân Viên thành công!!!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnEditNV.setBackground(Color.WHITE);
		btnEditNV.setIcon(new ImageIcon(ManageNV.class.getResource("/images/edit.png")));
		btnEditNV.setForeground(Color.BLACK);
		btnEditNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEditNV.setBounds(461, 741, 138, 49);
		contentPane.add(btnEditNV);
		
		JButton btnDelNV = new JButton("Xóa");
		btnDelNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MySQLConnUtils connUtils = new MySQLConnUtils();
					connUtils.deleteStaff(txtID.getText());
					DefaultTableModel model = (DefaultTableModel)tableNV.getModel();
					model.setRowCount(0);
					loadDataNV3();
					JOptionPane.showMessageDialog(null, "Xóa Nhân Viên thành công!!!");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnDelNV.setBackground(Color.WHITE);
		btnDelNV.setIcon(new ImageIcon(ManageNV.class.getResource("/images/delete.png")));
		btnDelNV.setForeground(Color.BLACK);
		btnDelNV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDelNV.setBounds(917, 741, 138, 49);
		contentPane.add(btnDelNV);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGender.setBounds(12, 686, 157, 31);
		contentPane.add(lblGender);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEmail.setBounds(12, 635, 157, 31);
		contentPane.add(lblEmail);

		JLabel lblFullname = new JLabel("Fullname:");
		lblFullname.setForeground(Color.BLACK);
		lblFullname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblFullname.setBounds(12, 584, 157, 31);
		contentPane.add(lblFullname);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 1043, 476);
		contentPane.add(scrollPane);

		tableNV = new JTable();
		tableNV.setForeground(Color.BLACK);
		tableNV.setRowHeight(30);
		tableNV.setSelectionBackground(new Color(1, 198, 83));
		tableNV.setSelectionForeground(new Color(255, 255, 255));
		tableNV.setGridColor(new Color(255, 255, 255));
		tableNV.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		tableNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = tableNV.getSelectedRow();
					String table_click = (tableNV.getModel().getValueAt(row, 0).toString());
					String sql = "Select * from staffs where id = '" + table_click + "' ";
					pst = mySQLCon.connect().prepareStatement(sql);
					rs = pst.executeQuery();
					if (rs.next()) {
						txtID.setText(rs.getString("id"));
						txtFullname.setText(rs.getString("full_name"));
						txtEmail.setText(rs.getString("email"));
						if (rs.getString("gender").equals("1")) {
							rdbtnMale.setSelected(true);
							rdbtnFemale.setSelected(false);
						} else {
							rdbtnFemale.setSelected(true);
							rdbtnMale.setSelected(false);
						}
						Date dOB = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("date_of_birth"));
						txtDOB.setDate(dOB);
						txtPhone.setText(rs.getString("phone"));
						txtAccountID.setText(rs.getString("account_id"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(tableNV);
		

		loadDataNV3();
//		Staffs s = new Staffs();
//		showFields(s);
	}
}
