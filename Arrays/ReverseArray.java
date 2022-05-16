//https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
//Write a program to reverse an array or string

class ReverseArray {
    
    public static int[] reverseArray(int[] arr){
        int start = 0;
        int end = arr.length-1;
        int temp;

        //swap start and end. 
        while(start < end){
            temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
        return arr;
    }

    public static void printArray(int arr[],int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
            System.out.println();
    }

    public static void main(String args[]){
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, 6);
        reverseArray(arr);
        System.out.print("Reversed array is \n");
        printArray(arr, 6);
        
    }
}

/*

OUTPUT:
1 2 3 4 5 6 
Reversed array is 
6 5 4 3 2 1 
Time Complexity : O(n).
*/