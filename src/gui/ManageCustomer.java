package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Connection.MySQLConnUtils;
import bean.Customer;

import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageCustomer extends JFrame {
	MySQLConnUtils connUtils = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTextField txtFullname;
	private JTextField txtPhone;
	private JTable tableCus;
	private JTextField txtEmail;
	
	private String idCustomer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCustomer frame = new ManageCustomer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void loadDataCus() { 
		MySQLConnUtils connUtils = new MySQLConnUtils();
		List<Customer> customers = connUtils.getCustomers();

		List<Object[]> list = new ArrayList<Object[]>();
		for (Customer customer : customers) {
			String gender = "";
			if (customer.getGender().equals("1")) {
				gender = "Male";
			}
			if (customer.getGender().equals("0")) {
				gender = "Female";
			}
			list.add(new Object[] { customer.getId(), customer.getFullname(), customer.getEmail(), gender,  customer.getDateOfBirth(),
					customer.getPhone() });
		}
		tableCus.setModel(new DefaultTableModel(list.toArray(new Object[][] {}),
				new String[] { "ID", "Full name", "Email", "Gender", "DOB", "Phone" }));
		
	}

	/**
	 * Create the frame.
	 */
	public ManageCustomer() {
		setTitle("Qu\u1EA3n L\u00FD Kh\u00E1ch H\u00E0ng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1085, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(238, 207, 161));
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setForeground(Color.BLACK);
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		txtFullname = new JTextField();
		txtFullname.setForeground(Color.BLACK);
		txtFullname.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtFullname.setColumns(10);
		txtFullname.setBackground(Color.WHITE);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnAddCustomer = new JButton("Thêm");
		btnAddCustomer.setIcon(new ImageIcon(ManageCustomer.class.getResource("/images/add.png")));
		btnAddCustomer.setForeground(Color.BLACK);
		btnAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAddCustomer.setBackground(Color.WHITE);
		
		JButton btnEditCustomer = new JButton("Sửa");
		btnEditCustomer.setIcon(new ImageIcon(ManageCustomer.class.getResource("/images/edit.png")));
		btnEditCustomer.setForeground(Color.BLACK);
		btnEditCustomer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEditCustomer.setBackground(Color.WHITE);
		
		JLabel lblDOB = new JLabel("DOB:");
		lblDOB.setForeground(Color.BLACK);
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		txtPhone = new JTextField();
		txtPhone.setForeground(Color.BLACK);
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtPhone.setColumns(10);
		txtPhone.setBackground(Color.WHITE);
		
		JButton btnDelCustomer = new JButton("Xóa");
		btnDelCustomer.setIcon(new ImageIcon(ManageCustomer.class.getResource("/images/delete.png")));
		btnDelCustomer.setForeground(Color.BLACK);
		btnDelCustomer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDelCustomer.setBackground(Color.WHITE);
		
		JDateChooser txtDOB = new JDateChooser();
		txtDOB.setForeground(Color.BLACK);
		txtDOB.setDateFormatString("dd/MM/yyyy");
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(Color.BLACK);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnMale.setBackground(Color.WHITE);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setForeground(Color.BLACK);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnFemale.setBackground(Color.WHITE);
		tableCus = new JTable();
		tableCus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					int row = tableCus.getSelectedRow();
					String table_click = (tableCus.getModel().getValueAt(row, 0).toString());
					String sql = "select * from customers where id = '" + table_click + "'";
					pst = connUtils.connect().prepareStatement(sql);
					rs = pst.executeQuery();
					if (rs.next()) {
						idCustomer = rs.getString("id");
						txtFullname.setText(rs.getString("full_name"));
						txtEmail.setText(rs.getString("email"));
						if (rs.getString("gender").equals("1")) {
							rdbtnMale.setSelected(true);
							rdbtnFemale.setSelected(false);
						} else {
							rdbtnFemale.setSelected(true);
							rdbtnMale.setSelected(false);
						}
						Date dCA = new SimpleDateFormat("yyyy/MM/dd").parse(rs.getString("date_of_birth"));
						txtDOB.setDate(dCA);
						txtPhone.setText(rs.getString("phone"));
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		tableCus.setForeground(Color.BLACK);
		tableCus.setRowHeight(30);
		tableCus.setSelectionBackground(new Color(1, 198, 83));
		tableCus.setSelectionForeground(new Color(255, 255, 255));
		tableCus.setGridColor(new Color(255, 255, 255));
		tableCus.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		scrollPane.setViewportView(tableCus);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDOB, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(txtDOB, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAddCustomer, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
							.addGap(300)
							.addComponent(btnEditCustomer, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
							.addGap(329)
							.addComponent(btnDelCustomer, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
									.addGap(8))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFullname, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnMale, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(41)
									.addComponent(rdbtnFemale)))
							.addPreferredGap(ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))))
					.addGap(7))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFullName)
						.addComponent(txtFullname, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPhone)
								.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDOB)
								.addComponent(txtDOB, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(68)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnEditCustomer, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnAddCustomer, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
								.addComponent(btnDelCustomer, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addGap(8))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnMale, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGender))
							.addGap(178))))
		);
		contentPane.setLayout(gl_contentPane);
		
		loadDataCus();
	}
}
