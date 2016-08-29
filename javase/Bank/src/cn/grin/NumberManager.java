package cn.grin;

import java.util.ArrayList;
import java.util.List;

public class NumberManager {
	private int lastNumber = 1;
	private List<Integer> queueNumber = new ArrayList<Integer>();
	
	public synchronized Integer generateNewNumber(){
		this.queueNumber.add(lastNumber);
		return this.lastNumber++;
	}
	
	public synchronized Integer fetchServiceNumber(){
		return this.queueNumber.size()>0 ? this.queueNumber.remove(0) : null;
	}
}

