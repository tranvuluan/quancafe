package BLL.BanHang.ThongKe;

import java.util.Vector;

import DAL.BanHang.TaoHoaDon.InHoaDonDAL;
import DAL.BanHang.ThongKe.ThongKeDAL;

public class ThongKeBLL {
	public Vector<Vector> hienthiDsHoaDon() {
		ThongKeDAL thongkeDAL = new ThongKeDAL();
		Vector<Vector> dsHoaDon = new Vector<Vector>();
		dsHoaDon = thongkeDAL.hienthiDsHoaDon();
		return dsHoaDon;
	}
	
	public Vector<Vector> hienthiDsMon(int ma_hoadon) {
		ThongKeDAL thongkeDAL = new ThongKeDAL();
		Vector<Vector> dsMon = new Vector<Vector>();
		dsMon = thongkeDAL.hienthiDsMon(ma_hoadon);
		return dsMon;
	}
}
