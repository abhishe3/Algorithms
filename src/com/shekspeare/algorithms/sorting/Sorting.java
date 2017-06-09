package com.shekspeare.algorithms.sorting;

public class Sorting {
	
	
	// Selection Sort
	// O(n^2) as there are two nested loops.
	//http://quiz.geeksforgeeks.org/selection-sort/
	void selectionSort(int[] arr){
		
		int n = arr.length;
		
		for(int i = 0 ; i < n-1 ; i++){

			for(int j=i+1; j < n ; j++){
				if(arr[j] < arr[i]) swap(arr, i, j);
			}
			
		}
		
	}
	//Bubble Sort
	// O(n^2) 
	//http://quiz.geeksforgeeks.org/bubble-sort/
	void bubbleSort(int[] arr){
		
		int i , j = 0;
		int n = arr.length;
		for(i=0;i<n-1;i++){
			
			for(j=0;j<n-i-1;j++){
				if(arr[j] > arr[j+1]) swap(arr, j, j+1);
			}
		}
		
	}
	
	//if no swap took place at all for entire inner loop, then the array is done being sorted. So break
	void bubbleSortOptimized(int[] arr){
		
		boolean swapped = false;
		int i , j = 0;
		int n = arr.length;
		
		for(i=0;i<n-1;i++){
			
			for(j=0;j<n-i-1;j++){
				if(arr[j] > arr[j+1]) { 
					swap(arr, j, j+1) ;
					swapped = true;
				}
			}
			
			if(!swapped) break;  // no swap occurred. So exit.
		}
		
	}
	
	//Insertion Sort : Link below for explanation, but self-written code :: PTR: Analogy is inserting in a deck of cards
	// O(n^2) 
	//http://quiz.geeksforgeeks.org/insertion-sort/
	void insertionSort(int[] arr){
		
		int n = arr.length;
		for(int i=1;i <n;i++){
			for(int j=0; j < i; j++){                        // The inner loop, expands as we insert smallest elements from outer loop (i-->n)
				if(arr[i] < arr[j]) swap(arr,i,j); 
			}
		}
		
	}
	
	//Merge Sort : From Cracking The Coding Interview
	// O(nLogn) : Log n for recursive division ; n for linear time for merge  
	void mergeSort(int[] arr){
		int[] helper = new int[arr.length];
		
		mergeSort(arr,helper,0,arr.length-1);
		
	}
	
	
	void mergeSort(int[] arr, int[] helper, int low, int high){
		if(low<high){
			int mid = (low+high)/2;
			mergeSort(arr,helper,low,mid); //sort left half  (this is just to break up the array; real sorting is done in merge())
			mergeSort(arr,helper,mid+1,high);  //sort right half
			merge(arr, helper, low, mid, high);  //merge both halves
		}
		
	}
	
	void merge(int[] arr, int[] helper, int low, int mid, int high){
		
		// Copy both halves into helper array
		for(int i=low;i<=high;i++){
			helper[i] = arr[i];
		}
		
		int helperLeft = low;
		int helperRight = mid+1;
		int current = low;
		
		/* Iterate through the helper array. Copy the smaller element from each half into the main array
		 * while updating the corresponding pointer (helperLeft/helperRight)
		 * 
		 */
		while(helperLeft<=mid && helperRight<=high){
			
			if(helper[helperLeft] <= helper[helperRight]){
				arr[current] = helper[helperLeft];
				helperLeft++;
			}else{
				arr[current] = helper[helperRight];
				helperRight++;
			}
			current++;
			
		}
		
		/*Copy the rest of the left side of the array into target array.
		 * Why not right array? Because it is already there
		 * Eg: when helper = 1 4 5 || 2 8 9  ------>  arr =  1 4 5 || 2 8 9
		 * After copying 2 in the right place, 8 and 9 are already there. So no need of right side.
		 * arr =  1 2 4 5 2 8 9
		*/
		int remaining = mid - helperLeft;
		for(int i=0;i<=remaining;i++){
			arr[current+i] = helper[helperLeft+i];
		}
		
	}
	
	//Quick Sort : From Cracking The Coding Interview
	//Worst case O(n^2) // ALSO READ GFG solution along with https://www.youtube.com/watch?v=aQiWF4E8flQ ..maybe easier
	void quickSort(int[] arr){
		quickSort(arr, 0, arr.length-1);
	}
	
	void quickSort(int[] arr, int left, int right){
		
		int index = partition(arr, left, right);
		
		if(left<index-1){  //sort left half
			quickSort(arr, left ,index-1);
		}
		
		if(right>index){
			quickSort(arr, index ,right);
		}
	}
	
	int partition(int[] arr, int left, int right){
		
		int pivot = arr[(left+right)/2]; //pick pivot point
		while(left<=right){
			//Find element on left that should be on right
			while(arr[left]< pivot) left++;
			
			//Find element on right that should be on left
			while(arr[right]> pivot) right--;
			
			//swap elements and move left and right indices
			
			if(left<=right){
				swap(arr,left, right);
				left++;
				right--;
			}
		}
		
		return left;
	}
	//Generic function to swap two elements in an array
	void swap (int[] arr, int i , int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	void printArray(int[] arr){
		
		int n= arr.length;
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {100,300,500,7,600,1,900 };//  {-2,11,-1,7,9,3,1,0}; //{-1 ,0 ,1 ,3 ,7 ,9};
		
		Sorting sorting = new Sorting();
	//	sorting.selectionSort(arr);
		
		//sorting.bubbleSort(arr);
		//sorting.bubbleSortOptimized(arr);
		//sorting.insertionSort(arr);
		//sorting.mergeSort(arr);
		sorting.quickSort(arr);
		
		sorting.printArray(arr);

	}

}
