package list.double_linklist;

import list.IDoubleNode;

/**
 * @author wukai
 * @date 2019/1/15
 * 双链表实现
 */
public class IDoubleLinkedList<T> implements IDoubleList<T> {
    /**
     * 使用一个头指针
     */
    private IDoubleNode<T> head;//只是一个哨兵节点，并没有实际存储数据


    public IDoubleLinkedList() {
        this.head = new IDoubleNode<>();
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public boolean contains(T data) {
        return find(data) != -1;
    }

    @Override
    public void clear() {
        head.next = null;
    }

    @Override
    public int size() {
        int size = 0;
        IDoubleNode<T> current = head;
        while (null != current.next) {
            size++;
            current = current.next;
        }
        return size;
    }

    @Override
    public void add(T data) {
        if (null == data) {
            throw new IllegalArgumentException("参数为null");
        }
        IDoubleNode<T> current = head;
        while (null != current.next) {
            current = current.next;
        }
        IDoubleNode<T> node = new IDoubleNode<>(data, null, null);

        //设置指针指向
        current.next = node;
        node.pre = current;
    }

    @Override
    public void set(int i, T data) {
        if (i < 0 || i >=size()) {
            throw new IndexOutOfBoundsException(i + "");
        }
        IDoubleNode<T> current = head;
        for (; i >= 0; i--) {
            current = current.next;
        }
        current.data = data;
    }

    @Override
    public T remove(int i) {
        if (i < 0 || i >=size()) {
            throw new IndexOutOfBoundsException(i + "");
        }
        IDoubleNode<T> current = head;
        for (; i >= 0; i--) {
            current = current.next;
        }

        //如果移除的节点是最后一个，特殊处理
        if (current.next == null) {
            current.pre.next = null;//最后一个节点前置节点的next指向null
            current.pre = null;//最后一个节点pre指向null
        }else {
            current.pre.next = current.next;
            current.next.pre = current.pre;

        }

        return current.data;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >=size()) {
            throw new IndexOutOfBoundsException(i + "");
        }
        IDoubleNode<T> current = head;
        for (; i >= 0; i--) {
            current = current.next;
        }

        return current.data;
    }

    @Override
    public int find(T data) {
        if (null == data) {
            throw new IllegalArgumentException("参数为null");
        }
        int index = 0;
        IDoubleNode<T> current = head.next;
        while (null != current) {
            if (current.data.equals(data)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }
}
