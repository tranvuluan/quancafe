package GUI.BanHang.BanVaKhuVuc;

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
import DTO.Ban;
import DTO.KhuVuc;
import DTO.NhanVien;
import GUI.BanHang.TaoHoaDon.FormChonMon;

import javax.swing.JButton;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Vector;
import java.awt.event.*;
import java.text.SimpleDateFormat;

public class FormBanVaKhuVuc extends JPanel {
	PanelListener listener = new PanelListener();
	private JPanel pnKhuVuc;
	private JPanel pnBan;
	private JPanel pnBanLoad;
	private JButton[] btnKV;
	private JButton[] btnBan;
	private String tenKhuVuc;
	private NhanVien nhanvienthungan;
	private String username;

	public FormBanVaKhuVuc() {
		initComponents();
		loadKhuVuc();
	}

	public FormBanVaKhuVuc(NhanVien nhanvienthungan) {
		this.nhanvienthungan = nhanvienthungan;
		initComponents();
		loadKhuVuc();
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 37, 830, 463);

		pnKhuVuc = new JPanel();
		pnKhuVuc.setBorder(new MatteBorder(1, 0, 2, 0, (Color) new Color(0, 139, 139)));
		pnKhuVuc.setBounds(0, 0, 830, 94);
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
		pnBan.setBounds(0, 94, 830, 369);
		add(pnBan);

		pnBanLoad = new JPanel();
		pnBanLoad.setLayout(null);
		pnBanLoad.setBounds(0, 0, 830, 369);
		pnBan.add(pnBanLoad);

	}

	public void addEvents() {

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
			positionBtnKV = positionBtnKV + 130;
			pnKhuVuc.add(btnKV[index]);
			btnKV[index].addMouseListener(listener);
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
			if (ban.getStatus() == 1 || ban.getStatus() == 3) {
				if (ban.getStatus() == 1)
					btnBan[index].setBackground(new Color(175, 0, 0));
				if (ban.getStatus() == 3)
					btnBan[index].setBackground(new Color(63, 0, 0));
				btnBan[index].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int rs = JOptionPane.showConfirmDialog(null, "Mở bàn");
						if (rs == 0)
							moBan(ban.getMaBan());
					}

				});
			} else if (ban.getStatus() == 2) {
				btnBan[index].setBackground(new Color(223, 112, 0));
				btnBan[index].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int rs = JOptionPane.showConfirmDialog(null, "Thanh toán bàn");
						if (rs == 0) {
							BanKhuVucBLL bankhuvucBLL = new BanKhuVucBLL();
							Vector<Vector> dsMon = new Vector<Vector>();
							int ma_ban = ban.getMaBan();
							int ma_hoadon = bankhuvucBLL.layMaHoaDonTuMaBanSomNhat(ma_ban);
							dsMon = bankhuvucBLL.hienthiDsMon(ma_hoadon);
							goToThanhToan(ban.getMaBan(), ban.getTenBan(), dsMon);
						}
					}

				});
				
			} else {
				btnBan[index].setBackground(new Color(255, 250, 250));
				btnBan[index].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int rs = JOptionPane.showConfirmDialog(null, "Khoá bàn?");
						if (rs == 0) {
							khoaBan(ban.getMaBan());
						}
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						JButton source = (JButton) e.getSource();
						source.setBackground(new Color(0, 139, 139));
						source.setForeground(new Color(255, 255, 255));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						JButton source = (JButton) e.getSource();
						source.setBackground(new Color(255, 250, 250));
						source.setForeground(new Color(0, 139, 139));
					}

				});
			}
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

	public void goToOrder(int ma_ban, String ten_ban) {
		FormChonMon formChonMon = new FormChonMon(ma_ban, ten_ban, tenKhuVuc, nhanvienthungan);
		this.remove(pnBan);
		this.remove(pnKhuVuc);
		this.add(formChonMon);
		this.revalidate();
		this.repaint();

	}

	public void goToThanhToan(int ma_ban, String ten_ban, Vector<Vector> dsMon) {
		FormThanhToan formChonMon = new FormThanhToan(ma_ban, ten_ban, tenKhuVuc, nhanvienthungan, dsMon);
		this.remove(pnBan);
		this.remove(pnKhuVuc);
		this.add(formChonMon);
		this.revalidate();
		this.repaint();

	}

	public void khoaBan(int ma_ban) {
		BanKhuVucBLL ban = new BanKhuVucBLL();
		ban.khoaban(ma_ban);
	}

	public void moBan(int ma_ban) {
		BanKhuVucBLL ban = new BanKhuVucBLL();
		ban.mokhoa(ma_ban);
	}

	private class PanelListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			Object source = event.getSource();
			for (int i = 0; i < btnKV.length; i++) {
				btnKV[i].setBackground(new Color(255, 250, 250));
				btnKV[i].setForeground(new Color(0, 139, 139));
			}
			if (source instanceof JButton) {
				JButton panelPressed = (JButton) source;
				panelPressed.setBackground(new Color(0, 139, 139));
				panelPressed.setForeground(new Color(255, 255, 255));
				tenKhuVuc = panelPressed.getClientProperty("ten_khuvuc").toString();
				loadBan(panelPressed.getText());
			}

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}

	}

}
