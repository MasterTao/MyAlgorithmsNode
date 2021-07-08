package com.monkey.sort;

/**
 * 冒泡排序
 *
 * @author tao
 * @date 2021/7/8 10:02 上午
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        // 0..N-1 两两比较，大的放后面
        // 0..N-2 两两比较，大的放后面
        // 0..N-3 两两比较，大的放后面
        int N = arr.length;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9,6,1,-1,3,4,3,6,5,7,8,4,2};
        int[] res = bubbleSort(arr);
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
    }
}
