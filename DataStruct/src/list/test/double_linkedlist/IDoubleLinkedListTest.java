package list.test.double_linkedlist;

import list.IList;
import list.double_linklist.IDoubleLinkedList;

/**
 * @author wukai
 * @date 2019/1/16
 */
public class IDoubleLinkedListTest {
    public static void main(String[] args) {
        IList<String> list = new IDoubleLinkedList<>();

        for (int i = 0; i < 6; i++) {
            list.add(i + "");
            System.out.print(i+" ");
        }

        System.out.println("==");
        System.out.println(list.get(3));
        System.out.println(list.size());

        String third = list.remove(3);
        System.out.println(third);
        System.out.println(list.get(3));



    }
}
