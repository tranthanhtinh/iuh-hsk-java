package tuan2_PhepTinh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GUIPhepTinh extends JFrame implements ActionListener{
	
	private JTextField txtA;
	private JTextField txtB;
	private JRadioButton radCong;
	private JRadioButton radTru;
	private JRadioButton radNhan;
	private JRadioButton radChia;
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JTextField txtKq;
	private ButtonGroup grpPhepTinh;


	public GUIPhepTinh(String title) {
		this.setTitle(title);
	}
	
	private void doShow() {
		this.setSize(600, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addControl();
		this.setVisible(true);
	}
	
	//Xác định layout của ứng dụng theo kiểu nào
	private void addControl() {
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		//Top
		JPanel pnTop = new JPanel();
		JLabel lblTitle = new JLabel("Cộng Trừ Nhân Chia");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("arial", Font.BOLD, 25));
		pnTop.add(lblTitle);
		
		pnMain.add(pnTop, BorderLayout.NORTH);
		
		//Left
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));//Đổ các button theo chiều đứng
		
		btnGiai = new JButton("  Giải ");
		btnGiai.setMnemonic(KeyEvent.VK_G);
		btnGiai.setPreferredSize(new Dimension(80, 30));
		
		btnXoa = new JButton("  Xóa ");
		btnGiai.setMnemonic(KeyEvent.VK_X);
		
		btnThoat = new JButton("Thoát");
		btnGiai.setMnemonic(KeyEvent.VK_T);
		
		pnLeft.setBackground(Color.LIGHT_GRAY);
		
		pnLeft.add(btnGiai);
		pnLeft.add(Box.createVerticalStrut(10));//add 1 cái box để giãn cách button
		
		pnLeft.add(btnXoa);
		pnLeft.add(Box.createVerticalStrut(10));
		
		pnLeft.add(btnThoat);
		
		//Tạo border panel
		Border leftBorder = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder leftTitleBorder = new TitledBorder(leftBorder, "Chọn tác vụ");
		pnLeft.setBorder(leftTitleBorder);
		pnLeft.setPreferredSize(new Dimension(100, 0));// 0 = free size
		
		pnMain.add(pnLeft, BorderLayout.WEST);
		
		//Center
		JPanel pnCenter = new JPanel();
		Border centerBorder = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder centerTitleBorder = new TitledBorder(centerBorder, "Tính toán");
		pnCenter.setBorder(centerTitleBorder);
		
		//panel Nhap A
		JPanel pnA = new JPanel();
		JLabel lblA = new JLabel("Nhập a: ");
		txtA = new JTextField(20);
		pnA.add(lblA);
		pnA.add(txtA);
		pnCenter.add(pnA);
		
		//panel Nhap B
		JPanel pnB = new JPanel();
		JLabel lblB = new JLabel("Nhập b: ");
		txtB = new JTextField(20);
		pnB.add(lblB);
		pnB.add(txtB);
		pnCenter.add(pnB);
		
		//panel Phép Tính
		JPanel pnC = new JPanel();
		JPanel pnPhepTinh = new JPanel();
		pnPhepTinh.setPreferredSize(new Dimension(260, 100));
		pnPhepTinh.setLayout(new GridLayout(2,2));
		
		Border ptBorder = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder ptTitleBorder = new TitledBorder(ptBorder, "Phép tính");
		pnPhepTinh.setBorder(ptTitleBorder);
		
		radCong = new JRadioButton("Cộng");
		pnPhepTinh.add(radCong);
		
		radTru = new JRadioButton("Trừ");
		pnPhepTinh.add(radTru);
		
		radNhan = new JRadioButton("Nhân");
		pnPhepTinh.add(radNhan);
		
		radChia = new JRadioButton("Chia");
		pnPhepTinh.add(radChia);
		
		grpPhepTinh = new ButtonGroup();
		grpPhepTinh.add(radCong);
		grpPhepTinh.add(radTru);
		grpPhepTinh.add(radNhan);
		grpPhepTinh.add(radChia);
		
		pnC.add(pnPhepTinh);
		pnCenter.add(pnC);
		
		//panel Kết quả
		JPanel pnKq = new JPanel();
		JLabel lblKq = new JLabel("Kết quả: ");
		txtKq = new JTextField(20);
		txtKq.setEditable(false);
		
		pnKq.add(lblKq);
		pnKq.add(txtKq);
		pnCenter.add(pnKq);
		
		pnMain.add(pnCenter, BorderLayout.CENTER);
		
		//bottom
		JPanel pnBottom = new JPanel();
		pnBottom.setBackground(Color.PINK);
		pnBottom.setPreferredSize(new Dimension(0, 50));
		
		JPanel pnBlue = new JPanel();
		pnBlue.setPreferredSize(new Dimension(30, 30));
		pnBlue.setBackground(Color.BLUE);
		pnBottom.add(pnBlue);
		
		JPanel pnRed = new JPanel();
		pnRed.setPreferredSize(new Dimension(30, 30));
		pnRed.setBackground(Color.RED);
		pnBottom.add(pnRed);
		
		JPanel pnYellow = new JPanel();
		pnYellow.setPreferredSize(new Dimension(30, 30));
		pnYellow.setBackground(Color.YELLOW);
		pnBottom.add(pnYellow);
		
		pnMain.add(pnBottom, BorderLayout.SOUTH);
		this.add(pnMain);
		
		//add event buttons
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		
		radCong.addActionListener(this);
		radTru.addActionListener(this);
		radNhan.addActionListener(this);
		radChia.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		GUIPhepTinh gui = new GUIPhepTinh("Các phép tính");
		gui.doShow();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj.equals(btnGiai)) {
			if(txtA.getText().trim().equals("") || txtB.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
			else {
				int a = Integer.parseInt(txtA.getText());
				int b = Integer.parseInt(txtB.getText());
				
				if(radCong.isSelected())
					txtKq.setText(PhepTinh.TinhToan(a, b, "Cộng"));
				if(radTru.isSelected())
					txtKq.setText(PhepTinh.TinhToan(a, b, "Trừ"));
				if(radNhan.isSelected())
					txtKq.setText(PhepTinh.TinhToan(a, b, "Nhân"));
				if(radChia.isSelected())
					txtKq.setText(PhepTinh.TinhToan(a, b, "Chia"));
			}
		}
		if(obj.equals(btnXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtKq.setText("");
			grpPhepTinh.clearSelection();
		}
		if(obj.equals(btnThoat)) {
			int choose = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thoat?", "Hỏi", JOptionPane.YES_NO_OPTION);
			if(choose == 0)
				System.exit(0);
		}
	}
}
