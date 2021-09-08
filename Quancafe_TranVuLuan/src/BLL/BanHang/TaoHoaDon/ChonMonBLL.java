package BLL.BanHang.TaoHoaDon;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import DAL.BanHang.TaoHoaDon.ChonMonDAL;
import DAL.BanHang.TaoHoaDon.InHoaDonDAL;
import DTO.Mon;

public class ChonMonBLL {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public Vector<Mon> hienthiMon(int ma_loaimon) {
		Vector<Mon> listMon = new Vector<Mon>();
		listMon = ChonMonDAL.hienthiMon(ma_loaimon);
		return listMon;
	}

	public Mon findMon(String ma_mon) {
		int ma_mon1 = Integer.parseInt(ma_mon);
		Mon mon = new Mon();
		mon = ChonMonDAL.findMonByMa_Mon(ma_mon1);
		return mon;
	}
	
	public boolean inHoaDon(int ma_ban, int ma_nvthungan, int trangthai, double tongtien, Vector<Vector> dsMon) {
		int mahd_inhoadon;
		InHoaDonDAL inhoadonDAL = new InHoaDonDAL();
		mahd_inhoadon = inhoadonDAL.inHoaDon(ma_ban, ma_nvthungan, trangthai, tongtien);
		if (mahd_inhoadon == -1)
			return false;
		boolean inhd = chitiethoadon(mahd_inhoadon ,dsMon);
		return inhd;
	}
	
	
	public boolean traSau(int ma_ban, int ma_nvthungan, int trangthai, double tongtien, Vector<Vector> dsMon) {
		int mahd_inhoadon;
		InHoaDonDAL inhoadonDAL = new InHoaDonDAL();
		mahd_inhoadon = inhoadonDAL.traSau(ma_ban, ma_nvthungan, trangthai, tongtien);
		if (mahd_inhoadon == -1)
			return false;
		boolean inhd = chitiethoadon(mahd_inhoadon ,dsMon);
		return inhd;
	}
	
	public boolean traSauDaTonTai(int ma_hoadon ,int ma_ban, int ma_nvthungan, int trangthai, double tongtien, Vector<Vector> dsMon) {

		InHoaDonDAL inhoadonDAL = new InHoaDonDAL();
		inhoadonDAL.deleteChiTietHoaDonByHoaDon(ma_hoadon);
		inhoadonDAL.traSauDaTonTai(ma_hoadon, tongtien);
		boolean inhd = chitiethoadon(ma_hoadon ,dsMon);
		return inhd;
	}
	
	public boolean chitiethoadon(int mahd_inhoadon, Vector<Vector> dsMon) {
		boolean kq = false;
		for (Vector<String> ct : dsMon) {
			Vector<String> mon  = ct;
			InHoaDonDAL inhoadonDAL = new InHoaDonDAL();
			int ma_mon = inhoadonDAL.getMa_MonByTen_Mon(mon.get(0));
			kq = inhoadonDAL.chitiethoadon(mahd_inhoadon, ma_mon,mon);
		}
		
		return kq;
	}
	
	public int getMa_BanByTen_Ban(String ten_ban) {
		int ma_ban = -1;
		ma_ban = ChonMonDAL.getMa_banByTen_Ban(ten_ban);
		return ma_ban;
	}
	
	public int getMa_KhuVucByTen_KhuVuc(String ten_khuvuc) {
		int ma_khuvuc = -1;
		ma_khuvuc = ChonMonDAL.getMa_KhuVucByTen_KhuVuc(ten_khuvuc);
		return ma_khuvuc;
	}
	
	public void thanhtoan(int ma_hoadon, int ma_ban) {
		boolean kq = false;
		InHoaDonDAL inhoadonDAL = new InHoaDonDAL();
		inhoadonDAL.thanhtoan(ma_hoadon, ma_ban);
	}
	
	public ArrayList<String> getHoaDon(int ma_hoadon) {			//Chi lay ngaylap voi thanhtien
		ArrayList<String> hoadon = new ArrayList<String>();
		InHoaDonDAL inhoadonDAL = new InHoaDonDAL();
		hoadon = inhoadonDAL.getHoaDon(ma_hoadon);
		return hoadon;
	}
}


