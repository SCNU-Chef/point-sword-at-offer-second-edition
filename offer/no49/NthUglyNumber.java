package offer.no49;

/**
 * @author Toreno Li
 * 每次用已经得到的丑数，计算出下一个丑数
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;
        int i = 0;
        int j = 0;
        int k = 0;
        for (int index = 1; index < n; index++) {
            int minUgly = Math.min(Math.min(result[i] * 2, result[j] * 3), result[k] * 5);
            if (result[i] * 2 == minUgly) {
                i++;
            }
            if (result[j] * 3 == minUgly) {
                j++;
            }
            if (result[k] * 5 == minUgly) {
                k++;
            }
            result[index] = minUgly;
        }
        return result[n - 1];
    }
}
