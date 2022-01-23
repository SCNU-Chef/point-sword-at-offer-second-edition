package offer.no29;

/**
 * @author Toreno Li
 * 先赋值,再判断是否需要转向,后移动坐标(i,j)
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        final int right = 0;
        final int down = 1;
        final int left = 2;
        final int up = 3;
        final int row = matrix.length;
        final int col = matrix[0].length;
        int direct = right;
        int index = 0;
        int i = 0;
        int j = 0;
        final int[] result = new int[row * col];
        final boolean[][] visited = new boolean[row][col];
        while (index < result.length) {
            result[index++] = matrix[i][j];
            visited[i][j] = true;
            if (direct == right) {
                if (j + 1 == col || visited[i][j + 1] == true) {
                    direct = down;
                    i++;
                } else {
                    j++;
                }
            } else if (direct == down) {
                if (i + 1 == row || visited[i + 1][j] == true) {
                    direct = left;
                    j--;
                } else {
                    i++;
                }
            } else if (direct == left) {
                if (j == 0 || visited[i][j - 1] == true) {
                    direct = up;
                    i--;
                } else {
                    j--;
                }
            } else if (direct == up) {
                if (i == 0 || visited[i - 1][j] == true) {
                    direct = right;
                    j++;
                } else {
                    i--;
                }
            }
        }
        return result;
    }
}