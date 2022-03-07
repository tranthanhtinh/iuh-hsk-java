package tuan3.JList_SoNguyenTo;

import java.util.ArrayList;
import java.util.List;

public class Primes {
	public List<Integer> getPrimes(int count) {
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 2; i < 10000; ++i) {
			if(isPrimes(i))
				result.add(i);
			if(result.size() == count)
				return result;
		}
		return result;
	}
	
	private boolean isPrimes(int num) {
		int count = 0;
		for(int i = 1; i < num; ++i) {
			if(num % i == 0) {
				count++;
			}
			
			if(count == 2)
				return false;
		}
		
		return true;
	}
}
