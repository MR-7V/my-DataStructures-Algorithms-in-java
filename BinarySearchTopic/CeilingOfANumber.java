/*It is completly binary search algorithm, but when target is not found just return "START" instead of "-1" */

public class CeilingOfANumber {
    public static void main(String[] args){
        int arr[]={2,3,7,14,19,21};
        int target=6;
        int result=ceiling(arr, target);
        System.out.println(result);
    }
    
    //returns num which is smallest >= to target.
    public static int ceiling(int[] arr,int target){
        
        if (target>arr[arr.length-1])      //cond. if the target is greater than the last element.
            return -1;

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
                return mid;     //this logic doesnot need if(arr[mid]==target) condition to return answer.
            }
        }
        return start;  //if target is not found then return "start" which will be the smallest greater number.
    }
}


/* 
    NOTES:

    1.In last iteration of binary search start=mid=end.
    2.If the target element is not present in the array then while(start<=end) condition will be voilated 
        and the start will become "start=end+1". 
    3.If target is in array: "START TARGET END"      so,return MID
    4.If target is not in array: "END TARGET START"  so,return START
*/