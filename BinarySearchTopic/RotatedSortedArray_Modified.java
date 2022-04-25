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

    public static int search(int[] arr,int start,int end,int target){
        if(start>end)
            return -1;
        int mid = start+(end-start)/2;
        
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
        
        else if(arr[start]<=arr[mid]){
            if(target>=arr[start] && target<=arr[mid])
                return search(arr, start, mid-1, target);
            return search(arr, mid+1, end, target);
        }
        else if(target>=arr[mid] && target<=arr[end])
            return search(arr,mid+1,end,target); 
        return search(arr,start,mid-1,target);
    }

}
