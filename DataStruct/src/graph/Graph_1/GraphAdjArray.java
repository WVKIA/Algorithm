package graph.Graph_1;

public class GraphAdjArray implements GraphAPI {
    private int V;
    private int E;
    private Bag<Integer>[] adj;//邻接表

    public GraphAdjArray(int v) {
        this.V = v;
        this.E = 0;
        adj = new Bag[v];
        for (int i = 0; i < V; i++) {
            adj[v] = new Bag<>();
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
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
