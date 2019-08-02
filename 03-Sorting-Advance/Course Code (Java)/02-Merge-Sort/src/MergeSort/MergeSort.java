package MergeSort;

import java.util.Arrays;

public class MergeSort {
    // 我们的算法类不允许产生任何实例
    private MergeSort() {
    }


    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并， 时间复杂度O（n log n）
     * 前闭后闭，中间位置：第一个已经排好序的数组的后面的位置
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        //auxiliary辅助空间
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        //遍历，决定每一次arr[k]的位置是谁
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            }
            // 左半部分所指元素 < 右半部分所指元素，
            // aux是新开辟的空间，索引是从0开始的，而i、j的初始化并不是从0开始，而是从l开始
            // 所以需要减去便宜l，即i-l,j-l 保证空间的正确性
            else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }


    // 测试MergeSort
    public static void main(String[] args) {
        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 500000);
        SortTestHelper.testSort("MergeSort.MergeSort", arr);

        return;
    }
}