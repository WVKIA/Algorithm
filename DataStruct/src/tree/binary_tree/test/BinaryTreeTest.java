package tree.binary_tree.test;

import tree.binary_tree.BinaryTree;
import tree.binary_tree.BinaryTreeNode;
import tree.binary_tree.IBinaryTree;

/**
 * @author wukai
 * @date 2019/1/24
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        IBinaryTree<String> tree = getTree();
        System.out.println("前序遍历");
        tree.preOrder();

        System.out.println("中序遍历");
        tree.levelOrder();
        System.out.println("后序遍历");
        tree.postOrder();

        System.out.println("树的高度 " + tree.height());
        System.out.println("树节点个数 " + tree.count());

        BinaryTreeNode<String> find = tree.search("A");
        System.out.println(find.data);
    }

    /**
     *
     *      a
     *    b     c
     *   d e   f
     *
     * @return
     */
    private static IBinaryTree<String> getTree() {
        BinaryTreeNode<String> child_a, child_b, child_c;
        child_c = new BinaryTreeNode<>("C", new BinaryTreeNode<>("F"), null);
        child_b = new BinaryTreeNode<>("B", new BinaryTreeNode<>("D"), new BinaryTreeNode<>("E"));
        child_a = new BinaryTreeNode<>("A", child_b, child_c);

        IBinaryTree<String> tree = new BinaryTree<>();
        tree.insertRoot(child_a);
        return tree;
    }


}
