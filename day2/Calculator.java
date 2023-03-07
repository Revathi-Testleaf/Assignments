package week1.day2;

public class Calculator {
	public int addMethod(int value1,int value2, int sum)
	{
		sum=value1+value2;
		return sum;
		
	}
	public int mulMethod(int value1,int value2)
	{
		
		return value1*value2;
		
	}
	public void subMethod(int value1,int value2)
	{
		
		System.out.println("Substracted value of "+value1 +" and " +value2 + " is " + (value1-value2));

		
	}

	public static void main(String[] args) {
		System.out.println("Three methods are created");
		//Creating add()
		
	}

}
