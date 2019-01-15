package Sort;

/**
 * 排序工具类
 */
public class SortUtil {
    public static void printNums(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " == > ");
        }
        System.out.println();
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
