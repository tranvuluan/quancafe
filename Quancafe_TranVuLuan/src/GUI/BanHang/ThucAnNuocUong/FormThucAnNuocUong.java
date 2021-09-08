package GUI.BanHang.ThucAnNuocUong;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import BLL.BanHang.TaoHoaDon.ChonMonBLL;
import BLL.BanHang.ThucAnNuocUong.ThucAnNuocUongBLL;
import DTO.Mon;
import DTO.NhanVien;
import GUI.BanHang.TaoHoaDon.FormChonMon;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FormThucAnNuocUong extends JPanel {
	private NhanVien nhanvienthungan;
	private String username;
	private JPanel[] pnMon;
	private JPanel pnOptions;
	private JPanel pnOptionHeader;
	private JPanel pnListMon;
	private JButton btnDrink;
	private JButton btnFood;

	public FormThucAnNuocUong(NhanVien nhanvienthungan) {
		this.nhanvienthungan = nhanvienthungan;
		initComponents();
		addEvents();
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 37, 830, 463);

		pnOptions = new JPanel();
		pnOptions.setLayout(null);
		pnOptions.setBounds(0, 0, 830, 463);
		add(pnOptions);

		pnOptionHeader = new JPanel();
		pnOptionHeader.setLayout(null);
		pnOptionHeader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 128, 128)));
		pnOptionHeader.setBounds(0, 0, 830, 54);
		pnOptions.add(pnOptionHeader);

		btnDrink = new JButton("THỨC UỐNG");

		btnDrink.setBounds(37, 9, 141, 35);
		pnOptionHeader.add(btnDrink);

		btnFood = new JButton("MÓN ĂN");

		btnFood.setBounds(211, 9, 141, 35);
		pnOptionHeader.add(btnFood);

		pnListMon = new JPanel();
		pnListMon.setLayout(null);
		pnListMon.setBounds(0, 55, 830, 408);
		pnOptions.add(pnListMon);

	}

	public void addEvents() {
		btnDrink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadMon(1, 1);
			}
		});

		btnFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadMon(2, 2);
			}
		});
	}

	public void loadMon(int ma_loaimon, int theloai) {
		JPanel pnLoadMon = new JPanel();
		pnLoadMon.setLayout(null);
		pnLoadMon.setBounds(0, 55, 556, 310);
		ThucAnNuocUongBLL thucannuocuongBLL = new ThucAnNuocUongBLL();
		Vector<Mon> listMon = new Vector<Mon>();
		listMon = thucannuocuongBLL.hienthiTatCaMon(ma_loaimon);
		pnMon = new JPanel[listMon.size()];
		int index = 0;
		int positionMonX = 15;
		int positionMonY = 10;
		for (Mon mon : listMon) {
			pnMon[index] = new JPanel();
			pnMon[index].setLayout(null);
			pnMon[index].setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 139, 139)));
			pnMon[index].setBounds(positionMonX, positionMonY, 120, 90);
			pnMon[index].putClientProperty("ma_mon", String.valueOf(mon.getMaMon()));
			pnMon[index].putClientProperty("ten_mon", mon.getTenMon());
			pnMon[index].putClientProperty("status", String.valueOf(mon.getStatus()));
			if (mon.getStatus() == 0)
				pnMon[index].setBackground(Color.GRAY);
			pnMon[index].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JPanel pnMon = (JPanel) e.getSource();
					String status = (String) pnMon.getClientProperty("status");
					String ma_mon = (String) pnMon.getClientProperty("ma_mon");
					if (status.equals("1")) {
						int rs = JOptionPane.showConfirmDialog(null, "Khoá món");
						if (rs == 0) {
							khoamon(ma_mon);
						}
					} else {
						int rs = JOptionPane.showConfirmDialog(null, "Mở khoá món");
						if (rs == 0) {
							mokhoamon(ma_mon);
						}
					}
				}
			});
			pnLoadMon.add(pnMon[index]);

			JLabel lblNewLabel_2 = new JLabel();
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			if (theloai == 1)
				lblNewLabel_2.setIcon(new ImageIcon(FormChonMon.class.getResource("/image/coffee-cup.png")));
			else
				lblNewLabel_2.setIcon(new ImageIcon(FormChonMon.class.getResource("/image/breakfast.png")));
			lblNewLabel_2.setBounds(15, 0, 89, 64);
			pnMon[index].add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel(mon.getTenMon());
			lblNewLabel_3.setForeground(new Color(0, 128, 128));
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setBounds(0, 65, 120, 25);
			pnMon[index].add(lblNewLabel_3);
			index++;
			positionMonX = positionMonX + 140;
			if (index % 4 == 0) {
				positionMonY = positionMonY + 100;
				positionMonX = 15;
			}

		}
		pnOptions.remove(pnListMon);
		pnListMon = pnLoadMon;
		pnOptions.add(pnListMon);
		this.revalidate();
		this.repaint();
	}

	public void khoamon(String ma_mons) {
		int ma_mon = Integer.parseInt(ma_mons);
		ThucAnNuocUongBLL mon = new ThucAnNuocUongBLL();
		mon.khoamon(ma_mon);
	}

	public void mokhoamon(String ma_mons) {
		int ma_mon = Integer.parseInt(ma_mons);
		ThucAnNuocUongBLL mon = new ThucAnNuocUongBLL();
		mon.mokhoamon(ma_mon);
	}
}
