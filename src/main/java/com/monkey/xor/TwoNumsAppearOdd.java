package com.monkey.xor;

/**
 * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，找到这两种数
 *
 * @author tao
 * @date 2021/7/12 5:32 下午
 */
public class TwoNumsAppearOdd {

    public static int[] twoNumsAppearOdd(int[] arr) {

        // 一个数组中有两种数出现了奇数次
        // 把所有的数都异或起来

        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }

        // 这里的 eor 是 俩数的异或

        // 提取 eor的最右侧的1
        int rightOne = eor & (-eor);

        int eor1 = 0;
        for (int i : arr) {
            if ((i & rightOne) == rightOne) {
                eor1 ^= i;
            }
        }

        return new int[] {eor1, eor1 ^ eor};
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2,2,3,4,5,5,6,6,3,3};

        int[] ans = twoNumsAppearOdd(arr);
        for (int num : ans) {
            System.out.println(num);
        }
    }
}
