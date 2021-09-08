package GUI.QuanLy.QLThongKe;

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
import BLL.QuanLy.QLThongKe.QLThongBLL;
import DTO.Mon;
import GUI.BanHang.TaoHoaDon.FormChonBanKhuVuc;
import GUI.BanHang.TaoHoaDon.FormChonMon;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.*;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.FlowLayout;

public class FormQLThongKe extends JPanel {
	private JTextField txtBanSo;
	private JTextField txtKhuVucSo;
	private JTextField txtBatDau;
	private JTextField txtThanhTien;
	private JPanel[] pnMon;
	private JPanel pnOptions;
	private JPanel pnDetails;
	private String tenBan, tenKhuVuc;
	private int ma_ban;
	private int ma_nvthungan;
	private Vector<Vector> dsMon = new Vector<Vector>();
	private Vector<Vector> dsHoaDon = new Vector<Vector>();
	private JDatePickerImpl datePicker, datePicker1;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JTable table;
	private JPanel pnOrder;
	private JTextField txtMaHD;
	private JTable tblDSHD;
	private JPanel pnLoc;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel pnDenNgay;
	private JPanel pnTuNgay;
	private JButton btnLc;
	private JFreeChart pieChart;
	private JFreeChart barChart;
	private ChartPanel chartPanel;
	private JButton btnTK;
	private JPanel pnThongKe;
	private JButton btnTroLai;
	private JTextField txtTongDoanhThu;
	private JButton btnNewButton;
	private JButton btnInport;

	public FormQLThongKe() {
		initComponents();
		addEvents();
		loadTable();
	}

	public FormQLThongKe(int ma_nvthungan) {
		this.ma_nvthungan = ma_nvthungan;
		initComponents();
		addEvents();
		loadTable();
	}

