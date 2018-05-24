package Sort;

import static Sort.SortUtil.*;

/**
 * 选择排序
 * 每次找到最小值，然后插入到前面
 */
public class SelectSort {
    public static void selectsort(int[] nums) {
        if (nums == null) {
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int temp=i;
            for (int j = i+1; j < len; j++) {
                if (nums[temp] < nums[j]) {
                    temp = j;
                }
            }
            swap(nums, i, temp);
        }
    }



    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 2, 5, 9, 4, 5, 2};
        printNums(nums);
        selectsort(nums);
        printNums(nums);
    }
}
