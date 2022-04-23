//1095. Find in Mountain Array
//https://leetcode.com/problems/find-in-mountain-array/

class FindInMountainArray {
    public static void main(String[] args){
        int arr[]={1,2,4,5,4,3,2,1,0};
        int target=3;
        int result=search(arr, target);
        System.out.println(result);
    }

    public static int search(int[] arr,int target){
        int peak=findThePeakElement(arr);   //FIRST FIND THE PEAK ELEMENT TO DIVIDE ARRAY INTO {ASCENDING PEAK DESCENDING}
        int firstTry=orderAgnosticBinarySearch1(arr, target,0,peak);    //CHECK ASCENDING PART 
        if (firstTry!=-1)
            return firstTry;    //ELSE CHECK DESCENDING PART.
        else
            return orderAgnosticBinarySearch1(arr, target,peak+1,arr.length-1);
    }

    public static int findThePeakElement(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
    }

    public static int orderAgnosticBinarySearch1(int[] arr,int target,int start,int end){
        if(arr[start]<=arr[end]){  
            while(start<=end){
                int mid=start+(end-start)/2;
                if(arr[mid]<target)
                    start=mid+1;
                else if(arr[mid]>target)
                    end=mid-1;
                else
                    return mid;
            }
        }

        else if(arr[start]>arr[end]){
            while(start<=end){
                int mid=start+(end-start)/2;
                if(arr[mid]<target)
                    end=mid-1;
                else if(arr[mid]>target)
                    start=mid+1;
                else
                    return mid;
            }
        }
        return -1;
    }

}

