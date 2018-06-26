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
        if (full()) {
            throw new RuntimeException("栈满");
        }
        top++;
        this.items[top] = item;
        return item;
    }

    /**
     * 栈是否已满
     * @return
     */
    public boolean full() {
        return top == this.items.length - 1;
    }

    @Override
    public T pop() {
        if (empty()) {
            throw new RuntimeException("栈空");
        }

        return (T) this.items[top--];   //弹出顶层元素
    }

    @Override
    public T peek() {
        if (empty()) {
            throw new RuntimeException("栈空");
        }
        return (T) this.items[top]; //获取顶层元素
    }

    @Override
    public boolean empty() {
        return top == -1;   //栈空
    }
}
