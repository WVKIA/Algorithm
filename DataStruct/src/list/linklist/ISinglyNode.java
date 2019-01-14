package list.linklist;

/**
 * 单链表节点
 * @author wukai
 */
public class ISinglyNode<T>{
    /**
     * 数据
     */
    public T data;
    /**
     * 引用后继节点
     */
    public ISinglyNode<T> next;

    public ISinglyNode() {
        this(null,null);
    }

    public ISinglyNode(T data, ISinglyNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
