package QueueModel;

public class QueueTest {
    public static void main(String[] args) {
        testQueue(new IArrayQueue<>());
    }

    private static void testQueue(IQueue<String> queue) {
        System.out.println("queue is empty : " + queue.empty());

        //测试添加数据
        for (int i = 0; i < 10; i++) {
            queue.offer(String.valueOf(i));
            System.out.println("queue add  " + i);
        }
        System.out.println("queue is empty : " + queue.empty());

        //测试弹出数据
        printQueue(queue);
        System.out.println("queue is empty : " + queue.empty());

        //测试插入和删除不同步一致
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        queue.poll();
        queue.poll();
        queue.offer("4");
        printQueue(queue);

    }

    private static void printQueue(IQueue<String> queue) {
        while (!queue.empty()) {
            String data = queue.poll();
            System.out.println(data);
        }
    }
}
