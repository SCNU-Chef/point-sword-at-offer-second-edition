package offer.no42;

/**
 * @author Toreno Li
 * 动态规划入门!
 * 对于nums[i],要么取之前累加的和+nums[i],要么以nums[i]为首重新开始累加
 * 用O(n)的空间换取了O(n)的时间
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
