package GUI_RoleNhanVien;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import GUI_RoleQuanLy.GUI_KhachHang;
import connectDB.Database;
import dao.KhachHang_DAO;
import entity.KhachHang;

public class GUI_KhachHangRNV extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField txtMaKH, txtTenKH, txtEmailKH, txtSDTKH, txtCMND, txtTimKiem, txtNgaySinhKH, txtDiaChiKH,
			txtTuoiKH;
	private JButton btnQLKH, btnQLDV, btnQLTK, btnLogout, btnThem, btnXoa, btnSua, btnLamMoi, btnReload, btnTimKiem,
			btnBack;
	private JRadioButton rdbtnNam, rdbtnNu;
	private JComboBox comboBoxMaKH;
	private JTable table;
	private DefaultTableModel model;

	private KhachHang_DAO dskh = new KhachHang_DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_KhachHangRNV frame = new GUI_KhachHangRNV();
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
	public GUI_KhachHangRNV() {
		setTitle("Quản Lí Khách Sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 736);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		panel.setBackground(new Color(25, 118, 211));
		panel.setBounds(0, 0, 247, 699);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GUI_KhachHang.class.getResource("/icon/admin_avt_64.png")));
		lblNewLabel_1.setBackground(new Color(255, 128, 64));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(90, 80, 64, 64);
		panel.add(lblNewLabel_1);

		btnQLKH = new JButton("Quản Lý Khách Hàng");
		btnQLKH.setForeground(Color.BLACK);
		btnQLKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLKH.setBounds(26, 219, 200, 30);
		panel.add(btnQLKH);

		JLabel lblNewLabel_3;
		lblNewLabel_3 = new JLabel("QUẢN LÝ KHÁCH SẠN");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_3.setBounds(-14, 21, 275, 40);
		panel.add(lblNewLabel_3);

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
		btnQLDV.setBounds(26, 268, 200, 30);
		panel.add(btnQLDV);

		btnQLTK = new JButton("Tra Cứu Hóa Đơn");
		btnQLTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_DSHoaDonRoleNV().setVisible(true);
				dispose();
			}
		});
		btnQLTK.setForeground(Color.BLACK);
		btnQLTK.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnQLTK.setBounds(26, 319, 200, 30);
		panel.add(btnQLTK);

		btnLogout = new JButton("Đăng Xuất");
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogout.setBounds(26, 601, 200, 30);
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				System.exit(0);
			}
		});
		panel.add(btnLogout);

		btnBack = new JButton("Back");
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(26, 368, 200, 30);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_QuanLiPhongRNV().setVisible(true);
				dispose();
			}
		});
		panel.add(btnBack);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		panel_1.setBounds(245, 0, 365, 699);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblThongNhanVien = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblThongNhanVien.setBounds(74, 90, 224, 20);
		panel_1.add(lblThongNhanVien);
		lblThongNhanVien.setForeground(new Color(0, 127, 255));
		lblThongNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongNhanVien.setBackground(new Color(64, 0, 64));

		JLabel lblNewLabel_2 = new JLabel("Mã Khách Hàng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 192, 120, 18);
		panel_1.add(lblNewLabel_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 127, 255));
		panel_2.setBounds(100, 120, 168, 2);
		panel_1.add(panel_2);

		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(150, 193, 183, 19);
		panel_1.add(txtMaKH);
		txtMaKH.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Tên Khách Hàng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(20, 227, 120, 18);
		panel_1.add(lblNewLabel_2_1);

		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(150, 228, 183, 19);
		panel_1.add(txtTenKH);

		JLabel lblNewLabel_2_1_1 = new JLabel("Email");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(20, 266, 112, 13);
		panel_1.add(lblNewLabel_2_1_1);

		txtEmailKH = new JTextField();
		txtEmailKH.setColumns(10);
		txtEmailKH.setBounds(150, 265, 183, 19);
		panel_1.add(txtEmailKH);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Số Điện Thoại");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(20, 374, 112, 18);
		panel_1.add(lblNewLabel_2_1_1_1);

		txtSDTKH = new JTextField();
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(150, 374, 183, 19);
		panel_1.add(txtSDTKH);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("CMND");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1.setBounds(20, 338, 112, 13);
		panel_1.add(lblNewLabel_2_1_1_1_1);

		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(150, 337, 183, 19);
		panel_1.add(txtCMND);

		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiiTnh.setBounds(20, 303, 112, 13);
		panel_1.add(lblGiiTnh);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GUI_KhachHang.class.getResource("/icon/add-icon-small.png")));
		btnThem.setForeground(new Color(0, 127, 255));
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBounds(20, 519, 159, 32);
		panel_1.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(GUI_KhachHang.class.getResource("/icon/repair-icon-small.png")));
		btnSua.setForeground(new Color(64, 0, 64));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBackground(Color.WHITE);
		btnSua.setBounds(191, 519, 159, 32);
		panel_1.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GUI_KhachHang.class.getResource("/icon/trash-icon-small.png")));
		btnXoa.setForeground(new Color(255, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(20, 561, 159, 32);
		panel_1.add(btnXoa);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(GUI_KhachHang.class.getResource("/icon/Refresh-icon-small.png")));
		btnLamMoi.setForeground(new Color(75, 150, 243));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setBounds(191, 561, 159, 32);
		panel_1.add(btnLamMoi);

		JLabel lblNmSinh = new JLabel("Ngày Sinh");
		lblNmSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNmSinh.setBounds(20, 412, 112, 13);
		panel_1.add(lblNmSinh);

		txtNgaySinhKH = new JTextField();
		txtNgaySinhKH.setColumns(10);
		txtNgaySinhKH.setBounds(150, 409, 183, 19);
		panel_1.add(txtNgaySinhKH);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNam.setBounds(178, 299, 59, 21);
		panel_1.add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNu.setBounds(249, 299, 59, 21);
		panel_1.add(rdbtnNu);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNam);
		group.add(rdbtnNu);

		btnReload = new JButton("Reload Data");
		btnReload.setIcon(new ImageIcon(GUI_KhachHang.class.getResource("/icon/reload-icon-small.png")));
		btnReload.setForeground(new Color(38, 198, 240));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReload.setBackground(Color.WHITE);
		btnReload.setBounds(100, 603, 159, 32);
		panel_1.add(btnReload);

		JLabel lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblaCh.setBounds(22, 476, 112, 13);
		panel_1.add(lblaCh);

		txtDiaChiKH = new JTextField();
		txtDiaChiKH.setColumns(10);
		txtDiaChiKH.setBounds(150, 472, 183, 19);
		panel_1.add(txtDiaChiKH);

		txtTuoiKH = new JTextField();
		txtTuoiKH.setColumns(10);
		txtTuoiKH.setBounds(150, 441, 183, 19);
		panel_1.add(txtTuoiKH);

		JLabel lblTui;
		lblTui = new JLabel("Tuổi");
		lblTui.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTui.setBounds(21, 446, 59, 13);
		panel_1.add(lblTui);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		panel_3.setBounds(607, 0, 779, 67);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(356, 22, 183, 19);
		panel_3.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(GUI_KhachHang.class.getResource("/icon/search-icon-small.png")));
		btnTimKiem.setBounds(564, 19, 126, 24);
		panel_3.add(btnTimKiem);
		btnTimKiem.setForeground(new Color(0, 127, 255));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setBackground(Color.WHITE);

		comboBoxMaKH = new JComboBox();
		comboBoxMaKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxMaKH.setBounds(252, 21, 80, 21);
		panel_3.add(comboBoxMaKH);

		JLabel lblNewLabel = new JLabel("Mã Khách Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(130, 22, 126, 19);
		panel_3.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(609, 66, 777, 633);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(model = new DefaultTableModel(new Object[][] {}, new String[] { "Mã Khách Hàng",
				"Tên Khách Hàng", "Email", "Giới Tính", "CMND", "Số Điện Thoại", "Ngày Sinh", "Tuổi", "Địa Chỉ" }));

		/*
		 * ==== EVENT ====
		 * 
		 * Chương trình chạy , lấy dữ liệu đưa vào table, combobox
		 */
		Database.getInstance().connect();
		updateComboBox();
		updateTableData();
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnReload.addActionListener(this);
		comboBoxMaKH.addActionListener(this);

		// Sự kiện Click getValueAt
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaKH.setText(model.getValueAt(row, 0).toString());
				txtTenKH.setText(model.getValueAt(row, 1).toString());
				txtEmailKH.setText(model.getValueAt(row, 2).toString());
				if (model.getValueAt(row, 3).toString().equalsIgnoreCase("Nam")) {
					rdbtnNam.setSelected(true);
					rdbtnNu.setSelected(false);
				} else {
					rdbtnNu.setSelected(true);
					rdbtnNam.setSelected(false);
				}
				txtCMND.setText(model.getValueAt(row, 4).toString());
				txtSDTKH.setText(model.getValueAt(row, 5).toString());
				txtNgaySinhKH.setText(model.getValueAt(row, 6).toString());
				txtTuoiKH.setText(model.getValueAt(row, 7).toString());
				txtDiaChiKH.setText(model.getValueAt(row, 8).toString());
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (validData()) {
				KhachHang kh = reverSPFfromTextFile(); // Lấy dữ liệu từ JtexFiled thêm vào danh sách khách hàng
				if (dskh.create(kh)) { // Thêm khách hàng vào SQL
					JOptionPane.showMessageDialog(null, "Thêm Thành Công !");
					updateTableData(); // Cập nhật dữ liệu mới vào table
					updateComboBox();
				} else {
					showMessage("Không Thể Thêm Do Trùng Mã !", txtMaKH);
				}
			}
		} else if (o.equals(btnSua)) {
			if (validData()) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					KhachHang kh = reverSPFfromTextFile(); // Lấy dữ liệu đã sửa từ JtextField
					if (dskh.update(kh)) { // Cập nhật khách hàng vào SQL
						// Cập nhật khách hàng vào table
//						String gioiTinh;
//						if (rdbtnNam.isSelected()) {
//							gioiTinh = rdbtnNam.getText();
//						} else {
//							gioiTinh = rdbtnNu.getText();
//						}
//						table.setValueAt(txtTenKH.getText(), row, 1);
//						table.setValueAt(txtEmailKH.getText(), row, 2);
//						table.setValueAt(gioiTinh, row, 3);
//						table.setValueAt(txtCMND.getText(), row, 4);
//						table.setValueAt(txtSDTKH.getText(), row, 5);
//						table.setValueAt(txtNgaySinhKH.getText(), row, 6);
//						table.setValueAt(txtTuoiKH.getText(), row, 7);
//						table.setValueAt(txtDiaChiKH.getText(), row, 8);
						updateTableData();
						JOptionPane.showMessageDialog(null, "Sửa Thành Công !");
					}
				}
			}
		} else if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Hãy Chọn Dòng Muốn Xóa !");
			} else {

				String maKH = (String) table.getValueAt(row, 0); // Lấy mã khách hàng khi chọn 1 dòng trên table
				int idKH = Integer.parseInt(maKH.substring(2)); // Loại bỏ 2 kí tự KH chỉ lấy số ID
				if (row >= 0 && JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Xóa Khách Hàng Có Mã " + maKH,
						"Cảnh Báo !!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (dskh.delete(idKH)) {
						JOptionPane.showMessageDialog(null, "Xóa Thành Công !");
						model.removeRow(row);
						updateComboBox();
						xoaRong();
					}
				}
			}
		} else if (o.equals(btnLamMoi)) {
			xoaRong();
		} else if (o.equals(btnTimKiem)) {
			KhachHang_DAO ds = new KhachHang_DAO();
			// Tìm khách hàng bằng mã khách hàng trên SQL
			String maKh = txtTimKiem.getText();
			int idKH = Integer.parseInt(maKh.substring(2)); // Lấy mã khách hàng trên JtexField,Loại bỏ
																			// 2 kí tự KH chỉ lấy số ID
			List<KhachHang> list = ds.getKhachHangTheoMaKhachHang(idKH);

			if (txtTimKiem.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Mã Cần Tìm !");
			else if (list.size() == 0)
				JOptionPane.showMessageDialog(this, "Không Tìm Thấy !");
			else {
				JOptionPane.showMessageDialog(this, "Tìm Thấy !");
				xoaRong();
				model.getDataVector().removeAllElements(); // Xóa tất cả các dòng (dữ liệu) hiện tại trong table
				for (KhachHang kh : list) { // Lấy dữ diệu khách hàng được tìm thấy đưa vào table
					Object data[] = { kh.getMaKH(), kh.getTenKH(), kh.getEmail(), kh.getPhai(), kh.getCmnd(),
							kh.getSdt(), kh.getNgaySinh(), kh.getTuoi(), kh.getDiaChi() };
					model.addRow(data);
				}
				table.setModel(model);
				xoaRong();
			}
		} else if (o.equals(btnReload)) {
			JOptionPane.showMessageDialog(null, "Cập nhật Data Thành Công !");
			updateTableData();
			xoaRong();
		} else if (o.equals(comboBoxMaKH)) {
			Object select = comboBoxMaKH.getSelectedItem();
		    if (select != null) {
		        String selectMaKH = select.toString();
		        txtTimKiem.setText(selectMaKH);
		    }
		}
	}

	private void xoaRong() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtEmailKH.setText("");
		rdbtnNam.setSelected(false);
		rdbtnNu.setSelected(false);
		txtCMND.setText("");
		txtSDTKH.setText("");
		txtNgaySinhKH.setText("");
		txtTuoiKH.setText("");
		txtDiaChiKH.setText("");
		txtTimKiem.setText("");
		txtMaKH.requestFocus();
	}

	private void showMessage(String mess, JTextField txt) {
		JOptionPane.showMessageDialog(null, mess);
		txt.requestFocus();
	}

	// Kiểm tra Regex
	private boolean validData() {
		String ten = txtTenKH.getText().trim();
		String email = txtEmailKH.getText().trim();
		String cmnd = txtCMND.getText().trim();
		String sdt = txtSDTKH.getText().trim();
		String ngaySinh = txtNgaySinhKH.getText().trim();
		String tuoi = txtTuoiKH.getText().trim();
		String diaChi = txtDiaChiKH.getText().trim();

		if (!(ten.length() > 0 && ten.matches("^[\\p{L} ]+"))) { // \\p{L} Bất kỳ ký tự chữ nào trong bảng mã Unicode,
			showMessage("Tên Khách Hàng phải là kí tự chữ", txtTenKH); // Bao gồm cả các ký tự có sắc âm.
			return false;
		}
		if (!(email.length() > 0 && email.matches("^[a-zA-Z][a-zA-Z0-9]+@gmail.com$"))) {
			showMessage("Email Khách Hàng phải bắt đầu bằng chữ cái và kết thúc @gmail.com và không có khoảng trắng !",
					txtEmailKH);
			return false;
		}
		if (!(rdbtnNam.isSelected() || rdbtnNu.isSelected())) {
			showMessage("Vui Lòng chọn giới tính !", null);
			return false;
		}
		if (!(cmnd.length() > 0 && cmnd.matches("\\d+"))) {
			showMessage("CMND Khách Hàng phải là kí số !", txtCMND);
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("^0\\d+"))) {
			showMessage("Số Điện Thoại Khách Hàng phải bắt đầu bằng số 0 !", txtSDTKH);
			return false;
		}
		if(!(ngaySinh.length() > 0)) {
			showMessage("Ngày Sinh Khách Hàng không được bỏ trống !", txtTuoiKH);
			return false;
		}
		if (!(tuoi.length() > 0 && tuoi.matches("\\d{2}"))) {
			showMessage("Tuổi Khách Hàng phải là 2 kí số !", txtTuoiKH);
			return false;
		} else {
			try {
				int x = Integer.parseInt(tuoi);
				if (!(x >= 18)) {
					showMessage("Tuổi Khách Hàng >= 18 !", txtTuoiKH);
					return false;
				}
			} catch (NumberFormatException e) {
				showMessage("Tuổi Khách Hàng phải là kí số !", txtTuoiKH);
				return false;
			}
		}
		if (!(diaChi.length() > 0)) {
			showMessage("Địa Chỉ Khách Hàng không được bỏ trống !", txtDiaChiKH);
			return false;
		}
		return true;
	}

	// Lấy dữ liệu từ JtexField khi nhập vào
	private KhachHang reverSPFfromTextFile() {
		String ma = txtMaKH.getText().toString();
		String ten = txtTenKH.getText().toString();
		String email = txtEmailKH.getText().toString();
		String gioiTinh;
		if (rdbtnNam.isSelected()) {
			gioiTinh = rdbtnNam.getText();
		} else {
			gioiTinh = rdbtnNu.getText();
		}
		String cmnd = txtCMND.getText().toString();
		String sdt = txtSDTKH.getText().toString();
		String ns = txtNgaySinhKH.getText().toString();
		int tuoi = Integer.parseInt(txtTuoiKH.getText());
		String diaChi = txtDiaChiKH.getText().toString();
		return new KhachHang(ma, tuoi, ten, cmnd, gioiTinh, ns, email, diaChi, sdt);
	}

	// Đưa dữ liệu vào ComboBox
	private void updateComboBox() {
		comboBoxMaKH.removeAllItems(); // Xóa tất cả các item cũ để cập nhật lại sau khi(Thêm, Xóa)
		KhachHang_DAO ds = new KhachHang_DAO();
		List<KhachHang> list = ds.doTuBang();
		for (KhachHang kh : list) {
			comboBoxMaKH.addItem(kh.getMaKH());
		}
	}

	// Đưa dữ liệu vào table
	private void updateTableData() {
		model.getDataVector().removeAllElements(); // Xóa tất cả các dòng (dữ liệu) hiện tại trong table
		KhachHang_DAO ds = new KhachHang_DAO();
		List<KhachHang> list = ds.doTuBang(); // Lấy danh sách khách hàng
		for (KhachHang kh : list) { // Lấy ra từng khách hàng
			Object data[] = { kh.getMaKH(), kh.getTenKH(), kh.getEmail(), kh.getPhai(), kh.getCmnd(), kh.getSdt(),
					kh.getNgaySinh(), kh.getTuoi(), kh.getDiaChi() };
			model.addRow(data);
		}
		table.setModel(model);

	}
}
