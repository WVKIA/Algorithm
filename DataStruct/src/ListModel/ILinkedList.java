package ListModel;

import java.util.Iterator;

/**
 * 双向链表
 */
class IDoublePointNode<T> {
    T data; //数据域
    IDoublePointNode<T> pre;    //前驱节点
    IDoublePointNode<T> next;   //后继节点

    public IDoublePointNode(T data, IDoublePointNode<T> pre, IDoublePointNode<T> next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    public IDoublePointNode() {
        this(null, null, null);
    }
}

/**
 * 带有头节点的双向链表实现
 *
 * @param <T>
 */
public class ILinkedList<T> extends IAbstractList<T> {
    private IDoublePointNode<T> head;

    public ILinkedList() {
        head = new IDoublePointNode<>();
    }

    @Override
    public int size() {
        int count = 0;
        IDoublePointNode<T> point = head;
        while (point.next != null) {
            count++;
            point = point.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next ==null;
    }

    @Override
    public boolean contains(Object o) {
        IDoublePointNode<T> point = head.next;
        while (point != null) {
            if (point.data == o || point.data.equals(o)) {
                return true;
            }
            point = point.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean add(T t) {
        checkObject(t);
        IDoublePointNode<T> point = head;
        while (point.next != null) {
            point = point.next; //获取最后一个节点
        }
        IDoublePointNode<T> data = new IDoublePointNode<>(t, null, null);
        point.next = data;
        data.pre = point;
        return true;
    }

    @Override
    public boolean remove(Object e) {
        checkObject(e);
        if (!contains(e)) {
            throw new IllegalArgumentException("数据不存在");
        }
        IDoublePointNode<T> point = head.next;
        while (point != null && !point.data.equals(e)) {
            point = point.next; //找到对应的节点
        }
        point.pre.next = point.next;    //移除前驱和后继指向
        point.next.pre = point.pre;
        point.pre = point.next = null;
        return true;
    }

    @Override
    public void clear() {
        this.head.next = null;  //移除head后全部后继节点
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("参数错误");
        }
        IDoublePointNode<T> point = head.next;
        for (int i = 0; i < index; i++) {

        }
        return null;
    }

    @Override
    public T set(int index, T t) {
        return null;
    }

    @Override
    public boolean insert(int index, T t) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
}
