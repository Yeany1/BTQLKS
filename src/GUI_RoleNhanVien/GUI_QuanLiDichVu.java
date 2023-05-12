package GUI_RoleNhanVien;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class GUI_QuanLiDichVu extends JFrame implements ActionListener, MouseListener {
	private DefaultTableModel modelHD;
	String[] colsHD = { "Số phòng", "Tên sản phẩm", "Số Lượng", "Tổng tiền", "Ngày lập" };
	public JPanel pnMain;
	private JTable tableHD;

	private JTextField txtTongTien;
	private JButton btnThem;
	private JComboBox<String> cboMaKH, cboLoaiDV, cboTenSP;
	private JPanel panel_1;
	private JTextField txtTenKhachHang;
 
	private JTextField txtGia, txtSL;
	private JTextField txtTen;
	private JButton btnTimMaHDDV;
	private JButton btnXem;
	private JButton btnPrint;
	private JButton btnThemMatHang;
	private JTextField txtTenSP;
	private JButton btnXoa;
	private JButton btnRefresh;
	private JButton btnChiTiet;

	public GUI_QuanLiDichVu() throws SQLException {

		setTitle("Quản Lý Khách Sạn");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1300, 700);

		setBackground(new Color(244, 247, 254));
		pnMain = new JPanel();
		pnMain.setBounds(0, 0, 584, 411);
		setContentPane(pnMain);

		JLabel lbTitle = new JLabel("Quản Lý Dịch Vụ");
		lbTitle.setBounds(585, 11, 348, 30);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnMain.add(lbTitle);

		modelHD = new DefaultTableModel(colsHD, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int i, int i1) {
				return false;
				// Không cho chỉnh sửa trên table
			}
		};

		pnMain.setLayout(null);

		JPanel pn = new JPanel();
		pn.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi tiết",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn.setBounds(10, 65, 347, 300);
		pnMain.add(pn);
		pn.setLayout(null);

		JLabel lbMaKH = new JLabel("Số Phòng:");
		lbMaKH.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMaKH.setBounds(10, 25, 93, 25);
		pn.add(lbMaKH);

		cboMaKH = new JComboBox<String>();
		cboMaKH.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cboMaKH.setBounds(122, 25, 205, 25);
		cboMaKH.addItem("");
		List<String> tenKhachHang = new ArrayList<String>();
		tenKhachHang.add("Nhấn để chọn số phòng");
	
		cboMaKH.setModel(new DefaultComboBoxModel<>(tenKhachHang.toArray(String[]::new)));
		pn.add(cboMaKH);

		JLabel lbTen = new JLabel("Loại Dịch Vụ");
		lbTen.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbTen.setBounds(10, 61, 93, 25);
		pn.add(lbTen);

		cboLoaiDV = new JComboBox<String>();
		cboLoaiDV.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cboLoaiDV.setBounds(122, 61, 205, 25);
		cboLoaiDV.addItem("Đồ uống");
		cboLoaiDV.addItem("Món Ăn");
		cboLoaiDV.addItem("Thức ăn khô");
		pn.add(cboLoaiDV);
		
//		txtTen = new JTextField();
//		txtTen.setEditable(false);
//		txtTen.setColumns(10);
//		txtTen.setBounds(122, 61, 205, 25);
//		pn.add(txtTen);

		JLabel lbMaSP = new JLabel("Tên sản phẩm:");
		lbMaSP.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMaSP.setBounds(10, 97, 93, 25);
		pn.add(lbMaSP);
		
//		txtTenSP = new JTextField();
//		txtTenSP.setColumns(10);
//		txtTenSP.setBounds(122, 97, 205, 25);
//		pn.add(txtTenSP);
		
		cboTenSP = new JComboBox<String>();
		cboTenSP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cboTenSP.setBounds(122, 97, 205, 25);
		cboTenSP.addItem("");
		pn.add(cboTenSP);
		
		JLabel lbSL = new JLabel("Số Lượng:");
		lbSL.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbSL.setBounds(10, 133, 93, 25);
		pn.add(lbSL);
		
		txtSL = new JTextField();
		txtSL.setColumns(10);
		txtSL.setBounds(122, 133, 205, 25);
		pn.add(txtSL);
		
