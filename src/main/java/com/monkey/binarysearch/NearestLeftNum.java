package com.monkey.binarysearch;

import java.util.Arrays;

/**
 * 在一个有序数组中，找>=某个数最左侧的位置
 *
 * @author tao
 * @date 2021/7/8 5:34 下午
 */
public class NearestLeftNum {

    public static int findNearestLeftNum(int[] arr, int target) {
        int ans = -1;
        if (arr == null || arr.length == 0) {
            return ans;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= target) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    // 写对数器
    // 1. 随机生成一个数组
    // 2. 排序
    // 3. 遍历，找到 >= 某个数最左侧的位置
    // 4. 比较

    public static int[] generateRandomArray(int size, int maxValue) {

        int randomSize = ((int) (Math.random() * size)) + 1;
        int[] arr = new int[randomSize];
        for (int i = 0; i < randomSize; i++) {
            arr[i] = (int)(Math.random() * maxValue + 1) - (int) (Math.random() * maxValue);
        }
        Arrays.sort(arr);
        return arr;
    }

    public static int findNearestLeftNumV1(int[] arr, int target) {
        int ans = -1;
        if (arr == null || arr.length == 0) {
            return ans;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        // 测试次数
        int testTimes = 100000;

        // 数组长度
        int size = 10;
        // 数组大小
        int maxValue = 10000;

        System.out.println("测试开始");
        for (int i = 0; i < testTimes; i++) {

            // 生成随机数组
            int[] arr = generateRandomArray(size, maxValue);

            // 生成随机数
            int target = (int)(Math.random() * maxValue + 1) - (int) (Math.random() * maxValue);
            int ans1 = findNearestLeftNum(arr, target);
            int ans2 = findNearestLeftNumV1(arr, target);
            if (ans1 != ans2) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                System.out.println(target);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("测试失败");
                break;
            }

        }
        System.out.println("测试结束");

    }

}
