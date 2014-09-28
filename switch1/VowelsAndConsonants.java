package cn.jackie.switch1;

import java.util.Random;

public class VowelsAndConsonants {
	public static void main(String[] args)
	{
		Random rand = new Random(47);
		for(int i=0;i<100;i++){
			int c = rand.nextInt(26)+'a';
			System.out.println((char)c+","+c+":");
			switch(c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				System.out.print("vowel");
				break;
			case 'y':
			case 'w':
				System.out.print("Sometimes a voewl");
				break;
			default:
				System.out.println("constant");
			}
		}
	}
}
