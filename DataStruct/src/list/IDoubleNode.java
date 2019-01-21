package list;

/**
 * @author wukai
 * @date 2019/1/15
 * 双链表节点
 * 包含一个指向后继的指针和指向前序的指针
 */
public class IDoubleNode<T> {
    /**
     * 数据域
     */
    public T data;
    /**
     * 前序指针
     */
    public IDoubleNode<T> pre;
    /**
     * 后继指针
     */
    public IDoubleNode<T> next;

    public IDoubleNode(T data,IDoubleNode<T> pre,IDoubleNode<T> next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }
    public IDoubleNode() {
        this(null, null, null);
    }
}
