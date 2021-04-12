package com.monkey.dp;

/**
 * 编辑距离问题
 *
 * @author tao
 * @date 2021/4/12 4:26 下午
 */
public class Code02_MinDistance {
    // 将word1 通过 最少的步数 转化成 word2
    public static int minDistance(String word1, String word2) {
        // dp[i][j] 0..i 花的最小的步数 转化成 0..j
        if (word1.length() == 0) {
            return word2.length();
        }

        if (word2.length() == 0) {
            return word1.length();
        }

        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        int N1 = str1.length;
        int N2 = str2.length;

        int[][] dp = new int[N1][N2];

        dp[0][0] = str1[0] == str2[0] ? 0 : 1;

        // 第一列
        for (int i = 1; i < N1; i++) {
            dp[i][0] = str1[i] == str2[0] ? i : (dp[i - 1][0] + 1);
        }

        // 第一行
        for (int i = 1; i < N2; i++) {
            dp[0][i] = str1[0] == str2[i] ? i : (dp[0][i - 1] + 1);
        }

        // 填每一个格子
        for (int row = 1; row < N1; row++) {
            for (int col = 1; col < N2; col++) {
                if (str1[row] == str2[col]) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]) + 1;
                }
            }
        }
        return dp[N1 - 1][N2 - 1];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
        System.out.println(minDistance("horse", "ros"));
        System.out.println(minDistance("ab", "bc"));
    }

}
