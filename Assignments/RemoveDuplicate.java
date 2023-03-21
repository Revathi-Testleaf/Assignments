package week3.day1.Assignments;

public class RemoveDuplicate {

	public static void main(String[] args) {
		
		String text = "We learn java basics as part of java sessions in java week1";		
		String[] arr=text.split(" ");
		int len=arr.length;		
		for (int i=0;i<len;i++)
		{
			System.out.println(arr[i]);
		}	
		for(int i=0;i<len;i++)
		{
			for(int j=i+1;j<len;j++)
			{
				if(arr[i].equals(arr[j]))
						{				
						arr[j]="";					
						arr[i]=arr[i]+arr[j];						
						}					
			}
			
		}		
		for (int i=0;i<len;i++)
		{			
			System.out.print(arr[i]+" ");
		}

	}

}
