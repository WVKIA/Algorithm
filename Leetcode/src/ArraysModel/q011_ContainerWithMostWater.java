package ArraysModel;

/**
 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，
 使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 注意：你不能倾斜容器，n 至少是2。

 y轴
 |
 |     o
 |     |   o
 | o   |   |
 | |   |   |   o
 | |   |   |   |
 -------------------------------x轴-----每个下标和对应的数都是一个点，找到其中的两个点，形成的面积盛水最多，
                                            注意这里有个陷阱，不是面积最大，而是盛水最多，计算面积大小时盛水最多应该是
                                            短板的高度 * 长度差值，如果是面积最大应该是 （上底+下底）* 高 / 2；
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
