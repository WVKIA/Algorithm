package hashtable;

/**
 * @author wukai
 * @date 2019/1/26
 * 符号表
 */
public class SequentialSearchST<Key, Value> {
    private SSTNode head;// 链表头节点

    private class SSTNode{
        Key key;
        Value value;
        SSTNode next;

        public SSTNode(Key key, Value value, SSTNode next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //给定键值，查找对应的value
    public Value get(Key key) {
        SSTNode x = head;
        while (x != null) {
            if (x.key.equals(key)) {
                return x.value;
            }
            x = x.next;
        }
        return null;
    }

    //查找给定键，找到就更新，否则就新建
    public void put(Key key, Value value) {
        SSTNode x = head;
        while (x != null) {
            if (x.key.equals(key)) {
                x.value = value;
                return;
            }
            x = x.next;
        }
        //如果没找到，则新建节点插入到头
        head = new SSTNode(key, value, head);
    }
}
