-- T?o co s? d? li?u
CREATE DATABASE QuanLyKhachSan;
go
USE QuanLyKhachSan;

-- B?ng Kh�ch h�ng
CREATE TABLE KhachHang (
    ID INT PRIMARY KEY,
    TenKhachHang NVARCHAR(100),
	CMND NVARCHAR(100),
	Tuoi INT, 
	GioiTinh NVARCHAR(100),
	NgaySinh Date, 
    DiaChi NVARCHAR(100),
    Email NVARCHAR(100),
    SoDienThoai NVARCHAR(20)
);

-- Th�m d? li?u v�o b?ng Kh�ch h�ng
INSERT INTO KhachHang (ID, TenKhachHang, DiaChi, Email, SoDienThoai)
VALUES
    (1, 'Nguy?n Van A', '123 �u?ng ABC', 'nguyenvana@example.com', '0123456789'),
    (2, 'Tr?n Th? B', '456 �u?ng XYZ', 'tranthib@example.com', '0987654321'),
    (3, 'L� Van C', '789 �u?ng DEF', 'levanc@example.com', '0369852147');

-- B?ng Qu?n l�
CREATE TABLE QuanLy (
    ID INT PRIMARY KEY,
    TenQuanLy NVARCHAR(100),
	CMND NVARCHAR(100),
	Tuoi INT, 
	GioiTinh NVARCHAR(100),
	NgaySinh Date, 
    SoDienThoai NVARCHAR(20),
    Email NVARCHAR(100),
    TaiKhoan NVARCHAR(50),
    MatKhau NVARCHAR(50)
);

-- Th�m d? li?u v�o b?ng Qu?n l�
INSERT INTO QuanLy (ID, TenQuanLy, SoDienThoai, Email, TaiKhoan, MatKhau)
VALUES
    (1, 'Nguy?n Th? Qu?n L�', '0987654321', 'quanly@example.com', 'quanly1', 'password1'),
    (2, 'Tr?n Van Qu?n L�', '0123456789', 'quanly2@example.com', 'quanly2', 'password2'),
    (3, 'L� Th? Qu?n L�', '0369852147', 'quanly3@example.com', 'quanly3', 'password3');

-- B?ng Nh�n vi�n
CREATE TABLE NhanVien (
    ID INT PRIMARY KEY,
    TenNhanVien NVARCHAR(100),
	CMND NVARCHAR(100),
	Tuoi INT, 
	GioiTinh NVARCHAR(100),
	NgaySinh Date, 
    SoDienThoai NVARCHAR(20),
    Email NVARCHAR(100),
    TaiKhoan NVARCHAR(50),
    MatKhau NVARCHAR(50)
);

-- Th�m d? li?u v�o b?ng Nh�n vi�n
INSERT INTO NhanVien (ID, TenNhanVien, SoDienThoai, Email, TaiKhoan, MatKhau)
VALUES
    (1, 'Nguy?n Van Nh�n Vi�n', '0987654321', 'nhanvien1@example.com', 'nhanvien1', 'password1'),
    (2, 'Tr?n Th? Nh�n Vi�n', '0123456789', 'nhanvien2@example.com', 'nhanvien2', 'password2'),
    (3, 'L� Van Nh�n Vi�n', '0369852147', 'nhanvien3@example.com', 'nhanvien3', 'password3');

-- B?ng Ho� don
CREATE TABLE HoaDon (
    ID INT PRIMARY KEY,
    MaHoaDon NVARCHAR(20),
    NgayThanhToan DATE,
    TongTien DECIMAL(18, 2),
    KhachHangID INT,
    NhanVienID INT,
    FOREIGN KEY (KhachHangID) REFERENCES KhachHang(ID),
    FOREIGN KEY (NhanVienID) REFERENCES NhanVien(ID)
);

