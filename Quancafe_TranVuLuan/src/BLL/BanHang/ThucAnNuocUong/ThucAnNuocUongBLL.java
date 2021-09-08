package BLL.BanHang.ThucAnNuocUong;

import java.util.Vector;

import DAL.ThucAnNuocUongDAL.ThucAnNuocUongDAL;
import DTO.Mon;

public class ThucAnNuocUongBLL {
	public void khoamon(int ma_mon) {
		ThucAnNuocUongDAL mon = new ThucAnNuocUongDAL();
		mon.khoamon(ma_mon);
	}
	
	public void mokhoamon(int ma_mon) {
		ThucAnNuocUongDAL mon = new ThucAnNuocUongDAL();
		mon.mokhoamon(ma_mon);
	}
	
	public Vector<Mon> hienthiTatCaMon(int ma_loaimon) {
		ThucAnNuocUongDAL mon = new ThucAnNuocUongDAL();
		Vector<Mon> dsMon = new Vector<Mon>();
		dsMon = mon.hienthiTatCaMon(ma_loaimon);
		return dsMon;
	}
}
