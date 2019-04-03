package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connection.MySQLConnUtils;
import bean.Account;
import login.Login;

import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JLabel;

public class Main extends JFrame {
	MySQLConnUtils connUtils = new MySQLConnUtils();
	ResultSet rs = null;
	PreparedStatement pst = null;

	private JPanel contentPane;
	private JPanel childPanel;
	private JPanel pnMain;
	private JLabel lblClock;
	
	public static JButton btnQuanLy;
	public static JButton btnThongKe;
	public static JLabel lblAccName;
	
	private Connection connection;
	
	MySQLConnUtils instanceSQL = MySQLConnUtils.getInstance();
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					//frame.setUndecorated(true);
					//frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void clock () {
		Thread clock = new Thread() {
			public void run () {
					for (;;) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = LocalDate.now().getMonthValue();
						int year = cal.get(Calendar.YEAR);
						
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR_OF_DAY);
						
						lblClock.setText(day + "/" + month + "/" + year + "   " + hour + ":" + minute + ":" + second);
						
						try {
							sleep(1000);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
		};
		clock.start();
	}
	private void showPanel (JPanel panel) {
		childPanel = panel;
		pnMain.removeAll();
		pnMain.add(childPanel);
		pnMain.validate();
		pnMain.repaint();
	}
	

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("AI Coffee Shop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1030);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        
        JPanel pnMenuBar = new JPanel();
        pnMenuBar.setBackground(new java.awt.Color(205, 179, 139));
        pnMenuBar.setBounds(0, 0, 1902, 75);
        contentPane.add(pnMenuBar);
        
        JButton btnHome = new JButton();
        btnHome.setBounds(12, 0, 210, 75);
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		showPanel(new PanelHome());
        	}
        });
        pnMenuBar.setLayout(null);
        btnHome.setIcon(new ImageIcon(Main.class.getResource("/images/home.png")));
        btnHome.setToolTipText("Trang ch\u1EE7");
        btnHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHome.setForeground(Color.BLACK);
        btnHome.setBackground(Color.WHITE);
        btnHome.setText("Trang ch\u1EE7   ");
        pnMenuBar.add(btnHome);
        
        btnThongKe = new JButton();
        btnThongKe.setBounds(456, 0, 210, 75);
        btnThongKe.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		showPanel(new PanelStatistical());
        	}
        });
        
        JButton btnBanHang = new JButton();
        btnBanHang.setBounds(234, 0, 210, 75);
        btnBanHang.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		showPanel(new PanelOrder());
        	}
        });
        btnBanHang.setIcon(new ImageIcon(Main.class.getResource("/images/order.png")));
        btnBanHang.setToolTipText("B\u00E1n h\u00E0ng");
        btnBanHang.setText("B\u00E1n h\u00E0ng");
        btnBanHang.setForeground(Color.BLACK);
        btnBanHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBanHang.setBackground(Color.WHITE);
        pnMenuBar.add(btnBanHang);
        btnThongKe.setIcon(new ImageIcon(Main.class.getResource("/images/statistical.png")));
        btnThongKe.setToolTipText("Th\u1ED1ng k\u00EA");
        btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThongKe.setForeground(Color.BLACK);
        btnThongKe.setBackground(Color.WHITE);
        btnThongKe.setText("Th\u1ED1ng k\u00EA");
        pnMenuBar.add(btnThongKe);
        
        btnQuanLy = new JButton();
        btnQuanLy.setBounds(678, 0, 210, 75);
        btnQuanLy.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		showPanel(new PanelManage());
        	}
        });
        btnQuanLy.setIcon(new ImageIcon(Main.class.getResource("/images/manage.png")));
        btnQuanLy.setToolTipText("Qu\u1EA3n l\u00FD");
        btnQuanLy.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnQuanLy.setForeground(Color.BLACK);
        btnQuanLy.setBackground(Color.WHITE);
        btnQuanLy.setText("Qu\u1EA3n l\u00FD");
        pnMenuBar.add(btnQuanLy);
        
        JButton btnThoat = new JButton();
        btnThoat.setBounds(1160, 0, 210, 75);
        btnThoat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//System.exit(0);
        		int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát ?!", "", JOptionPane.YES_NO_OPTION);
        		if (response == JOptionPane.YES_OPTION) {
        			dispose();
        			Login lg = new Login();
        			lg.setLocationRelativeTo(null);
        			lg.setVisible(true);
        		}
        	}
        });
        btnThoat.setIcon(new ImageIcon(Main.class.getResource("/images/exit.png")));
        btnThoat.setToolTipText("Tho\u00E1t");
        btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnThoat.setForeground(Color.BLACK);
        btnThoat.setBackground(Color.WHITE);
        btnThoat.setText("Tho\u00E1t");
        pnMenuBar.add(btnThoat);
        
        lblClock = new JLabel();
        lblClock.setBounds(1710, 0, 192, 34);
        lblClock.setForeground(Color.BLACK);
        lblClock.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pnMenuBar.add(lblClock);
        
        lblAccName = new JLabel();
        lblAccName.setForeground(Color.BLACK);
        lblAccName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAccName.setBounds(1732, 41, 170, 34);
        pnMenuBar.add(lblAccName);
        
        lblNewLabel = new JLabel("Xin chào, ");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(1642, 41, 88, 34);
        pnMenuBar.add(lblNewLabel);
        
        JButton btnChangeP = new JButton("Đổi mật khẩu");
        btnChangeP.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		ChangePassword cP = new ChangePassword();
				cP.setLocationRelativeTo(null);
				cP.setVisible(true);
        	}
        });
        btnChangeP.setIcon(new ImageIcon(Main.class.getResource("/images/lock.png")));
        btnChangeP.setForeground(Color.BLACK);
        btnChangeP.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnChangeP.setBackground(Color.WHITE);
        btnChangeP.setBounds(900, 0, 248, 75);
        pnMenuBar.add(btnChangeP);
        
        pnMain = new JPanel();
        pnMain.setBackground(new Color(0, 0, 0, 200));
        pnMain.setBounds(0, 78, 1902, 905);
        contentPane.add(pnMain);
        pnMain.setLayout(new BorderLayout(0, 0));
        
        JLabel label = new JLabel("");
        label.setBounds(0, 78, 1902, 905);
        contentPane.add(label);
        label.setIcon(new ImageIcon(Main.class.getResource("/images/bgcoffee3.jpg")));

        clock();
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
