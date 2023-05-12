package GUI_RoleNhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import entity.ChiTietDonHang;
//import entity.DonHang;
//import entity.NhanVien;
//import util.NotificationUtils;

import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PrintBillUI extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	JLabel txtID;
	JLabel txtTotal;
	JLabel txtReturn;
	JLabel txtStaff;
	JLabel txtPay;
	JLabel txtCustomer;
	JPanel panelPrint;
	JTextField txtSoPhong;

	String[] cols = { "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền" };
	private JScrollPane scrollPane = new JScrollPane();
	/**
	 * Launch the application.
	 */
	private JTable table;
	private JTextField inpPay;

	public static void main(String[] args) {
		new PrintBillUI().setVisible(true);;
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PrintBillUI frame = new PrintBillUI(null, null, null);
//					frame.setVisible(true);
//				} catch (Exception e) { 
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param listMatHang
	 * @param hoaDon
	 * @param nhanVien
	 */
	public PrintBillUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 675);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnPrint = new JButton("Xác Nhận");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total = Double.parseDouble(txtTotal.getText());
				if (txtReturn == null || txtReturn.getText() == "" || Double.parseDouble(txtPay.getText()) < total) {
//					NotificationUtils.createNotification("Error", 
//							"Số tiền khách trả không được để trống và phải lớn hơn tổng tiền");
//					return;
				}
				PrinterJob job = PrinterJob.getPrinterJob();
				job.setJobName("Print Data");

				job.setPrintable(new Printable() {
					@Override
					public int print(Graphics pg, PageFormat pf, int pageNum) {
						pf.setOrientation(PageFormat.LANDSCAPE);
						if (pageNum > 0) {
							return Printable.NO_SUCH_PAGE;
						}

						Graphics2D g2 = (Graphics2D) pg;
						g2.translate(pf.getImageableX(), pf.getImageableY());
						g2.scale(0.6, 0.6);

						panelPrint.print(g2);

						return Printable.PAGE_EXISTS;

					}

				});
				boolean ok = job.printDialog();
				if (ok) {
					try {

						job.print();
					} catch (PrinterException ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPrint.setBounds(415, 598, 100, 30);
		contentPane.add(btnPrint);

		panelPrint = new JPanel();
		panelPrint.setBackground(new Color(255, 255, 255));
		panelPrint.setBounds(0, 5, 531, 583);
		contentPane.add(panelPrint);
		panelPrint.setLayout(null);

		JLabel lblC = new JLabel("QUẢN LÝ KHÁCH SẠN");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblC.setBounds(165, 15, 374, 25);
		panelPrint.add(lblC);

		JLabel lblHoa = new JLabel("HOÁ ĐƠN THANH TOÁN");
		lblHoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHoa.setBounds(165, 40, 374, 25);
		panelPrint.add(lblHoa);

		JLabel lblNewLabel = new JLabel("Mã Hoá Đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 95, 100, 25);
		panelPrint.add(lblNewLabel);

		JLabel txtID = new JLabel("10");
		txtID.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtID.setBounds(120, 95, 100, 25);
		panelPrint.add(txtID);

		JLabel lblThuNgn = new JLabel("Thu Ngân");
		lblThuNgn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblThuNgn.setBounds(20, 120, 100, 25);
		panelPrint.add(lblThuNgn);

		JLabel txtStaff = new JLabel("Nguyễn Huy Hoàng");
		txtStaff.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtStaff.setBounds(120, 120, 150, 25);
		panelPrint.add(txtStaff);

		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKhchHng.setBounds(20, 145, 100, 25);
		panelPrint.add(lblKhchHng);

		txtCustomer = new JLabel("Ngô Đình Bảo Yến");
		txtCustomer.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCustomer.setBounds(120, 145, 150, 25);
		panelPrint.add(txtCustomer);

		JLabel lblNgyToHo = new JLabel("Ngày Tạo Hoá Đơn");
		lblNgyToHo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNgyToHo.setBounds(300, 95, 120, 25);
		panelPrint.add(lblNgyToHo);

		JLabel txtCratedDate = new JLabel("01/12/2022");
		txtCratedDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCratedDate.setBounds(419, 95, 100, 25);
		panelPrint.add(txtCratedDate);

		model = new DefaultTableModel(cols, 0) {
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

		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(20, 216, 484, 200);
		panelPrint.add(scrollPane);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tiền Phòng:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(317, 425, 90, 25);
		panelPrint.add(lblNewLabel_1_1);
		
//		txtTotal = new JLabel("");
//		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
//		txtTotal.setBounds(430, 426, 86, 25);
//		panelPrint.add(txtTotal);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng Tiền:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(317, 450, 100, 25);
		panelPrint.add(lblNewLabel_2);

		txtTotal = new JLabel("");
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTotal.setBounds(430, 450, 100, 25);
		panelPrint.add(txtTotal);

		JLabel lblNewLabel_2_1 = new JLabel("Khách Trả:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(317, 500, 125, 25);
		panelPrint.add(lblNewLabel_2_1);

		txtPay = new JLabel("500.000 đ");
		txtPay.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtPay.setBounds(430, 450, 100, 25);
		panelPrint.add(txtPay);

		JLabel lblNewLabel_2_1_1 = new JLabel("Tiền Thừa:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(317, 475, 100, 25);
		panelPrint.add(lblNewLabel_2_1_1);

		txtReturn = new JLabel("");
		txtReturn.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtReturn.setBounds(430, 475, 86, 25);
		panelPrint.add(txtReturn);

		JLabel lblNewLabel_5 = new JLabel("Chi Tiết Dịch Vụ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(20, 185, 150, 25);
		panelPrint.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("**Mọi ý kiến thắc mắc, khiếu nại xin liên hệ 0559023868");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 550, 521, 25);
		panelPrint.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/icon/logo4.png"));
		lblNewLabel_7.setIcon(img);
		lblNewLabel_7.setBounds(15, 30, 200, 65);
		panelPrint.add(lblNewLabel_7);

		JLabel lblNewLabel_4 = new JLabel("Khách Trả");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(20, 601, 81, 25);
		contentPane.add(lblNewLabel_4);

		inpPay = new JTextField();
		inpPay.setBounds(102, 602, 130, 25);
		contentPane.add(inpPay);
		inpPay.setColumns(10);

		JButton btnCustomerPay = new JButton("OK");
		btnCustomerPay.setBounds(235, 602, 85, 25);
		contentPane.add(btnCustomerPay);
		btnCustomerPay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double pay = Double.parseDouble(inpPay.getText());
				double returnAmount = pay - Double.parseDouble(txtTotal.getText());
				txtPay.setText("" + pay);
				txtReturn.setText("" + returnAmount);
			}
		});

//		txtID.setText("" + hoaDon.getMaHD());
//		txtStaff.setText(nhanVien.getTenNv());
//		txtCustomer.setText(hoaDon.getKhachHang().getHoTen());
//		txtCratedDate.setText(hoaDon.getNgayMua().toString());
//		txtTotal.setText("" + hoaDon.getTongTien());
//		txtPay.setText(inpPay.getText());

		JLabel lblNewLabel_1 = new JLabel("12 Nguyễn Văn Bảo,Phường 4,Gò Vấp,TP.HCM ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(257, 64, 254, 25);
		panelPrint.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Rất hân hạnh được phục vụ quý khách !");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_6_1.setBounds(0, 530, 521, 25);
		panelPrint.add(lblNewLabel_6_1);
		drawBill();
		model.setRowCount(0);
//		for (ChiTietDonHang cthd : listMatHang) {
//			Object[] temp = { cthd.getTenSanPham(), cthd.getSoLuong(), cthd.getDonGia(),
//					cthd.getDonGia() * cthd.getSoLuong() };
//			model.addRow(temp);
//		}
	}
	public void drawBill() {
	}
}
