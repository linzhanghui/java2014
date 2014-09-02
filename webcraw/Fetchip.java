package com.zhlin.wwwfetch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Fetchip {
/*	方法captureHtml传入ip
	public void captureHtml(String ip) throws Exception {
		String strURL = "http://ip.chinaz.com/?IP="+ip;
		
		URL url = new URL(strURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		
		InputStreamReader input = new InputStreamReader(httpConn.getInputStream(),"urt-8");
		BufferedReader bufReader = new BufferedReader(input);
		
		String line = "";
		StringBuilder contentBuf = new StringBuilder();
		while((line = bufReader.readLine()) != null) {
		
			contentBuf.append(line);
		}
		String buf = contentBuf.toString();
		//截取html源文件相关字符
		int beginIx = buf.indexOf("查询结果[");
		int endIx = buf.indexOf("上面四项依次显示的是");
		String result = buf.substring(beginIx, endIx);
		System.out.println("captureHtml()的结果：\n" + result);
	}
	*/
	public static void main(String[] args){
//		capApp cap = new captureHtml("192.168.1.1");
//		System.out.println("xyz");
		String strURL = "http://ip.chinaz.com/?IP=42.96.136.209";
		try{
		URL url = new URL(strURL);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		
		InputStreamReader input = new InputStreamReader(httpConn.getInputStream(),"utf-8");
		BufferedReader bufReader = new BufferedReader(input);
		
		String line = "";
		StringBuilder contentBuf = new StringBuilder();
		while((line = bufReader.readLine()) != null) {
		
			contentBuf.append(line);
		}
		String buf = contentBuf.toString();
		//截取html源文件相关字符
		int beginIx = buf.indexOf("查询结果[");
		int endIx = buf.indexOf("上面四项依次显示的是");
		String result = buf.substring(beginIx, endIx);
		System.out.println("captureHtml()的结果：\n" + result);
		} catch (Exception e){
			System.out.println(e);
		}
	}
}
