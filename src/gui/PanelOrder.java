package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Connection.MySQLConnUtils;
import bean.Staffs;
import bean.Tables;
import gui.PanelStatistical.NumberTableCellRenderer;
import bean.Products;
import bean.ProductCategory;

import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

import javax.swing.border.EtchedBorder;

public class PanelOrder extends JPanel {
	public static MySQLConnUtils connUtils = new MySQLConnUtils();
	public static ResultSet rs = null;
	public static PreparedStatement pst = null;
	
	public static JLabel txtCustomerID;
	public static JLabel txtStaffID;
	public static JLabel txtCustomerName;
	public static JLabel lblProductOrderQuantity;
	public static JLabel lblProductOrderName;
	public static JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	public static JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	public static JPanel panel_8;
	private JPanel panelProducts;
	public static JButton btnBan;
	private JButton btnCategory;
	private JButton btnProduct;
	private JLabel lblProductName;
	private JLabel lblProductPrice;
	private JLabel lblProductOrder;
	public static JLabel lblNumberServing;
	public static JLabel lblTotalTable;
	private JLabel lblTimeOrder;
	public static JComboBox cbbTableID;
	private JLabel txtTable;
	private JLabel txtThanhtien;
	private JLabel txtGiamgia;
	private JLabel txtTongCong;
	
	public static JLabel txtThanhtienConfirm;
	
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTextField txtGiamgiaOrder;
	
	private int click = 0;
	private int click1 = 0;
	
