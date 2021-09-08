package GUI.BanHang.BanVaKhuVuc;


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
import GUI.BanHang.TaoHoaDon.FormChonBanKhuVuc;
import GUI.BanHang.TaoHoaDon.FormChonMon;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class FormThanhToan extends JPanel {
	private JTextField txtBanSo;
	private JTextField txtKhuVucSo;
	private JTextField txtBatDau;
	private JTextField txtThanhTien;
	private JPanel[] pnMon;
	private JPanel pnOptions;
	private JPanel pnDetails;
	private String tenBan, tenKhuVuc;
	private int ma_ban;
	private NhanVien nhanvienthungan;
	private Vector<Vector> dsMon = new Vector<Vector>();
	private Vector<String> chiTietMon = new Vector<String>();

	private Calendar ngaylap;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private JTable table;
	private double totalPrice, sale, thanhtien;
	private int isTonTai = 0;
	private JButton btnThanhToan;
	private JPanel pnOrder;
	private JTextField textField;

	public FormThanhToan() {
		initComponents();
		addEvents();
	}

	public FormThanhToan(int ma_ban, String tenBan, String tenKhuVuc) {
		this.ma_ban = ma_ban;
		this.tenBan = tenBan;
		this.tenKhuVuc = tenKhuVuc;
		initComponents();
		addEvents();
		loadOrderDetails();
	}

	public FormThanhToan(int ma_ban, String tenBan, String tenKhuVuc, NhanVien nhanvienthungan) {
		this.ma_ban = ma_ban;
		this.tenBan = tenBan;
		this.tenKhuVuc = tenKhuVuc;
		this.nhanvienthungan = nhanvienthungan;
		initComponents();
		addEvents();
		loadOrderDetails();
	}
	
	public FormThanhToan(int ma_ban, String tenBan, String tenKhuVuc, NhanVien nhanvienthungan, Vector<Vector> dsMon) {
		this.ma_ban = ma_ban;
		this.tenBan = tenBan;
		this.tenKhuVuc = tenKhuVuc;
		this.nhanvienthungan = nhanvienthungan;
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
		pnOrder.setBounds(0, 0, 346, 463);
		add(pnOrder);
		pnOrder.setLayout(null);

		JPanel pnOrderHeader = new JPanel();
		pnOrderHeader.setBounds(0, 0, 336, 95);
		pnOrder.add(pnOrderHeader);
		pnOrderHeader.setLayout(null);

		JLabel lblNewLabel = new JLabel("HO\u00C1 \u0110\u01A0N");
		lblNewLabel.setBounds(131, 8, 74, 25);
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
		lblNewLabel_1_1.setBounds(203, 37, 55, 19);
		pnOrderHeader.add(lblNewLabel_1_1);

		txtKhuVucSo = new JTextField(tenKhuVuc);
		txtKhuVucSo.setEditable(false);
		txtKhuVucSo.setColumns(10);
		txtKhuVucSo.setBounds(268, 36, 58, 20);
		pnOrderHeader.add(txtKhuVucSo);

		JLabel lblNewLabel_1_2 = new JLabel("B\u1EAFt \u0111\u1EA7u");
		lblNewLabel_1_2.setBounds(10, 64, 47, 19);
		pnOrderHeader.add(lblNewLabel_1_2);

		txtBatDau = new JTextField();
		txtBatDau.setEditable(false);
		txtBatDau.setColumns(10);
		txtBatDau.setBounds(56, 64, 127, 20);
		pnOrderHeader.add(txtBatDau);
		
		JLabel lblNewLabel_2 = new JLabel("MaHD");
		lblNewLabel_2.setBounds(193, 67, 46, 14);
		pnOrderHeader.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setText(String.valueOf(isTonTai));
		textField.setBounds(240, 63, 86, 20);
		pnOrderHeader.add(textField);
		textField.setColumns(10);

		pnDetails = new JPanel();
		pnDetails.setBounds(0, 97, 336, 198);
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
		pnPrice.setBounds(0, 295, 336, 168);
		pnOrder.add(pnPrice);
		pnPrice.setLayout(null);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("TH\u00C0NH TI\u1EC0N");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3_1_1.setBounds(10, 115, 103, 25);
		pnPrice.add(lblNewLabel_1_3_1_1);

		txtThanhTien = new JTextField();
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(145, 115, 116, 25);
		pnPrice.add(txtThanhTien);

		pnOptions = new JPanel();
		pnOptions.setBounds(344, 0, 486, 463);
		add(pnOptions);
		pnOptions.setLayout(null);

		JPanel pnAction = new JPanel();
		pnAction.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 128, 128)));
		pnAction.setBounds(10, 368, 466, 95);
		pnOptions.add(pnAction);
		pnAction.setLayout(null);

		btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setBackground(new Color(240, 230, 140));
		btnThanhToan.setForeground(new Color(0, 139, 139));
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnThanhToan.setBounds(10, 29, 110, 42);
		pnAction.add(btnThanhToan);

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

		// Thanhtien va ngaylap
		ChonMonBLL chonmonBLL = new ChonMonBLL();
		ArrayList<String> hoadon = new ArrayList<String>();
		hoadon = chonmonBLL.getHoaDon(isTonTai);
		txtBatDau.setText(hoadon.get(0));
		txtThanhTien.setText(hoadon.get(1));
	}



	public void addEvents() {
		btnThanhToan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChonMonBLL chonMonBLL = new ChonMonBLL();
				chonMonBLL.thanhtoan(isTonTai ,ma_ban);
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
