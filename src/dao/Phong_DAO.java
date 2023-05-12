package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.Database;
import entity.Phong;

public class Phong_DAO {
	ArrayList<Phong> dsp;
	Phong p;

	public Phong_DAO() {
		dsp = new ArrayList<Phong>();
	}

	public ArrayList<Phong> getAllPhong() {
		ArrayList<Phong> ds = new ArrayList<Phong>(); 
		
		try {
			Connection con = Database.getInstance().getcoConnection();
			PreparedStatement stm = con.prepareStatement("select * from Phong");
			
			ResultSet rs = stm.executeQuery(); 
			while(rs.next()) {
				Phong p = new Phong(); 
				p.setId(rs.getInt("ID"));
				p.setLoaiPhong(rs.getNString("LoaiPhong"));
				p.setGiaPhong(rs.getDouble("GiaPhong"));
				p.settrangThaiPhong(rs.getNString("TrangThaiPhong"));
				
				ds.add(p); 
			}
			return ds; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}

	public ArrayList<Phong> getPhongTheoMaPhong(int mp) {

		Connection con = Database.getInstance().getcoConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT LoaiPhong, TrangThaiPhong, GiaPhong FROM Phong where ID = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, mp);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String loaiPhong = rs.getString(1);
				String trangThaiPhong = rs.getString(3);
				Double gia = rs.getDouble(2);
				Phong p = new Phong(0, loaiPhong, gia, trangThaiPhong);
				dsp.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsp;
	}
	public void themPhong(Phong p) {
		try {
//			String sql = "INSERT INTO Room (roomID, roomName, describe,roomTypeID, roomStatusTypeID) VALUES (?, ?, ?, ?, ?)";
			Connection  con = Database.getInstance().getcoConnection();
			PreparedStatement stm = con.prepareStatement("INSERT INTO Phong (ID, LoaiPhong, GiaPhong, TrangThai) "
					+ "VALUES (?, ?, ?, ?)");
			stm.setInt(1, p.getId());
			stm.setNString(2, p.getLoaiPhong());
			stm.setDouble(3, p.getGiaPhong());
			stm.setNString(4, p.gettrangThaiPhong());
			
			stm.executeUpdate(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Phong getPhongByID(int ID) {
		for( Phong p : getAllPhong() ) {
			if(ID == p.getId())
				return p; 
		}
		return null; 
	}
	
	
	public void xoaPhongTheoID(int ID) {
		try {
//			String sql = "INSERT INTO Room (roomID, roomName, describe,roomTypeID, roomStatusTypeID) VALUES (?, ?, ?, ?, ?)";
			Connection  con = Database.getInstance().getcoConnection();
			PreparedStatement stm = con.prepareStatement("DELETE FROM Phong WHERE ID = ?");
			stm.setInt(1, ID);		
			stm.executeUpdate(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void suaPhongTheoID(int ID, Phong p) {
		try {			
			System.out.println("Sửa Phòng: " + p.getId());
			Connection  con = Database.getInstance().getcoConnection();
			PreparedStatement stm = con.prepareStatement("UPDATE Phong set LoaiPhong = ?, GiaPhong = ?, TrangThai = ? where ID = ?");
			stm.setInt(4, ID);
			stm.setNString(1, p.getLoaiPhong());
			stm.setDouble(2, p.getGiaPhong()); 
			stm.setNString(3, p.gettrangThaiPhong());
			
			int c = stm.executeUpdate(); 
			if (c > 0) {
				
                System.out.println("Cập nhật thông tin phòng thành công.");
            } else {
                System.out.println("Không tìm thấy phòng để cập nhật.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
