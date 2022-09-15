class ProductOfArrayExceptItself{
    public static void main(String[] args){
        long arr[] = {1,2,3,4};
        int n = arr.length;
        long result[] = new long[n];
        result = productExceptSelf(arr,n);
        for(int i=0;i<n;i++){
            System.out.println(result[i]);
        }
    }

    public static long[] productExceptSelf(long nums[], int n) 
	{ 
        long[] arr = new long[n];
        long prod = 1,flag = 0 ;
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                flag+=1;
            else
                prod*=nums[i];
        }
        for(int i=0;i<n;i++){
            if(flag>1)
                arr[i]=0;
            else if(flag==1 && nums[i]!=0)
                arr[i]=0;
            else if(flag==1 && nums[i]==0)
                arr[i]=prod;
            else if(flag==0)
                arr[i]=prod/nums[i];
                
        }
        return arr;
	} 
}