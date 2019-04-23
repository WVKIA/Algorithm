package tree.binary_search_tree;

/**
 * @author wukai
 * @date 2019/1/24
 */
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        for (int i = 5; i < 6; i++) {
            tree.insert(i % 4);
        }

        tree.preOrder();
    }


}
