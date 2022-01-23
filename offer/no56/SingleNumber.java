package offer.no56;

/**
 * @author Toreno Li
 * 常量级空间复杂度,O(n)的时间复杂度
 * 统计每个元素的二进制下的1的出现次数
 * 哪一位不能被3整除,就表明只出现一次的数的这一位为1
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += (num >> i & 1);
            }
        }
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result = result << 1;
            if (count[i] % 3 != 0) {
                result = result | 1;
            }
        }
        return result;
    }
}
