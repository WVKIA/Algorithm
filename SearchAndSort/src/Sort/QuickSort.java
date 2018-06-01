package Sort;

/**
 * 快速排序
 * 1、选择一个元素为基准，通常是中间，大的移到右边，小的移到左边
 * 2、对基准两边的集合继续上一步骤，直到剩下一个元素
 *
 *
 * 分治法
 *
 * 注意理解：分治法 + 挖坑填数
 *
 *
 */
public class QuickSort {
    /**
     * 1. 采用递归
     */
    public static void quicksort(int[] nums,int left,int right) {
        if (left > right) {
            return;
        }
        int temp=partition(nums,left,right);
        quicksort(nums, left, temp - 1);
        quicksort(nums, temp + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int value = nums[left];//分割值
        while (left < right) {
            while (left < right && nums[right] >= value) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= value) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = value;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4, -3};
        SortUtil.printNums(nums);
        quicksort(nums,0,nums.length-1);
        SortUtil.printNums(nums);
    }
}
