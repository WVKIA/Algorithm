package list;

/**
 * @author wukai
 * 由动态数组实现的表
 *
 */
public class ResizeArrayList<T> implements IList<T>{

    //存储数据的数组
    private Object [] datas;
    //数组中元素的个数
    private int size;

    public ResizeArrayList() {
        //默认个数16
        this.datas = new Object[4];
        this.size = 0;
    }


    /**
     * 表元素是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    /**
     * 是否包含元素
     * @param data
     * @return
     */
    @Override
    public boolean contains(Object data) {
        //尽量复用方法
        return find(data) != -1;
    }

    /**
     * 清空表
     */
    @Override
    public void clear() {

        //元素位置置空
        for (int i = 0; i < size; i++) {
            datas[i] = null;
        }
        this.size = 0;
    }

    /**
     * 获取表中元素个数
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 在数组最后位加入元素
     * @param data
     */
    @Override
    public void add(T data) {
        if (null == data) {
            throw new IllegalArgumentException("参数为null");
        }
        if (datas.length <= size + 1) {
            resize();
        }
        datas[size++] = data;

    }

    /**
     * 设置第i元素为data，如果i指定序号无效，则抛序号越界异常
     * @param i
     * @param data
     */
    @Override
    public void set(int i, T data) {
        if (null == data) {
            throw new IllegalArgumentException("参数为null");
        }
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "");
        }
        datas[i] = data;
    }

    /**
     * 删除指定位置元素，如果i序号无效，抛除序号越界异常
     * @param i
     * @return
     */
    @Override
    public T remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "");
        }
        T record = (T) datas[i];

        //i位置后所有的元素向前一位移动
        for (int index = i; index < size-1; ) {
            datas[index] = datas[++index];
        }

        this.size--;


        return record;
    }

    /**
     * 获取第i位置的元素，如果i序号无效，抛除序号越界异常
     * @param i
     * @return
     */
    @Override
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(i + "");
        }
        return (T) datas[i];
    }

    /**
     * 找到元素data在表中的第一个位置
     * @param data
     * @return
     */
    @Override
    public int find(Object data) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (datas[i].equals(data)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 对数组进行扩容，扩充为 2 * size
     */
    private void resize() {
        Object[] objs = new Object[size * 2];
        for (int i = 0; i < size; i++) {
            objs[i] = datas[i];
        }
        this.datas = objs;
    }
}
