package tree.ttree;

import tree.ITree;

/**
 * @author wukai
 * 树接口
 * 一颗普通的文件树，由指向第一个子节点和下一个兄弟节点的树节点组成
 */
public interface TTree<T>  extends ITree<T> {
    /**
     * 插入节点
     * @param node
     */
    void insertNode(TTreeNode<T> node);

    TTreeNode<T> find(T data);


}
