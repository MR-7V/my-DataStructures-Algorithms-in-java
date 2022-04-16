public class SmallestLetter {
    public static void main(String[] args){
        char arr[]={'c','f','j'};
        char target='z';
        char result=smallestGreaterLetter(arr, target);
        System.out.println(result);
    }
    
    //returns letter smallest greater than target.
    public static char smallestGreaterLetter(char[] arr,char target){
        int start = 0;
        int end = arr.length-1;

        while (start<=end){       
            int mid = start+(end-start)/2;      
            if (target<arr[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;  //we ignore letter equal to target.
            }
        }
        return arr[start % arr.length];  //letters are wrapped up so we use % operator to return first ele .
    }
}

/* 
    NOTES:
    1.Exact equal to ceiling binary search algorithm of number. 
    2.Ignore the target letter what we are looking for. 
    3.Normal binary search algo have 3 checks but this algo have 2 checks we ignore "equal to" condition. 
    4.They gave letters wrap together.so, we use modulo.
        4.1 If there is no letter greater than target in given arr : return first letter.
*/