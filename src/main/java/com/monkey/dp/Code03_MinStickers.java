package com.monkey.dp;

import java.util.HashMap;

/**
 * 贴纸拼词
 * @author tao
 * @date 2021/4/12 5:34 下午
 */
public class Code03_MinStickers {

    public static int minStickers1(String[] stickers, String target) {

        if (target == null || target.length() == 0) {
            return 0;
        }

        int n = stickers.length;

        int[][] map = new int[n][26];
        for (int i = 0; i < n; i++) {
            char[] str = stickers[i].toCharArray();
            for (char c : str) {
                map[i][c - 'a']++;
            }
        }

        HashMap<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        int ans = process1(dp, map, target);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int process1(HashMap<String, Integer> dp, int[][] map, String rest) {

        if (dp.containsKey(rest)) {
            return dp.get(rest);
        }

        int[] target = new int[26];
        char[] str = rest.toCharArray();
        for (char c : str) {
            target[c - 'a']++;
        }

        // 尝试每一张贴纸
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {

            int[] sticker = map[i];
            // 枚举第一张贴纸
            if (sticker[str[0] - 'a'] > 0) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (target[j] > 0) {
                        int nums = target[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            builder.append((char) (j + 'a'));
                        }
                    }
                }
                String tmp = builder.toString();
                min = Math.min(min, process1(dp, map, tmp));
            }
        }
        int ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(rest, ans);
        return ans;
    }


    public static void main(String[] args) {
        String[] stickers = {"with", "example", "science"};
        System.out.println(minStickers1(stickers, "thehat"));
    }
}
