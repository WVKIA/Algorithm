package QueueModel;

/**
 * 循环数组实现队列
 * 通过舍弃一个节点位置作为代价，否则无法判断队空和队满
 * <p>
 * [head tail] -- [] -- [] -- []   //初始队列
 * <p>
 * [head value] --[value] --[val] --[tail]     //添加元素，tail指向的位置不放置元素
 * <p>
 * [val] -- [tail] --[head val] -- [val]       //删除并添加元素 ，可知 当 tail+1 % len == head 队列满
 * 当 head == tail 队列空
 * [] -- [head-tail] -- [] -- []
 *
 * @param <T>
 */
public class IArrayQueue<T> implements IQueue<T> {
    static int maxSize = 16;//数组大小,因为需要留出一个节点作为队满判断，所以最多可存储 maxSize - 1 个元素
    private Object[] items; //存储数据数组
    private int head;       //队首节点
    private int tail;       //队尾节点

    public IArrayQueue() {
        this(maxSize);
    }

    public IArrayQueue(int size) {
        this.items = new Object[size];
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public boolean offer(T data) {
        //首先判断队满
        if (full()) {
            throw new RuntimeException("队列满");
        }
        this.items[tail] = data;
        tail = (tail + 1) % items.length;   //判断尾节点位置，如果到数组尾部则，回到0位置
        return true;
    }

    @Override
    public T poll() {
        //首先判断队空
        if (empty()) {
            throw new RuntimeException("队列空");
        }
        T data = (T) this.items[head];
        head = (head + 1) % items.length;   //判断头节点位置，如果到数组尾部则，回到0位置
        return data;
    }

    @Override
    public T peek() {
        if (empty()) {
            throw new RuntimeException("队列空");
        }
        return (T) this.items[head];
    }

    @Override
    public boolean empty() {
        return head == tail;    //如果头节点和尾节点相同，说明空
    }

    private boolean full() {
        return (tail + 1) % items.length == head;   //如果尾节点向后一位和头节点相同，说明满
    }
}
