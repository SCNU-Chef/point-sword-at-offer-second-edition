package offer.no16;

/**
 * @author Toreno Li
 * 1. 记录half,不爆时间
 * 2. 不记录half,爆时间
 * 3. 我直接调库!
 * 测试用例可以让x和n分别取正数,负数,0
 */
public class MyPow {
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1.0 / x;
        }
        double half = myPow1(x, n / 2);
        return half * half * myPow1(x, n % 2);
    }

    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1.0 / x;
        }
        return myPow2(x, n / 2) * myPow2(x, n / 2) * myPow2(x, n % 2);
    }

    public double myPow3(double x, int n) {
        return Math.pow(x, n);
    }
}