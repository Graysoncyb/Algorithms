import edu.princeton.cs.algs4.InsertionX;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Yuanbin Cai
 * @date 2022/7/24
 **/
public class Test {
    public static void main(String[] args) {
        Integer[] a = {6,5,4,3,2,1};
        InsertionX.sort(a);
        show(a);
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
