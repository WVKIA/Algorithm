package queue;

/**
 * @author wukai
 * @date 2019/1/22
 */
public class ResizeArrayQueue<T>  implements IQueue<T>{
    private Object[] elems;
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void enqueue(T data) {

    }

    @Override
    public T dequeue() {
        return null;
    }
}
