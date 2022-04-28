class RotationCount {
    public static void main(String[] args){
        int arr[]={3,4,5,6,7,8,0,1,2};
        //int arr[]={3,1,2};
        int pivot = findPivotInRotatedArray(arr);
        if(pivot==-1)   
            System.out.println("Array not rotated");
        else
            System.out.println("Array is rotated "+(++pivot)+" times.");
    }


    public static int findPivotInRotatedArray(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            //Two return conditions
            if(mid<end && arr[mid]>arr[mid+1])  //to avoid array index out of bound, make sure that mid<end
                return mid;
            if(mid>start && arr[mid]<arr[mid-1])    //to avoid negitive indexing, make sure that mid>start
                return mid-1;
            //Two start,end changing conditions
            if(arr[start]>=arr[mid]){
                end = mid-1;
            }else{              //if(arr[start]<arr[mid])
                start = mid+1;
            }
        }
        return -1;
    }
}