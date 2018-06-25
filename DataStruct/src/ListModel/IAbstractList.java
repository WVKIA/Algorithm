package ListModel;

public abstract class IAbstractList<E>  implements IList<E>{
    protected void checkObject(Object o) {
        if (o == null) {
            throw new NullPointerException("元素为null");
        }
    }

    protected void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("参数错误");
        }
    }
}
