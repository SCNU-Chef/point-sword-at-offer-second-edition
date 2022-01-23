package offer.no11;

import java.util.Arrays;

/**
 * @author Toreno Li
 * 有序数组 -> 二分
 * 这题感觉吃的还不是很透,注意二分的边界条件
 */
public class MinArray {
    public int minArray1(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    public int minArray2(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[right] > numbers[mid]) {
                right = mid;
            } else if (numbers[right] < numbers[mid]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
