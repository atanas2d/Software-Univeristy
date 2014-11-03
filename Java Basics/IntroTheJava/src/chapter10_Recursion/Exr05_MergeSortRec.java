package chapter10_Recursion;

import java.util.Arrays;

public class Exr05_MergeSortRec {
	public static int[] nums = { 7,1,19,102,2009,8,6,4,14,17 };
	public static int result[], gL = 0;
	public static boolean devided = false;
	
	public static void merge (int start, int mid, int end) {
		int s, e, s1, i;
		s = start;	// start of subArr1
		i = start;	// result array counter
		s1 = mid + 1;	// start of subArr2
		e = end;	// end of subArr2
		
		while ((s <= mid)&&(s1 <= e)) {	// compare elements of two already sorted arrays and record
			if (nums[s] <= nums[s1]) {	// the lower of them to the result[] array
				result[i] = nums[s];
				s++;
				i++;
			} else {
				result[i] = nums[s1];
				s1++;
				i++;
			}
			
		}
		if (s > mid) {							// check if there is unrecorded (greater) values
			for (int ii = s1; ii <= e; ii++) {
				result[i] = nums[ii];
				i++;
			}				
		} else {
			for (int ii = s; ii <= mid; ii++) {
				result[i] = nums[ii];
				i++;
			}		
		}
		for (int ii = start; ii <= end; ii++) {	// apply (sorted) changes to the original array
			nums[ii] = result[ii];
		}
	}
	
	public static void mergeSort(int start, int end) {		
		int mid;
		if ( start < end ) {
			mid = (start + end)/2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			merge(start, mid, end);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Merge sort with recursion
		gL = nums.length;	// Global Length
		result = new int[gL];	// Initialize temp
		mergeSort(0, gL - 1);		
		System.out.print(Arrays.toString(result) + " Length is " + gL);
	}

}
