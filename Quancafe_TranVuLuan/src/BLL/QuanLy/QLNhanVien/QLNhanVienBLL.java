package BLL.QuanLy.QLNhanVien;

import java.util.Vector;

import DAL.QuanLy.QLNhanVienDAL.QLNhanVienDAL;
import DTO.NhanVien;

public class QLNhanVienBLL {
	public Vector<NhanVien> hienthiDsNhanVien() {
		QLNhanVienDAL qlnhanvien = new QLNhanVienDAL();
		Vector<NhanVien> dsNhanVien = new Vector<NhanVien>();
		dsNhanVien = qlnhanvien.hienthiDsNhanVien();
		return dsNhanVien;
	}
	
	public Vector<NhanVien> hienthiDsNhanVienTheoTimKiem(String noidung) {
		QLNhanVienDAL qlnhanvien = new QLNhanVienDAL();
		Vector<NhanVien> dsNhanVien = new Vector<NhanVien>();
		dsNhanVien = qlnhanvien.hienthiDsNhanVienTheoTimKiem(noidung);
		return dsNhanVien;
	}
	
	public NhanVien nhanvien(int ma_nhanvien) {
		QLNhanVienDAL qlnhanvien = new QLNhanVienDAL();
		NhanVien nv = new NhanVien();
		nv = qlnhanvien.nhanvien(ma_nhanvien);
		return nv;
	}
	
	public int checkAccount(String username) {
		QLNhanVienDAL qlnhanvien = new QLNhanVienDAL();
		boolean kt = qlnhanvien.checkUsername(username);
		if (kt == false)	// Username hop le
			return 1;
		else 
			return 0;
	}
	
	public boolean addUserAccount(String username, String password) {
		boolean rs = false;
		QLNhanVienDAL qlnhanvien = new QLNhanVienDAL();
		rs = qlnhanvien.addUserAccount(username, password);
		return rs;
	}
	
	public void addNhanVien(NhanVien nv, String ngaySinh, String ngayVaoLam) {
		QLNhanVienDAL qlnhanvien = new QLNhanVienDAL();
		qlnhanvien.addNhanVien(nv, ngaySinh, ngayVaoLam);
	}
	
	public void deleteNhanVien(int ma_nhanvien) {
		QLNhanVienDAL qlnhanvien = new QLNhanVienDAL();
		qlnhanvien.deleteNhanVien(ma_nhanvien);
	}
	
	public void suaNhanVien(String ten_nhanvien, String cmnd, String diachi, String sdt, String ngaysinh, String ngayvaolam) {
		QLNhanVienDAL qlnhanvien = new QLNhanVienDAL();
		
	}
	
	public void suaMatKhau(String username,String password) {
		QLNhanVienDAL qlnhanvien = new QLNhanVienDAL();
		qlnhanvien.suaMatKhau(username, password);
	}
}
