package offer.no53;

/**
 * @author Toreno Li
 * 找到mid后，直接缩短区间
 */
public class Search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                while (nums[left] != target) {
                    left++;
                }
                while (nums[right] != target) {
                    right--;
                }
                return right - left + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }
}