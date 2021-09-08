package DAL.LoginDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAL.MyJDBCUtil;
import DTO.NhanVien;

public class LoginDAL {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet result = null;
	
	public NhanVien login(String username, String password) {
		NhanVien nhanvien = new NhanVien();
		String sql = "SELECT * FROM `tbl_account` INNER JOIN tbl_nhanvien ON " +
		"tbl_account.username = tbl_nhanvien.username " +
		" WHERE tbl_account.username = ? AND tbl_account.pass = ? ";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			result = pstm.executeQuery();
			if (result.next()) {
				nhanvien.setMaNV(result.getInt("ma_nhanvien"));
				nhanvien.setTenNV(result.getString("ten_nhanvien"));
				nhanvien.setSdtNV(result.getString("sdt"));
				nhanvien.setDiachi(result.getString("diachi"));
				nhanvien.setCMND(result.getString("cmnd"));
				nhanvien.setNgaysinh(result.getDate("ngaysinh"));
				nhanvien.setNgayVaoLam(result.getDate("ngayvaolam"));
				nhanvien.setChucvu(result.getString("chucvu"));
				nhanvien.setUsername(result.getString("username"));
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				result.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return nhanvien;
	}
}
