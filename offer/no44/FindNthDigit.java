package offer.no44;

/**
 * @author Toreno Li
 * digit n所处的数字的位数
 * start digit位数的数字所处区间的开始的值
 * count digit位数所处区间所占的长度
 * 大佬的题解醍醐灌顶
 * 注意n-1的部分
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            start *= 10;
            digit++;
            count = digit * 9 * start;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
