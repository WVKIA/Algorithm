package ListModel;

/**
 * 单链表节点类
 */
public class SinglePointNode<T> {
    public T data;
    public SinglePointNode<T> next;

    public SinglePointNode(T data, SinglePointNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public SinglePointNode() {
        this(null, null);
    }

}
