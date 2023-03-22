package week3.day2.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SecondLargestNumber {

	public static void main(String[] args) {
	int [] data = {2,4,11,23,4,3,5,12};
	Set<Integer> treeSet = new TreeSet<Integer>();
	for(int i=0;i<data.length;i++) 
	{
		treeSet.add(data[i]);		
	}
	System.out.println(treeSet);
	List<Integer> list=new ArrayList<Integer>(treeSet);
	int len=list.size();
	System.out.println("Second largest number :" +list.get(len-2));	
	}
}
