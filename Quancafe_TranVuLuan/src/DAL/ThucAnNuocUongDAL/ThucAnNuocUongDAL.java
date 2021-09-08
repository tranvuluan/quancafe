package DAL.ThucAnNuocUongDAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import DAL.MyJDBCUtil;
import DTO.Mon;
public class ThucAnNuocUongDAL {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet result = null;
	
	public void khoamon(int ma_mon) {
		String sql = "UPDATE tbl_mon SET tbl_mon.status = 0 WHERE tbl_mon.ma_mon = ?";
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
	
	public void mokhoamon(int ma_mon) {
		String sql = "UPDATE tbl_mon SET tbl_mon.status = 1 WHERE tbl_mon.ma_mon = ?";
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
	
	public Vector<Mon> hienthiTatCaMon(int ma_loaimon) {
		Vector<Mon> listMon = new Vector<Mon>();
		String sql = "SELECT * FROM tbl_mon WHERE tbl_mon.ma_loaimon = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_loaimon);
			result = pstm.executeQuery();
			while (result.next()) {
				Mon mon = new Mon();
				mon.setMaMon(result.getInt("ma_mon"));
				mon.setTenMon(result.getString("ten_mon"));
				mon.setStatus(result.getInt("status"));
				listMon.add(mon);
			}
			result.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMon;
	}
}




