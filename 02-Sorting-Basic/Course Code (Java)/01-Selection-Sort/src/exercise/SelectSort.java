/**
 * ***************************************************************************
 * 工程：IntelliJ IDEA v1.0
 * All Rights Reserved.
 * <p>       类
 *
 * @author chenweizhao
 * 创建日期：2019/7/23 8:34
 * 版 本 号： 1.0
 * <p>
 * ****************************************************************************
 */
package exercise;

public class SelectSort {

    /**
     * 从小到大大排序
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    minindex = j;
                }
            }
            int temp = arr[i];
            arr[i] =arr[minindex];
            arr[minindex] = temp;

        }
    }

    public static void selectSort1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int j1 = arr[j];
                    arr[j] = arr[i];
                    arr[i] = j1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        //int[] arr = {1,2,3,4,5,6,7,8,9,10};
        selectSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }
}
