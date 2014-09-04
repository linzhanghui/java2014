package com.zhlin.algorithms;

public class Array {
	public static void main(String[] args)
	{
//		long[] arr;
		
		long[] arr = new long[100];
		int nElem = 0;
		int j;
		long SearchKey;
		
		//int 和 long 的长度到底是多少？
		arr[0] = 23;
		arr[1] = 25;
		arr[2] = 27;
		arr[3] = 35;
		arr[4] = 85;
		arr[5] = 235;
		arr[6] = 125;
		arr[7] = 15;
		arr[8] = 325;
		arr[9] = 345;
		
		nElem = 10;
		
		for (j=0; j<nElem; j++)
		{
			System.out.print(arr[j] + " ");
			
		}
		System.out.println("");
		
		SearchKey = 15;
		for(j=0; j<nElem; j++) 
			if(arr[j] == SearchKey)
			break;
			
			if(arr[j] == nElem){
				System.out.println("Can't find SearchKey!");
			} else {
				System.out.println("find SearchKey"+arr[j]);
			}
			
		SearchKey = 235;
		for(j=0; j<nElem; j++)
			if(arr[j] == SearchKey)
				break;
		
		for(int i=j;i<nElem;i++)
			arr[i] = arr[i+1];
			nElem--;
		
		for(j=0;j<nElem;j++)
		{
			System.out.print(arr[j] + " ");
		}
	}
}
