package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

import connectDB.Database;
import entity.KhachHang;

public class KhachHang_DAO {
	ArrayList<KhachHang> dskh;
	KhachHang kh;

	public KhachHang_DAO() {
		dskh = new ArrayList<KhachHang>();
	}

	public List<entity.KhachHang> doTuBang() {

		try {
			Connection con = Database.getInstance().getcoConnection();
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement(); // Thực thi câu lệnh SQL trả về ResulSet.
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				int id = rs.getInt(1);
				String ma = "KH"+ id;
				String ten = rs.getNString(2);
				String cmnd = rs.getNString(3);
				int tuoi = rs.getInt(4);
				String phai = rs.getNString(5);
				Date ns = rs.getDate(6);
				SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy"); // Chuyển định dang yyyy-MM-dd sang
																					// dd-MM-yyyy
				String ngaySinh = dataFormat.format(ns); // Chuyển dữ liệu date sang String theo định dd-MM-yyyy
				String diaChi = rs.getNString(7);
				String email = rs.getNString(8);
				String sdt = rs.getNString(9);
				KhachHang s = new KhachHang(ma, tuoi, ten, cmnd, phai, ngaySinh, email, diaChi, sdt);
				dskh.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}

	public ArrayList<KhachHang> getKhachHangTheoMaKhachHang(int mkh) {

		Connection con = Database.getInstance().getcoConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from KhachHang where ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, mkh);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String ma = "KH"+ id;
				String ten = rs.getNString(2);
				String cmnd = rs.getNString(3);
				int tuoi = rs.getInt(4);
				String phai = rs.getNString(5);
				Date ns = rs.getDate(6);
				SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy"); // Chuyển định dang yyyy-MM-dd sang
																					// dd-MM-yyyy
				String ngaySinh = dataFormat.format(ns); // Chuyển dữ liệu date sang String theo định dạng dd-MM-yyyy
				String diaChi = rs.getNString(7);
				String email = rs.getNString(8);
				String sdt = rs.getNString(9);
				KhachHang s = new KhachHang(ma, tuoi, ten, cmnd, phai, ngaySinh, email, diaChi, sdt);
				dskh.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}

	public boolean create(KhachHang kh) {
		Connection con = Database.getInstance().getcoConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			String sql = "Select MAX(ID) from KhachHang"; 
			Statement statement = con.createStatement(); // Thực thi câu lệnh SQL trả về ResulSet.
			ResultSet rs = statement.executeQuery(sql);
			int maxID = 0; 
			if (rs.next()) {
				maxID = rs.getInt(1); // Lấy ra mã khách hàng lớn nhất
			}
			int nextID = maxID + 1;
			stmt = con.prepareStatement("insert into KhachHang values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, nextID); 
			stmt.setString(2, kh.getTenKH());
			stmt.setString(3, kh.getCmnd());
			stmt.setInt(4, kh.getTuoi());
			stmt.setString(5, kh.getPhai());
			SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date ns = null;
			try {
				ns = dataFormat.parse(kh.getNgaySinh()); // Format chuỗi ngày sinh
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date ngaySinh = new java.sql.Date(ns.getTime()); // Chuyển String sang dự liệu Date để insert
																			// vào SQL
			stmt.setDate(6, ngaySinh);
			stmt.setString(7, kh.getDiaChi());
			stmt.setString(8, kh.getEmail());
			stmt.setString(9, kh.getSdt());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean update(KhachHang kh) {
		Connection con = Database.getInstance().getcoConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update KhachHang set TenKhachHang = ?, CMND = ?, Tuoi = ?, "
					+ "GioiTinh = ?, NgaySinh = ?, DiaChi = ?, Email = ?, SoDienThoai = ? where ID = ?");
			stmt.setString(1, kh.getTenKH());
			stmt.setString(2, kh.getCmnd());
			stmt.setInt(3, kh.getTuoi());
			stmt.setString(4, kh.getPhai());
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date ns = null;
			try {
				ns = dateFormat.parse(kh.getNgaySinh()); // Format chuỗi ngày sinh
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date ngaySinh = new java.sql.Date(ns.getTime()); // Chuyển String sang dự liệu Date để insert vào
																		// SQL
			stmt.setDate(5, ngaySinh);
			stmt.setString(6, kh.getDiaChi());
			stmt.setString(7, kh.getEmail());
			stmt.setString(8, kh.getSdt());
			int maKH = Integer.parseInt(kh.getMaKH().substring(2)); // Loại bỏ 2 kí tự KH chỉ lấy số ID 
			stmt.setInt(9, maKH);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(int mkh) {
		Connection con = Database.getInstance().getcoConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from KhachHang where ID = ?");
			stmt.setInt(1, mkh);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
