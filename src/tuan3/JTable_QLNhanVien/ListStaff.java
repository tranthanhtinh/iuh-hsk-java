package tuan3.JTable_QLNhanVien;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListStaff implements Serializable{
	List<Staff> listStaff;
	
	public ListStaff() {
		listStaff = new ArrayList<Staff>();
	}
	
	public List<Staff> getListStaff() {
		return listStaff;
	}
	
	public boolean addStaff(Staff st) {
		if(listStaff.contains(st))
			return false;
		listStaff.add(st);
		return true;
	}
	
	public boolean updateStaff(Staff st) {
		int index = listStaff.indexOf(st);
		if(index < 0)
			return false;
		listStaff.set(index, st);
		return true;
	}
	
	public boolean deleteStaff(Staff st) {
		listStaff.remove(st);
		return true;
	}
	
	public Staff findStaffById(String id) {
		for(Staff st : listStaff) {
			if(st.getIdStaff().equals(id))
				return st;
		}
		
		return null;
	}
}
