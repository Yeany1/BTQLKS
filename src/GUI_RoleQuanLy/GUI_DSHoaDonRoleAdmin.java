package GUI_RoleQuanLy;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;

public class GUI_DSHoaDonRoleAdmin extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtTimKiem;
	private JTable table;
	private DefaultTableModel model;
	
	private static final long serialVersionUID = 1L;
	private JLabel lblStaffName, lblRole, lbDS, lbSapXep;
	public JButton btnBack, btnLogout, btnQLNV, btnQLKH, btnTCHD, btnQLP, btnQLDV;
	private JButton btnQLNV_1;
	public JTextField txtTongSoPhong, txtTim, txtMaNV, txtTenNV, txtDay;
	private static JButton[] phong;
	Box b3;
	JScrollPane scroll;
	JComboBox<String> cmbSapXep, cmbTimKiem;
	GridLayout test;
	private JButton btnTimKiem_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DSHoaDonRoleAdmin frame = new GUI_DSHoaDonRoleAdmin();
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
	public GUI_DSHoaDonRoleAdmin() {
		setTitle("Quản Lí Khách Sạn");
		setBackground(new Color(244, 247, 254));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1400, 690);
		setLocationRelativeTo(null);
		setSize(new Dimension(1032, 688));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 247, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 247, 669);
		leftPanel.setBackground(new Color(25, 118, 211));
		contentPane.add(leftPanel);
		leftPanel.setLayout(null);
 
		JLabel lblNewLabel = new JLabel("QUẢN LÝ KHÁCH SẠN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(-10, 20, 275, 40);
		leftPanel.add(lblNewLabel);

		JLabel avt = new JLabel("");
		avt.setBounds(90, 80, 64, 64);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/icon/admin_avt_64.png"));
		avt.setIcon(img);
		leftPanel.add(avt);

		lblStaffName = new JLabel("");
		lblStaffName.setForeground(Color.WHITE);
		lblStaffName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStaffName.setBounds(0, 154, 275, 25);
		leftPanel.add(lblStaffName);

		lblRole = new JLabel("");
		lblRole.setForeground(new Color(163, 174, 208));
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRole.setBounds(0, 175, 275, 25);
		leftPanel.add(lblRole);
		
		btnQLKH = new JButton("Quản Lý Khách Hàng");
		btnQLKH.setForeground(Color.BLACK);
		btnQLKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLKH.setBounds(20, 220, 200, 30);
		btnQLKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_KhachHang().setVisible(true);
				dispose();
			}
		});
		
		btnQLNV = new JButton("QUản Lý Nhân Viên");
		btnQLNV.setForeground(Color.BLACK);
		btnQLNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLNV.setBounds(20, 270, 200, 30);
		btnQLNV_1 = new JButton("QUản Lý Nhân Viên");
		btnQLNV_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLNV_1.setLocation(20, 269);
		btnQLNV_1.setSize(200, 30);
		btnQLNV_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_NhanVien().setVisible(true);
				dispose();
			}
		});
		
		btnQLP = new JButton("Quản Lý Phòng");
		btnQLP.setForeground(Color.BLACK);
		btnQLP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLP.setBounds(20, 320, 200, 30);
		btnQLP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLyPhong().setVisible(true);
				dispose();
			}
		});
		
		btnQLDV = new JButton("Quản Lý Dịch Vụ");
		btnQLDV.setForeground(Color.BLACK);
		btnQLDV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLDV.setBounds(20, 370, 200, 30);
		btnQLDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_QuanLiSanPHam().setVisible(true);
				dispose();
			}
		});
		
		btnTCHD = new JButton("Tra Cứu Hóa Đơn");
		btnTCHD.setForeground(Color.BLACK);
		btnTCHD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTCHD.setBounds(20, 420, 200, 30);
		
		btnLogout = new JButton("Đăng Xuất");
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogout.setBounds(20, 600, 200, 30);
		
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				System.exit(0);
			}
		});
		leftPanel.add(btnLogout);
		leftPanel.add(btnQLNV_1);
		leftPanel.add(btnQLKH);
		leftPanel.add(btnQLP);
		leftPanel.add(btnQLDV);
		leftPanel.add(btnTCHD);
		
		JButton btnBackHome = new JButton("Back");
		btnBackHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new GUI_ThongKe().setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBackHome.setForeground(Color.BLACK);
		btnBackHome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBackHome.setBounds(20, 466, 200, 30);
		leftPanel.add(btnBackHome);
		
		btnQLKH.addActionListener(this);
		btnQLKH.addActionListener(this);
		btnQLNV_1.addActionListener(this);
		btnQLP.addActionListener(this);
		btnQLDV.addActionListener(this);
		btnTCHD.addActionListener(this);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(246, 0, 779, 98);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(186, 52, 183, 20);
		panel_3.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(GUI_DSHoaDonRoleAdmin.class.getResource("/icon/search-icon-small.png")));
		btnTimKiem.setBounds(379, 52, 126, 20);
		panel_3.add(btnTimKiem);
		btnTimKiem.setForeground(new Color(0, 127, 255));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setBackground(Color.WHITE);

		JComboBox comboBoxMaKH = new JComboBox();
		comboBoxMaKH.setModel(new DefaultComboBoxModel(new String[] {"Tên Khách Hàng:", "Mã Khách Hàng:"}));
		comboBoxMaKH.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxMaKH.setBounds(23, 50, 153, 21);
		panel_3.add(comboBoxMaKH);
		
		JLabel lblDanhSchn = new JLabel("DANH SÁCH ĐƠN HÀNG");
		lblDanhSchn.setForeground(new Color(0, 127, 255));
		lblDanhSchn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhSchn.setBackground(new Color(64, 0, 64));
		lblDanhSchn.setBounds(284, 11, 204, 20);
		panel_3.add(lblDanhSchn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 127, 255));
		panel_2.setBounds(295, 29, 168, 2);
		panel_3.add(panel_2);
		
		JButton btnTimKiem_1 = new JButton("In Hóa Đơn");
		btnTimKiem_1.setForeground(new Color(0, 127, 255));
		btnTimKiem_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem_1.setBackground(Color.WHITE);
		btnTimKiem_1.setBounds(515, 52, 127, 20);
		panel_3.add(btnTimKiem_1);
		
		btnTimKiem_2 = new JButton("Xóa");
		btnTimKiem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem_2.setForeground(new Color(255, 0, 0));
		btnTimKiem_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem_2.setBackground(Color.WHITE);
		btnTimKiem_2.setBounds(646, 52, 78, 20);
		panel_3.add(btnTimKiem_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(246, 95, 779, 574);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(model = new DefaultTableModel(new Object[][] {}, new String[] { "Mã Khách Hàng",
				"Tên Khách Hàng", "Tổng Tiền"}));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
