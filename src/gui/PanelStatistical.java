package gui;
import javax.swing.JPanel;

import java.awt.Color;

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
import java.util.Date;
import java.util.Calendar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
import java.awt.event.ActionEvent;


public class PanelStatistical extends JPanel {
	
	private Connection connection;
	
	MySQLConnUtils instanceSQL = MySQLConnUtils.getInstance();
	MySQLConnUtils mySQLCon = new MySQLConnUtils();
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelStatistical() {
		mySQLCon.connect();
		setBounds(0, 78, 1395, 875);
		setBackground(new Color(238, 207, 161));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 1371, 849);
		panel.setBackground(new Color(238, 207, 161));
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)), "T\u00F9y ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(12, 29, 1347, 127);
		panel_1.setBackground(new Color(238, 207, 161));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u1EEB ng\u00E0y:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(40, 44, 100, 37);
		panel_1.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(152, 44, 120, 37);
		panel_1.add(dateChooser);
		
		JLabel lblnNgy = new JLabel("\u0110\u1EBFn ng\u00E0y:");
		lblnNgy.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblnNgy.setBounds(347, 44, 120, 37);
		panel_1.add(lblnNgy);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBounds(479, 44, 120, 37);
		panel_1.add(dateChooser_1);
		
		JButton btnNewButton = new JButton("Li\u1EC7t k\u00EA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				String load_data = "SELECT * FROM user";
//				PreparedStatement pst = null;
//				connection = instanceSQL.connect();
//				try {
//					pst = connection.prepareStatement(load_data);
//					connection = instanceSQL.connect();
//					ResultSet rs = pst.executeQuery();
//					table.setModel(DbUtils.resultSetToTableModel(rs));
//				} catch (SQLException e) {
//					System.out.println("Lỗi rồi");
//				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(694, 44, 155, 37);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 169, 1337, 667);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}
