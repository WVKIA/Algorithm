package graph;

import java.io.File;
import java.io.IOException;

/**
 * @author wukai
 * @date 2019/4/23
 */
public class DepthFirstSearch {

    boolean[] marked;
    int count;

    //参数为图G，和源点s
    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    //深度遍历
    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (Object o : G.adj[v]) {
            if (!marked[(int) o]) {
                dfs(G, (Integer) o);
            }
        }
    }

    //返回w是否连接
    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(new File("").getAbsolutePath()+"/DataStruct/src/graph/graph.txt");
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 1);
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " 是否连通 " + 1 + " : " + depthFirstSearch.marked(i));
        }
        for (int i = 0; i < depthFirstSearch.marked.length; i++) {
            System.out.println("" + i + " : " + depthFirstSearch.marked[i]);
        }
    }
}
