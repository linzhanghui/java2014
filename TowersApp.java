package com.zhlin.algorithms;


/*
 * 
 * 汉诺塔问题，采用递归调用
 * Disk 1 from A to C
Disk 2 from A to B
Disk 1 from C to B
Disk 3 from A to C
Disk 1 from B to A
Disk 2 from B to C
Disk 1 from A to C
 * 
 * 
 * 
 */
public class TowersApp {
	static int nDisks = 3;
	public static void main(String[] args)
	{
		doTowers(nDisks,'A','B','C');
	}
	public static void doTowers(int topN,char from,char inter,char to)
	{
		if(topN == 1)
			System.out.println("Disk 1 from "+from+" to "+to);
		else
		{
			doTowers(topN-1,from,to,inter);
			System.out.println("Disk "+topN+" from "+from+" to "+to);
			doTowers(topN-1,inter,from,to);
		}
	}
}
