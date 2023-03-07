package week1.day2;

import java.util.Arrays;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {21,2,6,16};
		int[] nums1 = {2,13,24,21 };
		int len=nums.length;
		int len1=nums1.length;
		Arrays.sort(nums);	
		Arrays.sort(nums1);	
		System.out.println("Values in given array1");
		for( int i=0; i<=len-1; i++)
		{
		System.out.print(nums[i]+" ");	
		}
		System.out.println("");
		System.out.println("Values in given array2");
		for( int i=0; i<=len1-1; i++)
		{
		System.out.print(nums1[i]+" ");	
		}
		System.out.println("");
		System.out.println("Finding common values in both arrays(intersection)");
		for( int i=0; i<=len-1; i++)
		{
			for (int j=0;j<=len-1;j++)
			{			
				if (nums[i]==nums1[j])
				{
					System.out.print(nums[i] + " ");				
				}
			}			
		}	

	}

}
