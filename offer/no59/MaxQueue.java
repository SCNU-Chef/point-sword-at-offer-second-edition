package offer.no59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Toreno Li
 * 一个队列维护数据,一个队列维护最大值
 * 与最大值相同的值也存入max中,这样在pop时能保证max中的最大值够用
 */
public class MaxQueue {
    private Deque<Integer> max;
    private Queue<Integer> data;

    public MaxQueue() {
        max = new LinkedList<>();
        data = new LinkedList<>();
    }

    public int max_value() {
        return data.isEmpty() ? -1 : max.peek();
    }

    public void push_back(int value) {
        data.add(value);
        while (!max.isEmpty() && max.peekLast() < value) {
            max.pollLast();
        }
        max.push(value);
    }

    public int pop_front() {
        if (data.isEmpty()) {
            return -1;
        }
        int value = data.poll();
        if (value == max.peek()) {
            max.poll();
        }
        return value;
    }
}
