package week1.day1;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Displaying prime number from 1 to 20
		int incr;
		for(int i=2;i<=20;i++)
		{
			//System.out.println("Checking "+ i +" is prime or not");
			incr=0;
			for(int n=i;n>=2;n--)
			{				
				if(i%n==0)
				{
					incr=incr+1;			
				}					
			}
			if(incr==1)
			{
				System.out.println(i+" is a prime number");		
			}		
			else if (incr >=2)
			{
				System.out.println(i+" is  not a prime number");
			}		
		}			

	}

}
