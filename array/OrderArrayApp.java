package com.zhlin.algorithms;

public class OrderArrayApp {
	public static void main(String[] args){
		int maxSize = 100;
		OrderArray arr = new OrderArray(maxSize);
		
		arr.insert(77);
		arr.insert(7);
		arr.insert(27);
		arr.insert(37);
		arr.insert(17);
		arr.insert(73);
		arr.insert(75);
		arr.insert(177);
		arr.insert(21);
		arr.insert(45);
		arr.insert(65);
		arr.insert(33);
		arr.insert(123);
		arr.insert(31);
		arr.insert(22);
		
		arr.display();
		
		int searchKey = 43;
		if (arr.find(searchKey)!= arr.size())
			System.out.println("find "+searchKey);
		else
			System.out.println("Can't find"+searchKey);
		
		arr.display();
		
		arr.delete(21);
		arr.delete(22);
		
		arr.display();
		
	}
	
}
