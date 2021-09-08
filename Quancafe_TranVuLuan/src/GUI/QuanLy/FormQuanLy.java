package GUI.QuanLy;

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

import GUI.BanHang.BanVaKhuVuc.FormBanVaKhuVuc;
import GUI.BanHang.TaoHoaDon.FormChonBanKhuVuc;
import GUI.BanHang.ThongKe.FormThongKe;
import GUI.BanHang.ThucAnNuocUong.FormThucAnNuocUong;
import GUI.LoginForm.LoginForm;
import GUI.QuanLy.QLBanKhuVuc.FormQLBanKhuVuc;
import GUI.QuanLy.QLMon.FormQLMon;
import GUI.QuanLy.QLNhanVien.FormQLNhanVien;
import GUI.QuanLy.QLThongKe.FormQLThongKe;

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

public class FormQuanLy extends JFrame {
	int posX, posY, widthLeft;
	private String username;
	private int ma_nvthungan;
	private JPanel contentPane;
	private JPanel pnNhanVien;
	JPanel pnHome, pnLogout;
	JPanel pnMain_home;
	JPanel pnRight;
	JPanel pnBanKhuVuc;
	JPanel pnFoodDrink;
	JPanel pnChange;
	private JLabel lblClose;
	private JLabel lblMinimize;
	private JPanel pnHeader;
	private JPanel pnStatistical;

	/**
	 * @wbp.parser.constructor
	 */
	public FormQuanLy(String username) {
		this.username = username;
		initComponents();
		addEvents();
	}
	
	public FormQuanLy() {
		initComponents();
		addEvents();
	}
	
	public FormQuanLy(int ma_nvthungan) {
		this.ma_nvthungan = ma_nvthungan;
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

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setBounds(59, 58, 83, 94);
		pnAccount.add(lblNewLabel_1);

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
		lbl_iconHome.setIcon(new ImageIcon(FormQuanLy.class.getResource("/image/house-black-silhouette-without-door.png")));
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
		lbl_iconHome_2.setIcon(new ImageIcon(FormQuanLy.class.getResource("/image/logout.png")));
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

		pnNhanVien = new JPanel();
		pnNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnNhanVien.setLayout(null);
		pnNhanVien.setBackground(Color.WHITE);
		pnNhanVien.setBounds(69, 53, 285, 138);
		pnMain_home.add(pnNhanVien);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(FormQuanLy.class.getResource("/image/employee.png")));
		lblNewLabel_2_1.setBounds(106, 0, 73, 89);
		pnNhanVien.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(13, 100, 262, 38);
		pnNhanVien.add(lblNewLabel_3_1);

		pnBanKhuVuc = new JPanel();

		pnBanKhuVuc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnBanKhuVuc.setLayout(null);
		pnBanKhuVuc.setBackground(Color.WHITE);
		pnBanKhuVuc.setBounds(450, 53, 263, 138);
		pnMain_home.add(pnBanKhuVuc);

		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(FormQuanLy.class.getResource("/image/chair.png")));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(71, 0, 121, 89);
		pnBanKhuVuc.add(lblNewLabel_2_2);

		JLabel lblNewLabel_3_2 = new JLabel("QUẢN LÝ BÀN & KHU VỰC");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(13, 100, 240, 38);
		pnBanKhuVuc.add(lblNewLabel_3_2);

		pnFoodDrink = new JPanel();

		pnFoodDrink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnFoodDrink.setLayout(null);
		pnFoodDrink.setBackground(Color.WHITE);
		pnFoodDrink.setBounds(450, 263, 263, 138);
		pnMain_home.add(pnFoodDrink);

		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon(FormQuanLy.class.getResource("/image/fast-food.png")));
		lblNewLabel_2_3.setBounds(93, 0, 76, 88);
		pnFoodDrink.add(lblNewLabel_2_3);

		JLabel lblNewLabel_3_3 = new JLabel("QUẢN LÝ THỨC ĂN, NƯỚC UỐNG");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setForeground(new Color(0, 139, 139));
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_3_3.setBounds(23, 99, 230, 39);
		pnFoodDrink.add(lblNewLabel_3_3);

		//

		pnChange = pnMain_home;
		
		pnStatistical = new JPanel();

		pnStatistical.setLayout(null);
		pnStatistical.setBackground(Color.WHITE);
		pnStatistical.setBounds(69, 263, 285, 138);
		pnMain_home.add(pnStatistical);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("");
		lblNewLabel_2_3_1.setIcon(new ImageIcon(FormQuanLy.class.getResource("/image/trend.png")));
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

		pnNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToFormQLNhanVien();			}
		});
		
		pnBanKhuVuc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToFormQLBanKhuVuc();
			}
		});
		
		pnFoodDrink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToFormQLMon();
			}
		});
		
		pnStatistical.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				changeToFormQLThongKe();
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
	
	public void changeToFormQLNhanVien() {
		FormQLNhanVien pnFormQLNhanVien = new FormQLNhanVien();
		pnChange = pnFormQLNhanVien;
		pnRight.remove(pnMain_home);
		pnRight.add(pnChange);
		this.revalidate();
		this.repaint();
	}
	
	public void changeToFormQLThongKe() {
		FormQLThongKe pnFormQLThongKe = new FormQLThongKe();
		pnChange = pnFormQLThongKe;
		pnRight.remove(pnMain_home);
		pnRight.add(pnChange);
		this.revalidate();
		this.repaint();
	}

	public void changeToFormQLBanKhuVuc() {
		FormQLBanKhuVuc pnFormQLBanKhuVuc = new FormQLBanKhuVuc(ma_nvthungan);
		pnChange = pnFormQLBanKhuVuc;
		pnRight.remove(pnMain_home);
		pnRight.add(pnChange);
		this.revalidate();
		this.repaint();
	}
	
	public void changeToFormQLMon() {
		FormQLMon pnFormQLMon = new FormQLMon();
		pnChange = pnFormQLMon;
		pnRight.remove(pnMain_home);
		pnRight.add(pnChange);
		this.revalidate();
		this.repaint();
	}
	
}

