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

        //第几趟
        for (int p = 1; p < data.length; p++) {

            //这里说一下  当只有最后一个数 比 前一个数小的时候 才会进for循环,因为最上面的for循环表示了,p前面的数都是已经排序的
            //所以当给定一个已经排好序的数组时,往里面插一个的时间复杂度是 O(n)
            for (int k = p; k > 0 && data[k - 1] > data[p]; k--) {
                    //交换
                    int tmp = data[k - 1];

                    data[k - 1] = data[p];
                    data[p] = tmp;
            }

        }
        printAll(data);
        return data;
    }

    //选择排序
    public static int[] selectionSort(int[] data) {

        return null;
    }


    public static void printAll(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+",");
        }
    }

















    public static void main(String[] args) {

        insertionSort(new int[] {6, 1, 4, 8, 2, 3, 9});


    }
}
