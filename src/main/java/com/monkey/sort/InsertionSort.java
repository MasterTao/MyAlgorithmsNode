package com.monkey.sort;

/**
 * 插入排序
 *
 * @author tao
 * @date 2021/7/8 10:32 上午
 */
public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        // 0..0 排序
        // 0..1 排序
        // 0..2 排序
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1] ;j--) {
                swap(arr, j, j+1);
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
        int[] res = insertionSort(arr);
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
    }
}
