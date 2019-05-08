package ArraysAl;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class q015_3Sum {

    /**
     * 最简单，暴力穷举
     * 1、首先通过排序
     * 2、首先固定住第一个数，计算出和目标值的差值 tarnum-num[i]=subsum，然后遍历后续的数组查看是否有相加和等于 subsum
     * 3、遍历的同时采用向后移一位的方法，防止重复数据的产生，也防止下标一样的数据使用多次
     * 4、采用Set集合防止重复
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum_1(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums == null) {
            return new ArrayList<>(set);
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int twosum = 0 - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[j] + nums[k] == twosum) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }



    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum_1(nums);
        for (List<Integer> integerList : list) {
            for (Integer integer : integerList) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }
}
