package offer.no47;

/**
 * @author Toreno Li
 * 回溯会爆时间
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row + 1][column + 1];
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < column + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }
}
