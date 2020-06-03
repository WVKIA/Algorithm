package stack;

/**
 * @author wukai
 * 栈接口
 */
public interface IStack<T> {
    boolean isEmpty();


    /**
     * 入栈
     * @param data
     */
    void push(T data);

    /**
     * 弹出顶层元素，返回当前元素
     * @return
     */
    T pop();

    /**
     * 获取顶层元素，不出栈
     * @return
     */
    T peek();
}
