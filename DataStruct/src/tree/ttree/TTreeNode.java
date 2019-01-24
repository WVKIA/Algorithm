package tree.ttree;

/**
 * @author wukai
 * @date 2019/1/22
 *树的孩子兄弟节点
 */
public class TTreeNode<T> {
    public T data;

    /**
     * 链表节点，分别指向第一个孩子节点和下一个兄弟节点
     */
    public TTreeNode<T> firstChild,sibling;

    public TTreeNode(T data, TTreeNode<T> firstChild, TTreeNode<T> sibling) {
        this.data = data;
        this.firstChild = firstChild;
        this.sibling = sibling;
    }


    /**
     * 构造指定值的叶子节点
     * @param data
     */
    public TTreeNode(T data) {
        this(data,null,null);
    }

    public TTreeNode() {
        this(null, null, null);
    }
}
