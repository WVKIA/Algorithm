package StackModel;

public class StackTest {
    public static void main(String[] args) {
        test(new IFixedArrayStack<>());
        System.out.println("===============");
        test(new ILinkedStack<>());

    }

    private static void test(IStack<String> stack) {

        System.out.println("stack is empty " + stack.empty());
        for (int i = 0; i < 10; i++) {
            stack.push(String.valueOf(i));
        }
        System.out.println("stack is empty " + stack.empty());

        while (!stack.empty()) {
            String val = stack.pop();
            System.out.println(val);
        }
        System.out.println("stack is empty " + stack.empty());

    }

}
