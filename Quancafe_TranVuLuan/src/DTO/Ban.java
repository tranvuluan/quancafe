package DTO;

public class Ban {
	private int maBan;
	private String tenBan;
	private KhuVuc khuvuc;
	private int status;
	public Ban() {
		super();
	}

	public Ban(int maBan, String tenBan) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
	}

	public Ban(int maBan, String tenBan, KhuVuc khuvuc, int status) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.khuvuc = khuvuc;
		this.status = status;
	}
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getMaBan() {
		return maBan;
	}

	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}

	public String getTenBan() {
		return tenBan;
	}

	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}

	public KhuVuc getKhuvuc() {
		return khuvuc;
	}

	public void setKhuvuc(KhuVuc kv) {
		this.khuvuc = kv;
	}

	

}
