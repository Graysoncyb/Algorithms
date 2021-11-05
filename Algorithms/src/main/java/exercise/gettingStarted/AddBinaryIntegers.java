package exercise.gettingStarted;

import java.util.Arrays;

public class AddBinaryIntegers {
    /**
     * loop invariant: 每次循环前，result[i+2..n]为x/y[i-1..n-1]的计算结果
     * initialization:
     * maintenance:
     * termination:
     */
    // i=n-1, 没有计算
    // i=n-2, result[n]
    // i=n-3, result[n-1]
    public static int[] add(int[] x, int[] y) {
        int[] result = new int[x.length + 1];
        int carry = 0;
        for (int i = x.length - 1; i >= 0; i--) {
            result[i + 1] = (x[i] + y[i] + carry) % 2;
            carry = (x[i] + y[i] + carry) / 2; // 向下取整
        }
        result[0] = carry;
        return result;
    }

    public static void main(String[] args) {
        int[] x1 = new int[]{1};
        int[] y1 = new int[]{1};
        System.out.println(Arrays.toString(add(x1, y1)));

        int[] x2 = new int[]{1, 0};
        int[] y2 = new int[]{0, 1};
        System.out.println(Arrays.toString(add(x2, y2)));
        int[] x3 = new int[]{1, 1};
        int[] y3 = new int[]{1, 1};
        System.out.println(Arrays.toString(add(x3, y3)));
    }
}
