package com.zhlin.algorithms.quicksort;

public class QuickSortApp {
	public static void main(String[] args){
		int maxSize = 1500;
		ArrayIns arr;
		arr = new ArrayIns(maxSize);
		
		for(int j=0;j<maxSize;j++){
			long n = (int)(java.lang.Math.random()*990);
			arr.insert(n);
		}
		
		arr.display();
		arr.quickSort();
		System.out.println("");
		arr.display();
		
	}
}
