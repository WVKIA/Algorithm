package graph.Graph_1;

import java.io.File;
import java.io.IOException;

public class GraphSearchTest {

    private static String fileName = "/Users/wukai/wukaiWorkSpace/Algorithm/DataStruct/src/graph/Graph_1/tinyG.txt";


    public static void main(String[] args) throws IOException {
        testPath();

    }
    public static void testPath() throws IOException {
        GraphAPI G = new GraphAdjArray(new File(fileName));
        int s = 0;
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(G, s);
        for (int i = 0; i < G.V(); i++) {
            System.out.println(s + " to " + i + " : ");
            if (depthFirstPaths.hasPathTo(i)) {
                for (Integer x : depthFirstPaths.pathTo(i)) {
                    if (x == s) {
                        System.out.print(x);

                    }else {
                        System.out.print("-" + x);
                    }
                }
            }
            System.out.println();

        }
        System.out.println();

    }

    /**
     * 测试搜索
     * @throws IOException
     */
    public static void testSearch() throws IOException {
        GraphAPI G = new GraphAdjArray(new File(fileName));
        int s = 0;
        GraphSearchAPI searchAPI = new DepthFirstSearch(G, s);

        for (int v = 0; v < G.V(); v++) {
            //如果v和s 相连
            if (searchAPI.marked(v)) {
                System.out.println(v + " ");
            }
        }
        System.out.println();

        //是否s和其他点都全部连通
        if (searchAPI.count() != G.V()) {
            System.out.println("Not ");

        }
        System.out.println("Connected");
    }
}
