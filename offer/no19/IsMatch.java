package offer.no19;

/**
 * @author Toreno Li
 * 1.直接调JDK
 * 2.递归,感觉比较直观,只能说牛逼
 */
public class IsMatch {
    public boolean isMatch1(String s, String p) {
        return s.matches(p);
    }

    public boolean isMatch2(String s, String p) {
        if (s.length() == 0) {
            if (p.length() % 2 != 0) {
                //有独立的字符或者'.',必定匹配不上空串
                return false;
            }
            int i = 1;
            while (i < p.length()) {
                if (p.charAt(i) != '*') {
                    //模式必须是(字符+'*')*n的形式,不然无法匹配空串
                    return false;
                }
                i += 2;
            }
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        char sChar = s.charAt(0);
        char pChar = p.charAt(0);
        char pCharNext = p.length() > 1 ? p.charAt(1) : 'a';
        if (pCharNext == '*') {
            if (sChar == pChar || pChar == '.') {
                //可以选择匹配模式,也可以选择不匹配
                return isMatch2(s.substring(1), p) || isMatch2(s, p.substring(2));
            } else {
                //字符对不上,只能不匹配模式
                return isMatch2(s, p.substring(2));
            }
        } else {
            if (sChar == pChar || pChar == '.') {
                return isMatch2(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }
}
