//https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1

public class CyclicallyRotateAnArrayByOne {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        rotateByOne(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void rotateByOne(int[] arr) {
        int i = 0, j = arr.length - 1, temp;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
    }
}
