package list.test.linkedlist;

import list.IList;
import list.linklist.ISinglyLinkedList;

/**
 * @author wukai
 * @date 2019/1/16
 */
public class ISingleLikedListTest {
    public static void main(String[] args) {
        IList<String> list = new ISinglyLinkedList<>();

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
