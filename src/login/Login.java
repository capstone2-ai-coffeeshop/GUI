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
import java.sql.Statement;
import java.util.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import diu.swe.habib.JPanelSlider.JPanelSlider;

public class Login extends JFrame {
	MySQLConnUtils connUtils = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	
	private JPanel panel_1;
	private JPanel panel_2;

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
		setBounds(600, 300, 913, 594);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JPanelSlider panelSlider = new JPanelSlider();
		panelSlider.setBackground(new Color(32, 33, 35));
		panelSlider.setBounds(422, 0, 476, 561);
		contentPane.add(panelSlider);
		
		panel_1 = new JPanel();
		panelSlider.add(panel_1, "name_463387385600500");
		panel_1.setBackground(new Color(32, 33, 35));
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
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					btnLogin.doClick();
				}
			}
		});
		txtUsername.setText("adminking");
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
		txtPassword.setText("123123");
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
		
		JLabel lblErrPassword = new JLabel("");
		lblErrPassword.setForeground(Color.RED);
		lblErrPassword.setBounds(61, 303, 350, 25);
		panel_1.add(lblErrPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (txtUsername.getText().isEmpty()) {
						lblErrUsername.setText("Tên đăng nhập trống!");
					} else {
						lblErrUsername.setText("");
					}
					if (txtPassword.getText().isEmpty()) {
						lblErrPassword.setText("Mật khẩu trống!");
					} else {
						lblErrPassword.setText("");
					}
					Statement stmt = null;
					Account account = null;
					String queryC = "select * from accounts where username = '" + txtUsername.getText() + "'";
					stmt = connUtils.createConnection().createStatement();
					rs = stmt.executeQuery(queryC);
					while (rs.next()) {
						account = new Account();
						account.setId(rs.getString("id"));
						account.setUsername(rs.getString("username"));
						account.setPassword(rs.getString("password"));
						account.setRole(rs.getString("role"));
					}
					if (account == null && !txtUsername.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Username không hợp lệ!");
					} else if (!txtUsername.getText().isEmpty() && !txtPassword.getText().isEmpty()) {
						if (!txtPassword.getText().equals(account.getPassword())) {
							JOptionPane.showMessageDialog(null, "Password không hợp lệ!");
						}
						if (txtUsername.getText().equals(account.getUsername()) && txtPassword.getText().equals(account.getPassword())) {
							dispose();
							Main m = new Main();
							m.setVisible(true);
							Main.lblAccName.setText(txtUsername.getText());
							if (account.getRole().equals("1")) {
								Main.btnThongKe.setEnabled(true);
								Main.btnQuanLy.setEnabled(true);
							} else {
								Main.btnThongKe.setEnabled(false);
								Main.btnQuanLy.setEnabled(false);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		btnLogin.setBounds(61, 373, 350, 54);
		btnLogin.setBackground(new Color(57, 113, 177));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBorder(null);
		panel_1.add(btnLogin);
		
		JLabel lblForgotPassword = new JLabel("Forgot password ?!");
		lblForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panelSlider.nextPanel(10, panel_2, panelSlider.left);
			}
		});
		lblForgotPassword.setForeground(new Color(57, 113, 177));
		lblForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblForgotPassword.setBounds(161, 440, 152, 25);
		panel_1.add(lblForgotPassword);
		
		panel_2 = new JPanel();
		panelSlider.add(panel_2, "name_463392475687300");
		panel_2.setBackground(new Color(32, 33, 35));
		panel_2.setLayout(null);
		
		
		JLabel lblQuayLai = new JLabel("Quay lại");
		lblQuayLai.setIcon(new ImageIcon(Login.class.getResource("/images/left_25px.png")));
		lblQuayLai.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				panelSlider.nextPanel(10, panel_1, panelSlider.right);
			}
		});
		lblQuayLai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuayLai.setBounds(12, 13, 105, 25);
		lblQuayLai.setForeground(new Color(57, 113, 177));
		panel_2.add(lblQuayLai);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(22, 37, 85, 10);
		separator_3.setForeground(new Color(57, 113, 177));
		separator_3.setBackground(new Color(57, 113, 177));
		panel_2.add(separator_3);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(57, 113, 177));
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(61, 166, 97, 25);
		panel_2.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		txtEmail.setCaretColor(Color.WHITE);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(32, 33, 35));
		txtEmail.setBounds(61, 215, 350, 25);
		panel_2.add(txtEmail);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(61, 253, 350, 2);
		panel_2.add(separator_4);
		
		JButton btnXacnhan = new JButton("Send");
		btnXacnhan.setForeground(Color.WHITE);
		btnXacnhan.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		btnXacnhan.setBorder(null);
		btnXacnhan.setBackground(new Color(57, 113, 177));
		btnXacnhan.setBounds(61, 373, 350, 54);
		panel_2.add(btnXacnhan);
		
	}
}
