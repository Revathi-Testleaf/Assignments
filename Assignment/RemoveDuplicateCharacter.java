package week3.day2.Assignment;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicateCharacter {

	public static void main(String[] args) {
		String str= "Paypal India" ;
		str=str.toLowerCase();
		char[] charArray = str.toCharArray();
		LinkedHashSet<Character> charset = new LinkedHashSet<Character>();
		LinkedHashSet<Character> dupli_set = new LinkedHashSet<Character>();
		for (int i=0;i<charArray.length;i++)
		{
			if(!charset.contains(charArray[i]))
				charset.add(charArray[i]);
			
			else if(charset.contains(charArray[i]))
				dupli_set.add(charArray[i]);
		}
		System.out.println(charset);
		System.out.println(dupli_set);
		List<Character> list1=new ArrayList<Character>(dupli_set);
		
		for(int i=0;i<list1.size();i++)
		{
			if(charset.contains(list1.get(i)))
			{
				charset.remove(list1.get(i));
			}				
		}
		System.out.println(charset);	
		Object[] array = charset.toArray();					
		for(int i=0;i<array.length;i++)
		{
			if( (array[i] == null))  
			{
			System.out.println("Given string contains empty space");
			}
		}
	}

}
