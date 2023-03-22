package week3.day2.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {1,5,8,3,9,6,4,10,7};
		Set<Integer> treeSet = new TreeSet<Integer>();
		boolean flag=false;
		for(int i=0;i<data.length;i++) 
		{
			treeSet.add(data[i]);		
		}
		System.out.println(treeSet);
		List<Integer> list=new ArrayList<Integer>(treeSet);
		int len=list.size();			
		for(int i=0;i<len;i++)
		{
			int temp=i;
			if(list.get(i)!=(temp+1))
			{	
				flag=true;
				System.out.println("Missing number is :"+(temp+1));
				break;					
			}		
			temp=0;
		}
		if(!flag)
		{
		System.out.println("Missing no is :" +(len+1));
		}
	}	
}
