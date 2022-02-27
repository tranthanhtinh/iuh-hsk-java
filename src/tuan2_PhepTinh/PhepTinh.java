package tuan2_PhepTinh;

public class PhepTinh {
	static String TinhToan(int a, int b, String phepToan) {
		double kq = 0;
		switch (phepToan) {
			case "Cộng": {
				kq = a + b;
			}break;
			
			case "Trừ": {
				kq = a - b;
			}break;
			
			case "Nhân": {
				kq = a * b;
			}break;
			
			case "Chia": {
				if(a == 0)
					return "Không tính được";
				else
					kq = (a * 1.0) / b;
			}
		}
		
		return String.format("%.2f", kq);
		
	}
}
