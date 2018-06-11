package ListModel;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 基于数组实现的list
 * @param <E>
 */
public class IArrayList<E> implements IList<E> {
    private Object[] data;  //数据存储数组
    private int size;       //元素个数

    public IArrayList() {
        this.data = new Object[1];  //默认初始一个元素的数组
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >0;
    }

    @Override
    public Iterator<E> iterator() { //返回迭代器
        return new Iterator<E>() {
            private int index=0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                E value = (E) data[index];
                index++;
                return value;
            }
        };
    }

    @Override
    public boolean add(E e) {
        checkObject(e);
        ensoureCapacity();  //添加前进行扩容检测
        this.data[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object e) {
        checkObject(e);
        boolean bool = false;
        if (contains(e)) {
            int index = indexOf(e);
            remove(index);
            bool = true;
        }
        return bool;
    }

    @Override
    public void clear() {
        this.data = new Object[0];
        this.size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) this.data[index];
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index);
        E da = (E) this.data[index];
        this.data[index] = e;
        return da;
    }

    @Override
    public boolean insert(int index, E e) {
        checkIndex(index);
        checkObject(e);
        ensoureCapacity();  //插入前进行扩容检测

        //将指定位置后的数据向后移动一位
        for (int i = size-1; i >= index; i--) {
            this.data[i + 1] = this.data[i];
        }
        this.data[index] = e;
        this.size++;

        return false;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E value = (E) this.data[index];
        //将指定位置后的数据向前移动一位，覆盖index位的数据
        for (int i = index; i < size;i++ ) {
            this.data[i] = this.data[i+1];
        }
        this.size--;
        return value;
    }

    @Override
    public int indexOf(Object o) {
        checkObject(o);
        int index=-1;
        for (int i = 0; i < data.length; i++) {
            if (o.equals(data[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        checkObject(o);
        int index=-1;
        for (int i = data.length - 1; i >= 0; i--) {
            if (o.equals(data[i])) {
                index=i;
                break;
            }
        }
        return index;
    }

    private void checkObject(Object o) {
        if (o == null) {
            throw new NullPointerException("元素为null");
        }
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * 检查是否需要扩容，如果需要则扩容原先的2倍
     *
     */
    private void ensoureCapacity() {
        if (data.length <= size + 1) {
            Object[] temp = Arrays.copyOf(this.data, this.data.length);
            this.data = new Object[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                this.data[i] = temp[i];
            }
        }
    }
}
