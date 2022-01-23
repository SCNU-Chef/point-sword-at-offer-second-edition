package offer.no38;

import java.util.HashSet;

/**
 * @author Toreno Li
 * 利用hashset去重
 * visited和chars对齐,并非和result对齐
 * 较好的方法是剪枝
 */
public class Permutation {
    private HashSet<String> results;
    private char[] result;
    private boolean[] visited;
    private char[] chars;

    public String[] permutation(String s) {
        results = new HashSet<>();
        result = new char[s.length()];
        visited = new boolean[s.length()];
        chars = s.toCharArray();
        dfs(0);
        return results.toArray(new String[results.size()]);
    }

    private void dfs(int step) {
        if (step == chars.length) {
            results.add(new String(result));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                result[step] = chars[i];
                visited[i] = true;
                dfs(step + 1);
                visited[i] = false;
            }
        }
    }
}