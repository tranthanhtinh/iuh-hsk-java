package tuan3.JList_SoNguyenTo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class GUI_JList_SoNguyenTo extends JFrame implements ActionListener{
	private JTextField txtInput;
	private JButton btnGenerate;
	private DefaultListModel<Integer> listModel;

	public GUI_JList_SoNguyenTo(String title) {
		this.setTitle(title);
	}
	
	private void doShow() {
		this.setSize(350, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addControl();
		this.setVisible(true);
	}

	private void addControl() {
		JPanel pnMain = new JPanel();
		
		JPanel pnControl = new JPanel();
		txtInput = new JTextField(15);
		btnGenerate = new JButton("Generate");
		pnControl.add(txtInput);
		pnControl.add(btnGenerate);
		
		JPanel pnResult = new JPanel();
		listModel = new DefaultListModel<Integer>();
		JList<Integer> lstList = new JList<Integer>(listModel);
		pnResult.add(new JScrollPane(lstList));
		
		pnMain.add(pnControl);
		pnMain.add(pnResult);
		this.add(pnMain);
		
		btnGenerate.addActionListener(this);
	}
	
	public static void main(String[] args) {
		GUI_JList_SoNguyenTo gui = new GUI_JList_SoNguyenTo("Primes");
		gui.doShow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if(src.equals(btnGenerate)) {
			listModel.clear();
			Primes prs = new Primes();
			int count = Integer.parseInt(txtInput.getText());
			List<Integer> list = prs.getPrimes(count);
			for(int i = 0; i < list.size(); ++i) {
				listModel.addElement(list.get(i));
			}
		}
	}
}
