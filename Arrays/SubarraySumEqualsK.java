import java.util.*;
class SubarraySumEqualsK{

    public static void main(String args[]){
        int arr[]={10,15,-5,15,-10,5};
        int sum = 5;
        subarraySum(arr,sum);
    }

    public static void subarraySum(int[] nums, int k){
        int currSum = 0;
        int start = 0, end = -1;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if (currSum-k==0){
                start = 0;
                end = i;
                break;
            }
            if(map.containsKey(currSum-k)){
                start = map.get(currSum-k)+1;
                end = i;
                break;
            }
            map.put(currSum,i);
        }
        if(end==-1)
            System.out.println("Not Found");
        else
            System.out.println(start+" "+end);
    }
}