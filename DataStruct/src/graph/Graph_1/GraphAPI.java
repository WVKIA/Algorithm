package graph.Graph_1;

public interface GraphAPI {
    enum GraphType {
        directed,//有向图
        undirected  //无向图
    }
    int V();//顶点数

    int E();//边数

    int degree(int v);
    int maxDegree();

    void dfs(int v);
    void bfs(int v);
    boolean isAdjacent(int v1,int v2);

    Iterable<Integer> adj(int v);//和v相邻的所有顶点

    String toString();//打印图
}
