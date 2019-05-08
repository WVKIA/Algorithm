package ArraysAl;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须原地修改，只允许使用额外常数空间。

 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */

/**
 * 首先解释字典序
 * 什么是字典序？
 对于数字1、2、3......n的排列，不同排列的先后关系是从左到右逐个比较对应的数字的先后来决定的。
 例如对于5个数字的排列 12354和12345，排列12345在前，排列12354在后。按照这样的规定，5个数字的所有的排列中最前面的是12345，最后面的是 54321。
 */
public class q031_NextPermutation {
    /**
     * 就是需要确保右边的数字左边的数字大于右边的，如果全都大于则找出最小序
     * 而且从右到左的顺序
     * @param nums
     */
    public static void nextPermutation(int[] nums) {

        for (int i = nums.length-1, left = nums.length-2; i >= 0 && left >=0; i--,left--) {
            if (nums[i] > nums[left]) {
                swapNums(nums, i, left);
                return;
            }
        }
        //如果走到这里说明左边的全部大于右边，倒转数组
        revserNums(nums);
    }

    //倒转数组
    private static void revserNums(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right) {
            swapNums(nums,left,right);
            left++;
            right--;
        }

    }

    //交换值
    private static void swapNums(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        for (int i = 0; i < 5; i++) {
            nextPermutation(nums);
            for (int num : nums) {
                System.out.print(num+",");
            }
            System.out.println();
        }
    }
}
