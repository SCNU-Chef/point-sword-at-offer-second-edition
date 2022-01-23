package offer.no30;

import java.util.Stack;

/**
 * @author Toreno Li
 * 一个栈记录数据,一个栈记录最小值
 * 用O(n)的空间换取O(1)的时间
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    private Stack<Integer> stack;
    private Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else {
            min.push(x < min.peek() ? x : min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
