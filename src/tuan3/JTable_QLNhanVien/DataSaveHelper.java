package tuan3.JTable_QLNhanVien;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataSaveHelper {
	public static boolean saveFile(Object obj, String path) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
			oos.writeObject(obj);
			oos.flush();
			oos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Object loadFile(String path)  {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
			Object obj = ois.readObject();
			ois.close();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