//		btnThemMatHang = new JButton("Điều chỉnh đơn hàng");
//		btnThemMatHang.setBounds(122, 94, 205, 25);
//		pn.add(btnThemMatHang);

		JLabel lbTongTien = new JLabel("Thành tiền:");
		lbTongTien.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbTongTien.setBounds(10, 169, 93, 25);
		pn.add(lbTongTien);

		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTongTien.setBounds(122, 169, 205, 25);
		txtTongTien.setEditable(false);
		pn.add(txtTongTien);
		txtTongTien.setColumns(10);

		btnRefresh = new JButton("Làm Mới");
		btnRefresh.setIcon(new ImageIcon("data/images/refresh.png"));
		btnRefresh.setBounds(10, 206, 317, 35);
		pn.add(btnRefresh);

		btnThem = new JButton("Tạo đơn hàng");
		btnThem.setBounds(10, 243, 317, 35);
		pn.add(btnThem);
		btnThem.setIcon(new ImageIcon("data/images/check.png"));

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách đơn hàng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(370, 65, 900, 575);
		pnMain.add(panel_1);
		panel_1.setLayout(null);

		tableHD = new JTable(modelHD);
		JScrollPane scHD = new JScrollPane(tableHD, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scHD.setBounds(10, 67, 870, 500);
		panel_1.add(scHD);

		JLabel lbTimMaHDDV = new JLabel("Số Phòng:");
		lbTimMaHDDV.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbTimMaHDDV.setBounds(20, 25, 110, 30);
		panel_1.add(lbTimMaHDDV);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(120, 29, 120, 25);
		panel_1.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		btnTimMaHDDV = new JButton("Tìm");
		btnTimMaHDDV.setIcon(new ImageIcon("data/images/search_16.png"));
		btnTimMaHDDV.setBounds(255, 28, 115, 25);
		panel_1.add(btnTimMaHDDV);

		btnXem = new JButton("Xem chi tiết");
		btnXem.setIcon(new ImageIcon("data/images/blueAdd_16.png"));
		btnXem.setBounds(380, 28, 115, 25);
		panel_1.add(btnXem);

		btnPrint = new JButton("Xem tất cả");
		btnPrint.setBounds(505, 28, 115, 25);
		btnPrint.setIcon(new ImageIcon("assets/printer-16.png"));
		panel_1.add(btnPrint);

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(630, 28, 115, 25);
		btnXoa.setIcon(new ImageIcon("data/images/cancel_16.png"));
		panel_1.add(btnXoa);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_QuanLiPhongRNV().setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 20, 115, 25);
		pnMain.add(btnBack);

		btnRefresh.addActionListener(this);

		btnThem.addActionListener(this);
		btnTimMaHDDV.addActionListener(this);
		btnXem.addActionListener(this);
		btnPrint.addActionListener(this);
		cboMaKH.addActionListener(this);
		tableHD.addMouseListener(this);
		pnMain.addMouseListener(this);

		// ========================== EVENT HANDLER ===============================
		
		// chọn 1 hàng trong table -> đổ dữ liệu về form (dùng cho chức năng chỉnh sửa)
		tableHD.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// Xử lý hành động chọn 1 hàng
				int viewRow = tableHD.getSelectedRow();
				if (!e.getValueIsAdjusting() && viewRow != -1) {
					txtTen.setText(tableHD.getValueAt(viewRow, 2).toString());
				}

			}
		});
		
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtTen.setText("");
				if (txtGia != null)
					txtGia.setText("");
				if (txtTenSP != null)
					txtTenSP.setText("");
				cboMaKH.setSelectedIndex(0);
				txtTongTien.setText("");
				txtTenKhachHang.setText("");
				tableHD.getSelectionModel().clearSelection();
			}
		});
	}




	public void tinhTongTien(List<List<String>> listMatHang) {
		double tongTien = 0;
		for (List<String> mh : listMatHang) {
			tongTien += Double.parseDouble(mh.get(4));
		}

		txtTongTien.setText("" + tongTien);
//		this.listMatHang = listMatHang;
	}

	public JPanel getContentPane() {
		return this.pnMain;
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public static void main(String[] args) throws SQLException {
		new GUI_QuanLiDichVu().setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}