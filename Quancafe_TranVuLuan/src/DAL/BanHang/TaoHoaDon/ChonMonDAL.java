package DAL.BanHang.TaoHoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Vector;

import DAL.MyJDBCUtil;
import DTO.LoaiMon;
import DTO.Mon;

public class ChonMonDAL {
	private static Connection conn = null;
	private static PreparedStatement pstm = null;
	private static ResultSet result = null;

	public static Vector<Mon> hienthiMon(int ma_loaimon) {
		Vector<Mon> listMon = new Vector<Mon>();
		String sql = "SELECT * FROM tbl_mon WHERE tbl_mon.ma_loaimon = ? AND tbl_mon.status = 1";
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return listMon;
	}

	public static Mon findMonByMa_Mon(int ma_mon) {
		Mon mon = new Mon();
		String sql = "SELECT * FROM tbl_mon WHERE ma_mon = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_mon);
			result = pstm.executeQuery();

			while (result.next()) {
				mon.setMaMon(result.getInt("ma_mon"));
				mon.setTenMon(result.getString("ten_mon"));
				mon.setGiaMon(result.getInt("gia_mon"));
				LoaiMon loaimon = new LoaiMon();
				loaimon.setMaLoaiMon(result.getInt("ma_loaimon"));
				mon.setLoaiMon(loaimon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mon;
	}

	public static int getMa_banByTen_Ban(String ten_ban) {
		String sql = "SELECT * FROM tbl_ban WHERE ten_ban = ?";
		int ma_ban = -1;
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ten_ban);
			result = pstm.executeQuery();
			while (result.next()) {
				ma_ban = result.getInt("ma_ban");
			}

			return ma_ban;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				result.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public static int getMa_KhuVucByTen_KhuVuc(String ten_khuvuc) {
		String sql = "SELECT * FROM tbl_khuvuc WHERE ten_khuvuc = ?";
		int ma_khuvuc = -1;
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ten_khuvuc);
			result = pstm.executeQuery();
			while (result.next()) {
				ma_khuvuc = result.getInt("ma_khuvuc");
			}

			result.close();
			pstm.close();
			conn.close();
			return ma_khuvuc;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
