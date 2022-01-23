package offer.no40;

import java.util.Arrays;

/**
 * @author Toreno Li
 * 每次调用partition都会归位一位元素并返货归位后的index
 * 比较index就能找出前k小的元素
 * JDK还有PriorityQueue,默认是小根堆,可以在构造时提供比较器来实现大根堆
 * 数据量小的话还可以计数
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int index = partition(arr, left, right);
        while (index != k - 1) {
            if (index > k - 1) {
                index = partition(arr, left, index - 1);
            } else if (index < k - 1) {
                index = partition(arr, index + 1, right);
            }
        }
        return Arrays.copyOfRange(arr, left, k);
    }

    private int partition(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int baseIndex = left;
        int temp;
        while (i < j) {
            while (i < j && arr[j] >= arr[baseIndex]) {
                j--;
            }
            while (i < j && arr[i] <= arr[baseIndex]) {
                i++;
            }
            if (i >= j) {
                temp = arr[baseIndex];
                arr[baseIndex] = arr[j];
                arr[j] = temp;
                break;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return j;
    }
}