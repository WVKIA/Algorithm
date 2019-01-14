package list.linklist;

import list.IList;

/**
 * @author wukai
 * 含有头指针的单链表实现
 */
public class ISinglyLinkedList<T> implements IList<T> {

    /**
     * 头指针
     */
    public ISinglyNode<T> head;

    /**
     * 元素个数计数
     */
    private int size;

    public ISinglyLinkedList() {
        this.head = new ISinglyNode<>();
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T data) {
        return find(data) != -1;
    }

    @Override
    public void clear() {
        //节点全部断开
        ISinglyNode current = head;
        while (null != current) {
            ISinglyNode temp = current.next;
            current.next = null;
            current = temp;
        }
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 在链表末节点加入数据
     * @param data
     */
    @Override
    public void add(T data) {
        if (null == data) {
            throw new IllegalArgumentException("参数为null");
        }
        ISinglyNode current = head;

        //移动指针到链表末节点
        while (null != current.next) {
            current = current.next;
        }
        ISinglyNode record = new ISinglyNode(data, null);
        current.next = record;
    }

    @Override
    public void set(int i, T data) {
        if (null == data) {
            throw new IllegalArgumentException("参数为null");
        }
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "");
        }

        ISinglyNode current = head.next;
        int j = 0;

        while (i != j && current != null) {
            j++;
            current = current.next;
        }
        current.data = data;
    }

    @Override
    public T remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "");
        }
        ISinglyNode current = head.next;
        ISinglyNode pre = head;

        while (i != 0 && null != current) {
            i--;
            pre=current;
            current = current.next;
        }
        pre.next = null;
        T temp = (T) current.data;
        current = null;

        return temp;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "");
        }
        ISinglyNode current = head.next;

        while (i != 0 && current != null) {
            i--;
            current = current.next;
        }
        return (T) current.data;
    }

    @Override
    public int find(T data) {
        if (null == data) {
            throw new IllegalArgumentException("参数为null");
        }
        int i=0;
        ISinglyNode current = head.next;
        
        return 0;
    }
}
