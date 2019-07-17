package graph.Graph_1;

/**
 * 深度优先搜索算法
 */
public class DepthFirstSearch implements GraphSearchAPI {

    private boolean[] marked;//统计已经被搜索过的，也就是相连通的顶点
    private int count; //统计和s连通的顶点总数

    public DepthFirstSearch(GraphAPI G, int s) {
        //s和其他所有顶点的记录
        marked = new boolean[G.V()];
        //深度优先搜索s
        dfs(G, s);
    }

    //深度搜索v的相邻节点
    private void dfs(GraphAPI G, int v) {
        marked[v] = true;
        count++;
        //遍历v的相邻节点，然后继续搜索w
        for (Integer w : G.adj(v)) {
            //如果已经搜索过了就不搜索了
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }


    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }
}
