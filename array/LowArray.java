package com.zhlin.algorithms;

class LowArray {

	private long[] a;
	
	public LowArray(int size)
	{
		a = new long[size];
	}
	//set数组下标和值
	public void setElem(int index,long value)
	{
		a[index] = value;
	}
	//获取指定数组下标和值
	public long getElem(int index)
	{
		return a[index];
	}
}
