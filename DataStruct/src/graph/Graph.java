package graph;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author wukai
 * @date 2019/4/23
 */
class Bag<T> implements Iterable{
    private NodeT head;

    private class NodeT{
        T value;
        NodeT next;
    }
    public Bag() {
        this.head = new NodeT();
    }

    public void add(T value) {
        NodeT nodeT = new NodeT();
        nodeT.value = value;
        NodeT last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = nodeT;
    }

    @Override
    public Iterator iterator() {
        return new NodeIterator();
    }
    private class NodeIterator implements Iterator<T>{
        private NodeT current = head.next;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            NodeT n = current;
            current = current.next;
            return n.value;
        }
    }
}
public class Graph {
    private final int V;//顶点数目

    private int E;  //边的数目

    public Bag<Integer>[] adj;//邻接表

    public Graph(int v) {
        this.V = v;
        this.E = 0;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Graph(String inname) throws IOException {
        this(Integer.valueOf(new BufferedReader(new FileReader(inname)).readLine()));
        BufferedReader reader = new BufferedReader(new FileReader(inname));
        reader.readLine();
        int E = Integer.valueOf(reader.readLine());
        for (int i = 0; i < E; i++) {
            //添加一条边
            String[] line=reader.readLine().split(",");
            int v = Integer.valueOf(line[0]);
            for (int j = 1; j < line.length; j++) {
                int w = Integer.valueOf(line[j]);
                addEdge(v, w);
            }
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

}
