package tree.binary_tree;

/**
 * @author wukai
 * @date 2019/1/23
 */
public class BinaryTreeNode<T> {
    public T data;

    /**
     * 左节点
     */
    public BinaryTreeNode<T> left;

    /**
     * 右节点
     */
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(T data) {
        this(data, null, null);
    }

    public BinaryTreeNode() {
        this(null,null,null);
    }
}
