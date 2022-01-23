package offer.no14;

/**
 * @author Toreno Li
 * 1.动态规划,dp数组中存储的是n>=4时的最优解,n<4时直接返回最优解
 * 因为题目要求必须划分至少一次,所以n=3时的最优解(解为2) 并非 为因子时的最优解(解为3)
 * 2.数论/贪心
 * 最后剩下4的时候,应取2*2非1*3(这段代码太巧妙了)
 * 3.数据规模大的时候
 * 动态规划的方法可以采用BigInteger代替int
 * 数论方法则可以在合适位置取余,注意运算过程中sum应为long类型,最后在转换为int
 */
public class CuttingRope {
    public int cuttingRope1(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = -1;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dp[j] * dp[i - j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public int cuttingRope2(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int sum = 1;
        while (n > 4) {
            sum *= 3;
            n -= 3;
        }
        return sum * n;
    }

    public int cuttingRope3(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long sum = 1;
        while (n > 4) {
            sum *= 3;
            sum %= 1000000007;
            n -= 3;
        }
        return (int) (sum * n % 1000000007);
    }
}
