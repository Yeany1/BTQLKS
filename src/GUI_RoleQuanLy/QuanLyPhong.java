package GUI_RoleQuanLy;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import GUI_RoleNhanVien.GUI_ChiTietPhong;
import GUI_RoleQuanLy.GUI_DSHoaDonRoleAdmin;
import GUI_RoleQuanLy.GUI_KhachHang;
import GUI_RoleQuanLy.GUI_QuanLiSanPHam;
import connectDB.Database;
import dao.Phong_DAO;
import entity.Phong;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;

public class QuanLyPhong extends JFrame {

	private JPanel contentPane;
	private JButton btnPhong_1_4;
	private JTextField txtGia_controller;
	private JTextField txtfTenPhong_controller;
	private JTextField txtfMaPhong_controller;
	private JTextField txtTim;
	private JComboBox comboboxLoaiPhong_controller = new JComboBox();
	private JComboBox comboboxTrangThai_controller = new JComboBox();
	private JPanel pn_Container_Phong_insideContainer = new JPanel();
	private JPanel pn_Container_Phong_status = new JPanel();
	private Color ColorTrong  = new Color(40, 167, 69); 
	private Color ColorDangSuDung  = new Color(220, 53, 69); 
	private Color ColorBaoTri  = new Color(253, 126, 20); 
	private Color ColorDonDep  = new Color(23, 162, 184); 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Database().connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyPhong frame = new QuanLyPhong();
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
	public QuanLyPhong() {
		setTitle("Quản Lí Khách Sạn");
		setBackground(new Color(244, 247, 254));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1400, 690);
		setLocationRelativeTo(null);
		setSize(new Dimension(1522, 688));
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 247, 254));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		panel.setBackground(new Color(25, 118, 211));
		panel.setBounds(0, 0, 247, 693);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GUI_NhanVien.class.getResource("/icon/admin_avt_64.png")));
		lblNewLabel_1.setBackground(new Color(255, 128, 64));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(90, 80, 64, 64);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("QUẢN LÝ KHÁCH SẠN");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_3.setBounds(-13, 21, 275, 40);
		panel.add(lblNewLabel_3);

		JButton btnQLKH = new JButton("Quản Lý Khách Hàng");
		btnQLKH.setForeground(Color.BLACK);
		btnQLKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLKH.setBounds(26, 219, 200, 30);
		btnQLKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_KhachHang().setVisible(true);
				dispose();
			}
		});
		panel.add(btnQLKH);

		JButton btnQLNV = new JButton("QUản Lý Nhân Viên");
		btnQLNV.setForeground(Color.BLACK);
		btnQLNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLNV.setBounds(26, 270, 200, 30);
		panel.add(btnQLNV);

		JButton btnQLP = new JButton("Quản Lý Phòng");
		btnQLP.setForeground(Color.BLACK);
		btnQLP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLP.setBounds(26, 321, 200, 30);
		btnQLP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new QuanLyPhong().setVisible(true);
				dispose();
			}
		});
		panel.add(btnQLP);

		JButton btnQLDV = new JButton("Quản Lý Dịch Vụ");
		btnQLDV.setForeground(Color.BLACK);
		btnQLDV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLDV.setBounds(26, 373, 200, 30);
		btnQLDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_QuanLiSanPHam().setVisible(true);
				dispose();
			}
		});
		panel.add(btnQLDV);

		JButton btnTCHD = new JButton("Tra Cứu Hóa Đơn");
		btnTCHD.setForeground(Color.BLACK);
		btnTCHD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTCHD.setBounds(26, 424, 200, 30);
		btnTCHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_DSHoaDonRoleAdmin().setVisible(true);
				dispose();
			}
		});
		panel.add(btnTCHD);

		JButton btnLogout = new JButton("Đăng Xuất");
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogout.setBounds(26, 642, 200, 30);
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				System.exit(0);
			}
		});
		panel.add(btnLogout);

		
		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(new Color(33, 80, 123));
		pnCenter.setBounds(283, 0, 983, 683);
		contentPane.add(pnCenter);
		pnCenter.setLayout(null);
		
		
		pn_Container_Phong_status.setBackground(new Color(28, 112, 172));
		pn_Container_Phong_status.setBorder(new CompoundBorder(null, new LineBorder(new Color(255, 255, 255), 20, true)));
		pn_Container_Phong_status.setBounds(10, 10, 963, 459);
		pnCenter.add(pn_Container_Phong_status);
		pn_Container_Phong_status.setLayout(null);
		
		
		pn_Container_Phong_status.add(pn_Container_Phong_insideContainer);
		pn_Container_Phong_insideContainer.setBackground(new Color(33, 80, 123));
		pn_Container_Phong_insideContainer.setBounds(43, 45, 880, 369);
		pn_Container_Phong_insideContainer.setLayout(null);

		loadDataPhong(); 
		
		
		
