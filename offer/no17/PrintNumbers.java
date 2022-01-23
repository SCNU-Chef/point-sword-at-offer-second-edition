package offer.no17;

/**
 * @author Toreno Li
 * leetcode这题完全违背了书上的意思,未考虑n特别大时的情况
 * 2,3分别模拟大数加1和全排列,解答此题
 * 思想是懂了,就是时空复杂度高的一批
 */
public class PrintNumbers {
    public int[] printNumbers1(int n) {
        int[] result = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public int[] printNumbers2(int n) {
        class InnerBigNum {
            private byte[] value;

            public InnerBigNum(int n) {
                value = new byte[n];
            }

            public boolean isMax() {
                for (byte b : value) {
                    if (b != 9) {
                        return false;
                    }
                }
                return true;
            }

            public void addOne() {
                value[value.length - 1]++;
                for (int i = value.length - 1; i >= 0; i--) {
                    if (value[i] == 10 && i != 0) {
                        value[i - 1]++;
                        value[i] = 0;
                    }
                }
            }

            public int toInt() {
                int val = 0;
                for (byte b : value) {
                    val = val * 10 + b;
                }
                return val;
            }
        }

        int[] result = new int[(int) Math.pow(10, n) - 1];
        InnerBigNum innerBigNum = new InnerBigNum(n);
        for (int i = 0; i < result.length; i++) {
            innerBigNum.addOne();
            result[i] = innerBigNum.toInt();
        }
        return result;
    }

    int count = 0;

    public int[] printNumbers3(int n) {
        int[] val = new int[n];
        int[] result = new int[(int) Math.pow(10, n) - 1];
        dfs(0, val, result);
        return result;
    }

    private void dfs(int step, int[] val, int[] result) {
        if (step == val.length) {
            int number = 0;
            for (int i : val) {
                number = number * 10 + i;
            }
            if (number != 0) {
                result[count++] = number;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            val[step] = i;
            dfs(step + 1, val, result);
        }
    }
}