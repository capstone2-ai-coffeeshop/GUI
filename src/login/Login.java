package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.MySQLConnUtils;
import bean.Account;
import gui.Main;
import gui.PanelManage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {
	MySQLConnUtils connUtils = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setLocationRelativeTo(null);
					//frame.setUndecorated(true);
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
	public Login() {
		setTitle("\u0110\u0102NG NH\u1EACP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 916, 608);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(424, 0, 474, 561);
		panel_1.setBackground(new Color(32, 33, 35));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(61, 62, 97, 25);
		lblUsername.setForeground(new Color(57, 113, 177));
		panel_1.add(lblUsername);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(61, 149, 350, 2);
		panel_1.add(separator);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(51, 52, 54));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(61, 201, 97, 25);
		panel_1.add(lblPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(61, 288, 350, 2);
		panel_1.add(separator_1);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblUsername.setForeground(new Color(57, 113, 177));
				lblPassword.setForeground(new Color(51, 52, 54));
			}
		});
		txtUsername.setForeground(new Color(255, 255, 255));
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtUsername.setBounds(61, 111, 350, 25);
		txtUsername.setBackground(new Color(32, 33, 35));
		txtUsername.setBorder(null);
		txtUsername.setCaretColor(new Color(255, 255, 255));
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					btnLogin.doClick();
				}
			}
		});
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblPassword.setForeground(new Color(57, 113, 177));
				lblUsername.setForeground(new Color(51, 52, 54));
			}
		});
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPassword.setBounds(61, 251, 350, 25);
		txtPassword.setBackground(new Color(32, 33, 35));
		txtPassword.setForeground(new Color(255, 255, 255));
		txtPassword.setCaretColor(new Color(255, 255, 255));
		txtPassword.setBorder(null);
		panel_1.add(txtPassword);
		
		JLabel lblErrUsername = new JLabel("");
		lblErrUsername.setForeground(new Color(255, 0, 0));
		lblErrUsername.setBounds(61, 164, 350, 25);
		panel_1.add(lblErrUsername);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 0, 0, 100));
		panel_3.setBounds(0, 0, 424, 561);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("AI Coffee Shop");
		lblNewLabel.setFont(new Font("VnArialRoundedBold2", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(65, 115, 289, 73);
		lblNewLabel.setForeground(new Color(57, 113, 177));
		panel_3.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 424, 561);
		contentPane.add(label_1);
		label_1.setIcon(new ImageIcon(Login.class.getResource("/images/bgcoffee.jpg")));
		
		JLabel lblErrPassword = new JLabel("");
		lblErrPassword.setForeground(Color.RED);
		lblErrPassword.setBounds(61, 303, 350, 25);
		panel_1.add(lblErrPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					List<Account> accounts = connUtils.getAccounts();
					for (Account account : accounts) {
						if (txtUsername.getText().equals(account.getUsername()) && txtPassword.getText().equals(account.getPassword())) {
							dispose();
							Main m = new Main();
							m.setVisible(true);
							Main.lblAccName.setText("Xin chào, " + txtUsername.getText() + "!");
							if (account.getRole().equals("1")) {
								Main.btnThongKe.setEnabled(true);
								Main.btnQuanLy.setEnabled(true);
							} else {
								Main.btnThongKe.setEnabled(false);
								Main.btnQuanLy.setEnabled(false);
							}
						}
						if (txtUsername.getText().isEmpty()) {
							lblErrUsername.setText("Tên đăng nhập trống!");
						}
						if (txtUsername.getText().isEmpty()) {
							lblErrPassword.setText("Mật khẩu trống!");
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnLogin.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		btnLogin.setBounds(61, 373, 350, 54);
		btnLogin.setBackground(new Color(57, 113, 177));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBorder(null);
		panel_1.add(btnLogin);
		
	}
}
