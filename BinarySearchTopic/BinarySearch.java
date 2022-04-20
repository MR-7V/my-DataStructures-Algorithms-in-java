public class BinarySearch{

    public static void main(String[] args){
        int arr[]={1,2,3,4,5,6,7};
        int target=1;
        int result=binarySearch(arr, target);
        System.out.println(result);
    }

    public static int binarySearch(int[] arr,int target){

        int start = 0;
        int end = arr.length-1;

        while (start<=end){
        
            //int mid = (start+end)/2;   This might be possible that (start+end) will exceed the java integer range.
            int mid = start+(end-start)/2;     //so,we use this expression.

            if (arr[mid]<target){
                start = mid+1;
            }
            else if(arr[mid]>target){
                end=mid-1;
            }
            else{   //this logic doesnot need if(arr[mid]==target) condition to return answer.
                return mid;     //if element found.
            }
        }
        return -1;  //if element is not present in array.
    }
}