package Sort;

/**
 * 分治法的典型
 *先拆开，然后合并，最后结果合并
 * 类似map reduce
 *
 * 先将分开，然后排序之后，再重新合并
 */
public class MergeSort {

    public static void resv(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        //采用二路排序，也就是拆成两组，也可以多路排序，拆成多组

        int middle=(left+right) /2;
        sort(nums, left, middle);
        sort(nums, middle + 1, right);
        merge(nums,left,middle,right);
    }

    //进行合并操作，拆到最后就剩下nums[left] .. nums[mid] .. nusm[right]
    //并且左边已经排好序，后边的也已经排好序
    private static void merge(int[] nums, int left, int mid, int right) {
        //辅助数组
        //用来将两边的数到数组中重新排序
        int[] temp = new int[right - left + 1];

        int i = left;
        int j=mid+1;
        int k=0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
        //处理较长的部分
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        //用tmep覆盖nums的元素
        for (int l = 0; l < temp.length; l++) {
            nums[l + left] = temp[l];
        }
    }


    public static void loop(int[] nums) {

    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4, -3};
        SortUtil.printNums(nums);
        resv(nums);
        SortUtil.printNums(nums);
    }
}
