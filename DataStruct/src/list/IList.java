package list;

/**
 * @author wukai
 * 表list通用接口
 *
 */
public interface IList<T> {
    /**
     * 表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 表中是否含有某个元素
     * @param data
     * @return
     */
    boolean contains(T data);

    /**
     * 清空表
     */
    void clear();

    /**
     * 表中元素的数量
     * @return
     */
    int size();

    /**
     * 在表添加一个元素
     * @param data
     */
    void add(T data);

    /**
     * 设置位置为i的元素为data
     * @param i
     * @param data
     */
    void set(int i, T data);

    /**
     * 删除第i个元素并返回元素
     * @param i
     * @return
     */
    T remove(int i);

    /**
     * 获取第i个元素并返回
     * @param i
     * @return
     */
    T get(int i);

    /**
     * 找到第一次出现元素data的位置
     * @param data
     * @return
     */
    int find(T data);

}
