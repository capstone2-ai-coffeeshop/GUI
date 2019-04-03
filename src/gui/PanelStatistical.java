package gui;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.DateUtil;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Connection.MySQLConnUtils;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JTree;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


public class PanelStatistical extends JPanel {
	
	private Connection connection;
	
	MySQLConnUtils instanceSQL = MySQLConnUtils.getInstance();
	MySQLConnUtils connUtils = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	private JDateChooser dateChooserBegin;
	private JDateChooser dateChooserEnd;
	private JTable tableOptionDay;
	private JTable tableOptionDay2;
	private JTable tableOptionDay3;
	private JTable tableOptionDay4;
	private JTable tableAllDay;
	private JTable tableAllDay2;
	private JTable tableAllDay3;
	private JTable tableAllDay4;
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
//	public void loadStatisticalNgay() {
//		try {
//			String sql ="SELECT bills.created_at AS Ngày, products.name, sum(quantity) AS 'Số lượng', products.unitprice AS 'Đơn giá', discount AS 'Giảm giá', sum(quantity*products.unitprice -discount*quantity*products.unitprice) AS 'Thành tiền' \r\n" + 
//					"from bill_items join products \r\n" + 
//					"on bill_items.product_id = products.id \r\n" + 
//					"join bills on bills.id = bill_items.bill_id\r\n" + 
//					"where bills.created_at = CURRENT_DATE()\r\n" + 
//					"group by products.name, quantity, discount";
//			pst = connUtils.connect().prepareStatement(sql);
//			rs = pst.executeQuery();
//			tableStatisticalNgay.setModel(DbUtils.resultSetToTableModel(rs));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void loadStatisticalThang() {
//		try {
//			String sql ="SELECT bills.created_at AS Ngày, products.name, sum(quantity) AS 'Số lượng', discount AS 'Giảm giá', products.unitprice AS 'Đơn giá', sum(quantity*products.unitprice - discount*quantity*products.unitprice) AS 'Thành tiền' \r\n" + 
//					"from bill_items join products \r\n" + 
//					"on bill_items.product_id = products.id \r\n" + 
//					"join bills on bills.id = bill_items.bill_id\r\n" + 
//					"where month(bills.created_at) = \"03\" \r\n" + 
//					"and year(bills.created_at) = year(current_date())\r\n" + 
//					"group by products.name, quantity, bills.created_at, discount";
//			pst = connUtils.connect().prepareStatement(sql);
//			rs = pst.executeQuery();
//			tableStatisticalThang.setModel(DbUtils.resultSetToTableModel(rs));
//			tableStatisticalThang.getColumnModel().getColumn(4).setCellRenderer(new NumberTableCellRenderer());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void loadStatisticalOption() {
		try {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			String dateBegin = df.format(dateChooserBegin.getDate());
			String dateEnd = df.format(dateChooserEnd.getDate());
			String sql ="SELECT created_at AS Ngày FROM bills WHERE created_at BETWEEN CAST('" + dateBegin + "' AS DATE) AND CAST('" + dateEnd + "' AS DATE) group by created_at";
			pst = connUtils.connect().prepareStatement(sql);
			rs = pst.executeQuery();
			tableOptionDay.setModel(DbUtils.resultSetToTableModel(rs));
			tableOptionDay2.setModel(new DefaultTableModel(null, new String[] { "Số lượng hóa đơn", "Tổng tiền ngày" }));
			tableOptionDay3.setModel(new DefaultTableModel(null, new String[] { "ID hóa đơn", "Giảm giá", "Tổng tiền 1 hóa đơn" }));
			tableOptionDay4.setModel(new DefaultTableModel(null, new String[] { "Tên món", "Số lượng bán" }));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadStatisticalAll() {
		try {
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			String sql ="SELECT created_at AS Ngày FROM bills group by created_at";
			pst = connUtils.connect().prepareStatement(sql);
			rs = pst.executeQuery();
			tableAllDay.setModel(DbUtils.resultSetToTableModel(rs));
			tableAllDay2.setModel(new DefaultTableModel(null, new String[] { "Số lượng hóa đơn", "Tổng tiền ngày" }));
			tableAllDay3.setModel(new DefaultTableModel(null, new String[] { "ID hóa đơn", "Giảm giá", "Tổng tiền 1 hóa đơn" }));
			tableAllDay4.setModel(new DefaultTableModel(null, new String[] { "Tên món", "Số lượng bán" }));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class NumberTableCellRenderer extends DefaultTableCellRenderer {

        public NumberTableCellRenderer() {
            setHorizontalAlignment(JLabel.RIGHT);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Number) {
                value = NumberFormat.getNumberInstance().format(value);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

    }
	

	/**
	 * Create the panel.
	 */
	public PanelStatistical() {
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
		setBounds(0, 0, 1902, 905);
		setBackground(new Color(238, 207, 161));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 1878, 849);
		panel.setBackground(new Color(238, 207, 161));
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)), "T\u00F9y ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 29, 1854, 127);
		panel_1.setBackground(new Color(238, 207, 161));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDayBegin = new JLabel("T\u1EEB ng\u00E0y:");
		lblDayBegin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDayBegin.setBounds(40, 44, 100, 37);
		panel_1.add(lblDayBegin);
		
		dateChooserBegin = new JDateChooser();
		dateChooserBegin.setDateFormatString("dd/MM/yyyy");
		dateChooserBegin.setBounds(152, 44, 120, 37);
		dateChooserBegin.setDate(new Date());
		panel_1.add(dateChooserBegin);
		
		JLabel lblDayEnd = new JLabel("\u0110\u1EBFn ng\u00E0y:");
		lblDayEnd.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDayEnd.setBounds(347, 44, 120, 37);
		panel_1.add(lblDayEnd);
		
		dateChooserEnd = new JDateChooser();
		dateChooserEnd.setDateFormatString("dd/MM/yyyy");
		dateChooserEnd.setBounds(479, 44, 120, 37);
		dateChooserEnd.setDate(new Date());
		panel_1.add(dateChooserEnd);
		
		JButton btnLietKe = new JButton("Li\u1EC7t k\u00EA");
		btnLietKe.setIcon(new ImageIcon(PanelStatistical.class.getResource("/images/list_24px.png")));
		btnLietKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadStatisticalOption();
				loadStatisticalAll();
			}
		});
		btnLietKe.setForeground(Color.BLACK);
		btnLietKe.setBackground(Color.WHITE);
		btnLietKe.setBounds(694, 44, 155, 37);
		panel_1.add(btnLietKe);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBounds(22, 169, 1844, 667);
		panel.add(tabbedPane);
		
		JPanel panelOption = new JPanel();
		tabbedPane.addTab("Tùy chọn", null, panelOption, null);
		panelOption.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 336, 637);
		panelOption.add(scrollPane);
		
		tableOptionDay = new JTable();
		tableOptionDay.setForeground(Color.BLACK);
		tableOptionDay.setRowHeight(30);
		tableOptionDay.setSelectionBackground(new Color(1, 198, 83));
		tableOptionDay.setSelectionForeground(new Color(255, 255, 255));
		tableOptionDay.setGridColor(new Color(255, 255, 255));
		tableOptionDay.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		tableOptionDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = tableOptionDay.getSelectedRow();
					String table_click = (tableOptionDay.getModel().getValueAt(row, 0).toString());
					String sql1 ="SELECT count(*) AS 'Số lượng hóa đơn', (Select Sum(quantity*products.unitprice - discount) as 'Tổng tiền ngày' from products join bill_items \r\n" + 
							"on products.id = bill_items.product_id join bills on bills.id = bill_items.bill_id where bills.created_at = '" + table_click + "' ) as 'Tổng tiền ngày'\r\n" + 
							"from bills\r\n" + 
							"where created_at = '" + table_click + "'\r\n" + 
							"group by created_at";
					pst = connUtils.connect().prepareStatement(sql1);
					rs = pst.executeQuery();
					tableOptionDay2.setModel(DbUtils.resultSetToTableModel(rs));
					tableOptionDay2.getColumnModel().getColumn(1).setCellRenderer(new NumberTableCellRenderer());
					
					String sql2 ="Select bills.id AS 'ID hóa đơn', Sum(discount) as 'Giảm giá', Sum(quantity*products.unitprice - discount) as 'Tổng tiền 1 hóa đơn' \r\n" + 
							"from products join bill_items \r\n" + 
							"on products.id = bill_items.product_id join bills on bills.id = bill_items.bill_id \r\n" + 
							"where bills.created_at = '" + table_click + "'\r\n" + 
							"group by bills.id";
					pst = connUtils.connect().prepareStatement(sql2);
					rs = pst.executeQuery();
					tableOptionDay3.setModel(DbUtils.resultSetToTableModel(rs));
					tableOptionDay3.getColumnModel().getColumn(1).setCellRenderer(new NumberTableCellRenderer());
					tableOptionDay3.getColumnModel().getColumn(2).setCellRenderer(new NumberTableCellRenderer());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(tableOptionDay);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(348, 0, 367, 637);
		panelOption.add(scrollPane_1);
		
		tableOptionDay2 = new JTable();
		tableOptionDay2.setForeground(Color.BLACK);
		tableOptionDay2.setRowHeight(30);
		tableOptionDay2.setSelectionBackground(new Color(1, 198, 83));
		tableOptionDay2.setSelectionForeground(new Color(255, 255, 255));
		tableOptionDay2.setGridColor(new Color(255, 255, 255));
		tableOptionDay2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		scrollPane_1.setViewportView(tableOptionDay2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(727, 0, 594, 637);
		panelOption.add(scrollPane_2);
		
		tableOptionDay3 = new JTable();
		tableOptionDay3.setForeground(Color.BLACK);
		tableOptionDay3.setRowHeight(30);
		tableOptionDay3.setSelectionBackground(new Color(1, 198, 83));
		tableOptionDay3.setSelectionForeground(new Color(255, 255, 255));
		tableOptionDay3.setGridColor(new Color(255, 255, 255));
		tableOptionDay3.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		tableOptionDay3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = tableOptionDay3.getSelectedRow();
					String table_click = (tableOptionDay3.getModel().getValueAt(row, 0).toString());
					String sql ="Select products.name AS 'Tên món', sum(quantity) AS 'Số lượng bán' from products join bill_items \r\n" + 
							"on products.id = bill_items.product_id join bills on bills.id = bill_items.bill_id \r\n" + 
							"where bills.id= '" + table_click + "'\r\n" + 
							"group by products.id";
					pst = connUtils.connect().prepareStatement(sql);
					rs = pst.executeQuery();
					tableOptionDay4.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane_2.setViewportView(tableOptionDay3);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(1333, 0, 506, 637);
		panelOption.add(scrollPane_3);
		
		tableOptionDay4 = new JTable();
		tableOptionDay4.setForeground(Color.BLACK);
		tableOptionDay4.setRowHeight(30);
		tableOptionDay4.setSelectionBackground(new Color(1, 198, 83));
		tableOptionDay4.setSelectionForeground(new Color(255, 255, 255));
		tableOptionDay4.setGridColor(new Color(255, 255, 255));
		tableOptionDay4.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		scrollPane_3.setViewportView(tableOptionDay4);
		
		JPanel panelAll = new JPanel();
		panelAll.setLayout(null);
		tabbedPane.addTab("Tất cả", null, panelAll, null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 336, 637);
		panelAll.add(scrollPane_4);
		
		tableAllDay = new JTable();
		tableAllDay.setForeground(Color.BLACK);
		tableAllDay.setRowHeight(30);
		tableAllDay.setSelectionBackground(new Color(1, 198, 83));
		tableAllDay.setSelectionForeground(new Color(255, 255, 255));
		tableAllDay.setGridColor(new Color(255, 255, 255));
		tableAllDay.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		tableAllDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = tableAllDay.getSelectedRow();
					String table_click = (tableAllDay.getModel().getValueAt(row, 0).toString());
					String sql1 ="SELECT count(*) AS 'Số lượng hóa đơn', (Select Sum(quantity*products.unitprice - discount) as 'Tổng tiền ngày' from products join bill_items \r\n" + 
							"on products.id = bill_items.product_id join bills on bills.id = bill_items.bill_id where bills.created_at = '" + table_click + "' ) as 'Tổng tiền ngày'\r\n" + 
							"from bills\r\n" + 
							"where created_at = '" + table_click + "'\r\n" + 
							"group by created_at";
					pst = connUtils.connect().prepareStatement(sql1);
					rs = pst.executeQuery();
					tableAllDay2.setModel(DbUtils.resultSetToTableModel(rs));
					tableAllDay2.getColumnModel().getColumn(1).setCellRenderer(new NumberTableCellRenderer());
					
					String sql2 ="Select bills.id AS 'ID hóa đơn', Sum(discount) as 'Giảm giá', Sum(quantity*products.unitprice - discount) as 'Tổng tiền 1 hóa đơn' \r\n" + 
							"from products join bill_items \r\n" + 
							"on products.id = bill_items.product_id join bills on bills.id = bill_items.bill_id \r\n" + 
							"where bills.created_at = '" + table_click + "'\r\n" + 
							"group by bills.id";
					pst = connUtils.connect().prepareStatement(sql2);
					rs = pst.executeQuery();
					tableAllDay3.setModel(DbUtils.resultSetToTableModel(rs));
					tableAllDay3.getColumnModel().getColumn(1).setCellRenderer(new NumberTableCellRenderer());
					tableAllDay3.getColumnModel().getColumn(2).setCellRenderer(new NumberTableCellRenderer());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		scrollPane_4.setViewportView(tableAllDay);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(348, 0, 367, 636);
		panelAll.add(scrollPane_5);
		
		tableAllDay2 = new JTable();
		tableAllDay2.setForeground(Color.BLACK);
		tableAllDay2.setRowHeight(30);
		tableAllDay2.setSelectionBackground(new Color(1, 198, 83));
		tableAllDay2.setSelectionForeground(new Color(255, 255, 255));
		tableAllDay2.setGridColor(new Color(255, 255, 255));
		tableAllDay2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		scrollPane_5.setViewportView(tableAllDay2);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(727, 0, 594, 636);
		panelAll.add(scrollPane_6);
		
		tableAllDay3 = new JTable();
		tableAllDay3.setForeground(Color.BLACK);
		tableAllDay3.setRowHeight(30);
		tableAllDay3.setSelectionBackground(new Color(1, 198, 83));
		tableAllDay3.setSelectionForeground(new Color(255, 255, 255));
		tableAllDay3.setGridColor(new Color(255, 255, 255));
		tableAllDay3.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		tableAllDay3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = tableAllDay3.getSelectedRow();
					String table_click = (tableAllDay3.getModel().getValueAt(row, 0).toString());
					String sql ="Select products.name AS 'Tên món', sum(quantity) AS 'Số lượng bán' from products join bill_items \r\n" + 
							"on products.id = bill_items.product_id join bills on bills.id = bill_items.bill_id \r\n" + 
							"where bills.id= '" + table_click + "'\r\n" + 
							"group by products.id";
					pst = connUtils.connect().prepareStatement(sql);
					rs = pst.executeQuery();
					tableAllDay4.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane_6.setViewportView(tableAllDay3);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(1333, 0, 506, 636);
		panelAll.add(scrollPane_7);
		
		tableAllDay4 = new JTable();
		scrollPane_7.setViewportView(tableAllDay4);

	}
}
