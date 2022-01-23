package offer.no58;

/**
 * @author Toreno Li
 * 平移就反转两次
 */
public class ReverseLeftWords {
    public String reverseLeftWords1(String s, int n) {
        n = n % s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int begin, int end) {
        char temp;
        for (int i = begin; i <= (begin + end) / 2; i++) {
            temp = chars[i];
            chars[i] = chars[end + begin - i];
            chars[end + begin - i] = temp;
        }
    }

    public String reverseLeftWords2(String s, int n) {
        n = n % s.length();
        return s.substring(n)+s.substring(0, n);
    }
}
