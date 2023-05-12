package test;

import connectDB.Database;
import dao.NhanVien_DAO;
import dao.Phong_DAO;
import entity.NhanVien;
import entity.Phong;
import connectDB.Database; 
public class test {
	
	
	public static void main(String[] args) {
		new Database().connect(); 
		for(Phong p : new Phong_DAO().getAllPhong() ) 
			System.out.println(p);
	}
}
