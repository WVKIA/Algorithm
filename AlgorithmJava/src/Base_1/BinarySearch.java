package Base_1;

import java.util.Arrays;

/**
 * @author wukai
 * @date 2019/1/6
 * 二分查询
 */
public class BinarySearch {
    public static int rank(int key, int a[]) {
        //数组必须有序
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == key) {
                return mid;
            }
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6};
        Arrays.sort(list);
        int key = rank(2, list);
        System.out.println("index = " + key);
    }
}
