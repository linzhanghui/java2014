package cn.jackie.startsequre;

public class House {
	Windows w1 = new Windows(1);
	House() {
		System.out.println("House()");
		w3 = new Windows(33);
	}
	Windows w2 = new Windows(2);
	void f() 
	{
		System.out.println ("f()");
	}
	Windows w3 = new Windows(3);
}


