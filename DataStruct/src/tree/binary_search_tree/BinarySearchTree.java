package tree.binary_search_tree;

import tree.binary_tree.BinaryTreeNode;

/**
 * @author wukai
 * 二叉查找树
 * 数据必须实现compare接口
 */
public class BinarySearchTree<T extends Comparable>  {
    //根节点指向
    private BinaryTreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T data) {

        if (root == null) {
            root = new BinaryTreeNode<>(data);
            return;
        }
        BinaryTreeNode<T> current = root;

        //这次采用循环的方法找到data节点
        while (current != null) {
            if (current.data.compareTo(data) <= 0) {
                if (null == current.left) {
                    current.left = new BinaryTreeNode<>(data);
                    return;
                } else {
                    current = current.left;
                }

            } else {
                if (null == current.right) {
                    current.right = new BinaryTreeNode<>(data);
                    return;
                } else {
                    current = current.right;
                }
            }

        }

    }


    public BinaryTreeNode<T> search(T data) {

        return search(root,data);
    }

    //递归查询node树中满足data的节点
    private BinaryTreeNode<T> search(BinaryTreeNode<T> node, T data) {
        if (null == data) {
            return null;
        }
        if (node.data.equals(data)) {
            return node;
        }
        if (node.data.compareTo(data) <= 0) {
            return search(node.left, data);
        }
        return search(node.right, data);
    }

    //根据二叉树的特性，最大的节点处于最右节点
    public BinaryTreeNode<T> searchMax() {
        if (null == root) {
            return null;
        }
        BinaryTreeNode<T> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;

    }

    //根据二叉树的特性，最小的节点处于最左节点
    public BinaryTreeNode<T> searchMin() {
        if (null == root) {
            return null;
        }
        BinaryTreeNode<T> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void retrieve() {

    }

    /**
     * 二叉查找树的删除节点
     *
     * 1。 如果单子节点，只有左孩子或只有右孩子，则可以直接删除，然后用左子树或右子树节点替换位置即可
     * 2。 如果双分支
     *
     * 则只有找到合理的节点替换当前被删除节点位置，保证二叉树的有序性
     *
     * 通常的做法是找到右子树的最小节点，然后替换到被删除节点的位置，替换之后，递归删除右子树最小节点
     *
     */
    public void remove(T data) {
        //找到data所处的节点和父节点
        if (null == root) {
            return;
        }
        //如果data为根节点
        if (root.data.equals(data)) {
            root = null;
            return;
        }
        //删除一个节点
    }


    /**
     * 删除以node为根的二叉树中data为key的节点，并返回最新的树
     * @param node
     * @param key
     */
    public BinaryTreeNode<T> delete(BinaryTreeNode<T> node, T key) {
        if (key == null) {
            return null;
        }
        //比较key和node节点的值
        int cmp = key.compareTo(node.data);

        //如果key大于node值，到node的右子树去寻找并删除
        if (cmp > 0) {
            node.right = delete(node.right, key);
        } else if (cmp < 0) {
            node.left = delete(node.left, key);
        }else {
            //如node节点值==key值

            //如果node是单分支，则直接删除该节点，并且返回可用分支
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            //如果是双分支，则需要进行删除操作
            BinaryTreeNode<T> temp = null;
            //找到node右子树的最小节点，替换和node的位置，从而保证node节点位置平衡
            temp = min(node.right);

            //左子树保持不变
            temp.left = node.left;
            //右子树删除最小节点
            temp.right = deleteMin(temp.right);
            return temp;

        }
        return null;
    }

    public BinaryTreeNode<T> min(BinaryTreeNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //删除以node为根树的最小节点
    public BinaryTreeNode<T> deleteMin(BinaryTreeNode<T> node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }


    //先根遍历
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
