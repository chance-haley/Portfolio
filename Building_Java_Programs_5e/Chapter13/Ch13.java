import java.util.*;

public class Ch13{
	public static void main(String[]args){
		
		int [] x = {0,1,10,12,42,55,88,1000};
		System.out.println(binarySearch(x,1000));
		System.out.println(binarySearch(x,1));
		System.out.println(binarySearch(x,88));
		System.out.println(binarySearch(x,999));
		int[] nums = {-1000,20,42,1,9,23};
		
		selectionSortMax(nums);
		System.out.println(Arrays.toString(nums));
	}
	
		 public static void bubbleSortRev(int[] nums){
		 for(int i=0; i<nums.length;i++){
			 for(int j= nums.length-1; j>0;j--){
				 if(nums[j]>nums[j-1]){
					 swap(nums, j ,j-1);
				 }
			 }
		 }
	 }
	 	public static void selectionSortMax(int[] nums){ //selects certain element (in this case max) and swap it
		
		for(int i=0; i<nums.length;i++){
			int maxIndex = i;
			for(int j= i; j< nums.length; j++){
				if(nums[j] < nums[maxIndex]){
					maxIndex =j;
				
				}
			}
			swap(nums, i, maxIndex);
		}
	}
	
	public static boolean binarySearch(int[] nums, int x){
		int len = nums.length;
		int start, end, mid,flag;
		start = 0;
		end = len;
		flag=0;
		
		while(flag==0){
			mid = (start + end)/2;
			System.out.println(nums[mid]);
			if(nums[mid]==x) return true; //need to ensure this runs before I return false
			if(end-start==1) return false;
			if(nums[mid]>x){
				start = start; // returns bottom half of array
				end = mid;
			}
			if(nums[mid]<x){
				start = mid;
				end = end;
			}
		}
		
		
	return true;	
	}
	
	/* Quadratic growth 0(n^2) (this is quadratic even though it takes n^2/2 average iterations
	 * better for partially sorted list
	 * 
	 * 
	 * */
	public static void insertionSort(int[] nums){
		int key;
		for(int i = 1; i<nums.length;i++){
			key = nums[i];
			
			int j = i-1;
			while(j>=0 && nums[j]> key){
				nums[j+1] = nums[j]; //shifting
				j--;
			}
			nums[j+1] = key;  //insertion
		}
	}
	/* Quadratic growth 0(n^2) (this is quadratic even though it takes n^2/2 average iterations
	
	
	*/
	public static void selectionSort(int[] nums){ //selects certain element (in this case min) and swap it
		
		for(int i=0; i<nums.length;i++){
			int minIndex = i;
			for(int j= i; j< nums.length; j++){
				if(nums[j] < nums[minIndex]){
					minIndex =j;
				
				}
			}
			swap(nums, i, minIndex);
		}
	}
	
	
	
	
	/* Quadratic growth 0(n^2)
	 * 
	 * 
	 * */
	 
	 public static void bubbleSort(int[] nums){
		 for(int i=0; i<nums.length;i++){
			 for(int j= 0; j<nums.length-1;j++){
				 if(nums[j]>nums[j+1]){
					 swap(nums, j ,j+1);
				 }
			 }
		 }
	 }
	 
	 private static void swap(int[] array, int i, int j){
		 int temp = array[i];
		 array[i] = array[j];
		 array[j] = temp;
	 }
	 	
	/* Constant growth 0(1)
	 * 
	 * base/avg/worst case: all the same
	 * 
	 * 
	 * */
	public static void constant(int m){
		
		for(int i= 0 ;i< 1_000_000L; i++){
			System.out.println(m);
		}
			
	}
	/* linear growth 0(n) 
	 * best case: 1 time
	 *  on average: will take n / 2 time
	 *  worst-case: will take n + 1 time
	 * 
	 * 
	 * */
	 
	public static boolean contains(int[]x,int y){
		
		for(int z : x){
			
			if(z == y){
				return true;
			}
		}
		return false;
		
		
		
	}
	/* logarithmic growth 0(log(n))
	 * 
	 * pre-req: x must be sorted
	 * 
	 * best case: 1 time
	 * avg case: log(n)
	 * worst case: log(n)
	 * 
	 * */
	public static boolean recContains(int[]x,int y){ //assume data is valid
		int len = x.length;
		
		if(len==0) return false; //if array is empty 
		
		int mid = x[len/2];
		
		if(mid ==y) return true;
		
		if(mid>y){
			return recContains(Arrays.copyOfRange(x, 0, len/2), y); 
		}
		return recContains(Arrays.copyOfRange(x,len/2+1, len),y);
		
	}
	
	
	
}
