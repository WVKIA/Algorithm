package ListModel;

import javax.xml.soap.Node;
import java.util.Iterator;

/**
 * 带有头节点的单链表
 * @param <E>
 */
public class ISingleLinkedList<E>  extends IAbstractList<E> {

    private SinglePointNode<E> head;    //头节点

    public ISingleLinkedList() {
        this.head = new SinglePointNode<>();
    }

   //获取元素个数
    @Override
    public int size() {
        int size = 0;
        SinglePointNode<E> first = head.next;   //获取第一个节点
        while (first != null) {
            size++;
            first = first.next; //移到后继节点
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        checkObject(o);
        SinglePointNode<E> first = head.next;   //获取第一个节点
        while (first != null) {
            if (first.data.equals(o)) {
                return true;
            }
            first = first.next;
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }

    @Override
    public boolean add(E e) {
        checkObject(e);
        SinglePointNode<E> first = head;
        while (first.next != null) {
            first = first.next;
        }
        first.next = new SinglePointNode<>(e, null);
        return true;
    }

    @Override
    public boolean remove(Object e) {
        checkObject(e);

        SinglePointNode<E> prePoint = head;
        SinglePointNode<E> point = head.next;
        while (point != null) {
            if (point.data.equals(e)) {
                prePoint.next = point.next;
                point.next = null;
                break;
            }
            prePoint = point;
            point = point.next;
        }
        return true;
    }

    @Override
    //删除单链表所有元素，回收机制会自动回收到GC Root不可达的节点
    public void clear() {
        this.head.next = null;
    }

    @Override
    public E get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        SinglePointNode<E> point = head.next;

        for (int i = 0; i < index && point != null; i++) {  //指针移动到index位置
            point = point.next;
        }
        if (point != null) {
            return point.data;  //指向第index个节点的数据
        }
        return null;
    }

    @Override
    public E set(int index, E e) {
        checkObject(e);
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        SinglePointNode<E> point = head.next;
        for (int i = 0; i < index && point != null; i++) {
            point = point.next;
        }
        E value = null;
        if (point != null) {    //设置指定位置值并且返回原值
            value = point.data;
            point.data = e;
        }
        return value;
    }

    @Override
    public E remove(int index) {
        E value = get(index);
        remove(value);
        return value;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public boolean insert(int index, E e) {
        return false;
    }
}
