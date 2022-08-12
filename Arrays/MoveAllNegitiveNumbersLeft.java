//https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1

import java.util.*;

class MoveAllNegitiveNumbersLeft{
    public static void main(String[] args){
        int arr[] = {2,-1,4,-2,5,7};
        segregateElements(arr);
        for(int i =0;i<arr.length;i++)
            System.out.println(arr[i]+" ");
    }

    public static void segregateElements(int arr[])
    {
        Stack<Integer> stackPositive = new Stack<Integer>();
        Stack<Integer> stackNegitive = new Stack<Integer>();

        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]<0)
                stackNegitive.push(arr[i]);
            else 
                stackPositive.push(arr[i]);
        }
        int arrIndex = 0;
        while(!stackPositive.isEmpty()){
            arr[arrIndex++]=stackPositive.pop();
        }
        while(!stackNegitive.isEmpty()){
            arr[arrIndex++]=stackNegitive.pop();
        }
    }
}