package graph.Graph_1;

import java.io.*;

public class GraphAdjArray implements GraphAPI {
    private int V;
    private int E;
    private Bag<Integer>[] adj;//邻接表

    public GraphAdjArray(int v) {
        init(v);
    }

    private void init(int v) {
        this.V = v;
        this.E = 0;
        adj = new Bag[v];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public GraphAdjArray(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int v = Integer.valueOf(bufferedReader.readLine());
        init(v);
        int e = Integer.valueOf(bufferedReader.readLine());
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] tmep = line.split(" ");
            int tempv = Integer.valueOf(tmep[0]);
            int tempw = Integer.valueOf(tmep[1]);
            //添加一条边
            addEdge(tempv, tempw);
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
