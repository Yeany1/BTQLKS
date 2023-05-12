package GUI_RoleQuanLy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;

import javax.swing.ImageIcon;



public class GUI_ThongKe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelBarchart, panelPieChart;
	private JLabel lblStaffName, lblRole, txtStaff, txtOrder, txtRevenue;
	public JButton btnLogout, btnQLNV, btnQLKH, btnTCHD, btnQLP, btnQLDV;
//	private NhanVien nv;

	/**
	 * Create the frame.
	 * @param nhanVien 
	 * @throws SQLException  
	 */
	public GUI_ThongKe() throws SQLException {
//		nv = nhanVien;
		setTitle("Quản Lí Khách Sạn");
		setBackground(new Color(244, 247, 254));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1400, 690);
		setLocationRelativeTo(null);
		setSize(getMaximumSize());
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
		btnTCHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_DSHoaDonRoleAdmin().setVisible(true);
				dispose();
			}
		});
		
		btnLogout = new JButton("Đăng Xuất");
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogout.setBounds(20, 470, 200, 30);
		
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
		

		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 247, 254));
		panel.setBounds(275, 0, 1011, 663);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panelRevenue = new JPanel();
		panelRevenue.setBackground(new Color(131, 130, 249));
		panelRevenue.setBounds(37, 30, 290, 130);
		panel.add(panelRevenue);
		panelRevenue.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(21, 34, 64, 64);
		ImageIcon img7 = new ImageIcon(this.getClass().getResource("/icon/revenue_64.png"));
		lblNewLabel_3.setIcon(img7);
		panelRevenue.add(lblNewLabel_3);

		LocalDate today = LocalDate.now();
		int month = today.getMonthValue();
		JLabel lblNewLabel_4 = new JLabel("Doanh thu tháng " + month);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(101, 41, 168, 20);
		panelRevenue.add(lblNewLabel_4);

		txtRevenue = new JLabel("");
		txtRevenue.setForeground(Color.WHITE);
		txtRevenue.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtRevenue.setBounds(101, 60, 179, 35);
		panelRevenue.add(txtRevenue);

		JPanel panelStaff = new JPanel();
		panelStaff.setBackground(new Color(175, 108, 249));
		panelStaff.setBounds(359, 30, 290, 130);
		panel.add(panelStaff);
		panelStaff.setLayout(null);

		JLabel lblNewLabel_4_2 = new JLabel("Tổng số phòng");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(101, 36, 168, 20);
		panelStaff.add(lblNewLabel_4_2);

		txtStaff = new JLabel("");
		txtStaff.setForeground(Color.WHITE);
		txtStaff.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtStaff.setBounds(101, 55, 179, 35);
		panelStaff.add(txtStaff);

		JLabel lblNewLabel_3_1 = new JLabel("New label");
		lblNewLabel_3_1.setBounds(21, 29, 64, 64);
		ImageIcon img8 = new ImageIcon(this.getClass().getResource("/icon/staff-64.png"));
		lblNewLabel_3_1.setIcon(img8);
		panelStaff.add(lblNewLabel_3_1);

		JPanel panelCustomer = new JPanel();
		panelCustomer.setBackground(new Color(5, 205, 153));
		panelCustomer.setBounds(684, 30, 290, 130);
		panel.add(panelCustomer);
		panelCustomer.setLayout(null);

		JLabel lblNewLabel_4_3 = new JLabel("Phòng đang sử dụng");
		lblNewLabel_4_3.setForeground(Color.WHITE);
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_3.setBounds(101, 37, 168, 20);
		panelCustomer.add(lblNewLabel_4_3);

		txtOrder = new JLabel("");
		txtOrder.setForeground(Color.WHITE);
		txtOrder.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtOrder.setBounds(101, 56, 179, 35);
		panelCustomer.add(txtOrder);

		JLabel lblNewLabel_3_2 = new JLabel("New label");
		lblNewLabel_3_2.setBounds(21, 30, 64, 64);
		ImageIcon img9 = new ImageIcon(this.getClass().getResource("/icon/order-64.png"));
		lblNewLabel_3_2.setIcon(img9);
		panelCustomer.add(lblNewLabel_3_2);

		panelBarchart = new JPanel();
		panelBarchart.setBounds(37, 195, 450, 444);
		panel.add(panelBarchart);

		panelPieChart = new JPanel();
		panelPieChart.setBounds(513, 195, 450, 444);
		panel.add(panelPieChart);
