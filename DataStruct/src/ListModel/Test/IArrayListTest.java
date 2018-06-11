package ListModel.Test;

import ListModel.IArrayList;
import ListModel.IList;

import java.util.Iterator;

public class IArrayListTest {
    public static void main(String[] args) {
        IList<String> stringIList = new IArrayList<>();
        for (int i = 0; i < 10; i++) {
            stringIList.add(i + "");
        }

        //测试iterator
        Iterator<String> iterator = stringIList.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }

        //
        System.out.println(stringIList.contains("" + 1) == true);

        System.out.println(stringIList.get(1).equals("1"));

        System.out.println(stringIList.isEmpty() == false);

    }
}
