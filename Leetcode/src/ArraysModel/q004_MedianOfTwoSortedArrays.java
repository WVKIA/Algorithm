package ArraysModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */
public class q004_MedianOfTwoSortedArrays {
    /**
     * 暂时不考虑时间复杂度O(log(m+n))的限制，首先想办法解决问题
     * 问题是取得两个数组的中位数，第一个考虑的办法是两个数组合并，然后取得中位数
     *
     * 第一种，暴力排序，浪费两个数组已经排序的优势
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>(nums1.length + nums2.length);
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            list.add(i);
        }
        Collections.sort(list);
        int middel = list.size() / 2;
        double d=0.0;
        if (list.size() % 2 == 0) {
            //注意易错点 除以 2.0,否则转型导致结果错误
            d=(list.get(middel)+list.get(middel-1))/2.0;
        }else {
            d = list.get(middel);
        }
        return d;
    }


    /**
     * 同样不关心时间复杂度，利用已经排序的条件进行组合成一个数组
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("Arrays is error");
        }
        int count = nums1.length + nums2.length;
        int[] countarr = new int[count];
        int index1 = 0;
        int index2 = 0;
        int indexcount=0;
        double d = 0.0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                countarr[indexcount++] = nums1[index1++];
            }else {
                countarr[indexcount++] = nums2[index2++];
            }
        }

        //如果有一方数组用完
        while (index1 < nums1.length) {
            countarr[indexcount++] = nums1[index1++];
        }
        while (index2 < nums2.length) {
            countarr[indexcount++] = nums2[index2++];
        }

        int middel=count/2;
        if (count % 2 == 0) {
            d = (countarr[middel] + countarr[middel - 1]) / 2.0;
        }else {
            d = countarr[middel];
        }
        return d;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays_2(nums1,nums2));

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays_2(nums1,nums2));
    }


}
