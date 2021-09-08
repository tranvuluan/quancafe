package DAL.QuanLy.QLBanKhuVucDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import DAL.MyJDBCUtil;


public class QLBanKhuVucDAL {
	private  Connection conn = null;
	private  PreparedStatement pstm = null;
	private  ResultSet result = null;
	
	public void themKhuVuc(String ten_khuvuc) {
		String sql = "INSERT INTO tbl_khuvuc(ten_khuvuc) VALUES(?)";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ten_khuvuc);
			pstm.executeUpdate();
			
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doiTenKhuVuc(int ma_khuvuc, String ten_khuvuc) {
		String sql = "UPDATE tbl_khuvuc SET ten_khuvuc = ? WHERE ma_khuvuc = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ten_khuvuc);
			pstm.setInt(2, ma_khuvuc);
			pstm.executeUpdate();
			
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xoaKhuVuc(int ma_khuvuc) {
		String sql = "DELETE FROM tbl_khuvuc WHERE ma_khuvuc = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_khuvuc);
			pstm.executeUpdate();
			
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void themBan(String ten_ban, int ma_khuvuc) {
		String sql = "INSERT INTO tbl_ban(ten_ban, ma_khuvuc) VALUES(?, ?)";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ten_ban);
			pstm.setInt(2, ma_khuvuc);
			pstm.executeUpdate();
			 
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doiTenBan(int ma_ban, String ten_ban) {
		String sql = "UPDATE tbl_ban SET ten_ban = ? WHERE ma_ban = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ten_ban);
			pstm.setInt(2, ma_ban);
			pstm.executeUpdate();
			
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xoaBan(int ma_ban) {
		String sql = "DELETE FROM tbl_ban WHERE ma_ban = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_ban);
			pstm.executeUpdate();
			
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
