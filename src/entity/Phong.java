package entity;

public class Phong {
	private int id;
	private String loaiPhong;
	private double giaPhong;
	private String trangThaiPhong;
	public Phong(int id, String loaiPhong, double giaPhong, String trangThaiPhong) {
		super();
		this.id = id;
		this.loaiPhong = loaiPhong;
		this.giaPhong = giaPhong;
		this.trangThaiPhong = trangThaiPhong;
	}
	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public double getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}
	public String gettrangThaiPhong() {
		return trangThaiPhong;
	}
	public void settrangThaiPhong(String trangThaiPhong) {
		this.trangThaiPhong = trangThaiPhong;
	}
	@Override
	public String toString() {
		return "Phong [id=" + id + ", loaiPhong=" + loaiPhong + ", giaPhong=" + giaPhong + ", trangThaiPhong=" + trangThaiPhong
				+ "]";
	}
	
	
	
}