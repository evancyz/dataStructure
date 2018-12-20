/**
 * Created by evan on 2018/12/20.
 *
 * 实现数组的添加,删除,按照下标随机访问
 */
public class SimpleArray<E> {

    Object[] container;

    int offset;

    public static <E> SimpleArray<E> newArray() {
        // initialize
        return new SimpleArray<>();
    }

    public SimpleArray() {
        container = new Object[10];
    }

    public boolean add(E e) {
        enableCapacityAndResize();
        container[offset++] = e;
        return true;
    }

    public void remove(int index) {
        if (index > offset - 1) {
            throw new IndexOutOfBoundsException("actual size " + offset);
        }

        Object[] tmp = new Object[container.length - 1];

        for (int i = 0; i < container.length; i++) {
            if (i < index) {
                tmp[i] = container[i];
            } else if (i > index) {
                tmp[i - 1] = container[i];
            }
        }
        offset--;
        container = tmp;
    }

    public  E get(int index) {
        if (index > offset - 1) {
            throw new IndexOutOfBoundsException("actual data size " + offset);
        }

        return (E) container[index];
    }

    private void enableCapacityAndResize() {

        //满了扩容
        if (offset >= container.length) {
            resize();
        }
    }

    private void resize() {
        Object[] tmp = new Object[container.length * 2];

        for (int i = 0; i < container.length ; i++) {
            tmp[i] = container[i];
        }
        container = tmp;
    }

    @Override public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < offset - 1; i++) {
            builder.append(container[i]).append(",");
        }
        builder.append(container[offset- 1]);
        return builder.toString();
    }

    public static void main(String[] args) {
        SimpleArray<Integer> array = SimpleArray.newArray();

        for (int i = 0;i < 100 ;i++) {
            //add
            array.add(i);
        }

        //delete
        array.remove(50);
        array.remove(48);

        //toString
        System.out.println(array.toString());

        //get
        System.out.println(array.get(97));

    }
}
