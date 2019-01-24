package queue;

/**
 * @author wukai
 * @date 2019/1/22
 */
public class QueueTest {
    public static void main(String[] args) {
        IQueue<String> arrayQueue = new FixedSizeArrayQueue<>();
        test(arrayQueue);
        System.out.println("=========");
        IQueue<String> linkedQueue = new ILinkedQueue<>();
        test(linkedQueue);
    }

    public static void test(IQueue<String> queue) {
        int size=FixedSizeArrayQueue.maxSize-1;

        for (int i = 0; i < size; i++) {
            queue.enqueue(i + "");
        }
        System.out.println("队列空 : "+queue.isEmpty());
        for (int i = 0; i < size; i++) {
            System.out.println(queue.dequeue());
        }
        System.out.println("队列空 : "+queue.isEmpty());
    }
}