	public void initComponents() {
		setLayout(null);
		setBounds(0, 37, 830, 463);

		pnOrder = new JPanel();
		pnOrder.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 139, 139)));
		pnOrder.setBounds(0, 0, 346, 352);
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

		txtBatDau = new JTextField();
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
		String[] header = { "Tên món", "SL", "Đơn giá" };
		dtm.setColumnIdentifiers(header);
		table.setModel(dtm);
		JScrollPane sc = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnDetails.add(sc);

		JPanel pnPrice = new JPanel();
		pnPrice.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 128, 128)));
		pnPrice.setBounds(0, 306, 336, 46);
		pnOrder.add(pnPrice);
		pnPrice.setLayout(null);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("TH\u00C0NH TI\u1EC0N");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3_1_1.setBounds(10, 11, 103, 25);
		pnPrice.add(lblNewLabel_1_3_1_1);

		txtThanhTien = new JTextField();
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(156, 11, 116, 25);
		pnPrice.add(txtThanhTien);

		pnOptions = new JPanel();
		pnOptions.setBounds(344, 11, 486, 341);
		add(pnOptions);
		pnOptions.setLayout(new BorderLayout(0, 0));

		DefaultTableModel dtmHD = new DefaultTableModel();
		String[] headerHD = { "MaHD", "Bàn", "Khu vực", "Tổng tiền" };
		dtmHD.setColumnIdentifiers(headerHD);
		tblDSHD = new JTable();

		tblDSHD.setBounds(0, 0, 486, 300);
		tblDSHD.setModel(dtmHD);
		JScrollPane sc1 = new JScrollPane(tblDSHD, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnOptions.add(sc1);

		pnLoc = new JPanel();
		pnLoc.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 139, 139)));
		pnLoc.setBounds(354, 363, 466, 89);
		add(pnLoc);
		pnLoc.setLayout(null);

		lblNewLabel_3 = new JLabel("Lọc từ ngày");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 11, 76, 28);
		pnLoc.add(lblNewLabel_3);
		lblNewLabel_4 = new JLabel("đến");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(10, 50, 26, 28);
		pnLoc.add(lblNewLabel_4);

		pnDenNgay = new JPanel();
		pnDenNgay.setBounds(83, 50, 220, 39);
		pnLoc.add(pnDenNgay);
		UtilDateModel model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
		datePicker1 = new JDatePickerImpl(datePanel1);
		pnDenNgay.add(datePicker1);

		pnTuNgay = new JPanel();
		pnTuNgay.setBounds(83, 11, 220, 38);
		pnLoc.add(pnTuNgay);
		pnTuNgay.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		pnTuNgay.add(datePicker);

		btnLc = new JButton("Lọc");

		btnLc.setForeground(new Color(255, 255, 224));
		btnLc.setBackground(new Color(0, 128, 128));
		btnLc.setBounds(328, 15, 101, 63);
		pnLoc.add(btnLc);

		pnThongKe = new JPanel();
		pnThongKe.setLayout(null);
		pnThongKe.setBounds(0, 0, 346, 350);
		chartPanel = new ChartPanel(barChart);
		pnThongKe.add(chartPanel);

		JLabel lblNewLabel_5 = new JLabel("Tổng doanh thu");
		lblNewLabel_5.setBounds(10, 315, 115, 25);
		pnThongKe.add(lblNewLabel_5);

		txtTongDoanhThu = new JTextField();
		txtTongDoanhThu.setBounds(160, 315, 115, 25);
		pnThongKe.add(txtTongDoanhThu);
		txtTongDoanhThu.setColumns(10);

		btnTK = new JButton("THỐNG KÊ DOANH THU");
		btnTK.setForeground(new Color(255, 255, 224));
		btnTK.setBackground(new Color(0, 128, 128));
		btnTK.setBounds(10, 378, 233, 34);
		add(btnTK);
		
		btnNewButton = new JButton("Xuất Excel");

		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(10, 429, 133, 23);
		add(btnNewButton);
		
		btnInport = new JButton("Nhập Excel");
		btnInport.setForeground(Color.WHITE);
		btnInport.setBackground(new Color(0, 139, 139));
		btnInport.setBounds(153, 429, 92, 23);
		add(btnInport);

		btnTroLai = new JButton("TRỞ LẠI");
		btnTroLai.setForeground(new Color(255, 255, 224));
		btnTroLai.setBackground(new Color(0, 128, 128));
		btnTroLai.setBounds(253, 363, 83, 89);
	}

	public void loadTable() {
		QLThongBLL thongkeBLL = new QLThongBLL();
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

	public void loadTableTheoNgay() {
		Date selectedDate = (Date) datePicker.getModel().getValue();
		Date selectedDate1 = (Date) datePicker1.getModel().getValue();
		QLThongBLL thongkeBLL = new QLThongBLL();
		dsHoaDon = thongkeBLL.hienthiDsHoaDonTheoNgay(sdf.format(selectedDate), sdf.format(selectedDate1));
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
		QLThongBLL thongkeBLL = new QLThongBLL();
		DefaultTableModel dtm = new DefaultTableModel();
		String[] header = { "Tên món", "SL", "Đơn giá" };
		dtm.setColumnIdentifiers(header);
		for (Vector<String> ct : dsMon) {
			dtm.addRow(ct);
		}

		table.setModel(dtm);

		txtBanSo.setText(String.valueOf(dsHoaDon.get(rownumber).get(2)));
		txtKhuVucSo.setText(String.valueOf(dsHoaDon.get(rownumber).get(4)));
		txtBatDau.setText(String.valueOf(dsHoaDon.get(rownumber).get(6)));
		txtMaHD.setText(String.valueOf(dsHoaDon.get(rownumber).get(0)));
		txtThanhTien.setText(String.valueOf(dsHoaDon.get(rownumber).get(5)));
	}

	public void addEvents() {
		tblDSHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblDSHD.getSelectedRow();
				if (row != -1) {
					QLThongBLL thongKeBLL = new QLThongBLL();
					int ma_hoadon = Integer.parseInt((String) tblDSHD.getValueAt(row, 0));
					dsMon = thongKeBLL.hienthiDsMon(ma_hoadon);
					loadChiTietHD(row);
				}
			}
		});
		btnLc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadTableTheoNgay();
			}
		});

		btnTK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pieChart = createPieChart();
				pnThongKe.remove(chartPanel);
				chartPanel = new ChartPanel(pieChart);
				pnThongKe.add(chartPanel);
				chartPanel.setBounds(0, 0, 339, 300);
				changeTKTheoMon();
			}
		});

		btnTroLai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeTroLai();
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exportExcel();
			}
		});
		
		btnInport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Chức năng hiện đang bảo trì! \nHiển chỉ sử dụng được Xuất Excel!");
			}
		});
	}
	
	public void exportExcel() {
		 JFileChooser chooser = new JFileChooser();
		 int i = chooser.showSaveDialog(chooser);
		 if (i == JFileChooser.APPROVE_OPTION) {
		  File file = chooser.getSelectedFile();
		  try {
		   FileWriter out = new FileWriter(file + ".xls");
		   BufferedWriter bwrite = new BufferedWriter(out);
		   DefaultTableModel model = (DefaultTableModel) tblDSHD.getModel();
		   // ten Cot
		   for (int j = 0; j < tblDSHD.getColumnCount(); j++) {
		    bwrite.write(model.getColumnName(j) + "\t");
		   }
		   bwrite.write("\n");
		   // Lay du lieu dong
		   for (int j = 0; j < tblDSHD.getRowCount(); j++) {
		    for (int k = 0; k < tblDSHD.getColumnCount(); k++) {
		     bwrite.write(model.getValueAt(j, k) + "\t");
		    }
		    bwrite.write("\n");
		   }
		   bwrite.close();
		   JOptionPane.showMessageDialog(null, "Lưu file thành công!");
		  } catch (Exception e2) {
		   JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
		  }
		 }
		}

	private PieDataset createPieDataset() {
		QLThongBLL thongkeBLL = new QLThongBLL();
		double TongTien = 0;
		int tienThucAn = 0, tienNuocUong = 0;
		for (Vector<String> hoadonTK : dsHoaDon) {
			int ma_hoadon = Integer.parseInt(hoadonTK.get(0));
			Vector<Vector> dsMon = new Vector<Vector>();
			dsMon = thongkeBLL.hienthiDsMon(ma_hoadon);
			for (Vector<String> ct : dsMon) {
				if (ct.get(3).equals("1")) {
					tienNuocUong += Integer.parseInt(ct.get(1)) * Integer.parseInt(ct.get(2));
				}
				if (ct.get(3).equals("2")) {
					tienThucAn += Integer.parseInt(ct.get(1)) * Integer.parseInt(ct.get(2));
				}
			}
			TongTien += Double.parseDouble(hoadonTK.get(5));
		}
		txtTongDoanhThu.setText(String.valueOf(TongTien));
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Nước uống", new Double(tienNuocUong * 1.0 / TongTien));
		dataset.setValue("Thức ăn", new Double(tienThucAn * 1.0 / TongTien));
		return dataset;
	}

	public JFreeChart createPieChart() {
		String dateTu, dateDen, TK;
		Date selectedDate = (Date) datePicker.getModel().getValue();
		Date selectedDate1 = (Date) datePicker1.getModel().getValue();
		if (selectedDate == null || selectedDate1 == null) {
			TK = "Thống kê toàn bộ";
		} else {
			dateTu = sdf.format(selectedDate);
			dateDen = sdf.format(selectedDate1);
			TK = "Thống kê từ " + dateTu + " đến " + dateDen;
		}
		PieDataset dataset = createPieDataset();
		JFreeChart chart = ChartFactory.createPieChart(TK, dataset, true, true, true);
		return chart;
	}

	public void changeTKTheoMon() {
		this.remove(pnOrder);
		this.add(pnThongKe);
		this.add(btnTroLai);
		this.revalidate();
		this.repaint();
	}

	public void changeTroLai() {
		this.remove(pnThongKe);
		this.add(pnOrder);
		this.remove(btnTroLai);
		btnTK.setEnabled(true);
		this.revalidate();
		this.repaint();
	}
}
