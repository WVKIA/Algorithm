package tree.binarytree;

import tree.ITree;

/**
 * @author wukai
 * @date 2019/1/23
 */
public interface IBinaryTree<T> extends ITree<T> {

    /**
     * 插入根节点
     * @param node
     */
    void insertRoot(BinaryTreeNode<T> node);

    /**
     * 查询
     * @param data
     * @return
     */
    BinaryTreeNode<T> search(T data);

    /**
     * 获取父节点
     * @param node
     * @return
     */
    BinaryTreeNode<T> getParent(BinaryTreeNode<T> node);

    /**
     * 插入孩子节点
     * @param node
     * @param data
     * @param isLeft 插入左孩子
     */
    void insertChild(BinaryTreeNode<T> node, T data, boolean isLeft);

    /**
     * 删除孩子节点
     * @param node
     * @param isLeft 删除左孩子
     */
    void removeChild(BinaryTreeNode<T> node ,boolean isLeft);

    /**
     * 删除一棵树
     */
    void removeAll();

}
