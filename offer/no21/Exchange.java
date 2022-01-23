package offer.no21;

/**
 * @author Toreno Li
 * 根据数字的性质划分数组,可以抽取出公共的判断条件
 * 本题用数字的奇偶性来划分
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            while (left < right && !isOK(nums[left])) {
                left++;
            }
            while (right > left && isOK(nums[right])) {
                right--;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    private boolean isOK(int n) {
        return (n & 1) == 0;
    }
}
