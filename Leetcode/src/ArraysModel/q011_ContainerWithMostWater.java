package ArraysModel;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.
 */
public class q011_ContainerWithMostWater {
    /**
     * 暴力穷举
     * @param height
     * @return
     */
    public static int maxArea_1(int[] height) {
        int maxArea=0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int area = area(height, i, j);
                maxArea = maxArea > area ? maxArea : area;
            }
        }
        return maxArea;
    }

    public static int area(int[] height, int x, int y) {
        int h = height[x] > height[y] ? height[x] : height[y];
        int area= (x - y)<0?(y-x):x-y;
        return area * h;
    }

    /**
     * 从两端开始向中间走，以高度大的值作为高
     * @param height
     * @return
     */
    public static int maxArea_2(int[] height) {
        int maxArea=0;

        int p=0;
        int q=height.length-1;
        while (p < q) {
            int x = height[p];
            int y = height[q];
            int area = area(height, p, q);
            maxArea = Math.max(maxArea, area);
            if (x > y) {
                y++;
            }else {
                x++;
            }
        }
        return maxArea;
    }
}
