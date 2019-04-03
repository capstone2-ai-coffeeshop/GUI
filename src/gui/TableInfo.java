package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TableInfo extends JFrame {

	private JPanel contentPane;
	public static JLabel lblTitleBan;

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
	}
}
