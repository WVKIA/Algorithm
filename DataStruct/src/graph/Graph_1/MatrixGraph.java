package graph.Graph_1;

import java.io.*;
import java.util.*;

/**
 * 数据格式
 * 7
 * 7
 * 0 1
 * 0 2
 * 0 5
 * 0 6
 * 4 3
 * 5 3
 * 6 4
 */
public class MatrixGraph implements GraphAPI {
    private static int INFINITY=-1;//表示两个不相邻的点的权重


    private int V;//节点数量
    private int E;//边的数量

    private GraphAPI.GraphType type;

    private int[][] matrix;//临街矩阵，用下标来代替一个节点

    public MatrixGraph(GraphType type) {
        this.type = type;
    }

    public MatrixGraph(File file) throws IOException {
        this.type = GraphType.undirected;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int v = Integer.valueOf(bufferedReader.readLine());
        int e = Integer.valueOf(bufferedReader.readLine());
        init(v,e);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] tmep = line.split(" ");

            //说明v到w有一条边
            int tempv = Integer.valueOf(tmep[0]);
            int tempw = Integer.valueOf(tmep[1]);

            int weight= Integer.valueOf(tmep[3]);
            this.matrix[tempv][tempw]=weight;

            //如果是无向图，则两边都需要加这条边，也就是v到w有一条边，w到v肯定也有一条边
            if (type == GraphType.undirected) {
                this.matrix[tempw][tempv]=weight;
            }
        }
    }

    private void init(int V, int E) {
        this.V=V;
        this.E=E;
        this.matrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                this.matrix[i][j] = INFINITY;//0表示没有路径
            }
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    //查看一个节点的度，也就是有多少条边
    @Override
    public int degree(int v) {
        int count=0;
        for (int i = 0; i < this.V(); i++) {
            if (matrix[v][i] != INFINITY) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int maxDegree() {
        int max = 0;
        for (int i = 0; i < this.V(); i++) {
            int degree = degree(i);
            if (max < degree) {
                max = degree;
            }
        }
        return max;
    }

    @Override
    public void dfs(int v) {
        boolean[] mark = new boolean[V];
        dfsMethod(v, mark);
    }

    //顶点，mark是否已经访问过
    private void dfsMethod(int v, boolean[] mark) {
        mark[v] = true;//v顶点已经访问
        //然后找v的深度遍历
        for (int i = 0; i < this.V; i++) {
            //如果v和i相邻，并且没有被访问过，就标注，并且递归i
            if (isAdjacent(v, i) && !mark[i]) {
                mark[i] = true;
                dfsMethod(i, mark);
                System.out.println(i + " ");
            }
        }
    }

    @Override
    public void bfs(int v) {
        boolean[] visited = new boolean[this.V()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int d = queue.remove();
            for (int i = 0;i < this.V();i++) {
                if (this.isAdjacent(v,i) && !visited[i]) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.add(i);
                }
            }
        }
    }

    @Override
    public boolean isAdjacent(int v1, int v2) {
        return matrix[v1][v2] != INFINITY;
    }


    @Override
    public Iterable<Integer> adj(int v) {
        return null;
    }
    public float weight(int v1, int v2) {
        return matrix[v1][v2];
    }
    public float shortestPath(int s, int t) {
        if (this.type != GraphType.directed) {
            return -1;
        }
        Set<Integer> s2 = new HashSet<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(s);
        float[] dist = new float[this.V()];
        for (int i = 0; i < this.V(); i++) {
            if (i != s) {
                s2.add(i);
                if (this.isAdjacent(s,i)) {
                    dist[i] = weight(s,i);
                } else {
                    dist[i] = INFINITY;
                }
            } else {
                dist[i] = 0;
            }
        }
        while (s2.size() > 0) {
            float min = INFINITY;
            int k = -1;
            for (int i = 0; i < dist.length; i++) {
                if (dist[i] != INFINITY && s2.contains(i)) {
                    if (min > dist[i]) {
                        min = dist[i];
                        k = i;
                    }
                }
            }
            for (int i = 0; i < dist.length; i++) {
                if (this.isAdjacent(s,k) && this.isAdjacent(k,i)) {
                    if (dist[i] > weight(s,k) + weight(k,i)) {
                        dist[i] = weight(s,k) + weight(k,i);
                        if (i == t) {
                            path.add(k);
                        }
                    }
                }
            }
            s2.remove(k);
        }
        path.add(t);

        return dist[t];
    }

}
