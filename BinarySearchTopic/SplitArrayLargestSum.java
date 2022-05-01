class SplitArrayLargestSum {
    
    public static void main(String[] args){
        int arr[]={7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(arr,m));    }

    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        
        for(int i=0;i<nums.length;i++){
            start = Math.max(start,nums[i]); //TO GET MAX ELE IN ARRAY
            end += nums[i]; //SUM OF ARRAY.
        }

        while(start<end){
            //TRY MIDDLE AS POTENTIAL ANSWER. 
            int mid = start+(end-start)/2;

            int sum = 0;
            int pieces = 1;
            for(int num: nums){
                if(sum + num > mid){
                    sum = num;
                    pieces++;
                }
                else{
                    sum+=num;
                }
            }
            if(pieces>m){
                start=mid+1;
            }else{
                end=mid;
            }

        }

        return end;
    }
}