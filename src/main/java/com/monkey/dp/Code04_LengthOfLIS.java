package com.monkey.dp;

/**
 * 最长递增子序列
 * @author tao
 * @date 2021/4/15 4:21 下午
 */
public class Code04_LengthOfLIS {

    public static int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        // 需要一个ends数组
        int N = nums.length;
        int[] ends = new int[N];
        for (int i = 0; i < N; i++) {
            ends[i] = Integer.MAX_VALUE;
        }

        ends[0] = nums[0];

        int index = 0;
        for (int i = 1; i < N; i++) {

            // <= ends[index]的最右的位置
            int position = find(ends, 0, index, nums[i]);
            ends[position] = Math.min(ends[position], nums[i]);
            index = Math.max(position, index);
        }
        return index + 1;
    }

    public static int find(int[] arr, int L, int R, int target) {
        if (L >= R) {
            return arr[L] >= target ? L : L + 1;
        }
        int mid = L + ((R - L) >> 1);
        if (arr[mid] > target) {
            return find(arr, L, mid - 1, target);
        } else if (arr[mid] < target) {
            return find(arr,mid + 1, R, target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums)); // 4

        nums = new int[] {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums)); // 4

        nums = new int[] {7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS(nums)); // 1
    }
}
