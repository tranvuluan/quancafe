package DAL.QuanLy.QLThongKe;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import DAL.MyJDBCUtil;

public class QLThongKeDAL {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet result = null;

	public Vector<Vector> hienthiDsHoaDon() {
		Vector<Vector> dsHoaDon = new Vector<Vector>();
		String sql = "SELECT * FROM `tbl_hoadon`, `tbl_ban`, `tbl_khuvuc` WHERE tbl_hoadon.ma_ban = tbl_ban.ma_ban AND tbl_ban.ma_khuvuc = tbl_khuvuc.ma_khuvuc AND tbl_hoadon.trangthai = 1";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			result = pstm.executeQuery();
			while (result.next()) {
				Vector<String> hoadon = new Vector<String>();
				hoadon.add(String.valueOf(result.getInt("ma_hoadon")));
				hoadon.add(String.valueOf(result.getInt("ma_ban")));
				hoadon.add(result.getString("ten_ban"));
				hoadon.add(String.valueOf(result.getInt("ma_khuvuc")));
				hoadon.add(result.getString("ten_khuvuc"));
				hoadon.add(String.valueOf(result.getDouble("tongtien")));
				hoadon.add(result.getString("ngaythanhtoan"));
				hoadon.add(String.valueOf(result.getInt("trangthai")));
				dsHoaDon.add(hoadon);
			}

			result.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsHoaDon;
	}
	
	public Vector<Vector> hienthiDsHoaDonTheoNgay(String tungay,String denngay) {
		Vector<Vector> dsHoaDon = new Vector<Vector>();
		String sql = "SELECT * FROM `tbl_hoadon`, `tbl_ban`, `tbl_khuvuc` WHERE tbl_hoadon.ma_ban = tbl_ban.ma_ban "
				+ "AND tbl_ban.ma_khuvuc = tbl_khuvuc.ma_khuvuc AND tbl_hoadon.trangthai = 1 AND tbl_hoadon.ngaythanhtoan >= ? AND tbl_hoadon.ngaythanhtoan <= ?";
		try {
			conn = MyJDBCUtil.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, tungay);
			pstm.setString(2, denngay);
			result = pstm.executeQuery();
			while (result.next()) {
				Vector<String> hoadon = new Vector<String>();
				hoadon.add(String.valueOf(result.getInt("ma_hoadon")));
				hoadon.add(String.valueOf(result.getInt("ma_ban")));
				hoadon.add(result.getString("ten_ban"));
				hoadon.add(String.valueOf(result.getInt("ma_khuvuc")));
				hoadon.add(result.getString("ten_khuvuc"));
				hoadon.add(String.valueOf(result.getDouble("tongtien")));
				hoadon.add(result.getString("ngaythanhtoan"));
				hoadon.add(String.valueOf(result.getInt("trangthai")));
				dsHoaDon.add(hoadon);
			}
			
			
			result.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsHoaDon;
	}
	
	public Vector<Vector> hienthiDsMon(int ma_hoadon) {
		Vector<Vector> dsMon = new Vector<Vector>();
		String sql = "SELECT * FROM `tbl_hoadon`, `tbl_chitiethoadon`,`tbl_mon` WHERE tbl_hoadon.ma_hoadon = tbl_chitiethoadon.ma_hoadon "
				+ "AND tbl_chitiethoadon.ma_mon = tbl_mon.ma_mon AND tbl_hoadon.ma_hoadon = ?";
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
				chitietMon.add(String.valueOf(result.getInt("ma_loaimon")));
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
}
