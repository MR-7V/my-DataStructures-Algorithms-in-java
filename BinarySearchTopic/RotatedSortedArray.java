//33. Search in Rotated Sorted Array(No Duplicate Elements)
//https://leetcode.com/problems/search-in-rotated-sorted-array/

class RotatedSortedArray {
    public static void main(String[] args){
        //int arr[]={3,4,5,6,7,8,0,1,2};
        int arr[]={3,1};
        int target=1;
        int result = search(arr, target);
        System.out.println(result);
    }

    public static int search(int[] arr,int target){
        int pivot = findPivotInRotatedArray(arr);
        //if you did not found the pivot then the array is not found.
        if (pivot == -1)
            return binarySearch(arr, target, 0, arr.length-1);  //normal binary search.
        else{   
            //you will have one pivot & 2 ascending order arrays.
            if (target==arr[pivot])
                return pivot;
            //with the referance of start element choose between 2 ascending arrays. 
            if (target>=arr[0]) 
                return binarySearch(arr, target, 0, pivot-1);
            return binarySearch(arr, target, pivot+1, arr.length-1);
        }
    }


    public static int findPivotInRotatedArray(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            //Two return conditions
            if(mid<end && arr[mid]>arr[mid+1])  //to avoid array index out of bound, make sure that mid<end
                return mid;
            if(mid>start && arr[mid]<arr[mid-1])    //to avoid negitive indexing, make sure that mid>start
                return mid-1;
            //Two start,end changing conditions
            if(arr[start]>=arr[mid]){
                end = mid-1;
            }else{              //if(arr[start]<arr[mid])
                start = mid+1;
            }
        }
        return -1;
    }


    public static int binarySearch(int[] arr,int target,int start,int end){
        while (start<=end){
            int mid = start+(end-start)/2;     
            if (arr[mid]<target)
                start = mid+1;
            else if(arr[mid]>target)
                end=mid-1;
            else
                return mid;    
        }
        return -1; 
    }

}

/*
24 APR 2022
NOTE:

1.FIRST FIND THE PIVOT: AS IT IS SORTED ARRAY, IF ARRAY IS ROTATED THE LARGEST ELEMENT IS THE PIVOT IN ARRAY. 
    1.1 TO FIND THE PIVOT 4 CONDITIONS ARE THERE. 
        TWO CONDITIONS RETURN PIVOT
        TWO CONDITIONS TO CHANGE START AND END

2.NOW APPLY BINARY SEARCH
    2.1 IF PIVOT NOT FOUND THEN ARRAY IS NOT ROTATED: APPLY BINARY SEARCH TO WHOLE ARRAY.
    2.2 IF PIVOT != -1 THEN ARRAY IS ROTATED
        2.2.1 IF PIVOT ELEMENT == TARGET
        2.2.2 IF TARGERT >= START ELEMENT 
        2.2.3 IF TARGET < START ELEMENT
*/