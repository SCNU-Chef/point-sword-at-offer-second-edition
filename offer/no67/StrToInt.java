package offer.no67;

/**
 * @author Toreno Li
 * 考虑的情况有点多
 */
public class StrToInt {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int index = 0;
        boolean isPositive = false;
        if (str.charAt(index) == '+' || (str.charAt(index) <= '9' && str.charAt(index) >= '0')) {
            //第一个字符为正号或者数字
            isPositive = true;
            if (str.charAt(index) == '+') {
                //第一个字符为正号,则游标后移一位
                index++;
                if (index == str.length()) {
                    return 0;
                }
            } else {
                //为数字则不作为
            }
        } else if (str.charAt(index) == '-') {
            //第一个字符为负号
            isPositive = false;
            index++;
            if (index == str.length()) {
                return 0;
            }
        } else {
            return 0;
        }
        long result = 0;
        while (index < str.length() && (str.charAt(index) - '0' <= 9 && str.charAt(index) - '0' >= 0)) {
            result = result * 10;
            result += str.charAt(index) - '0';
            if (result > Integer.MAX_VALUE && isPositive) {
                //是正数且越界
                return Integer.MAX_VALUE;
            } else if (-result < Integer.MIN_VALUE && !isPositive) {
                //负数且越界
                return Integer.MIN_VALUE;
            }
            index++;
        }
        return isPositive ? (int) result : (int) (-result);
    }
}
