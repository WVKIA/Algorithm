package tree;

/**
 * @author wukai
 * 树接口
 */
public interface ITree <T>{

    /**
     * 是否为空树
     * @return
     */
    boolean isEmpty();

    /**
     * 计算节点个数
     * @return
     */
    int count();

    /**
     * 返回树的高度
     * @return
     */
    int height();


    /**
     * 先根序遍历
     */
    void preOrder();

    /**
     * 后根序遍历
     */
    void postOrder();

    /**
     * 中根序遍历
     */
    void levelOrder();
}
