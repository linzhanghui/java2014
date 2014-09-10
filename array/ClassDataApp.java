package com.zhlin.algorithms;

public class ClassDataApp {
	public static void main(String[] args)
	{
		int maxSize = 100;
		ClassDataArray arr;
		arr = new ClassDataArray(maxSize);
		
		arr.insert("John", "eve", 23);
		arr.insert("Johny", "neve", 33);
		arr.insert("sown", "lie", 38);
		arr.insert("eve", "fe", 42);
		arr.insert("xyz", "lin", 65);
		arr.insert("Jackie", "lin", 32);
		arr.insert("jane", "miao", 18);
		arr.insert("lucy", "y", 33);
		arr.insert("dashu", "lin", 23);
		arr.insert("fff", "xy", 23);
		arr.insert("xz", "eb", 23);
		
		arr.displayA();
		
		String searchKey = "fe";
		Person found;
		found = arr.find(searchKey);
		if(found!=null)
		{
			System.out.print("found");
			found.displayPerson();
		} else {
			System.out.print("Can't found"+searchKey);
		}
		System.out.println("Delet person eve,xy,eb");
		arr.delete("eve");
		arr.delete("xy");
		arr.delete("eb");
		
		arr.displayA();
	}
}
