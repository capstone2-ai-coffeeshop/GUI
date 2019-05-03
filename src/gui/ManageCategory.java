package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import Connection.MySQLConnUtils;
import bean.ProductCategory;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageCategory extends JFrame {
	MySQLConnUtils connUtils = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDescription;
	private JTable tableCategory;
	
	private DefaultTableModel model;
	private String idProductCategory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCategory frame = new ManageCategory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void loadDataCategory() {
		MySQLConnUtils connUtils = new MySQLConnUtils();
		List<ProductCategory> categorys = connUtils.getProductCategorys();


		List<Object[]> list = new ArrayList<Object[]>();
		for (ProductCategory category : categorys) {
			list.add(new Object[] { category.getId(), category.getName(), category.getDescription(), category.getCreatedAt() });
		}
		tableCategory.setModel(new DefaultTableModel(list.toArray(new Object[][] {}),
				new String[] { "ID", "Name", "Description", "Created At" }));
	}

	/**
	 * Create the frame.
	 */
	public ManageCategory() {
		setTitle("Qu\u1EA3n L\u00FD Danh M\u1EE5c S\u1EA3n Ph\u1EA9m");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1085, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(238, 207, 161));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		txtName = new JTextField();
		txtName.setForeground(Color.BLACK);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtName.setColumns(10);
		txtName.setBackground(Color.WHITE);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.BLACK);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		txtDescription = new JTextField();
		txtDescription.setForeground(Color.BLACK);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtDescription.setColumns(10);
		txtDescription.setBackground(Color.WHITE);
		
		JDateChooser txtCreatedAt = new JDateChooser();
		txtCreatedAt.setForeground(Color.BLACK);
		txtCreatedAt.setDateFormatString("dd/MM/yyyy");
		
		JLabel label_5 = new JLabel("Created At:");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JButton btnAddCategory = new JButton("Thêm");
		btnAddCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (!txtName.getText().equals("") && !txtDescription.getText().equals("") && !txtCreatedAt.getDate().equals("")) {
						MySQLConnUtils connUtils = new MySQLConnUtils();
						String name = txtName.getText();
						String description = txtDescription.getText();
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						String dCA = df.format(txtCreatedAt.getDate());
						connUtils.insertProductCategory(name, description, dCA);
						DefaultTableModel model = (DefaultTableModel)tableCategory.getModel();
						model.setRowCount(0);
						loadDataCategory();
						JOptionPane.showMessageDialog(null, "Thêm Danh Mục Sản Phẩm thành công!!!");
					} else {
						JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin!!!");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnAddCategory.setIcon(new ImageIcon(ManageCategory.class.getResource("/images/add.png")));
		btnAddCategory.setForeground(Color.BLACK);
		btnAddCategory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAddCategory.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		
		JButton btnEditCategory = new JButton("Sửa");
		btnEditCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MySQLConnUtils connUtils = new MySQLConnUtils();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String dCA = df.format(txtCreatedAt.getDate());
					connUtils.updateProductCategory(idProductCategory, txtName.getText(), txtDescription.getText(), dCA);
					DefaultTableModel model = (DefaultTableModel)tableCategory.getModel();
					model.setRowCount(0);
					loadDataCategory();
					JOptionPane.showMessageDialog(null, "Sửa Danh Mục Sản Phẩm thành công!!!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnEditCategory.setIcon(new ImageIcon(ManageCategory.class.getResource("/images/edit.png")));
		btnEditCategory.setForeground(Color.BLACK);
		btnEditCategory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEditCategory.setBackground(Color.WHITE);
		
		JButton btnDelCategory = new JButton("Xóa");
		btnDelCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MySQLConnUtils connUtils = new MySQLConnUtils();
					connUtils.deleteProductCategory(idProductCategory);
					DefaultTableModel model = (DefaultTableModel)tableCategory.getModel();
					model.setRowCount(0);
					loadDataCategory();
					JOptionPane.showMessageDialog(null, "Xóa Danh Mục Sản Phẩm thành công!!!");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnDelCategory.setIcon(new ImageIcon(ManageCategory.class.getResource("/images/delete.png")));
		btnDelCategory.setForeground(Color.BLACK);
		btnDelCategory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDelCategory.setBackground(Color.WHITE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tableCategory = new JTable();
		scrollPane.setViewportView(tableCategory);
		tableCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					int row = tableCategory.getSelectedRow();
					String table_click = (tableCategory.getModel().getValueAt(row, 0).toString());
					String sql = "select * from product_category where id = '" + table_click + "'";
					pst = connUtils.connect().prepareStatement(sql);
					rs = pst.executeQuery();
					if (rs.next()) {
						idProductCategory = rs.getString("id");
						txtName.setText(rs.getString("name"));
						txtDescription.setText(rs.getString("description"));
						Date dCA = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("created_at"));
						txtCreatedAt.setDate(dCA);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		tableCategory.setForeground(Color.BLACK);
		tableCategory.setRowHeight(30);
		tableCategory.setSelectionBackground(new Color(1, 198, 83));
		tableCategory.setSelectionForeground(new Color(255, 255, 255));
		tableCategory.setGridColor(new Color(255, 255, 255));
		tableCategory.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(txtCreatedAt, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAddCategory, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
					.addGap(300)
					.addComponent(btnEditCategory, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
					.addGap(329)
					.addComponent(btnDelCategory, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
					.addGap(2))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDescription)
								.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
						.addComponent(label_5)
						.addComponent(txtCreatedAt, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(122)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAddCategory, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditCategory, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelCategory, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		loadDataCategory();
	}
	
}
