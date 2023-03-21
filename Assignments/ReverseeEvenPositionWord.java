package week3.day1.Assignments;

public class ReverseeEvenPositionWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Its for testing purpose";		
		 String[] arr=str.split(" ");		 
		for (int i=0;i<arr.length;i++)
		{
			if((i+1)%2==0)
			{
				char[] charArray = arr[i].toCharArray();
				for(int j=charArray.length-1;j>=0;j--)
				{
					System.out.print(charArray[j]);
					
				}
				System.out.print(" ");			
			}
			else
			{
				System.out.print(arr[i]+" ");
			}
		}
	}
}
		