//		int role = nhanVien.getTaiKhoan().getRole();
//		if (role == 2) {
//			lblRole.setText("Quản Trị Viên");
//		}
//		else if (role == 1) {
//			lblRole.setText("Nhân Viên");
//		}
//		overallAnalysis();
//		
//		revenueAnalysis();
//		productAnalysis();
	}

//	private void overallAnalysis() throws SQLException {
//		lblStaffName.setText(nv.getTenNv());
//		txtStaff.setText(new NhanVienDAO().countStaff() + " Nhân Viên");
//		txtRevenue.setText(new DonHangDAO().tinhDoanhThuTheoThang() + " VND");
//		txtOrder.setText(new DonHangDAO().countDonHangTrongNgay() + " Đơn Hàng");
//		
//	}
//
//	private void revenueAnalysis() throws SQLException {
//		DefaultCategoryDataset revenueByWeek = new DefaultCategoryDataset();
//		List<List<String>> l = new DonHangDAO().revenueLast4Week();
//		for (List<String> i: l) {
//			revenueByWeek.setValue(Double.parseDouble(i.get(0)), "", i.get(1));
//		}
//
//		JFreeChart barChart = ChartFactory.createBarChart("Doanh thu 4 tuần gần đây", "", "", revenueByWeek,
//				PlotOrientation.VERTICAL, false, true, false);
//
//		CategoryPlot cplot = (CategoryPlot) barChart.getPlot();
//		cplot.setBackgroundPaint(new Color(244, 247, 254));// change background color
//
//		BarRenderer r = (BarRenderer) barChart.getCategoryPlot().getRenderer();
//		cplot.setRenderer(new util.CustomRenderer());
//		((BarRenderer) cplot.getRenderer()).setBarPainter(new StandardBarPainter());
//
//		panelBarchart.setLayout(new BoxLayout(panelBarchart, BoxLayout.X_AXIS));
//		panelBarchart.removeAll();
//		ChartPanel cPanel = new ChartPanel(barChart);
//		panelBarchart.add(cPanel);
//		cPanel.setLayout(null);
//		panelBarchart.validate();
//		
//	}
//
//	private void productAnalysis() throws SQLException {
//		DefaultPieDataset productData = new DefaultPieDataset();
//		List<List<String>> top3BanChay = new ChiTietDonHangDAO().getTop3Product();
//		for (List<String> i: top3BanChay) {
//			productData.setValue(i.get(0), Integer.parseInt(i.get(1)));
//		}
//
//
//		JFreeChart pieChart = ChartFactory.createPieChart("Top 3 sản phẩm bán chạy", productData, true, true, false);
//		PiePlot plot = (PiePlot) pieChart.getPlot();
//		plot.setBackgroundPaint(new Color(244, 247, 254));
//		ChartPanel pPanel = new ChartPanel(pieChart);
//		panelPieChart.removeAll();
//		panelPieChart.setLayout(new BoxLayout(panelPieChart, BoxLayout.X_AXIS));
//		panelPieChart.add(pPanel);
//		pPanel.setLayout(null);
//		panelPieChart.validate();
//	}

	public JPanel getContentPane() {
		return this.contentPane;
	}
	public static void main(String[] args) throws SQLException {
		new GUI_ThongKe().setVisible(true);
	}
//	public void refresh() throws SQLException {
//		productAnalysis();
//		revenueAnalysis();
//		overallAnalysis();
//	}
}
