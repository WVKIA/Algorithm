package queue;

/**
 * @author wukai
 * 队列接口
 */
public interface IQueue<T> {
    boolean isEmpty();

    /**
     * 入队
     * @param data
     */
    void enqueue(T data);

    /**
     * 出队
     * @return
     */
    T dequeue();

}
