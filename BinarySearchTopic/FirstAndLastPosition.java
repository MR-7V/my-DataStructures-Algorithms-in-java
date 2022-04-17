import java.util.Arrays;
public class FirstAndLastPosition {
    public static void main(String[] args){
        int arr[]={1,2,4,6,7,7,7,7,9};
        int target=7;
        int[] result=firstandlastindex(arr, target);
        System.out.println(Arrays.toString(result));  //the for loop has been replaced by a single line of code using Arrays.toString() function.
    }

    public static int[] firstandlastindex(int[] arr,int target){
        int[] ans={-1,-1};   //make default values.so, that no need to write extra condition when target is not found.
        ans[0]=binarySearch(arr,target,true);
        if(ans[0]!=-1)  //if start is not found then no need to search the end.
            ans[1]=binarySearch(arr,target,false);
        return ans;
    }

    //binery search algo but we use extra boolean type to separate the start,end searches.
    public static int binarySearch(int[] arr,int target,boolean findStartElement){
        int start = 0,ans=-1;
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
                ans=mid; //make the ans=mid,it will be overwritten if the target is found one more time.
                if (findStartElement)//for start index,search left side
                    end=mid-1;
                else            //for end index,search right side
                    start = mid+1;
            }
        }
        return ans;  
    }
}


/*
NOTE:

1. THIS FIRST AND LAST INDEX FINDING BINARY SEARCH ALGORITHM WORKS FOR ONLY FOR SORTED ARRAY.
*/