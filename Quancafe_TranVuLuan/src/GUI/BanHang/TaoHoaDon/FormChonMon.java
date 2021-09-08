package GUI.BanHang.TaoHoaDon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import BLL.BanHang.TaoHoaDon.ChonMonBLL;
import DTO.Mon;
import DTO.NhanVien;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.*;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class FormChonMon extends JPanel {
	private JTextField txtBanSo;
	private JTextField txtKhuVucSo;
	private JTextField txtBatDau;
	private JTextField txtSale;
	private JTextField txtThanhTien;
	private JButton btnDrink;
	private JButton btnFood;
	private JPanel[] pnMon;
	private JPanel pnListMon;
	private JPanel pnOptions;
	private JPanel pnDetails;
	private String tenBan, tenKhuVuc;
	private int ma_ban;
	private NhanVien nhanvienthungan;
	private int isTonTai = 0;
	private Vector<Vector> dsMon = new Vector<Vector>();
	private Vector<String> chiTietMon = new Vector<String>();

	private Calendar ngaylap;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private JTable table;
	private JTextField txtTotalPrice;
	private double totalPrice, sale, thanhtien;
	private JButton btnInHoaDon;
	private JPanel pnOrder;
	private JButton btnTrSau;

	public FormChonMon() {
		initComponents();
		addEvents();
	}

	public FormChonMon(int ma_ban, String tenBan, String tenKhuVuc) {
		this.ma_ban = ma_ban;
		this.tenBan = tenBan;
		this.tenKhuVuc = tenKhuVuc;
		initComponents();
		addEvents();
		loadOrderDetails();
	}

	public FormChonMon(int ma_ban, String tenBan, String tenKhuVuc, NhanVien nhanvienthungan) {
		this.ma_ban = ma_ban;
		this.tenBan = tenBan;
		this.tenKhuVuc = tenKhuVuc;
		this.nhanvienthungan = nhanvienthungan;
		initComponents();
		addEvents();
		loadOrderDetails();
	}

	public FormChonMon(int ma_ban, String tenBan, String tenKhuVuc, NhanVien nhanvienthungan, Vector<Vector> dsMon) {
		this.ma_ban = ma_ban;
		this.tenBan = tenBan;
		this.tenKhuVuc = tenKhuVuc;
		this.nhanvienthungan = nhanvienthungan;
		System.out.println(dsMon);
		this.isTonTai = Integer.parseInt((String) dsMon.get(0).get(3));
		for (Vector<String> ct : dsMon) {
			ct.remove(3);
		}
		this.dsMon = dsMon;
		initComponents();
		addEvents();
		loadOrderDetails();
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 0, 830, 463);

		pnOrder = new JPanel();
		pnOrder.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 139, 139)));
		pnOrder.setBounds(0, 0, 274, 463);
		add(pnOrder);
		pnOrder.setLayout(null);

		JPanel pnOrderHeader = new JPanel();
		pnOrderHeader.setBounds(0, 0, 271, 95);
		pnOrder.add(pnOrderHeader);
		pnOrderHeader.setLayout(null);

		JLabel lblNewLabel = new JLabel("HO\u00C1 \u0110\u01A0N");
		lblNewLabel.setBounds(84, 8, 74, 25);
		pnOrderHeader.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_1 = new JLabel("B\u00E0n s\u1ED1");
		lblNewLabel_1.setBounds(10, 37, 47, 19);
		pnOrderHeader.add(lblNewLabel_1);

		txtBanSo = new JTextField(tenBan);
		txtBanSo.setEditable(false);
		txtBanSo.setBounds(56, 37, 47, 20);
		pnOrderHeader.add(txtBanSo);
		txtBanSo.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Khu v\u1EF1c");
		lblNewLabel_1_1.setBounds(113, 37, 55, 19);
		pnOrderHeader.add(lblNewLabel_1_1);

		txtKhuVucSo = new JTextField(tenKhuVuc);
		txtKhuVucSo.setEditable(false);
		txtKhuVucSo.setColumns(10);
		txtKhuVucSo.setBounds(175, 37, 58, 20);
		pnOrderHeader.add(txtKhuVucSo);

		JLabel lblNewLabel_1_2 = new JLabel("B\u1EAFt \u0111\u1EA7u");
		lblNewLabel_1_2.setBounds(10, 64, 47, 19);
		pnOrderHeader.add(lblNewLabel_1_2);

		txtBatDau = new JTextField(sdf.format(ngaylap.getInstance().getTime()));
		txtBatDau.setEditable(false);
		txtBatDau.setColumns(10);
		txtBatDau.setBounds(56, 64, 177, 20);
		pnOrderHeader.add(txtBatDau);

		pnDetails = new JPanel();
		pnDetails.setBounds(0, 97, 271, 198);
		pnDetails.setLayout(new BorderLayout(0, 0));
		pnOrder.add(pnDetails);

		table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setBounds(0, 0, 271, 198);
		DefaultTableModel dtm = new DefaultTableModel();
		String[] header = { "Tên món", "SL", "Đơn giá", "Xoá" };
		dtm.setColumnIdentifiers(header);
		table.setModel(dtm);
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(Color.RED);
		table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		JScrollPane sc = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnDetails.add(sc);

		JPanel pnPrice = new JPanel();
		pnPrice.setBounds(0, 295, 271, 168);
		pnOrder.add(pnPrice);
		pnPrice.setLayout(null);

		JLabel lblNewLabel_1_3 = new JLabel("T\u1ED4NG");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3.setBounds(10, 22, 103, 25);
		pnPrice.add(lblNewLabel_1_3);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setBounds(145, 22, 116, 25);
		txtTotalPrice.setColumns(10);
		pnPrice.add(txtTotalPrice);

		JLabel lblNewLabel_1_3_1 = new JLabel("GI\u1EA2M GI\u00C1 (%)");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3_1.setBounds(10, 58, 103, 25);
		pnPrice.add(lblNewLabel_1_3_1);

		txtSale = new JTextField("0");
		txtSale.setEditable(false);
		txtSale.setColumns(10);
		txtSale.setBounds(145, 58, 116, 25);
		pnPrice.add(txtSale);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("TH\u00C0NH TI\u1EC0N");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3_1_1.setBounds(10, 109, 103, 25);
		pnPrice.add(lblNewLabel_1_3_1_1);

		txtThanhTien = new JTextField();
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(145, 109, 116, 25);
		pnPrice.add(txtThanhTien);

		pnOptions = new JPanel();
		pnOptions.setBounds(274, 0, 556, 463);
		add(pnOptions);
		pnOptions.setLayout(null);

		JPanel pnOptionHeader = new JPanel();
		pnOptionHeader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 128, 128)));
		pnOptionHeader.setBounds(0, 0, 556, 54);
		pnOptions.add(pnOptionHeader);
		pnOptionHeader.setLayout(null);

		btnDrink = new JButton("TH\u1EE8C U\u1ED0NG");

		btnDrink.setBounds(37, 9, 141, 35);
		pnOptionHeader.add(btnDrink);

		btnFood = new JButton("M\u00D3N \u0102N");
		btnFood.setBounds(211, 9, 141, 35);
		pnOptionHeader.add(btnFood);

		pnListMon = new JPanel();
		pnListMon.setBounds(0, 55, 556, 310);
		pnOptions.add(pnListMon);
		pnListMon.setLayout(null);

		JPanel pnAction = new JPanel();
		pnAction.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 128, 128)));
		pnAction.setBounds(0, 368, 556, 95);
		pnOptions.add(pnAction);
		pnAction.setLayout(null);

		btnInHoaDon = new JButton("IN HO\u00C1 \u0110\u01A0N");
		btnInHoaDon.setBackground(new Color(240, 230, 140));
		btnInHoaDon.setForeground(new Color(0, 139, 139));
		btnInHoaDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInHoaDon.setBounds(10, 29, 110, 42);
		pnAction.add(btnInHoaDon);

		btnTrSau = new JButton("TR\u1EA2 SAU");

		btnTrSau.setForeground(new Color(0, 139, 139));
		btnTrSau.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTrSau.setBackground(new Color(240, 230, 140));
		btnTrSau.setBounds(163, 29, 110, 42);
		pnAction.add(btnTrSau);

	}

	public void loadMon(int ma_loaimon, int theloai) {
		JPanel pnLoadMon = new JPanel();
		pnLoadMon.setLayout(null);
		pnLoadMon.setBounds(0, 55, 556, 310);
		ChonMonBLL chonMonBLL = new ChonMonBLL();
		Vector<Mon> listMon = new Vector<Mon>();
		listMon = chonMonBLL.hienthiMon(ma_loaimon);
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
			pnMon[index].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JPanel pnMonClick = (JPanel) e.getSource();
					ChonMonBLL chonMonBLL = new ChonMonBLL();
					Mon mon = new Mon();
					String ma1 = (String) pnMonClick.getClientProperty("ma_mon");
					mon = chonMonBLL.findMon(ma1);
					String soluong = "";
					do {
						soluong = String.valueOf(JOptionPane.showInputDialog(null, "Nhập số lượng"));
					} while (isNumeric(soluong) == false);
					chiTietMon = new Vector<String>();
					chiTietMon.add(mon.getTenMon());
					chiTietMon.add(soluong);
					chiTietMon.add(String.valueOf(mon.getGiaMon()));
					chiTietMon.add("x");
					dsMon.add(chiTietMon);
					loadOrderDetails();
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

	public void loadOrderDetails() {
		DefaultTableModel dtm = new DefaultTableModel();
		String[] header = { "Tên món", "SL", "Đơn giá", "Xoá" };
		dtm.setColumnIdentifiers(header);
		for (Vector<String> ct : dsMon) {
			ct.add("x");
			dtm.addRow(ct);
		}

		table.setModel(dtm);
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		DefaultTableCellRenderer cellRendererColor = new DefaultTableCellRenderer();
		cellRendererColor.setBackground(Color.RED);
		cellRendererColor.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(3).setCellRenderer(cellRendererColor);

		// Load price
		loadPrice();
	}

	public void deleteItem(int row) {
		DefaultTableModel dtm = new DefaultTableModel();
		String[] header = { "Tên món", "SL", "Đơn giá", "Xoá" };
		dtm.setColumnIdentifiers(header);
		for (int i = 0; i < dsMon.size(); i++) {
			if (i == row)
				continue;
			Vector<String> ctMon = dsMon.get(i);
			dtm.addRow(ctMon);
		}
		dsMon.remove(row);

		table.setModel(dtm);
		table.getColumnModel().getColumn(0).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		DefaultTableCellRenderer cellRendererColor = new DefaultTableCellRenderer();
		cellRendererColor.setHorizontalAlignment(JLabel.CENTER);

		cellRendererColor.setBackground(Color.RED);

		table.getColumnModel().getColumn(3).setCellRenderer(cellRendererColor);

		// Load
		loadPrice();
	}

	public void loadPrice() {
		totalPrice = 0;
		sale = 1 - Double.parseDouble(txtSale.getText()) / 100;
		thanhtien = 0;
		for (Vector<String> chitietMon : dsMon) {
			totalPrice += Integer.parseInt(chitietMon.get(1)) * Integer.parseInt(chitietMon.get(2));
		}
		txtTotalPrice.setText(String.valueOf(totalPrice));
		thanhtien = totalPrice * sale;
		txtThanhTien.setText(String.valueOf(thanhtien));

		// Change with sale
	}

	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void changeValue() {
		String sl = "";
		do {
			sl = String.valueOf(JOptionPane.showInputDialog(null, "Nhập phần trăm giảm giá"));
		} while (isNumeric(sl) == false);
		txtSale.setText(sl);
		sale = 1 - Double.parseDouble(sl) / 100;
		thanhtien = totalPrice * sale;
		txtThanhTien.setText(String.valueOf(thanhtien));
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

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
//				JOptionPane.showMessageDialog(null, row + " " + column);
				if (column == 3) {
					deleteItem(row);
				}
			}
		});
		txtSale.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				changeValue();
			}
		});

		btnInHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChonMonBLL chonMonBLL = new ChonMonBLL();
				boolean inhoadon = chonMonBLL.inHoaDon(ma_ban, nhanvienthungan.getMaNV(), 1, thanhtien, dsMon);
				backToChonBanKhuVuc();
			}
		});

		btnTrSau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChonMonBLL chonMonBLL = new ChonMonBLL();
				if (isTonTai == 0) {
					boolean traSau = chonMonBLL.traSau(ma_ban, nhanvienthungan.getMaNV(), 0, thanhtien, dsMon);
				} else {
					boolean themvaochitiethoadon = chonMonBLL.traSauDaTonTai(isTonTai, ma_ban, nhanvienthungan.getMaNV(), 0,
							thanhtien, dsMon); 
					// isTonTai la ma_hoadon cu
				}
				backToChonBanKhuVuc();
			}
		});
	}

	public void backToChonBanKhuVuc() {
		FormChonBanKhuVuc formChonBanKhuVuc = new FormChonBanKhuVuc(nhanvienthungan);
		formChonBanKhuVuc.setBounds(this.getBounds());
		this.remove(pnOrder);
		this.remove(pnOptions);
		this.add(formChonBanKhuVuc);
		this.revalidate();
		this.repaint();
	}

}
