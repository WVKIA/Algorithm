package ArraysModel;

import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class q001_TwoSum {

    /**
     * 暴力穷举法
     * 循环两次nums，然后得到相加数为target的下标，同时限制下标不能一致
     * 时间复杂度为O(n^2)
     * @param arrs
     * @param target
     * @return
     */
    public static int[] solution_1(int[] arrs, int target) {
        if (arrs == null || arrs.length == 0) {
            return null;
        }
        int[] result = new int[2];
        for (int i = 0; i < arrs.length; i++) {
            int a = arrs[i];
            for (int j = 0; j < arrs.length; j++) {
                if (i != j) {
                    if (a + arrs[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 先看时间复杂度 O(n)
     * 对解法进行分析
     * 1. 首先将数组的值作为key，下标作为value放到map里，注意如果有重复的value值，那就是最后的为value，因为题目标志有一个唯一解，所以这个没关系，不可能出现两个位置都是目标结果的
     * 2. 循环数组，判断targget-num[i]是否在map里，如果在，取出下标就是我们需要的，但还要注意取的下标不能和我们循环的下标一致，
     * 即map.get(target-num[i]) != i，就是防止如果target为8，其中有个4，我们拿到了4的下标又循环了数组，得出4+4=8下标取出来都是一样 的
     *
     * @param arrs
     * @param target
     * @return
     */
    public int[] solution_2(int[] arrs, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrs.length; i++) {
            map.put(arrs[i], i);
        }
        for (int i = 0; i < arrs.length; i++) {
            int other = target - arrs[i];
            if (map.containsKey(other) && map.get(other) != i) {
                return new int[]{i,map.get(other)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 将解法2两个循环合并成一个
     * @param arrs
     * @param target
     * @return
     */
    public int[] solution_3(int[] arrs, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrs.length; i++) {
            if (map.containsKey(target - arrs[i])) {
                return new int[]{i,map.get(target-arrs[i])};
            }
            map.put(arrs[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution_1(nums, target);
        System.out.println(result.length == 2);
        System.out.println(result[0] == 0);
        System.out.println(result[1] == 1);

    }
}
