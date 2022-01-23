package offer.no61;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Toreno Li
 * 五张牌能组成顺子的条件为
 * 1.无重复的牌
 * 2.最大牌-最小牌<5
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        int min = 14;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            set.add(num);
        }
        return max - min < 5;
    }
}
