//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
//use mid-high method

class Sort123{
    public static void main(String[] args) {
        int arr[] = {0,1,2,0,1};
        sort012(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
	}
	
	static void sort012(int[] arr){ 
        int low = 0,mid = 0,high = arr.length-1;
        while(mid<=high){
            switch(arr[mid]){
                case 0:
                    swap(arr, mid,low);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid,high);
                    high--;
                    break;
            }
        }
	}
	
	static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
	}
}

*/
11 AUG 2022

TC: O(N)
SC: O(1)
*/