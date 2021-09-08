package BLL.QuanLy.QLMon;

import DAL.QuanLy.QLMonDAL.QLMonDAL;

public class QLMonBLL {
	public void themMon(int ma_loaimon, String ten_mon, int gia_mon) {
		QLMonDAL mon = new QLMonDAL();
		mon.themMon(ma_loaimon, ten_mon, gia_mon);
	}

	public void suaMon(int ma_mon, String ten_mon, int gia_mon) {
		QLMonDAL mon = new QLMonDAL();
		mon.suaMon(ma_mon, ten_mon, gia_mon);
	}

	public void xoaMon(int ma_mon) {
		QLMonDAL mon = new QLMonDAL();
		mon.xoaMon(ma_mon);
	}
}
