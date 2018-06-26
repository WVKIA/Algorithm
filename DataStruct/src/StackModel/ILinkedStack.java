package StackModel;

import java.util.EmptyStackException;

/**
 * 单链表实现的栈
 */
public class ILinkedStack<T> implements IStack<T> {
    private INode<T> head;

    public ILinkedStack() {
        this.head = new INode<>(null, null);
    }

    @Override
    public T push(T item) {
        INode<T> data = new INode<>(item, null);
        INode<T> point = head.next;     //插入到head后，作为第一个节点
        head.next = data;
        data.next = point;
        return item;
    }

    @Override
    public T pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        INode<T> point = head.next; //取到第一个节点，获取值并弹出
        head.next = point.next;
        T data = point.data;
        point = null;
        return data;
    }

    @Override
    public T peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        INode<T> point = head.next; //获取第一个节点值value
        T data = point.data;
        return data;
    }

    @Override
    public boolean empty() {
        return head.next == null;
    }

    static class INode<T>{
         T data;
         INode<T> next;

        public INode(T data, INode<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
