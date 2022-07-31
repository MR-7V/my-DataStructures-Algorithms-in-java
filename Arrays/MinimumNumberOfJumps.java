//https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
//we use maxReach approch because we need to get less jumps.

class MinimumNumberOfJumps{
    public static void main(String args[]){
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int result = minJumps(arr);
        System.out.println(result);
    }

    static int minJumps(int[] arr){
        int n = arr.length;
        if(n==1)
            return 0;
        if(arr[0]==0)
            return -1;
        
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for(int i=1;i<n;i++){
            if(i==n-1)
                return jump;
            maxReach = Math.max(maxReach,i+arr[i]);
            step--;
            
            if(step==0){
                jump++;
                if(i>=maxReach)
                    return -1;
                step = maxReach-i;
            }
        }
        return -1;
    }
}

//31 jul 2022
/*
ALGORITHM:
    Step 1:
        if there is only one number return 0
    Step 2:
        if there is zero at arr[0] return 1
    Step 3:
        declare 3 varibles 
            maxReach=arr[0]
            step=arr[0]
            jumps=1
    Step 4:
        find the maxReach for each element
        step--
        Step 4.1:
            if step==0:
                jump++;
            Step 4.1.1:
                check whether the reach to end is possible 
                if(i>=maxReach)
                    return not possible
    Step 5:
        change step = maxReach - i
*/
