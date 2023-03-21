package week3.day1.Assignments;

public class PalindromeFunc {

	public static void main(String[] args) {
		String str="Radar";
		String new_str = "";
		str=str.toLowerCase();
		String str_cpy=str;
		System.out.println("Given string :" + str +" Reversed String :" + str_cpy);
		char[] array = str.toCharArray();
		int len=array.length;
		for(int i=len-1;i>=0;i--)
		{
			new_str=new_str+array[i];
		}
		System.out.println("The Reversed string is :"+ new_str);
		if(str_cpy.equals(new_str))
		{
			System.out.println("The Given text is Palindrome");
		}
		else
		{
			System.out.println("The Given text is not a palindrome");
		}
		
	}

}
