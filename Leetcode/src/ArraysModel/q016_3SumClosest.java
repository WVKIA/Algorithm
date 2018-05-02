package ArraysModel;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class q016_3SumClosest {

    /**
     * 类似于3sum，首先利用穷举
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest_1(int[] nums, int target) {
        int temp = 0;//记录最近的值
        int n = Integer.MAX_VALUE;//记录和target的差值,首先设置差值为integer最大值，然后逐渐缩小
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    //如果差值小于 n，则记录差值、接近值
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < n) {
                        n = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        temp = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return temp;
    }
}
