//we use two pointer approach
//https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1

class SmallestSubarrayWithSumGreaterThanX{
    public static void main(String args[]){
        int arr[] = {1, 4, 45, 6, 0, 19};
        int n = arr.length;
        int x = 51;
        int result = smallestSubWithSum(arr,n,x);
        System.out.println(result);
    }

    public static int smallestSubWithSum(int a[], int n, int x) {
        int currSum = 0,minLen = n+1;
        int start = 0,end = 0;
        while(end<n){
            while(currSum<=x && end<n)
                currSum+=a[end++];
            while(currSum>x && start<n){
                minLen=Math.min(minLen,end-start);
                currSum-=a[start++];
            }
        }
        return minLen;
    }
}

/*
1 AUG 2022
ALGORITHM:

STEP 1:
    while (end<n)
    STEP 1.1:
        until currSum<=x add right ele 
    STEP 1.2:
        until currSum>x try to reduce the left part 
        update minLen 
*/