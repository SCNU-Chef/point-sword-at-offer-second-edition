package offer.no6;

import common.ListNode;

import java.util.Stack;

/**
 * @author Toreno Li
 * 既然可以用栈做,同样也可以用递归去做,但leetcode(存储到数组)和书上的(打印)不一样,还原递归做法比较麻烦
 *
 * Iterator                           ListIterator
 * 不能向List中添加对象                  可通过add方法添加(非集合的add,是ListIterator自己的)
 * 不能逆向遍历集合                      可通过hasPrevious和previous方法实现逆向遍历
 * 构造后初始位置为集合第一位              可通过集合的方法指定初始位置(其本身是接口无构造器)
 * 不可定位索引                         可通过nextIndex和previousIndex定位索引
 * 不可修改集合                         可通过set方法修改最后一次访问的对象的值
 * 有forEachRemaining访问未访问过的元素  无forEachRemaining
 *       都有hasNext和next和remove方法
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
