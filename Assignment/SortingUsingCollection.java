package week3.day2.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class SortingUsingCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str= {"HCL","Wipro","Apsire System","CTS"};
		int str_len=str.length;
		TreeSet<String> str1=new TreeSet<String>(); 
		for(int i=0;i<str_len;i++)
		{
			str1.add(str[i]);
		}
		System.out.println(str1);
		List<String> list=new ArrayList<String>(str1);
		for(int j=str1.size()-1;j>=0;j--)
		{			
			if(j==0)
				System.out.print(list.get(j));
			else
				System.out.print(list.get(j) + ",");
		}	

	}

}
