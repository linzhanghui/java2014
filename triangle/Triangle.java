package com.zhlin.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
	static int theNumber;

	public static void main(String[] args) throws IOException {
		System.out.println("提示：请输入数字！");
		theNumber = getInt();
		int theAnswer = triangle(theNumber);
		System.out.println("theAnswer:" + theAnswer);
	}

	public static int triangle(int n) {
		if (n == 1)
			return 1;
		else {
			return (n + triangle(n - 1));
		}
	}

	// 接收输入的字符串
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}
