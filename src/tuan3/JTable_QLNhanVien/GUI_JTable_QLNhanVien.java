package tuan3.JTable_QLNhanVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
	private JRadioButton radFeMale;
	private JTextField txtSalary;
	private DefaultTableModel tableModel;
	private JTable tblStaff;
	private JTextField txtNumFind;
	private JButton btnFind;
	private JButton btnAdd;
	private JButton btnEmtyFullInput;
	private JButton btnDel;
	private JButton btnSave;
	private JRadioButton radMale;
	private ButtonGroup btnGroup;
	private ListStaff listStaff;
	private JButton btnReloadData;
	
	public GUI_JTable_QLNhanVien(String title) {
		this.setTitle(title);
	}
	
	private void doShow() {
		this.setSize(700, 720);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		listStaff = new ListStaff();
		addControl();
		this.setVisible(true);
	}
	
	private void addControl() {
		JPanel pnMain = new JPanel();
		
		//====================HEADER=========================
		JPanel pnHeader = new JPanel();
		JLabel lblHeader = new JLabel("Thông Tin Nhân Viên");
		lblHeader.setForeground(Color.BLUE);
		lblHeader.setFont(new Font("sansif", Font.BOLD, 24));
		pnHeader.add(lblHeader);
		pnMain.add(pnHeader);
		
		//====================INPUT ID STAFF =================
		JPanel pnIdStaff = new JPanel();
		pnIdStaff.add(new JLabel("Mã nhân viên:  "));
		txtIdStaff = new JTextField(53);
		pnIdStaff.add(txtIdStaff);
		pnMain.add(pnIdStaff);
		
		//====================INPUT NAME STAFF =================
		JPanel pnNameStaff = new JPanel();
		pnNameStaff.add(new JLabel("Họ:      "));
		txtFirstName = new JTextField(25);
		pnNameStaff.add(txtFirstName);
		pnNameStaff.add(new JLabel("Tên nhân viên:"));
		txtLastName = new JTextField(23);
		pnNameStaff.add(txtLastName);
		pnMain.add(pnNameStaff);
		
		//====================INPUT AGE GENDER =================
		JPanel pnAge_Gender = new JPanel();
		
		pnAge_Gender.add(new JLabel("Tuổi: "));
		txtAge = new JTextField(45);
		pnAge_Gender.add(txtAge);
		
		//Chưa add được button group
		pnAge_Gender.add(new JLabel("Phái:"));
		radFeMale = new JRadioButton("Nữ");
		radMale = new JRadioButton("Nam");
		btnGroup = new ButtonGroup();
		btnGroup.add(radFeMale);
		btnGroup.add(radMale);
		
		pnAge_Gender.add(radFeMale);
		pnAge_Gender.add(radMale);
		pnMain.add(pnAge_Gender);
		
		//=================== INPUT SALARY ========================
		JPanel pnSalary = new JPanel();
		pnSalary.add(new JLabel("Tiền lương:   "));
		txtSalary = new JTextField(54);
		pnSalary.add(txtSalary);
		pnMain.add(pnSalary);
		
		//========================= TABLE LIST STAFF================
		JPanel pnTableStaff = new JPanel();
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(new String[] {"Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền Lương"});
		
		//============ INIT DATA TO FILE ===========================
		listStaff = (ListStaff) DataSaveHelper.loadFile("data\\ListStaff.txt");
		loadDataToTable(listStaff.getListStaff(), tableModel);
		
		//============ CONFIG CELL TABLE ===========================
		JComboBox<String> cboGender = new JComboBox<String>(new String[] {"Nam", "Nữ"});
		DefaultCellEditor de = new DefaultCellEditor(cboGender);
		
		tblStaff = new JTable();
		tblStaff.setModel(tableModel);
		tblStaff.getColumnModel().getColumn(3).setCellEditor(de);
		pnTableStaff.add(new JScrollPane(tblStaff));
		pnMain.add(pnTableStaff);
		
		//========================== PANEL CONTROL ===================
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
		btnReloadData = new JButton("Tải lại");
		pnControlRight.add(btnAdd);
		pnControlRight.add(btnEmtyFullInput);
		pnControlRight.add(btnDel);
		pnControlRight.add(btnSave);
		pnControlRight.add(btnReloadData);
		pnControlRight.setBorder(border);
		pnControl.add(pnControlRight);
		pnMain.add(pnControl);
		this.add(pnMain);
		
		//================= ADD EVENT LISTENER =========================
		btnAdd.addActionListener(this);
		btnEmtyFullInput.addActionListener(this);
		btnDel.addActionListener(this);
		btnSave.addActionListener(this);
		btnFind.addActionListener(this);
		btnReloadData.addActionListener(this);
		tblStaff.addMouseListener(this);
	}

	
	public static void main(String[] args) {
		GUI_JTable_QLNhanVien gui = new GUI_JTable_QLNhanVien("^-^");
		gui.doShow();
	}

	// =================== FUNCTION SUPPORT ===============================
	private void loadDataToTable(List<Staff> list, DefaultTableModel model) {
		model.setRowCount(0);
		for(Staff s : list) {
			Object[] row = {s.getIdStaff(), s.getFirstName(), s.getLastName(), s.getGender(), s.getAge(), s.getSalary()};
			model.addRow(row);
		}
	}
	
	private Staff createStaff() {
		String id = txtIdStaff.getText();
		String fName = txtFirstName.getText();
		String lName = txtLastName.getText();
		String gender = radFeMale.isSelected() ? "Nữ" : "Nam";
		String age = txtAge.getText();
		String salary = txtSalary.getText();
		
		Staff staff = new Staff(id, fName, lName, gender, Integer.parseInt(age), Double.parseDouble(salary));
		
		return staff;
	}
	
	private boolean checkInputNotEmty() {
		if(txtIdStaff.getText().trim() != null && txtFirstName.getText().trim() != null 
				&& txtLastName.getText().trim() != null && txtAge.getText().trim() != null
				&& !txtSalary.getText().trim().equals("") && (radFeMale.isSelected() || radMale.isSelected())
		  )
			return true;
		return false;
	}
	
	private void clearInput() {
		txtIdStaff.setText("");
		txtFirstName.setText("");
		txtLastName.setText("");
		btnGroup.clearSelection();
		txtAge.setText("");
		txtSalary.setText("");
		txtIdStaff.requestFocus();
	}

	private void loadDataToText(int index) {
		txtIdStaff.setText((String) tblStaff.getValueAt(index, 0));
		txtFirstName.setText((String) tblStaff.getValueAt(index, 1));
		txtLastName.setText((String) tblStaff.getValueAt(index, 2));
		radFeMale.setSelected((tblStaff.getValueAt(index, 3).equals("Nữ")) ? true : false);
		radMale.setSelected((tblStaff.getValueAt(index, 3).equals("Nam")) ? true : false);
		txtAge.setText(tblStaff.getValueAt(index, 4).toString());
		txtSalary.setText((String) tblStaff.getValueAt(index, 5).toString());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//==================== EVENT ADD STAFF ==================
		if(src.equals(btnAdd)) {
			if(!checkInputNotEmty())
				JOptionPane.showMessageDialog(this, "Bạn vui lòng nhập đầy đủ thông tin!!");
			else {
				Staff staff = createStaff();
				listStaff.addStaff(staff);
				loadDataToTable(listStaff.getListStaff(), tableModel);
				clearInput();
			}
		}
		
		//==================== EVENT ADD CLEAR FULL INPUT =========
		if(src.equals(btnEmtyFullInput)) {
			clearInput();
		}
		
		//==================== EVENT DELETE STAFF ==================
		if(src.equals(btnDel)) {
			int index = tblStaff.getSelectedRow();
			if(index == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn một nhân viên!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			}else {
				Staff staff = listStaff.getListStaff().get(index);
				if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này?", "Hỏi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					listStaff.deleteStaff(staff);
					loadDataToTable(listStaff.getListStaff(), tableModel);
					JOptionPane.showMessageDialog(this, "Xóa thành công!");
				}
				
				clearInput();
			}
		}
		
		//==================== EVENT SAVE LIST STAFF ==================
		if(src.equals(btnSave)) {
			// must initialize the directory to the project first
			if(DataSaveHelper.saveFile(listStaff, "data\\ListStaff.txt")) {
				JOptionPane.showMessageDialog(this, "Lưu thông tin nhân viên thành công!");
			}else {
				JOptionPane.showMessageDialog(this, "Lưu thông tin nhân viên thất bại!");
			}
		}
		
		//==================== EVENT FIND STAFF BY ID ==================
		if(src.equals(btnFind)) {
			String id = txtNumFind.getText().trim();
			
			if(id.equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập id để tìm kiếm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
			}else {
				Staff staff = listStaff.findStaffById(id);
				if(staff == null) {
					JOptionPane.showMessageDialog(this, "Không tồn tại nhân viên này!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				}else {
					tableModel.setRowCount(0);
					tableModel.addRow(new Object[] {staff.getIdStaff(), staff.getFirstName(), staff.getGender(), staff.getLastName(), staff.getAge(), staff.getSalary()});
				}
			}
			
		}
		
		//==================== EVENT RELOAD TABLE ==================
		if(src.equals(btnReloadData)) {
			loadDataToTable(listStaff.getListStaff(), tableModel);
		}
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int index = tblStaff.getSelectedRow();
		loadDataToText(index);
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
