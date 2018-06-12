package ListModel;

public abstract class IAbstractList<E>  implements IList<E>{
    protected void checkObject(Object o) {
        if (o == null) {
            throw new NullPointerException("元素为null");
        }
    }
}