//		JButton btnPhong_1_1 = new JButton("1.1");
//		btnPhong_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnPhong_1_1.setBackground(new Color(192, 192, 192));
//		btnPhong_1_1.setBounds(34, 39, 80, 80);
//		pn_Container_Phong_insideContainer.add(btnPhong_1_1);
//		
//		JButton btnPhong_1_2 = new JButton("1.2");
//		btnPhong_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnPhong_1_2.setBackground(new Color(192, 192, 192));
//		btnPhong_1_2.setBounds(135, 39, 80, 80);
//		pn_Container_Phong_insideContainer.add(btnPhong_1_2);
//		
//		
//		JButton btnPhong_1_3 = new JButton("1.3");
//		btnPhong_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnPhong_1_3.setBackground(new Color(192, 192, 192));
//		btnPhong_1_3.setBounds(237, 39, 80, 80);
//		pn_Container_Phong_insideContainer.add(btnPhong_1_3);
//		
//		btnPhong_1_4 = new JButton("1.4");
//		btnPhong_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnPhong_1_4.setBackground(new Color(192, 192, 192));
//		btnPhong_1_4.setBounds(341, 39, 80, 80);
//		pn_Container_Phong_insideContainer.add(btnPhong_1_4);
//		
//		JButton btnPhong_1_5 = new JButton("1.5");
//		btnPhong_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnPhong_1_5.setBackground(new Color(192, 192, 192));
//		btnPhong_1_5.setBounds(443, 39, 80, 80);
//		pn_Container_Phong_insideContainer.add(btnPhong_1_5);
//		
//		JButton btnPhong_1_6 = new JButton("1.6");
//		btnPhong_1_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnPhong_1_6.setBackground(new Color(192, 192, 192));
//		btnPhong_1_6.setBounds(551, 39, 80, 80);
//		pn_Container_Phong_insideContainer.add(btnPhong_1_6);
//		
//		JButton btnPhong_2_2 = new JButton("2.2");
//		btnPhong_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnPhong_2_2.setBackground(new Color(192, 192, 192));
//		btnPhong_2_2.setBounds(135, 140, 80, 80);
//		pn_Container_Phong_insideContainer.add(btnPhong_2_2);
//		
//		JButton btnPhong_2_1 = new JButton("2.1");
//		btnPhong_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnPhong_2_1.setBackground(new Color(192, 192, 192));
//		btnPhong_2_1.setBounds(34, 140, 80, 80);
//		pn_Container_Phong_insideContainer.add(btnPhong_2_1);
//		JButton btnPhong_2_3 = new JButton("2.3");
//		btnPhong_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnPhong_2_3.setBackground(new Color(192, 192, 192));
//		btnPhong_2_3.setBounds(237, 140, 80, 80);
//		pn_Container_Phong_insideContainer.add(btnPhong_2_3);
		
		JPanel pn_members = new JPanel();
		pn_members.setBounds(10, 641, 963, 29);
		pnCenter.add(pn_members);
		
		JPanel pn_Status_Phong_inSide_1 = new JPanel();
		pn_Status_Phong_inSide_1.setLayout(null);
		pn_Status_Phong_inSide_1.setBounds(10, 479, 484, 152);
		pnCenter.add(pn_Status_Phong_inSide_1);
		
		JLabel lblMaPhong = new JLabel("Mã Phòng");
		lblMaPhong.setFont(new Font("Arial", Font.BOLD, 13));
		lblMaPhong.setBounds(75, 11, 112, 13);
		pn_Status_Phong_inSide_1.add(lblMaPhong);
		
		JLabel lblTenPhong = new JLabel("Tên Phòng");
		lblTenPhong.setFont(new Font("Arial", Font.BOLD, 13));
		lblTenPhong.setBounds(75, 34, 112, 13);
		pn_Status_Phong_inSide_1.add(lblTenPhong);
		
		JLabel lblLoaiPhong = new JLabel("Loại Phòng");
		lblLoaiPhong.setFont(new Font("Arial", Font.BOLD, 13));
		lblLoaiPhong.setBounds(75, 57, 112, 18);
		pn_Status_Phong_inSide_1.add(lblLoaiPhong);
		
		JLabel lblChiTit = new JLabel("Giá");
		lblChiTit.setFont(new Font("Arial", Font.BOLD, 13));
		lblChiTit.setBounds(75, 85, 67, 20);
		pn_Status_Phong_inSide_1.add(lblChiTit);
		
		txtGia_controller = new JTextField();
		txtGia_controller.setColumns(10);
		txtGia_controller.setBounds(161, 85, 252, 19);
		pn_Status_Phong_inSide_1.add(txtGia_controller);
		
		JLabel lblTrngThi = new JLabel("Trạng Thái");
		lblTrngThi.setFont(new Font("Arial", Font.BOLD, 13));
		lblTrngThi.setBounds(250, 57, 85, 18);
		pn_Status_Phong_inSide_1.add(lblTrngThi);
		
		comboboxTrangThai_controller.setBackground(new Color(192, 192, 192));
		comboboxTrangThai_controller.setFont(new Font("Arial", Font.BOLD, 13));
		comboboxTrangThai_controller.setBounds(334, 58, 79, 21);
		pn_Status_Phong_inSide_1.add(comboboxTrangThai_controller);
		
		comboboxTrangThai_controller.addItem("Trống"); 
		comboboxTrangThai_controller.addItem("Đang sử dụng");
		comboboxTrangThai_controller.addItem("Dọn dẹp");
		comboboxTrangThai_controller.addItem("Bảo trì");
		
		
		
		txtfTenPhong_controller = new JTextField();
		txtfTenPhong_controller.setColumns(10);
		txtfTenPhong_controller.setBounds(161, 34, 252, 19);
		pn_Status_Phong_inSide_1.add(txtfTenPhong_controller);
		
		txtfMaPhong_controller = new JTextField();
		txtfMaPhong_controller.setColumns(10);
		txtfMaPhong_controller.setBounds(161, 10, 252, 19);
		pn_Status_Phong_inSide_1.add(txtfMaPhong_controller);
		
		JButton btnThemPhong = new JButton("Thêm");
		btnThemPhong.setBounds(108, 115, 87, 23);
		pn_Status_Phong_inSide_1.add(btnThemPhong);
		btnThemPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Phong p = new Phong(); 
				p.setId(Integer.parseInt( txtfMaPhong_controller.getText()));
				p.setGiaPhong(Double.parseDouble(txtGia_controller.getText()));
				p.setLoaiPhong(comboboxLoaiPhong_controller.getSelectedItem()+"");
				p.settrangThaiPhong(comboboxTrangThai_controller.getSelectedItem()+"");
				
				
				new Phong_DAO().themPhong(p);
				loadDataPhong();
		
				pn_Container_Phong_insideContainer.revalidate(); // Cập nhật layout cho JPanel
		        pn_Container_Phong_insideContainer.repaint(); // Vẽ lại JPanel
		        JOptionPane.showMessageDialog(pn_Container_Phong_insideContainer, "Thêm phòng thành công");
			}
		});
		
		btnThemPhong.setBackground(new Color(217, 217, 217));
		btnThemPhong.setFont(new Font("Arial", Font.BOLD, 15));
		
