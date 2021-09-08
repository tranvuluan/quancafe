package DAL.QuanLy.QLNhanVienDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Vector;

import DAL.MyJDBCUtil;
import DTO.NhanVien;

public class QLNhanVienDAL {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet result = null;
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public Vector<NhanVien> hienthiDsNhanVien() {
		Vector<NhanVien> dsNhanVien = new Vector<NhanVien>();
		String sql = "SELECT * FROM tbl_nhanvien";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			result = pstm.executeQuery();
			while (result.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNV(result.getInt("ma_nhanvien"));
				nv.setTenNV(result.getString("ten_nhanvien"));
				nv.setCMND(result.getString("cmnd"));
				nv.setSdtNV(result.getString("sdt"));
				nv.setNgaysinh(result.getDate("ngaysinh"));
				nv.setNgayVaoLam(result.getDate("ngayvaolam"));
				nv.setUsername(result.getString("username"));
				nv.setDiachi(result.getString("diachi"));
				if (result.getString("username") == null) {
					nv.setChucvu("Nhân viên phục vụ");
				} else
					nv.setChucvu("Nhân viên thu ngân");
				dsNhanVien.add(nv);
			}

			result.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}

	public Vector<NhanVien> hienthiDsNhanVienTheoTimKiem(String noidung) {
		Vector<NhanVien> dsNhanVien = new Vector<NhanVien>();
		String sql = "";

		sql = "SELECT * FROM tbl_nhanvien WHERE ma_nhanvien LIKE ? OR ten_nhanvien LIKE ? "
				+ "OR cmnd LIKE ? OR diachi LIKE ? OR sdt LIKE ? OR chucvu LIKE ?";

		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + String.valueOf(noidung) + "%");
			pstm.setString(2, "%" + String.valueOf(noidung) + "%");
			pstm.setString(3, "%" + String.valueOf(noidung) + "%");
			pstm.setString(4, "%" + String.valueOf(noidung) + "%");
			pstm.setString(5, "%" + String.valueOf(noidung) + "%");
			pstm.setString(6, "%" + String.valueOf(noidung) + "%");
			result = pstm.executeQuery();
			while (result.next()) {
				NhanVien nv = new NhanVien();
				nv.setMaNV(result.getInt("ma_nhanvien"));
				nv.setTenNV(result.getString("ten_nhanvien"));
				nv.setCMND(result.getString("cmnd"));
				nv.setSdtNV(result.getString("sdt"));
				nv.setNgaysinh(result.getDate("ngaysinh"));
				nv.setNgayVaoLam(result.getDate("ngayvaolam"));
				nv.setUsername(result.getString("username"));
				nv.setDiachi(result.getString("diachi"));
				if (result.getString("username") == null) {
					nv.setChucvu("Nhân viên phục vụ");
				} else
					nv.setChucvu("Nhân viên thu ngân");
				dsNhanVien.add(nv);
			}

			result.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}

	public NhanVien nhanvien(int ma_nhanvien) {
		NhanVien nv = new NhanVien();
		String sql = "SELECT * FROM tbl_nhanvien WHERE ma_nhanvien = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_nhanvien);
			result = pstm.executeQuery();
			while (result.next()) {
				nv.setMaNV(result.getInt("ma_nhanvien"));
				nv.setTenNV(result.getString("ten_nhanvien"));
				nv.setCMND(result.getString("cmnd"));
				nv.setSdtNV(result.getString("sdt"));
				nv.setNgaysinh(result.getDate("ngaysinh"));
				nv.setNgayVaoLam(result.getDate("ngayvaolam"));
				nv.setUsername(result.getString("username"));
				nv.setDiachi(result.getString("diachi"));
				if (result.getString("username") == null) {
					nv.setChucvu("Nhân viên phục vụ");
				} else
					nv.setChucvu("Nhân viên thu ngân");
			}

			result.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}

	public boolean checkUsername(String username) {
		boolean kt = false;
		String sql = "SELECT * FROM tbl_nhanvien WHERE username = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			result = pstm.executeQuery();
			kt = result.next();

			result.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kt;
	}

	public boolean addUserAccount(String username, String password) {
		String sql = "INSERT INTO tbl_account(username,pass) VALUE(?,?)";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			pstm.executeUpdate();

			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void addNhanVien(NhanVien nv, String ngaySinh, String ngayVaoLam) {
		String sql = "INSERT INTO tbl_nhanvien(ten_nhanvien, username, cmnd, sdt, ngaysinh, diachi, ngayvaolam, chucvu) VALUES(?,?,?,?,?,?,?,?)";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nv.getTenNV());
			pstm.setString(2, nv.getUsername());
			pstm.setString(3, nv.getCMND());
			pstm.setString(4, nv.getSdtNV());
			pstm.setString(5, ngaySinh);
			pstm.setString(6, nv.getDiachi());
			pstm.setString(7, ngayVaoLam);
			pstm.setString(8, nv.getChucvu());

			pstm.executeUpdate();

			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteNhanVien(int ma_nhanvien) {
		String sql = "DELETE FROM tbl_nhanvien WHERE ma_nhanvien = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_nhanvien);
			pstm.executeUpdate();

			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void suaMatKhau(String username, String password) {
		String sql = "UPDATE tbl_account SET pass = ? WHERE username = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, password);
			pstm.setString(2, username);
			pstm.executeUpdate();

			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void suaNhanVien(String ten_nhanvien, String cmnd, String diachi, String sdt, String ngaysinh,
			String ngayvaolam) {
		String sql = "UPDATE tbl_nhanvien SET ten_nhanvien = ?, cmnd = ?, diachi = ?, sdt = ?, ngaysinh = ?, ngayvaolam = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ten_nhanvien);
			pstm.setString(2, cmnd);
			pstm.setString(3, diachi);
			pstm.setString(4, sdt);
			pstm.setString(5, ngaysinh);
			pstm.setString(6, ngayvaolam);
			pstm.executeUpdate();

			pstm.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
