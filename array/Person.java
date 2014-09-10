package com.zhlin.algorithms;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	
	public Person(String first,String last,int a)
	{
		firstName = first;
		lastName = last;
		age = a;
	}
	
	public void displayPerson()
	{
		System.out.print(" lastName "+lastName);
		System.out.print(", firstName "+firstName);
		System.out.println(", age " + age);
	}
	
	public String getLast()
	{
		return lastName;
	}
}
