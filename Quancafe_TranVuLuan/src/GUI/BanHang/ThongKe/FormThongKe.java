package GUI.BanHang.ThongKe;




import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import BLL.BanHang.TaoHoaDon.BanKhuVucBLL;
import BLL.BanHang.TaoHoaDon.ChonMonBLL;
import BLL.BanHang.ThongKe.ThongKeBLL;
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

public class FormThongKe extends JPanel {
	private JTextField txtBanSo;
	private JTextField txtKhuVucSo;
	private JTextField txtBatDau;
	private JTextField txtThanhTien;
	private JTextField txtTinhTrang;
	private JPanel[] pnMon;
	private JPanel pnOptions;
	private JPanel pnDetails;
	private String tenBan, tenKhuVuc;
	private NhanVien nhanvienthungan;
	private Vector<Vector> dsMon = new Vector<Vector>();
	private Vector<String> chiTietMon = new Vector<String>();

	private Calendar ngaylap;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private JTable table;
	private double totalPrice, sale, thanhtien;
	private JPanel pnOrder;
	private JTextField txtMaHD;
	private JTable tblDSHD;

	public FormThongKe() {
		initComponents();
		addEvents();
		loadTable();
	}

	
	public FormThongKe(NhanVien nhanvienthungan) {
		this.nhanvienthungan = nhanvienthungan;
		initComponents();
		addEvents();
		loadTable();
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 37, 830, 463);

		pnOrder = new JPanel();
		pnOrder.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 139, 139)));
		pnOrder.setBounds(0, 0, 346, 463);
		add(pnOrder);
		pnOrder.setLayout(null);

		JPanel pnOrderHeader = new JPanel();
		pnOrderHeader.setBounds(0, 11, 336, 84);
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

		JLabel lblNewLabel_1_2 = new JLabel("Thanh toán");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(5, 64, 60, 19);
		pnOrderHeader.add(lblNewLabel_1_2);

		txtBatDau = new JTextField(sdf.format(ngaylap.getInstance().getTime()));
		txtBatDau.setEditable(false);
		txtBatDau.setColumns(10);
		txtBatDau.setBounds(70, 63, 127, 20);
		pnOrderHeader.add(txtBatDau);
		
		JLabel lblNewLabel_2 = new JLabel("MaHD");
		lblNewLabel_2.setBounds(203, 67, 38, 14);
		pnOrderHeader.add(lblNewLabel_2);
		
		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
//		textField.setText(String.valueOf(isTonTai));
		txtMaHD.setBounds(240, 63, 86, 20);
		pnOrderHeader.add(txtMaHD);
		txtMaHD.setColumns(10);

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
		String[] header = { "Tên món", "SL", "Đơn giá"};
		dtm.setColumnIdentifiers(header);
		table.setModel(dtm);
		JScrollPane sc = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnDetails.add(sc);

		JPanel pnPrice = new JPanel();
		pnPrice.setBounds(0, 322, 336, 117);
		pnOrder.add(pnPrice);
		pnPrice.setLayout(null);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("TH\u00C0NH TI\u1EC0N");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3_1_1.setBounds(10, 37, 103, 25);
		pnPrice.add(lblNewLabel_1_3_1_1);

		txtThanhTien = new JTextField();
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(145, 37, 116, 25);
		pnPrice.add(txtThanhTien);

		JLabel lblNewLabel_1_3_1_1_1 = new JLabel("TÌNH TRẠNG");
		lblNewLabel_1_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3_1_1_1.setBounds(10, 78, 103, 25);
		pnPrice.add(lblNewLabel_1_3_1_1_1);

		txtTinhTrang = new JTextField();
		txtTinhTrang.setColumns(10);
		txtTinhTrang.setBounds(145, 78, 116, 25);
		pnPrice.add(txtTinhTrang);

		pnOptions = new JPanel();
		pnOptions.setBounds(344, 11, 486, 452);
		add(pnOptions);
		pnOptions.setLayout(new BorderLayout(0, 0));

		
		DefaultTableModel dtmHD = new DefaultTableModel();
		String[] headerHD = { "MaHD", "Bàn", "Khu vực", "Tổng tiền" };
		dtmHD.setColumnIdentifiers(headerHD);
		tblDSHD = new JTable();

		tblDSHD.setBounds(0,0,486,300);
		tblDSHD.setModel(dtmHD);
		JScrollPane sc1 = new JScrollPane(tblDSHD, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnOptions.add(sc1);

	}


	public void loadTable() {
		ThongKeBLL thongkeBLL = new ThongKeBLL();
		Vector<Vector> dsHoaDon = new Vector<Vector>();
		dsHoaDon = thongkeBLL.hienthiDsHoaDon();
		DefaultTableModel dtm = new DefaultTableModel();
		String[] header = { "MaHD", "Mã bàn", "Khu vực", "Tổng tiền" };
		dtm.setColumnIdentifiers(header);
		for (Vector<String> ct : dsHoaDon) {
			Vector<String> item = new Vector<String>();
			item.add(ct.get(0));
			item.add(ct.get(1));
			item.add(ct.get(3));
			item.add(ct.get(5));
			dtm.addRow(item);
		}
		tblDSHD.setModel(dtm);
	}
	


	public void loadChiTietHD(int rownumber) {
		int ma_hoadon = Integer.parseInt((String) tblDSHD.getValueAt(rownumber, 0));
		ThongKeBLL thongkeBLL = new ThongKeBLL();
		Vector<Vector> dsTemp = new Vector<Vector>();
		dsTemp = thongkeBLL.hienthiDsHoaDon();
		dsMon = thongkeBLL.hienthiDsMon(ma_hoadon);
		DefaultTableModel dtm = new DefaultTableModel();
		String[] header = { "Tên món", "SL", "Đơn giá"};
		dtm.setColumnIdentifiers(header);
		for (Vector<String> ct : dsMon) {
		
			dtm.addRow(ct);
		}

		table.setModel(dtm);
		
		txtBanSo.setText(String.valueOf(dsTemp.get(rownumber).get(2)));
		txtKhuVucSo.setText(String.valueOf(dsTemp.get(rownumber).get(4)));
		txtBatDau.setText(String.valueOf(dsTemp.get(rownumber).get(6)));
		txtMaHD.setText(String.valueOf(dsTemp.get(rownumber).get(0)));
		txtThanhTien.setText(String.valueOf(dsTemp.get(rownumber).get(5)));
		if (dsTemp.get(rownumber).get(7).equals("0")) {
			txtTinhTrang.setText("Chưa thanh toán");
		}
		else
			txtTinhTrang.setText("Đã thanh toán");
	}
	

	public void addEvents() {
		tblDSHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblDSHD.getSelectedRow();
				if (row != -1) {
					ThongKeBLL thongKeBLL = new ThongKeBLL();
 					loadChiTietHD(row);
				}
			}
		});
	}
}
