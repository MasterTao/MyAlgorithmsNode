package com.monkey.xor;

/**
 * 不适用额外变量，交换两个数
 *
 * @author tao
 * @date 2021/7/12 4:53 下午
 */
public class SwapWithoutVariable {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
    }


}
