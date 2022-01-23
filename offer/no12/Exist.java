package offer.no12;

/**
 * @author Toreno Li
 * 利用||的短路性质进行剪枝
 * 是很标准的回溯剪枝题目,建议背诵
 * (i,j)存在取决于(i-1,j),(i+1,j),(i,j-1),(i,j+1)是否至少存在一个
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        if (!(board == null || board.length == 0 || board[0].length == 0)) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (dfs(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int row, int col, int step) {
        if (step == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[row].length ||
                visited[row][col] || word.charAt(step) != board[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean ans = dfs(board, word, visited, row + 1, col, step + 1) ||
                dfs(board, word, visited, row - 1, col, step + 1) ||
                dfs(board, word, visited, row, col + 1, step + 1) ||
                dfs(board, word, visited, row, col - 1, step + 1);
        visited[row][col] = false;
        return ans;
    }
}
