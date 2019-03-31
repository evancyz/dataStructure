/**
 * Created by evan on 2019/3/30.
 * 数组的插入、删除、按照下标随机访问操作
 *
 * 不考虑扩容
 */
public class SimpleArray {

    private int a[];

    //数组长度
    private int n;

    //实际个数
    private int count;



    public SimpleArray(int capacity) {
        a = new int[capacity];
       n = capacity;
        count = 0;
    }


    public boolean insert(int index, int value) {

        if (n == count) {
            System.out.println("满了");
            return false;
        }

        if (index > count) {
            System.out.println("位置不合法");
            return false;
        }

        //把该index后面的所有的数往后面移动
        for (int i = count; i > index; i--) {
            a[i] = a[i - 1];
        }

        a[index] = value;

        count++;

        return true;
    }

    public int find(int index) {

        if (index < 0 || index >= count) {
            System.out.println("位置不合法");
            return -1;
        }
        return a[index];
    }

    public boolean delete(int index) {

        if (index < 0 || index >= count) {
            System.out.println("不合法");
            return false;
        }

        //删除把所有的值往前移动一会

        for (int i = index;i < count;i++) {
            a[index] = a[index + 1];
        }

        count--;
        return true;


    }

    public void printAll() {
        for (int i = 0;i< count;i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        SimpleArray simpleArray = new SimpleArray(10);

        simpleArray.insert(0, 2);
        simpleArray.insert(0, 4);

        simpleArray.insert(1, 2);

        simpleArray.insert(2, 4);

        simpleArray.printAll();

        System.out.println("===========");
        simpleArray.delete(2);

        simpleArray.printAll();


    }









}
