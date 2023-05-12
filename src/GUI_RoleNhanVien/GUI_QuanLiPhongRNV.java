package GUI_RoleNhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import GUI_RoleQuanLy.GUI_KhachHang;
import connectDB.Database;
import dao.Phong_DAO;
import entity.Phong;

import java.awt.SystemColor;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GUI_QuanLiPhongRNV extends JFrame {

	private JPanel contentPane;

	private JTextField txtMaNV, txtTenNV, txtEmailNV, txtSDTNV, txtCMND, txtDiaChiNV;
	private JButton btnThem, btnXoa, btnSua, btnLamMoi, btnReload;
	private JRadioButton rdbtnNam, rdbtnNu;
	private JComboBox comboBoxMaNV;
	private JTable table;
	private DefaultTableModel model;

	private static final long serialVersionUID = 1L;
	private JLabel lblStaffName, lblRole, lbDS, lbTongSoPhong, lbSapXep, lblTitle, lbTim, lbMaNV, lbTenNV, lbDay,
			lbHieu, lbDang, lbLinh, lbMaHieu, lbMaLinh, lbMaDang;
	public JButton btnBack, btnLogout, btnQLNV, btnQLKH, btnQLTK, btnQLP, btnQLDV, btnTCHD;
	public JTextField txtTongSoPhong, txtTim, txtDay;
	private static JButton[] phong;
	Box b3;
	JScrollPane scroll;
	JComboBox<String> cmbSapXep, cmbTimKiem;
	GridLayout test;
	private JTextField textField;
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
					GUI_QuanLiPhongRNV frame = new GUI_QuanLiPhongRNV();
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
	public GUI_QuanLiPhongRNV() {
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

		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(0, 0, 247, 813);
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
		btnQLKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_KhachHangRNV().setVisible(true);
				dispose();
			}
		});
		btnQLKH.setForeground(Color.BLACK);
		btnQLKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLKH.setBounds(20, 220, 200, 30);

		btnQLDV = new JButton("Quản Lý Dịch Vụ");
		btnQLDV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new GUI_QuanLiDichVu().setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQLDV.setForeground(Color.BLACK);
		btnQLDV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLDV.setBounds(20, 270, 200, 30);

		btnTCHD = new JButton("Tra Cứu Hóa Đơn");
		btnTCHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_DSHoaDonRoleNV().setVisible(true);
				dispose();
			}
		});
		btnTCHD.setForeground(Color.BLACK);
		btnTCHD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTCHD.setBounds(20, 320, 200, 30);

		btnLogout = new JButton("Đăng Xuất");
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogout.setBounds(20, 370, 200, 30);

		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				System.exit(0);
			}
		});
		leftPanel.add(btnLogout);
		leftPanel.add(btnQLKH);
		leftPanel.add(btnQLDV);
		leftPanel.add(btnTCHD);

		pn_Container_Phong_status.setLayout(null);
		pn_Container_Phong_status.setBorder(new CompoundBorder(null, new LineBorder(new Color(255, 255, 255), 20, true)));
		pn_Container_Phong_status.setBackground(new Color(28, 112, 172));
		pn_Container_Phong_status.setBounds(-13, 10, 1260, 446);
		pn_Container_Phong_insideContainer.setLayout(null);
		pn_Container_Phong_insideContainer.setBackground(new Color(33, 80, 123));
		pn_Container_Phong_insideContainer.setBounds(34, 34, 1186, 375);
		pn_Container_Phong_status.add(pn_Container_Phong_insideContainer);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(new Color(33, 80, 123));
		pnCenter.setBounds(246, 0, 1280, 474);
//		pnCenter.setBounds(283, 0, 983, 683);
		contentPane.add(pnCenter);
		pnCenter.setLayout(null);
		
		
		pn_Container_Phong_status.setBackground(new Color(28, 112, 172));
		pn_Container_Phong_status.setBorder(new CompoundBorder(null, new LineBorder(new Color(255, 255, 255), 20, true)));
		pn_Container_Phong_status.setBounds(-13, 10, 1260, 446);
//		pn_Container_Phong_status.setBounds(10, 10, 963, 459);
		pnCenter.add(pn_Container_Phong_status);
		pn_Container_Phong_status.setLayout(null);
		
		pn_Container_Phong_status.add(pn_Container_Phong_insideContainer);
		pn_Container_Phong_insideContainer.setBackground(new Color(33, 80, 123));
		pn_Container_Phong_insideContainer.setBounds(34, 34, 1186, 375);
