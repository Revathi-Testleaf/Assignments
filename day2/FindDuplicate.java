package week1.day2;
import java.util.*;


public class FindDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 5, 7, 7, 5, 9, 2, 3};
		int len=nums.length;		
		Arrays.sort(nums);	
		System.out.println("Values in given array");
		for( int i=0; i<=len-1; i++)
		{
		System.out.print(nums[i]+" ");	
		}
		System.out.println("");
		System.out.println("Duplicate values in given array");
		for( int i=0; i<=len-1; i++)
		{
			for (int j=i+1;j<=len-1;j++)
			{			
				if (nums[i]==nums[j])
				{
					System.out.print(nums[i] + " ");					
				}		
				
			}			
		}	
			
		}	
    
	}


