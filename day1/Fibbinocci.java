package week1.day1;

public class Fibbinocci {

	public static void main(String[] args) {
		// to generate Fibbinocci series for 1st 11 numbers	
		int firstNum = 0, secNum = 1, sum = 0;
		System.out.println("Displaying Fibbinocci series for 1st 11 numbers ");
		System.out.println(firstNum);
		System.out.println(secNum);
		for(int i=1;i<=11;i++)
		{
			sum=firstNum+secNum;
			firstNum=secNum;
			secNum=sum;
			System.out.println(sum);				
		}		
			
	}
}
