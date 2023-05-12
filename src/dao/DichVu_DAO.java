package dao;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.Database;
import entity.DichVu;
import entity.KhachHang;

public class DichVu_DAO {
	ArrayList<DichVu> dsdv;
	DichVu dv;

	public DichVu_DAO() {
		dsdv = new ArrayList<DichVu>();
	}
	
	public List<entity.DichVu> doTuBang() {

		try {
			Connection con = Database.getInstance().getcoConnection();
			String sql = "Select * from DichVu";
			Statement statement = con.createStatement(); // Thực thi câu lệnh SQL trả về ResulSet.
			ResultSet rs = statement.executeQuery(sql);
			// Duyệt kết quả trả về
			while (rs.next()) {
				int ID = rs.getInt(1);
				String ma = "DV"+ ID;
				String tenDV = rs.getNString(2);
				BigDecimal giaDV = rs.getBigDecimal(3);
				DichVu dv = new DichVu(ma, tenDV, giaDV);
				dsdv.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsdv;
	}

}
