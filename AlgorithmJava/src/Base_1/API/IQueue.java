package Base_1.API;

/**
 * @author wukai
 * @date 2019/1/6
 */
public interface IQueue<T>extends Iterable<T> {
    void enqueue(T data);

    T dequeue();

    boolean isEmpty();

    int size();
}
