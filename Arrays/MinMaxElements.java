//Maximum and minimum of an array using minimum number of comparisons
//https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

class MinMaxElements {
    
    public static class Pair{
        int min;
        int max;
    }

    public static Pair getMinMax(int[] arr,int n){
        Pair minmax = new Pair();
        int i;

        if(n%2==0){
            if(arr[0]>arr[1]){
                minmax.min = arr[1];
                minmax.max = arr[0];
            }
            else{
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i=2;
        }
        else{
            minmax.min=arr[0];
            minmax.max=arr[1];
            i=1;
        }

        while(i<n-1){
            if (arr[i]>arr[i+1]){
                if(minmax.max < arr[i])
                    minmax.max = arr[i];
                if(minmax.min > arr[i+1])
                    minmax.min = arr[i+1];
            }
            else{
                if(minmax.max < arr[i+1])
                    minmax.max = arr[i+1];
                if(minmax.min > arr[i])
                    minmax.min = arr[i];
            }
            i+=2;
        }
        return minmax;
    }

    public static void main(String args[]) {
        int arr[] = {7979, 987, 5, 108, 3, 83 ,0, 30, 8, 90, 450, -8};
        int arr_size = arr.length;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }
}

/*
15 MAY 2022
NOTE:
    Time Complexity: O(n)
    Auxiliary Space: O(1) as no extra space was needed.
    
    If n is odd:    3*(n-1)/2  
    If n is even:   1 Initial comparison for initializing min and max, 
                and 3(n-2)/2 comparisons for rest of the elements  
                =  1 + 3*(n-2)/2 
                =  3n/2 -2
*/