//we use silding window
//https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1

class MinimumSwapsAndKTogether{
    public static void main(String args[]){
        int arr[] = {2, 7, 9, 5, 8, 7, 4};
        int n = arr.length;
        int k = 6;
        int result = minSwap (arr, n, k);
        System.out.println(result);
    }

    static int minSwap (int arr[], int n, int k) {
        int goodNum = 0;
        for(int i=0;i<n;i++){
            if(arr[i]<=k)
                goodNum++;
        }
        int badNum = 0;
        for(int i=0;i<goodNum;i++){
            if(arr[i]>k)
                badNum++;
        }
        int minBad = badNum;
        for(int i=0,j=goodNum;j<n;i++,j++){
            if(arr[i]>k)
                badNum--;
            if(arr[j]>k)
                badNum++;
            minBad = Math.min(minBad,badNum);
        }
        return minBad;
    }
}