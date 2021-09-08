package DTO;

import java.util.Date;

public class NhanVien {
	protected int maNV;
	protected String tenNV;
	protected String CMND;
	protected String sdtNV;
	protected String diachi;
	protected Date ngaysinh;
	protected Date ngayVaoLam;
	protected String chucvu;
	protected String username;
	public NhanVien() {
		super();
	}

	public NhanVien(int maNV, String tenNV, String cMND, String sdtNV, String diachi, Date ngaysinh,
			Date ngayVaoLam) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		CMND = cMND;
		this.sdtNV = sdtNV;
		this.diachi = diachi;
		this.ngaysinh = ngaysinh;
		this.ngayVaoLam = ngayVaoLam;
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChucvu() {
		return chucvu;
	}

	public void setChucvu(String chucv) {
		this.chucvu = chucv;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getSdtNV() {
		return sdtNV;
	}

	public void setSdtNV(String sdtNV) {
		this.sdtNV = sdtNV;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

}
