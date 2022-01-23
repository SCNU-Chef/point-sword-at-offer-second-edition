package offer.no3;

import java.util.Arrays;

/**
 * @author Toreno Li
 * 1. 排序后判断
 * 2. 哈希表
 * 3. 原地哈希
 */
public class FindRepeatNumber {
    public int findRepeatNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {
        boolean[] bucket = new boolean[nums.length];
        for (int num : nums) {
            if (!bucket[num]) {
                bucket[num] = true;
            } else {
                return num;
            }
        }
        return 0;
    }

    public int findRepeatNumber3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                } else {
                    int num1 = nums[i];
                    int num2 = nums[nums[i]];
                    nums[nums[i]] = num1;
                    nums[i] = num2;
                }
            }
        }
        return 0;
    }
}
