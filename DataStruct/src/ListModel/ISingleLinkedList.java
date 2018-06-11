package ListModel;

import javax.xml.soap.Node;
import java.util.Iterator;

/**
 * 带有头节点的单链表
 * @param <E>
 */
public class ISingleLinkedList<E>  implements IList<E> {

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
        if (o == null) {
            return false;
        }
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
        return false;
    }

    @Override
    public boolean remove(Object e) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    @Override
    public E remove(int index) {
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

    @Override
    public boolean insert(int index, E e) {
        return false;
    }
}
