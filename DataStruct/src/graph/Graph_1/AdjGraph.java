package graph.Graph_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    private static int INFINITY=-1;//表示两个不相邻的点的权重
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
        boolean[] mark = new boolean[V];
        dfsMethod(v, mark);
    }
    private void dfsMethod(int v, boolean[] mark) {
        mark[v] = true;
        ArrayList<Node> vList = adj.get(v);
        for (Node node : vList) {
            if (!mark[node.vertex]) {//如果v的邻接表链表没有访问过
                System.out.println(node.vertex + " ");
                dfsMethod(node.vertex, mark);
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
            ArrayList<Node> vList = adj.get(d);
            for (Node node : vList) {
                if (!visited[node.vertex]) {//如果没有访问过
                    visited[node.vertex] = true;
                    System.out.println(node.vertex+" ");
                    queue.add(node.vertex);
                }
            }
        }
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



    public int shortestPath(int s, int t) {
        if (this.type != GraphType.directed) {
            return -1;
        }
        Set<Integer> s2 = new HashSet<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(s);
        int[] dist = new int[this.V()];
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

    //获取权重
    public int weight(int v1, int v2) {
        for (Node node : adj.get(v1)) {
            if (node.vertex == v2) {
                return node.weight;
            }
        }
        return INFINITY;
    }
}
