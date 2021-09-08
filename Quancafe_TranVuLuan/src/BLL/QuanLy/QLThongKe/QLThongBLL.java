package BLL.QuanLy.QLThongKe;

import java.util.Date;
import java.util.Vector;

import DAL.BanHang.ThongKe.ThongKeDAL;
import DAL.QuanLy.QLThongKe.QLThongKeDAL;

public class QLThongBLL {
	public Vector<Vector> hienthiDsHoaDon() {
		QLThongKeDAL thongkeDAL = new QLThongKeDAL();
		Vector<Vector> dsHoaDon = new Vector<Vector>();
		dsHoaDon = thongkeDAL.hienthiDsHoaDon();
		return dsHoaDon;
	}
	
	public Vector<Vector> hienthiDsHoaDonTheoNgay(String ngayden, String ngaydi) {
		QLThongKeDAL thongkeDAL = new QLThongKeDAL();
		Vector<Vector> dsHoaDon = new Vector<Vector>();
		dsHoaDon = thongkeDAL.hienthiDsHoaDonTheoNgay(ngayden, ngaydi);
		return dsHoaDon;
	}
	
	public Vector<Vector> hienthiDsMon(int ma_hoadon) {
		QLThongKeDAL thongkeDAL = new QLThongKeDAL();
		Vector<Vector> dsMon = new Vector<Vector>();
		dsMon = thongkeDAL.hienthiDsMon(ma_hoadon);
		return dsMon;
	}
	
}
