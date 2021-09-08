package DTO;

import java.util.ArrayList;

public class LoaiMon {
	private int maLoaiMon;
	private String tenLoaiMon;
	private ArrayList<Mon> listMon;

	public LoaiMon() {
		super();
	}

	public LoaiMon(int maLoaiMon, String tenLoaiMon) {
		super();
		this.maLoaiMon = maLoaiMon;
		this.tenLoaiMon = tenLoaiMon;
	}

	public LoaiMon(int maLoaiMon, String tenLoaiMon, ArrayList<Mon> listMon) {
		super();
		this.maLoaiMon = maLoaiMon;
		this.tenLoaiMon = tenLoaiMon;
		this.listMon = listMon;
	}

	public int getMaLoaiMon() {
		return maLoaiMon;
	}

	public void setMaLoaiMon(int maLoaiMon) {
		this.maLoaiMon = maLoaiMon;
	}

	public String getTenLoaiMon() {
		return tenLoaiMon;
	}

	public void setTenLoaiMon(String tenLoaiMon) {
		this.tenLoaiMon = tenLoaiMon;
	}

	public ArrayList<Mon> getListMon() {
		return listMon;
	}

	public void setListMon(ArrayList<Mon> listMon) {
		this.listMon = listMon;
	}

}
