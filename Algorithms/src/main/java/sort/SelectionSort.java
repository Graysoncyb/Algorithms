package sort;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Objects.compare;

public class SelectionSort {
    private SelectionSort() {}

    public static <T extends Comparable<T>> void selectionSort(T[] s, int l, int h) {
        selectionSort(s, l, h, Comparator.naturalOrder());
    }

    public static <T extends Comparable<T>> void selectionSort(T[] s, int l, int h, Comparator<T> c) {
        for (int i = l; i <= h; i++) {
            int min = i;
            for (int j = i + 1; j <= h; j++) {
                if (less(s[j], s[min], c)) {
                    min = j;
                }
            }
            swap(s, i, min);
        }
    }

    private static <T> boolean less(T x, T y, Comparator<T> c) {
        return compare(x, y, c) < 0;
    }

    private static <T> void swap(T[] s, int i, int j) {
        T tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] test1 = new Integer[]{1, 4, 2, 6, 3, 5};
        Integer[] test2 = new Integer[]{1};
        Integer[] test3 = new Integer[]{};

        selectionSort(test1, 0, test1.length - 1);
        System.out.println(Arrays.toString(test1));
        selectionSort(test2, 0, 0);
        System.out.println(Arrays.toString(test2));
        selectionSort(test3, 0, test3.length - 1);
        System.out.println(Arrays.toString(test3));
    }

}
