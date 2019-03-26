package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.MySQLConnUtils;
import bean.Account;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChangePassword extends JFrame {
	MySQLConnUtils connUtils = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;
	MySQLConnUtils conn = connUtils.getInstance();

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtOldPassword;
	private JPasswordField txtNewPassword;
	private JPasswordField txtConfirmNewPassword;
	private JButton btnChangeP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setTitle("\u0110\u1ED5i m\u1EADt kh\u1EA9u");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 33, 35));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(57, 113, 177));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(110, 13, 97, 25);
		contentPane.add(lblUsername);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(110, 100, 350, 2);
		contentPane.add(separator);
		
		JLabel lblOldPassword = new JLabel("Old Password:");
		lblOldPassword.setForeground(new Color(57, 113, 177));
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOldPassword.setBounds(110, 152, 127, 25);
		contentPane.add(lblOldPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(110, 239, 350, 2);
		contentPane.add(separator_1);
		
		txtUsername = new JTextField();
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnChangeP.doClick();
				}
			}
		});
		txtUsername.setForeground(Color.WHITE);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsername.setColumns(10);
		txtUsername.setCaretColor(Color.WHITE);
		txtUsername.setBorder(null);
		txtUsername.setBackground(new Color(32, 33, 35));
		txtUsername.setBounds(110, 62, 350, 25);
		contentPane.add(txtUsername);
		
		txtOldPassword = new JPasswordField();
		txtOldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnChangeP.doClick();
				}
			}
		});
		txtOldPassword.setForeground(Color.WHITE);
		txtOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtOldPassword.setCaretColor(Color.WHITE);
		txtOldPassword.setBorder(null);
		txtOldPassword.setBackground(new Color(32, 33, 35));
		txtOldPassword.setBounds(110, 202, 350, 25);
		contentPane.add(txtOldPassword);
		
		JLabel lblErrUsername = new JLabel("");
		lblErrUsername.setForeground(Color.RED);
		lblErrUsername.setBounds(110, 115, 350, 25);
		contentPane.add(lblErrUsername);
		
		JLabel lblErrOldP = new JLabel("");
		lblErrOldP.setForeground(Color.RED);
		lblErrOldP.setBounds(110, 254, 350, 25);
		contentPane.add(lblErrOldP);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setForeground(new Color(57, 113, 177));
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewPassword.setBounds(110, 292, 136, 25);
		contentPane.add(lblNewPassword);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(110, 379, 350, 2);
		contentPane.add(separator_2);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnChangeP.doClick();
				}
			}
		});
		txtNewPassword.setForeground(Color.WHITE);
		txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNewPassword.setCaretColor(Color.WHITE);
		txtNewPassword.setBorder(null);
		txtNewPassword.setBackground(new Color(32, 33, 35));
		txtNewPassword.setBounds(110, 342, 350, 25);
		contentPane.add(txtNewPassword);
		
		JLabel lblErrNewP = new JLabel("");
		lblErrNewP.setForeground(Color.RED);
		lblErrNewP.setBounds(110, 394, 350, 25);
		contentPane.add(lblErrNewP);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password:");
		lblConfirmNewPassword.setForeground(new Color(57, 113, 177));
		lblConfirmNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmNewPassword.setBounds(110, 432, 211, 25);
		contentPane.add(lblConfirmNewPassword);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(110, 519, 350, 2);
		contentPane.add(separator_3);
		
		txtConfirmNewPassword = new JPasswordField();
		txtConfirmNewPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					btnChangeP.doClick();
				}
			}
		});
		txtConfirmNewPassword.setForeground(Color.WHITE);
		txtConfirmNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtConfirmNewPassword.setCaretColor(Color.WHITE);
		txtConfirmNewPassword.setBorder(null);
		txtConfirmNewPassword.setBackground(new Color(32, 33, 35));
		txtConfirmNewPassword.setBounds(110, 482, 350, 25);
		contentPane.add(txtConfirmNewPassword);
		
		JLabel lblErrConfirmNewP = new JLabel("");
		lblErrConfirmNewP.setForeground(Color.RED);
		lblErrConfirmNewP.setBounds(110, 534, 350, 25);
		contentPane.add(lblErrConfirmNewP);
		
		btnChangeP = new JButton("Change");
		btnChangeP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtUsername.getText().isEmpty()) {
						lblErrUsername.setText("Tên đăng nhập trống!");
					} else {
						lblErrUsername.setText("");
					}
					if (txtOldPassword.getText().isEmpty()) {
						lblErrOldP.setText("Mật khẩu cũ trống!");
					} else {
						lblErrOldP.setText("");
					}
					if (txtNewPassword.getText().isEmpty()) {
						lblErrNewP.setText("Mật khẩu mới trống!");
					} else {
						lblErrNewP.setText("");
					}
					if (txtConfirmNewPassword.getText().isEmpty()) {
						lblErrConfirmNewP.setText("Xác nhận mật khẩu mới trống!");
					} else {
						lblErrConfirmNewP.setText("");
					}
					Statement stmt = null;
					Account account = null;
					String queryC = "select * from accounts where username = '" + txtUsername.getText() + "'";
					stmt = conn.createConnection().createStatement();
					rs = stmt.executeQuery(queryC);
					while (rs.next()) {
						account = new Account();
						account.setId(rs.getString("id"));
						account.setUsername(rs.getString("username"));
						account.setPassword(rs.getString("password"));
						account.setRole(rs.getString("role"));
					}
					if (account == null && !txtUsername.getText().isEmpty() && !txtOldPassword.getText().isEmpty() && !txtNewPassword.getText().isEmpty() && !txtConfirmNewPassword.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Username hoặc Password không hợp lệ!");
					} else if (!txtUsername.getText().isEmpty() && !txtOldPassword.getText().isEmpty() && !txtNewPassword.getText().isEmpty() && !txtConfirmNewPassword.getText().isEmpty()) {	
						if (account.getUsername().equals(txtUsername.getText()) && account.getPassword().equals(txtOldPassword.getText())) {
							if (txtNewPassword.getText().equals(txtConfirmNewPassword.getText()) && !txtNewPassword.getText().isEmpty() && !txtConfirmNewPassword.getText().isEmpty()) {
								connUtils.updateAccount(txtUsername.getText(), txtOldPassword.getText(), txtNewPassword.getText(), txtConfirmNewPassword.getText());
								JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!!!");
								dispose();
							} else {
								lblErrConfirmNewP.setText("Mật khẩu không trùng khớp!");
							}
						}
					}		
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnChangeP.setForeground(Color.WHITE);
		btnChangeP.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		btnChangeP.setBorder(null);
		btnChangeP.setBackground(new Color(57, 113, 177));
		btnChangeP.setBounds(110, 572, 150, 54);
		contentPane.add(btnChangeP);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(57, 113, 177));
		btnCancel.setBounds(310, 572, 150, 54);
		contentPane.add(btnCancel);
	}
}
