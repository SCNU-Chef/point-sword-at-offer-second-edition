package offer.no46;

/**
 * @author Toreno Li
 * 青蛙跳台阶变版,简单的动态规划
 * dp[0]无意义,只是为了方便计算
 */
public class TranslateNum {
    public int translateNum(int num) {
        String numString = Integer.toString(num);
        int[] dp = new int[numString.length() + 1];
        dp[1] = dp[0] = 1;
        for (int i = 2; i <= numString.length(); i++) {
            String sub = numString.substring(i - 2, i);
            if (sub.compareTo("25") <= 0 && sub.compareTo("10") >= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }
}