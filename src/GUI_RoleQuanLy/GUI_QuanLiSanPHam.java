package GUI_RoleQuanLy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUI_RoleNhanVien.GUI_DanhSachLoaiSanPham;

import java.awt.Dialog.ModalExclusionType;

public class GUI_QuanLiSanPHam extends JFrame {

//	private JPanel contentPane;
	private JTextField txtfSoLuongSP;
	private JTextField txtfGiaBan;
	private JTextField txtfMaSP_search;
	private JTable table;
	private JTextField txtfMaSP;
	private JTextField txtfGiaNhap;
	private JTextField txtfNgayNhap;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelBarchart, panelPieChart;
	private JLabel lblStaffName, lblRole, txtStaff, txtOrder, txtRevenue;
	public JButton btnLogout, btnQLNV, btnQLKH, btnTCHD, btnQLP, btnQLDV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuanLiSanPHam frame = new GUI_QuanLiSanPHam();
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
	public GUI_QuanLiSanPHam() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(244, 247, 254));
		contentPane_1.setBounds(10, 10, 1232, 663);
		contentPane.add(contentPane_1);
		
		JPanel panel_Center = new JPanel();
		panel_Center.setLayout(null);
		panel_Center.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		panel_Center.setBounds(253, 0, 359, 663);
		contentPane_1.add(panel_Center);
		
		JLabel lblThongTinSP = new JLabel("THÔNG TIN SẢN PHẨM");
		lblThongTinSP.setForeground(new Color(0, 127, 255));
		lblThongTinSP.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongTinSP.setBackground(new Color(64, 0, 64));
		lblThongTinSP.setBounds(74, 91, 205, 20);
		panel_Center.add(lblThongTinSP);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 127, 255));
		panel_2.setBounds(86, 120, 168, 2);
		panel_Center.add(panel_2);
		
		JLabel lblLoaiSP = new JLabel("Loại Sản Phẩm");
		lblLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoaiSP.setBounds(20, 237, 112, 13);
		panel_Center.add(lblLoaiSP);
		
		JLabel lblTenSP = new JLabel("Tên Sản Phẩm");
		lblTenSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenSP.setBounds(20, 266, 112, 13);
		panel_Center.add(lblTenSP);
		
		JLabel lblSoLuongSP = new JLabel("Số Lượng");
		lblSoLuongSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoLuongSP.setBounds(20, 289, 112, 18);
		panel_Center.add(lblSoLuongSP);
		
		txtfSoLuongSP = new JTextField();
		txtfSoLuongSP.setColumns(10);
		txtfSoLuongSP.setBounds(150, 291, 183, 19);
		panel_Center.add(txtfSoLuongSP);
		
		txtfGiaBan = new JTextField();
		txtfGiaBan.setColumns(10);
		txtfGiaBan.setBounds(150, 350, 183, 19);
		panel_Center.add(txtfGiaBan);
		
		JLabel lblGiaBan = new JLabel("Giá Bán");
		lblGiaBan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiaBan.setBounds(20, 347, 112, 20);
		panel_Center.add(lblGiaBan);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(0, 127, 255));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBackground(Color.WHITE);
		btnThem.setBounds(12, 482, 159, 32);
		panel_Center.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setForeground(new Color(64, 0, 64));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBackground(Color.WHITE);
		btnSua.setBounds(181, 482, 159, 32);
		panel_Center.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.RED);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(12, 524, 159, 32);
		panel_Center.add(btnXoa);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(new Color(75, 150, 243));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setBounds(183, 524, 159, 32);
		panel_Center.add(btnLamMoi);
		
		JButton btnReload = new JButton("Reload Data");
		btnReload.setForeground(new Color(38, 198, 240));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReload.setBackground(Color.WHITE);
		btnReload.setBounds(10, 566, 159, 32);
		panel_Center.add(btnReload);
		
		JComboBox comboBoxLoaiSP = new JComboBox();
		comboBoxLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxLoaiSP.setBounds(150, 235, 183, 21);
		comboBoxLoaiSP.addItem("Đồ Ăn");
		comboBoxLoaiSP.addItem("Đồ Uống");
		comboBoxLoaiSP.addItem("Đồ Ăn Khô");
		panel_Center.add(comboBoxLoaiSP);
		
		JComboBox comboBoxTenSP = new JComboBox();
		comboBoxTenSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxTenSP.setBounds(150, 264, 183, 21);
		panel_Center.add(comboBoxTenSP);
		
		JButton btnThemLoaiSP = new JButton("Thêm Loại Sản Phẩm");
		btnThemLoaiSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_DanhSachLoaiSanPham().setVisible(true);
				
			}
		});
		btnThemLoaiSP.setForeground(new Color(0, 127, 255));
		btnThemLoaiSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemLoaiSP.setBackground(Color.WHITE);
		btnThemLoaiSP.setBounds(181, 566, 159, 32);
		panel_Center.add(btnThemLoaiSP);
		
		JLabel lblmaSP = new JLabel("Mã Sản Phẩm");
		lblmaSP.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmaSP.setBounds(20, 204, 112, 18);
		panel_Center.add(lblmaSP);
		
		txtfMaSP = new JTextField();
		txtfMaSP.setEnabled(false);
		txtfMaSP.setColumns(10);
		txtfMaSP.setBounds(150, 206, 183, 19);
		panel_Center.add(txtfMaSP);
		
		JLabel lblGiaNhap = new JLabel("Giá Nhập");
		lblGiaNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiaNhap.setBounds(20, 317, 112, 20);
		panel_Center.add(lblGiaNhap);
		
		txtfGiaNhap = new JTextField();
		txtfGiaNhap.setColumns(10);
		txtfGiaNhap.setBounds(150, 320, 183, 19);
		panel_Center.add(txtfGiaNhap);
		
		JLabel lblNgayNhap = new JLabel("Ngày Nhập");
		lblNgayNhap.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgayNhap.setBounds(20, 379, 112, 20);
		panel_Center.add(lblNgayNhap);
		
		txtfNgayNhap = new JTextField();
		txtfNgayNhap.setColumns(10);
		txtfNgayNhap.setBounds(150, 382, 183, 19);
		panel_Center.add(txtfNgayNhap);
		
		JPanel panel_Search = new JPanel();
		panel_Search.setLayout(null);
		panel_Search.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		panel_Search.setBounds(607, 0, 625, 67);
		contentPane_1.add(panel_Search);
		
		txtfMaSP_search = new JTextField();
		txtfMaSP_search.setColumns(10);
		txtfMaSP_search.setBounds(217, 22, 183, 22);
		panel_Search.add(txtfMaSP_search);
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(new Color(0, 127, 255));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setBounds(417, 20, 126, 24);
		panel_Search.add(btnTimKiem);
		
		JLabel lblMaSP_search = new JLabel("Mã Sản Phẩm");
		lblMaSP_search.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaSP_search.setBounds(103, 25, 104, 16);
		panel_Search.add(lblMaSP_search);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(622, 66, 610, 597);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 S\u1EA3n Ph\u1EA9m", "Lo\u1EA1i S\u1EA3n Ph\u1EA9m", "T\u00EAn S\u1EA3n Ph\u1EA9m", "S\u1ED1 L\u01B0\u1EE3ng", "Gi\u00E1 Nh\u1EADp", "Gi\u00E1 B\u00E1n", "Ng\u00E0y Nh\u1EADp"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(77);
		table.getColumnModel().getColumn(1).setPreferredWidth(84);
		table.getColumnModel().getColumn(2).setPreferredWidth(78);
		scrollPane.setViewportView(table);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 254, 663);
		contentPane_1.add(leftPanel);
		leftPanel.setLayout(null);
		leftPanel.setBackground(new Color(25, 118, 211));
		
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
		btnQLNV.addActionListener(new ActionListener() {
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
		
		btnTCHD = new JButton("Tra Cứu Hóa Đơn");
		btnTCHD.setForeground(Color.BLACK);
		btnTCHD 	.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTCHD.setBounds(20, 420, 200, 30);
		btnTCHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_DSHoaDonRoleAdmin().setVisible(true);
				dispose();
			}
		});
		
		btnLogout = new JButton("Đăng Xuất");
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogout.setBounds(20, 612, 200, 30);
		
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				System.exit(0);
			}
		});
		leftPanel.add(btnLogout);
		leftPanel.add(btnQLNV);
		leftPanel.add(btnQLKH);
		leftPanel.add(btnQLP);
		leftPanel.add(btnQLDV);
		leftPanel.add(btnTCHD);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(20, 470, 200, 30);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new GUI_ThongKe().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		leftPanel.add(btnBack);
	}
}
