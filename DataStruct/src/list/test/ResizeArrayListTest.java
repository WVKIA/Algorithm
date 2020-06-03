package list.test;

import list.IList;
import list.IArrayList;

/**
 * @author wukai
 * @date 2019/1/10
 */
public class ResizeArrayListTest {
    public static void main(String[] args) {
        IList<String> iList = new IArrayList<>();
        for (int i = 0; i < 5; i++) {
            iList.add(i + "");
        }
        System.out.println(iList.get(3));
        System.out.println(iList.size() == 5);

        iList.remove(2);
        System.out.println(iList.get(2));
        System.out.println(iList.size() == 4);

        iList.clear();
        System.out.println(iList.get(2));
        System.out.println(iList.size() == 0);
    }
}
