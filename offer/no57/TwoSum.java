package offer.no57;

/**
 * @author Toreno Li
 * 有序,所以可以双指针
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (nums[left] + nums[right] != target) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{nums[left], nums[right]};
    }
}
