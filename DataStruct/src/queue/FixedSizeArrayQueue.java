package queue;

/**
 * @author wukai
 * @date 2019/1/22
 * 使用固定数组实现队列，和使用数组实现栈不一样
 * 实现队列的话，会涉及到队列满的情况
 * 循环数组实现队列
 *  * 通过舍弃一个节点位置作为代价，否则无法判断队空和队满
 *  * <p>
 *  * [head tail] -- [] -- [] -- []   //初始队列
 *  * <p>
 *  * [head value] --[value] --[val] --[tail]     //添加元素，tail指向的位置不放置元素
 *  * <p>
 *  * [val] -- [tail] --[head val] -- [val]       //删除并添加元素 ，可知 当 tail+1 % len == head 队列满
 *  * 当 head == tail 队列空
 *  * [] -- [head-tail] -- [] -- []
 *  *
 *
 */
public class FixedSizeArrayQueue<T>  implements IQueue<T>{
    //数组大小，因为需要留出一个位置作为队满判断，所以最多存储 maxSize-1
    public static int maxSize = 16;
    /**
     * 存储数据
     */
    private Object[] elems;
    /**
     * 头指针和尾指针
     */
    private int rear, head = 0;

    public FixedSizeArrayQueue() {
        this.elems = new Object[maxSize];
    }
    @Override
    public boolean isEmpty() {
        return rear==head;
    }

    //入队从尾部，出队出头部
    @Override
    public void enqueue(T data) {
        if (full()) {
            throw new IllegalArgumentException("队列满");
        }
        if (null == data) {
            throw new IllegalArgumentException("参数空");
        }
        this.elems[rear] = data;

        //获取rear节点位置，之所以不直接加1，是为了避免当rear已经到达数组最后一格，但数组前面因为出队空出位置，
        //不能合理利用，所以采用加一取模的方式，是rear重头部开始
        rear = (rear + 1) % elems.length;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列空");
        }
        T data = (T) this.elems[head];
        head = (head + 1) % elems.length;
        return data;
    }

    public boolean full() {
        boolean full = (rear + 1) % elems.length == head;
        return full;
    }
}
