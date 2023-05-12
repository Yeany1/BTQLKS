package GUI_RoleNhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import connectDB.Database;
import dao.DichVu_DAO;
import dao.KhachHang_DAO;
import entity.DichVu;
import entity.KhachHang;

import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class GUI_ChiTietPhong extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JTextField txtMaKH, txtTenKH, txtEmailKH, txtSDT, txtCMND, txtNgaySinh, txtLoaiPhong, txtGiaPhong,
			txtSoPhong, txtTrangThaiPhong, txtDiaChi;
	public JButton btnDatPhong, btnThanhToan, btnDonDep, btnBaoTri, btnBack;
	private JButton btnLoc;
	private JComboBox comboBoxMaKH;
	private JRadioButton rdbtnNam, rdbtnNu;
	private JTable tableDV, tableODV;
	private DefaultTableModel modelDV, modelODV;
	private KhachHang_DAO dskh = new KhachHang_DAO();
	private JTextField txtTuoi;
	private JLabel lblTui;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ChiTietPhong frame = new GUI_ChiTietPhong();
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
	public GUI_ChiTietPhong() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 719);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblThngTinPhng = new JLabel("THÔNG TIN PHÒNG");
		lblThngTinPhng.setForeground(new Color(0, 127, 255));
		lblThngTinPhng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThngTinPhng.setBackground(new Color(64, 0, 64));
		lblThngTinPhng.setBounds(445, 21, 166, 20);
		contentPane.add(lblThngTinPhng);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 127, 255));
		panel_2.setBounds(455, 51, 140, 2);
		contentPane.add(panel_2);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), new Color(255, 255, 255)),
				"Th\u00F4ng Tin Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(0, 100, 440, 345);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Mã Khách Hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(43, 26, 120, 18);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Tên Khách Hàng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(43, 61, 120, 18);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Email");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(43, 100, 112, 13);
		panel.add(lblNewLabel_2_1_1);

		txtEmailKH = new JTextField();
		txtEmailKH.setEditable(false);
		txtEmailKH.setColumns(10);
		txtEmailKH.setBounds(173, 99, 183, 19);
		panel.add(txtEmailKH);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Số Điện Thoại");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(43, 208, 112, 18);
		panel.add(lblNewLabel_2_1_1_1);

		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(173, 208, 183, 19);
		panel.add(txtSDT);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("CMND");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1.setBounds(43, 172, 112, 13);
		panel.add(lblNewLabel_2_1_1_1_1);

		txtCMND = new JTextField();
		txtCMND.setEditable(false);
		txtCMND.setColumns(10);
		txtCMND.setBounds(173, 171, 183, 19);
		panel.add(txtCMND);

		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiiTnh.setBounds(43, 137, 112, 13);
		panel.add(lblGiiTnh);

		JLabel lblNmSinh = new JLabel("Ngày Sinh");
		lblNmSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNmSinh.setBounds(43, 246, 76, 13);
		panel.add(lblNmSinh);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(173, 243, 183, 19);
		panel.add(txtNgaySinh);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setEnabled(false);
		rdbtnNam.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNam.setBounds(201, 133, 59, 21);
		panel.add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setEnabled(false);
		rdbtnNu.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNu.setBounds(272, 133, 59, 21);
		panel.add(rdbtnNu);

		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(272, 28, 84, 19);
		panel.add(txtMaKH);

		comboBoxMaKH = new JComboBox();
		comboBoxMaKH.setBounds(173, 27, 91, 21);
		panel.add(comboBoxMaKH);

		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(173, 63, 183, 19);
		panel.add(txtTenKH);

		btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLoc.setBounds(366, 27, 64, 21);
		panel.add(btnLoc);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(173, 315, 183, 19);
		panel.add(txtDiaChi);

		JLabel lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblaCh.setBounds(43, 317, 76, 13);
		panel.add(lblaCh);

		txtTuoi = new JTextField();
		txtTuoi.setEditable(false);
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(173, 279, 183, 19);
		panel.add(txtTuoi);

		lblTui = new JLabel("Tuổi");
		lblTui.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTui.setBounds(43, 282, 76, 13);
		panel.add(lblTui);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), new Color(255, 255, 255)),
				"Th\u00F4ng Tin Ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(442, 100, 340, 345);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2_2 = new JLabel("Số Phòng");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(97, 24, 80, 18);
		panel_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1_2 = new JLabel("Loại Phòng");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(88, 59, 89, 18);
		panel_1.add(lblNewLabel_2_1_2);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(187, 61, 139, 19);
		panel_1.add(txtLoaiPhong);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("Giá Phòng");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_2.setBounds(97, 134, 80, 18);
		panel_1.add(lblNewLabel_2_1_1_2);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(187, 136, 139, 19);
		panel_1.add(txtGiaPhong);

		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Trạng Thái Phòng");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_2_1.setBounds(42, 97, 128, 18);
		panel_1.add(lblNewLabel_2_1_1_2_1);

		txtSoPhong = new JTextField();
		txtSoPhong.setEditable(false);
		txtSoPhong.setColumns(10);
		txtSoPhong.setBounds(187, 26, 139, 19);
		panel_1.add(txtSoPhong);

		txtTrangThaiPhong = new JTextField();
		txtTrangThaiPhong.setEditable(false);
		txtTrangThaiPhong.setColumns(10);
		txtTrangThaiPhong.setBounds(187, 99, 139, 19);
		panel_1.add(txtTrangThaiPhong);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(783, 108, 314, 574);
		contentPane.add(scrollPane);

		tableDV = new JTable();
		tableDV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableDV.setBackground(new Color(255, 255, 255));
		tableDV.setModel(modelDV = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Dịch Vụ", "Tên Dịch Vụ", "Giá Dịch Vụ" }));
		tableDV.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		scrollPane.setViewportView(tableDV);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 619, 782, 63);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		btnDatPhong = new JButton("Đặt Phòng");
		btnDatPhong.setBounds(60, 21, 117, 30);
		panel_3.add(btnDatPhong);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setEnabled(false);
		btnThanhToan.setBounds(187, 21, 117, 30);
		panel_3.add(btnThanhToan);
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrintBillUI().setVisible(true);
			}
		});
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnDonDep = new JButton("Dọn Dẹp");
		btnDonDep.setEnabled(false);
		btnDonDep.setBounds(314, 21, 117, 30);
		panel_3.add(btnDonDep);
		btnDonDep.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnBaoTri = new JButton("Bảo Trì");
		btnBaoTri.setEnabled(false);
		btnBaoTri.setBounds(441, 21, 117, 30);
		panel_3.add(btnBaoTri);
		btnBaoTri.setFont(new Font("Tahoma", Font.PLAIN, 13));

		btnBack = new JButton("Back");
		btnBack.setBounds(568, 21, 117, 30);
		panel_3.add(btnBack);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 448, 782, 167);
		contentPane.add(scrollPane_1);

		tableODV = new JTable();
		tableODV.setModel(modelODV = new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Dịch Vụ", "Tên Dịch Vụ", "Đơn Giá", "Số Lượng", "Tổng Tiền" }));
		scrollPane_1.setViewportView(tableODV);

		/*
		 * ==== EVENT ====
		 * 
		 * Chương trình chạy , lấy dữ liệu đưa vào tableDV, comboboxMaKH, hiện thị thông
		 * tin khách hàng vào JTextField
		 */
		Database.getInstance().connect();
		updateTableData();
		updateComboBox();
		btnLoc.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnDonDep.addActionListener(this);
		btnBaoTri.addActionListener(this);
		btnBack.addActionListener(this);
		comboBoxMaKH.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLoc)) {
			KhachHang_DAO ds = new KhachHang_DAO();
			String maKh = txtMaKH.getText(); // Lấy mã khách hàng trên JtexField,Loại bỏ
			int idKH = Integer.parseInt(maKh.substring(2)); // 2 kí tự KH chỉ lấy số ID
			List<KhachHang> list = ds.getKhachHangTheoMaKhachHang(idKH);

			if (txtMaKH.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Mã Cần Lọc !");
			else if (list.size() == 0)
				JOptionPane.showMessageDialog(this, "Không Tìm Thấy !");
			else {
				JOptionPane.showMessageDialog(this, "Lọc Thành Công !");
				for (KhachHang kh : list) {
					comboBoxMaKH.setSelectedItem(kh.getMaKH());
					txtTenKH.setText(kh.getMaKH());
					txtEmailKH.setText(kh.getEmail());
					if (kh.getPhai().equalsIgnoreCase("Nam")) {
						rdbtnNam.setSelected(true);
						rdbtnNu.setSelected(false);
					} else {
						rdbtnNu.setSelected(true);
						rdbtnNam.setSelected(false);
					}
					txtCMND.setText(kh.getCmnd());
					txtSDT.setText(kh.getSdt());
					txtNgaySinh.setText(kh.getNgaySinh());
					String tuoi = Integer.toString(kh.getTuoi());
					txtTuoi.setText(tuoi);
					txtDiaChi.setText(kh.getDiaChi());
				}
			}
		} else if (o.equals(btnDatPhong)) {
			if (txtMaKH.getText().equals("") || txtTenKH.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Thông Tin Khách Hàng Không Được Bỏ Trống !");
			} else {
				JOptionPane.showMessageDialog(null, "Gì Đó Trời !");
			}
			// Sự kiện chọn một mã khách hàng, hiện thị thông tin khách hàng vào JTextField
		} else if (o.equals(comboBoxMaKH)) {
			KhachHang_DAO ds = new KhachHang_DAO();
			String selectMaKH = comboBoxMaKH.getSelectedItem().toString(); // Lấy mã khách hàng được chọn trong
			int idKH = Integer.parseInt(selectMaKH.substring(2)); // 2 kí tự KH chỉ lấy số ID																// comboBoxMaKH
			List<KhachHang> list = ds.getKhachHangTheoMaKhachHang(idKH); // Tìm khách hàng theo mã được Chọn trên
																				// comboBoxMaKH
			for (KhachHang kh : list) {
				txtMaKH.setText(kh.getMaKH());
				txtTenKH.setText(kh.getTenKH());
				txtEmailKH.setText(kh.getEmail());
				if (kh.getPhai().equalsIgnoreCase("Nam")) {
					rdbtnNam.setSelected(true);
					rdbtnNu.setSelected(false);
				} else {
					rdbtnNu.setSelected(true);
					rdbtnNam.setSelected(false);
				}
				txtCMND.setText(kh.getCmnd());
				txtSDT.setText(kh.getSdt());
				txtNgaySinh.setText(kh.getNgaySinh());
				String tuoi = Integer.toString(kh.getTuoi());
				txtTuoi.setText(tuoi);
				txtDiaChi.setText(kh.getDiaChi());
			}
		}

	}

	// Đưa dữ liệu vào ComboBox
	private void updateComboBox() {
		KhachHang_DAO ds = new KhachHang_DAO();
		List<KhachHang> list = ds.doTuBang();
		for (KhachHang kh : list) {
			comboBoxMaKH.addItem(kh.getMaKH());
		}
	}

	// Đưa dữ liệu vào table Dịch Vụ
	private void updateTableData() {
		DichVu_DAO ds = new DichVu_DAO();
		List<DichVu> list = ds.doTuBang(); // Lấy danh sách sản phẩm
		for (DichVu dv : list) { // Lấy ra từng sản phẩm
			Object data[] = { dv.getMaDV(), dv.getTenDV(), dv.getGiaDV() };
			modelDV.addRow(data);
		}
		tableDV.setModel(modelDV);

	}
}
