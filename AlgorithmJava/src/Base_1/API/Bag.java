package Base_1.API;

/**
 * @author wukai
 * @date 2019/1/6
 */
public interface Bag<T> extends Iterable<T>  {
    /**
     * 添加
     * @param item
     */
    void add(T item);


    boolean isEmpty();

    int size();
}
