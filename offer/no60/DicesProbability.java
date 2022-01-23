package offer.no60;

import java.util.Arrays;

/**
 * @author Toreno Li
 * 计算出现次数,然后除以总次数
 * 骰子数n,点和sum
 * f(n,sum)=f(n-1,sum-1)+f(n-1,sum-2)+f(n-1,sum-3)+f(n-1,sum-4)+f(n-1,sum-5)+f(n-1,sum-6)
 */
public class DicesProbability {
    public double[] dicesProbability(int n) {
        double[] result = new double[6];
        Arrays.fill(result, 1.0);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[6 * i - i + 1];
            for (int j = 0; j < temp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j - k < result.length && j - k >= 0) {
                        temp[j] += result[j - k];
                    }
                }
            }
            result = temp;
        }
        double value = Math.pow(1.0 / 6, n);
        for (int i = 0; i < result.length; i++) {
            result[i] *= value;
        }
        return result;
    }
}