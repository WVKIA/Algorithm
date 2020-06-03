package graph.Graph_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 图的邻接表实现
 */
class Node{
    int vertex;//边节点
    int weight;//权重

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
public class AdjGraph implements GraphAPI {

    private int V;
    private int E;

    private ArrayList<ArrayList<Node>> adj;//邻接表
    private GraphAPI.GraphType type;

    public AdjGraph(GraphType type) {
        this.type = type;
    }

    public AdjGraph(File file) throws IOException {
        this.type = GraphType.undirected;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int v = Integer.valueOf(bufferedReader.readLine());
        int e = Integer.valueOf(bufferedReader.readLine());
        init(v,e);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] tmep = line.split(" ");

            //说明v到w有一条边
            int v1 = Integer.valueOf(tmep[0]);
            int v2 = Integer.valueOf(tmep[1]);

            int weight=Integer.valueOf(tmep[2]);

            this.adj.get(v1).add(new Node(v2, weight));

            //如果是无向图，则两边都需要加这条边，也就是v到w有一条边，w到v肯定也有一条边
            if (type == GraphType.undirected) {
                this.adj.get(v2).add(new Node(v1, weight));
            }
        }
    }

    private void init(int v, int e) {
        this.V=v;
        this.E=e;
        this.adj = new ArrayList<>(v);//v个节点
        for (int i = 0; i < v; i++) {
            ArrayList<Node> line = new ArrayList<>();//每个节点对应的链表
            this.adj.add(line);
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

    @Override
    public int degree(int v) {
        return adj.get(v).size();
    }

    @Override
    public int maxDegree() {
        int max=0;
        for (int i = 0; i < V(); i++) {
            if (max < adj.get(i).size()) {
                max = adj.get(i).size();
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
        ArrayList<Node> arrayList = adj.get(v1);
        for (Node node : arrayList) {
            if (node.vertex == v2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return null;
    }
}
