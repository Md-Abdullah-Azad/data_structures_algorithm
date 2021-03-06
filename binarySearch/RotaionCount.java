package com.binarySearch;

public class RotaionCount {

	static int findPivot(int[] array) {
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			
			if(array[middle] > array[middle + 1]) {
				// return array[middle + 1];
				return middle + 1;
			}
			if(array[start] <= array[middle]) {
				start = middle + 1;
			}else {
				end = middle - 1;
			}
		}
		return -1;
	}
	
	public static void main (String[] args) { 
        int arr1[] =  {15, 16, 17, 11, 13, 14}; 
        int n1 = arr1.length; 
        // System.out.println("The minimum element is "+ findPivot(arr1));
        System.out.println("Array is rotated "+ findPivot(arr1) + " times");
    }
}