//		JButton btnThemDichVu = new JButton("Xem ");
//		btnThemDichVu.setBounds(154, 114, 85, 23);
//		pn_Status_Phong_inSide_1.add(btnThemDichVu);
//		btnThemDichVu.setFont(new Font("Arial", Font.BOLD, 15));
//		btnThemDichVu.setBackground(new Color(217, 217, 217));
		
		JButton btnSuaPhong = new JButton("Sửa");
		btnSuaPhong.setBounds(204, 114, 85, 23);
		
		pn_Status_Phong_inSide_1.add(btnSuaPhong);
		btnSuaPhong.setFont(new Font("Arial", Font.BOLD, 15));
		btnSuaPhong.setBackground(new Color(217, 217, 217));
		btnSuaPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Phong p = new Phong(); 
				p.setId(Integer.parseInt( txtfMaPhong_controller.getText()));
				p.setGiaPhong(Double.parseDouble(txtGia_controller.getText()));
				p.setLoaiPhong(comboboxLoaiPhong_controller.getSelectedItem()+"");
				p.settrangThaiPhong(comboboxTrangThai_controller.getSelectedItem()+"");

				new Phong_DAO().suaPhongTheoID( Integer.parseInt(txtfMaPhong_controller.getText()+""), p); 
				loadDataPhong();
				
				JOptionPane.showMessageDialog(pn_Container_Phong_insideContainer, "Cập thật thông tin thành công");
			}
		});
		
		JButton btnXoaPhong = new JButton("Xóa");
		btnXoaPhong.setBounds(300, 114, 85, 23);
