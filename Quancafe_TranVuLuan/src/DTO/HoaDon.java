package DTO;

import java.util.Calendar;

public class HoaDon {
	private int maHD;
	private Ban ban;
	private NhanVien nvThuNgan;
	private Calendar tgLapHoaDon;
	private Calendar tgThanhToan;
	private int trangthai;
	private double tongTien;

	public HoaDon() {
		super();
	}

	public HoaDon(int maHD, Ban ban, NhanVien nvThuNgan, Calendar tgLapHoaDon, Calendar tgThanhToan, int trangthai,
			double tongTien) {
		super();
		this.maHD = maHD;
		this.ban = ban;
		this.nvThuNgan = nvThuNgan;
		this.tgLapHoaDon = tgLapHoaDon;
		this.tgThanhToan = tgThanhToan;
		this.trangthai = trangthai;
		this.tongTien = tongTien;
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public Ban getBan() {
		return ban;
	}

	public void setBan(Ban ban) {
		this.ban = ban;
	}

	public NhanVien getNvThuNgan() {
		return nvThuNgan;
	}

	public void setNvThuNgan(NhanVien nvThuNgan) {
		this.nvThuNgan = nvThuNgan;
	}

	public Calendar getTgLapHoaDon() {
		return tgLapHoaDon;
	}

	public void setTgLapHoaDon(Calendar tgLapHoaDon) {
		this.tgLapHoaDon = tgLapHoaDon;
	}

	public Calendar getTgThanhToan() {
		return tgThanhToan;
	}

	public void setTgThanhToan(Calendar tgThanhToan) {
		this.tgThanhToan = tgThanhToan;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

}
