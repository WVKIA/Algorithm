package hashtable;


/**
 * @author wukai
 * @date 2019/1/26
 */
public class SeparateChainingHashST<Key, Value> {
    //存储对象的链表数组
    public SequentialSearchST<Key, Value>[] st;
    public int M; //散列表的大小


    public SeparateChainingHashST() {
        this(100);

    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    private int hash(Key key) {
        //采用取模算法
        return (key.hashCode() & 0x7fffffff) % M;
    }
}
