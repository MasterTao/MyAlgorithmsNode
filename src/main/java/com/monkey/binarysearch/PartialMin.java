package com.monkey.binarysearch;

/**
 * TODO 这个要看一下原code
 * 局部最小值问题
 *
 * @author tao
 * @date 2021/7/12 1:46 下午
 */
public class PartialMin {

    public static int partialMin(int[] arr) {

        if (arr == null || arr.length < 2) {
            return -1;
        }

        int N = arr.length - 1;

        // 判断 头和尾
        if (arr[0] < arr[1]) {
            return 0;
        }

        if (arr[N] < arr[N - 1]) {
            return N;
        }

        return 0;
    }



}
