package ListModel;

import java.util.Iterator;

/**
 * List接口
 */
public interface IList<E> {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<E> iterator();

    /**
     * 添加元素
     * @param e element to be appended to this list
     * @return true 如果添加成功
     * @throws NullPointerException 如果e为null
     */
    boolean add(E e);

    /**
     * 移除this.list的第一个匹配元素
     *
     * @param e
     * @return true如果移除成功
     */
    boolean remove(Object e);

    /**
     * 清空
     */
    void clear();

    /**
     * 根据下标获取元素
     * @param index
     * @return
     * @throws IndexOutOfBoundsException 如果下标不合法
     */
    E get(int index);

    /**
     * 为下标所在位置重新赋值
     * @param index
     * @param e
     * @return
     * @throws UnsupportedOperationException 有的list实现不支持
     * @throws IndexOutOfBoundsException 下标不合法
     */
    E set(int index, E e);

    /**
     * 移除下标所在元素
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    E remove(int index);

    /**
     * 获取this.list第一个匹配的元素下标
     * @param o
     * @return 如果找不到 返回 -1
     */
    int indexOf(Object o);

    /**
     * 从最后进行匹配元素
     * @param o
     * @return 如果找不到，返回-1
     */
    int lastIndexOf(Object o);
}
