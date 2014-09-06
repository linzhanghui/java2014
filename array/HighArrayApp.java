package com.zhlin.algorithms;

public class HighArrayApp {
	public static void main(String[] args) {
		int maxSize = 100;
		HighArray arr = new HighArray(maxSize);
		
		arr.insert(77);
		arr.insert(177);
		arr.insert(37);
		arr.insert(54);
		arr.insert(21);
		arr.insert(23);
		arr.insert(44);
		arr.insert(98);
		arr.insert(2);
		arr.insert(7);
		arr.insert(17);
		
		arr.display();
		
		int searchKey = 21;
		
		if(arr.find(searchKey))
			System.out.println("find searchKey "+searchKey);
		else
			System.out.println("Can't find searchKey "+ searchKey);
		
		arr.delete(23);
		arr.delete(24);
		
		arr.display();
			
			
	}
}
