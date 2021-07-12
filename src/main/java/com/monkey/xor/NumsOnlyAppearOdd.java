package com.monkey.xor;

/**
 * 一个数组中一种树出现了奇数次，其他数都出现了偶数次，怎么找出并打印这种数
 *
 * @author tao
 * @date 2021/7/12 4:57 下午
 */
public class NumsOnlyAppearOdd {

    public static int numsOnlyAppearOdd(int[] arr) {
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        return eor;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3,1,1,2,2,4,4};
        System.out.println(numsOnlyAppearOdd(arr));
    }
}
