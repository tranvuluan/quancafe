package DAL.BanHang.TaoHoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import DAL.MyJDBCUtil;
import DTO.Ban;
import DTO.KhuVuc;

public class BanKhuVucDAL {
	private static Connection conn = null;
	private static PreparedStatement pstm = null;
	private static ResultSet result = null;
	
	public static Vector<KhuVuc> hienthiKhuVuc() {
		Vector<KhuVuc> listKhuVuc = new Vector<KhuVuc>();
		String sql = "SELECT * FROM tbl_khuvuc";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			result = pstm.executeQuery();
			while (result.next()) {
				KhuVuc kv = new KhuVuc();
				kv.setMaKV(result.getInt("ma_khuvuc"));
				kv.setTenKV(result.getString("ten_khuvuc"));
				listKhuVuc.add(kv);
			}
			result.close();
			pstm.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listKhuVuc;
	}
	
	public static Vector<Ban> hienthiBanTheoKhuVuc(KhuVuc kv) {
		Vector<Ban> listBan = new Vector<Ban>();
		String sql = "SELECT * FROM tbl_khuvuc, tbl_ban WHERE tbl_khuvuc.ma_khuvuc = tbl_ban.ma_khuvuc AND tbl_khuvuc.ten_khuvuc = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, kv.getTenKV());
			result = pstm.executeQuery();
			while (result.next()) {
				Ban ban = new Ban();
				ban.setMaBan(result.getInt("ma_ban"));
				ban.setTenBan(result.getString("ten_ban"));
				ban.setKhuvuc(kv);
				ban.setStatus(result.getInt("status"));
				listBan.add(ban);
			}
			result.close();
			pstm.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listBan;
	}
	
	public void mokhoa(int ma_ban) {
		String sql = "UPDATE tbl_ban SET status = 0 WHERE ma_ban = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_ban);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void khoaban(int ma_ban) {
		String sql = "UPDATE tbl_ban SET status = 3 WHERE ma_ban = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_ban);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
