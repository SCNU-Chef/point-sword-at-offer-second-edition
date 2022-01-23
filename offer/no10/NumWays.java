package offer.no10;

/**
 * @author Toreno Li
 * 和fib基本一致,除了初始值不一样
 */
public class NumWays {
    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        final int MOD = (int) (1e9 + 7);
        int a = 1;
        int b = 1;
        for (int i = 1; i < n; i++) {
            a = a + b;
            b = a - b;
            a = a % MOD;
        }
        return a;
    }
}
