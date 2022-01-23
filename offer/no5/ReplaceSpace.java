package offer.no5;

/**
 * @author Toreno Li
 * StringBuilder   StringBuffer
 * 线程不安全        线程安全
 * JDK1.5          JDK1.0
 * <p>
 * 1. JDK
 * 2. StringBuilder
 * 3. 遍历,后移,填充,时间复杂度O(n²),用Java实现有点麻烦,这里就不写代码了,看书吧
 */
public class ReplaceSpace {
    public String replaceSpace1(String s) {
        return s.replace(" ", "%20");
    }

    public String replaceSpace2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
