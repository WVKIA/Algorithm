package Search;

/**
 * 二分查找
 * 又称折半查找，属于分治法的一种
 * 因为每次都需要折半，所以平均和最坏时间复杂度都是O(log n)
 *
 * 注意二分查找关键在于查询序列必须有序
 *
 * 进阶：
 *  实际应用中，很可能不仅需要高效的查找效率，还希望高效的删除和插入。如果待查集合数据结构是数组，插入和删除会移动平均一半的元素。
 *  通常采用的方法是构造二叉查找树，更稳妥的构造平衡二叉树
 *
 *  二叉树在插入和删除操作非常频繁的情况下，性能很好，但最坏情况下会退化成链表，这时候就需要平衡树：AVL树和红黑树
 */
public class BinarySearch {
    public static int binarySearch(int[] nums, int val) {
        int left=0;
        int right=nums.length-1;
        int middle=0;
        while (left <= right) {
             middle=(left+right) / 2;
            if (nums[middle] == val) {
                return middle;
            }
            if (nums[middle] < val) {
                left=middle+1;
            }else {
                right=middle-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 65, 344};
        int ind = binarySearch(nums, 23);
        System.out.println(ind);
        System.out.println(nums[ind]);
    }
}
