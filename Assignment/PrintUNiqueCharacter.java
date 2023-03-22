package week3.day2.Assignment;

import java.util.HashSet;

public class PrintUNiqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="pranav";
		char[] charArray = str.toCharArray();
		int len=charArray.length;
		HashSet<Character> hashSet = new HashSet<Character>();
		for(int i=0;i<len;i++)
		{
			if(!hashSet.contains(charArray[i]))
			{
				hashSet.add(charArray[i]);
			}
			else
			{
				hashSet.remove(charArray[i]);
			}
		}
		System.out.println(hashSet);
	}

}
