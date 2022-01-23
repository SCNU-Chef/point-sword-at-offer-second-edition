package offer.no15;

/**
 * @author Toreno Li
 * 1. 不能处理负数
 * 2. 可以处理负数,会循环32次
 * 3. 可以处理负数,二进制下有几个1就处理几次(个人感觉这种解法才是完全在二进制层面解决问题,不考虑正负)
 * 4. Java利用JDK特殊处理
 * 5. Java利用高位补0的位运算符 >>>
 * 6. Java利用JDK特殊处理
 * 7. 对比下7和2,为什么要+1????
 * 因为:while的条件是>0,而i在最后一次循环时的值为(1000 0000 .... 0000),十进制下为负数
 * 会比2解法中的while条件!=0少一次循环,少一次统计,故count的值会少1
 * 建议:2和7,还是用2的条件判断比较好(刚开始还以为是if的条件不同导致结果不同,没想到竟然是while)
 */
public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        int bit = 1;
        while (bit != 0) {
            if ((n & bit) != 0) {
                count++;
            }
            bit = bit << 1;
        }
        return count;
    }

    public int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public int hammingWeight4(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public int hammingWeight5(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public int hammingWeight6(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight7(int n) {
        int count = 0;
        int i = 1;
        while (i > 0) {
            if ((n & i) == i) {
                count++;
            }
            i = i << 1;
        }
        return n < 0 ? count + 1 : count;
    }
}