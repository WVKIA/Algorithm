package Sort;

import static Sort.SortUtil.printNums;

/**
 * 冒泡排序
 * 通过两层循环，大体通过和相邻元素进行比较，将最大的数移动到最后面，最终排序
 * 时间复杂度很平均 是 O(n^2)
 *
 * 例如
 *  1  4  2  5  3  7  8
 *
 *  第一次从第一个元素开始，1和4相比，如果前者比后者大，交换位置，否则，指针继续走到2，1和2相比，然后1和5比，1和3比
 *  第一趟排序将第一位交换成最小的数
 */
public class BubbleSort {
    /**
     * 其实就是选择排序
     * @param nums
     */
    public static void bubbleUpSort(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //固定第一位
            int temp=i;
            for (int j = i+1; j < nums.length; j++) {
                //如果j位置数据小于i位置数据，将i和j交换位置
                if (nums[j] < nums[temp]) {
                    int k = nums[j];
                    nums[j] = nums[i];
                    nums[i] = k;
                }
            }
            printNums(nums);
        }
    }

    /**
     * 或者通过将最大值移到最后
     * @param nums
     */
    public static void bubbleDownSort(int[] nums) {
        if (nums == null) {
            return;
        }
        //第一层只是循环次数的
        for (int i = 0; i < nums.length-1; i++) {

            //第二层才是真正工作，每次将最大的放后面
            for (int j = 0; j < nums.length-1-i; j++) {
                //注意此处和上面一种解法的不一致，这里的里层循环用来将最大值移动到最后，通过交换相邻最大值
                // 外层循环控制需要循环的次数

                if (nums[j] > nums[j+1]) {
                    int k = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = k;
                }
            }
            printNums(nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 6, 9, 43, 67, 9};
        printNums(nums);
        bubbleDownSort(nums);
        printNums(nums);
    }
}
