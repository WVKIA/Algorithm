package graph.Graph_1;

import java.util.Stack;

/**
 * 使用深度优先算法找出图中的路径
 */
public class DepthFirstPaths {
    private boolean[] marked;//这个顶点是否调用了dfs()
    private int[] edgeTo;//起点到顶点的路径最后一个顶点
    private final int s;//起始顶点

    public DepthFirstPaths(GraphAPI G,int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(GraphAPI G, int v) {
        marked[v] = true;
        //遍历v的所有邻接顶点
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }


}
