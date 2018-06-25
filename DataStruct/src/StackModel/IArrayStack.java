package StackModel;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;

/**
 * 数组实现栈
 *
 */
public class IArrayStack<T> implements IStack<T>{
    private Object[] data;  //存储值

    private int size;   //元素个数

    private static final int DEFAULT_LEN=16;    //初始容量

    private static final double DEFAULT_FACTOR=0.5; //默认扩容因子，扩容一半容量

    public IArrayStack() {
        this.data = new Object[DEFAULT_LEN];
    }

    /**
     * 扩容检测
     * 当检查到元素个数等于数组容量时，进行扩容
     */
    private void ensureCapacity() {
        if (data == null || data.length == 0) {
            this.data = new Object[DEFAULT_LEN];
            return;
        }
        if (size == data.length) {
            int newcapactiry = (int) (data.length * (1 + DEFAULT_FACTOR));
            data = Arrays.copyOf(data, newcapactiry);
        }
    }

    @Override
    public T push(T item) {
        ensureCapacity();   //进行扩容检测
        this.data[size++] = item;
        return item;
    }

    @Override
    public T pop() {
        if (empty()) {
            throw new EmptyStackException();    //如果为空，抛出栈空异常
        }
        --size;
        T item = (T) this.data[size];
        this.data[size] = null; //设置移除元素位置为null
        return item;
    }

    @Override
    public T peek() {
        return (T) this.data[size - 1];
    }

    @Override
    public boolean empty() {
        return size==0;
    }

    public static void main(String[] args) {
        IStack<String> stack = new IArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push("" + i);
        }
        System.out.println("stack is empty : " + stack.empty());
        while (!stack.empty()) {
            String value = stack.pop();
            System.out.println(value);
        }
        System.out.println("stack is empty : " + stack.empty());
    }
}