-- Th�m d? li?u v�o b?ng Ho� don
INSERT INTO HoaDon (ID, MaHoaDon, NgayThanhToan, TongTien, KhachHangID, NhanVienID)
VALUES
    (1, 'HD001', '2023-05-01', 1500000, 1, 1),
    (2, 'HD002', '2023-05-02', 2000000, 2, 2),
    (3, 'HD003', '2023-05-03', 1800000, 3, 3);


-- B?ng D?ch v?
CREATE TABLE DichVu (
    ID INT PRIMARY KEY,
    TenDichVu NVARCHAR(100),
    DonGia DECIMAL(18, 2)
);

-- Th�m d? li?u v�o b?ng D?ch v?
INSERT INTO DichVu (ID, TenDichVu, DonGia)
VALUES
    (1, 'D?ch v? 1', 500000),
    (2, 'D?ch v? 2', 300000),
    (3, 'D?ch v? 3', 800000);

-- B?ng Chi ti?t ho� don
CREATE TABLE ChiTietHoaDon (
    ID INT PRIMARY KEY,
    HoaDonID INT,
    DichVuID INT,
    SoLuong INT,
    DonGia DECIMAL(18, 2),
    FOREIGN KEY (HoaDonID) REFERENCES HoaDon(ID),
    FOREIGN KEY (DichVuID) REFERENCES DichVu(ID)
);

-- Th�m d? li?u v�o b?ng Chi ti?t ho� don
INSERT INTO ChiTietHoaDon (ID, HoaDonID, DichVuID, SoLuong, DonGia)
VALUES
    (1, 1, 1, 2, 500000),
    (2, 1, 2, 3, 300000),
    (3, 2, 3, 1, 800000);

-- B?ng Ph�ng
CREATE TABLE Phong (
    ID INT PRIMARY KEY,
    SoPhong NVARCHAR(10),
    LoaiPhong NVARCHAR(50),
    GiaPhong DECIMAL(18, 2), 
	TrangThai NVARCHAR(30),
);

-- Th�m d? li?u v�o b?ng Ph�ng
INSERT INTO Phong (ID, SoPhong, LoaiPhong, GiaPhong)
VALUES
    (1, '101', 'Ph�ng don', 1000000),
    (2, '102', 'Ph�ng don', 1000000),
    (3, '201', 'Ph�ng d�i', 1500000);

-- B?ng Phi?u d?t ph�ng
CREATE TABLE PhieuDatPhong (
    ID INT PRIMARY KEY,
    MaPhieuDat NVARCHAR(20),
    NgayDat DATE,
    NgayNhan DATE,
    KhachHangID INT,
    NhanVienID INT,
    PhongID INT,
    FOREIGN KEY (KhachHangID) REFERENCES KhachHang(ID),
    FOREIGN KEY (NhanVienID) REFERENCES NhanVien(ID),
    FOREIGN KEY (PhongID) REFERENCES Phong(ID)
);

-- Th�m d? li?u v�o b?ng Phi?u d?t ph�ng
INSERT INTO PhieuDatPhong (ID, MaPhieuDat, NgayDat, NgayNhan, KhachHangID, NhanVienID, PhongID)
VALUES
    (1, 'PD001', '2023-05-01', '2023-05-02', 1, 1, 1);



-- B?ng T�i kho?n
CREATE TABLE TaiKhoan (
    ID INT PRIMARY KEY,
    TenDangNhap NVARCHAR(50),
    MatKhau NVARCHAR(50),
    NhanVienID INT,
    QuanLyID INT,
    FOREIGN KEY (NhanVienID) REFERENCES NhanVien(ID),
    FOREIGN KEY (QuanLyID) REFERENCES QuanLy(ID)
);

-- Th�m d? li?u v�o b?ng T�i kho?n
INSERT INTO TaiKhoan (ID, TenDangNhap, MatKhau, NhanVienID, QuanLyID)
VALUES
    (1, 'nhanvien1', 'password1', 1, NULL),
    (2, 'nhanvien2', 'password2', 2, NULL),
    (3, 'quanly1', 'password1', NULL, 1);