//		pn_Container_Phong_insideContainer.setBounds(43, 45, 880, 369);
		pn_Container_Phong_insideContainer.setLayout(null);
		
		loadDataPhong(); 

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(33, 80, 123));
		panel_1.setBounds(246, 470, 1262, 330);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 0, 1252, 320);
		panel_1.add(panel_1_1);


		JLabel lbl_Phong_Status_Unable_1 = new JLabel("Đang sử dụng");
		lbl_Phong_Status_Unable_1.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Phong_Status_Unable_1.setBounds(770, 107, 151, 33);
		panel_1_1.add(lbl_Phong_Status_Unable_1);
		
		JButton pn_btn_DangSuDung = new JButton();
		pn_btn_DangSuDung.setLayout(null);
		pn_btn_DangSuDung.setBackground(ColorDangSuDung);
		pn_btn_DangSuDung.setBounds(680, 97, 50, 50);
		panel_1_1.add(pn_btn_DangSuDung); 
		
		pn_btn_DangSuDung.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadDataPhong_TheoTrangThai("Đang sử dụng");
			}
		});
		
		JButton pn_btn_PhongTrong = new JButton();
		pn_btn_PhongTrong.setLayout(null);
		pn_btn_PhongTrong.setBackground(ColorTrong);
		pn_btn_PhongTrong.setBounds(133, 97, 50, 50);
		panel_1_1.add(pn_btn_PhongTrong);
		
		pn_btn_PhongTrong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadDataPhong_TheoTrangThai("Trống");
			}
		});

		JButton pn_btn_DonDep = new JButton();
		pn_btn_DonDep.setLayout(null);
		pn_btn_DonDep.setBackground(ColorDonDep);
		pn_btn_DonDep.setBounds(448, 97, 50, 50);
		panel_1_1.add(pn_btn_DonDep);
		
		pn_btn_DonDep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadDataPhong_TheoTrangThai("Dọn dẹp");
			}
		});

		JButton pn_btn_BaoTri = new JButton();
		pn_btn_BaoTri.setLayout(null);
		pn_btn_BaoTri.setBackground(ColorBaoTri);
		pn_btn_BaoTri.setBounds(992, 97, 50, 50);
		panel_1_1.add(pn_btn_BaoTri);
		
		pn_btn_BaoTri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadDataPhong_TheoTrangThai("Bảo trì");
			}
		});
		

		JLabel lbl_Phong_Status_Unable_1_1 = new JLabel("Phòng trống");
		lbl_Phong_Status_Unable_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Phong_Status_Unable_1_1.setBounds(226, 109, 151, 33);
		panel_1_1.add(lbl_Phong_Status_Unable_1_1);

		JLabel lbl_Phong_Status_Unable_1_1_1 = new JLabel("Dọn dẹp");
		lbl_Phong_Status_Unable_1_1_1.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Phong_Status_Unable_1_1_1.setBounds(527, 109, 87, 33);
		panel_1_1.add(lbl_Phong_Status_Unable_1_1_1);
		
		JLabel lbl_Phong_Status_Unable_1_1_2 = new JLabel("Bảo Trì");
		lbl_Phong_Status_Unable_1_1_2.setFont(new Font("Arial", Font.BOLD, 20));
		lbl_Phong_Status_Unable_1_1_2.setBounds(1052, 107, 151, 33);
		panel_1_1.add(lbl_Phong_Status_Unable_1_1_2);
		
		JComboBox comboBoxMaPhong = new JComboBox();
		comboBoxMaPhong.setBounds(209, 12, 238, 26);
		panel_1_1.add(comboBoxMaPhong);
		comboBoxMaPhong.addItem("Số Phòng");
		comboBoxMaPhong.addItem("Loại Phòng");

		txtTim = new JTextField();
	
		
		txtTim.setColumns(10);
		txtTim.setBounds(483, 13, 316, 24);
		panel_1_1.add(txtTim);

		JButton btnTimKiem = new JButton("Tìm Kiếm"); 
		btnTimKiem.setForeground(new Color(0, 127, 255));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setBounds(825, 12, 126, 26);
		panel_1_1.add(btnTimKiem);
		
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
		btnTatCa.setBounds(961, 12, 126, 26);
		panel_1_1.add(btnTatCa);
		
		btnTatCa.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadDataPhong();
			}
		});
		
	}

	private void loadDataPhong() {
		// TODO Auto-generated method stub
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
					new GUI_ChiTietPhong().setVisible(true);				
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
				
				btnPhong_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new GUI_ChiTietPhong().setVisible(true);				
					}
				});
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
				
				btnPhong_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new GUI_ChiTietPhong().setVisible(true);		
					}
				});
				
				break; 
			}
		}
		pn_Container_Phong_insideContainer.revalidate(); // Cập nhật layout cho JPanel
		pn_Container_Phong_insideContainer.repaint(); // Vẽ lại JPanel
			
	}
}
