package queue;

import list.ISinglyNode;

/**
 * @author wukai
 * 单链表实现队列
 *
 * 使用单链表实现队列
 * 单链表本身天然很适合处理栈或队列
 *
 * enqueue();
 *
 * head.next -> null
 *
 * head.next -> one
 *
 * head.next -> one.next -> two
 *
 * dequeue();
 *
 * head.next -> two
 *
 * 对应的入队和出队也就是对应着单链表的插入到链表尾部和删除第一个节点
 */
public class ILinkedQueue<T> implements IQueue<T> {
    /**
     * 单链表头指针
     */
    private ISinglyNode<T> head;

    public ILinkedQueue() {
        this.head = new ISinglyNode<>();
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public void enqueue(T data) {
        ISinglyNode<T> ele = new ISinglyNode<>(data, null);
        ISinglyNode<T> current = head;

        //获取末尾节点
        while (current.next != null) {
            current = current.next;
        }

        current.next = ele;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列空");
        }
        ISinglyNode<T> current = head.next;
        head = head.next;
        return current.data;
    }
}
