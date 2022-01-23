package offer.no13;

/**
 * @author Toreno Li
 * 这题的visited不用重置,因为题目是统计数量
 * 有关系dfs(m, n, k, x, y, visited) = dfs(m, n, k, x+1, y, visited)+1
 *      dfs(m, n, k, x, y, visited) = dfs(m, n, k, x-1, y, visited)+1
 *      dfs(m, n, k, x, y, visited) = dfs(m, n, k, x, y+1, visited)+1
 *      dfs(m, n, k, x, y, visited) = dfs(m, n, k, x, y-1, visited)+1
 * dfs中最后+1的原因是统计(x,y)这个格子
 * 非+4是因为会重复统计(x,y)
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[n][m];
        return dfs(m, n, k, 0, 0, visited);
    }

    private int dfs(int m, int n, int k, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= n || y < 0 || y >= m || (x / 10 + x % 10 + y / 10 + y % 10) > k || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        return dfs(m, n, k, x + 1, y, visited) +
                dfs(m, n, k, x - 1, y, visited) +
                dfs(m, n, k, x, y + 1, visited) +
                dfs(m, n, k, x, y - 1, visited) + 1;
    }
}
