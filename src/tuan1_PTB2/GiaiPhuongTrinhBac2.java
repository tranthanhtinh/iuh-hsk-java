/**
 * 
 */
package tuan1_PTB2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * @author Student LeTuan
 *
 */
public class GiaiPhuongTrinhBac2 extends JFrame implements ActionListener{
	
	private JTextField txtNhapA;
	private JTextField txtNhapB;
	private JTextField txtNhapC;
	private JTextField txtKetQua;
	private JButton btnGiai;
	private JButton btnXoaRong;
	private JButton btnThoat;
	
	public GiaiPhuongTrinhBac2(String title) {
		this.setTitle(title);
	}
	
	private void doShow() {
		//setting frame
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		addControl();
		this.setVisible(true);
	}
	
	private void addControl() {
		Panel p = new Panel();
		p.setLayout(null);
		
		//top title
		JLabel lblTitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		lblTitle.setSize(500, 50);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);//center text => chiều ngang
		lblTitle.setOpaque(true);//alow setting background label
		lblTitle.setBackground(Color.CYAN);
		lblTitle.setFont(new Font("Helvetica", Font.BOLD, 20));
		
		//panel main
		JPanel pMain = new JPanel();
		pMain.setSize(500, 250);
		pMain.setLayout(null);
		
		//create elements input and title
		JLabel lblNhapA = new JLabel("Nhập a: ");
		lblNhapA.setBounds(40, 70, 50, 30);
		
		txtNhapA = new JTextField();
		txtNhapA.setBounds(100, 70, 350, 30);
		
		JLabel lblNhapB = new JLabel("Nhập b: ");
		lblNhapB.setBounds(40, 110, 50, 30);
		
		txtNhapB = new JTextField();
		txtNhapB.setBounds(100, 110, 350, 30);
		
		JLabel lblNhapC = new JLabel("Nhập c: ");
		lblNhapC.setBounds(40, 150, 50, 30);
		
		txtNhapC = new JTextField();
		txtNhapC.setBounds(100, 150, 350, 30);
		
		JLabel lblKetQua = new JLabel("Kết quả: ");
		lblKetQua.setBounds(40, 190, 50, 30);
		
		txtKetQua = new JTextField();
		txtKetQua.setBounds(100, 190, 350, 30);
		txtKetQua.setEditable(false);
		
		//add element into panel main
		pMain.add(lblNhapA);
		pMain.add(txtNhapA);
		pMain.add(lblNhapB);
		pMain.add(txtNhapB);
		pMain.add(lblNhapC);
		pMain.add(txtNhapC);
		pMain.add(lblKetQua);
		pMain.add(txtKetQua);
		
		//bottom controls
		JPanel pControl = new JPanel();
		pControl.setBounds(0, 280, 500, 80);
		TitledBorder tb = BorderFactory.createTitledBorder("Chọn tác vụ:");
		tb.setTitleJustification(TitledBorder.LEFT);
		pControl.setBorder(tb);
		
		//create buttons control
		btnGiai = new JButton("Giải");
		btnXoaRong = new JButton("Xóa rỗng");
		btnThoat = new JButton("Thoát");
		
		//add element
		pControl.add(btnGiai);
		pControl.add(btnXoaRong);
		pControl.add(btnThoat);
		
		//add component into panel
		p.add(lblTitle);
		p.add(pMain);
		p.add(pControl);
		
		//add panel into frame
		this.add(p);
		
		//add actionListener
		btnGiai.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThoat.addActionListener(this);
		
	}

	public static void main(String[] args) {
		GiaiPhuongTrinhBac2 ptb2 = new GiaiPhuongTrinhBac2("^-^");
		ptb2.doShow();
	}
	
	private String PTB2(int a, int b, int c) {
		double delta = (b * b) - (4 * a * c);
		
		if(delta < 0)
			return "Phương trình vô nghiệm";
		else if(delta == 0) 
			return "Phương trình có nghiệm kép x1 = x2 = " + (-b/ (2 * a)) + "";
		else {
			double x1 = (-b + Math.sqrt(delta)) / (2 * a);
			double x2 = (-b - Math.sqrt(delta)) / (2 * a);
			
			return "Phương trình có 2 nghiệm phân biệt x1 = " + x1 + ", x2 = " + x2 + ""; 
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		String nhapA = txtNhapA.getText();
		String nhapB = txtNhapB.getText();
		String nhapC = txtNhapC.getText();
		
		if(src.equals(btnGiai)) {
			if(nhapA.equals("") || nhapB.equals("") || nhapC.equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập đủ dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			int a = Integer.parseInt(nhapA);
			int b = Integer.parseInt(nhapB);
			int c = Integer.parseInt(nhapC);
			txtKetQua.setText(PTB2(a, b, c));
		}
		else if(src.equals(btnXoaRong)) {
			txtNhapA.setText("");
			txtNhapB.setText("");
			txtNhapC.setText("");
			txtKetQua.setText("");
		}
		else if(src.equals(btnThoat)) {
			System.exit(0);
		}
		
	}

}
