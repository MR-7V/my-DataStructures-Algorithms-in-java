/*It is completly binary search algorithm, but when target is not found just return "END" instead of "-1" */

public class FloorOfANumber {
    public static void main(String[] args){
        int arr[]={2,3,7,14,19,21};
        int target=1;
        int result=flooring(arr, target);
        System.out.println(result);
    }
    
    //returns num which is greatest <= to target.
    public static int flooring(int[] arr,int target){
        
        if(target<arr[0])  //if target is less than first element return -1.
            return -1;     //even if you dont write this cond. also this algorithm will return -1.

        int start = 0;
        int end = arr.length-1;

        while (start<=end){       
            int mid = start+(end-start)/2;      
            if (arr[mid]<target){
                start = mid+1;
            }
            else if(arr[mid]>target){
                end=mid-1;
            }
            else{                
                return mid;    //this logic doesnot need if(arr[mid]==target) condition to return answer.
            }
        }
        return end;   //if target is not found then return "end" which will be the greatest smaller number.
    }
}

/* 
    NOTES:

    1.In last iteration of binary search start=mid=end.
    2.If the target element is not present in the array then while(start<=end) condition will be voilated 
        and the start will become "start=end+1". 
    3.If target is in array: "START TARGET END"      so,return MID
    4.If target is not in array: "END TARGET START"  so,return END
*/