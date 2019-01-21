package stack;

import list.ISinglyNode;

/**
 * @author wukai
 * @date 2019/1/21
 * 单链表构成的栈
 * 有两种方式构成
 *
 * 1。
 * head.next -> one.next -> two.next -> three
 * 这样每次push或pop都是最后一个节点，所以每次都需要遍历到最后
 *
 * 2。
 * 采用倒序指向，也就是
 *
 * (1)  head.next ->null
 *
 * (2)  head.next-> one
 *
 * (3)  head.next->two
 *      two.next     -> one
 * (4)
 *  head.next->three
 *
 *  three.next-> two.next -> one
 *
 *
 * 我们这次采用第二种方式
 */
public class ILinkedStack<T> implements IStack<T>{

    /**
     * 头指针，也是栈顶指针
     */
    private ISinglyNode<T> head;

    public ILinkedStack() {
        this.head = new ISinglyNode<>();
    }

    @Override
    public boolean isEmpty() {
        return head.next == null;
    }

    @Override
    public void push(T data) {
        ISinglyNode<T> ele = new ISinglyNode<>(data, null);
        ele.next = head.next;
        head.next = ele;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException("栈空");
        }
        T data = head.next.data;
        ISinglyNode<T> current = head.next;
        head.next = current.next;
        current = null;
        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("栈空");
        }
        ISinglyNode<T> current = head.next;
        return current.data;
    }
}
