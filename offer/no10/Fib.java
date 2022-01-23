package offer.no10;

import java.util.logging.Logger;

/**
 * @author Toreno Li
 * leetcode有n的范围为0-100
 * 递归直接爆时间
 * 第三种用循环去做应该是比较好的解法
 * 书上还提到了时间复杂度为O(logn)的解法
 */
public class Fib {
    final int MOD = (int) (1e9 + 7);

    public int fib1(int n) {
        // 这里可以采取构造长度为n+1的数组
        int[] result = new int[101];

        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < result.length; i++) {
            result[i] = (result[i - 1] % MOD + result[i - 2] % MOD) % MOD;
        }

        return result[n];
    }

    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return (fib2(n - 1) % MOD + fib2(n - 2) % MOD) % MOD;
    }

    public int fib3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 1;
        int b = 0;
        for (int i = 1; i < n; i++) {
            a = a + b;
            b = a - b;
            a = a % MOD;
        }
        return a;
    }
}
