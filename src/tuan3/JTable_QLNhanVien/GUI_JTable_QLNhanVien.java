package tuan3.JTable_QLNhanVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class GUI_JTable_QLNhanVien extends JFrame implements ActionListener, MouseListener{
	private JTextField txtIdStaff;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAge;
	private JRadioButton radGender;
	private JTextField txtSalary;
	private DefaultTableModel tableModel;
	private JTable tblStaff;
	private JTextField txtNumFind;
	private JButton btnFind;
	private JButton btnAdd;
	private JButton btnEmtyFullInput;
	private JButton btnDel;
	private JButton btnSave;

	public GUI_JTable_QLNhanVien(String title) {
		this.setTitle(title);
	}
	
	private void doShow() {
		this.setSize(700, 720);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addControl();
		this.setVisible(true);
	}
	
	private void addControl() {
		JPanel pnMain = new JPanel();
		
		JPanel pnHeader = new JPanel();
		JLabel lblHeader = new JLabel("Thông Tin Nhân Viên");
		lblHeader.setForeground(Color.BLUE);
		lblHeader.setFont(new Font("sansif", Font.BOLD, 24));
		pnHeader.add(lblHeader);
		pnMain.add(pnHeader);
		
		JPanel pnIdStaff = new JPanel();
		pnIdStaff.add(new JLabel("Mã nhân viên: "));
		txtIdStaff = new JTextField(52);
		pnIdStaff.add(txtIdStaff);
		pnMain.add(pnIdStaff);
		
		JPanel pnNameStaff = new JPanel();
		pnNameStaff.add(new JLabel("Họ:   "));
		txtFirstName = new JTextField(25);
		pnNameStaff.add(txtFirstName);
		pnNameStaff.add(new JLabel("Tên nhân viên: "));
		txtLastName = new JTextField(23);
		pnNameStaff.add(txtLastName);
		pnMain.add(pnNameStaff);
		
		JPanel pnAge_Gender = new JPanel();
		pnAge_Gender.add(new JLabel("Tuổi: "));
		txtAge = new JTextField(45);
		pnAge_Gender.add(txtAge);
		pnAge_Gender.add(new JLabel("Phái:                "));
		radGender = new JRadioButton();
		pnAge_Gender.add(radGender);
		pnAge_Gender.add(new JLabel("Nữ"));
		pnMain.add(pnAge_Gender);
		
		JPanel pnSalary = new JPanel();
		pnSalary.add(new JLabel("Tiền lương:   "));
		txtSalary = new JTextField(53);
		pnSalary.add(txtSalary);
		pnMain.add(pnSalary);
		
		//Table
		JPanel pnTableStaff = new JPanel();
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] {"Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền Lương"});
		
		//Config cell table
		JComboBox<String> jComboBox = new JComboBox<String>(new String[] {"Nam", "Nữ"});
		DefaultCellEditor de = new DefaultCellEditor(jComboBox);
		tableModel.addRow(new Object[] {"1111", "Nguyễn", "Hoàng", "Nam", "26", "4,500$"}) ;
		tableModel.addRow(new Object[] {"2222", "Bá", "Long", "Nam", "25", "2,500$"}) ;
		
		tblStaff = new JTable();
		tblStaff.setModel(tableModel);
		tblStaff.getColumnModel().getColumn(3).setCellEditor(de);
		pnTableStaff.add(new JScrollPane(tblStaff));
		pnMain.add(pnTableStaff);
		
		JPanel pnControl = new JPanel();
		
		JPanel pnControlLeft = new JPanel();
		pnControlLeft.add(new JLabel("Nhập số cần tìm"));
		txtNumFind = new JTextField(10);
		pnControlLeft.add(txtNumFind);
		btnFind = new JButton("Tìm");
		pnControlLeft.add(btnFind);
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		pnControlLeft.setBorder(border);
		pnControl.add(pnControlLeft);
		  
		JPanel pnControlRight = new JPanel();
		btnAdd = new JButton("Thêm");
		btnEmtyFullInput = new JButton("Xóa trắng");
		btnDel = new JButton("Xóa");
		btnSave = new JButton("Lưu");
		pnControlRight.add(btnAdd);
		pnControlRight.add(btnEmtyFullInput);
		pnControlRight.add(btnDel);
		pnControlRight.add(btnSave);
		pnControlRight.setBorder(border);
		pnControl.add(pnControlRight);
		pnMain.add(pnControl);
		this.add(pnMain);
		
		btnAdd.addActionListener(this);
		btnEmtyFullInput.addActionListener(this);
		btnDel.addActionListener(this);
		btnSave.addActionListener(this);
		btnFind.addActionListener(this);
		tblStaff.addMouseListener(this);
	}

	public static void main(String[] args) {
		GUI_JTable_QLNhanVien gui = new GUI_JTable_QLNhanVien("^-^");
		gui.doShow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src.equals(btnAdd)) {
			String id = txtIdStaff.getText();
			String fName = txtFirstName.getText();
			String lName = txtLastName.getText();
			String gender = radGender.isSelected() ? "Nữ" : "Nam";
			String age = txtAge.getText();
			String salary = txtSalary.getText() + "$";
			tableModel.addRow(new String[] {id, fName, lName, gender, age, salary});
			//clearInput();
		}
		
		if(src.equals(btnEmtyFullInput)) {
			clearInput();
		}
		
		if(src.equals(btnDel)) {
			int index = tblStaff.getSelectedRow();
			if(index == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhân viên!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			}else {
				if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này?", "Hỏi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					tableModel.removeRow(index);
					clearInput();
				}
			}
		}
		
		if(src.equals(btnSave)) {
			int index = tblStaff.getSelectedRow();
			String id = txtIdStaff.getText();
			String fName = txtFirstName.getText();
			String lName = txtLastName.getText();
			String gender = radGender.isSelected() ? "Nữ" : "Nam";
			String age = txtAge.getText();
			String salary = txtSalary.getText() + "$";
			
			tableModel.setValueAt(id, index, 0);
			tableModel.setValueAt(fName, index, 1);
			tableModel.setValueAt(lName, index, 2);
			tableModel.setValueAt(gender, index, 3);
			tableModel.setValueAt(age, index, 4);
			tableModel.setValueAt(salary, index, 5);
			
			clearInput();
		}
		
		if(src.equals(btnFind)) {
			String id = txtNumFind.getText().trim();
			int indexRow = getRowFind(id);
			if(indexRow == -1) {
				JOptionPane.showMessageDialog(this, "Không tồn tại nhân viên này!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}else {
				String[] info = getRowAt(indexRow);
				
				tableModel.setRowCount(0);
				tableModel.addRow(new String[] {info[0], info[1], info[2], info[3], info[4], info[5]});
			}
		}
	}
	
	private int getRowFind(String id) {
		for(int i = 0; i < tableModel.getRowCount() ; ++i) {
			if(id.equals(tblStaff.getValueAt(i, 0)))
				return i;
		}
		return -1;
		
	}
	
	private String[] getRowAt(int indexRow) {
		String[] result = new String[tableModel.getColumnCount()];
		
		for(int i = 0; i < tableModel.getColumnCount(); ++i) {
			result[i] = (String) tableModel.getValueAt(indexRow, i);
		}
		
		return result;
	}

	private void clearInput() {
		txtIdStaff.setText("");
		txtFirstName.setText("");
		txtLastName.setText("");
		radGender.setSelected(false);
		txtAge.setText("");
		txtSalary.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int index = tblStaff.getSelectedRow();
		txtIdStaff.setText((String) tblStaff.getValueAt(index, 0));
		txtFirstName.setText((String) tblStaff.getValueAt(index, 1));
		txtLastName.setText((String) tblStaff.getValueAt(index, 2));
		radGender.setSelected((tblStaff.getValueAt(index, 3).equals("Nữ")) ? true : false);
		txtAge.setText((String) tblStaff.getValueAt(index, 4));
		txtSalary.setText((String) tblStaff.getValueAt(index, 5));
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
