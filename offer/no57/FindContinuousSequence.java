package offer.no57;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Toreno Li
 * 双指针指向区间的起点和终点
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        int left = 1;
        int right = 2;
        while (left < right) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] arr = new int[(right - left + 1)];
                for (int i = left; i <= right; i++) {
                    arr[i - left] = i;
                }
                result.add(arr);
                left++;
            } else if (sum < target) {
                right++;
            } else {
                left++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
