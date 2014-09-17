package com.zhlin.algorithms;

public class InsertSortApp {
	public static void main(String[] args) {
		int maxSize = 100;
		ArrayIns arr;
		arr = new ArrayIns(maxSize);
		
		arr.insert(22);
		arr.insert(1);
		arr.insert(32);
		arr.insert(122);
		arr.insert(17);
		arr.insert(5);
		arr.insert(54);
		arr.insert(12);
		arr.insert(98);
		arr.insert(43);
		arr.insert(31);
		
		arr.display();
		arr.insertSort();
		arr.display();
	}
}
