package ArraysAl;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * @author wukai
 * @date 2019/5/10
 */
public class q034_FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 涉及logn，二分法
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int start=0,end=nums.length-1;

        while (start <= end) {
            int middle=(start+end+1)/2;

            //如果找到了对应值，就到前后找
            if (nums[middle] == target) {
                if (nums[start] == target && nums[end] == target) {
                    return new int[]{start,end};
                } else if (nums[start] < target) {
                    start++;
                } else if (nums[end] > target) {
                    end++;
                }

            }else if (nums[middle] < target) {
                start = middle+1;
            }else if (nums[middle] > target) {
                end = middle-1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int nums[] = new int[]{5,7,7,8,8,10};
        int target = 8;
        for (int i : searchRange(nums,target)) {
            System.out.println(i);
        }
    }
}
