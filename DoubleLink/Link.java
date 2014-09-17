package com.zhlin.algorithms.doublelink;


//双向链表 有节点值 前节点 后节点
public class Link {
	public long dData;
	public Link previous;
	public Link next;
	
	public Link(long d)
	{
		dData = d;
	}
	
	public void displayLink()
	{
		System.out.print(dData+" ");
	}
	
}
