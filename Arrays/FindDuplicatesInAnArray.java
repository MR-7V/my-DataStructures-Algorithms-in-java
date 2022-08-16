////https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1

import java.util.ArrayList;

public class FindDuplicatesInAnArray {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        int[] arr = { 1, 2, 3, 3, 4, 5, 6, 1, 3, 2 };
        al = duplicates(arr, arr.length);
        for (int i = 0; i < al.size(); i++)
            System.out.println(al.get(i));
    }

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int[] countArr = new int[n];
        for (int ele : arr) {
            countArr[ele]++;
        }
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 1)
                al.add(i);
        }
        if (al.size() == 0)
            al.add(-1);
        return al;
    }
}
