//81. Search in Rotated Sorted Array II 
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

public class RotatedSortedArray_Modified{
    public static void main(String[] args){
        int arr[]={1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        //int arr[]={2,1,1,1,1};
        int target=2;
        int result = search(arr, 0, arr.length-1, target);
        System.out.println(result);
    }
    // Function to return the index of the
    // key in arr[l..h] if the key is present
    // otherwise return -1
    public static int search(int[] arr,int start,int end,int target){
        if(start>end)
            return -1;
        int mid = start+(end-start)/2;
        
        //if arr[start]==arr[mid]==arr[end] ignore the start,end. 
        //Before ignoring check whether start,end are the target or not.
        if(arr[start]==arr[mid] && arr[end]==arr[mid]){
            if(arr[start]==target)
                return start;
            start++;
            if(arr[end]==target)
                return end;
            end--;
            return search(arr, start, end, target);
        }

        else if(arr[mid]==target)
            return mid;
        
        // If arr[start...mid] is sorted
        else if(arr[start]<=arr[mid]){
            // As this subarray is sorted, we can quickly
            // check if key lies in any of the halves
            if(target>=arr[start] && target<=arr[mid])
                return search(arr, start, mid-1, target);
            // If key does not lie in the first half
            // subarray then divide the other half
            // into two subarrays such that we can
            // quickly check if key lies in the other half
            return search(arr, mid+1, end, target);
        }

        // If arr[l..mid] first subarray is not sorted
        // then arr[mid... h] must be sorted subarray
        else if(target>=arr[mid] && target<=arr[end])
            return search(arr,mid+1,end,target); 
        return search(arr,start,mid-1,target);
    }

}

/*
26 APR 2022
NOTE:
    SEARCH IN ROTATED SORTED ARRAY WITH DUPLICATES.
    1. WE MADE THIS USING RECURSIVE FUNCTION ALGORITHM OF BINARY SEARCH.
*/
