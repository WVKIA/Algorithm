package graph.Graph_1;


public class GraphImpl {


    /**
     * 计算v的度数，即v的边
     * @param G
     * @param v
     * @return
     */
    public static int degree(GraphAPI G, int v) {
        int degree = 0;
        //遍历v的所有顶点，即边数
        for (Integer integer : G.adj(v)) {
            degree++;
        }
        return degree;
    }


    /**
     * 计算所有顶点的最大度数
     * @param G
     * @return
     */
    public static int maxDegree(GraphAPI G) {
        int max = 0;
        //遍历所有顶点计算度数，找出最大的
        for (int v = 0; v < G.V(); v++) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }

    /**
     * 所有顶点平均度数
     * @param G
     * @return
     */
    public static double avgDegree(GraphAPI G) {
        return 2 * G.E() / G.V();
    }

    /**
     * 计算图中自环的个数
     * 就是 v-w也是w-v
     * @param G
     * @return
     */
    public static int numberOfSelfLoops(GraphAPI G) {
        int count = 0;
        for (int v = 0; v < G.V(); v++) {
            for (Integer w : G.adj(v)) {

                //如果v和w一样，说明
                if (v == w) {
                    count++;
                }
            }
        }
        return count / 2;//每个边都被记2次
    }


}

