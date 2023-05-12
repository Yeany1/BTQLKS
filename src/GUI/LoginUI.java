package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class LoginUI extends JFrame{
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	public JButton btnLogin;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					
					LoginUI window = new LoginUI();
					window.setVisible(true);
				} catch (Exception e) { 
				 	e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginUI() {
		initialize();
	}

	/** 
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 877, 605);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = (JPanel) getContentPane();
		getContentPane().setLayout(null);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 462, 573);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLoginImage = new JLabel("");
		lblLoginImage.setBounds(-10, 50, 500, 480);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/icon/login-img.png"));

		lblLoginImage.setIcon(img);
		panel.add(lblLoginImage);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 118, 211));
		panel_1.setBounds(458, 0, 410, 568);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblHeader = new JLabel("ĐĂNG NHẬP");
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setBounds(10, 51, 390, 48);
		panel_1.add(lblHeader);
		
		JLabel lblNewLabel_2 = new JLabel("Đăng nhập để tiếp tục sử dụng dịch vụ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(10, 97, 390, 30);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tài Khoản");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(40, 155, 109, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("___________________________________________________________");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(40, 200, 290, 13);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("___________________________________________________________");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setBounds(40, 290, 290, 15);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Mật Khẩu");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(40, 245, 109, 25);
		panel_1.add(lblNewLabel_3_1);
		
		btnLogin = new JButton("Đăng Nhập");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setForeground(new Color(25, 118, 211));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(40, 356, 329, 40);
		panel_1.add(btnLogin);
	
		
		JLabel lblViewPassword = new JLabel("");
//		lblViewPassword.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//
//				if (txtPassword.getEchoChar() != '•' && txtPassword.getEchoChar() != '*') {
//					System.out.println("heheh");
//					txtPassword.setEchoChar('*');
//					ImageIcon imgEye = new ImageIcon(this.getClass().getResource("/icons8_eye_20px_1.png"));
//					lblViewPassword.setIcon(imgEye);
//				}
//				else {
//					ImageIcon imgHide = new ImageIcon(this.getClass().getResource("/icons8_invisible_20px_1.png"));
//					System.out.println("hihi");
//					lblViewPassword.setIcon(imgHide);
//					txtPassword.setEchoChar((char)0);
//				}
//			}
//		});
		lblViewPassword.setBounds(350, 290, 20, 20);
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/icon/icons8_eye_20px_1.png"));
		lblViewPassword.setIcon(img2);
		panel_1.add(lblViewPassword);
		
		JLabel lblIconUser = new JLabel("");
		lblIconUser.setBounds(350, 185, 29, 35);
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/icon/icons8_user_20px_1.png"));
		lblIconUser.setIcon(img1);
		panel_1.add(lblIconUser);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsername.setCaretColor(Color.WHITE);
		txtUsername.setBackground(new Color(25, 118, 211));
		txtUsername.setForeground(SystemColor.text);
		txtUsername.setBorder(null);
		txtUsername.setBounds(45, 180, 220, 25); 
//		txtUsername.setBackground(new Color(0,0,0,1));
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		JCheckBox ckboxRemember = new JCheckBox("Hiển thị mật khẩu");
		ckboxRemember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ckboxRemember.setBounds(40, 416, 141, 25);
		ckboxRemember.setBackground(new Color(25, 118, 211));
		ckboxRemember.setForeground(Color.WHITE);
		panel_1.add(ckboxRemember);
		
		ckboxRemember.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtPassword.getText().equals("Mật Khẩu")) {
					txtPassword.setEchoChar((char)0);	
					ckboxRemember.setSelected(false);
					return ;
				}
				
				if(ckboxRemember.isSelected()) {
		        	txtPassword.setEchoChar((char)0);
				}else {
					txtPassword.setEchoChar('*');
				}
			}
			
		});
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(45, 273, 220, 25);
		txtPassword.setBackground(new Color(25, 118, 211));
		txtPassword.setForeground(SystemColor.text);
		txtPassword.setBorder(null);
		txtPassword.setCaretColor(Color.WHITE);
		panel_1.add(txtPassword);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Chưa có tài khoản?");
		lblNewLabel_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(10, 466, 205, 30);
		panel_1.add(lblNewLabel_2_1_1);
		
		JButton btnDangKi = new JButton("Đăng kí ngay");
		btnDangKi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DangKy_GUI().setVisible(true);
				dispose();
			}
		});
		btnDangKi.setForeground(new Color(255, 255, 255));
		btnDangKi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDangKi.setBackground(new Color(25, 118, 211));
		btnDangKi.setBounds(227, 465, 123, 34);
		panel_1.add(btnDangKi);
		
		setLocationRelativeTo(null);
		
	}
	
//	public boolean checkPassword() throws SQLException {
//		TaiKhoanDAO taiKhoanDao = new TaiKhoanDAO();
//		String matKhau = taiKhoanDao.getMatKhau(txtUsername.getText());
//		if(txtPassword.getText().equals(matKhau)) {
//			
//			return true;
//		}
//		
//		renderError("Tài khoản hoặc mật khẩu không chính xác");	
//		return false;
//	}
	
	public void renderError(String message){
        JOptionPane.showMessageDialog(null, message);
    }
	
	
	public void requestFocus() {
		this.txtUsername.requestFocus();
	}

	public JTextField getTxtUserName() {
		return txtUsername;
	}

	public void setTxtUserName(JTextField txtUserName) {
		this.txtUsername = txtUserName;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JPasswordField txtPassword) {
		this.txtPassword = txtPassword;
	}
	public JPanel getContentPane1() {
		return this.contentPane;
	}
	public void clearInput() {
		txtPassword.setText("");
		txtUsername.setText("");
	}
}
