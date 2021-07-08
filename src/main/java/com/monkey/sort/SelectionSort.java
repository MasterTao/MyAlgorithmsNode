package com.monkey.sort;

/**
 * 选择排序
 *
 * @author tao
 * @date 2021/7/8 9:47 上午
 */
public class SelectionSort {

    public static int[] selectionSort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return arr;
        }

        // 选择排序的流程
        // 0..N-1 范围上 找到最小的数，和0位置上的数交换
        // 1..N-1 范围上 找到最小的数，和1位置上的数交换
        // 2..N-1 范围上 找到最小的数，和2位置上的数交换

        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // TODO 要尝试写对数器


    public static void main(String[] args) {
        int[] arr = new int[] {9,6,1,-1,3,4,3,6,5,7,8,4,2};
        int[] res = selectionSort(arr);
        for (int re : res) {
            System.out.print(re + " ");
        }
        System.out.println();
    }

}
