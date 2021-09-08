package DAL.BanHang.TaoHoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import DAL.MyJDBCUtil;
import DTO.Mon;

public class InHoaDonDAL {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet result = null;

	public int inHoaDon(int ma_ban, int ma_nvthungan, int trangthai, double tongtien) {
		int ma_hoadon;
		String sql = "INSERT INTO tbl_hoadon(ma_hoadon, ma_ban, ma_nvthungan, trangthai, tongtien, ngaylap, ngaythanhtoan) VALUES(?, ?, ?, ?, ?, current_timestamp(),current_timestamp())";
		try {
			Random rd = new Random();
			ma_hoadon = rd.nextInt(9999999);
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_hoadon);
			pstm.setInt(2, ma_ban);
			pstm.setInt(3, ma_nvthungan);
			pstm.setInt(4, trangthai);
			pstm.setDouble(5, tongtien);
			pstm.executeUpdate();

			// Set trạng thái bàn
			String sql1 = "UPDATE `tbl_ban` SET status = 1 WHERE ma_ban = ?";
			pstm = conn.prepareStatement(sql1);
			pstm.setInt(1, ma_ban);
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ma_hoadon;

	}

	public void inHoaDonDaTonTai(int ma_hoadon, int ma_ban, double tongtien) {
		String sql = "UPDATE tbl_hoadon SET tongtien= ?, ngaythanhtoan = current_timestamp(), trangthai = 1 WHERE ma_hoadon = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, tongtien);
			pstm.setInt(2, ma_hoadon);
			pstm.executeUpdate();

			// Set trạng thái bàn
			String sql1 = "UPDATE `tbl_ban` SET status = 1 WHERE ma_ban = ?";
			pstm = conn.prepareStatement(sql1);
			pstm.setInt(1, ma_ban);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public int traSau(int ma_ban, int ma_nvthungan, int trangthai, double tongtien) {
		int ma_hoadon;
		String sql = "INSERT INTO tbl_hoadon(ma_hoadon, ma_ban, ma_nvthungan, trangthai, tongtien, ngaylap) VALUES(?, ?, ?, ?, ?, current_timestamp())";
		try {
			Random rd = new Random();
			ma_hoadon = rd.nextInt(9999999);
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_hoadon);
			pstm.setInt(2, ma_ban);
			pstm.setInt(3, ma_nvthungan);
			pstm.setInt(4, trangthai);
			pstm.setDouble(5, tongtien);
			pstm.executeUpdate();

			// Set trạng thái bàn
			String sql1 = "UPDATE `tbl_ban` SET status = 2 WHERE ma_ban = ?";
			pstm = conn.prepareStatement(sql1);
			pstm.setInt(1, ma_ban);
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				pstm.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ma_hoadon;

	}

	public void traSauDaTonTai(int ma_hoadon, double tongtien) {
		String sql = "UPDATE tbl_hoadon SET tongtien= ? WHERE ma_hoadon = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, tongtien);
			pstm.setInt(2, ma_hoadon);
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public boolean chitiethoadon(int ma_hoadon, int ma_mon, Vector<String> mon) {
		String sql = "INSERT INTO tbl_chitiethoadon(ma_hoadon, ma_mon, soluong, gia_mon) VALUES(?,?,?,?)";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_hoadon);
			pstm.setInt(2, ma_mon);
			pstm.setInt(3, Integer.parseInt(mon.get(1)));
			pstm.setInt(4, Integer.parseInt(mon.get(2)));
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return true;
	}

	public int getMa_MonByTen_Mon(String ten_mon) {
		int ma_mon = 0;
		String sql = "SELECT * FROM tbl_mon WHERE ten_mon = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ten_mon);
			result = pstm.executeQuery();
			while (result.next())
				ma_mon = result.getInt("ma_mon");

			result.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ma_mon;
	}

	public Vector<Vector> hienthiDsMon(int ma_hoadon) {
		Vector<Vector> dsMon = new Vector<Vector>();
		String sql = "SELECT * FROM `tbl_chitiethoadon`,`tbl_mon` WHERE  tbl_chitiethoadon.ma_mon = tbl_mon.ma_mon  AND tbl_chitiethoadon.ma_hoadon = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_hoadon);
			result = pstm.executeQuery();
			while (result.next()) {
				Vector<String> chitietMon = new Vector<String>();
				chitietMon.add(result.getString("ten_mon"));
				chitietMon.add(String.valueOf(result.getInt("soluong")));
				chitietMon.add(String.valueOf(result.getInt("gia_mon")));
				chitietMon.add(String.valueOf(result.getInt("ma_hoadon")));
				dsMon.add(chitietMon);
			}
			result.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsMon;
	}

	public int layMaHoaDonTuMaBanSomNhat(int ma_ban) {
		int ma_hoadon=0;
		String sql="SELECT * FROM tbl_hoadon WHERE ma_ban = ? ORDER BY ngaylap DESC LIMIT 1";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_ban);
			result = pstm.executeQuery();
			result.next();
			ma_hoadon = result.getInt("ma_hoadon");
			
			result.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ma_hoadon;
	}

	public void deleteChiTietHoaDonByHoaDon(int ma_hoadon) {
		String sql = "DELETE FROM `tbl_chitiethoadon` WHERE ma_hoadon = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_hoadon);
			pstm.executeUpdate();

			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void thanhtoan(int ma_hoadon, int ma_ban) {
		String sql = "UPDATE tbl_hoadon SET ngaythanhtoan = current_timestamp(), trangthai = 1 WHERE ma_hoadon = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_hoadon);
			pstm.executeUpdate();

			String sql1 = "UPDATE tbl_ban SET status = 1 WHERE ma_ban = ?";
			PreparedStatement pstm1 = null;
			pstm1 = conn.prepareStatement(sql1);
			pstm1.setInt(1, ma_ban);
			pstm1.executeUpdate();

			pstm1.close();
			pstm.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getHoaDon(int ma_hoadon) {
		ArrayList<String> hoadon = new ArrayList<String>();
		String sql = "SELECT * FROM tbl_hoadon WHERE ma_hoadon = ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma_hoadon);
			result = pstm.executeQuery();
			result.next();
			hoadon.add(result.getString("ngaylap"));
			hoadon.add(String.valueOf(result.getDouble("tongtien")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hoadon;
	}
}
