package week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {
	
	public static void main(String[] args) {
		int[] num= {1,3,2,6,5};
		Arrays.sort(num);
		int len=num.length;
		System.out.println("Displaying missing element in an array");
		for(int i=0;i<=len-1;i++)
		{
			if(num[i]!=(i+1))
			{
				System.out.println(i+1);
				break;
			}
				
		}
	}

}
