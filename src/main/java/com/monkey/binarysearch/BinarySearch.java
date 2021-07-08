package com.monkey.binarysearch;

/**
 * 二分查找
 *
 * @author tao
 * @date 2021/7/8 3:53 下午
 */
public class BinarySearch {

    public static boolean binarySearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int L = 0;
        int R = arr.length - 1;

        while (L < R) {

            int mid = L + ((R - L) >> 1);
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2,3,4,5,6,7,8,9,11};
        System.out.println(binarySearch(arr, 10));
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, -1));
        System.out.println(binarySearch(arr, 12));
    }
}
