package sort;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Objects.compare;

/**
 * sort1比sort2少了交换的三次操作，效率更高
 */
public class InsertSort {

    private InsertSort(){}

    public static <T extends Comparable<T>> void sort1(T[] s, int l, int h) {
        sort1(s, l, h, Comparator.naturalOrder());
        System.out.println(Arrays.toString(s));
    }

    public static <T extends Comparable<T>> void sort1(T[] s, int l, int h, Comparator<T> c) {
        for (int i = l; i <= h; i++) {
            T t = s[i];
            int j;
            for (j = i; j - 1 >= l && less(t, s[j - 1], c); j--) {
                s[j] = s[j - 1];
            }
            s[j] = t;
        }
    }

    public static <T extends Comparable<T>> void sort2(T[] s, int l, int h) {
        sort2(s, l, h, Comparator.naturalOrder());
        System.out.println(Arrays.toString(s));
    }

    public static <T extends Comparable<T>> void sort2(T[] s, int l, int h, Comparator<T> c) {
        for (int i = l + 1; i <= h; i++) {
            for (int j = i; j >= 0 && less(s[j], s[j - 1], c); j--) {
                swap(s, j, j - 1);
            }
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

        sort1(test1, 0, test1.length - 1);
        sort2(test1, 0, test1.length - 1);
        sort1(test2, 0, 0);
        sort2(test2, 0, 0);
        sort1(test3, 0, test3.length - 1);
        sort2(test3, 0, test3.length - 1);
    }

}
