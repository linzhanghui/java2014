package com.zhlin.algorithms;

public class ClassDataArray {
	private Person[] person;
	private int nElems;
	
	public ClassDataArray(int max)
	{
		person = new Person[max];
		nElems = 0;
	}
	
	public void insert(String last,String first,int age)
	{
		person[nElems] = new Person(last,first,age);
		nElems++;
	}
	
	public Person find(String searchName)
	{
		int j;
		for(j=0;j<nElems;j++)
			if(person[j].getLast().equals(searchName))
				break;
		if(j==nElems)
			return null;
		else
			return person[j];
	}
	
	
	//找出这个要删除的数，后面紧跟的数覆盖上去，总体长度减一；
	public boolean delete(String searchName)
	{
		int j;
		for(j=0;j<nElems;j++)
			if(person[j].getLast().equals(searchName))
				break;
		if(j==nElems)
			return false;
		else
		{
			for(int k=j;k<nElems;k++)
				person[k] = person[k+1];
				nElems--;
				return true;
		}
			
	}
	
	public void displayA()
	{
		for(int j=0;j<nElems;j++)
			person[j].displayPerson();
	}
}
