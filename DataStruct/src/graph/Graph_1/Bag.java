package graph.Graph_1;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
        private Node first;  // 链表的首节点
        private class Node{
            // 定义了节点的嵌套类
            Item item;
            Node next;
        }
        public void add(Item item){
            // 和Stack的push() 方法完全相同
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
        }
        public boolean isEmpty(){
            return first == null;  // 或：N == 0
        }

        @Override
        public Iterator<Item> iterator() {
            return new ListIterator();
        }
        private class ListIterator implements Iterator<Item>{

            private Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }

            @Override
            public void remove() { }
        }
}
