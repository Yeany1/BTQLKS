package GUI_RoleQuanLy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Event;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.Database;
import dao.NhanVien_DAO;
import entity.NhanVien;

import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class GUI_NhanVien extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtMaNV, txtTenNV, txtNgaySinhNV, txtEmailNV, txtSDTNV, txtCMND, txtTuoiNV, txtTaiKhoan,
			txtPassWord, txtTimKiem;
	private JButton btnThem, btnXoa, btnSua, btnLamMoi, btnTimKiem, btnReload;
	private JRadioButton rdbtnNam, rdbtnNu;
	private JComboBox comboBoxMaNV;
	private JTable table;
	private DefaultTableModel model;
	private NhanVien_DAO dsnv = new NhanVien_DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_NhanVien frame = new GUI_NhanVien();
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
	public GUI_NhanVien() {
//		try {
//			Database.getInstance().connect();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		setTitle("Quản Lí Khách Sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1460, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		panel.setBackground(new Color(25, 118, 211));
		panel.setBounds(0, 0, 247, 743);
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

		JButton btnBack = new JButton("Back");
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
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(26, 475, 200, 30);
		panel.add(btnBack);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		panel_1.setBounds(246, 0, 366, 743);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblThongNhanVien = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblThongNhanVien.setBounds(74, 91, 205, 20);
		panel_1.add(lblThongNhanVien);
		lblThongNhanVien.setForeground(new Color(0, 127, 255));
		lblThongNhanVien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThongNhanVien.setBackground(new Color(64, 0, 64));

		JLabel lblNewLabel_2 = new JLabel("Mã Nhân Viên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 194, 105, 13);
		panel_1.add(lblNewLabel_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 127, 255));
		panel_2.setBounds(86, 120, 168, 2);
		panel_1.add(panel_2);

		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setBounds(150, 193, 183, 19);
		panel_1.add(txtMaNV);
		txtMaNV.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Tên Nhân Viên");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(20, 229, 112, 13);
		panel_1.add(lblNewLabel_2_1);

		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(150, 228, 183, 19);
		panel_1.add(txtTenNV);

		JLabel lblNewLabel_2_1_1 = new JLabel("Email");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(20, 266, 59, 13);
		panel_1.add(lblNewLabel_2_1_1);

		txtEmailNV = new JTextField();
		txtEmailNV.setColumns(10);
		txtEmailNV.setBounds(150, 265, 183, 19);
		panel_1.add(txtEmailNV);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Số Điện Thoại");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1.setBounds(20, 383, 112, 18);
		panel_1.add(lblNewLabel_2_1_1_1);

		txtSDTNV = new JTextField();
		txtSDTNV.setColumns(10);
		txtSDTNV.setBounds(150, 385, 183, 19);
		panel_1.add(txtSDTNV);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("CMND");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1.setBounds(20, 305, 112, 13);
		panel_1.add(lblNewLabel_2_1_1_1_1);

		txtCMND = new JTextField();
		txtCMND.setColumns(10);
		txtCMND.setBounds(150, 303, 183, 19);
		panel_1.add(txtCMND);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setHorizontalAlignment(SwingConstants.LEFT);
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(150, 497, 183, 19);
		panel_1.add(txtTaiKhoan);

		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiiTnh.setBounds(20, 345, 112, 13);
		panel_1.add(lblGiiTnh);

		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Tài Khoản");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1_1.setBounds(20, 496, 112, 20);
		panel_1.add(lblNewLabel_2_1_1_1_1_1);

		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(GUI_NhanVien.class.getResource("/icon/add-icon-small.png")));
		btnThem.setForeground(new Color(0, 127, 255));
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBounds(20, 575, 159, 32);
		panel_1.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(GUI_NhanVien.class.getResource("/icon/repair-icon-small.png")));
		btnSua.setForeground(new Color(64, 0, 64));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSua.setBackground(Color.WHITE);
		btnSua.setBounds(189, 575, 159, 32);
		panel_1.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(GUI_NhanVien.class.getResource("/icon/trash-icon-small.png")));
		btnXoa.setForeground(new Color(255, 0, 0));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(20, 617, 159, 32);
		panel_1.add(btnXoa);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(GUI_NhanVien.class.getResource("/icon/Refresh-icon-small.png")));
		btnLamMoi.setForeground(new Color(75, 150, 243));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setBounds(189, 617, 159, 32);
		panel_1.add(btnLamMoi);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNam.setBounds(169, 341, 59, 21);
		panel_1.add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNu.setBounds(236, 344, 59, 17);
		panel_1.add(rdbtnNu);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNam);
		group.add(rdbtnNu);

		JLabel lblUsername = new JLabel("PassWord");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(20, 538, 112, 13);
		panel_1.add(lblUsername);

		txtPassWord = new JTextField();
		txtPassWord.setColumns(10);
		txtPassWord.setBounds(150, 534, 183, 19);
		panel_1.add(txtPassWord);

		btnReload = new JButton("Reload Data");
		btnReload.setIcon(new ImageIcon(GUI_NhanVien.class.getResource("/icon/reload-icon-small.png")));
		btnReload.setForeground(new Color(38, 198, 240));
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReload.setBackground(Color.WHITE);
		btnReload.setBounds(105, 669, 159, 32);
		panel_1.add(btnReload);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("Ngày Sinh");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_2.setBounds(20, 422, 112, 18);
		panel_1.add(lblNewLabel_2_1_1_2);

		txtNgaySinhNV = new JTextField();
		txtNgaySinhNV.setColumns(10);
		txtNgaySinhNV.setBounds(150, 423, 183, 19);
		panel_1.add(txtNgaySinhNV);

		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Tuổi");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_2_1.setBounds(20, 460, 112, 18);
		panel_1.add(lblNewLabel_2_1_1_2_1);

		txtTuoiNV = new JTextField();
		txtTuoiNV.setColumns(10);
		txtTuoiNV.setBounds(150, 462, 183, 19);
		panel_1.add(txtTuoiNV);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		panel_3.setBounds(607, 0, 839, 67);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(330, 22, 183, 19);
		panel_3.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(GUI_NhanVien.class.getResource("/icon/search-icon-small.png")));
		btnTimKiem.setBounds(530, 20, 126, 24);
		panel_3.add(btnTimKiem);
		btnTimKiem.setForeground(new Color(0, 127, 255));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setBackground(Color.WHITE);

		comboBoxMaNV = new JComboBox();
		comboBoxMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxMaNV.setBounds(230, 21, 80, 21);
		panel_3.add(comboBoxMaNV);

		JLabel lblNewLabel = new JLabel("Mã Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(122, 23, 126, 16);
		panel_3.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(611, 66, 835, 677);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(model = new DefaultTableModel(new Object[][] {}, new String[] { "Mã Nhân Viên", "Tên Nhân Viên",
				"Email", "CMND", "Giới Tính", "Số Điện Thoại", "Ngày Sinh", "Tuổi", "Tài Khoản", "PassWord" }));
		NumberFormat format = NumberFormat.getInstance();

		/*
		 * ==== EVENT ====
		 */
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnReload.addActionListener(this);
		comboBoxMaNV.addActionListener(this);

		// Chương trình chạy , lấy dữ liệu đưa vào table, combobox
		Database.getInstance().connect();
		updateComboBox();
		updateTableData();

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
				txtMaNV.setText(model.getValueAt(row, 0).toString());
				txtTenNV.setText(model.getValueAt(row, 1).toString());
				txtEmailNV.setText(model.getValueAt(row, 2).toString());
				txtCMND.setText(model.getValueAt(row, 3).toString());
				if (model.getValueAt(row, 4).toString().equalsIgnoreCase("Nam")) {
					rdbtnNam.setSelected(true);
					rdbtnNu.setSelected(false);
				} else {
					rdbtnNu.setSelected(true);
					rdbtnNam.setSelected(false);
				}
				txtSDTNV.setText(model.getValueAt(row, 5).toString());
				txtNgaySinhNV.setText(model.getValueAt(row, 6).toString());
				txtTuoiNV.setText(model.getValueAt(row, 7).toString());
				txtTaiKhoan.setText(model.getValueAt(row, 8).toString());
				txtPassWord.setText(model.getValueAt(row, 9).toString());
//				String value = table.getValueAt(row, 0).toString();
//				comboBoxMaNV.setSelectedItem(value);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (validData()) {
				NhanVien nv = reverSPFfromTextFile(); // Lấy dữ liệu từ JtexFiled thêm vào danh sách nhân viên
				if (dsnv.create(nv)) { // Thêm nhân viên vào SQL
					// Thêm nhân viên table
					JOptionPane.showMessageDialog(null, "Thêm Thành Công !");
					updateTableData();
					updateComboBox();
				} else {
					showMessage("Không Thể Thêm Do Trùng Mã !", txtMaNV);
				}
			}
		} else if (o.equals(btnSua)) {
			if (validData()) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					NhanVien nv = reverSPFfromTextFile(); // Lấy dữ liệu đã sửa từ JtextField
					if (dsnv.update(nv)) { // Cập nhật nhân viên vào SQL
						// Cập nhật khách hàng vào table
//						String gioiTinh;
//						if (rdbtnNam.isSelected()) {
//							gioiTinh = rdbtnNam.getText();
//						} else {
//							gioiTinh = rdbtnNu.getText();
//						}
//						table.setValueAt(txtTenNV.getText(), row, 1);
//						table.setValueAt(txtEmailNV.getText(), row, 2);
//						table.setValueAt(txtCMND.getText(), row, 3);
//						table.setValueAt(gioiTinh, row, 4);
//						table.setValueAt(txtSDTNV.getText(), row, 5);
//						table.setValueAt(txtNgaySinhNV.getText(), row, 6);
//						table.setValueAt(txtTuoiNV.getText(), row, 7);
//						table.setValueAt(txtTaiKhoan.getText(), row, 8);
//						table.setValueAt(txtPassWord.getText(), row, 9);
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
				String maNV = (String) table.getValueAt(row, 0); // Lấy mã khách hàng khi chọn trên table
				int ID = Integer.parseInt(maNV.substring(2)); // Loại bỏ 2 kí tự NV chỉ lấy số ID
				if (row >= 0 && JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Xóa Nhân Viên Có Mã " + maNV,
						"Cảnh Báo !!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (dsnv.delete(ID)) {
						JOptionPane.showMessageDialog(null, "Xóa Thành Công !");
						updateComboBox();
						model.removeRow(row);
						xoaRong();
					}
				}
			}
		} else if (o.equals(btnLamMoi)) {
			xoaRong();
		} else if (o.equals(btnTimKiem)) {
			NhanVien_DAO ds = new NhanVien_DAO();
			// Tìm nhân viên bằng mã nhân viên trên SQL
			String maNV = txtTimKiem.getText();
			int idNV = Integer.parseInt(maNV.substring(2));
			List<NhanVien> list = ds.getNhanVienTheoMaNhanVien(idNV);

			if (txtTimKiem.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Mã Cần Tìm !");
			else if (list.size() == 0)
				JOptionPane.showMessageDialog(this, "Không Tìm Thấy !");
			else {
				JOptionPane.showMessageDialog(this, "Tìm Thấy !");
				model.getDataVector().removeAllElements(); // Xóa tất cả các dòng (dữ liệu) hiện tại trong table
				xoaRong();
				for (NhanVien nv : list) { // Lấy dữ diệu khách hàng được tìm thấy đưa vào table
					Object data[] = { nv.getMaNV(), nv.getTenNV(), nv.getEmail(), nv.getCmnd(), nv.getPhai(),
							nv.getSdt(), nv.getNgaySinh(), nv.getTuoi(), nv.getTaiKhoan(), nv.getPassword() };
					model.addRow(data);
				}
				table.setModel(model);
			}
		} else if (o.equals(btnReload)) {
			JOptionPane.showMessageDialog(null, "Cập nhật Data Thành Công !");
			updateTableData();
		} else if (o.equals(comboBoxMaNV)) {
			Object select = comboBoxMaNV.getSelectedItem();
			if (select != null) {
				String selectMaKH = select.toString();
				txtTimKiem.setText(selectMaKH);
			}
		}
	}

	private void xoaRong() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtNgaySinhNV.setText("");
		txtTuoiNV.setText("");
		txtEmailNV.setText("");
		txtCMND.setText("");
		rdbtnNam.setSelected(false);
		rdbtnNu.setSelected(false);
		txtSDTNV.setText("");
		txtTaiKhoan.setText("");
		txtPassWord.setText("");
		txtTimKiem.setText("");
		txtMaNV.requestFocus();
	}

	private void showMessage(String mess, JTextField txt) {
		JOptionPane.showMessageDialog(null, mess);
		txt.requestFocus();
	}

	// Kiểm tra Regex
	private boolean validData() {
		String ma = txtMaNV.getText().trim();
		String ten = txtTenNV.getText().trim();
		String tuoi = txtTuoiNV.getText().trim();
		String email = txtEmailNV.getText().trim();
		String cmnd = txtCMND.getText().trim();
		String sdt = txtSDTNV.getText().trim();
		String diaChi = txtTaiKhoan.getText().trim();
		String password = txtPassWord.getText().trim();

//		if (!(ma.length() > 0 && ma.matches("^(NV)[0-9]+"))) {
//			showMessage("Mã Nhân Viên phải bắt đầu bằng 'NV' sau đó là kí số và không có khoảng trắng !", txtMaNV);
//			return false;
//		}
		if (!(ten.length() > 0 && ten.matches("^[\\p{L} ]+"))) { // \\p{L} Bất kỳ ký tự chữ nào trong bảng mã Unicode,
			showMessage("Tên Nhân Viên phải là kí tự chữ", txtTenNV); // Bao gồm cả các ký tự có sắc âm.
			return false;
		}
		if (!(tuoi.length() > 0 && tuoi.matches("\\d{2}"))) {
			showMessage("Năm Sinh Nhân Viên phải là 2 kí số !", txtTuoiNV);
			return false;
		} else {
			try {
				int x = Integer.parseInt(tuoi);
				if (!(x >= 18)) {
					showMessage("Tuổi Nhân Viên >= 18 !", txtTuoiNV);
					return false;
				}
			} catch (NumberFormatException e) {
				showMessage("Năm Sinh Nhân Viên phải là kí số !", txtTuoiNV);
				return false;
			}
		}
		if (!(email.length() > 0 && email.matches("^[a-zA-Z][a-zA-Z0-9]+@gmail.com$"))) {
			showMessage("Email Nhân Viên phải bắt đầu bằng chữ cái và kết thúc @gmail.com và không có khoảng trắng !",
					txtEmailNV);
			return false;
		}
		if (!(cmnd.length() > 0 && cmnd.matches("\\d+"))) {
			showMessage("CMND Nhân Viên phải là kí số !", txtCMND);
			return false;
		}
		if (!(rdbtnNam.isSelected() || rdbtnNu.isSelected())) {
			showMessage("Phải chọn giới tính !", null);
			return false;
		}
		if (!(sdt.length() > 0 && sdt.matches("^0\\d+"))) {
			showMessage("Số Điện Thoại Nhân Viên phải bắt đầu là số 0 !", txtSDTNV);
			return false;
		}
		if (!(diaChi.length() > 0)) {
			showMessage("Địa Chỉ Nhân Viên không được bỏ trống !", txtTaiKhoan);
			return false;
		}
		if (!(password.length() > 0)) {
			showMessage("PassWord Nhân Viên không được bỏ trống !", txtPassWord);
			return false;
		}
		return true;
	}

	// Lấy dữ liệu từ JtexField khi nhập vào
	private NhanVien reverSPFfromTextFile() {
		String ma = txtMaNV.getText().toString();
		String ten = txtTenNV.getText().toString();
		String email = txtEmailNV.getText().toString();
		String cmnd = txtCMND.getText().toString();
		String gioiTinh;
		if (rdbtnNam.isSelected()) {
			gioiTinh = rdbtnNam.getText();
		} else {
			gioiTinh = rdbtnNu.getText();
		}
		String ngaySinh = txtNgaySinhNV.getText().toString();
		int tuoi = Integer.parseInt(txtTuoiNV.getText());
		String sdt = txtSDTNV.getText().toString();
		String taiKhoan = txtTaiKhoan.getText().toString();
		String password = txtPassWord.getText().toString();
		return new NhanVien(ma, ten, cmnd, tuoi, gioiTinh, ngaySinh, sdt, email, taiKhoan, password);
	}

	// Đưa dữ liệu vào ComboBox
	private void updateComboBox() {
		comboBoxMaNV.removeAllItems(); // Xóa tất cả các item cũ để cập nhật lại sau khi(Thêm, Xóa)
		NhanVien_DAO ds = new NhanVien_DAO();
		List<NhanVien> list = ds.doTuBang();
		for (NhanVien nv : list) {
			comboBoxMaNV.addItem(nv.getMaNV());
		}
	}

	// Đưa dữ liệu vào table
	private void updateTableData() {
		model.getDataVector().removeAllElements(); // Xóa tất cả các dòng (dữ liệu) hiện tại trong table
		NhanVien_DAO ds = new NhanVien_DAO();
		List<NhanVien> list = ds.doTuBang(); // Lấy danh sách nhân viên
		for (NhanVien nv : list) { // Lấy ra từng nhân viên
			Object data[] = { nv.getMaNV(), nv.getTenNV(), nv.getEmail(), nv.getCmnd(), nv.getPhai(), nv.getSdt(),
					nv.getNgaySinh(), nv.getTuoi(), nv.getTaiKhoan(), nv.getPassword() };
			model.addRow(data);
		}
		table.setModel(model);
	}
}
