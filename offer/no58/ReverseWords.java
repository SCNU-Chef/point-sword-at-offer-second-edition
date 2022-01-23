package offer.no58;

/**
 * @author Toreno Li
 * trim保证s1的首尾都非空串
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals("")) {
                continue;
            }
            stringBuilder.append(s1[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}
