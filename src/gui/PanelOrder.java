package gui;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;

public class PanelOrder extends JPanel {
	private JTextField txtCapheden;
	private JTextField txtCaphesua;
	private JTextField txtBacxiu;
	private JTextField txtCaphedenSG;
	private JTextField txtCacao;
	private JTextField txtDua;
	private JTextField txtXoai;
	private JTextField txtDau;
	private JTextField txtBo;
	private JTextField txtChuoi;

	/**
	 * Create the panel.
	 */
	public PanelOrder() {
		setForeground(Color.BLACK);
		setBackground(new Color(238, 207, 161));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "B\u00E0n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 344, 849);
		panel.setBackground(new Color(238, 207, 161));
		add(panel);
		
		JButton btnBan1 = new JButton("1");
		btnBan1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBan1.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/table2.png")));
		btnBan1.setBackground(Color.WHITE);
		panel.add(btnBan1);
		
		JButton btnBan2 = new JButton("2");
		btnBan2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBan2.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/table2.png")));
		btnBan2.setBackground(Color.WHITE);
		panel.add(btnBan2);
		
		JButton btnBan3 = new JButton("3");
		btnBan3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBan3.setIcon(new ImageIcon(PanelOrder.class.getResource("/images/table2.png")));
		btnBan3.setBackground(Color.WHITE);
		panel.add(btnBan3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Ch\u1ECDn m\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(238, 207, 161));
		panel_1.setBounds(368, 13, 539, 849);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_3.setBounds(12, 29, 515, 459);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JCheckBox chbCapheden = new JCheckBox("Cà phê đen");
		chbCapheden.setForeground(Color.BLACK);
		chbCapheden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chbCapheden.isSelected()) {
					txtCapheden.setEnabled(true);
					txtCapheden.setEditable(true);
					txtCapheden.requestFocus();
					txtCapheden.setText("");
				} else {
					txtCapheden.setEnabled(false);
					txtCapheden.setEditable(false);
					txtCapheden.setText("0");
				}
			}
		});
		chbCapheden.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbCapheden.setBounds(8, 47, 113, 25);
		panel_3.add(chbCapheden);
		
		JLabel lblCaphe = new JLabel("Cà phê");
		lblCaphe.setForeground(Color.BLACK);
		lblCaphe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCaphe.setBounds(12, 13, 98, 22);
		panel_3.add(lblCaphe);
		
		JCheckBox chbCaphesua = new JCheckBox("Cà phê sữa");
		chbCaphesua.setForeground(Color.BLACK);
		chbCaphesua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbCaphesua.setBounds(8, 77, 113, 25);
		panel_3.add(chbCaphesua);
		
		JCheckBox chbCaphedenSG = new JCheckBox("Cà phê đen SG");
		chbCaphedenSG.setForeground(Color.BLACK);
		chbCaphedenSG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbCaphedenSG.setBounds(252, 47, 127, 25);
		panel_3.add(chbCaphedenSG);
		
		JCheckBox chbCacao = new JCheckBox("Ca cao");
		chbCacao.setForeground(Color.BLACK);
		chbCacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbCacao.setBounds(252, 77, 113, 25);
		panel_3.add(chbCacao);
		
		JCheckBox chbBacxiu = new JCheckBox("Bạc xỉu");
		chbBacxiu.setForeground(Color.BLACK);
		chbBacxiu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbBacxiu.setBounds(8, 107, 113, 25);
		panel_3.add(chbBacxiu);
		
		JLabel lblSinhTo = new JLabel("Sinh tố");
		lblSinhTo.setForeground(Color.BLACK);
		lblSinhTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSinhTo.setBounds(8, 142, 98, 22);
		panel_3.add(lblSinhTo);
		
		JCheckBox chbDua = new JCheckBox("Dừa");
		chbDua.setForeground(Color.BLACK);
		chbDua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbDua.setBounds(8, 173, 70, 25);
		panel_3.add(chbDua);
		
		JCheckBox chbXoai = new JCheckBox("Xoài");
		chbXoai.setForeground(Color.BLACK);
		chbXoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbXoai.setBounds(8, 203, 70, 25);
		panel_3.add(chbXoai);
		
		JCheckBox chbDau = new JCheckBox("Dâu");
		chbDau.setForeground(Color.BLACK);
		chbDau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbDau.setBounds(8, 233, 70, 25);
		panel_3.add(chbDau);
		
		JCheckBox chbBo = new JCheckBox("Bơ");
		chbBo.setForeground(Color.BLACK);
		chbBo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbBo.setBounds(260, 174, 70, 25);
		panel_3.add(chbBo);
		
		JCheckBox chbChuoi = new JCheckBox("Chuối");
		chbChuoi.setForeground(Color.BLACK);
		chbChuoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chbChuoi.setBounds(260, 204, 70, 25);
		panel_3.add(chbChuoi);
		
		txtCapheden = new JTextField();
		txtCapheden.setText("0");
		txtCapheden.setHorizontalAlignment(SwingConstants.CENTER);
		txtCapheden.setEditable(false);
		txtCapheden.setEnabled(false);
		txtCapheden.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCapheden.setForeground(Color.BLACK);
		txtCapheden.setBounds(129, 47, 115, 25);
		panel_3.add(txtCapheden);
		txtCapheden.setColumns(10);
		
		txtCaphesua = new JTextField();
		txtCaphesua.setText("0");
		txtCaphesua.setHorizontalAlignment(SwingConstants.CENTER);
		txtCaphesua.setEditable(false);
		txtCaphesua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCaphesua.setForeground(Color.BLACK);
		txtCaphesua.setEnabled(false);
		txtCaphesua.setColumns(10);
		txtCaphesua.setBounds(129, 79, 115, 25);
		panel_3.add(txtCaphesua);
		
		txtBacxiu = new JTextField();
		txtBacxiu.setText("0");
		txtBacxiu.setHorizontalAlignment(SwingConstants.CENTER);
		txtBacxiu.setEditable(false);
		txtBacxiu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBacxiu.setForeground(Color.BLACK);
		txtBacxiu.setEnabled(false);
		txtBacxiu.setColumns(10);
		txtBacxiu.setBounds(129, 109, 115, 25);
		panel_3.add(txtBacxiu);
		
		txtCaphedenSG = new JTextField();
		txtCaphedenSG.setText("0");
		txtCaphedenSG.setHorizontalAlignment(SwingConstants.CENTER);
		txtCaphedenSG.setEditable(false);
		txtCaphedenSG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCaphedenSG.setForeground(Color.BLACK);
		txtCaphedenSG.setEnabled(false);
		txtCaphedenSG.setColumns(10);
		txtCaphedenSG.setBounds(387, 47, 115, 25);
		panel_3.add(txtCaphedenSG);
		
		txtCacao = new JTextField();
		txtCacao.setText("0");
		txtCacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtCacao.setEditable(false);
		txtCacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCacao.setForeground(Color.BLACK);
		txtCacao.setEnabled(false);
		txtCacao.setColumns(10);
		txtCacao.setBounds(387, 79, 115, 25);
		panel_3.add(txtCacao);
		
		txtDua = new JTextField();
		txtDua.setText("0");
		txtDua.setHorizontalAlignment(SwingConstants.CENTER);
		txtDua.setEditable(false);
		txtDua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDua.setForeground(Color.BLACK);
		txtDua.setEnabled(false);
		txtDua.setColumns(10);
		txtDua.setBounds(129, 173, 115, 25);
		panel_3.add(txtDua);
		
		txtXoai = new JTextField();
		txtXoai.setText("0");
		txtXoai.setHorizontalAlignment(SwingConstants.CENTER);
		txtXoai.setEditable(false);
		txtXoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtXoai.setForeground(Color.BLACK);
		txtXoai.setEnabled(false);
		txtXoai.setColumns(10);
		txtXoai.setBounds(129, 205, 115, 25);
		panel_3.add(txtXoai);
		
		txtDau = new JTextField();
		txtDau.setText("0");
		txtDau.setHorizontalAlignment(SwingConstants.CENTER);
		txtDau.setEditable(false);
		txtDau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDau.setForeground(Color.BLACK);
		txtDau.setEnabled(false);
		txtDau.setColumns(10);
		txtDau.setBounds(129, 235, 115, 25);
		panel_3.add(txtDau);
		
		txtBo = new JTextField();
		txtBo.setText("0");
		txtBo.setHorizontalAlignment(SwingConstants.CENTER);
		txtBo.setEditable(false);
		txtBo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBo.setForeground(Color.BLACK);
		txtBo.setEnabled(false);
		txtBo.setColumns(10);
		txtBo.setBounds(387, 175, 115, 25);
		panel_3.add(txtBo);
		
		txtChuoi = new JTextField();
		txtChuoi.setText("0");
		txtChuoi.setHorizontalAlignment(SwingConstants.CENTER);
		txtChuoi.setEditable(false);
		txtChuoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtChuoi.setForeground(Color.BLACK);
		txtChuoi.setEnabled(false);
		txtChuoi.setColumns(10);
		txtChuoi.setBounds(387, 205, 115, 25);
		panel_3.add(txtChuoi);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_4.setBounds(12, 501, 515, 238);
		panel_1.add(panel_4);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(12, 770, 117, 48);
		panel_1.add(btnNewButton_2);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(410, 770, 117, 48);
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(212, 770, 117, 48);
		panel_1.add(button_8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(238, 207, 161));
		panel_2.setBounds(919, 13, 464, 849);
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
		lblGoiY.setBounds(12, 99, 140, 22);
		panel_2.add(lblGoiY);
		
		JLabel lblCacMonChon = new JLabel("Các món đã chọn:");
		lblCacMonChon.setForeground(Color.BLACK);
		lblCacMonChon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCacMonChon.setBounds(12, 236, 157, 22);
		panel_2.add(lblCacMonChon);
		
		JLabel lblThanhTien = new JLabel("Thành tiền:");
		lblThanhTien.setForeground(Color.BLACK);
		lblThanhTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThanhTien.setBounds(12, 627, 99, 22);
		panel_2.add(lblThanhTien);
		
		JLabel lblMaGiamGia = new JLabel("Mã giảm giá:");
		lblMaGiamGia.setForeground(Color.BLACK);
		lblMaGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaGiamGia.setBounds(12, 662, 115, 22);
		panel_2.add(lblMaGiamGia);
		
		JLabel lblTngCng = new JLabel("Tổng cộng:");
		lblTngCng.setForeground(Color.BLACK);
		lblTngCng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTngCng.setBounds(12, 697, 99, 22);
		panel_2.add(lblTngCng);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setForeground(Color.BLACK);
		btnThanhToan.setBackground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThanhToan.setBounds(161, 758, 140, 55);
		panel_2.add(btnThanhToan);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblId.setBounds(12, 31, 59, 22);
		panel_2.add(lblId);

	}
}
