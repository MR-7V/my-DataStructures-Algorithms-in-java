//410. Split Array Largest Sum
//https://leetcode.com/problems/split-array-largest-sum/
class SplitArrayLargestSum {
    
    public static void main(String[] args){
        int arr[]={7,2,5,10,8};
        int m = 1;
        System.out.println(splitArray(arr,m));    }

    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;
        
        //FINDING THE RANGE (START,END) TO APPLY BINARY SEARCH. 
        for(int i=0;i<nums.length;i++){
            start = Math.max(start,nums[i]); //TO GET MAX ELE IN ARRAY
            end += nums[i]; //SUM OF ARRAY.
        }

        //UNTILL START == END WE RUN THE ITERATION. 
        while(start<end){   
            //TRY MIDDLE AS POTENTIAL ANSWER. 
            int mid = start+(end-start)/2;

            int sum = 0;
            int pieces = 1;
            for(int num: nums){
                if(sum + num > mid){
                    sum = num;      //RESETTING THE SUM VALUE, MAKING SUM VALUE EQUAL TO NUM. 
                    pieces++;       //MAKING PIECES++ AS WE ADDED NEW CHUNK. 
                    if(pieces>m){
                        start=mid+1;
                        break; 
                    }
                }
                else{
                    sum+=num;   //IF NOT ADD NUM TO SUM.
                }
            }
            if(pieces<=m)
                end=mid;
            /*if(pieces>m){
                start=mid+1;    //IF THE NUMBER OF PIECES ARE MORE THAN M, THEN INCREASE THE TARGET. START=MID+1
            }else{
                end=mid;    //IF THE NUMBER OF PIECES ARE LESS OR EQUAL TO M, THEN DECREASE THE TARGET. END=MID
            }*/
        }
        return end;     //AT LAST START AND END VALUE WILL BE EQUAL. (START==MID==END)
    }
}

/*
2 MAY 2022
NOTE:
    1.THIS ARRAY DOESNT NEED TO BE SORTED, HERE WE APPLY BINARY SEARCH BY THE "MAX ELE IN ARRAY" & "SUM OF ARRAY" . 
    2.IF THE START AND END VALUE ARE SAME THE ANSWER IS FOUND. (START==MID==END). 
    3.RETURN END. 
*/