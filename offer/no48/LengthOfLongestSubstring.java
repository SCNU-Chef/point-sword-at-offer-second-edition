package offer.no48;

import java.util.HashMap;

/**
 * @author Toreno Li
 * 我写出来了,但是我不懂,为为什么只右移动,就可以得到正确的答案
 * maxLength是最终结果
 * begin是每次迭代的没有重复字符的字符串的开始下标，end是结束下标的下一位，preEnd是上一个结束下标
 * charIndex用于存储字符对应的下标
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int begin = 0;
        HashMap<Character, Integer> charIndex = new HashMap<>();
        for (int end = 0; end < s.length(); end++) {
            Integer preEnd = charIndex.get(s.charAt(end));
            if (preEnd != null) {
                begin = Math.max(begin, preEnd + 1);
            }
            charIndex.put(s.charAt(end), end);
            maxLength = Math.max(end - begin + 1, maxLength);
        }
        return maxLength;
    }
}
