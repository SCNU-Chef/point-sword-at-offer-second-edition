package offer.no39;

/**
 * @author Toreno Li
 * 摩尔投票法
 * 相同的加一,不同的减一,减到零另选
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int pre = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (count == 0) {
                pre = cur;
                count = 1;
            } else if (pre == cur) {
                count++;
            } else {
                count--;
            }
        }
        return pre;
    }
}
