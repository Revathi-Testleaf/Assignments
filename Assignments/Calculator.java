package week3.day1.Assignments;

import week3.day1.IPhone;

public class Calculator extends IPhone{
public void add(int a, int b) {
	System.out.println("Im inside Calculator class- add func");
	System.out.println(a+b);

}
public void add(int a, int b, int c) {
	System.out.println(a+b+c);

}
public void multiple(double a, double b) {
	System.out.println(a*b);

}
public void multiple(double a, float b) {
	System.out.println(a*b);

}
public void multiple(int a, double b) {
	System.out.println(a*b);

}

	public static void main(String[] args) {
	
		Calculator cal=new Calculator();
		cal.add(1,2);
		cal.add(2, 3, 4);
		cal.multiple(1.2, 1.8);
		cal.multiple(2, 2.3);
		cal.multiple(2.3, 2.5f);
		IPhone ip=new IPhone();
		ip.add(2, 3);

	}

}
