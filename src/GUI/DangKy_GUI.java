package GUI;
import java.awt.Graphics;  
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

//import DAO.NhanVienDAO;
//import DAO.TaiKhoanDAO;
//import entity.KhachHang;
//import entity.NhanVien;
//import entity.TaiKhoan;
//import util.NotificationUtils;
//import util.Placeholder;

public class DangKy_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	public JButton btnDangKy;
	public JButton btnDangNhap;
	private JPasswordField txtRePassword;
	private JTextField txtTenKH;
	private JCheckBox chcHienThiMatKhau;
	private JTextField txtSoDienThoai;
	private JTextField txtDiaChi; 
	private JTextField txtEmail;


	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DangKy_GUI frame = new DangKy_GUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}); 
		new DangKy_GUI().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public DangKy_GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setBounds(0, 0, 1000, 700);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 118, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(260, 40, 480, 550);
		panel.setBackground(new Color(255, 255, 255, 30));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblDangKy = new JLabel("Đăng Ký");
		lblDangKy.setBounds(159, 11, 159, 49);
		panel.add(lblDangKy);
		lblDangKy.setForeground(new Color(0, 206, 209));
		lblDangKy.setBackground(new Color(255, 255, 255));
		lblDangKy.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		txtTenKH = new JTextField("Họ và Tên");
		txtTenKH.setColumns(10);
		txtTenKH.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtTenKH.setBounds(41, 73, 398, 41);
		panel.add(txtTenKH);
//		new Placeholder().placeholder(txtTenKH, "Họ và Tên");
		
		txtSoDienThoai = new JTextField("Số Điện Thoại");
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtSoDienThoai.setBounds(41, 125, 398, 41);
		panel.add(txtSoDienThoai);
//		new Placeholder().placeholder(txtSoDienThoai, "Số Điện Thoại");
		
		txtDiaChi = new JTextField("Địa Chỉ");
		txtDiaChi.setColumns(10);
		txtDiaChi.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtDiaChi.setBounds(41, 177, 398, 41);
		panel.add(txtDiaChi);
//		new Placeholder().placeholder(txtDiaChi, "Địa Chỉ");
		
		txtUserName = new JTextField("Tài Khoản");
		txtUserName.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtUserName.setBounds(41, 229, 398, 41);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
//		new Placeholder().placeholder(txtUserName, "Tài Khoản");
		
		txtPassword = new JPasswordField("Mật Khẩu");
		txtPassword.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtPassword.setEchoChar((char)0);
		txtPassword.setBounds(41, 281, 398, 41);
		panel.add(txtPassword);
		txtPassword.setColumns(10);
//		new Placeholder().placeholder(txtPassword, "Mật Khẩu");
		
		txtRePassword = new JPasswordField("Nhập Lại Mật Khẩu");
		txtRePassword.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtRePassword.setEchoChar((char)0);
		txtRePassword.setBounds(41, 333, 398, 41);
		panel.add(txtRePassword);
		txtRePassword.setColumns(10);
//		new Placeholder().placeholder(txtRePassword, "Nhập Lại Mật Khẩu");
		
		 
		txtEmail = new JTextField("Email");
		txtEmail.setBorder(new LineBorder(new Color(171, 173, 179)));
		txtEmail.setBounds(41, 385, 398, 41);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
//		new Placeholder().placeholder(txtEmail, "Nhập Email");
		
		btnDangKy = new JButton("Đăng Ký");
		btnDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangKy.setBackground(new Color(0, 206, 209));
		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangKy.setBounds(105, 463, 130, 41);
		panel.add(btnDangKy);
		
		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginUI().setVisible(true);
				dispose();
			}
		});
		btnDangNhap.setBackground(Color.WHITE);
		btnDangNhap.setBounds(261, 463, 130, 41);
		panel.add(btnDangNhap);
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}
	
	public void hienThiPassword() {
		if(chcHienThiMatKhau.isSelected()) {
        	txtPassword.setEchoChar((char)0);
		}else {
			txtPassword.setEchoChar('*');
		}
	}
	
	public void hienThiRePassword() {
		if(chcHienThiMatKhau.isSelected()) {
			txtRePassword.setEchoChar((char)0);
		}else {
			txtRePassword.setEchoChar('*');
		}
	}
//	public boolean dangKy() throws SQLException {
//		
//		if(txtTenKH.getText().trim().equals("") || txtTenKH.getText().trim().equals("Họ và Tên")){
//            renderError(txtTenKH, "Tên khách hàng không được để trống");
//            return false;
//        }
//		
//		if(!txtTenKH.getText().matches("^[^0-9]{2,25}$")){
//            renderError(txtTenKH, "Tên khách hàng không được chứa chữ số, ít nhất là 2 ký tự");
//            return false;
//        }
//		
//		if(!txtSoDienThoai.getText().matches("^0[0-9]{9}$")){
//            renderError(txtSoDienThoai, "Số điện thoại không hợp lệ");
//            return false;
//        }
//		
//		if(txtUserName.getText().trim().length() < 8 || txtUserName.getText().trim().equals("Tài Khoản")){
//            renderError(txtUserName, "Tài khoản phải ít nhất 8 ký tự");
//            return false;
//        }
//		
//		if(!txtUserName.getText().matches("^[a-zA-Z0-9]{8,}$")){
//            renderError(txtUserName, "Tài khoản chỉ được chứa ký tự hoa thường a-z và chữ số");
//            return false;
//        }
//		
//		if(txtPassword.getText().trim().length() < 8 || txtPassword.getText().trim().equals("Mật Khẩu")){
//            renderError(txtPassword, "Mật khẩu phải ít nhất 8 ký tự");
//            return false;
//        }
//		
//		if(!txtPassword.getText().matches("^[a-zA-Z0-9]{8,}$")){
//            renderError(txtPassword, "Mật khẩu chỉ được chứa ký tự hoa thường a-z và chữ số");
//            return false;
//        }
//
//		if(!txtPassword.getText().trim().equals(txtRePassword.getText().trim())){
//            renderError(txtRePassword, "Mật khẩu không khớp");
//            return false;
//        }
//		
//		if(txtEmail.getText().trim().equals("") || txtEmail.getText().trim().equals("Email")){
//            renderError(txtEmail, "Email không được để trống");
//            return false;
//        }
//		
//		int row = new NhanVienDAO().addNhanVien(
//				new NhanVien(-1, txtTenKH.getText(), txtSoDienThoai.getText(), 
//						txtDiaChi.getText(), new TaiKhoan(txtUserName.getText(), txtPassword.getText(), 1), txtEmail.getText()));
//		
//		if (row > 0) {
//			NotificationUtils.createNotification("Success", "Đăng Ký Thành Công");
//			return true;
//		}
//			
//		
//		return false;
//	}
	
	public void renderError(JTextField a, String message){
        a.requestFocus();
        a.selectAll();
        JOptionPane.showMessageDialog(contentPane, message);
    }
	
	public JPanel getContentPane() {
		return this.contentPane;
	}
	
	public void requestFocus() {
		this.txtUserName.requestFocus();
	}
	
	public void clearInput() {
		txtPassword.setText("");
		txtDiaChi.setText("");
		txtRePassword.setText("");
		txtTenKH.setText("");
		txtSoDienThoai.setText("");
		
	}
}
