package offer.no31;

import java.util.Stack;

/**
 * @author Toreno Li
 * 建议用Deque来模拟Stack
 * 往辅助栈中以pushed的顺序添加元素
 * 添加完成后,当辅助栈顶和popped相等时,pop辅助栈,popped指针后移
 * pushed中元素全部被加入辅助栈后,判断popped的指针是否达到了末尾
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;
        for (int i : pushed) {
            stack.push(i);
            while (poppedIndex < popped.length && !stack.isEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            }
        }
        return poppedIndex == popped.length;
    }
}
