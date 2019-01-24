package tree.binarytree;

/**
 * @author wukai
 * @date 2019/1/23
 * 普通的二叉树
 */
public class BinaryTree<T> implements IBinaryTree<T> {

    /**
     * 根节点
     */
    private BinaryTreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    @Override
    public void insertRoot(BinaryTreeNode<T> node) {
        //如果根节点不存在
        if (root == null) {
            root = node;
        }else {

            //分别指向根节点的左孩子和右孩子
            node.left = root.left;
            node.right = root.right;
            root = node;
        }
    }

    @Override
    public BinaryTreeNode<T> search(T data) {

        return searchNode(root,data);
    }

    private BinaryTreeNode<T> searchNode(BinaryTreeNode<T> node, T data) {
        if (null == node || null == data) {

            return null;
        }
        if (node.data.equals(data)) {
            return node;
        }

        BinaryTreeNode<T> find = searchNode(node.left, data);
        if (null != find) {
            return find;
        }
        find = searchNode(node.right, data);
        return find;

    }
    @Override
    public BinaryTreeNode<T> getParent(BinaryTreeNode<T> node) {
        return getParent(root, node);
    }

    //在根节点是pRoot的树中，找到node的父节点
    private BinaryTreeNode<T> getParent(BinaryTreeNode<T> pRoot,BinaryTreeNode<T> node) {
        if (pRoot == null || node == null) {
            return null;
        }
        if (pRoot.left == node || pRoot.right == node) {
            return pRoot;
        }
        BinaryTreeNode<T> find = getParent(pRoot.left, node);
        if (null != find) {
            return find;
        }
        find = getParent(pRoot.right, node);
        return find;
    }

    //插入node孩子节点，如果isLeft为true，插入为左孩子，否则为右孩子
    //如果node已经存在左孩子或右孩子，将node孩子作为新孩子节点孩子
    @Override
    public void insertChild(BinaryTreeNode<T> node, T data, boolean isLeft) {
        if (null == node || data == null) {
            return;
        }
        BinaryTreeNode<T> child = new BinaryTreeNode<>(data);
        if (isLeft) {
            //原node的左孩子成为child的左孩子
            child.left = node.left;
            node.left = child;
            return;
        }
        child.right = node.right;
        node.right = child;
    }

    @Override
    public void removeChild(BinaryTreeNode<T> node, boolean isLeft) {
        if (null == node) {
            return;
        }
        if (isLeft) {
            node.left = null;
        }else {
            node.right = null;
        }
    }

    @Override
    public void removeAll() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int count() {
        return countChild(root);
    }

    //计算以node为根的子树节点个数
    private int countChild(BinaryTreeNode<T> node) {
        if (null == node) {
            return 0;
        }
        return countChild(node.left) + countChild(node.left) + 1;
    }
    @Override
    public int height() {
        return 0;
    }

    //计算以node为根的子树高度
    private int heightChild(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        //左子树高度
        int hl = heightChild(node.left);
        //右子树高度
        int rl = heightChild(node.right);

        return hl > rl ? hl + 1 : rl + 1;
    }

    //先根遍历
    @Override
    public void preOrder() {
        preOrder(root);
    }

    //先根遍历以node为根节点的树
    //递归实现
    public void preOrder(BinaryTreeNode<T> node) {
        if (null == node) {
            return;
        }

        System.out.println(node.data + "");
        preOrder(node.left);
        preOrder(node.right);
    }

    //后根遍历
    @Override
    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(BinaryTreeNode<T> node) {
        if (null == node) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data + "");
    }



    @Override
    public void levelOrder() {
        levelOrder(this.root);
    }

    public void levelOrder(BinaryTreeNode<T> node) {
        if (null == node) {
            return;
        }
        levelOrder(node.left);
        System.out.println(node.data + "");
        levelOrder(node.right);
    }
}
