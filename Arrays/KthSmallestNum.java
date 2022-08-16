//https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1

public class KthSmallestNum {
    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 20, 15 };
        int k = 4;
        System.out.println(kthSmallest(arr, k));
    }

    public static int kthSmallest(int[] arr, int k) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        boolean serial[] = new boolean[max + 1];
        for (int i = 0; i < arr.length; i++) {
            serial[arr[i]] = true;
        }
        int count = 0;
        for (int i = 0; i < serial.length; i++) {
            if (serial[i])
                count++;
            if (count == k)
                return i;
        }
        return -1;
    }
}
