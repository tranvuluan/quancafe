package GUI.QuanLy.QLBanKhuVuc;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import BLL.BanHang.TaoHoaDon.BanKhuVucBLL;
import BLL.QuanLy.QLBanKhuVucBLL.QLBanKhuVucBLL;
import DTO.Ban;
import DTO.KhuVuc;
import GUI.BanHang.TaoHoaDon.FormChonMon;

import javax.swing.JButton;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Vector;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.JSeparator;

public class FormQLBanKhuVuc extends JPanel {
	private JPanel pnKhuVuc;
	private JPanel pnBan;
	private JPanel pnBanLoad;
	private JButton[] btnKV;
	private JButton[] btnBan;
	private String tenKhuVuc;
	private int ma_nvthungan;
	private String username;
	private JPanel pnAction;
	private JButton btnAddTable;
	private JButton btnChangeTable;
	private JButton btnDeleteTable;
	private int MaKhuVuc = -1, MaBan = -1;
	private JButton btnAddKV;
	private JButton btnChangeKV;
	private JButton btnDeleteKV;

	public FormQLBanKhuVuc() {
		initComponents();
		loadKhuVuc();
		addEvents();
	}

	public FormQLBanKhuVuc(int ma_nvthungan) {
		this.ma_nvthungan = ma_nvthungan;
		initComponents();
		loadKhuVuc();
		addEvents();
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 37, 830, 463);

		pnKhuVuc = new JPanel();
		pnKhuVuc.setBorder(new MatteBorder(1, 0, 2, 0, (Color) new Color(0, 139, 139)));
		pnKhuVuc.setBounds(0, 0, 672, 94);
		add(pnKhuVuc);
		pnKhuVuc.setLayout(null);

		JLabel lblNewLabel = new JLabel("KHU V\u1EF0C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(0, 0, 88, 94);
		pnKhuVuc.add(lblNewLabel);

		pnBan = new JPanel();
		pnBan.setLayout(null);
		pnBan.setBounds(0, 94, 672, 369);
		add(pnBan);

		pnBanLoad = new JPanel();
		pnBanLoad.setLayout(null);
		pnBanLoad.setBounds(0, 0, 672, 369);
		pnBan.add(pnBanLoad);

		pnAction = new JPanel();
		pnAction.setBounds(673, 0, 157, 463);
		add(pnAction);
		pnAction.setLayout(null);

		btnAddKV = new JButton("Thêm khu vực");
		btnAddKV.setBounds(16, 32, 124, 37);
		pnAction.add(btnAddKV);

		btnChangeKV = new JButton("Sửa khu vực");
		btnChangeKV.setBounds(16, 99, 124, 37);
		pnAction.add(btnChangeKV);

		btnDeleteKV = new JButton("Xoá khu vực");
		btnDeleteKV.setBounds(16, 162, 124, 37);
		pnAction.add(btnDeleteKV);

		btnAddTable = new JButton("Thêm Bàn");
		btnAddTable.setBounds(16, 256, 124, 37);
		pnAction.add(btnAddTable);

		btnChangeTable = new JButton("Sửa bàn");
		btnChangeTable.setBounds(16, 320, 124, 37);
		pnAction.add(btnChangeTable);

		btnDeleteTable = new JButton("Xoá bàn");
		btnDeleteTable.setBounds(16, 381, 124, 37);
		pnAction.add(btnDeleteTable);

	}

