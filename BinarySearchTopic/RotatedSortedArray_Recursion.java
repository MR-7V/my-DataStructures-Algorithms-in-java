
public class RotatedSortedArray_Recursion {
    public static void main(String[] args){
        int arr[]={3,4,5,6,7,8,0,1,2};
        //int arr[]={3,1};
        int target=1;
        int result = search(arr, 0, arr.length-1, target);
        System.out.println(result);
    }

    public static int search(int[] arr,int start,int end,int target){
        if(start>end)
            return -1;
        int mid = start+(end-start)/2;
        if(arr[mid]==target)
            return mid;
        /* If arr[l...mid] first subarray is sorted */
        if(arr[start]<=arr[mid]){
            /* As this subarray is sorted, we
                can quickly check if key lies in
                half or other half */
            if(target>=arr[start] && target<arr[mid])
                return search(arr, start, mid-1, target);
            /*If key not lies in first half subarray,
            Divide other half  into two subarrays,
            such that we can quickly check if key lies
            in other half */
            return search(arr,mid+1,end,target);
        }
        /* If arr[l..mid] first subarray is not sorted,
            then arr[mid... h] must be sorted subarray*/
        if(target>arr[mid] && target<=arr[end])
            return search(arr,mid+1,end,target);
        return search(arr, start, mid-1, target);
    }
}

/*
27 APR 2022
NOTE:
    1. USE RECURSION ALGORITHM.
*/
