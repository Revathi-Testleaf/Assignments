package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
		
		Calculator obj_calulatorClass=new Calculator();
		System.out.println("Add Method :" + obj_calulatorClass.addMethod(13, 12, 0));
		System.out.println("Multiple Method : "+ obj_calulatorClass.mulMethod(21, 21));
		obj_calulatorClass.subMethod(10, 12);	
	}

}
