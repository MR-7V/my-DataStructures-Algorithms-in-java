//153. Find Minimum in Rotated Sorted Array
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinInRotatedSorted {
    public static void main(String args[]){
        int arr[]={3,3,3,3,3,3,3,4,5,6,7,8};
        int result=findMin(arr);
        System.out.println(result);
    }
    public static int findMin(int[] nums) {
        int pivot = search(nums,0,nums.length-1);
        if (pivot==-1)
            return nums[0];
        return nums[pivot+1];
    }
    
    public static int search(int[] arr,int start,int end){
    if(start>end)
        return -1;
    int mid=start+(end-start)/2;
    if(mid<arr.length-1 && arr[mid]>arr[mid+1])
        return mid;
    if(mid>0 && arr[mid]<arr[mid-1])
        return mid-1; 
    if(arr[start]<arr[mid])
        return search(arr,mid,end);
    return search(arr,start,mid-1);
    }
}

/* 
30 APR 2022 12:22AM
NOTE:
1.THIS CODE PRINTS THE MINIMUM NUMBER IN THE ROTATED SORTED ARRAY.
*/