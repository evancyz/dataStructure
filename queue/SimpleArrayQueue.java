/**
 * Created by evan on 2019/4/7.
 *
 * 基于数组实现先进先出的队列,
 * 实现为循环数组,入队出队只改变指针位置,不进行数据搬移
 */
public class SimpleArrayQueue {

    int[] data;

    int offset;

    int headIndex;

    int length;

    int validSpace;

    public SimpleArrayQueue(int capacity) {
        data = new int[capacity];
        offset = 0;
        headIndex = 0;
        length = capacity;
        validSpace = capacity;
    }

    //入队
    public void enqueue(int value) {

        if (validSpace == 0) {
            System.out.println("队列满了");
            return;
        }

        if (offset == length) {
            offset = 0;
        }

        data[offset] = value;
        validSpace--;
        System.out.println("入队成功" + value + ",剩余空间:" + validSpace);
        offset++;
    }

    //出队
    public void dequeue() {

        if (validSpace == length) {
            System.out.println("队列为空");
            return;
        }

        if (headIndex == length) {
            headIndex = 0;
        }

        int res = data[headIndex];
        validSpace++;
        System.out.println("出队成功" + res + ",剩余空间:" + validSpace);
        headIndex++;
    }


    public static void main(String[] args) {

        SimpleArrayQueue queue = new SimpleArrayQueue(4);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();


    }


}
