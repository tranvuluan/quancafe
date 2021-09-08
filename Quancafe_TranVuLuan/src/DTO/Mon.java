package DTO;

public class Mon {
	private int maMon;
	private String tenMon;
	private int giaMon;
	private LoaiMon loaiMon;
	private int status;

	public Mon() {
		super();
	}

	public Mon(int maMon, String tenMon, int giaMon) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.giaMon = giaMon;
	}

	public Mon(int maMon, String tenMon, LoaiMon loaiMon, int status) {
		super();
		this.maMon = maMon;
		this.tenMon = tenMon;
		this.loaiMon = loaiMon;
		this.status = status;
	}
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getMaMon() {
		return maMon;
	}

	public void setMaMon(int maMon) {
		this.maMon = maMon;
	}
	
	

	public int getGiaMon() {
		return giaMon;
	}

	public void setGiaMon(int giaMon) {
		this.giaMon = giaMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public LoaiMon getLoaiMon() {
		return loaiMon;
	}

	public void setLoaiMon(LoaiMon loaiMon) {
		this.loaiMon = loaiMon;
	}

}
