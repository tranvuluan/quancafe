package BLL.BanHang.TaoHoaDon;

import java.util.Vector;

import DAL.BanHang.TaoHoaDon.BanKhuVucDAL;
import DAL.BanHang.TaoHoaDon.InHoaDonDAL;
import DTO.Ban;
import DTO.KhuVuc;

public class BanKhuVucBLL {
	public Vector<KhuVuc> hienthiKhuVuc() {
		Vector<KhuVuc> listKhuVuc = new Vector<KhuVuc>();
		listKhuVuc = BanKhuVucDAL.hienthiKhuVuc();
		return listKhuVuc;
	}
	
	public Vector<Ban> hienthiBanTheoKhuVuc(String ten_kv) {
		KhuVuc kv = new KhuVuc();
		kv.setTenKV(ten_kv);
		Vector<Ban> listBan = new Vector<Ban>();
		listBan = BanKhuVucDAL.hienthiBanTheoKhuVuc(kv);
		return listBan;
	}
	
	public Vector<Vector> hienthiDsMon(int ma_hoadon) {
		InHoaDonDAL inhoadonDAL = new InHoaDonDAL();
		Vector<Vector> dsMon = new Vector<Vector>();
		dsMon = inhoadonDAL.hienthiDsMon(ma_hoadon);
		return dsMon;
	}
	
	public int layMaHoaDonTuMaBanSomNhat(int ma_ban) {
		int ma_hoadon = 0;
		InHoaDonDAL inhoadonDAL = new InHoaDonDAL();
		ma_hoadon = inhoadonDAL.layMaHoaDonTuMaBanSomNhat(ma_ban);
		return ma_hoadon;
	}
	
	public void mokhoa(int ma_ban) {
		BanKhuVucDAL ban = new BanKhuVucDAL();
		ban.mokhoa(ma_ban);
	}
	
	public void khoaban(int ma_ban) {
		BanKhuVucDAL ban = new BanKhuVucDAL();
		ban.khoaban(ma_ban);
	}
	
}
