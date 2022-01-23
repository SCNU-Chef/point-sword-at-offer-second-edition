package offer.no53;

/**
 * @author Toreno Li
 * 可以将数组看成左半部分的nums[i]==i和右半部分的nums[i]!=i
 * 若nums[mid] == mid,则右半部分的首元素一定在[mid+1,right]中
 * 若nums[mid] != mid,则左半部分的尾元素一定在[left,mid-1]中
 * 跳出循环后,left指向右半部分的首元素
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}