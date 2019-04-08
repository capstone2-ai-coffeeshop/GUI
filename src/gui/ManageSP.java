package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import Connection.MySQLConnUtils;
import bean.Products;
import gui.PanelStatistical.NumberTableCellRenderer;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ManageSP extends JFrame {
	MySQLConnUtils connUtils = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTable tableSP;
	private JTextField txtDescription;
	private JTextField txtUnitprice;
	private JTextField txtName;
	private JTextField txtStatus;
	private JDateChooser txtCreatedAt;
	private JComboBox cbbCategoryName;
	private String idProduct;
	private String nameCategory;
	private String idCategory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSP frame = new ManageSP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public class NumberTableCellRenderer extends DefaultTableCellRenderer {

        public NumberTableCellRenderer() {
            setHorizontalAlignment(JLabel.LEFT);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Number) {
                value = NumberFormat.getNumberInstance().format(value);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

    }
	
	public void loadDataSP() {
		MySQLConnUtils connUtils = new MySQLConnUtils();
		List<Products> products = connUtils.getProducts();

		List<Object[]> list = new ArrayList<Object[]>();
		for (Products product : products) {
			try {
				String sqlABC = "select * from product_category where id = '" + product.getCategoryId() + "'";
				pst = connUtils.connect().prepareStatement(sqlABC);
				rs = pst.executeQuery();
				if (rs.next()) {
					nameCategory = rs.getString("name");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			list.add(new Object[] { product.getId(), product.getName(), nameCategory, product.getUnitPrice(),
					product.getDescription(), product.getStatus(), product.getCreatedAt() });
		}
		tableSP.setModel(new DefaultTableModel(list.toArray(new Object[][] {}),
				new String[] { "ID", "Name", "Category Name", "Unitprice", "Description", "Status", "Created At" }));
		tableSP.getColumnModel().getColumn(3).setCellRenderer(new NumberTableCellRenderer());
	}

	/**
	 * Create the frame.
	 */
	public ManageSP() {
		setTitle("Qu\u1EA3n L\u00FD S\u1EA3n Ph\u1EA9m");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1085, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(238, 207, 161));
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 1043, 476);
		contentPane.add(scrollPane);
		
		txtDescription = new JTextField();
		txtDescription.setForeground(Color.BLACK);
		txtDescription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtDescription.setColumns(10);
		txtDescription.setBackground(Color.WHITE);
		txtDescription.setBounds(805, 584, 250, 38);
		contentPane.add(txtDescription);
		
		JLabel lblCategoryName = new JLabel("Category Name:");
		lblCategoryName.setForeground(Color.BLACK);
		lblCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCategoryName.setBounds(614, 533, 179, 31);
		contentPane.add(lblCategoryName);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setForeground(Color.BLACK);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDescription.setBounds(636, 584, 157, 31);
		contentPane.add(lblDescription);
		
		JLabel lblCreatedAt = new JLabel("Created At:");
		lblCreatedAt.setForeground(Color.BLACK);
		lblCreatedAt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCreatedAt.setBounds(636, 635, 157, 31);
		contentPane.add(lblCreatedAt);
		
		txtUnitprice = new JTextField();
		txtUnitprice.setForeground(Color.BLACK);
		txtUnitprice.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtUnitprice.setColumns(10);
		txtUnitprice.setBackground(Color.WHITE);
		txtUnitprice.setBounds(177, 584, 250, 38);
		contentPane.add(txtUnitprice);
		
		txtName = new JTextField();
		txtName.setForeground(Color.BLACK);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtName.setColumns(10);
		txtName.setBackground(Color.WHITE);
		txtName.setBounds(177, 533, 250, 38);
		contentPane.add(txtName);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblStatus.setBounds(12, 635, 157, 31);
		contentPane.add(lblStatus);
		
		JLabel lblUnitprice = new JLabel("Unitprice:");
		lblUnitprice.setForeground(Color.BLACK);
		lblUnitprice.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblUnitprice.setBounds(12, 584, 157, 31);
		contentPane.add(lblUnitprice);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblName.setBounds(12, 533, 157, 31);
		contentPane.add(lblName);
		
		txtStatus = new JTextField();
		txtStatus.setForeground(Color.BLACK);
		txtStatus.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtStatus.setColumns(10);
		txtStatus.setBackground(Color.WHITE);
		txtStatus.setBounds(177, 635, 250, 38);
		contentPane.add(txtStatus);
		
		txtCreatedAt = new JDateChooser();
		txtCreatedAt.setDateFormatString("dd/MM/yyyy");
		txtCreatedAt.setForeground(Color.BLACK);
		txtCreatedAt.setBounds(805, 635, 250, 38);
		contentPane.add(txtCreatedAt);
		
		cbbCategoryName = new JComboBox();
		cbbCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbbCategoryName.setEditable(true);
		cbbCategoryName.setForeground(Color.BLACK);
		cbbCategoryName.setBounds(805, 533, 250, 38);
		try {
			String sql = "select * from product_category";
			pst = connUtils.connect().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				cbbCategoryName.addItem(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		contentPane.add(cbbCategoryName);
		
		JButton btnAddSP = new JButton("Thêm");
		btnAddSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MySQLConnUtils connUtils = new MySQLConnUtils();
					String name = txtName.getText();
					String unitprice = txtUnitprice.getText();
					String description = txtDescription.getText();
					String status = txtStatus.getText();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String dCA = df.format(txtCreatedAt.getDate());
					connUtils.insertProduct(name, idCategory, unitprice, description, status, dCA);
					DefaultTableModel model = (DefaultTableModel)tableSP.getModel();
					model.setRowCount(0);
					loadDataSP();
					JOptionPane.showMessageDialog(null, "Thêm Sản Phẩm thành công!!!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnAddSP.setBackground(Color.WHITE);
		btnAddSP.setForeground(Color.BLACK);
		btnAddSP.setIcon(new ImageIcon(ManageSP.class.getResource("/images/add.png")));
		btnAddSP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAddSP.setBounds(12, 741, 138, 49);
		contentPane.add(btnAddSP);
		
		JButton btnEditSP = new JButton("Sửa");
		btnEditSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MySQLConnUtils connUtils = new MySQLConnUtils();
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String dCA = df.format(txtCreatedAt.getDate());
					String sql = "select * from product_category where name = '" + cbbCategoryName.getSelectedItem().toString() + "'";
					pst = connUtils.connect().prepareStatement(sql);
					rs = pst.executeQuery();
					if (rs.next()) {
						idCategory = rs.getString("id");
					}
					connUtils.updateProduct(idProduct, txtName.getText(), idCategory, txtUnitprice.getText(), txtDescription.getText(), txtStatus.getText(), dCA);
					DefaultTableModel model = (DefaultTableModel)tableSP.getModel();
					model.setRowCount(0);
					loadDataSP();
					JOptionPane.showMessageDialog(null, "Sửa Sản Phẩm thành công!!!");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnEditSP.setBackground(Color.WHITE);
		btnEditSP.setForeground(Color.BLACK);
		btnEditSP.setIcon(new ImageIcon(ManageSP.class.getResource("/images/edit.png")));
		btnEditSP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEditSP.setBounds(450, 741, 138, 49);
		contentPane.add(btnEditSP);
		
		JButton btnDelSP = new JButton("Xóa");
		btnDelSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MySQLConnUtils connUtils = new MySQLConnUtils();
					connUtils.deleteProduct(idProduct);
					DefaultTableModel model = (DefaultTableModel)tableSP.getModel();
					model.setRowCount(0);
					loadDataSP();
					JOptionPane.showMessageDialog(null, "Xóa Sản Phẩm thành công!!!");
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnDelSP.setBackground(Color.WHITE);
		btnDelSP.setForeground(Color.BLACK);
		btnDelSP.setIcon(new ImageIcon(ManageSP.class.getResource("/images/delete.png")));
		btnDelSP.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDelSP.setBounds(917, 741, 138, 49);
		contentPane.add(btnDelSP);
		
		tableSP = new JTable();
		tableSP.setForeground(Color.BLACK);
		tableSP.setRowHeight(30);
		tableSP.setSelectionBackground(new Color(1, 198, 83));
		tableSP.setSelectionForeground(new Color(255, 255, 255));
		tableSP.setGridColor(new Color(255, 255, 255));
		tableSP.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		tableSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					int row = tableSP.getSelectedRow();
					String table_click = (tableSP.getModel().getValueAt(row, 0).toString());
					String sql = "select products.id as idProduct, products.name as nameProduct, product_category.id as idCategory, product_category.name as nameCategory, unitprice, products.description as descriptionProduct, status, products.created_at as createdAtProduct \r\n" + 
							"from products join product_category\r\n" + 
							"on products.category_id = product_category.id where products.id = '" + table_click + "'";
					pst = connUtils.connect().prepareStatement(sql);
					rs = pst.executeQuery();
					if (rs.next()) {
						idCategory = rs.getString("idCategory");
						idProduct = rs.getString("idProduct");
						txtName.setText(rs.getString("nameProduct"));
						cbbCategoryName.setSelectedItem(rs.getString("nameCategory"));
						txtUnitprice.setText(rs.getString("unitprice"));
						txtDescription.setText(rs.getString("descriptionProduct"));
						txtStatus.setText(rs.getString("status"));
						Date dCA = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("createdAtProduct"));
						txtCreatedAt.setDate(dCA);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(tableSP);
		
		
		
		loadDataSP();
	}
}
