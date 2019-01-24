package stack;

/**
 * @author wukai
 * @date 2019/1/21
 */
public class ResizeArrayStack<T> implements IStack<T> {
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

}