	public double tempsum = 0;
	private Component[] components;
	public static JTable tableProductChoose;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private JTable tableBillItems;
	private int session;

	
	public static void loadTable() {
		List<Tables> tables = connUtils.getTables();
		for (Tables table : tables) {
			btnBan = new JButton(table.getId());
			btnBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnBan.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/table2.png")));
			btnBan.setBackground(Color.WHITE);
			btnBan.setForeground(Color.BLACK);
			btnBan.setPreferredSize(new Dimension(95, 60));
			btnBan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TableInfo tI = new TableInfo();
					tI.setLocationRelativeTo(null);
					tI.setVisible(true);
					try {
						String sql = "Select * from tables where id = '" + table.getId() + "' ";
						pst = connUtils.connect().prepareStatement(sql);
						rs = pst.executeQuery();
						if (rs.next()) {
							TableInfo.lblTitleBan.setText(rs.getString("id"));
							TableInfo.txtSLKhach.setText(rs.getString("quantity_of_customer"));
							if (rs.getString("status").equals("0")) {
								TableInfo.txtStatus.setText("Sẵn sàng");
							}
							if (rs.getString("status").equals("1")) {
								TableInfo.txtStatus.setText("Không sẵn sàng");
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			if (table.getStatus().equals("1")) {
				btnBan.setBackground(new Color(57, 113, 177));
			}
			panel.add(btnBan);
		}
		panel.revalidate();
		panel.repaint();
	}
	public static void loadCombobox() {
		cbbTableID = new JComboBox();
		cbbTableID.setModel(new DefaultComboBoxModel(new String[] {""}));
		cbbTableID.setForeground(Color.BLACK);
		cbbTableID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbbTableID.setBackground(Color.WHITE);
		cbbTableID.setBounds(236, 167, 98, 24);
		panel_5.add(cbbTableID);
		try {
			String sql = "select * from tables where status = '0'";
			pst = connUtils.connect().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				cbbTableID.addItem(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		cbbTableID.revalidate();
		cbbTableID.repaint();
	}
	public static void loadNumberServing() {
		JLabel lblNewLabel_1 = new JLabel("Đang phục vụ:");
		lblNewLabel_1.setBounds(0, 13, 105, 26);
		panel_8.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblNumberServing = new JLabel("");
		lblNumberServing.setBounds(118, 13, 41, 26);
		panel_8.add(lblNumberServing);
		lblNumberServing.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberServing.setForeground(Color.BLACK);
		lblNumberServing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label = new JLabel("/");
		label.setBounds(168, 13, 6, 26);
		panel_8.add(label);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblTotalTable = new JLabel("");
		lblTotalTable.setBounds(186, 13, 78, 26);
		panel_8.add(lblTotalTable);
		lblTotalTable.setForeground(Color.BLACK);
		lblTotalTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		try {
			String sql1 = "select count(*) as count from tables where status = '1'";
			pst = connUtils.connect().prepareStatement(sql1);
			rs = pst.executeQuery();
			if (rs.next()) {
				lblNumberServing.setText(rs.getString("count"));
			}
			
			String sql2 = "select count(*) as count from tables";
			pst = connUtils.connect().prepareStatement(sql2);
			rs = pst.executeQuery();
			if (rs.next()) {
				lblTotalTable.setText(rs.getString("count") + " bàn");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		panel_8.revalidate();
		panel_8.repaint();
	}
	
	public void loadMenuCategory() {
		List<ProductCategory> categorys = connUtils.getProductCategorys();
		for (ProductCategory category : categorys) {
			btnCategory = new JButton(category.getName());
			btnCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
			if (category.getId().equals("1")) {
				btnCategory.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/coffee.png")));
			}
			if (category.getId().equals("2")) {
				btnCategory.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/fruit.png")));
			}
			if (category.getId().equals("3")) {
				btnCategory.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/milktea.png")));
			}
			if (category.getId().equals("4")) {
				btnCategory.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/food.png")));
			}
			btnCategory.setBackground(Color.WHITE);
			btnCategory.setForeground(Color.BLACK);
			btnCategory.setPreferredSize(new Dimension(140, 40));
			btnCategory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						panel_4.removeAll();
						String sql = "select * from products where category_id = '" + category.getId() + "'";
						pst = connUtils.connect().prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							panelProducts = new JPanel();
							panelProducts.setBorder(new LineBorder(Color.BLACK, 1, true));
							GridBagConstraints gbc_panelProducts = new GridBagConstraints();
							gbc_panelProducts.insets = new Insets(0, 0, 10, 0);
							gbc_panelProducts.gridx = 0;
							gbc_panelProducts.gridy = click;
							panelProducts.setPreferredSize(new Dimension(450, 100));
							panelProducts.setLayout(null);
							panelProducts.setBackground(new Color(167, 219, 219));
							panel_4.add(panelProducts, gbc_panelProducts);
							
							lblProductName = new JLabel(rs.getString("name"));
							lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
							lblProductName.setForeground(new Color(244, 67, 54));
							lblProductName.setFont(new Font("Tahoma", Font.BOLD, 16));
							lblProductName.setBounds(12, 13, 185, 74);
							panelProducts.add(lblProductName);
							
							JLabel lblNewLabel_6 = new JLabel("Đơn giá:");
							lblNewLabel_6.setForeground(Color.BLACK);
							lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
							lblNewLabel_6.setBounds(209, 13, 61, 31);
							panelProducts.add(lblNewLabel_6);
								
							JLabel lblProductPrice = new JLabel(String.format("%1$,.0f", rs.getDouble("unitprice")));
							lblProductPrice.setForeground(Color.BLACK);
							lblProductPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
							lblProductPrice.setHorizontalAlignment(SwingConstants.CENTER);
							lblProductPrice.setBounds(282, 13, 88, 31);
							panelProducts.add(lblProductPrice);
							
							JLabel lblNewLabel_7 = new JLabel("Trạng thái:");
							lblNewLabel_7.setForeground(Color.BLACK);
							lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
							lblNewLabel_7.setBounds(209, 56, 73, 31);
							panelProducts.add(lblNewLabel_7);
								
							JLabel lblProductStatus = new JLabel();
							if (rs.getString("status").equals("1")) {
								lblProductStatus.setText("CÒN");
							}
							if (rs.getString("status").equals("0")) {
								lblProductStatus.setText("HẾT");
							}
							lblProductStatus.setHorizontalAlignment(SwingConstants.CENTER);
							lblProductStatus.setForeground(Color.BLACK);
							lblProductStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
							lblProductStatus.setBounds(282, 56, 88, 31);
							panelProducts.add(lblProductStatus);
							int a = Integer.parseInt(rs.getString("id"));
							panelProducts.addMouseListener(new MouseAdapter() {
								@Override
								public void mousePressed(MouseEvent arg0) {
									lblTimeOrder.setText(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
//									try {
//										String sql1 = "select * from products where id = '" + a + "'";
//										pst = connUtils.connect().prepareStatement(sql1);
//										rs = pst.executeQuery();
//										if (rs.next()) {
//											panel_7 = new JPanel();
//											panel_7.setBorder(new LineBorder(Color.BLACK, 1, true));
//											GridBagConstraints gbc_panel_7 = new GridBagConstraints();
//											gbc_panel_7.insets = new Insets(0, 0, 10, 0);
//											gbc_panel_7.gridx = 0;
//											gbc_panel_7.gridy = click;
//											panel_7.setPreferredSize(new Dimension(450, 100));
//											panel_7.setLayout(null);
//											panel_7.setBackground(new Color(167, 219, 219));
//											panel_7.addMouseListener(new MouseAdapter() {
//												@Override
//												public void mouseClicked(MouseEvent arg0) {
////													JPanel panel = (JPanel)arg0.getSource();
////													panel.setName(lblProductName.getText());
////													System.out.println("Panel...."+panel.getName());
//												}
//											});
//											panel_6.add(panel_7, gbc_panel_7);
//												
//											lblProductOrderName = new JLabel(rs.getString("name"));
//											lblProductOrderName.setHorizontalAlignment(SwingConstants.CENTER);
//											lblProductOrderName.setForeground(new Color(244, 67, 54));
//											lblProductOrderName.setFont(new Font("Tahoma", Font.BOLD, 16));
//											lblProductOrderName.setBounds(12, 13, 185, 74);
//											panel_7.add(lblProductOrderName);
//											
//											JLabel lblNewLabel_5 = new JLabel("Đơn giá:");
//											lblNewLabel_5.setForeground(Color.BLACK);
//											lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
//											lblNewLabel_5.setBounds(209, 13, 61, 31);
//											panel_7.add(lblNewLabel_5);
//												
//											JLabel lblProductOrderPrice = new JLabel(String.format("%1$,.0f", rs.getDouble("unitprice")));
//											lblProductOrderPrice.setForeground(Color.BLACK);
//											lblProductOrderPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
//											lblProductOrderPrice.setHorizontalAlignment(SwingConstants.CENTER);
//											lblProductOrderPrice.setBounds(282, 13, 88, 31);
//											panel_7.add(lblProductOrderPrice);
//												
//											JLabel lblSLng = new JLabel("Số lượng:");
//											lblSLng.setForeground(Color.BLACK);
//											lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 15));
//											lblSLng.setBounds(209, 56, 61, 31);
//											panel_7.add(lblSLng);
//												
//											lblProductOrderQuantity = new JLabel("1");
//											lblProductOrderQuantity.setHorizontalAlignment(SwingConstants.CENTER);
//											lblProductOrderQuantity.setForeground(Color.BLACK);
//											lblProductOrderQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
//											lblProductOrderQuantity.setBounds(282, 56, 88, 31);
//											panel_7.add(lblProductOrderQuantity);
//												
//											JLabel lblNewLabel_3 = new JLabel("");
//											lblNewLabel_3.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/cancel_48px.png")));
//											lblNewLabel_3.setBounds(390, 27, 48, 48);
//											lblNewLabel_3.addMouseListener(new MouseAdapter() {
//												@Override
//												public void mouseClicked(MouseEvent arg0) {
//													Object source = arg0.getSource();
//												    if (source instanceof Component) {
//												        Component comp = (Component)source;
//												        panel_6.remove(comp.getParent());
//												        panel_6.revalidate();
//												        panel_6.repaint();
//												    }
//													
//												}
//											});
//											panel_7.add(lblNewLabel_3);
//											tempsum += rs.getDouble("unitprice") * Double.parseDouble(lblProductOrderQuantity.getText());
//											txtThanhtienConfirm.setText(String.format("%1$,.0f", tempsum));
//											
//											validate();
//											repaint();
//											panel_6.setOpaque(true);
//										}
//									} catch (Exception e2) {
//										e2.printStackTrace();
//									}
									
									try {
										Object[] columns = {"STT", "Tên món", "Đơn giá", "Số lượng"};
										Object[] rows = new Object[4];
										model = (DefaultTableModel)tableProductChoose.getModel();
										model.setColumnIdentifiers(columns);
										tableProductChoose.getColumnModel().getColumn(0).setPreferredWidth(50);
										tableProductChoose.getColumnModel().getColumn(1).setPreferredWidth(200);
										tableProductChoose.getColumnModel().getColumn(2).setPreferredWidth(100);
										tableProductChoose.getColumnModel().getColumn(3).setPreferredWidth(100);
										tableProductChoose.getColumnModel().getColumn(0).setCellRenderer(new NumberTableCellRenderer());
										tableProductChoose.getColumnModel().getColumn(1).setCellRenderer(new NumberTableCellRenderer());
										tableProductChoose.getColumnModel().getColumn(2).setCellRenderer(new NumberTableCellRenderer());
										tableProductChoose.getColumnModel().getColumn(3).setCellRenderer(new NumberTableCellRenderer());
										tableProductChoose.setModel(model);
										boolean isClicked = false;
										String sql1 ="SELECT name, unitprice from products where id = '" + a + "'";
										pst = connUtils.connect().prepareStatement(sql1);
										rs = pst.executeQuery();
										if (rs.next()) {
											for (int y = 0; y < tableProductChoose.getRowCount(); y++) {
												if (tableProductChoose.getValueAt(y, 1).equals(rs.getString("name"))) {
													isClicked = true;
												}
												if (isClicked) {
													int b = (Integer)tableProductChoose.getValueAt(y, 3) + 1;
													Object x = (Integer)b;
													tableProductChoose.setValueAt(x, y, 3);
													break;
												}
											}
											if (!isClicked) {
												click++;
												rows[0] = click;
												rows[1] = rs.getString("name");
												rows[2] = rs.getDouble("unitprice");
												rows[3] = 1;
												model.addRow(rows);
											}
											
										}
										double z = 0;
										DecimalFormat formatter = new DecimalFormat("###,###,###.##");
										for (int y = 0; y < tableProductChoose.getRowCount(); y++) {
											double t = Double.parseDouble(String.valueOf(tableProductChoose.getValueAt(y, 2))) * Double.parseDouble(String.valueOf(tableProductChoose.getValueAt(y, 3)));
											z += t;
											txtThanhtienConfirm.setText(formatter.format(z));
										}
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
								}
							});
						}
						panel_4.repaint();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			panel_3.add(btnCategory);
		}
	}
	public void loadInfoOrder() {
		try {
			if (click1 == 0) {
				String cbbTab = cbbTableID.getSelectedItem().toString();
				if (cbbTab.equals("")) {
					cbbTab = null;
				}
				double z = 0;
				txtTable.setText(cbbTableID.getSelectedItem().toString());
				DecimalFormat formatter = new DecimalFormat("###,###,###.##");
				if (!cbbTableID.getSelectedItem().toString().equals("")) {
					for (int y = 0; y < tableProductChoose.getRowCount(); y++) {
						z += Integer.parseInt(String.valueOf(tableProductChoose.getValueAt(y, 3)));
					}
					connUtils.updateTable(cbbTab, formatter.format(z), "Noo Descriptionn", "1");
					panel.removeAll();
					loadTable();
					panel.revalidate();
					panel.repaint();
					panel_5.remove(cbbTableID);
					loadCombobox();
					panel_5.revalidate();
					panel_5.repaint();
				}
				
				connUtils.insertBill(txtStaffID.getText(), txtCustomerID.getText(), cbbTab, lblTimeOrder.getText());
				Calendar c = Calendar.getInstance();
				int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

				if(timeOfDay >= 0 && timeOfDay < 11){
				    session = 1;        
				}else if(timeOfDay >= 11 && timeOfDay < 13){
					session = 2;
				}else if(timeOfDay >= 13 && timeOfDay < 18){
					session = 3;
				}else if(timeOfDay >= 18 && timeOfDay < 24){
					session = 4;
				}
				for (int y = 0; y < tableProductChoose.getRowCount(); y++) {
					String sqlK = "select * from products where name = '" + tableProductChoose.getValueAt(y, 1) + "'";
					pst = connUtils.connect().prepareStatement(sqlK);
					rs = pst.executeQuery();
					if (rs.next()) {
						connUtils.insertBillInfo(rs.getString("id"), tableProductChoose.getValueAt(y, 3).toString(), String.valueOf(session), "1", txtGiamgiaOrder.getText(), "No description");
					}
				}
				Object[] columns = {"TÊN MÓN", "SỐ LƯỢNG", "ĐƠN GIÁ", "THÀNH TIỀN"};
				Object[] rows = new Object[4];
				model1 = (DefaultTableModel)tableBillItems.getModel();
				model1.setColumnIdentifiers(columns);
				tableBillItems.getColumnModel().getColumn(0).setPreferredWidth(200);
				tableBillItems.getColumnModel().getColumn(1).setPreferredWidth(100);
				tableBillItems.getColumnModel().getColumn(2).setPreferredWidth(100);
				tableBillItems.getColumnModel().getColumn(3).setPreferredWidth(100);
				tableBillItems.getColumnModel().getColumn(0).setCellRenderer(new NumberTableCellRenderer());
				tableBillItems.getColumnModel().getColumn(1).setCellRenderer(new NumberTableCellRenderer());
				tableBillItems.getColumnModel().getColumn(2).setCellRenderer(new NumberTableCellRenderer());
				tableBillItems.getColumnModel().getColumn(3).setCellRenderer(new NumberTableCellRenderer());
				tableBillItems.setModel(model1);
				String sql = "select products.name as name, bill_items.quantity as quantity, products.unitprice as unitprice, "
						+ "sum(bill_items.quantity * products.unitprice) as total "
						+ "from bill_items join products on bill_items.product_id = products.id "
						+ "where bill_id = (select MAX(id) from bills) group by bill_items.id";
				pst = connUtils.connect().prepareStatement(sql);
				rs = pst.executeQuery();
				double total = 0;
				while (rs.next()) {
					rows[0] = rs.getString("name");
					rows[1] = rs.getString("quantity");
					rows[2] = rs.getDouble("unitprice");
					rows[3] = rs.getDouble("total");
					model1.addRow(rows);
					total = total + rs.getDouble("total");
				}
				txtThanhtien.setText(formatter.format(total));
				txtGiamgia.setText(formatter.format(Double.parseDouble(txtGiamgiaOrder.getText())));
				txtTongCong.setText(formatter.format(total - Double.parseDouble(txtGiamgiaOrder.getText())));
			}
			click1 ++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		panel_8.removeAll();
		loadNumberServing();
		panel_8.revalidate();
		panel_8.repaint();
	}
	public class NumberTableCellRenderer extends DefaultTableCellRenderer {

        public NumberTableCellRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Number) {
                value = NumberFormat.getNumberInstance().format(value);
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

    }
	
	public void inBill() {
		String idTBill = "";
		String timeOrder = "";
		try {
			String sqlT = "select * from bills where id = (select MAX(id) from bills)";
			pst = connUtils.connect().prepareStatement(sqlT);
			rs = pst.executeQuery();
			if (rs.next()) {
				idTBill = rs.getString("id");
				timeOrder = rs.getString("created_at");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		File newFile = new File("D:/4_Projects/FilesCreate/Bill" + idTBill + ".txt");
		if (newFile.exists()) {
			System.out.println("The file already exists!");
		} else {
			try {
				newFile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
			DecimalFormat formatterNum = new DecimalFormat("###,###,###.##");
			try {
				FileWriter fileW = new FileWriter(newFile);
				BufferedWriter buffW = new BufferedWriter(fileW);
				buffW.write("---------------------------------------------------------\n");
				buffW.write("               AI COFFEE SHOP BILL RECEIPT               \n");
				buffW.write("---------------------------------------------------------\n");
				buffW.write("Bill ID:      " + idTBill +                             "\n");
				buffW.write("Tên khách hàng:     " + txtCustomerName.getText() +     "\n");
				buffW.write("Thời gian:    " + timeOrder +                           "\n");
				buffW.write("Bàn:    " + txtTable.getText() +                        "\n");
				buffW.write("_________________________________________________________\n");
				buffW.write("|                                                       |\n");
				buffW.write("| Tên món                SL     Đơn giá     Thành tiền  |\n");
				buffW.write("|_______________________________________________________|\n");
				for (int k = 0; k < tableBillItems.getRowCount(); k++) {
					Formatter formatter = new Formatter();
					String formatter123 = formatter.format("%-22s %-6s %-13s %-10s", tableBillItems.getValueAt(k, 0).toString(), 
							tableBillItems.getValueAt(k, 1).toString(), formatterNum.format(Double.parseDouble(tableBillItems.getValueAt(k, 2).toString())), 
							formatterNum.format(Double.parseDouble(tableBillItems.getValueAt(k, 3).toString()))).toString();
					buffW.write("| " + formatter123 + "|\n");
				}
//				buffW.write("| Oreo Đá xay            1      42000          42000    |\n");
//				buffW.write("| Oreo Đá xay            1      42000          42000    |\n");
				buffW.write("|_______________________________________________________|\n");
				buffW.write("                                                         \n");
				buffW.write("Thành tiền:                                   " + txtThanhtien.getText() + "\n");
				buffW.write("Giảm giá:                                     " + txtGiamgia.getText() + "\n");
				buffW.write("Tổng cộng:                                    " + txtTongCong.getText() + "\n");
				buffW.write("Tiền khách đưa:                                          \n");
				buffW.write("Tiền trả lại:                                            \n");
				buffW.write("                                                         \n");
				buffW.write("_________________________________________________________\n");
				buffW.write("                                                         \n");
				buffW.write("           Cảm ơn quý khách và hẹn gặp lại !!!           \n");
				buffW.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Create the panel.
	 */
	public PanelOrder() {
		setForeground(Color.BLACK);
		setBackground(new Color(238, 207, 161));
		setBounds(0, 0, 1902, 905);
		setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "B\u00E0n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 13, 344, 807);
		panel.setBackground(new Color(238, 207, 161));
		add(panel);
		
		panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Ch\u1ECDn m\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(238, 207, 161));
		panel_1.setBounds(368, 13, 539, 849);
		add(panel_1);
		panel_1.setLayout(null);
		
		
//////////////////////////////////////////////////////
		panel_2 = new JPanel();
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(238, 207, 161));
		panel_2.setBounds(1426, 13, 464, 849);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblHoTenKH = new JLabel("H\u1ECD t\u00EAn:");
		lblHoTenKH.setForeground(Color.BLACK);
		lblHoTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHoTenKH.setBounds(12, 64, 59, 22);
		panel_2.add(lblHoTenKH);
		
		JLabel lblGoiY = new JLabel("Gợi ý thức uống:");
		lblGoiY.setForeground(Color.BLACK);
		lblGoiY.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGoiY.setBounds(12, 99, 134, 22);
		panel_2.add(lblGoiY);
		
		JLabel lblCacMonChon = new JLabel("Các món đã chọn:");
		lblCacMonChon.setForeground(Color.BLACK);
		lblCacMonChon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCacMonChon.setBounds(12, 301, 144, 22);
		panel_2.add(lblCacMonChon);
		
		JLabel lblThanhTien = new JLabel("Thành tiền:");
		lblThanhTien.setForeground(Color.BLACK);
		lblThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThanhTien.setBounds(12, 672, 91, 22);
		panel_2.add(lblThanhTien);
		
		JLabel lblMaGiamGia = new JLabel("Giảm giá:");
		lblMaGiamGia.setForeground(Color.BLACK);
		lblMaGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaGiamGia.setBounds(12, 707, 79, 22);
		panel_2.add(lblMaGiamGia);
		
		JLabel lblTongCong = new JLabel("Tổng cộng:");
		lblTongCong.setForeground(Color.BLACK);
		lblTongCong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTongCong.setBounds(12, 742, 91, 22);
		panel_2.add(lblTongCong);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inBill();
				for( int i = model1.getRowCount() - 1; i >= 0; i-- ) {
					model1.removeRow(i);
			    }
				txtTable.setText("");
				txtThanhtien.setText("");
				txtGiamgia.setText("");
				txtTongCong.setText("");
				click1 = 0;
				for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
					model.removeRow(i);
			    }
				txtThanhtienConfirm.setText("");
				txtGiamgiaOrder.setText("0");
				click = 0;
			}
		});
		btnThanhToan.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/cash_in_hand_40px.png")));
		btnThanhToan.setForeground(Color.BLACK);
		btnThanhToan.setBackground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThanhToan.setBounds(140, 781, 181, 55);
		panel_2.add(btnThanhToan);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(12, 31, 25, 22);
		panel_2.add(lblNewLabel);
		
		txtCustomerID = new JLabel("2");
		txtCustomerID.setHorizontalAlignment(SwingConstants.CENTER);
		txtCustomerID.setForeground(Color.BLACK);
		txtCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCustomerID.setBounds(49, 31, 31, 20);
		panel_2.add(txtCustomerID);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 337, 440, 322);
		panel_2.add(scrollPane);
		
		tableBillItems = new JTable();
		tableBillItems.setBounds(0, 0, 1, 1);
		scrollPane.setViewportView(tableBillItems);
		tableBillItems.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tableBillItems.setBounds(0, 0, 1, 1);
		tableBillItems.setForeground(Color.BLACK);
		tableBillItems.setRowHeight(30);
		tableBillItems.setSelectionBackground(new Color(1, 198, 83));
		tableBillItems.setSelectionForeground(new Color(255, 255, 255));
		tableBillItems.setGridColor(new Color(255, 255, 255));
		tableBillItems.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblTable = new JLabel("Table:");
		lblTable.setForeground(Color.BLACK);
		lblTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTable.setBounds(293, 64, 49, 22);
		panel_2.add(lblTable);
		
		txtCustomerName = new JLabel("");
		txtCustomerName.setForeground(Color.BLACK);
		txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCustomerName.setBounds(83, 64, 177, 22);
		panel_2.add(txtCustomerName);
		
		JLabel lblStaffId = new JLabel("Staff ID:");
		lblStaffId.setForeground(Color.BLACK);
		lblStaffId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStaffId.setBounds(293, 31, 68, 22);
		panel_2.add(lblStaffId);
		
		txtStaffID = new JLabel("");
		txtStaffID.setForeground(Color.BLACK);
		txtStaffID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtStaffID.setBounds(373, 31, 79, 22);
		try {
			String sqlStaffID ="select * from staffs where account_id = (select id from accounts where username = '" + Main.lblAccName.getText() + "')";
			pst = connUtils.connect().prepareStatement(sqlStaffID);
			rs = pst.executeQuery();
			while (rs.next()) {
				txtStaffID.setText(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		panel_2.add(txtStaffID);
		
		txtThanhtien = new JLabel("");
		txtThanhtien.setHorizontalAlignment(SwingConstants.TRAILING);
		txtThanhtien.setForeground(Color.BLACK);
		txtThanhtien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtThanhtien.setBounds(307, 672, 105, 22);
		panel_2.add(txtThanhtien);
		
		txtGiamgia = new JLabel("");
		txtGiamgia.setHorizontalAlignment(SwingConstants.TRAILING);
		txtGiamgia.setForeground(Color.BLACK);
		txtGiamgia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGiamgia.setBounds(307, 707, 105, 22);
		panel_2.add(txtGiamgia);
		
		txtTongCong = new JLabel("");
		txtTongCong.setHorizontalAlignment(SwingConstants.TRAILING);
		txtTongCong.setForeground(Color.BLACK);
		txtTongCong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTongCong.setBounds(307, 742, 105, 22);
		panel_2.add(txtTongCong);
		
		txtTable = new JLabel("");
		txtTable.setForeground(Color.BLACK);
		txtTable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTable.setBounds(373, 64, 79, 22);
		panel_2.add(txtTable);
		
		JLabel lblVn = new JLabel("VNĐ");
		lblVn.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVn.setForeground(Color.BLACK);
		lblVn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVn.setBounds(412, 672, 40, 22);
		panel_2.add(lblVn);
		
		JLabel label_2 = new JLabel("VNĐ");
		label_2.setHorizontalAlignment(SwingConstants.TRAILING);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(412, 707, 40, 22);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("VNĐ");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(412, 742, 40, 22);
		panel_2.add(label_3);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Danh m\u1EE5c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(12, 29, 515, 211);
		panel_3.setBackground(new Color(238, 207, 161));
		panel_1.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 253, 515, 583);
		scrollPane_1.setBorder(null);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(16);
		panel_1.add(scrollPane_1);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "M\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_4.setBackground(new Color(238, 207, 161));
		panel_4.setLayout(new GridLayout(0, 1, 10, 10));
		scrollPane_1.setViewportView(panel_4);
		
		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setForeground(Color.BLACK);
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBackground(new Color(238, 207, 161));
		panel_5.setBounds(919, 13, 495, 849);
		add(panel_5);
				
				JButton btnOrder = new JButton("Xác nhận");
				btnOrder.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/checkmark_40px.png")));
				btnOrder.setBounds(53, 781, 171, 55);
				panel_5.add(btnOrder);
				btnOrder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadInfoOrder();
					}
				});
				btnOrder.setForeground(Color.BLACK);
				btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnOrder.setBackground(Color.WHITE);
				
				JButton btnHuy = new JButton("Hủy");
				btnHuy.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/delete_sign_40px.png")));
				btnHuy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						for( int i = model.getRowCount() - 1; i >= 0; i-- ) {
							model.removeRow(i);
					    }
						txtThanhtienConfirm.setText("");
						txtGiamgiaOrder.setText("0");
						click = 0;
					}
				});
				btnHuy.setForeground(Color.BLACK);
				btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnHuy.setBackground(Color.WHITE);
				btnHuy.setBounds(285, 781, 171, 55);
				panel_5.add(btnHuy);
				
				scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(12, 204, 471, 419);
				scrollPane_2.setBorder(null);
				scrollPane_2.getVerticalScrollBar().setUnitIncrement(16);
				panel_5.add(scrollPane_2);
				
				tableProductChoose = new JTable();
				tableProductChoose.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ProductsQuantity pQ = new ProductsQuantity();
						pQ.setLocationRelativeTo(null);
						pQ.setVisible(true);
						try {
							int row = tableProductChoose.getSelectedRow();
							String table_click = (tableProductChoose.getModel().getValueAt(row, 1).toString());
							String sql = "Select * from products where name = '" + table_click + "' ";
							pst = connUtils.connect().prepareStatement(sql);
							rs = pst.executeQuery();
							if (rs.next()) {
								ProductsQuantity.lblTitle.setText(rs.getString("name"));
								if (rs.getString("category_id").equals("1")) {
									ProductsQuantity.lblTitle.setIcon(new ImageIcon(ProductsQuantity.class.getResource("/images/coffee.png")));
								}
								if (rs.getString("category_id").equals("2")) {
									ProductsQuantity.lblTitle.setIcon(new ImageIcon(ProductsQuantity.class.getResource("/images/fruit.png")));
								}
								if (rs.getString("category_id").equals("3")) {
									ProductsQuantity.lblTitle.setIcon(new ImageIcon(ProductsQuantity.class.getResource("/images/milktea.png")));
								}
								if (rs.getString("category_id").equals("4")) {
									ProductsQuantity.lblTitle.setIcon(new ImageIcon(ProductsQuantity.class.getResource("/images/food.png")));
								}
								String b = tableProductChoose.getValueAt(row, 3).toString();
								ProductsQuantity.txtQuantity.setText(b);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

					}
				});
				tableProductChoose.setFont(new Font("Tahoma", Font.PLAIN, 18));
				tableProductChoose.setBounds(0, 0, 1, 1);
				scrollPane_2.setViewportView(tableProductChoose);
				tableProductChoose.setForeground(Color.BLACK);
				tableProductChoose.setRowHeight(30);
				tableProductChoose.setSelectionBackground(new Color(1, 198, 83));
				tableProductChoose.setSelectionForeground(new Color(255, 255, 255));
				tableProductChoose.setGridColor(new Color(255, 255, 255));
				tableProductChoose.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
				
//				panel_6 = new JPanel();
//				panel_6.setBackground(new Color(238, 207, 161));
//				scrollPane_2.setViewportView(panel_6);
//				GridBagLayout gbl_panel_6 = new GridBagLayout();
//				gbl_panel_6.rowHeights = new int[]{0, 0, 0};
//				gbl_panel_6.rowWeights = new double[]{};
//				gbl_panel_6.columnWeights = new double[]{};
//				panel_6.setLayout(gbl_panel_6);
				
////////////////////////////////////////
//				JPanel panel_7 = new JPanel();
//				panel_7.setBorder(new LineBorder(Color.BLACK, 1, true));
//				GridBagConstraints gbc_panel_7 = new GridBagConstraints();
//				gbc_panel_7.insets = new Insets(0, 0, 10, 0);
//				gbc_panel_7.gridx = 0;
//				gbc_panel_7.gridy = 0;
//				panel_7.setPreferredSize(new Dimension(450, 100));
//				panel_7.setLayout(null);
//				panel_6.add(panel_7, gbc_panel_7);
//				
//				JLabel lblNewLabel_2 = new JLabel("New label");
//				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
//				lblNewLabel_2.setBounds(12, 13, 185, 74);
//				panel_7.add(lblNewLabel_2);
//				
//				JLabel lblNewLabel_5 = new JLabel("Đơn giá:");
//				lblNewLabel_5.setForeground(Color.BLACK);
//				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
//				lblNewLabel_5.setBounds(209, 13, 61, 31);
//				panel_7.add(lblNewLabel_5);
//				
//				JLabel lblSLng = new JLabel("Trạn thái:");
//				lblSLng.setForeground(Color.BLACK);
//				lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 15));
//				lblSLng.setBounds(209, 56, 64, 31);
//				panel_7.add(lblSLng);
//				
//				JLabel lblNewLabel_3 = new JLabel("");
//				lblNewLabel_3.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/cancel_48px.png")));
//				lblNewLabel_3.setBounds(390, 27, 48, 48);
//				panel_7.add(lblNewLabel_3);
//				
//				JLabel lblNewLabel_4 = new JLabel("");
//				lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
//				lblNewLabel_4.setBounds(282, 13, 88, 31);
//				panel_7.add(lblNewLabel_4);
//				
//				JLabel label_2 = new JLabel("");
//				label_2.setHorizontalAlignment(SwingConstants.CENTER);
//				label_2.setBounds(282, 56, 88, 31);
//				panel_7.add(label_2);
				
/////////////////////////////////				
				JLabel label_1 = new JLabel("AI Coffee Shop");
				label_1.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/coffee_to_go_48px.png")));
				label_1.setForeground(new Color(57, 113, 177));
				label_1.setFont(new Font("VnArialRoundedBold2", Font.BOLD | Font.ITALIC, 35));
				label_1.setBounds(75, 28, 340, 73);
				panel_5.add(label_1);
				
				lblTimeOrder = new JLabel("");
				lblTimeOrder.setForeground(Color.BLACK);
				lblTimeOrder.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblTimeOrder.setBounds(143, 114, 225, 22);
				panel_5.add(lblTimeOrder);
				
				JLabel lblThanhtienConfirm = new JLabel("Thành tiền:");
				lblThanhtienConfirm.setForeground(Color.BLACK);
				lblThanhtienConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblThanhtienConfirm.setBounds(12, 658, 91, 22);
				panel_5.add(lblThanhtienConfirm);
				
				JLabel lblGiamgiaConfirm = new JLabel("Giảm giá:");
				lblGiamgiaConfirm.setForeground(Color.BLACK);
				lblGiamgiaConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblGiamgiaConfirm.setBounds(12, 720, 79, 22);
				panel_5.add(lblGiamgiaConfirm);
				
				txtThanhtienConfirm = new JLabel("");
				txtThanhtienConfirm.setHorizontalAlignment(SwingConstants.TRAILING);
				txtThanhtienConfirm.setForeground(Color.BLACK);
				txtThanhtienConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtThanhtienConfirm.setBounds(133, 658, 140, 22);
				panel_5.add(txtThanhtienConfirm);
				
				txtGiamgiaOrder = new JTextField();
				txtGiamgiaOrder.setHorizontalAlignment(SwingConstants.TRAILING);
				txtGiamgiaOrder.setText("0");
				txtGiamgiaOrder.setForeground(Color.BLACK);
				txtGiamgiaOrder.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txtGiamgiaOrder.setBounds(133, 720, 140, 22);
				panel_5.add(txtGiamgiaOrder);
				txtGiamgiaOrder.setColumns(10);
				
				JLabel lblNewLabel_2 = new JLabel("VNĐ");
				lblNewLabel_2.setForeground(Color.BLACK);
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblNewLabel_2.setBounds(285, 658, 36, 22);
				panel_5.add(lblNewLabel_2);
				
				JLabel lblTableID = new JLabel("Table:");
				lblTableID.setForeground(Color.BLACK);
				lblTableID.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lblTableID.setBounds(175, 167, 49, 22);
				panel_5.add(lblTableID);
				
				panel_8 = new JPanel();
				panel_8.setBounds(12, 831, 344, 47);
				panel_8.setBackground(new Color(238, 207, 161));
				add(panel_8);
				panel_8.setLayout(null);
		
		
		loadTable();
		loadCombobox();
		loadNumberServing();
		loadMenuCategory();

	}
}