//		btnXoaPhong.setBounds(345, 114, 85, 23);
		pn_Status_Phong_inSide_1.add(btnXoaPhong);
		btnXoaPhong.setForeground(new Color(255, 255, 255));
		btnXoaPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Phong_DAO().xoaPhongTheoID( Integer.parseInt(txtfMaPhong_controller.getText()+"") ); 
				loadDataPhong();
				JOptionPane.showMessageDialog(pn_Container_Phong_insideContainer, "Xoá phòng thành công");
			}
		});
		btnXoaPhong.setFont(new Font("Arial", Font.BOLD, 15));
		btnXoaPhong.setBackground(new Color(227, 52, 15));
		
		
		comboboxLoaiPhong_controller.setBackground(new Color(192, 192, 192));
		comboboxLoaiPhong_controller.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboboxLoaiPhong_controller.setBounds(161, 58, 79, 21);
		pn_Status_Phong_inSide_1.add(comboboxLoaiPhong_controller);
		comboboxLoaiPhong_controller.addItem("Phòng đơn");
		comboboxLoaiPhong_controller.addItem("Phòng đôi");
		
		JPanel pn_Status_Phong_inSide = new JPanel();
		pn_Status_Phong_inSide.setBounds(504, 479, 469, 152);
		pnCenter.add(pn_Status_Phong_inSide);
		pn_Status_Phong_inSide.setLayout(null);
		
		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(124, 12, 100, 22);
		pn_Status_Phong_inSide.add(txtTim);
		
		
		
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(new Color(0, 127, 255));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setBounds(234, 10, 107, 24);
		pn_Status_Phong_inSide.add(btnTimKiem);
		btnTimKiem.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int ID = Integer.parseInt(txtTim.getText()); 
				loadDataPhong_theoID(ID);
			}
		});
		
		
		JButton btnTatCa = new JButton("Tất cả");
		btnTatCa.setForeground(new Color(0, 127, 255));
		btnTatCa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTatCa.setBackground(Color.WHITE);
		btnTatCa.setBounds(354, 10, 107, 24);
		pn_Status_Phong_inSide.add(btnTatCa);
		btnTatCa.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadDataPhong();
			}
		});
		
//		JComboBox comboBoxSearch = new JComboBox();
//		comboBoxSearch.setBackground(new Color(192, 192, 192));
//		comboBoxSearch.setBounds(10, 13, 104, 21);
		
