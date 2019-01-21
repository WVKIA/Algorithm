package stack;

/**
 * @author wukai
 * @date 2019/1/21
 */
public class StackTest {
    public static void main(String[] args) {
        //测试resizeArrayStack数组实现

        IStack<String> stack = new ResizeArrayStack<>();
        test(stack);

        System.out.println("========");
        stack = new ILinkedStack<>();
        test(stack);


    }

    public static void test(IStack<String> stack) {
        for (int i = 0; i < 5; i++) {
            stack.push(i + "");
        }
        boolean isTrue = stack.peek().equals("4");

        System.out.println(isTrue);
        System.out.println(stack.isEmpty());
        isTrue = stack.pop().equals("4");
        System.out.println(isTrue);

        for (int i = 0; i < 4; i++) {
            System.out.println(stack.pop());
        }

        System.out.println(stack.isEmpty());
    }
}
