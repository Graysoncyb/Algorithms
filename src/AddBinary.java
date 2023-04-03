import java.util.Arrays;

public class AddBinary {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 1};
        int[] b = new int[]{1, 1, 1};
        System.out.println(Arrays.toString(addBinary(a, b)));
    }

    private static int[] addBinary(int[] a, int[] b) {
        int carry = 0;
        int[] c = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            int sum = a[i] + b[i] + carry;
            c[i] = sum % 2;
            carry = sum / 2;
        }
        c[a.length] = carry;
        return c;
    }
}
