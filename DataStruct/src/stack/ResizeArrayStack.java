package stack;

import java.util.Iterator;

/**
 * @author wukai
 * @date 2019/1/21
 */
public class ResizeArrayStack<T> implements IStack<T> ,Iterable<T>{
    /**
     * 存储数据
     */
    private Object[] elems;

    /**
     * 栈顶指针
     */
    private int top =-1;

    private int default_size = 3;


    public ResizeArrayStack() {
        this.elems = new Object[default_size];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(T data) {
        if (top + 1 >= this.elems.length) {
            increaseSize();
        }
        top++;
        this.elems[top] = data;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("栈空");
        }
        return (T) this.elems[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("栈空");
        }

        return (T) this.elems[top ];
    }

    /**
     * 扩容为2 * length
     */
    private void increaseSize() {
        Object[] datas = new Object[this.elems.length * 2];
        for (int i = 0; i < elems.length; i++) {
            datas[i] = this.elems[i];
        }
        this.elems = datas;
    }


    //实现iterable接口
    @Override
    public Iterator<T> iterator() {

        return new ReverseStackIterator<>();
    }

    //逆序打印栈元素
    private class ReverseStackIterator<T> implements Iterator<T>{

        private int i = top;
        @Override
        public boolean hasNext() {
            return i >= 0;
        }

        @Override
        public T next() {
            return (T) elems[i--];
        }
    }


    //测试用例
    public static void main(String[] args) {
        ResizeArrayStack<String> stack = new ResizeArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i + "");
        }
        System.out.println("栈顶元素 "+stack.peek());

        System.out.println("打印元素=====");
        for (String s : stack) {
            System.out.println(s);
        }


        System.out.println("弹出元素 ===");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("栈空 "+stack.isEmpty());


    }
}
