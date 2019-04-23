package stack;

import queue.FixedSizeArrayQueue;

/**
 * @author wukai
 * @date 2019/1/22
 * 固定容量的栈
 */
public class FixedsizeArrayStack<T> implements IStack<T> {

    private Object[] datas;//存储数据数组

    private int top;//栈顶指针

    public FixedsizeArrayStack(int size) {
        this.top = -1;
        this.datas = new Object[size];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    //是否栈满
    public boolean isFull() {
        return top + 1 >= datas.length;
    }
    @Override
    public void push(T data) {
        if (isFull()) {
            throw new IllegalArgumentException("栈满");
        }
        this.datas[++top] = data;
    }

    @Override
    public T pop() {
        return (T) this.datas[top--];
    }

    @Override
    public T peek() {
        return (T) this.datas[top ];
    }

    public static void main(String[] args) {
        FixedsizeArrayStack<String> stack = new FixedsizeArrayStack<>(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i + "");
        }
        System.out.println("栈顶元素 "+stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("栈空 "+stack.isEmpty());
    }
}
