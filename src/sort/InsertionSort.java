package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] integers = {4, 5, 3, 6, 2};
        sort(integers);
        System.out.println(Arrays.toString(integers));
    }

    private static <T extends Comparable<T>> void sort(T[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            T key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(key) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}