	public void addEvents() {
		btnAddKV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String TenKhuVuc = JOptionPane.showInputDialog("Nhập tên khu vực");
				QLBanKhuVucBLL bankhuvucBLL = new QLBanKhuVucBLL();
				bankhuvucBLL.themKhuVuc(TenKhuVuc);
				JOptionPane.showMessageDialog(null, "Load lại trang để cập nhật");
			}
		});

		btnChangeKV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (MaKhuVuc != -1) {
					String TenKhuVuc = JOptionPane.showInputDialog("Nhập tên khu vực muốn đổi");
					QLBanKhuVucBLL bankhuvucBLL = new QLBanKhuVucBLL();
					bankhuvucBLL.doiTenKhuVuc(MaKhuVuc, TenKhuVuc);
					JOptionPane.showMessageDialog(null, "Load lại trang để cập nhật");
				}
			}
		});

		btnDeleteKV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (MaKhuVuc != -1) {
					QLBanKhuVucBLL bankhuvucBLL = new QLBanKhuVucBLL();
					bankhuvucBLL.xoaKhuVuc(MaKhuVuc);
					JOptionPane.showMessageDialog(null, "Load lại trang để cập nhật");
				}
			}
		});
		
		
		btnAddTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (MaKhuVuc != -1) {
				String TenBan = JOptionPane.showInputDialog("Nhập tên bàn");
				QLBanKhuVucBLL bankhuvucBLL = new QLBanKhuVucBLL();
				bankhuvucBLL.themBan(TenBan, MaKhuVuc);
				JOptionPane.showMessageDialog(null, "Load lại trang để cập nhật");
				}
			}
		});
		
		btnChangeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (MaBan != -1) {
					String TenBan = JOptionPane.showInputDialog("Nhập tên bàn muốn đổi");
					QLBanKhuVucBLL bankhuvucBLL = new QLBanKhuVucBLL();
					bankhuvucBLL.doiTenBan(MaBan, TenBan);
					JOptionPane.showMessageDialog(null, "Load lại trang để cập nhật");
				}
			}
		});
		
		btnDeleteTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (MaBan != -1) {
					QLBanKhuVucBLL bankhuvucBLL = new QLBanKhuVucBLL();
					bankhuvucBLL.xoaBan(MaBan);
					JOptionPane.showMessageDialog(null, "Load lại trang để cập nhật");
				}
			}
		});
		
	}

	public void loadKhuVuc() {
		int positionBtnKV = 120;
		BanKhuVucBLL banKhuVucBLL = new BanKhuVucBLL();
		Vector<KhuVuc> listKhuVuc = banKhuVucBLL.hienthiKhuVuc();
		btnKV = new JButton[listKhuVuc.size()];
		int index = 0;
		for (KhuVuc kv : listKhuVuc) {
			btnKV[index] = new JButton(kv.getTenKV());
			btnKV[index].setBounds(positionBtnKV, 11, 98, 71);
			btnKV[index].setBackground(new Color(255, 250, 250));
			btnKV[index].setForeground(new Color(0, 139, 139));
			btnKV[index].setBorder(new LineBorder(new Color(0, 139, 139), 2));
			btnKV[index].setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnKV[index].putClientProperty("ten_khuvuc", kv.getTenKV());
			btnKV[index].putClientProperty("ma_khuvuc", kv.getMaKV());
			positionBtnKV = positionBtnKV + 130;
			pnKhuVuc.add(btnKV[index]);
			btnKV[index].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (int i = 0; i < btnKV.length; i++) {
						btnKV[i].setBackground(new Color(255, 250, 250));
						btnKV[i].setForeground(new Color(0, 139, 139));
					}
					JButton panelPressed = (JButton) e.getSource();
					panelPressed.setBackground(new Color(0, 139, 139));
					panelPressed.setForeground(new Color(255, 255, 255));
					tenKhuVuc = panelPressed.getClientProperty("ten_khuvuc").toString();
					MaKhuVuc = Integer.parseInt(panelPressed.getClientProperty("ma_khuvuc").toString());
					loadBan(panelPressed.getText());
				}

			});
			index++;
		}

	}

	public void loadBan(String ten_kv) {
		JPanel pnListBan = new JPanel();
		pnListBan.setLayout(null);
		pnListBan.setBounds(0, 0, 830, 369);
		BanKhuVucBLL banKhuVucBLL = new BanKhuVucBLL();
		Vector<Ban> listBan = new Vector<Ban>();
		listBan = banKhuVucBLL.hienthiBanTheoKhuVuc(ten_kv);
		int index = 0;
		int positionXBtnBan = 33;
		btnBan = new JButton[listBan.size()];
		for (Ban ban : listBan) {
			btnBan[index] = new JButton(ban.getTenBan());
			btnBan[index].setBounds(positionXBtnBan, 21, 116, 57);
			btnBan[index].putClientProperty("ma_ban", ban.getMaBan());
			btnBan[index].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					for (int i = 0; i < btnBan.length; i++) {
						btnBan[i].setBackground(new Color(255, 250, 250));
						btnBan[i].setForeground(new Color(0, 139, 139));
					}
					JButton ban = (JButton) e.getSource();
					MaBan = Integer.parseInt(ban.getClientProperty("ma_ban").toString());
					ban.setBackground(new Color(0, 139, 139));
					ban.setForeground(Color.white);
				}

			});
			btnBan[index].setBackground(new Color(255, 250, 250));
			btnBan[index].setForeground(new Color(0, 139, 139));
			btnBan[index].putClientProperty("ten_ban", ban.getTenBan());
			positionXBtnBan = positionXBtnBan + 155;
			pnListBan.add(btnBan[index]);
			index++;
		}
		pnBan.remove(pnBanLoad);
		pnBanLoad = pnListBan;
		pnBan.add(pnBanLoad);
		this.revalidate();
		this.repaint();
	}

}
