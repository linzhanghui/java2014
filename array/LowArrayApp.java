package com.zhlin.algorithms;

public class LowArrayApp 
{
	public static void main(String[] args)
	{
	//函数式调用	
	LowArray arr;
	arr = new LowArray(100);
	int nElems=0;
	int j;
	
	arr.setElem(0,110);
	arr.setElem(1,90);
	arr.setElem(2,11);
	arr.setElem(3,12);
	arr.setElem(4,320);
	arr.setElem(5,220);
	arr.setElem(6,180);
	arr.setElem(7,187);
	arr.setElem(8,3);
	arr.setElem(9,32);

	nElems = 10;
	
	for(j=0;j<nElems;j++)
		System.out.print(arr.getElem(j)+" ");
	System.out.println("");
//  数组遍历查找到后跳出，一直找到nElems没找到，则就是没找到
	int searchKey=3;
	for(j=0;j<nElems;j++)
		if (arr.getElem(j)==searchKey)
		break;
		
		if (j==nElems)
			System.out.println("Can't find key!"+searchKey);
		else
			System.out.println("find search key, the key is "+j+" the value is "+ searchKey);
		
//  傻瓜式删除
		
	for(j=0;j<nElems;j++)
		if(arr.getElem(j)==320)
			break;
	//将k+1的值补到k的数组上
	for(int k=j;k<nElems;k++)
		arr.setElem(k,arr.getElem(k+1));
	nElems--;
		
	for(j=0;j<nElems;j++)
		System.out.print(arr.getElem(j)+" ");
	System.out.println("");
	}
	
}