//		comboBoxSearch.addItem("Tìm Theo Loại");
//		pn_Status_Phong_inSide.add(comboBoxSearch);
//		comboBoxSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel timTheoMa = new JLabel("Mã Phòng");
		timTheoMa.setBounds(40, 13, 104, 21);
		timTheoMa.setFont(new Font("Tahoma", Font.BOLD, 13));
		pn_Status_Phong_inSide.add(timTheoMa);
		
		JLabel lbl_Phong_Status_Disable = new JLabel("Phòng Trống");
		lbl_Phong_Status_Disable.setBounds(90, 107, 110, 31);
		pn_Status_Phong_inSide.add(lbl_Phong_Status_Disable);
		lbl_Phong_Status_Disable.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lbl_Phong_Status_Unable = new JLabel("Đang Sử Dụng");
		lbl_Phong_Status_Unable.setBounds(90, 66, 110, 31);
		pn_Status_Phong_inSide.add(lbl_Phong_Status_Unable);
		lbl_Phong_Status_Unable.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lbl_Phong_Status_DonDep = new JLabel("Đang Dọn Dẹp");
		lbl_Phong_Status_DonDep.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_Phong_Status_DonDep.setBounds(315, 66, 110, 31);
		pn_Status_Phong_inSide.add(lbl_Phong_Status_DonDep);
		
		JLabel lbl_Phong_Status_BaoTri = new JLabel("Đang Bảo Trì");
		lbl_Phong_Status_BaoTri.setFont(new Font("Arial", Font.BOLD, 15));
		lbl_Phong_Status_BaoTri.setBounds(315, 107, 110, 31);
		pn_Status_Phong_inSide.add(lbl_Phong_Status_BaoTri);
		
		JButton btn_Phong_Status_DonDep = new JButton("");
		btn_Phong_Status_DonDep.setBackground(ColorDonDep);
		btn_Phong_Status_DonDep.setBounds(268, 66, 40, 31);
		pn_Status_Phong_inSide.add(btn_Phong_Status_DonDep);
		
		btn_Phong_Status_DonDep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadDataPhong_TheoTrangThai("Dọn dẹp");
			}
		});
		
		JButton btn_Phong_Status_BaoTri = new JButton("");
		btn_Phong_Status_BaoTri.setBackground(ColorBaoTri);
		btn_Phong_Status_BaoTri.setBounds(268, 107, 40, 31);
		pn_Status_Phong_inSide.add(btn_Phong_Status_BaoTri);
		btn_Phong_Status_BaoTri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadDataPhong_TheoTrangThai("Bảo trì");
			}
		});
		
		JButton btn_Phong_Status_Disable = new JButton("");
		btn_Phong_Status_Disable.setBackground(ColorTrong);
		btn_Phong_Status_Disable.setBounds(40, 107, 40, 31);
		pn_Status_Phong_inSide.add(btn_Phong_Status_Disable);
		btn_Phong_Status_Disable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadDataPhong_TheoTrangThai("Trống");
			}
		});
		
		JButton btn_Phong_Status_Unable = new JButton("");
		btn_Phong_Status_Unable.setBackground(ColorDangSuDung);
		btn_Phong_Status_Unable.setBounds(40, 66, 40, 31);
		pn_Status_Phong_inSide.add(btn_Phong_Status_Unable);
		btn_Phong_Status_Unable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadDataPhong_TheoTrangThai("Đang sử dụng");
			}
		});
	}
	
	
	
	public void loadDataPhong() {
		pn_Container_Phong_insideContainer.removeAll();
		pn_Container_Phong_status.add(pn_Container_Phong_insideContainer);
		pn_Container_Phong_insideContainer.setBackground(new Color(33, 80, 123));
		pn_Container_Phong_insideContainer.setBounds(43, 45, 880, 369);
		pn_Container_Phong_insideContainer.setLayout(null);
		
		int x = 34, y = 39; 
		for( Phong p : new Phong_DAO().getAllPhong() ) {
			
			JButton btnPhong_1_1 = new JButton(p.getId()+"");
			btnPhong_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
			if( p.gettrangThaiPhong().equals("Trống"))
				btnPhong_1_1.setBackground(ColorTrong);
			else if(p.gettrangThaiPhong().equals("Đang sử dụng"))
				btnPhong_1_1.setBackground(ColorDangSuDung);
			else if(p.gettrangThaiPhong().equals("Bảo trì"))
				btnPhong_1_1.setBackground(ColorBaoTri);
			else
				btnPhong_1_1.setBackground(ColorDonDep);
			
			
			btnPhong_1_1.setBounds(x, y, 80, 80);
			pn_Container_Phong_insideContainer.add(btnPhong_1_1);
			
			x += 100; 
			if(x == 834) {
				x = 34; 
				y += 100; 
			}
			
			btnPhong_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtfMaPhong_controller.setText(p.getId()+"");
					txtGia_controller.setText(p.getGiaPhong()+"");
					txtfTenPhong_controller.setText(p.getLoaiPhong()+" "+ p.getId()); 
					if(p.gettrangThaiPhong().equals("Trống")) 
						comboboxTrangThai_controller.setSelectedIndex(0);
					if(p.gettrangThaiPhong().equals("Đang sử dụng")) 
						comboboxTrangThai_controller.setSelectedIndex(1);
					if(p.gettrangThaiPhong().equals("Dọn Dẹp")) 
						comboboxTrangThai_controller.setSelectedIndex(2);
					if(p.gettrangThaiPhong().equals("Bảo Trì")) 
						comboboxTrangThai_controller.setSelectedIndex(3);
					
					if(p.getLoaiPhong().equals("Phòng đơn"))
						comboboxLoaiPhong_controller.setSelectedIndex(0); 
					else 
						comboboxLoaiPhong_controller.setSelectedIndex(1); 
				}
			});
		}
		pn_Container_Phong_insideContainer.revalidate(); // Cập nhật layout cho JPanel
        pn_Container_Phong_insideContainer.repaint(); // Vẽ lại JPanel
	}
	
	private void loadDataPhong_TheoTrangThai( String loai ) {
		// TODO Auto-generated method stub
		pn_Container_Phong_insideContainer.removeAll();
		pn_Container_Phong_status.add(pn_Container_Phong_insideContainer);
		pn_Container_Phong_insideContainer.setBackground(new Color(33, 80, 123));
		pn_Container_Phong_insideContainer.setBounds(43, 45, 880, 369);
		pn_Container_Phong_insideContainer.setLayout(null);
		
		int x = 34, y = 39; 
		for( Phong p : new Phong_DAO().getAllPhong() ) {
			if(p.gettrangThaiPhong().equals(loai) ) {
				
				JButton btnPhong_1_1 = new JButton(p.getId()+"");
				btnPhong_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
				if( p.gettrangThaiPhong().equals("Trống"))
					btnPhong_1_1.setBackground(ColorTrong);
				else if(p.gettrangThaiPhong().equals("Đang sử dụng"))
					btnPhong_1_1.setBackground(ColorDangSuDung);
				else if(p.gettrangThaiPhong().equals("Bảo trì"))
					btnPhong_1_1.setBackground(ColorBaoTri);
				else
					btnPhong_1_1.setBackground(ColorDonDep);
				
				
				btnPhong_1_1.setBounds(x, y, 80, 80);
				pn_Container_Phong_insideContainer.add(btnPhong_1_1);
				
				x += 100; 
				if(x == 834) {
					x = 34; 
					y += 100; 
				}
				
				
			}
		}
		pn_Container_Phong_insideContainer.revalidate(); // Cập nhật layout cho JPanel
		pn_Container_Phong_insideContainer.repaint(); // Vẽ lại JPanel
			
	}
	
	private void loadDataPhong_theoID( int ID ) {
		// TODO Auto-generated method stub
		pn_Container_Phong_insideContainer.removeAll();
		pn_Container_Phong_status.add(pn_Container_Phong_insideContainer);
		pn_Container_Phong_insideContainer.setBackground(new Color(33, 80, 123));
		pn_Container_Phong_insideContainer.setBounds(43, 45, 880, 369);
		pn_Container_Phong_insideContainer.setLayout(null);
		
		int x = 34, y = 39; 
		for( Phong p : new Phong_DAO().getAllPhong() ) {
			if(p.getId()==ID ) {
				
				JButton btnPhong_1_1 = new JButton(p.getId()+"");
				btnPhong_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
				if( p.gettrangThaiPhong().equals("Trống"))
					btnPhong_1_1.setBackground(ColorTrong);
				else if(p.gettrangThaiPhong().equals("Đang sử dụng"))
					btnPhong_1_1.setBackground(ColorDangSuDung);
				else if(p.gettrangThaiPhong().equals("Bảo trì"))
					btnPhong_1_1.setBackground(ColorBaoTri);
				else
					btnPhong_1_1.setBackground(ColorDonDep);
				
				
				btnPhong_1_1.setBounds(x, y, 80, 80);
				pn_Container_Phong_insideContainer.add(btnPhong_1_1);
				
				x += 100; 
				if(x == 834) {
					x = 34; 
					y += 100; 
				}
				
			
				
				break; 
			}
		}
		pn_Container_Phong_insideContainer.revalidate(); // Cập nhật layout cho JPanel
		pn_Container_Phong_insideContainer.repaint(); // Vẽ lại JPanel
			
	}
}

