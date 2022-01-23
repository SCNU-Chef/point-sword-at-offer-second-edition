package offer.no41;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Toreno Li
 * add的时候的if条件可以互换,互换后getMid时总长度为奇数的时候,也要换成另一个heap的peek
 * 主要是保证每次添加时,堆的有序性质是由poll实现的而不是add实现的
 * 小根堆保存较大的一半,堆顶是较大部分的最小值,大根堆保存较小的一半,堆顶是较小部分的最大值
 * 还可以直接add到array,getMid的时候sort
 */
public class MedianFinder {
    private PriorityQueue<Integer> smallHeap;
    private PriorityQueue<Integer> bigHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<Integer>();
        bigHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if (smallHeap.size() == bigHeap.size()) {
            smallHeap.add(num);
            bigHeap.add(smallHeap.poll());
        } else {
            bigHeap.add(num);
            smallHeap.add(bigHeap.poll());
        }
    }

    public double findMedian() {
        return smallHeap.size() == bigHeap.size() ? (smallHeap.peek() + bigHeap.peek()) / 2.0 : bigHeap.peek();
    }
}