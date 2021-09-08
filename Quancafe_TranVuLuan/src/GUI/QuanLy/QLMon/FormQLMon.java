package GUI.QuanLy.QLMon;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import BLL.BanHang.TaoHoaDon.ChonMonBLL;
import BLL.BanHang.ThucAnNuocUong.ThucAnNuocUongBLL;
import BLL.QuanLy.QLMon.QLMonBLL;
import DTO.Mon;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormQLMon extends JPanel {
	private int ma_nvthungan;
	private String username;
	private JPanel[] pnMon;
	private JPanel pnOptions;
	private JPanel pnOptionHeader;
	private JPanel pnListMon;
	private JButton btnDrink;
	private JButton btnFood;
	private JPanel pnAction;
	private JButton btnTheMon;
	private JButton btnSuaMon;
	private JButton btnXoaMon;
	private int MaMon = -1, MaLoai = -1;

	public FormQLMon() {
		initComponents();
		addEvents();
	}

	public FormQLMon(int ma_nvthungan) {
		this.ma_nvthungan = ma_nvthungan;
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
		pnOptionHeader.setBounds(0, 0, 695, 54);
		pnOptions.add(pnOptionHeader);

		btnDrink = new JButton("THỨC UỐNG");

		btnDrink.setBounds(37, 9, 141, 35);
		pnOptionHeader.add(btnDrink);

		btnFood = new JButton("MÓN ĂN");

		btnFood.setBounds(211, 9, 141, 35);
		pnOptionHeader.add(btnFood);

		pnListMon = new JPanel();
		pnListMon.setLayout(null);
		pnListMon.setBounds(0, 55, 695, 408);
		pnOptions.add(pnListMon);

		pnAction = new JPanel();
		pnAction.setBounds(694, 0, 136, 463);
		pnOptions.add(pnAction);
		pnAction.setLayout(null);

		btnTheMon = new JButton("Thêm món");

		btnTheMon.setBounds(16, 43, 104, 39);
		pnAction.add(btnTheMon);

		btnSuaMon = new JButton("Sửa món");
		btnSuaMon.setBounds(16, 112, 104, 39);
		pnAction.add(btnSuaMon);

		btnXoaMon = new JButton("Xoá món");
		btnXoaMon.setBounds(16, 182, 104, 39);
		pnAction.add(btnXoaMon);

	}

	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public void addEvents() {
		btnDrink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MaLoai = 1;
				loadMon(1, 1);
			}
		});

		btnFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MaLoai = 2;
				loadMon(2, 2);
			}

		});

		btnTheMon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (MaLoai != -1) {
					QLMonBLL mon = new QLMonBLL();
					String ten_mon = JOptionPane.showInputDialog("Nhập tên món");
					String gia_mon = "";
					do {
					gia_mon = JOptionPane.showInputDialog("Nhập giá món muốn sửa");
					} while (isNumeric(gia_mon) == false);
					mon.themMon(MaLoai, ten_mon, Integer.parseInt(gia_mon));
					JOptionPane.showMessageDialog(null, "Load lại trang để cập nhật");
				}
			}
		});
		
		btnSuaMon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (MaMon != -1) {
					QLMonBLL mon = new QLMonBLL();
					String ten_mon = JOptionPane.showInputDialog("Nhập tên món muốn sửa");
					String gia_mon = "";
					do {
					gia_mon = JOptionPane.showInputDialog("Nhập giá món muốn sửa");
					} while (isNumeric(gia_mon) == false);
					mon.suaMon(MaMon, ten_mon, Integer.parseInt(gia_mon));
					JOptionPane.showMessageDialog(null, "Load lại trang để cập nhật");
				}
			}
		});
		
		btnXoaMon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (MaMon != -1) {
					QLMonBLL mon = new QLMonBLL();
					mon.xoaMon(MaMon);
					JOptionPane.showMessageDialog(null, "Load lại trang để cập nhật");
				}
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
			if (mon.getStatus() == 0)
				pnMon[index].setBackground(Color.GRAY);
			pnMon[index].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JPanel pnMonClicked = (JPanel) e.getSource();
					MaMon = Integer.parseInt((String) pnMonClicked.getClientProperty("ma_mon"));
					for(int i=0; i< pnMon.length; i++) {
						pnMon[i].setBackground(null);
					}
					pnMonClicked.setBackground(new Color(194, 214, 214));
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

}