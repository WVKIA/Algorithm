package Base_1.API;

/**
 * @author wukai
 * @date 2019/1/6
 */
public interface QStack<T> extends Iterable<T> {

    void push();

    T pop();

    boolean isEmpty();

    int size();
}
