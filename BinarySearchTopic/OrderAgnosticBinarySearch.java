//THIS ORDER AGNOSTIC BINARY SEARCH ALGORITHM WORKS FOR BOTH ASCENDING AND DESCENDING ORDER.

class OrderAgnosticBinarySearch {
    public static void main(String[] args){
        //int arr[] = {-99,-2,0,2,34,45,55,64,78}; //ascending order.
        int arr[] = {78,64,55,45,34,2,0,-2,-99};    //desending order.
        int target = 64;
        int result=orderAgnosticBinarySearch(arr, target);
        System.out.println(result);
    }

    public static int orderAgnosticBinarySearch(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;

        while (start<=end){

            int mid = start+(end-start)/2;  
            boolean isAlpha=arr[start]<arr[end];  //to know the order of array.

            if(arr[mid]==target){   //common part for both ascending and descending,
                //because we are writing the return mid cond statement first we must write if(arr[mid]==target) conditon.
                return mid;
            }

            if (isAlpha){       //if array is ascending order
                if (arr[mid]<target){
                    start = mid+1;
                }
                else{  
                    end=mid-1;
                }
            }
            else{               //if array is decending order
                if (arr[mid]>target){
                    start = mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return -1;  //if element is not present in array.
    }
}
