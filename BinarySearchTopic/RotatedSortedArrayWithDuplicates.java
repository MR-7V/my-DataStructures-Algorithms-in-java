public class RotatedSortedArrayWithDuplicates {
    public static void main(String[] args){
        int arr[]={4,5,6,7,0,1,2,3,3};
        int target=3;
        int result = search(arr, target);
        System.out.println(result);
    }


    public static int search(int[] arr,int target){
        int pivot = findPivotInRotatedArray(arr);
        //if you did not found the pivot then the array is not rotated.
        if (pivot == -1)
            return binarySearch(arr, target, 0, arr.length-1);  //normal binary search.
        else{   
            //you will have one pivot & two ascending order arrays.
            if (target==arr[pivot])
                return pivot;
            //with the referance of start element choose between 2 ascending arrays. 
            if (target>=arr[0]) 
                return binarySearch(arr, target, 0, pivot-1);
            return binarySearch(arr, target, pivot+1, arr.length-1);
        }
    }


    public static int findPivotInRotatedArray(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            
            //1---->TWO CONDITIONS TO RETURN PIVOT
            if(mid<end && arr[mid]>arr[mid+1])  
                return mid;
            if(mid>start && arr[mid]<arr[mid-1])    
                return mid-1;
            
            //2---->CONDITION: IF arr[start]==arr[mid]==arr[end] THEN IGNORE DUPLICATES.(start++,end--)
            if(arr[start] == arr[mid] && arr[mid]== arr[end]){
                //NOTE: what if the start and end were the pivot, so check before ignore them..
                //check if start is pivot
                if(arr[start]>arr[start+1])
                    return start;
                start++;
                //check if end-1 is pivot: 
                if(arr[end]<arr[end-1])
                    return end-1;
                end--;
                /*
                NOTE FOR THIS LINE:
                ACTUALLY WE ARE NOT CHECKING WHETHER END IS PIVOT HERE. 
                IF END IS THE PIVOT THEN THE ARRAY IS NOT ROTATED.THE FUNCTION AUTOMATICALLY RETURNS -1. 
                WE ARE JUST CHECKING THE CONDITION RELATED TO END BEFORE IGNORING END. (i.e.we are checking for end-1)
                */
            }
            
            //3---->CONDITONS TO CHANGE THE START OR END. 
            //THERE MAYBE CHANCE THAT START==MID.SO, WE TAKE REFERANCE OF END TO CHANGE START. 
            if(arr[start]<arr[mid] || (arr[start]==arr[mid] && arr[mid]>arr[end])){
                start = mid+1;
            }else{              
                end = mid-1;;
            }
        }
        return -1;
    }


    public static int binarySearch(int[] arr,int target,int start,int end){
        while (start<=end){
            int mid = start+(end-start)/2;     
            if (arr[mid]<target)
                start = mid+1;
            else if(arr[mid]>target)
                end=mid-1;
            else
                return mid;    
        }
        return -1; 
    }
}

/*
25 APR 2022
NOTE:

1.FIRST FIND THE PIVOT: AS IT IS SORTED ARRAY, IF ARRAY IS ROTATED THE LARGEST ELEMENT IS THE PIVOT IN ARRAY. 
    1.1 TO FIND THE PIVOT 4 CONDITIONS ARE THERE. 
        TWO CONDITIONS RETURN PIVOT
        ONE CONDITION IF arr[start]==arr[mid]==arr[end]
        TWO CONDITIONS TO CHANGE START AND END
            HERE THERE MAY BE CHANCE THAT arr[start]==arr[mid].SO, MAKE REFERANCE OF END TO CHANGE THE START,END.

2.NOW APPLY BINARY SEARCH
    2.1 IF PIVOT NOT FOUND THEN ARRAY IS NOT ROTATED: APPLY BINARY SEARCH TO WHOLE ARRAY.
    2.2 IF PIVOT != -1 THEN ARRAY IS ROTATED
        2.2.1 IF PIVOT ELEMENT == TARGET
        2.2.2 IF TARGERT >= START ELEMENT 
        2.2.3 IF TARGET < START ELEMENT
*/
