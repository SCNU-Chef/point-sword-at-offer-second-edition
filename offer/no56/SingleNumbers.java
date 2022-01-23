package offer.no56;

/**
 * @author Toreno Li
 * 先遍历数组,得出两个只出现一次的数的异或值
 * 两个数不同,异或值必定不为0,取异或值的最低位的1
 * 对nums中的num进行分类,依据异或值最低位的1,是否在num中的相同位置也是1
 * 这个分类太牛逼了
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int result = 0;
        int[] results = new int[2];
        for (int num : nums) {
            result = result ^ num;
        }
        int lowestOne = result & (-result);
        for (int num : nums) {
            if ((num & lowestOne) == 0) {
                results[0] ^= num;
            } else {
                results[1] ^= num;
            }
        }
        return results;
    }
}
