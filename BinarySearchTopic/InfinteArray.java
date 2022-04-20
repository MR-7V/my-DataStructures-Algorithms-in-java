//To find target in sorted infinte array by using binary search.
public class InfinteArray{  
        public static void main(String[] args){
            int arr[]={2,3,5,6,7,8,10,11,12,15,20,23,30,32};
            int target=15;
            int result=ans(arr, target);
            System.out.println(result);
        }


        //finds the chuck(start,end) where does the target lies and pass (start,end) to binarySearch().
        public static int ans(int[] arr,int target){
            //first find the range
            //first start with a box of size 2
            int start=0;
            int end=1;
            while(target>arr[end]){     //untill arr[end]>target, we grow the size of our chunk exponential(double it).
                int temp=end+1;          //save the end value in temp.so,we will use it to create next start.
                end=end+(end-start+1)*2;     //double the chunk size: end=prev_end+(sizeofbox*2)   
                start=temp;
            }
            int ans=binarySearch(arr, target, start, end);
            return ans;
        }
        
        
        public static int binarySearch(int[] arr,int target,int start, int end){
            while (start<=end){
                int mid = start+(end-start)/2;     
                if (arr[mid]<target){
                    start = mid+1;
                }
                else if(arr[mid]>target){
                    end=mid-1;
                }
                else{   
                    return mid;     
                }
            }
            return -1;  
        }
}

/*
To find target in sorted infinte array by using binary search.
NOTE:
1.We cannot create a infinte array instead we just consider not to use arr.length
2.We cannot search target without start and end in binary search. 
3.We will search chunk by chunk in an array. 
20 APR 2022
*/
