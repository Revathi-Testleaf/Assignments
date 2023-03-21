package week3.day1.Assignments;

public class OddIndexToUpperCase {

	public static void main(String[] args) {
		String str="Madam",new_str = "";
		char temp_str;			
		System.out.println(" Given string :" + str);
		char[] array = str.toCharArray();
		int len=array.length;
		for(int i=0;i<len;i++)
		{			
			if((i+1)%2==0)
			{
				new_str=new_str+array[i];		
			}
			else
			{				
				temp_str=Character.toUpperCase(array[i]);				
				new_str=new_str+temp_str;				
			}
		}
		System.out.println("The Answer is :"+ new_str);
		// TODO Auto-generated method stub

	}
	
	}


