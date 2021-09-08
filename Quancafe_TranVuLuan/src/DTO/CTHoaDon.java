package DTO;

public class CTHoaDon {
	private HoaDon hoadon;
	private Mon mon;
	private double dongia;
	private int soluong;

	public CTHoaDon() {
		super();
	}

	public CTHoaDon(HoaDon hoadon, Mon mon, double dongia, int soluong) {
		super();
		this.hoadon = hoadon;
		this.mon = mon;
		this.dongia = dongia;
		this.soluong = soluong;
	}

	public HoaDon getHoadon() {
		return hoadon;
	}

	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}

	public Mon getMon() {
		return mon;
	}

	public void setMon(Mon mon) {
		this.mon = mon;
	}

	public double getDongia() {
		return dongia;
	}

	public void setDongia(double dongia) {
		this.dongia = dongia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

}
