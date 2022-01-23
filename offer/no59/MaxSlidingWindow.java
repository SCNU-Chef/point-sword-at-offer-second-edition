package offer.no59;

import java.util.PriorityQueue;

/**
 * @author Toreno Li
 * 1.暴力双循环
 * 2.空间换时间,用大根堆维护最大值(JDK的优先队列默认是小根堆)
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        for (int left = 0; left < nums.length - k + 1; left++) {
            int right = left + k;
            int max = Integer.MIN_VALUE;
            for (int i = left; i < right; i++) {
                max = Math.max(max, nums[i]);
            }
            result[left] = max;
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        // int[2]{num,index} 默认小根堆,重写比较器转为大根堆,num相同时后进的大于先进的
        PriorityQueue<int[]> window = new PriorityQueue<>((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        for (int i = 0; i < k; i++) {
            window.offer(new int[]{nums[i], i});
        }
        result[0] = window.peek()[0];
        for (int i = k; i < nums.length; i++) {
            window.offer(new int[]{nums[i], i});
            while (window.peek()[1] <= i - k) {
                // 保证堆顶的值是落在当前区间中的
                window.poll();
            }
            result[i - k + 1] = window.peek()[0];
        }
        return result;
    }
}
