package GUI.BanHang;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.border.MatteBorder;

import DTO.NhanVien;
import GUI.BanHang.BanVaKhuVuc.FormBanVaKhuVuc;
import GUI.BanHang.TaoHoaDon.FormChonBanKhuVuc;
import GUI.BanHang.ThongKe.FormThongKe;
import GUI.BanHang.ThucAnNuocUong.FormThucAnNuocUong;
import GUI.LoginForm.LoginForm;

import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class HomeForm extends JFrame {
	private NhanVien nhanvienthungan;
	int posX, posY, widthLeft;
	private int ma_nvthungan;
	private JPanel contentPane;
	private JPanel pnCreateOrder;
	JPanel pnHome, pnLogout;
	JPanel pnMain_home;
	JPanel pnRight;
	JPanel pnTableAndArea;
	JPanel pnDrinkAndFood;
	JPanel pnChange;
	private JLabel lblClose;
	private JLabel lblMinimize;
	private JPanel pnHeader;
	private JPanel pnStatistical;

	/**
	 * @wbp.parser.constructor
	 */
	public HomeForm(NhanVien nhanvienthungan) {
		this.nhanvienthungan = nhanvienthungan;
		initComponents();
		addEvents();
	}
	
	public void initComponents() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel pnLeft = new JPanel();
		pnLeft.setMaximumSize(new Dimension(8200, 32767));
		pnLeft.setBackground(new Color(0, 139, 139));
		contentPane.add(pnLeft);
		pnLeft.setBounds(0,0,170,500);
		pnLeft.setLayout(null);

		JLabel lblNewLabel = new JLabel("CAFE NHỎ");
		lblNewLabel.setBounds(0, 0, 170, 37);
		lblNewLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(37, 128, 128));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pnLeft.add(lblNewLabel);

		JPanel pnMenu = new JPanel();
		pnMenu.setBounds(0, 34, 201, 466);
		pnMenu.setOpaque(false);
		pnLeft.add(pnMenu);
		pnMenu.setLayout(null);

		JPanel pnAccount = new JPanel();
		pnAccount.setOpaque(false);
		pnAccount.setBounds(0, 0, 170, 163);
		pnMenu.add(pnAccount);
		pnAccount.setLayout(null);
		
		JLabel lblTenNhanVien = new JLabel(nhanvienthungan.getTenNV());
		lblTenNhanVien.setForeground(Color.WHITE);
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenNhanVien.setBounds(10, 39, 136, 21);
		pnAccount.add(lblTenNhanVien);
		
		JLabel lblMaNhanVien = new JLabel("ID: " + nhanvienthungan.getMaNV());
		lblMaNhanVien.setForeground(Color.WHITE);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNhanVien.setBounds(10, 74, 80, 14);
		pnAccount.add(lblMaNhanVien);

		JPanel pnOptions = new JPanel();
		pnOptions.setOpaque(false);
		pnOptions.setBounds(0, 163, 170, 303);
		pnMenu.add(pnOptions);
		pnOptions.setLayout(new GridLayout(4, 2, 0, 0));

		pnHome = new JPanel();
		pnHome.setOpaque(false);
		pnOptions.add(pnHome);
		GridBagLayout gbl_pnHome = new GridBagLayout();
		gbl_pnHome.columnWidths = new int[] { 30, 40, 130 };
		gbl_pnHome.rowHeights = new int[] { 64, 0 };
		gbl_pnHome.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_pnHome.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pnHome.setLayout(gbl_pnHome);

		JLabel lbl_iconHome = new JLabel("");
		lbl_iconHome.setIcon(new ImageIcon(HomeForm.class.getResource("/image/house-black-silhouette-without-door.png")));
		GridBagConstraints gbc_lbl_iconHome = new GridBagConstraints();
		gbc_lbl_iconHome.fill = GridBagConstraints.BOTH;
		gbc_lbl_iconHome.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_iconHome.gridx = 1;
		gbc_lbl_iconHome.gridy = 0;
		pnHome.add(lbl_iconHome, gbc_lbl_iconHome);
		JLabel lbl_home = new JLabel("Home");
		lbl_home.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_home.setForeground(Color.WHITE);
		GridBagConstraints gbc_lbl_home = new GridBagConstraints();
		gbc_lbl_home.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_home.fill = GridBagConstraints.BOTH;
		gbc_lbl_home.gridx = 2;
		gbc_lbl_home.gridy = 0;
		pnHome.add(lbl_home, gbc_lbl_home);

		pnLogout = new JPanel();
		pnLogout.setOpaque(false);
		pnOptions.add(pnLogout);
		GridBagLayout gbl_pnLogout = new GridBagLayout();
		gbl_pnLogout.columnWidths = new int[] { 30, 40, 130 };
		gbl_pnLogout.rowHeights = new int[] { 64, 0 };
		gbl_pnLogout.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_pnLogout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pnLogout.setLayout(gbl_pnLogout);

		JLabel lbl_iconHome_2 = new JLabel("");
		lbl_iconHome_2.setIcon(new ImageIcon(HomeForm.class.getResource("/image/logout.png")));
		GridBagConstraints gbc_lbl_iconHome_2 = new GridBagConstraints();
		gbc_lbl_iconHome_2.fill = GridBagConstraints.BOTH;
		gbc_lbl_iconHome_2.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_iconHome_2.gridx = 1;
		gbc_lbl_iconHome_2.gridy = 0;
		pnLogout.add(lbl_iconHome_2, gbc_lbl_iconHome_2);

		JLabel lbl_home_2 = new JLabel("Logout");
		lbl_home_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_home_2.setForeground(Color.WHITE);
		GridBagConstraints gbc_lbl_home_2 = new GridBagConstraints();
		gbc_lbl_home_2.fill = GridBagConstraints.BOTH;
		gbc_lbl_home_2.gridx = 2;
		gbc_lbl_home_2.gridy = 0;
		pnLogout.add(lbl_home_2, gbc_lbl_home_2);

		pnRight = new JPanel();
		pnRight.setBounds(169, 0, 830, 500);
		pnRight.setBorder(new EmptyBorder(0, 0, 0, 0));
		pnRight.setBackground(new Color(211, 211, 211));
		contentPane.add(pnRight);
		pnRight.setLayout(null);

		pnHeader = new JPanel();
		pnHeader.setBorder(null);
		pnHeader.setBackground(new Color(255, 255, 255));
		pnHeader.setBounds(0, 0, 830, 37);
		pnRight.add(pnHeader);
		pnHeader.setLayout(null);
		
		lblMinimize = new JLabel("-");
		lblMinimize.setBounds(744, 0, 43, 37);
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(new Color(0, 128, 128));
		lblMinimize.setFont(new Font("Tahoma", Font.PLAIN, 21));
		pnHeader.add(lblMinimize);
		
		lblClose = new JLabel("x");
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setForeground(new Color(0, 128, 128));
		lblClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClose.setBackground(new Color(255, 255, 255));
		lblClose.setBounds(787, 0, 43, 37);
		pnHeader.add(lblClose);

		pnMain_home = new JPanel();
		pnMain_home.setOpaque(false);
		pnMain_home.setBounds(0, 37, 830, 463);
		pnRight.add(pnMain_home);
		pnMain_home.setLayout(null);

		pnCreateOrder = new JPanel();
		pnCreateOrder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnCreateOrder.setLayout(null);
		pnCreateOrder.setBackground(Color.WHITE);
		pnCreateOrder.setBounds(69, 53, 285, 138);
		pnMain_home.add(pnCreateOrder);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(HomeForm.class.getResource("/image/add-package.png")));
		lblNewLabel_2_1.setBounds(106, 0, 73, 89);
		pnCreateOrder.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("T\u1EA0O HO\u00C1 \u0110\u01A0N");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(13, 100, 262, 38);
		pnCreateOrder.add(lblNewLabel_3_1);

		pnTableAndArea = new JPanel();

		pnTableAndArea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnTableAndArea.setLayout(null);
		pnTableAndArea.setBackground(Color.WHITE);
		pnTableAndArea.setBounds(450, 53, 263, 138);
		pnMain_home.add(pnTableAndArea);

		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(HomeForm.class.getResource("/image/chair.png")));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(71, 0, 121, 89);
		pnTableAndArea.add(lblNewLabel_2_2);

		JLabel lblNewLabel_3_2 = new JLabel("B\u00C0N & KHU V\u1EF0C");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(13, 100, 240, 38);
		pnTableAndArea.add(lblNewLabel_3_2);

		pnDrinkAndFood = new JPanel();

		pnDrinkAndFood.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnDrinkAndFood.setLayout(null);
		pnDrinkAndFood.setBackground(Color.WHITE);
		pnDrinkAndFood.setBounds(450, 263, 263, 138);
		pnMain_home.add(pnDrinkAndFood);

		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon(HomeForm.class.getResource("/image/fast-food.png")));
		lblNewLabel_2_3.setBounds(93, 0, 76, 88);
		pnDrinkAndFood.add(lblNewLabel_2_3);

		JLabel lblNewLabel_3_3 = new JLabel("TH\u1EE8C \u0102N, N\u01AF\u1EDAC U\u1ED0NG");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setForeground(new Color(0, 139, 139));
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3_3.setBounds(23, 99, 230, 39);
		pnDrinkAndFood.add(lblNewLabel_3_3);

		//

		pnChange = pnMain_home;
		
		pnStatistical = new JPanel();
		pnStatistical.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		pnStatistical.setLayout(null);
		pnStatistical.setBackground(Color.WHITE);
		pnStatistical.setBounds(69, 263, 285, 138);
		pnMain_home.add(pnStatistical);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("");
		lblNewLabel_2_3_1.setIcon(new ImageIcon(HomeForm.class.getResource("/image/trend.png")));
		lblNewLabel_2_3_1.setBounds(106, 0, 72, 88);
		pnStatistical.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("TH\u1ED0NG K\u00CA HO\u00C1 \u0110\u01A0N");
		lblNewLabel_3_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_3_3_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3_3_1.setBounds(23, 99, 240, 39);
		pnStatistical.add(lblNewLabel_3_3_1);
		widthLeft = (int) pnLeft.getPreferredSize().getWidth();
	}

	public void addEvents() {
		//Move
		pnHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX = e.getX();
				posY = e.getY();
			}
		});
		pnHeader.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int positionX = e.getXOnScreen();
				int positionY = e.getYOnScreen();
				moveWindow(positionX - posX - 210, positionY - posY);
			}
		});
		//Mini, max
		lblClose.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblClose.setBackground(new Color(0, 128, 128));
				lblClose.setOpaque(true);
				lblClose.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblClose.setOpaque(false);
				lblClose.setBackground(new Color(255, 255, 255));
				lblClose.setForeground(new Color(0, 128, 128));
			}
		});

		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimize.setBackground(new Color(0, 128, 128));
				lblMinimize.setOpaque(true);
				lblMinimize.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimize.setOpaque(false);
				lblMinimize.setBackground(new Color(255, 255, 255));
				lblMinimize.setForeground(new Color(0, 128, 128));
			}
		});
		// Menu
		pnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				homeUI();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				pnHome.setOpaque(true);
				pnHome.setBackground(new Color(37, 79, 79));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnHome.setOpaque(false);
				pnHome.setBackground(new Color(0, 139, 139));
				
			}
		});
		
		pnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logout();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				pnLogout.setOpaque(true);
				pnLogout.setBackground(new Color(37, 79, 79));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnLogout.setOpaque(false);
				pnLogout.setBackground(new Color(0, 139, 139));
				
			}
		});

		pnCreateOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToFormChonBanKhuVuc();
			}
		});
		
		pnTableAndArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToFormBanVaKhuVuc();
			}
		});
		
		pnDrinkAndFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToFoodAndDrink();
			}
		});
		
		pnStatistical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToFormThongKe();
			}
		});

		
	}
	public void moveWindow(int positionX, int positionY) {
		this.setLocation(positionX, positionY);
	}
	
	public void logout() {
		LoginForm loginUI = new LoginForm();
		loginUI.setVisible(true);
		this.dispose();
	}

	// Menu UI
	public void homeUI() { // Home UI
		pnRight.remove(pnChange);
		pnRight.add(pnMain_home);
		this.revalidate();
		this.repaint();
	}
	
	public void changeToFormThongKe() {
		FormThongKe pnFormThongKe = new FormThongKe(nhanvienthungan);
		pnChange = pnFormThongKe;
		pnRight.remove(pnMain_home);
		pnRight.add(pnChange);
		this.revalidate();
		this.repaint();
	}

	public void changeToFormChonBanKhuVuc() {
		FormChonBanKhuVuc pnFormChonBanKhuVuc = new FormChonBanKhuVuc(nhanvienthungan);
		pnChange = pnFormChonBanKhuVuc;
		pnRight.remove(pnMain_home);
		pnRight.add(pnChange);
		this.revalidate();
		this.repaint();
	}
	
	public void changeToFoodAndDrink() {
		FormThucAnNuocUong pnFormThucAnNuocUong = new FormThucAnNuocUong(nhanvienthungan);
		pnChange = pnFormThucAnNuocUong;
		pnRight.remove(pnMain_home);
		pnRight.add(pnChange);
		this.revalidate();
		this.repaint();
	}
	
	public void changeToFormBanVaKhuVuc() {
		FormBanVaKhuVuc pnFormBanVaKhuVuc = new FormBanVaKhuVuc(nhanvienthungan);
		pnChange = pnFormBanVaKhuVuc;
		pnRight.remove(pnMain_home);
		pnRight.add(pnChange);
		this.revalidate();
		this.repaint();
	}
}

