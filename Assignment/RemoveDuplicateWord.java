package week3.day2.Assignment;

import java.util.LinkedHashSet;

class RemoveDuplicateWord {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";		
		String[] arr=text.split(" ");
		int len=arr.length;		
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		for (int i=0;i<len;i++)
		{
			linkedHashSet.add(arr[i]);
		}
		System.out.println(linkedHashSet);
	}

}
