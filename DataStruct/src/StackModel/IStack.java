package StackModel;

import java.util.Stack;

public interface IStack<T> {

    /**
     * 压入栈
     * @param item
     * @return
     */
    T push(T item);

    /**
     * 弹出最顶层元素并返回值
     * @return
     */
    T pop();

    /**
     * 获取最顶层值，不弹出
     * @return
     */
    T peek();

    /**
     * 栈是否为空
     * @return
     */
    boolean empty();
}
