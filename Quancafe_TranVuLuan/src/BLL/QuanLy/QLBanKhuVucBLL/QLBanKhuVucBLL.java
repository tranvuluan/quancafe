package BLL.QuanLy.QLBanKhuVucBLL;

import DAL.QuanLy.QLBanKhuVucDAL.QLBanKhuVucDAL;

public class QLBanKhuVucBLL {
	public void themKhuVuc(String ten) {
		QLBanKhuVucDAL banKhuVucDAL = new QLBanKhuVucDAL();
		banKhuVucDAL.themKhuVuc(ten);
	}
	
	public void doiTenKhuVuc(int ma_khuvuc, String ten_khuvuc) {
		QLBanKhuVucDAL banKhuVucDAL = new QLBanKhuVucDAL();
		banKhuVucDAL.doiTenKhuVuc(ma_khuvuc, ten_khuvuc);
	}
	
	public void xoaKhuVuc(int ma_khuvuc) {
		QLBanKhuVucDAL banKhuVucDAL = new QLBanKhuVucDAL();
		banKhuVucDAL.xoaKhuVuc(ma_khuvuc);
	}
	
	
	
	public void themBan(String ten, int ma_khuvuc) {
		QLBanKhuVucDAL banKhuVucDAL = new QLBanKhuVucDAL();
		banKhuVucDAL.themBan(ten, ma_khuvuc);
	}
	
	public void doiTenBan(int ma_ban, String ten_ban) {
		QLBanKhuVucDAL banKhuVucDAL = new QLBanKhuVucDAL();
		banKhuVucDAL.doiTenBan(ma_ban, ten_ban);
	}
	
	public void xoaBan(int ma_ban) {
		QLBanKhuVucDAL banKhuVucDAL = new QLBanKhuVucDAL();
		banKhuVucDAL.xoaBan(ma_ban);
	}
}
