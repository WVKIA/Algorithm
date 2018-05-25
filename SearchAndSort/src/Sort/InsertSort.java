package Sort;

/**
 * 插入排序
 * 首先认为第一个已经排序，然后从剩下的未排序的拿出元素，从已经排序的元素中从后向前扫描，插入到对应的位置
 */
public class InsertSort {
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            for (; j >0 &&temp < nums[j-1] ; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums={2,1,2,5,3,4,1,7,9,34};
        SortUtil.printNums(nums);
        insertSort(nums);
        SortUtil.printNums(nums);
    }

}
