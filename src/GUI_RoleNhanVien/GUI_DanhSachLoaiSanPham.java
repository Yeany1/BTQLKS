package GUI_RoleNhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

public class GUI_DanhSachLoaiSanPham extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaLoai, txtTenLoai, txtTimKiem;
	private JButton btnThem, btnXoa, btnLamMoi, btnTimKiem;
	private JComboBox comboBoxMaSanPham ;
	private JTable table;
	private DefaultTableModel model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DanhSachLoaiSanPham frame = new GUI_DanhSachLoaiSanPham();
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
	public GUI_DanhSachLoaiSanPham() {
		setTitle("Quản Lý Khách Sạn");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDanhSchLoi = new JLabel("Danh Sách Loại Sản Phẩm");
		lblDanhSchLoi.setForeground(new Color(0, 127, 255));
		lblDanhSchLoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDanhSchLoi.setBackground(new Color(64, 0, 64));
		lblDanhSchLoi.setBounds(208, 32, 224, 20);
		contentPane.add(lblDanhSchLoi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 127, 255));
		panel_2.setBounds(232, 62, 172, 2);
		contentPane.add(panel_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		panel.setBounds(0, 86, 320, 177);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã loại");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(20, 22, 60, 18);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên loại");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(20, 57, 60, 18);
		panel.add(lblNewLabel_2_1);
		
		txtMaLoai = new JTextField();
		txtMaLoai.setColumns(10);
		txtMaLoai.setBounds(89, 24, 214, 19);
		panel.add(txtMaLoai);
		
		txtTenLoai = new JTextField();
		txtTenLoai.setColumns(10);
		txtTenLoai.setBounds(89, 59, 214, 19);
		panel.add(txtTenLoai);
		
		btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(0, 127, 255));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThem.setBackground(Color.WHITE);
		btnThem.setBounds(10, 102, 80, 32);
		panel.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(Color.RED);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(100, 102, 80, 32);
		panel.add(btnXoa);
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setForeground(new Color(75, 150, 243));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLamMoi.setBackground(Color.WHITE);
		btnLamMoi.setBounds(190, 102, 113, 32);
		panel.add(btnLamMoi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		panel_1.setBounds(317, 86, 300, 177);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tìm sản phẩm");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(96, 22, 101, 18);
		panel_1.add(lblNewLabel_2_2);
		
		comboBoxMaSanPham = new JComboBox();
		comboBoxMaSanPham.setBounds(20, 59, 103, 21);
		comboBoxMaSanPham.addItem("Mã sản phẩm");
		panel_1.add(comboBoxMaSanPham);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(133, 62, 154, 19);
		panel_1.add(txtTimKiem);
		
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(GUI_DanhSachLoaiSanPham.class.getResource("/icon/search-icon-small.png")));
		btnTimKiem.setForeground(new Color(0, 127, 255));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimKiem.setBackground(Color.WHITE);
		btnTimKiem.setBounds(20, 102, 267, 32);
		panel_1.add(btnTimKiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(2, 264, 615, 199);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 127, 255), null));
		table.setModel(model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Loại", "Tên Loại"
			}
		));
		scrollPane.setViewportView(table);
	}
}
