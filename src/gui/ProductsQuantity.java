package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import gui.PanelOrder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.event.AncestorListener;

import Connection.MySQLConnUtils;

import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductsQuantity extends JFrame {
	MySQLConnUtils connUtils = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private static ProductsQuantity obj = null;
	public static JLabel lblTitle;
	public static JTextField txtQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductsQuantity frame = new ProductsQuantity();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductsQuantity() {
		setTitle("S\u1ED1 l\u01B0\u1EE3ng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 389, 323);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(32, 33, 35));
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitle.setBounds(12, 13, 347, 31);
		contentPane.add(lblTitle);
		
		JButton btnXacnhan = new JButton("X\u00E1c nh\u1EADn");
		btnXacnhan.setBorder(null);
		btnXacnhan.setIcon(new ImageIcon(ProductsQuantity.class.getResource("/images/checkmark_40px.png")));
		btnXacnhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				int rowUpdate = PanelOrder.tableProductChoose.getSelectedRow();
				int bUpdate = Integer.parseInt(txtQuantity.getText());
				Object xUpdate = (Integer)bUpdate;
				PanelOrder.tableProductChoose.getModel().setValueAt(xUpdate, rowUpdate, 3);
				double z = 0;
				DecimalFormat formatter = new DecimalFormat("###,###,###.##");
				for (int y = 0; y < PanelOrder.tableProductChoose.getRowCount(); y++) {
					double t = Double.parseDouble(String.valueOf(PanelOrder.tableProductChoose.getValueAt(y, 2))) * Double.parseDouble(String.valueOf(PanelOrder.tableProductChoose.getValueAt(y, 3)));
					z += t;
					PanelOrder.txtThanhtienConfirm.setText(formatter.format(z));
				}
			}
		});
		btnXacnhan.setBackground(Color.WHITE);
		btnXacnhan.setForeground(Color.BLACK);
		btnXacnhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXacnhan.setBounds(12, 224, 159, 39);
		contentPane.add(btnXacnhan);
		
		JButton btnHuy = new JButton("H\u1EE7y");
		btnHuy.setBorder(null);
		btnHuy.setIcon(new ImageIcon(ProductsQuantity.class.getResource("/images/delete_sign_40px.png")));
		btnHuy.setBackground(Color.WHITE);
		btnHuy.setForeground(Color.BLACK);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuy.setBounds(200, 224, 159, 39);
		contentPane.add(btnHuy);
		
		txtQuantity = new JTextField();
		txtQuantity.setForeground(Color.WHITE);
		txtQuantity.setBackground(new Color(32, 33, 35));
		txtQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtQuantity.setBounds(12, 95, 159, 50);
		txtQuantity.setBorder(null);
		txtQuantity.setCaretColor(new Color(255, 255, 255));
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblMinus = new JLabel("");
		lblMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = Integer.parseInt(txtQuantity.getText());
				x--;
				txtQuantity.setText(Integer.toString(x));
			}
		});
		lblMinus.setIcon(new ImageIcon(ProductsQuantity.class.getResource("/images/minus_math_60px.png")));
		lblMinus.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinus.setBounds(200, 95, 56, 50);
		contentPane.add(lblMinus);
		
		JLabel lblPlus = new JLabel("");
		lblPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int x = Integer.parseInt(txtQuantity.getText());
				x++;
				txtQuantity.setText(Integer.toString(x));
			}
		});
		lblPlus.setIcon(new ImageIcon(ProductsQuantity.class.getResource("/images/plus_math_60px.png")));
		lblPlus.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlus.setBounds(303, 95, 56, 50);
		contentPane.add(lblPlus);
		
	}
}
