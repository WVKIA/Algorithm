package Search;

/**
 * 顺序查找
 * 又称线性查找，从一端开始顺序扫描
 * 时间复杂度是O(n)
 *
 * 平均时间复杂度：
 * 最好情况是 1
 * 最坏情况是 n
 *  (n + 1) / 2
 *  所以平均时间复杂度是 O(n)
 *
 *
 * 优点：对存储没要求，实现简单
 * 缺点：当n很大时，平均查找长度大，效率低
 *
 *
 * 进阶：
 *  + MRU算法，最近最多被使用
 *      将查找到的元素移动到最前面：这个策略适用于某些元素很可能被再次查找到，利用前面位置作为热点数据存储位置，提高下次查找效率，利用的是如果局部性原理
 *
 *  + 成功查找就向前移动一位
 *      策略同样适用于某些最近的元素被下次查找的概率大于其他，但避免了大量移动元素带来的开销
 *
 *  + 成功查找移动到最后
 *      这个策略适用于一个元素不会被多次查找
 */
public class SequenceSearch {
    public static int sequencesSearch(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
