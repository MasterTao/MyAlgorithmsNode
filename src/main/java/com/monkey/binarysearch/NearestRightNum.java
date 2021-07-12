package com.monkey.binarysearch;

import java.util.Arrays;

/**
 * 在一个有序数组中，找<=某个数最右侧的位置
 *
 * @author tao
 * @date 2021/7/12 10:56 上午
 */
public class NearestRightNum {
    // 1,2,4,5,6
    // 3
    // <= 3 最右侧的数 => 2
    // >= 3 最左侧的数 => 4

    public static int nearestRightNum(int[] arr, int target) {
        int ans = -1;
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int L = 0;
        int R = arr.length - 1;

        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] <= target) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }

    public static int[] generateRandomArray(int size, int maxValue) {

        int randomSize = (int) (Math.random() * size) + 1;
        int[] arr = new int[randomSize];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * maxValue + 1) - (int) (Math.random() * maxValue);
        }

        Arrays.sort(arr);
        return arr;
    }

    public static int nearestRightNumV2(int[] arr, int target) {
        int ans = -1;
        if (arr == null || arr.length == 0) {
            return ans;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target) {
                ans = i;
            } else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int tryTimes = 100000;
        int size = 1000;
        int maxValue = 10000;

        System.out.println("测试开始");
        for (int i = 0; i < tryTimes; i++) {
            // 生成随机数组
            int[] arr = generateRandomArray(size, maxValue);
            int target = (int) (Math.random() * maxValue + 1) - (int) (Math.random() * maxValue);
            int ans1 = nearestRightNum(arr, target);
            int ans2 = nearestRightNumV2(arr, target);
            if (ans1 != ans2) {
                System.out.println("测试失败");
            }
        }
        System.out.println("测试结束");

    }
}
