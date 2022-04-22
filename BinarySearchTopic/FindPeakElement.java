public class FindPeakElement {
    public static void main(String[] args){
        int arr[]={1,2,3,4,5,6,7,8,10,11,13,45,67,333,5644,6322,5,4,3,2,1};
        int result=findThePeakElement(arr);
        System.out.println(result);
    }

    public static int findThePeakElement(int[] arr){
        int start = 0;
        int end = arr.length-1;
        int mid=0;
        while (start<end){
            mid = start+(end-start)/2;     
            if (arr[mid]>arr[mid+1]){
                //YOU ARE IN THE DESCENDING PART OF ARRAY. 
                //THIS MAYBE THE ANSWER, BUT LOOKAT LEFT. 
                end = mid;
            }
            else /*if(arr[mid]<arr[mid+1])*/{
                //YOU ARE THE IN THE ASCENDING PART OF THE ARRAY. 
                start=mid+1;
            }
        }
        return arr[start]; 
    }
}


/* 
    NOTES: TO FIND THE PEAK ELEMENT {ASCENDING_OREDER   PEAK_ELEMENT    DESENDING_ORDER }

    1.IN THE END, START==END WILL POINT TO THE LARGEST ELEMENT BECAUSE OF THE ABOVE TWO CHECKS. 
    2.START AND END ARE ALWAYS TRYING TO FIND MAX ELEMENT BECAUSE OF THE ABOVE TWO CHECKS. 
    3.WHEN START AND END ARE POINTING TO THE SAME ELEMENT THEN THAT IS OUR MAX ELEMENT REQUIRED.
    4.MORE ELABORATION: AT EVERY POINT OF TIME FOR START AND END,THEY HAVE THE BEST POSSIBLE ANSWER TILL THAT TIME. 
        AND IF WE ARE SAYING ONE ITEM IS REMAINING,HENCE BECAUSE OF ABOVE LINE THAT IS THE BEST POSSIBLE ANSWER.
*/