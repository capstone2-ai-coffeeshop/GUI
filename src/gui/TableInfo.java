package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Connection.MySQLConnUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import gui.PanelOrder;
import bean.Tables;

public class TableInfo extends JFrame {
	MySQLConnUtils connUtils = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	public static JLabel lblTitleBan;
	public static JTextField txtSLKhach;
	public static JTextField txtStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableInfo frame = new TableInfo();
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
	public TableInfo() {
		setTitle("Th\u00F4ng tin b\u00E0n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 33, 35));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitleBan = new JLabel("");
		lblTitleBan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleBan.setForeground(new Color(255, 255, 255));
		lblTitleBan.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblTitleBan.setBounds(230, 13, 47, 31);
		contentPane.add(lblTitleBan);
		
		JLabel lblBn = new JLabel("B\u00E0n");
		lblBn.setHorizontalAlignment(SwingConstants.CENTER);
		lblBn.setForeground(Color.WHITE);
		lblBn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBn.setBounds(189, 13, 47, 31);
		contentPane.add(lblBn);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TableInfo.class.getResource("/images/tableware_24px.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		label.setBounds(141, 13, 47, 31);
		contentPane.add(label);
		
		JLabel lblSLngKhch = new JLabel("S\u1ED1 l\u01B0\u1EE3ng kh\u00E1ch:");
		lblSLngKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSLngKhch.setForeground(Color.WHITE);
		lblSLngKhch.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSLngKhch.setBounds(12, 68, 148, 36);
		contentPane.add(lblSLngKhch);
		
		JLabel lblStatus = new JLabel("Tr\u1EA1ng th\u00E1i:");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setForeground(Color.WHITE);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblStatus.setBounds(12, 127, 148, 36);
		contentPane.add(lblStatus);
		
		JButton btnDonBan = new JButton("D\u1ECDn b\u00E0n");
		btnDonBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				connUtils.updateTable(lblTitleBan.getText(), "0", "No description", "0");
				PanelOrder.panel.removeAll();
				PanelOrder.panel_5.remove(PanelOrder.cbbTableID);
				PanelOrder.loadTable();
				PanelOrder.loadCombobox();
				PanelOrder.panel_5.revalidate();
				PanelOrder.panel_5.repaint();
				PanelOrder.panel.revalidate();
				PanelOrder.panel.repaint();
				PanelOrder.panel_8.removeAll();
				PanelOrder.loadNumberServing();
				PanelOrder.panel_8.revalidate();
				PanelOrder.panel_8.repaint();
			}
		});
		btnDonBan.setIcon(new ImageIcon(TableInfo.class.getResource("/images/broom_40px.png")));
		btnDonBan.setForeground(Color.BLACK);
		btnDonBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDonBan.setBorder(null);
		btnDonBan.setBackground(Color.WHITE);
		btnDonBan.setBounds(40, 214, 159, 39);
		contentPane.add(btnDonBan);
		
		JButton btnHuy = new JButton("H\u1EE7y");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHuy.setIcon(new ImageIcon(TableInfo.class.getResource("/images/delete_sign_40px.png")));
		btnHuy.setForeground(Color.BLACK);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuy.setBorder(null);
		btnHuy.setBackground(Color.WHITE);
		btnHuy.setBounds(228, 214, 159, 39);
		contentPane.add(btnHuy);
		
		txtSLKhach = new JTextField();
		txtSLKhach.setHorizontalAlignment(SwingConstants.CENTER);
		txtSLKhach.setForeground(Color.WHITE);
		txtSLKhach.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtSLKhach.setColumns(10);
		txtSLKhach.setCaretColor(Color.WHITE);
		txtSLKhach.setBorder(null);
		txtSLKhach.setBackground(new Color(32, 33, 35));
		txtSLKhach.setBounds(199, 68, 188, 36);
		contentPane.add(txtSLKhach);
		
		txtStatus = new JTextField();
		txtStatus.setHorizontalAlignment(SwingConstants.CENTER);
		txtStatus.setForeground(Color.WHITE);
		txtStatus.setFont(new Font("Tahoma", Font.PLAIN, 19));
		txtStatus.setColumns(10);
		txtStatus.setCaretColor(Color.WHITE);
		txtStatus.setBorder(null);
		txtStatus.setBackground(new Color(32, 33, 35));
		txtStatus.setBounds(199, 127, 188, 36);
		contentPane.add(txtStatus);
	}
}
