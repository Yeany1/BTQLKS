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
import entity.NhanVien;


public class NhanVien_DAO {
	ArrayList<NhanVien> dsnv;
	NhanVien nv;

	public NhanVien_DAO() {
		dsnv = new ArrayList<NhanVien>();
	}

	public List<entity.NhanVien> doTuBang() {

		try {
			Connection con = Database.getInstance().getcoConnection();
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement(); // Thực thi câu lệnh SQL trả về ResulSet.
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp
				int ID = rs.getInt(1);
				String ma = "NV"+ID;
				String ten = rs.getNString(2);
				String cmnd = rs.getNString(3);
				int tuoi = rs.getInt(4);
				String phai = rs.getNString(5);
				Date ns = rs.getDate(6);
				SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy"); // Chuyển định dang yyyy-MM-dd sang
																					// dd-MM-yyyy
				String ngaySinh = dataFormat.format(ns); // Chuyển dữ liệu date sang String theo định dd-MM-yyyy
				String sdt = rs.getNString(7);
				String email = rs.getNString(8);
				String taiKhoan = rs.getNString(9);
				String password = rs.getNString(10);
				NhanVien nv = new NhanVien(ma, ten, cmnd, tuoi, phai, ngaySinh, sdt, email, taiKhoan, password);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}

	public ArrayList<NhanVien> getNhanVienTheoMaNhanVien(int mnv) {

		Connection con = Database.getInstance().getcoConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from NhanVien where ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, mnv);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt(1);
				String ma = "NV"+ID;
				String ten = rs.getNString(2);
				String cmnd = rs.getNString(3);
				int tuoi = rs.getInt(4);
				String phai = rs.getNString(5);
				Date ns = rs.getDate(6);
				SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy"); // Chuyển định dang yyyy-MM-dd sang
																					// dd-MM-yyyy
				String ngaySinh = dataFormat.format(ns); // Chuyển dữ liệu date sang String theo định dd-MM-yyyy
				String sdt = rs.getNString(7);
				String email = rs.getNString(8);
				String taiKhoan = rs.getNString(9);
				String password = rs.getNString(10);
				NhanVien nv = new NhanVien(ma, ten, cmnd, tuoi, phai, ngaySinh, sdt, email, taiKhoan, password);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}

	public boolean create(NhanVien nv) {
		Connection con = Database.getInstance().getcoConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			String sql = "Select MAX(ID) from NhanVien"; 
			Statement statement = con.createStatement(); // Thực thi câu lệnh SQL trả về ResulSet.
			ResultSet rs = statement.executeQuery(sql);
			int maxID = 0; 
			if (rs.next()) {
				maxID = rs.getInt(1); // Lấy ra mã khách hàng lớn nhất
			}
			int nextID = maxID + 1;
			stmt = con.prepareStatement("insert into NhanVien values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setInt(1, nextID);
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getCmnd());
			stmt.setInt(4, nv.getTuoi());
			stmt.setString(5, nv.getPhai());
			SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date ns = null;
			try {
				ns = dataFormat.parse(nv.getNgaySinh()); // Format chuỗi ngày sinh
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			java.sql.Date ngaySinh = new java.sql.Date(ns.getTime()); // Chuyển String sang dự liệu Date để insert
																		// vào SQL
			stmt.setDate(6, ngaySinh);
			stmt.setString(7, nv.getSdt());
			stmt.setString(8, nv.getEmail());
			stmt.setString(9, nv.getTaiKhoan());
			stmt.setString(10, nv.getPassword());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean update(NhanVien nv) {
		Connection con = Database.getInstance().getcoConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien set TenNhanVien = ?, CMND = ?,Tuoi = ?, GioiTinh = ?, "
					+ "NgaySinh = ?, SoDienThoai = ?, Email = ?, TaiKhoan = ?, MatKhau = ? where ID = ?");
			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getCmnd());
			stmt.setInt(3, nv.getTuoi());
			stmt.setString(4, nv.getPhai());
			SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date ns = null;
			try {
				ns = dataFormat.parse(nv.getNgaySinh()); // Format chuỗi ngày sinh
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date ngaySinh = new java.sql.Date(ns.getTime()); // Chuyển String sang dự liệu Date để insert vào
																		// SQL
			stmt.setDate(5, ngaySinh);
			stmt.setString(6, nv.getSdt());
			stmt.setString(7, nv.getEmail());
			stmt.setString(8, nv.getTaiKhoan());
			stmt.setString(9, nv.getPassword());
			int maNV = Integer.parseInt(nv.getMaNV().substring(2)); // Loại bỏ 2 kí tự NV chỉ lấy số ID 
			stmt.setInt(10, maNV);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public boolean delete(int mnv) {
		Connection con = Database.getInstance().getcoConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhanVien where ID = ?");
			stmt.setInt(1, mnv);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}
}
