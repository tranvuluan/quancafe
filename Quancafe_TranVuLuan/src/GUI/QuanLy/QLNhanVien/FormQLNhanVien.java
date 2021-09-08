package GUI.QuanLy.QLNhanVien;

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
import BLL.QuanLy.QLNhanVien.QLNhanVienBLL;
import BLL.QuanLy.QLThongKe.QLThongBLL;
import DTO.Mon;
import DTO.NhanVien;
import GUI.BanHang.TaoHoaDon.FormChonBanKhuVuc;
import GUI.BanHang.TaoHoaDon.FormChonMon;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.*;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class FormQLNhanVien extends JPanel {
	private JPanel pnOptions;
	private int ma_nvthungan;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JPanel pnOrder;
	private JTable tblDsNhanVien;
	private JLabel lblNgySinh;
	private JLabel lblMNv;
	private JLabel lblSinThoi;
	private JLabel lblaCh;
	private JLabel lblNgyLm;
	private JLabel lblUsername;
	private JLabel lblNgySinh_1;
	private JLabel lblChcV;
	private JButton btnThemNhanVien;
	private JButton btnSuaThongTin;
	private JButton btnXoaNhanVien;
	private JTextField txtMaNV;
	private JTextField txtCMND;
	private JTextField txtNgaySinh;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtNgayLam;
	private JTextField txtUserName;
	private JTextField txtChucVu;
	private JTextField txtTenNV;
	private JLabel lblTnNv;
	private JPanel pnDetails;
	private JButton btnExportExcel;
	private JButton btnTimKiem;
	private JTextField txtTimKiem;
	private JButton btnImport;

	public FormQLNhanVien() {
		initComponents();
		addEvents();
		loadTable();
	}

	public FormQLNhanVien(int ma_nvthungan) {
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
		pnOrder.setBounds(0, 0, 332, 463);
		add(pnOrder);
		pnOrder.setLayout(null);

		pnDetails = new JPanel();
		pnDetails.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 128, 128)));
		pnDetails.setBounds(0, 347, 329, 116);
		pnOrder.add(pnDetails);
		pnDetails.setLayout(null);

		btnThemNhanVien = new JButton("Thêm nhân viên");
		btnThemNhanVien.setForeground(new Color(255, 255, 224));
		btnThemNhanVien.setBackground(new Color(0, 128, 128));
		btnThemNhanVien.setBounds(26, 11, 124, 30);
		pnDetails.add(btnThemNhanVien);

		btnSuaThongTin = new JButton("Sửa thông tin");

		btnSuaThongTin.setForeground(new Color(255, 255, 224));
		btnSuaThongTin.setBackground(new Color(0, 128, 128));
		btnSuaThongTin.setBounds(181, 11, 124, 30);
		pnDetails.add(btnSuaThongTin);

		btnXoaNhanVien = new JButton("Xoá nhân viên");
		btnXoaNhanVien.setForeground(new Color(255, 255, 224));
		btnXoaNhanVien.setBackground(new Color(0, 128, 128));
		btnXoaNhanVien.setBounds(26, 63, 124, 30);
		pnDetails.add(btnXoaNhanVien);

		btnExportExcel = new JButton("Xuất Excel");

		btnExportExcel.setForeground(new Color(255, 255, 224));
		btnExportExcel.setBackground(new Color(0, 128, 128));
		btnExportExcel.setBounds(181, 67, 124, 30);
		pnDetails.add(btnExportExcel);

		JPanel pnAction = new JPanel();
		pnAction.setBounds(0, 0, 329, 347);
		pnOrder.add(pnAction);
		pnAction.setLayout(null);

		txtCMND = new JTextField();
		txtCMND.setEditable(false);
		txtCMND.setColumns(10);
		txtCMND.setBounds(88, 96, 227, 29);
		pnAction.add(txtCMND);

		lblNgySinh = new JLabel("CMND");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgySinh.setBounds(25, 95, 53, 27);
		pnAction.add(lblNgySinh);

		lblMNv = new JLabel("Mã NV");
		lblMNv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMNv.setBounds(25, 11, 45, 27);
		pnAction.add(lblMNv);

		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(69, 12, 70, 29);
		pnAction.add(txtMaNV);

		lblSinThoi = new JLabel("SĐT");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinThoi.setBounds(25, 176, 53, 27);
		pnAction.add(lblSinThoi);

		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(88, 176, 227, 29);
		pnAction.add(txtSDT);

		lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblaCh.setBounds(25, 216, 63, 27);
		pnAction.add(lblaCh);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(88, 216, 227, 29);
		pnAction.add(txtDiaChi);

		lblNgyLm = new JLabel("Ngày vào làm");
		lblNgyLm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgyLm.setBounds(25, 265, 96, 27);
		pnAction.add(lblNgyLm);

		txtNgayLam = new JTextField();
		txtNgayLam.setEditable(false);
		txtNgayLam.setColumns(10);
		txtNgayLam.setBounds(131, 265, 184, 29);
		pnAction.add(txtNgayLam);

		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(149, 11, 70, 27);
		pnAction.add(lblUsername);

		txtUserName = new JTextField();
		txtUserName.setEditable(false);
		txtUserName.setColumns(10);
		txtUserName.setBounds(216, 12, 103, 29);
		pnAction.add(txtUserName);

		lblNgySinh_1 = new JLabel("Ngày sinh");
		lblNgySinh_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgySinh_1.setBounds(25, 135, 63, 27);
		pnAction.add(lblNgySinh_1);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(98, 135, 217, 29);
		pnAction.add(txtNgaySinh);

		lblChcV = new JLabel("Chức vụ");
		lblChcV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChcV.setBounds(25, 305, 53, 27);
		pnAction.add(lblChcV);

		txtChucVu = new JTextField();
		txtChucVu.setEditable(false);
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(88, 305, 227, 29);
		pnAction.add(txtChucVu);

		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(88, 56, 227, 29);
		pnAction.add(txtTenNV);

		lblTnNv = new JLabel("Tên NV");
		lblTnNv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnNv.setBounds(25, 55, 53, 27);
		pnAction.add(lblTnNv);

		pnOptions = new JPanel();
		pnOptions.setBounds(340, 11, 490, 452);
		add(pnOptions);

		DefaultTableModel dtmHD = new DefaultTableModel();
		String[] headerHD = { "Mã NV", "Tên NV", "SĐT", "Chức vụ" };
		dtmHD.setColumnIdentifiers(headerHD);
		pnOptions.setLayout(null);
		tblDsNhanVien = new JTable();

		tblDsNhanVien.setBounds(0, 0, 486, 300);
		tblDsNhanVien.setModel(dtmHD);
		JScrollPane sc1 = new JScrollPane(tblDsNhanVien, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sc1.setBounds(0, 0, 490, 383);
		pnOptions.add(sc1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 394, 490, 58);
		pnOptions.add(panel);
		panel.setLayout(null);
		
		btnTimKiem = new JButton("LỌC");
		btnTimKiem.setBounds(192, 10, 106, 30);
		btnTimKiem.setForeground(new Color(255, 255, 224));
		btnTimKiem.setBackground(new Color(0, 128, 128));
		panel.add(btnTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(10, 10, 142, 26);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnImport = new JButton("Nhập Excel");
		btnImport.setForeground(new Color(255, 255, 224));
		btnImport.setBackground(new Color(0, 128, 128));
		btnImport.setBounds(338, 10, 142, 30);
		panel.add(btnImport);

	}

	public void loadTable() {
		QLNhanVienBLL qlNhanVien = new QLNhanVienBLL();
		Vector<NhanVien> dsNhanVien = new Vector<NhanVien>();
		dsNhanVien = qlNhanVien.hienthiDsNhanVien();
		DefaultTableModel dtm = new DefaultTableModel();
		String[] header = { "Mã NV", "Tên NV", "SĐT", "Chức vụ" };
		dtm.setColumnIdentifiers(header);
		for (NhanVien nv : dsNhanVien) {
			Vector<String> item = new Vector<String>();
			item.add(String.valueOf(nv.getMaNV()));
			item.add(nv.getTenNV());
			item.add(nv.getSdtNV());
			item.add(nv.getChucvu());
			dtm.addRow(item);
		}
		tblDsNhanVien.setModel(dtm);
	}
	
	public void loadTableTheoTimKiem(Vector<NhanVien> dsNhanVien) {
		DefaultTableModel dtm = new DefaultTableModel();
		String[] header = { "Mã NV", "Tên NV", "SĐT", "Chức vụ" };
		dtm.setColumnIdentifiers(header);
		for (NhanVien nv : dsNhanVien) {
			Vector<String> item = new Vector<String>();
			item.add(String.valueOf(nv.getMaNV()));
			item.add(nv.getTenNV());
			item.add(nv.getSdtNV());
			item.add(nv.getChucvu());
			dtm.addRow(item);
		}
		tblDsNhanVien.setModel(dtm);
		
	}

	public void loadTableDetails(NhanVien nv) {
		txtMaNV.setText(String.valueOf(nv.getMaNV()));
		txtUserName.setText(nv.getUsername());
		txtTenNV.setText(nv.getTenNV());
		txtNgaySinh.setText(String.valueOf(nv.getNgaysinh()));
		txtNgayLam.setText(String.valueOf(nv.getNgayVaoLam()));
		txtSDT.setText(nv.getSdtNV());
		txtDiaChi.setText(nv.getDiachi());
		txtChucVu.setText(nv.getChucvu());
		txtCMND.setText(nv.getCMND());
	}

	public void addEvents() {
		tblDsNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tblDsNhanVien.getSelectedRow();
				if (row != -1) {
					QLNhanVienBLL qlNhanVien = new QLNhanVienBLL();
					NhanVien nv = new NhanVien();
					int ma_nhanvien = Integer.parseInt((String) tblDsNhanVien.getValueAt(row, 0));
					nv = qlNhanVien.nhanvien(ma_nhanvien);
					loadTableDetails(nv);
				}
			}
		});
		btnSuaThongTin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtMaNV.getText().equals(""))
					return;
				btnSuaThongTin.setVisible(false);
				btnXoaNhanVien.setVisible(false);
				btnThemNhanVien.setVisible(false);

				txtCMND.setEditable(true);
				txtDiaChi.setEditable(true);
				txtNgayLam.setEditable(true);
				txtNgaySinh.setEditable(true);
				txtSDT.setEditable(true);
				txtTenNV.setEditable(true);
				JButton confirmSua = new JButton("Xác nhận");
				confirmSua.setBounds(btnSuaThongTin.getBounds());
				pnDetails.add(confirmSua);
				confirmSua.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						QLNhanVienBLL qlNhanVienBLL = new QLNhanVienBLL();
						qlNhanVienBLL.suaNhanVien(txtTenNV.getText(), txtCMND.getText(), txtDiaChi.getText(),
								txtSDT.getText(), txtNgaySinh.getText(), txtNgayLam.getText());
						if (txtChucVu.getText().equals("Nhân viên thu ngân")) {
							int rs = JOptionPane.showConfirmDialog(null, "Sửa mật khẩu của tài khoản ?");
							if (rs == 0) {
								String username = txtUserName.getText();
								String password = JOptionPane.showInputDialog("Password");
								qlNhanVienBLL.suaMatKhau(username, password);
							}
						}

						////
						btnSuaThongTin.setVisible(true);
						btnXoaNhanVien.setVisible(true);
						btnThemNhanVien.setVisible(true);
						confirmSua.setVisible(false);
						loadTable();
					}
				});

			}
		});

		btnThemNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] selectionValues = { "Nhân viên phục vụ", "Nhân viên thu ngân" };
				String initialSelection = "Nhân viên phục vụ";
				Object selection = JOptionPane.showInputDialog(null, "Chọn chức vụ?", "Chức vụ",
						JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				txtCMND.setEditable(true);
				txtDiaChi.setEditable(true);
				txtNgayLam.setEditable(true);
				txtNgaySinh.setEditable(true);
				txtSDT.setEditable(true);
				txtTenNV.setEditable(true);
				if (selection.equals("Nhân viên phục vụ")) {
					txtMaNV.setText("");
					txtUserName.setText("");
					txtCMND.setText("");
					txtDiaChi.setText("");
					txtNgayLam.setText("");
					txtNgaySinh.setText("");
					txtSDT.setText("");
					txtTenNV.setText("");
					txtChucVu.setText("Nhân viên phục vụ");
				} else {
					txtUserName.setText("");
					txtMaNV.setText("");
					txtCMND.setText("");
					txtDiaChi.setText("");
					txtNgayLam.setText("");
					txtNgaySinh.setText("");
					txtSDT.setText("");
					txtTenNV.setText("");
					txtChucVu.setText("Nhân viên thu ngân");
				}
				btnSuaThongTin.setVisible(false);
				btnXoaNhanVien.setVisible(false);
				btnThemNhanVien.setVisible(false);
				JButton btnXacNhan = new JButton("Xác nhận");
				btnXacNhan.setBounds(btnThemNhanVien.getBounds());
				pnDetails.add(btnXacNhan);
				btnXacNhan.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (txtTenNV.getText().equals("") || txtChucVu.getText().equals("")
								|| txtCMND.getText().equals("") || txtDiaChi.getText().equals("")
								|| txtNgayLam.getText().equals("") || txtNgaySinh.getText().equals("")
								|| txtSDT.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!");
						} else {
							NhanVien nv = new NhanVien();
							if (txtChucVu.getText().equals("Nhân viên thu ngân")) {
								String username = createAccount();
								nv.setUsername(username);
							}
							nv.setTenNV(txtTenNV.getText());
							nv.setSdtNV(txtSDT.getText());
							nv.setDiachi(txtDiaChi.getText());
							nv.setCMND(txtCMND.getText());
							nv.setChucvu(txtChucVu.getText());
							QLNhanVienBLL qlNhanVienBLL = new QLNhanVienBLL();
							qlNhanVienBLL.addNhanVien(nv, txtNgaySinh.getText(), txtNgayLam.getText());
							btnSuaThongTin.setVisible(true);
							btnXoaNhanVien.setVisible(true);
							btnThemNhanVien.setVisible(true);
							btnXacNhan.setVisible(false);
							loadTable();
						}
					}
				});
			}
		});
		btnXoaNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!txtMaNV.getText().equals("")) {
					int rs = JOptionPane.showConfirmDialog(null, "Xác nhận xoá nhân viên");
					if (rs == 0) {
						int ma_nhanvien = Integer.parseInt(txtMaNV.getText());
						QLNhanVienBLL qlNhanVienBLL = new QLNhanVienBLL();
						qlNhanVienBLL.deleteNhanVien(ma_nhanvien);
						loadTable();
					}
				}
			}
		});

		btnExportExcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exportExcel();
			}
		});
		
		btnTimKiem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String noidung = txtTimKiem.getText();
				QLNhanVienBLL qlNhanVien = new QLNhanVienBLL();
				Vector<NhanVien> dsNhanVien = new Vector<NhanVien>();
				dsNhanVien = qlNhanVien.hienthiDsNhanVienTheoTimKiem(noidung);
				loadTableTheoTimKiem(dsNhanVien);
			}
		});
		
		btnImport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Chức năng Import đang bảo trì!\n Hiện tại chỉ sử dụng được chính năng Export Excel !");
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
				DefaultTableModel model = (DefaultTableModel) tblDsNhanVien.getModel();
				// ten Cot
				for (int j = 0; j < tblDsNhanVien.getColumnCount(); j++) {
					bwrite.write(model.getColumnName(j) + "\t");
				}
				bwrite.write("\n");
				// Lay du lieu dong
				for (int j = 0; j < tblDsNhanVien.getRowCount(); j++) {
					for (int k = 0; k < tblDsNhanVien.getColumnCount(); k++) {
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
	

	public String createAccount() {
		String username = "";
		QLNhanVienBLL qlNhanVienBLL = new QLNhanVienBLL();
		while (true) {
			username = JOptionPane.showInputDialog("Nhập username:");
			int checkUsername = qlNhanVienBLL.checkAccount(username);
			if (checkUsername == 1)
				break;
			else
				JOptionPane.showMessageDialog(null, "Username đã tồn tại!");
		}
		String password = JOptionPane.showInputDialog("Nhập password:");

		// Lưu account vào csdl
		boolean rs = false;
		rs = qlNhanVienBLL.addUserAccount(username, password);
		return username;
	}
}
