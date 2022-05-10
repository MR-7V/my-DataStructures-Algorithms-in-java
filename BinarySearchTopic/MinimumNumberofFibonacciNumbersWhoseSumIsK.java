import java.util.ArrayList;
import java.util.Scanner;

class MinimumNumberofFibonacciNumbersWhoseSumIsK{
    
    public static ArrayList<Integer> findFib(int max){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(0);
        numbers.add(1);
        while(numbers.get(numbers.size()-2)+numbers.get(numbers.size()-1)<=max){
            numbers.add( numbers.get(numbers.size()-2) + numbers.get(numbers.size()-1) );
        }
        return numbers;
    }

    //Floor of a number algorithm.
    public static int binarySearch(ArrayList<Integer> arr, int target){
        int start = 0;
        int end = arr.size()-1;
        while (start<=end){
            int mid = start+(end-start)/2; 
            if(arr.get(mid)==target)
                return mid;
            if(arr.get(mid)<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return end;
    }


    public static int search(ArrayList<Integer> nums,int k){
        int num_req = 1;
        int rem_req = k - nums.get(nums.size()-1);
        while (rem_req > 0){
            int index = binarySearch(nums,rem_req);
            num_req++;
            rem_req -= nums.get(index);
        }
        return num_req;
    }

    
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter k value:");
        int k = sc.nextInt();
        numbers = findFib(k);
        System.out.println(search(numbers,k));
    }


}