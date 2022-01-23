package offer.no20;

/**
 * @author Toreno Li
 * 1.书上的解答
 * 2.用JDK抓异常
 * 3.正则,写正则的是真的牛皮
 * 4.还可以用有限状态机
 * 5.还可以充分考虑各种情况,详见评论区大佬吧
 */
public class IsNumber {
    private int index = 0;

    public boolean isNumber1(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char[] chars = s.trim().toCharArray();
        //中间有空格也是不合法的
        for (char c : chars) {
            if (c == ' ') {
                return false;
            }
        }
        boolean result = scanInt(chars);
        if (index < chars.length && chars[index] == '.') {
            index++;
            //这里顺序不能乱,不然短路了,即使合法index也走不到最后
            result = scanUnsignedInt(chars) || result;
        }
        if (index < chars.length) {
            if (chars[index] == 'e' || chars[index] == 'E') {
                index++;
                result = result && scanInt(chars);
            }
        }
        //走不到最后也是不合法的
        return result && (index == chars.length);
    }

    private boolean scanUnsignedInt(char[] chars) {
        int oldBegin = index;
        while (index < chars.length && chars[index] <= '9' && chars[index] >= '0') {
            index++;
        }
        return index > oldBegin;
    }

    private boolean scanInt(char[] chars) {
        if (index < chars.length) {
            if (chars[index] == '+' || chars[index] == '-') {
                index++;
            }
        }
        return scanUnsignedInt(chars);
    }

    public boolean isNumber2(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //面向测试用例,首尾有空格也算数字???
        s = s.trim();
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        char lastChar = s.charAt(s.length() - 1);
        //面向测试用例,末尾有d,D,f,F的不算????
        return (lastChar >= '0' && lastChar <= '9') || lastChar == '.';
    }

    public boolean isNumber3(String s) {
        String regex = "\\s*[+-]?[0-9]*((\\.[0-9])|([0-9]\\.)|[0-9])[0-9]*([eE][+-]?[0-9]+)?\\s*";
        return s.matches(regex);
    }
}