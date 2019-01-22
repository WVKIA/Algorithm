package stack;

/**
 * @author wukai
 * @date 2019/1/21
 */
public class StackTest {
    public static void main(String[] args) {
        //测试resizeArrayStack数组实现

        System.out.println("测试resizeArrayStack数组实现");
        IStack<String> stack = new ResizeArrayStack<>();
        test(stack);

        System.out.println("========");
        System.out.println("测试单链表数组实现");

        stack = new ILinkedStack<>();
        test(stack);


    }

    public static void test(IStack<String> stack) {
        int size=10;
        for (int i = 0; i < size; i++) {
            stack.push(i + "");
        }
        boolean isTrue = stack.peek().equals((size - 1) + "");

        System.out.println("栈顶元素是否为 "+(size-1)+" : "+isTrue);
        System.out.println("栈是否空 = "+stack.isEmpty());
        isTrue = stack.pop().equals((size-1)+"");
        System.out.println("栈顶元素弹出元素是否为"+ (size-1) +" :"+isTrue);

        for (int i = 0; i < size - 1; i++) {
            System.out.println("栈弹出元素 ： "+stack.pop());
        }

        System.out.println("栈是否为空 "+ stack.isEmpty());
    }
}
