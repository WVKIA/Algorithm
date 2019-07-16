package graph.Graph_1;

public interface GraphAPI {

    int V();//顶点数

    int E();//边数

    void addEdge(int v, int w);//添加v-w的边

    Iterable<Integer> adj(int v);//和v相邻的所有顶点

    String toString();//打印图
}
