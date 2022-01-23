package offer.no45;

/**
 * @author Toreno Li
 * 定义一种新的比较规则
 * 对拼接后的数字进行比较
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (compare(nums[i], nums[j]) == 1) {
                    int swap = nums[i];
                    nums[i] = nums[j];
                    nums[j] = swap;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    private int compare(int a, int b) {
        String ab = a + Integer.toString(b);
        String ba = b + Integer.toString(a);
        return ab.compareTo(ba);
    }
}
