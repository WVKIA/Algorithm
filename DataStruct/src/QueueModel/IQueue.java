package QueueModel;

/**
 * 队列接口
 */
public interface IQueue<T> {
    /**
     * 从尾端加入队列
     * @param data
     * @return
     */
    boolean offer(T data);

    /**
     * 从头部弹出一个元素
     * @return
     */
    T poll();

    /**

     * 获取头部元素数据
     * @return
     */
    T peek();
}
