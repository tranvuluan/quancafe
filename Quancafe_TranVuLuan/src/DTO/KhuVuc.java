package DTO;

import java.util.ArrayList;

public class KhuVuc {
	private int maKV;
	private String tenKV;
	private ArrayList<Ban> listBan;

	public KhuVuc() {
		super();
	}

	public KhuVuc(int maKV, String tenKV) {
		super();
		this.maKV = maKV;
		this.tenKV = tenKV;
	}

	public KhuVuc(int maKV, String tenKV, ArrayList<Ban> listBan) {
		super();
		this.maKV = maKV;
		this.tenKV = tenKV;
		this.listBan = listBan;
	}

	public int getMaKV() {
		return maKV;
	}

	public void setMaKV(int maKV) {
		this.maKV = maKV;
	}

	public String getTenKV() {
		return tenKV;
	}

	public void setTenKV(String tenKV) {
		this.tenKV = tenKV;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return tenKV;
	}

	public ArrayList<Ban> getListBan() {
		return listBan;
	}

	public void setListBan(ArrayList<Ban> listBan) {
		this.listBan = listBan;
	}

}
