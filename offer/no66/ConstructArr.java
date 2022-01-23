package offer.no66;

/**
 * @author Toreno Li
 * 第一次循环求左半边的乘积，第二次循环求右半边的乘积
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {
        int left = 1;
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = left;
            left *= a[i];
        }
        int right = 1;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= a[i];
        }
        return result;
    }
}