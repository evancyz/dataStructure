/**
 * Created by evan on 2019/4/21.
 *
 * 排序
 */
public class SimpleSort {

    //插入排序(O(n²))
    public static int[] insertionSort(int[] data) {

        if (data.length == 0) {
            return data;
        }

        int k;
        //第几趟
        for (int p = 1; p < data.length; p++) {

            int tmp = data[p];

            //这里说一下  当只有最后一个数 比 前一个数小的时候 才会进for循环,因为最上面的for循环表示了,p前面的数都是已经排序的
            //所以当给定一个已经排好序的数组时,往里面插一个的时间复杂度是 O(n)
            //寻找插入点
            for (k = p; k > 0 && tmp < data[k - 1]; k--) {
                    //把比他大的右移
                    data[k] = data[k - 1];
            }

            //找准位置插入
            data[k] = tmp;
        }
        printAll(data);
        return data;
    }

    //选择排序
    //未排序区间找到最小的值放到已排序区间的末尾
    public static int[] selectionSort(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {


            //找到最小的那个index
            int minIndex = i;

            for (int k = minIndex + 1; k < data.length; k++) {

                if (data[k] < data[minIndex]) {
                    minIndex = k;
                }
            }

            //当前的i和index交换
            int tmpValue = data[minIndex];

            data[minIndex] =  data[i];
            data[i] = tmpValue;
        }

        printAll(data);
        return data;

    }

    //冒泡排序
    public static int[] bubbleSort(int[] data) {

        boolean hasExchange = false;

        for (int i = 0 ; i < data.length ; i++) {

            //每一次至少把一个数排到最后面去,如果不发生交换,就说明排好了
            for (int k = 0; k < data.length - i - 1; k++) {

                if (data[k] > data[k + 1]) {

                    int tmp = data[k];

                    data[k] = data[k + 1];
                    data[k + 1] = tmp;
                    hasExchange = true;
                }
            }

            if (!hasExchange) {
                printAll(data);
                return data;
            }
        }
        printAll(data);
        return data;
    }


    public static void printAll(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+",");
        }
        System.out.println("");
    }

















    public static void main(String[] args) {

        insertionSort(new int[] {6, 1, 4, 8, 2, 3, 9});
        selectionSort(new int[] {6, 1, 4, 8, 2, 3, 9});
        bubbleSort(new int[] {6, 1, 4, 8, 2, 3, 9});


    }
}
