package week1.day1;

public class OddNoPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Printing odd numbers alone
		System.out.println("Odd numbers between 1 to 20 are");
		for (int i=1; i<=20;i++)
		{
			if(i%2!=0)// to print even no i%2==0
			{
				System.out.println(i);
			}
		}

	}

}
