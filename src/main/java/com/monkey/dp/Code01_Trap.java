package com.monkey.dp;

/**
 * 蓄水池算法，接雨水
 * @author tao
 * @date 2021/4/12 4:06 下午
 */
public class Code01_Trap {

    public static int trap(int[] height) {

        if (height == null || height.length <= 2) {
            return 0;
        }

        int ans = 0;

        // 每一根柱子，左侧最大和右侧最大的
        int N = height.length;
        int[] rightMax = new int[N];
        for (int i = N - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int leftMax = height[0];
        for (int i = 1; i < N - 1; i++) {
            ans += Math.max(Math.min(leftMax, rightMax[i]) - height[i], 0);
            leftMax = Math.max(leftMax, height[i]);
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
