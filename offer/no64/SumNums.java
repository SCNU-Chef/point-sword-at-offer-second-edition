package offer.no64;

/**
 * @author Toreno Li
 * 利用&&的短路性质代替if实现递归的终止条件
 */
public class SumNums {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
