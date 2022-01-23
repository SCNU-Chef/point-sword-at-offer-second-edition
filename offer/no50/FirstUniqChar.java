package offer.no50;

/**
 * @author Toreno Li
 * 一次统计次数,一次根据顺序找出次数为1的字符
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        if ("".equals(s)) {
            return ' ';
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
