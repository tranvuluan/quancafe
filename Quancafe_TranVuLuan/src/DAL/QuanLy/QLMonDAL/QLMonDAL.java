package DAL.QuanLy.QLMonDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAL.MyJDBCUtil;

public class QLMonDAL {
	private  Connection conn = null;
	private  PreparedStatement pstm = null;
	private  ResultSet result = null;
	
	public void themMon(int ma_loaimon, String ten_mon, int gia_mon) {
		String sql = "INSERT INTO tbl_mon(ma_loaimon, ten_mon, gia_mon) VALUES(?,?,?)";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_loaimon);
			pstm.setString(2, ten_mon);
			pstm.setInt(3, gia_mon);
			pstm.executeUpdate();
			
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void suaMon(int ma_mon, String ten_mon, int gia_mon) {
		String sql = "UPDATE tbl_mon SET ten_mon = ?, gia_mon = ? WHERE ma_mon = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ten_mon);
			pstm.setInt(2, gia_mon);
			pstm.setInt(3, ma_mon);
			pstm.executeUpdate();
			
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void xoaMon(int ma_mon) {
		String sql = "DELETE FROM tbl_mon WHERE ma_mon = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_mon);
			pstm.executeUpdate();
			
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
