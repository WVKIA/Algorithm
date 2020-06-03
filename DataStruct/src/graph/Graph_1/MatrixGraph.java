package graph.Graph_1;

import java.io.*;

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
                this.matrix[i][j] = 0;//0表示没有路径
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
            if (matrix[v][i] != 0) {
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

    }

    @Override
    public void bfs(int v) {

    }

    @Override
    public boolean isAdjacent(int v1, int v2) {
        return matrix[v1][v2] != 0;
    }


    @Override
    public Iterable<Integer> adj(int v) {
        return null;
    }
}
