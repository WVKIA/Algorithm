package StackModel;

/**
 * 采用固定长度数组作为栈的实现
 * 采用循环数组实现
 *
 */
public class IFixedArrayStack<T> implements IStack<T> {
    private static final int DEFAULT_LEN = 16;
    private Object[] items;   //存储数据数组

    private int top = -1;   //栈顶指针

    public IFixedArrayStack() {
        items = new Object[DEFAULT_LEN];
    }

    public IFixedArrayStack(int size) {
        this.items = new Object[size];
    }

    @Override
    public T push(T item) {
        return null;
    }

    /**
     * 栈是否已满
     * @return
     */
    public boolean full() {
        return false;
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean empty() {
        return false;
    }
}
